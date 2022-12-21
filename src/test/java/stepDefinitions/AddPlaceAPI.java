package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import PojoClasses.NestedJSON_ForLocation;
import PojoClasses.PojoMainForSerializeTest;
import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Data;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddPlaceAPI extends Utils
{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild testData= new TestDataBuild();
	static String place_Id;
	
	
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String Peru, String Bhasha, String Uruu) throws IOException 
	{
		
		 res=given().spec(requestSpecification())
		.body(testData.addPayLoad(Peru,Bhasha,Uruu));
	   
	}
	@When("user calls {string} with {string} httpRequest")
	public void user_calls_with_http_request(String resource, String method) 
	{
		//Clearly invoke the constructor which is value of resource
		//Constructor will be called with value of resource which you pass
	APIResources resourceAPI=APIResources.valueOf(resource);
	//Try to print and check
	System.out.println(resourceAPI.getResource());
		
		
		resspec= new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		if(method.equalsIgnoreCase("POST"))
			response=res.when()	.post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response=res.when()	.get(resourceAPI.getResource());
		
	    
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1)
	{
		assertEquals(response.getStatusCode(),200);
	    
	   
	}
	
	@Then("verify place_Id created on Maps to {string} using {string}")
	public void verify_place_id_created_on_maps_to_using(String expName, String resource) throws IOException
	{
		//requestSpec
		place_Id=getJSONpath(response, "place_Id");
		res=given().spec(requestSpecification()).queryParam("place_Id", place_Id);
		user_calls_with_http_request(resource,"GET");
		String actualname=getJSONpath(response, "name");
		assertEquals(actualname,expName);
		
	    
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) 
	{
	   assertEquals(getJSONpath(response, keyValue),Expectedvalue);
	   
	}
	
	@Given("DeletePlace payload")
    public void deleteplace_payload() throws IOException 
	{
		res=given().spec(requestSpecification())
		.body(testData.deletePlacePayload(place_Id)) ;
        
    }
	

}
