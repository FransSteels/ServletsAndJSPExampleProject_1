package be.intecbrussel.Servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LennertServlet")
public class LennertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/fbs.jsp";

	public LennertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Met deze methodes kan je een path maken 
		// dat geschikt is voor uw doeleinden

		String path1 = getServletContext().getRealPath("/WEB-INF/conf/f2.txt");

		String path2 = getServletContext().getRealPath("/WEB-INF/conf/b2.txt");

		String path3 = getServletContext().getRealPath("/WEB-INF/conf/s2.txt");

		StringBuilder refreshCookie = new StringBuilder();
		refreshCookie.append("een");
		refreshCookie.append(request.getParameter("ikbeneen"));
		
		if (refreshCookie.toString().equals("eencookie")) {
			Cookie cookie = new Cookie("wachtwoordCookie", "1");
			response.addCookie(cookie);
			}
				
		
		RequestDispatcher rqdp = request.getRequestDispatcher(VIEW);
		StringBuilder message = new StringBuilder();
		Random rand = new Random();
		int f = rand.nextInt(63);
		int b = rand.nextInt(193);
		int s = rand.nextInt(32);

		FileReader read = new FileReader(new File(path1));
		BufferedReader br = new BufferedReader(read);
		int count = 0;
		while (count != f) {
			br.readLine();
			count++;
		}
		message.append(br.readLine());
		read = new FileReader(new File(path2));
		br = new BufferedReader(read);
		count = 0;
		while (count != b) {
			br.readLine();
			count++;
		}
		message.append(" " + br.readLine());
		read = new FileReader(new File(path3));
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
