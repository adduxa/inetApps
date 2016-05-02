package ru.adduxa.inetApps.Lab8.MatchesBean;

import java.io.Serializable;
import java.util.LinkedList;

public class MatchesBean implements Serializable {
	private LinkedList<Match> matches = new LinkedList<Match>();

	public LinkedList<Match> getMatches() {
		return matches;
	}

	public void addMatch(Match match) {
		matches.add(match);
		if(matches.size() > 5) {
			matches.removeFirst();
		}
	}
}
