package be.intecbrussel.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassWordServlet
 */
@WebServlet("/PassWordServlet")
public class PassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/wachtwoord.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PassWordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		
		boolean tempcookie = true;

		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("wachtwoordCookie")) {
				tempcookie = false;
				if (Integer.parseInt(cookie.getValue()) > 4) {
					response.sendRedirect("/ServletsAndJSPExampleProject_1/LennertServlet");
				}
				else {
					rqdp1.forward(request, response);
				}

			}
		}

		if (tempcookie) {
			Cookie cookie = new Cookie("wachtwoordCookie", "1");
			response.addCookie(cookie);
			rqdp1.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		String password = request.getParameter("pwd");
		if (password.equals("iknaakt")) {
			// rqdp2.forward(request, response);
			Cookie cookie = new Cookie("wachtwoordCookie", "1");
			response.addCookie(cookie);
			response.sendRedirect("/ServletsAndJSPExampleProject_1/FinancialSwitchFunctionServlet");
		} else {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equalsIgnoreCase("wachtwoordCookie")) {

					if (Integer.parseInt(cookie.getValue()) > 4) {
						response.sendRedirect("/ServletsAndJSPExampleProject_1/LennertServlet");
					} else {
						Integer add = Integer.parseInt(cookie.getValue());

						add += 1;
						cookie = new Cookie("wachtwoordCookie", add.toString());
						response.addCookie(cookie);

						request.setAttribute("wrong", "wrong password, "
								+ (5 - add) + "more tries");
						rqdp1.forward(request, response);
					}
				}
			}
		}

	}
}
