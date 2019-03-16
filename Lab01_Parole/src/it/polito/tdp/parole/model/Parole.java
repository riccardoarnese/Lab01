package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> parole;
		
	public Parole() {
		parole= new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
	parole.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	public void rimuoviParola(String p) {
		parole.remove(p);
	}

}
