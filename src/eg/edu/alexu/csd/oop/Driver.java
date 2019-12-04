package eg.edu.alexu.csd.oop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;


public class Driver implements java.sql.Driver {

	/*****************************Singleton Design Pattern********************************************/
	private static Driver instance = new Driver(); 
	
	private  Driver(){}
	
	public static Driver get_instance() {
		return instance;
	}
	/*******************************************************************************************************/
	String save=null;
	@Override
	public boolean acceptsURL(String url) throws SQLException {
		File newfile = new File("D:\\\\DBMS\\\\DB_PATHES.txt");
		boolean isExist=false;
		try {
			BufferedReader br = new BufferedReader(new FileReader(newfile));
			String line=null;
			while((line = br.readLine()) != null) {
				if(line.trim().contains("PATH: "+url)) {
					save=line.substring(6, line.length());
					isExist=true;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isExist;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		File dir = (File) info.get("path");
		String path = dir.getAbsolutePath();
/*		File newfile = new File("F:\\personal pics\\Bahaa\\programs\\second year term 1\\programming\\omarmohamedemam-dbms-1410883b5be8\\DB_PATHES.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(newfile));
			String line=null;
			while((line = br.readLine()) != null) {
				if(line.trim().contains("PATH: "+path)) {
					
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		Connection cc=Connection.get_instance();
		if(acceptsURL(path)) {
//			cc.setElconnect(save);
			return cc;
		}
		return cc;
//		return null;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		DriverPropertyInfo[] dpi=new DriverPropertyInfo[0];
	
		return null;
	}
	
	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

}
