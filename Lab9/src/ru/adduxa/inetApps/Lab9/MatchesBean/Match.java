package ru.adduxa.inetApps.Lab9.MatchesBean;

import ru.adduxa.inetApps.Lab9.Form.Vertex;

import java.io.Serializable;

public class Match implements Serializable {
	private Vertex vertex;
	private float R;
	private boolean matched;

	public Match(Vertex vertex, float R, boolean matched) {
		this.vertex = vertex;
		this.R = R;
		this.matched = matched;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public float getR() {
		return R;
	}

	public void setR(float r) {
		R = r;
	}

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	public String getMatchedText() {
		return matched ? "yes" : "no";
	}
}
