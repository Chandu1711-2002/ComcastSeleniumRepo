package datadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
	public static void main(String[] args) throws Exception
	{
		// FileInputStream fis=new FileInputStream("‪C:\\Users\\srinivasa rao\\Downloads\\commondata.properties");
		FileInputStream fis=new FileInputStream("‪C:\\Users\\srinivasa rao\\Downloads\\commondata.properties");
		 Properties prop=new Properties();
		 prop.load(fis);
		 String url=prop.getProperty("url");
		 String username=prop.getProperty("usernam");
		 String password=prop.getProperty("password");
		 System.out.println(url);
		 System.out.println(username);
	}

}
