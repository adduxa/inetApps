package ru.adduxa.inetApps.Lab7;

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

		if(!(	2 <= r && r <= 5 &&
				-5 <= x && x <= 3 &&
				-3 <= y && y <= 5)) {
			response.getWriter().print("Invalid input");
		} else {
			Form form = new Form(r);
			boolean contains = form.contains(new Vertex(x, y));
			request.setAttribute("contains", contains ? "yes" : "no");
			getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
		}
	}
	
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		response.getWriter().print("POST!");
	}
}
