package Movie1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String Movie=(String) request.getAttribute("movie");
		String Theatre=(String) request.getAttribute("theatre");
		String Date=(String) request.getAttribute("date");
		String Time=(String) request.getAttribute("time");
		int nooftic=(int) request.getAttribute("noontic");
		double amount=(double) request.getAttribute("amount");
		pw.println("<html><body text=green><center>");
		pw.println("<h2><b>Your Tickets Are Booked Successfully)</b></h2>");
		pw.println("<em>Movie :</em>"+Movie);
		pw.println("<em>Theatre :</em>"+Theatre);
		pw.println("<em>Show Date :</em>"+Date);
		pw.println("<em>Show Time :</em>"+Time);
		pw.println("<em>No.Of Tickets :</em>"+nooftic);
		pw.println("<em>Total Fare :</em>"+amount);
		pw.println("</center></body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("Booked.html");
		rd.include(request, response);
	}

}
