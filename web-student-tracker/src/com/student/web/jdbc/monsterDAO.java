package com.student.web.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.ws.Closeable;

public class monsterDAO {
	private DataSource dataSource;

	public monsterDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<monsters> listOfStudent() throws SQLException {
		List<monsters> monsterList = new ArrayList<monsters>();
		String query = "select * from web_student_tracker.monsters";
		try (java.sql.Connection connection = dataSource.getConnection();
				java.sql.PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				monsters newMonster = new monsters();
				newMonster.setFirstName(resultSet.getString("FirstName"));
				newMonster.setLastName(resultSet.getString("LastName"));
				newMonster.setEmail(resultSet.getString("email"));
				newMonster.setScareScore(resultSet.getString("ScareScore"));

				monsterList.add(newMonster);
			}

		}

		return monsterList;
	}

	public void addStudents(String firstName, String lastName, String email, String scareScore) throws SQLException {

		java.sql.Connection myConn = null;
		java.sql.PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into monsters " + "(firstName, lastName, email, scareScore) " + "values (?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setString(1, firstName);
			myStmt.setString(2, lastName);
			myStmt.setString(3, email);
			myStmt.setString(4, scareScore);

			// execute sql insert
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

	private void close(java.sql.Connection myConn, java.sql.PreparedStatement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in
								// connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
