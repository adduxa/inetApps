package ru.adduxa.inetApps.Lab9.MatchesBean;

import ru.adduxa.inetApps.Lab9.Form.Form;
import ru.adduxa.inetApps.Lab9.Form.Vertex;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;

@ManagedBean
@SessionScoped
public class MatchBean implements Serializable {
	private Float x=0f, y=0f, r=3f;
	private LinkedList<Match> matches = new LinkedList<Match>();

	public void match() {
		if(x != null && y != null && r != null &&
			-5 <= x && x <= 5 &&
			-2 <= y && y <= 2 &&
			1 <= r && r <= 3) {
			Form form = new Form(r);
			Vertex vertex = new Vertex(x, y);
			boolean contains = form.contains(vertex);
			matches.add(new Match(vertex, r, contains));
		}
	}

	public void clickMatch() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String x_key = "", y_key = "";
		for(String s : params.keySet()) {
			if(s.endsWith(":graph.x")) {
				x_key = s;
			}
			if(s.endsWith(":graph.y")) {
				y_key = s;
			}
		}

		try {
			x = Float.parseFloat(params.get(x_key));
			y = Float.parseFloat(params.get(y_key));
			x = (x - 110) / 80 * r;
			y = (110 - y) / 80 * r;
			match();
		} catch (Exception ignored) {

		}
	}

	public LinkedList<Match> getMatches() {
		return matches;
	}

	public void setMatches(LinkedList<Match> matches) {
		this.matches = matches;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Float getR() {
		return r;
	}

	public void setR(Float r) {
		this.r = r;
	}
}
