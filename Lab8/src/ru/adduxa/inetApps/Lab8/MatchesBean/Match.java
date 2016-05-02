package ru.adduxa.inetApps.Lab8.MatchesBean;

import ru.adduxa.inetApps.Lab8.Form.Vertex;

public class Match {
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

	public float getR() {
		return R;
	}

	public String getMatched() {
		return matched ? "yes" : "no";
	}
}
