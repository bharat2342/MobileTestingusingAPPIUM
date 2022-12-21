package Resources;

import java.util.ArrayList;
import java.util.List;

import PojoClasses.NestedJSON_ForLocation;
import PojoClasses.PojoMainForSerializeTest;
import io.restassured.RestAssured;

public class TestDataBuild 
{
	public PojoMainForSerializeTest addPayLoad(String Name,String Language, String Address)
	{
		
		PojoMainForSerializeTest addPlace=new PojoMainForSerializeTest();
		RestAssured.baseURI="https://rahulshettyacademy.com";

		addPlace.setAccuracy(50);
		addPlace.setAddress(Address);
		addPlace.setLanguage(Language);
		addPlace.setPhone_number("+91-8897583291");
		addPlace.setWebsite("https://booka.com");
		addPlace.setName(Name);
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		addPlace.setTypes(myList);
		NestedJSON_ForLocation location= new NestedJSON_ForLocation();
		location.setLatitude(-38.383494);
		location.setLongitude(33.427362);
		addPlace.setLocation(location);
		return addPlace;
	}
	
	public String deletePlacePayload(String placeID )
	{
		return "{\r\n"
				+ "    \"place_id\":\""+placeID+"\"\r\n"
				+ "}";
		
	}

}
