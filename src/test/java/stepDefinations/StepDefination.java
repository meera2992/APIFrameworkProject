package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import resources.APIResources;
import resources.Utils;

public class StepDefination extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    static String launches_name;


    @Given("Url")
    public void add_Place_Payload_with() throws IOException {
        res = given().spec(requestSpecification());
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if (method.equalsIgnoreCase("POST"))
            response = res.when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource());

    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {

        assertEquals(getJsonPath(response, keyValue), Expectedvalue);
    }

   /* @Then("verify launch_Name created maps to {string} ")
    public void verify_launches_created_maps_to_using(String expectedName[]) throws IOException {
    	launches_name = getJsonPath(response, "launch_Name");
        res = given().spec(requestSpecification()).queryParam("launch_Name", launches_name);
        String actualName = getJsonPath(response, "name");
        assertEquals(actualName, expectedName);

    }
*/
    @Then("verify launches From response received")
    public void verify_launches_created_maps_to_using()  {
        ArrayList<String> crew_launch = response.path("crew");
        for(String crew1: crew_launch){
            System.out.println(crew1);
        }
        ArrayList<String> ships_launch = response.path("ships");
        for(String ships1: ships_launch){
            System.out.println(ships1);
        }
        ArrayList<String> capsules_launch = response.path("capsules");
        for(String capsules1: capsules_launch){
            System.out.println(capsules1);
        }
        ArrayList<String> payloads_launch = response.path("payloads");
        for(String payloads1: payloads_launch){
            System.out.println(payloads1);
        }

        HashMap<String, String> hMapData = new HashMap<String, String>();
        hMapData = response.path("cores");
        for (Map.Entry<String,String> entry : hMapData.entrySet())
        {
            System.out.println("CoreLaunchProperty: " + entry.getKey() + ", CoreLaunchValue: " + entry.getValue());
        }
    }
}
