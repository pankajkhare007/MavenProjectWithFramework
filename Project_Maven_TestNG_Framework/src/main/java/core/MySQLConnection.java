package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MySQLConnection {

	
	public static Connection connectionWithMySQL() {
		 String url = "jdbc:mysql://localhost:3306/facebook";
	        String username = "root";
	        String password = "root";
	        Connection   connection=null;
	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Create a connection to the database
	             connection = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection successfully");
	           // Statement statement = connection.createStatement();
	           //  getData();
	           //  updateData();
	          //   getData();
	            // Define your SQL query
	          
	           // connection.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return connection;
	}
	
	public static Map<String,String> getData(String sqlQuery) {
		  
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		con=connectionWithMySQL();
		
		Map<String,String> dataRow = new HashMap<String, String>();
         
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			 if (resultSet.next()) {
//		          	String course = resultSet.getString("Course");
//		          	System.out.println(course);
				 int cCount = resultSet.getMetaData().getColumnCount();
				 if(cCount > 0) {
					 for(int i = 1;i <= cCount; i++) {
						 dataRow.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(i));
					 }
				 }
				
					 resultSet.close();
				 	 return dataRow;
				 
		     }else {
		    	 resultSet.close();
		    	 return null;
		     }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
         
	}
	
	

}
