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
 * Servlet implementation class FinancialServletDelUser
 */
@WebServlet("/FinancialServletDelUser")
public class FinancialServletDelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/Financial.jsp";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinancialServletDelUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		Financieel fin;
		request.setAttribute("x", 3);
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		request.setAttribute("x", 3);

		String name = request.getParameter("name");

		try {
			Financieel fin = new Financieel();
			fin.deleteUser(name);
			request.setAttribute("succes", "GELUKT!");
			rqdp1.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("succes",
					"Het process is niet gelukt, u hebt een fout getypt <br/> Of de user staat nog in de tabel");
			rqdp1.forward(request, response);
		}
	}

}
