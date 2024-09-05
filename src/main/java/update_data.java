

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update_data
 */
@WebServlet("/update_data")
public class update_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String Bid = request.getParameter("Bid");
		String Bname = request.getParameter("Bname");
		String Bprice = request.getParameter("Bprice");
		String Bpages = request.getParameter("Bpages");
		String Aname = request.getParameter("Aname");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_clg","root","Deep@1904");
			PreparedStatement pst = con.prepareStatement("update Books set Book_Name=? , Book_Price=? , Book_Pages=? , Author_Name=? where Book_ID=?");
			
			pst.setString(1, Bname);
			pst.setString(2, Bprice);
			pst.setString(3, Bpages);
			pst.setString(4, Aname);
			pst.setString(5, Bid);
			
			pst.executeUpdate();
			
			String LinkUrl1 = "<a href='show_books'>SHOW ALL THE BOOKS</a>";
			out.println("<h2>Book Succesfully Updated...</h2>");
			out.println(LinkUrl1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
