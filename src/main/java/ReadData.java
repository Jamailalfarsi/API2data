import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class ReadData {
	
	public static void readDataFunction()throws IOException, InterruptedException {

	String url = "jdbc:mysql://localhost:3306/APIDataBase";

	// Username and password to access DB
	// Custom initialization
	String user = "root";
	String pass = "root";

	Scanner scanner = new Scanner(System.in);
	

	String sql2 = "SELECT * FROM restCountries";

	Connection con1 = null;

	try {

		Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		// Registering drivers
		DriverManager.registerDriver(driver);

		// Reference to connection interface
		con1 = DriverManager.getConnection(url, user, pass);

		// Creating a statement
		Statement st = con1.createStatement();
		ResultSet resultSet = st.executeQuery(sql2);
		// System.out.println(resultSet);
		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String capital = resultSet.getString("capital");
			Integer population=resultSet.getInt("population");
			String region = resultSet.getString("region");
			String subregion=resultSet.getString("subregion");
			String eng =resultSet.getString("eng");
			
		
			System.out.println(id + ", '" + capital + "', " + population + ", '"+ region +"', '"
			+ subregion+ "' ,'" +eng+"");
		}

	}

	// Catch block to handle exceptions
	catch (Exception ex) {
		// Display message when exceptions occurs
		System.err.println(ex);
	}


}
}
