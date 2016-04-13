package ru.adduxa.inetApps.Lab8;

import ru.adduxa.inetApps.Lab8.Form.Form;
import ru.adduxa.inetApps.Lab8.Form.Vertex;
import ru.adduxa.inetApps.Lab8.MatchesBean.Match;
import ru.adduxa.inetApps.Lab8.MatchesBean.MatchesBean;

import java.io.IOException;

public class AreaCheckServlet extends javax.servlet.http.HttpServlet {
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		Float r, x, y;
		try {
			x = new Float(request.getParameter("x"));
			r = new Float(request.getParameter("r"));
			y = new Float(request.getParameter("y"));
		} catch(Exception e) {
			response.getWriter().print("Invalid input");
			return;
		}

		if(!(	1 <= r && r <= 5 &&
				-4 <= x && x <= 4 &&
				-3 <= y && y <= 3)) {
			response.getWriter().print("Invalid input");
		} else {
			Form form = new Form(r);
			Vertex vertex = new Vertex(x, y);
			boolean contains = form.contains(vertex);
			request.setAttribute("contains", contains ? "yes" : "no");
			MatchesBean matches = (MatchesBean) getServletContext().getAttribute("matches");
			if(matches == null) {
				matches = new MatchesBean();
			}
			matches.addMatch(new Match(vertex, r, contains));
			getServletContext().setAttribute("matches", matches);
			getServletContext().getRequestDispatcher("/form.jsp").forward(request, response);
		}
	}
	
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		response.getWriter().print("POST!");
	}
}
