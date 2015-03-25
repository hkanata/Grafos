package main;

import java.util.ArrayList;

public class PossibleRouters {
	
	private static PossibleRouters instance = null;
	
	ArrayList<Routers> listRouters = new ArrayList<Routers>();
	
	/**
	 * Singleton
	 */
	public static PossibleRouters getInstance() {
		if(instance == null) {
			instance = new PossibleRouters();
		}
	    return instance;
	}
	
	/**
	 * Possíveis rotas
	 */
	private PossibleRouters(){
		//AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
		listRouters.add(new Routers("AB", 5));
		listRouters.add(new Routers("BC", 4));
		listRouters.add(new Routers("CD", 8));
		listRouters.add(new Routers("DC", 8));
		listRouters.add(new Routers("DE", 6));
		listRouters.add(new Routers("AD", 5));
		listRouters.add(new Routers("CE", 2));
		listRouters.add(new Routers("EB", 3));
		listRouters.add(new Routers("AE", 7));
	}
	
}
