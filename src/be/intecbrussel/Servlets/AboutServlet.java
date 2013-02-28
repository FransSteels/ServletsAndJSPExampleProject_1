package be.intecbrussel.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

/**
 * Servlet implementation class AboutServlet
 */
@WebServlet("/AboutServlet")
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/About.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AboutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);
		// de request forwarden naar de JSP
		rqdp1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rqdp1 = request.getRequestDispatcher(VIEW);

		
		String button = request.getParameter("TSH");
		
		
		if (button.equalsIgnoreCase("THE SHOP")) {
			request.setAttribute("text","Tattoo artist Polak One started Polak’s Finest Beef Shop in oktober 2012, after some years of experience in Harai Tattoo and other tattoo shops. Although Polak learned a lot there, his dream for a shop of his own became more and more prominent. Eventually, his wish brought him to a location at Sint-Kwintensberg 47 that proved to be the ideal spot Polak’s Finest Beef Shop became a highly personally styled shop. Meet Polak’s collection of skulls and swords next to other rare items, set in a beautifully painted interior with a cow-skinned desk welcoming you. Make yourself comfortable in the seats, while admiring artwork by Polak One and other artists and nipping from a drink. Polak’s Finest Beef Shop keeps unwanted curiosity out of the picture because of the privacy offered by non-transparent windows and the slightly confusing name (Yeah, we had some grannies ordering half a kilo of lamb chops).Visit the shop during the opening hours for information on designs, prices and duration. Inform us about your ideas and your visit via info@finestbeefshop.com or +32472269064. Further appointments will be made at the shop. Exceptions will only be made if you don’t live near Ghent. The shop is open from Tuesday till Saturday, every day from 12 pm till 18 pm. For more details, see ‘CONTACT’.");
		}
		else {
			request.setAttribute("text", "FBS is a graphic design collective by Thomas, Lennert en Gert. Their studio is located in Polak’s Finest Beef Shop. They combine strong illustrations with fine lettering, adapted to your wishes. For all your ideas or products that need some awesome graphic design, mail to : fbsstudio@gmail.com For more information and a portfolio, check : www.fbsstudio.com or www.fbsstudio.be");

		}
		

		// de request forwarden naar de JSP
		rqdp1.forward(request, response);
	}

}
