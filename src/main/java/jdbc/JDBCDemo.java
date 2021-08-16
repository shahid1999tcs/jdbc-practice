package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JDBCDemo {
	public static Logger logger = LogManager.getLogger(JDBCDemo.class);
	public static void main(String[] args) {
		logger.fatal("fatality");
		String DB_URL = "jdbc:mysql://localhost/learn";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
			// create(statement);
			//retrieve(statement);
			//update(statement);
			//delete(statement);
			//List<String> regions = retrieveWithCondition(statement, "A");
			//System.out.println(regions);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void delete(Statement statement) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM REGIONS WHERE REGION_ID=5";
		statement.execute(sql);
		
	}

	private static List<String> retrieveWithCondition(Statement statement, String string) throws SQLException {
		String sql = "SELECT * FROM REGIONS WHERE REGION_NAME LIKE '" + string + "%' ORDER BY REGION_NAME DESC";
		//System.out.println(sql);
		ResultSet resultset = statement.executeQuery(sql);
		List<String> regions = new ArrayList<String>();
		while (resultset.next()) {
			//System.out.println(resultset.getInt(1));// column index starts from 1
			//System.out.println(resultset.getString(2));
			regions.add(resultset.getString(2));
		}
		//System.out.println(regions);
		return regions;
	}

	private static void update(Statement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.execute("UPDATE REGIONS SET REGION_NAME='Arctic' WHERE REGION_ID=5");
	}

	private static void retrieve(Statement statement) throws SQLException {

		ResultSet resultset = statement.executeQuery("SELECT * FROM REGIONS");
		while (resultset.next()) {
			logger.debug((resultset.getInt(1)));// column index starts from 1
			System.out.println(resultset.getString(2));
		}
	}

	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO REGIONS VALUES(5,'Antartica')");
	}
}
