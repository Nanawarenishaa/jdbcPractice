package jdbcPractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class day1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcPracticeDB","root","ahsin@317");
			Statement stat= con.createStatement();
			String insert1="INSERT INTO employees(emp_Name,emp_Addr) VALUES ('WINTER','SEOUL')";
			int insValue=stat.executeUpdate(insert1);
			String update1="UPDATE employees SET emp_Addr='SEOUL' WHERE emp_id=2";
			String update2="UPDATE employees SET emp_addr='KARJAT' where emp_id=1";
			int Count1 = stat.executeUpdate(update1);
			int Count2=stat.executeUpdate(update2);
		
			ResultSet rs= stat.executeQuery("SELECT * FROM employees");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" ,"+rs.getString(3));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}

	
