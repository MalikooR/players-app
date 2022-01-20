package com.players.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	// in the dbhost the first playersdb is the container name and the second one is the database name
	private static String connString = "jdbc:playersdb:3306/playersdb";
	private static String username = "juser";
	private static String password = "password";
	private static Connection conn;
	private static String sql_req = "select * from players";
	private static Statement stmt;
	private static ResultSet results;

	public static void main(String[] args) {

		try {
			conn = DriverManager.getConnection(connString, username, password);
			System.out.println("Connecting...");
			System.out.println("Connected !!");

			stmt = conn.createStatement();
			results = stmt.executeQuery(sql_req);

			while (results.next()) {
				System.out.println("Id = " + results.getInt("id") + "\n" + "FirstName = "
						+ results.getString("firstname") + "\n" + "LastName = " + results.getString("lastname") + "\n"
						+ "Team = " + results.getString("team") +  "\n" + "Position = " + results.getString("position"));

			}
		} catch (SQLException e) {
			System.out.println("Cannot connect to database connection");
			e.printStackTrace();
		}
	}
}
