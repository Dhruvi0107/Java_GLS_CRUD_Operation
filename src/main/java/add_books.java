

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
 * Servlet implementation class add_books
 */
@WebServlet("/add_books")
public class add_books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_books() {
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
		
		String Bname = request.getParameter("bname");
		String Bprice = request.getParameter("bprice");
		String Bpages = request.getParameter("bpages");
		String Aname = request.getParameter("aname");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_clg","root","Deep@1904");
			PreparedStatement pst = con.prepareStatement("insert into Books (Book_Name,Book_Price,Book_Pages,Author_Name) values (?,?,?,?);");

			pst.setString(1, Bname);
			pst.setString(2, Bprice);
			pst.setString(3, Bpages);
			pst.setString(4, Aname);
			
			pst.executeUpdate();
			
			String LinkUrl = "<a href='show_books'>Show All The Books</a>";
			
			out.println("<h3>Book Successfully Added...</h3>");
			out.println("You Are Show All The Books??"+LinkUrl+"<br>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
