import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport ;
import java.sql.Statement;

import java.io.PrintWriter;

//import com.mysql.Statement;
//import com.mysql.cj.xdevapi.Statement;
//import java.util.Map;  
//import org.apache.struts2.dispatcher.SessionMap;  
//import org.apache.struts2.interceptor.SessionAware;


public class Register extends ActionSupport implements SessionAware {

	//declare variables 
	private String username;
	private String password;
	private String itemname;
	private String price;
	private String bid;
	private String name = username;
	boolean flag = false;
	
	
	

	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<String> items = new ArrayList<String>();
	private ArrayList<String> bids = new ArrayList<String>();
	
	
	private Map<String, Object> session ;
	
	public Register() {
		
	}
	
	public String registration() {
		//String outcome = null;		
		Connection connection = null ;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca?serverTimezone=UTC","root" , "DahabAshraf17");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement createUser = null;
		try {
			createUser = connection.prepareStatement(	
					"INSERT into user"
					+ "(username , password)" + "VALUES (?,?)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			// PASS in the values as parameters 
		try {
			createUser.setString(1, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
			createUser.setString(2, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
			int rowsUpdated = createUser.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
			createUser.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		return "SUCCESS";
	}
	



	
	
public String login() {
	String result = "fail";		
	Connection connection = null ;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca?serverTimezone=UTC","root" , "DahabAshraf17");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	boolean status=false;  
	try {
		 
		PreparedStatement ps=connection.prepareStatement(  
		     "select * from user where username=? and password=?");  
		   ps.setString(1,username);  
		   ps.setString(2,password);  
		   ResultSet rs=ps.executeQuery() ;
		   status=rs.next();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if (status) {
		result = "SUCCESS";
		session.put("currentUser", username);
	} 
		
	return result ;
}


public String logout () {
	return "SUCCESS";
	
}




public String viewAllUsers() {
	Connection connection = null ;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca?serverTimezone=UTC","root" , "DahabAshraf17");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Statement statement = null ;
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		

	ResultSet rs = null;
	try {
		rs = statement.executeQuery("select username from user" )	;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		while (rs.next())
		{
			usernames.add(rs.getString(1));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "SUCCESS";

}




public String addItems() {
		//String outcome = null;		
		Connection connection = null ;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca?serverTimezone=UTC","root" , "DahabAshraf17");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement createItem = null;
		try {
			createItem = connection.prepareStatement(	
					"INSERT into item"
					+ "( itemname , price , username)" + "VALUES (?,?, ?)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			// PASS in the values as parameters 
		try {
			createItem.setString(1, itemname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
			createItem.setString(2, price);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		try {
			createItem.setString(3, username);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	try {
			int rowsUpdated = createItem.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
			createItem.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return "SUCCESS";
	}


public String viewAllItems() {
	Connection connection = null ;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca?serverTimezone=UTC","root" , "DahabAshraf17");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Statement statement = null ;
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	ResultSet rs = null;
	try {
		rs = statement.executeQuery("select * from item" )	;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		while (rs.next())
		{
			String ss = rs.getString(1);
			String tt = rs.getString(2);
			items.add(ss+" "+tt);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "SUCCESS";

}

public String addBids() {
	//String outcome = null;		
	Connection connection = null ;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca?serverTimezone=UTC","root" , "DahabAshraf17");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	PreparedStatement createBid = null;
	try {
		createBid = connection.prepareStatement(	
				"UPDATE item set bid=60 where itemname=?");
		System.out.println(itemname+" "+bid);
		//createBid.setString(1, bid);
		createBid.setString(1, itemname);
		int rowsUpdated = createBid.executeUpdate();
		createBid.close();
		return "SUCCESS";
	}
		
 catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return "FAILURE";
}



public String viewMyBids() {
	Connection connection = null ;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca?serverTimezone=UTC","root" , "DahabAshraf17");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		 
		PreparedStatement ps=connection.prepareStatement("select * from bid where username=?" );  
		System.out.println(ps);
		ps.setString(1,username);   
		ResultSet rs=ps.executeQuery() ;
		while (rs.next())
		{
			flag=true ;
			String it = rs.getString(1);
			String bp = rs.getString(2);
			bids.add(it +" " + bp );
		}
		
		
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(flag) {
		return "SUCCESS";
	}else {
	return "FAILURE";
	}
	
	
}









































	 public String getUsername() {
	 return username;
	 }
	
	 public void setUsername(String username) {
	 this.username = username;
	 }
	
	 public String getPassword() {
	 return password;
	 }
	
	 public void setPassword(String password) {
	 this.password = password;
	 }
	      
	 
	 
	 public String getItemname() {
		 return itemname;
		 }
		
		 public void setItemname(String itemname) {
		 this.itemname = itemname;
		 }
		 
		 
		 public String getPrice() {
			 return price;
			 }
			
			 public void setPrice(String price) {
			 this.price = price;
			 }
	 
			 public String getBidprice() {
				 return bidprice;
				 }
				
				 public void setBidname(String bidprice) {
				 this.bidprice = bidprice;
				 }
	 
	
     @Override
     public void setSession(Map map)
     {
  	   session = map;
     }
    
      public ArrayList<String> getUsernames(){
    	  return usernames;
      }
      
      public void setUsernames(ArrayList<String> usernames) {
	  this.usernames = usernames;
      }
      
      
      public ArrayList<String> getItems(){
    	  return items;
      }
      
      public void setItems(ArrayList<String> items) {
	  this.items = items;
      }
      
      public ArrayList<String> getBids(){
    	  return bids;
      }
      
      public void setBids(ArrayList<String> bids) {
	  this.bids = bids;
      }
      
              
}

