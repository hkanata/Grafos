package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Trains;

/**
 * Servlet implementation class Calling
 */
@WebServlet("/Calling")
public class Calling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calling() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String numberExercise = request.getParameter("number_exercise");
		
		Trains t = new Trains();
		
		switch (numberExercise) {
			case "1":  
				out.println(t.exercise1());
	        break;
			case "2":  
				out.println(t.exercise2());
	        break;
			case "3":  
				out.println(t.exercise3());
	        break;
			case "4":  
				out.println(t.exercise4());
	        break;
			case "5":  
				out.println(t.exercise5());
	        break;
			case "6":  
				out.println(t.exercise6());
	        break;
			case "7":  
				out.println(t.exercise7());
	        break;
			case "8":  
				out.println(t.exercise8());
	        break;
			case "9":  
				out.println(t.exercise9());
	        break;
			case "10":  
				out.println(t.exercise10());
	        break;
		}
		
	}

}
