package datadriventesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		//step 1:parse json physical file into java object representation using jsonparse class
		JSONParser parser=new JSONParser();
		//step 2:read the data from physical file and convert into json object using parse()
	    Object obj=	parser.parse(new FileReader("C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\JSon_testdata.json"));
		//step 3:downcast the java object into json object
        JSONObject map=(JSONObject)obj;
        System.out.println(map.get("url"));
//    File file=new File("‪C:\\Users\\srinivasa rao\\Downloads\\EXcel_TestData\\JSon_testdata.json");
//     System.out.println(file.exists());
     
     
	}

}
