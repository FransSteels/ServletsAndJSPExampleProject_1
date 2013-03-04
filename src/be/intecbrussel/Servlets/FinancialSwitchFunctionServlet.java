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
 * Servlet implementation class FinancialSwitchFunctionServlet
 */
@WebServlet("/FinancialSwitchFunctionServlet")
public class FinancialSwitchFunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static Integer count=0;
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp = request.getRequestDispatcher("/WEB-INF/JSP/Financial.jsp");
		if (count>3){
			count=0;
		}
		request.setAttribute("x", count);
		Financieel fin;
		try {
		fin = new Financieel();
		fin.setResult();
		request.setAttribute("fin", fin);
		rqdp.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		count++;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
