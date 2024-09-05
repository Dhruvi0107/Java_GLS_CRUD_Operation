

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show_books
 */
@WebServlet("/show_books")
public class show_books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_books() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
			PreparedStatement pst = con.prepareStatement("select * from Books;");
			
			ResultSet rs = pst.executeQuery();
			
			out.println("<h2>Show All The Books</h2>");
			while(rs.next())
			{
				int Bid = rs.getInt(1);
				Bname = rs.getString(2);
				Bprice = rs.getString(3);
				Bpages = rs.getString(4);
				Aname = rs.getString(5);
				
				String LinkUrl = "details?Bid="+Bid+"&Bname="+Bname+"&Bprice="+Bprice+"&Bpages="+Bpages+"&Aname="+Aname;
				
				out.println("<a href='"+LinkUrl+"'>"+Bname+"</a><br><br>");
			}
			String LinkUrl1 = "<a href='add_book.jsp'>ADD BOOK</a>";
			out.println(LinkUrl1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
