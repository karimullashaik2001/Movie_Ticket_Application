package Movie1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Connection con;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","karimulla");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String s2=request.getParameter("movie");
			String s3=request.getParameter("theatre");
			String s4=request.getParameter("date");
			String s5=request.getParameter("time");
			int s6=Integer.parseInt(request.getParameter("nooftic"));
			int amount=s6*100;
			request.setAttribute("movie", s2);
			request.setAttribute("theatre", s3);
			request.setAttribute("date", s4);
			request.setAttribute("time", s5);
			request.setAttribute("noontic", s6);
			request.setAttribute("amount",amount);
			PrintWriter pw=response.getWriter();
			pw.println("<html><body text=black><center><form>");
			pw.println("<h1><em>Review Details</em></h1>");
			pw.println("Movie Name :"+s2);
			pw.println("<br><br>");
			pw.println("Theatre Name :"+s3);
			pw.println("<br><br>");
			pw.println("Show Date :"+s4);
			pw.println("<br><br>");
			pw.println("Show Time :"+s5);
			pw.println("<br><br>");
			pw.println("No Of Tickets :"+s6);
			pw.println("<br><br>");
			pw.println("Fare :"+amount);
			pw.println("</form></center></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("final.html");
			rd.include(request, response);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
