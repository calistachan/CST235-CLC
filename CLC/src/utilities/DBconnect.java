package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	public static Connection getConnection() throws SQLException {
		String url= "jdbc:mysql://localhost:3306/application";
		String username= "kyle";
		String password= "bubbles";
		return DriverManager.getConnection(url, username, password);
	}
}
