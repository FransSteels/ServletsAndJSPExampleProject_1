package be.intecbrussel.Servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LennertServlet
 */
@WebServlet("/LennertServlet")
public class LennertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/fbs.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LennertServlet() {
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
		RequestDispatcher rqdp = request.getRequestDispatcher(VIEW);
		StringBuilder message = new StringBuilder();
		Random rand = new Random();
		int f = rand.nextInt(63);
		int b = rand.nextInt(193);
		int s = rand.nextInt(32);
		
		FileReader read = new FileReader(
				new File(
						"C:\\Users\\lennertg\\DynamicWebWorkspace\\ServletsAndJSPExampleProject_1\\WebContent\\textfiles\\f2.txt"));
		BufferedReader br = new BufferedReader(read);
		int count = 0;
		while (count != f) {
			br.readLine();
			count++;
		}
		message.append(br.readLine());
		read = new FileReader(
				new File(
						"C:\\Users\\lennertg\\DynamicWebWorkspace\\ServletsAndJSPExampleProject_1\\WebContent\\textfiles\\b2.txt"));
		br = new BufferedReader(read);
		count = 0;
		while (count != b) {
			br.readLine();
			count++;
		}
		message.append(" " + br.readLine());
		read = new FileReader(
				new File(
						"C:\\Users\\lennertg\\DynamicWebWorkspace\\ServletsAndJSPExampleProject_1\\WebContent\\textfiles\\s2.txt"));
		br = new BufferedReader(read);
		count = 0;
		while (count != s) {
			br.readLine();
			count++;
		}
		message.append(" " + br.readLine());

		// een attribuut toevoegen aan de request
		request.setAttribute("fbs_afkorting", message.toString());

		// de request forwarden naar de JSP
		rqdp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
