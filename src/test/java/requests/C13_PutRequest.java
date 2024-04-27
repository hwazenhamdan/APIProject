package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C13_PutRequest extends JsonPlaceHolderBaseUrl {
/*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "userId": 21,
             "title": "Read Books",
             "completed": false
           }
    When
        I send a PUT request to the URL
    Then
       the status code should be 200
       And the response body should be like:
       {
          "completed": false,
          "title": "Read Books",
          "userId": 21,
          "id": 198
       }
*/

    @Test
    public void putRequestTest() {
        //Set the url
        spec.pathParams("first", "todos", "second", "198");

        //Set the expected data
        Map<String, Object> expectedData = JsonPlaceHolderTestData.expectedDataMap(21, "Read Books", false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(Map.class);//De-Serialization --> We convert Json response into Java Object(Map)
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.get("completed"), expectedData.get("completed"));
        assertEquals(actualData.get("title"), expectedData.get("title"));
        assertEquals(actualData.get("userId"), expectedData.get("userId"));


    }

}