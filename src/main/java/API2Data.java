import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import com.google.gson.Gson;
import com.mysql.jdbc.Statement;

public class API2Data {

	public static void getData() throws IOException, InterruptedException {
		 String jsonUrl = "https://restcountries.com/v3.1/all";
		        HttpClient client = HttpClient.newHttpClient();
		        HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(jsonUrl))
		                .build();
		        HttpResponse<String> response = client.send(request,
		                HttpResponse.BodyHandlers.ofString());
		      // System.out.println("The JSON of the API is :" +Atributies.body());
		        
		       
		     // Creating the connection using Oracle DB
		        // Note: url syntax is standard, so do grasp
		        String url = "jdbc:mysql://localhost:3306/APIDataBase";

		        // Username and password to access DB
		        // Custom initialization
		        String user = "root";
		        String pass = "root";
		        
		        Gson gsonObject1=new Gson();
		    
		        Atributies[] fetchGson=gsonObject1.fromJson(response.body(),Atributies[].class);
		        
		       for (Atributies varaiblex:fetchGson) {
		    	   System.out.println("The Capiltal is:"+varaiblex.getCapital()[0]);
		    	   System.out.println("The population is:"+varaiblex.getPopulation());
	    	       System.out.println("The Area is:"+varaiblex.getArea());
		    	   System.out.println("The Region is:"+varaiblex.getRegion());
		    	   System.out.println("The Subregion is:"+varaiblex.getSubregion());
	    	       System.out.println("The Languages is:"+varaiblex.getLanguages().getEng());
		    	   
		    	   
		    	   // Inserting data using SQL query
			       String sql = "insert into  restCountries (capital,Population,region,subregion,eng)values('"+varaiblex.getCapital()[0]+"','"
		             + varaiblex.getPopulation()+"','"+varaiblex.getRegion()+"','"+varaiblex.getSubregion()+"','"+varaiblex.getLanguages().getEng()+"')"; 
			       
			       System.out.println(sql);
			       // Connection class object
			        Connection con = null;

			        // Try block to check for exceptions
			        try {

			            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			            // Registering drivers
			            DriverManager.registerDriver(driver);

		            // Reference to connection interface
			            con = DriverManager.getConnection(url, user,
		                    pass);

			            // Creating a statement
			            Statement st = (Statement) con.createStatement();

			            // Executing query
			            int m = st.executeUpdate(sql);
			           if (m >=  1)
			               System.out.println(
			                        "inserted successfully : " + sql);
		           else
			                System.out.println("insertion failed");

			            // Closing the connections
			            con.close();
			        }

		        // Catch block to handle exceptions
		        catch (Exception ex) {
		            // Display message when exceptions occurs
		            System.err.println(ex);
		        }
		        
		       }
		       
		        
		        
		   
		        
		        
		    }

}
