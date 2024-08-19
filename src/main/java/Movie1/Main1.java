package Movie1;

import java.io.IOException;
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
 * Servlet implementation class Main1
 */
@WebServlet("/main1")
public class Main1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
Connection con;
    /**
     * Default constructor. 
     */
    public Main1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@local:1521:xe","system","karimulla");
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
		String action=request.getParameter("action");
		//PrintWriter pw=response.getWriter();
		if("Login".equals(action))
		{
			//pw.println("you clicked login button");
			RequestDispatcher rd=request.getRequestDispatcher("log");
			rd.forward(request, response);
		}
		else if("Registration".equals(action))
		{
			//pw.println("you clicked registration button");
			RequestDispatcher rd=request.getRequestDispatcher("reg.html");
			rd.forward(request, response);
		}
	}

}
