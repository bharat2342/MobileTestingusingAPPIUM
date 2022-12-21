package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class HooksCucumber 
{
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//Execute only when placeID-is null
		//Write a code that will give the placeID
		
			AddPlaceAPI p=new AddPlaceAPI();
			if(AddPlaceAPI.place_Id==null)
			{
			p.add_place_payload("Bharat", "Telugu", "Sklm");
			p.user_calls_with_http_request("AddPlaceAPI", "POST");
			p.verify_place_id_created_on_maps_to_using("Bharat", "getPlaceAPI");
			
			}

	}
	
	
	
}	
