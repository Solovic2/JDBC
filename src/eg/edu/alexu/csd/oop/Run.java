package eg.edu.alexu.csd.oop;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

public class Run {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		File myFile=new File("D:\\JDBC");
		Connection c = Connection.get_instance();
		Statement s=c.createStatement();
		//System.out.println("lmkllkihlk");
		try {
			s.execute("create table none(col1 int , col2 int)");
			//s.execute("create table test");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			URL myUrl = myFile.toURI().toURL();
//			System.out.println(myUrl);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////		}
			
	}

}
