

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
		
		out.println("<body><center>");
		out.println("<h1>Book Update Form</h1>");
		out.println("<form action='update_data' method='post'>");
		out.println("<input type='hidden' name='Bid' value="+Bid+"><br><br>");
		out.println("Book Name <input type='text' name='Bname' value="+Bname+"><br><br>");
		out.println("Book Price <input type='text' name='Bprice' value="+Bprice+"><br><br>");
		out.println("Book Pages <input type='text' name='Bpages' value="+Bpages+"><br><br>");
		out.println("Author Name <input type='text' name='Aname' value="+Aname+"><br><br>");
		out.println("<input type='submit' value='EDIT'/>");
		out.println("</form>");
		out.println("</body>");
	}

}
