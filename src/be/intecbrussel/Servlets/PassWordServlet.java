package be.intecbrussel.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

/**
 * Servlet implementation class PassWordServlet
 */
@WebServlet("/PassWordServlet")
public class PassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/wachtwoord.jsp";
	private static final String VIEW2 = "/WEB-INF/JSP/Financial.jsp";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		rqdp1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		RequestDispatcher rqdp2 = request.getRequestDispatcher(VIEW2);
		String password = request.getParameter("pwd");
		if (password.equalsIgnoreCase("polakpool")) {
//			rqdp2.forward(request, response);
			response.sendRedirect("/ServletsAndJSPExampleProject_1/FinancialSwitchFunctionServlet");
		}
		else {
			request.setAttribute("wrong", "wrong password");
			rqdp1.forward(request, response);
		}
	}

}
