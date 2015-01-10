package com.servlets.ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolisticCounter
 */
@WebServlet("/HolisticCounter")
public class HolisticCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolisticCounter() {
		super();
		// TODO Auto-generated constructor stub
	}

	static int classCount = 0; // shared by all instances
	int count = 0; // separate for each servlet
	static Hashtable<HolisticCounter, HolisticCounter> instances = new Hashtable<HolisticCounter, HolisticCounter>(); // also shared

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		count++;
		out.println("Since loading, this servlet instance has been accessed "
				+ count + " times.");
		// Keep track of the instance count by putting a referece to this
		// instance in a Hashtable. Duplicate entries are ignored.
		// The size() method returns the number of unique instances stored
		instances.put(this, this);
		out.println("There are currently " + instances.size() + " instances.");

		classCount++;
		out.println("Accross all instances, this servlet class has been "
				+ "accessed " + classCount + " times");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
