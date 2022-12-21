Feature: Validating place API's

Scenario: Verify if place is successfully added using AddPlaceAPI without paramters

	Given Add Place Payload
	When user calls AddPlaceAPI with POST httpRequest 
	Then the API call got success with status code 200
	And status is ok