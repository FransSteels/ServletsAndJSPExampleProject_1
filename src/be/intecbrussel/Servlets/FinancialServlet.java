package be.intecbrussel.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Financieel;

/**
 * Servlet implementation class FinancialServlet
 */
@WebServlet("/FinancialServlet")
public class FinancialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/Financial.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinancialServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
			Financieel fin;
			request.setAttribute("x", 0);
			try {
			fin = new Financieel();
			fin.setResult();
			request.setAttribute("fin", fin);
			rqdp1.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		request.setAttribute("x", 0);

		String name = request.getParameter("name");
		int value = Integer.parseInt(request.getParameter("value"));
		String date = request.getParameter("date");
		String project = request.getParameter("project");
		try {
			Financieel fin = new Financieel();
			fin.addExpences(name, value, date, project);
			request.setAttribute("succes", "GELUKT!");
			rqdp1.forward(request, response);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("succes",
					"Het process is niet gelukt, u hebt een faut getypt");
			rqdp1.forward(request, response);
		}

	}

}
