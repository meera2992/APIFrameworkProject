Feature: Get SpaceX latest launches

@GetLaunches
Scenario: Get SpaceX latest launches
	Given Url
	When user calls "GetLatestLaunchesAPI" with "GET" http request
	Then the API call got success with status code 200
	#And "status" in response body is "OK"
	And verify launches From response received

#Other Scenarios as Belows:
	#Scenarion2: verify id of each launch get api from response

	#Scenarion3: verify All the launches get api from response
	#verify there properties and correspond values

	#Scenarion4: Verify in Response from GET API for related names, marks, emblems and images are registered trademarks of their respective owners.
	#verify there properties and correspond values

	#Scenarion5: Verify launch success in Response from GET API

   #Scenarion6: Verify launch failures in Response from GET API

 	#Scenarion7: Verify launch Dates Times in Response from GET API

	

	
	
	
	
	
	

	
	
	