package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/learn";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
			// create(statement);
			retrieve(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void retrieve(Statement statement) throws SQLException {

		ResultSet resultset = statement.executeQuery("SELECT * FROM REGIONS");
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));// column index starts from 1
			System.out.println(resultset.getString(2));
		}
	}

	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO REGIONS VALUES(5,'Antartica')");
	}
}
