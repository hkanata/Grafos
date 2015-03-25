package main;

import java.util.ArrayList;

public class Trains {
	
	Routers objRouters = new Routers();
	ArrayList<String> route;
	
	
	public String exercise1(){
		this.route = new ArrayList<String>();
		this.route.add("AB");
		this.route.add("BC");
		
		return this.objRouters.checkDistance(this.route);
	}
	
	public String exercise2(){
		this.route = new ArrayList<String>();
		this.route.add("AD");
		
		return this.objRouters.checkDistance(this.route);
	}
	
	public String exercise3(){
		this.route = new ArrayList<String>();
		this.route.add("AD");
		this.route.add("DC");
		
		return this.objRouters.checkDistance(this.route);
	}
	
	public String exercise4(){
		this.route = new ArrayList<String>();
		this.route.add("AE");
		this.route.add("EB");
		this.route.add("BC");
		this.route.add("CD");
		
		return this.objRouters.checkDistance(this.route);
	}
	
	public String exercise5(){
		this.route = new ArrayList<String>();
		this.route.add("AE");
		this.route.add("ED");
		
		return this.objRouters.checkDistance(this.route);
	}
	
	public String exercise6(){
		return this.objRouters.tripLimit("C", "C", 3);
	}
	
	public String exercise7(){
		return this.objRouters.tripStartsEnds("A", "C", 3);
	}
	
	public String exercise8(){
		return this.objRouters.mostShortest("A", "C");
	}
	
	public String exercise9(){
		return this.objRouters.mostShortest("B", "B");
	}
	
	public String exercise10(){
		return this.objRouters.getRouterLessThan("C", "C", 30);
	}
	
	public Trains(){

		/*
		 * Este é o construtor da classe.
		 * Pode-se executar separadamente cada exercício.
		 * Coloquei um comentário acima identificando o exercício e as saídas esperadas.
		 * O resultado aparecerá no console do Eclipse
		 * */
		
		//A-B-C = 9
		/*1
		ArrayList<String> route = new ArrayList<String>();
		route.add("AB");
		route.add("BC");
		Routers r = new Routers();
		System.out.println(r.checkDistance(route));
		*/
		
		//A-D = 5
		/*2
		ArrayList<String> route = new ArrayList<String>();
		route.add("AD");
		Routers r = new Routers();
		System.out.println(r.checkDistance(route));
		*/
		
		//A-D-C = 13
		/*3
		ArrayList<String> route = new ArrayList<String>();
		route.add("AD");
		route.add("DC");
		Routers r = new Routers();
		System.out.println(r.checkDistance(route));
		*/
		
		//A-E-B-C-D = 22
		/*4
		ArrayList<String> route = new ArrayList<String>();
		route.add("AE");
		route.add("EB");
		route.add("BC");
		route.add("CD");
		Routers r = new Routers();
		System.out.println(r.checkDistance(route));
		*/
		
		//A-E-D
		/*5
		ArrayList<String> route = new ArrayList<String>();
		route.add("AE");
		route.add("ED");
		Routers r = new Routers();
		System.out.println(r.checkDistance(route));
		*/
		
		//6
		//The number of trips starting at C and ending at C with a maximum of 3 stops.
		//In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
		//Routers r = new Routers();
		//System.out.println(r.tripLimit("C", "C", 3));
		
		
		//7
		//The number of trips starting at A and ending at C with exactly 4 stops.  
		//In the sample data below, there are three such trips: 
		//A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
		//Routers r = new Routers();
		//System.out.println(r.tripStartsEnds("A", "C", 3));
		
		//8
		//The length of the shortest route (in terms of distance to travel) from A to C.
		//Routers r = new Routers();
		//System.out.println(r.mostShortest("A", "C"));
		
		
		//9
		//The length of the shortest route (in terms of distance to travel) from B to B.
		//Routers r = new Routers();
		//System.out.println(r.mostShortest("B", "B"));
		
		//10
		//The number of different routes from C to C with a distance of less than 30.
		//Routers r = new Routers();
		//System.out.println(r.getRouterLessThan("C", "C", 30));
		
	}
	
}
