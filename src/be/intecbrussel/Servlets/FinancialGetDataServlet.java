package be.intecbrussel.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Financieel;

/**
 * Servlet implementation class FinancialGetDataServlet
 */
@WebServlet("/FinancialGetDataServlet")
public class FinancialGetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinancialGetDataServlet() {
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
		RequestDispatcher rqdp = request
				.getRequestDispatcher("/WEB-INF/JSP/Financial.jsp");

		Financieel fin;
		request.setAttribute("x", 4);

		try {
			fin = new Financieel();
			fin.setResult();
			request.setAttribute("fin", fin);
			rqdp.forward(request, response);

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
		RequestDispatcher rqdp = request
				.getRequestDispatcher("/WEB-INF/JSP/Financial.jsp");
		Financieel fin;
		request.setAttribute("x", 4);
		String name = request.getParameter("name");
		if (request.getParameter("getData").equals("GET TOTAL AMOUNT")) {
			try {
				fin = new Financieel();
				String res = fin.getAmountPerUser(name);
				request.setAttribute("amountPP", res);
				rqdp.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("succes", "Wrong name input");
				rqdp.forward(request, response);
			}
		} else if (request.getParameter("getData").equals("GET THIS USER'S DATA")) {
			try {
				fin = new Financieel();
				String res = fin.getDataUser(name);
				request.setAttribute("amountPP", res);
				rqdp.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("succes", "Wrong name input");
				rqdp.forward(request, response);
			}
		} else if (request.getParameter("getData").equals("GET ALL USER DATA")) {
			try {
				fin = new Financieel();
				String res = fin.getDataUsers();
				request.setAttribute("amountPP", res);
				rqdp.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("succes", "Whoeps, this is not supposed to happen");
				rqdp.forward(request, response);
			}
		}
	}
}
