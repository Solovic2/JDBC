package eg.edu.alexu.csd.oop.jdbc;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File myFile=new File("D:\\JDBC");
		try {
			URL myUrl = myFile.toURI().toURL();
			System.out.println(myUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
