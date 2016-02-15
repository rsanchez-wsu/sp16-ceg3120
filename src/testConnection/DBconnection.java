package testConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author AlisonGuyton.
 *
 */
public class DBconnection {
	Connection conn;
	String url;
	String username;
	String password;

	/**
	 * DBconnection will establish a connection.
	 */
	public DBconnection() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		//path may vary
		url = "jdbc:derby:/Users/AlisonGuyton/.ivy2/cache/org.apache.derby/derby/jars/newDB;"
				+ "create=true";

		System.out.println("Created SQL Connect");
	}

	/**
	 * CreateConnection creates a connection.
	 */
	public void createConnection() {
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Successfully Connected");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * closeConnection closes the established connection to a derby database.
	 */
	public void closeConnection() {
		try {
			this.conn.close();	
			System.out.println("Connection successfully closed");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
/**
 * main.
 * @param args args.
 */
	public static void main(String args[]) {
		DBconnection sql = new DBconnection();
		sql.createConnection();
		sql.closeConnection();
	}
}
