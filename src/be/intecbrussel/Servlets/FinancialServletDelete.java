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
 * Servlet implementation class FinancialServletDelete
 */
@WebServlet("/FinancialServletDelete")
public class FinancialServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/FinancialDelete.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		Financieel fin;
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
		Financieel fin;
		try {
			int projectnumber = Integer.parseInt(request.getParameter("id"));
			fin = new Financieel();
			int x = fin.delete(projectnumber);
				if (x == 0) {
					request.setAttribute("succes", "File has not been deleted");
					rqdp1.forward(request, response);
				} else {
					request.setAttribute("succes", "File has been deleted");
					rqdp1.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("succes",
					"File has not been deleted, give in a number");
			rqdp1.forward(request, response);
		}
	}

}
