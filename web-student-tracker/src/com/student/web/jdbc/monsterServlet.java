package com.student.web.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/monsterServlet")
public class monsterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
	private monsterDAO monsterDAO;

	public void init() {
		monsterDAO = new monsterDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listOfMonsters(request, response);
				break;
				
			case "ADD":
				addMonster(request, response);
				listOfMonsters(request, response);
				break;
				
			default:
				listOfMonsters(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void addMonster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String scareScore  = request.getParameter("scareScore");
	
		try {
			monsterDAO.addStudents(firstName, lastName, email, scareScore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void listOfMonsters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<monsters> monsterList = monsterDAO.listOfStudent();
			request.setAttribute("monsterList", monsterList); 
			request.getRequestDispatcher("student-table-view.jsp").forward(request,
					response);
		} catch (SQLException e) {
			throw new ServletException("Cannot obtain products from DB", e);
		}
		
	}

}
