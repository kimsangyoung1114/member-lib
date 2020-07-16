package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Execute {
	public static void main(String[] args) {
		String url = "";
		String id= "";
		String pwd ="";
		String driverName ="";
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




