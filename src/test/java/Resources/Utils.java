package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	public static RequestSpecification req; 
	public RequestSpecification requestSpecification() throws IOException
	
	{
		if(req==null)
		{
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
		req=new  RequestSpecBuilder()
				.setBaseUri(getGlobalValue("baseURI"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)) //For Request
				.addFilter(ResponseLoggingFilter.logResponseTo(log)) // For Response
				.setContentType(ContentType.JSON)
				.build();
		return req;	
	}
		return req;
	}
	
	//To access the global.properties and all the baseURI stuff
	public static String  getGlobalValue(String Key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\bharat\\eclipse-workspace\\RestAssuredByRahullShetty_BDDFramework\\src\\test\\java\\Resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(Key);
	}
	
	public String getJSONpath(Response response,String key)
	{
		 String resp=response.asString();
		 JsonPath js = new JsonPath(resp);
		 return js.get(key).toString();
		
	}
	

}
