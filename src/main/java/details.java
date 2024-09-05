

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class details
 */
@WebServlet("/details")
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() {
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
		
		String Bid = request.getParameter("Bid");
		String Bname = request.getParameter("Bname");
		String Bprice = request.getParameter("Bprice");
		String Bpages = request.getParameter("Bpages");
		String Aname = request.getParameter("Aname");
		String deleteUrl = "delete?Bid="+Bid;
		String updateUrl = "update?Bid="+Bid+"&Bname="+Bname+"&Bprice="+Bprice+"&Bpages="+Bpages+"&Aname="+Aname;
		
		out.println("<h2>BOOK DETAILS</h2>");
		out.println("<table border=3>");
		out.println("<tr>");
		out.println("<th>Book ID</th>");
		out.println("<th>Book Name</th>");
		out.println("<th>Book Price</th>");
		out.println("<th>Book Pages</th>");
		out.println("<th>Author Name</th>");
		out.println("<th>Delete Action</th>");
		out.println("<th>Update Action</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>"+Bid+"</td>");
		out.println("<td>"+Bname+"</td>");
		out.println("<td>"+Bprice+"</td>");
		out.println("<td>"+Bpages+"</td>");
		out.println("<td>"+Aname+"</td>");
		out.println("<td>"+"<a href='"+deleteUrl+"'>"+"DELETE"+"</a>"+"</td>");
		out.println("<td>"+"<a href='"+updateUrl+"'>"+"UPDATE"+"</a>"+"</td>");
		out.println("</tr>");
		
		String LinkUrl1 = "<a href='show_books'>SHOW ALL THE BOOKS</a><br><br>";
		out.println(LinkUrl1);
	}

}
