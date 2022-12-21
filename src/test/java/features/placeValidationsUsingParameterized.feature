Feature: Validating place API's

@AddPlace
Scenario Outline: Verify if place is successfully added using AddPlaceAPI

	Given Add Place Payload "<Name>" "<Language>" "<Address>"
	When user calls "AddPlaceAPI" with "POST" httpRequest 
	Then the API call got success with status code 200
	And verify place_Id created on Maps to "<Name>" using "getPlaceAPI"
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
	
	#Multiple data sets always with the Keyword-examples
	Examples:
		|Name|    	|Language|      |Address|
		|Bharat| 	 |Telugu|	 	|1 colony|
		#|Chinnu|     |English|	    |2 colony|
		#|Bokka|		 |Orey| 		|Neku Colony Ledu|


@DeletePlace		
Scenario: Verify if Delete Place functionality is working
		Given DeletePlace payload
		When user calls "deletePlaceAPI" with "POST" httpRequest
		Then the API call got success with status code 200
		And "status" in response body is "OK"