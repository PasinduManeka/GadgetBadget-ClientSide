package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fund {
	//Database connection
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf", "root", "");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//read database values
	public String readFunds() {
		String output="";
		try {
			Connection con = connect();
			//check database connection
			if(con == null) {
				return "Error while connecting to databse for reading the table data.";
			}
			
			//prepare the HTML page
			output +="<div class='table-wrapper-scroll-y my-custom-scrollbar'><table border='1' class='table'><thead class='thead-dark'><tr><th>id</th><th>Cart ID</th><th>Researcher Name</th>" +
					"<th>Invest Amount</th>" +  
					"<th>Invester Message</th>" +
					"<th>Update</th><th>Remove</th></tr></thead>";
			
			//Table connection query
			String sql = "select* from funds";
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
			
			//iterate the rows in the result set
			while(rs.next()) {
				//assign to the tables
				String id = Integer.toString(rs.getInt("id"));
				String cartID = Integer.toString(rs.getInt("cartid"));
				String name = rs.getString("researchName");
				String amount = Double.toString(rs.getDouble("investAmount"));
				String description = rs.getString("description");
				
				//add to html table
				output += "<tbody><tr><td>"+id+"</td>";
				output += "<td>"+cartID+"</td>";
				output += "<td>"+name+"</td>";
				output += "<td>"+amount+"</td>";
				output += "<td>"+description+"</td>";
				
				//buttons
				output += "<td><input type='button' name='btnUpdate' value='Update' class='btn btn-outline-warning btnUpdate' data-funid='"+id+"'></td>"
						+ "<td><input type='button' name='btnDelete' value='Delete' class='btn btn-outline-danger btnDelete' data-fundid='"+id+"'></td></tr>";
				
			}
			//databse connection is closed
			con.close();
			
			//End of the HTML table
			output += "</tbody></table></div>";
			
		}catch(Exception e) {
			output = "Error while reading databse data.";
			System.out.println("This is the error reading: "+e.getMessage());
		}
		return output;
	}

	//Insert data 
	public String insertFunds(String id, String name, String iAmount, String description) {
		String output="";
		try {
			Connection con = connect();
			//database connection
			if(con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			//create a prepared statement
			String sql = "insert into funds (cartid,researchName,investAmount, 	description ) values (?,?,?,?)";
			PreparedStatement pdstm = con.prepareStatement(sql);
			
			//bind values
			pdstm.setInt(1, Integer.parseInt(id));
			pdstm.setString(2, name);
			pdstm.setDouble(3, Double.parseDouble(iAmount));
			pdstm.setString(4, description);
			
			//Execute the statement
			pdstm.executeUpdate();
			con.setAutoCommit(false);
			con.commit();
			con.close();
			
			String newFund = readFunds();
			output="{\"status\":\"success\", \"data\":\""+newFund+"\"}";	
			
			
		}catch(Exception e) {
			output="{\"status\":\"error\", \"data\":\"Error while inserting item.\"}";
			System.err.println("This is the error:"+e.getMessage());
		}
		return output;
	}
	
	public String updateFunds(String id, String cartid, String rname, String iAmount, String description) {
		String output = "";
		try {
			Connection con = connect();
			if(con == null) {
				return "Error while connecting to the datebase forupdating the data.";
			}
			
			//sql query
			String sql = "update funds set cartid=?, researchName=?, investAmount=?, description=? whwere id=?";
			PreparedStatement pdstm = con.prepareStatement(sql);
			
			//bind values
			pdstm.setInt(1, Integer.parseInt(cartid));
			pdstm.setString(2, rname);
			pdstm.setDouble(3, Double.parseDouble(iAmount));
			pdstm.setString(4, description);
			pdstm.setInt(5, Integer.parseInt(id));
			
			//execute the statement
			pdstm.executeUpdate();
			con.setAutoCommit(false);
			con.commit();
			
			String newFund = readFunds();
			output = "{\"status\":\"success\", \"data\":\""+newFund+"\"}";
		
		}catch(Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while updating the data.\"}";
			System.err.print("this is the error updating:"+e.getMessage());
		}
		return output;
	}
	
	//public String updateString(String id, String name, String )
	
	public String deleteFunds(String id) {
		String output="";
		try {
			Connection con=connect();
			//check the database connection
			if(con==null) {
				return "Error while connecting to the databae for deleting the data.";
			}
			
			//create prepared statement
			String sql = "delete from funds wherer id=?";
			PreparedStatement pdstm = con.prepareStatement(sql);
			
			//bind values
			pdstm.setInt(1, Integer.parseInt(id));
			
			//execute the statement
			pdstm.executeUpdate();
			con.setAutoCommit(false);
			con.commit();
			
			String newFund = readFunds();
			output = "{\"status\":\"success\", \"data\":\""+newFund+"\"}";
			
		}catch(Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the data.\"}";
			System.err.print("this is the erro updating:"+e.getMessage());
		}
		return output;
	}
}
