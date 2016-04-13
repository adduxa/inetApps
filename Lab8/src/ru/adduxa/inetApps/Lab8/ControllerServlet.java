package ru.adduxa.inetApps.Lab8;

import ru.adduxa.inetApps.Lab8.MatchesBean.MatchesBean;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MatchesBean matches = (MatchesBean) getServletContext().getAttribute("matches");
		if(matches == null) {
			matches = new MatchesBean();
			getServletContext().setAttribute("matches", matches);
		}
		getServletContext().getRequestDispatcher("/form.jsp").forward(request, response);
	}
}
