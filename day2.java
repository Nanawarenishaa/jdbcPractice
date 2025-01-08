package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class day2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcPracticeDB","root","ahsin@317");
			Statement stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
	        String showTable="select * from employees";
	        ResultSet rs=stat.executeQuery(showTable);
	        
	        
	        
	        
	        if(rs.first()) {
	        	System.out.println("First Row:");
	        	System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
	        }
	        if(rs.last()) {
	        	System.out.println("\nLast Row:");
	        	System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
	        }
	        
	        if (rs.absolute(3)) {
                System.out.println("\nData at Row 2:");
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
	        
	        if (rs.absolute(-1)) { 
                System.out.println("\nData at Last Row:");
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
	        
	        
	        System.out.println("\nforward table :");
	        while (rs.next()) {
	        	System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
	        }
	        System.out.println("\nbackward table:");
	        while (rs.previous()) {
	        	System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
	        }
	        if (rs.relative(4)) {
                System.out.println("\nRow after moving 2 rows forward:");
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
	        if (rs.relative(-1)) {
                System.out.println("\nRow after moving 2 rows backward:");
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
	        
	        }
		
			catch (Exception e) {
				e.printStackTrace();
				
		}

	}

}
