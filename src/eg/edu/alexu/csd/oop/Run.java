package eg.edu.alexu.csd.oop;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) throws SQLException {
		Driver d = new Driver();
		Connection c = new Connection();
		Statement s=c.createStatement();
		System.out.println("***************Welcome To JDBS***********************");
		while (true) {
		System.out.println("Enter Your Query TO execute it  or write (end) to exit :");
		Scanner sc = new Scanner(System.in);
		String sql = new String();
		java.sql.ResultSet r = new ResultSet();
		sql = sc.nextLine();
		if(sql.equalsIgnoreCase("end")) {
			System.out.println("********************* see you soon*************************");
			break;
		}
		
		
		try {
			
			if(sql.toLowerCase().contains("create") || sql.toLowerCase().contains("drop")) {
				 s.addBatch(sql);
				s.execute(sql);
			}
			else if(sql.toLowerCase().contains("insert") || sql.toLowerCase().contains("update")|| sql.toLowerCase().contains("delete"))  {
				 s.addBatch(sql);
				s.executeUpdate(sql);
			}
			else if(sql.toLowerCase().contains("select") ) {
				 s.addBatch(sql);
				r=s.executeQuery(sql);
			}
			else {
				System.err.println("Invalid Input");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
			
	}

}
