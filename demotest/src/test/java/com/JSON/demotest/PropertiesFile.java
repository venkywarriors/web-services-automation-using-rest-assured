/**
 * 
 */
package com.JSON.demotest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author venkateshwara.d
 *
 */
public class PropertiesFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	static String path = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(path+"\\Property_file\\db.properties");
		  FileReader reader=new FileReader(path+"\\Property_file\\db.properties");  
	      
		    Properties p=new Properties();  
		    p.load(reader);  
		      
		    System.out.println(p.getProperty("user"));  
		    System.out.println(p.getProperty("password"));  

	}

}
