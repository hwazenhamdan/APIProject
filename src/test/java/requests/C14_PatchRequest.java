package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class C14_PatchRequest extends JsonPlaceHolderBaseUrl {
    /*
        Given
            1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                 "title": "Read Books"
               }
        When
            I send PATCH Request to the Url
        Then
           Status code is 200
           And response body is like  {
                                            "userId": 10,
                                            "id": 198,
                                            "title": "Read Books",
                                            "completed": true
                                        }
    */
    @Test
    public void patchRequestTest() {

        //Set the url
        spec.pathParams("first", "todos", "second", "198");

        //Set the expected data
        Map<String, Object> expectedData = JsonPlaceHolderTestData.expectedDataMap(null, "Read Books", null);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(Map.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        //We only need to assert what we changed
        assertEquals(actualData.get("title"), expectedData.get("title"));

        //If we need to assert whole body:
        assertEquals(actualData.get("userId"), 10);
        assertEquals(actualData.get("completed"), true);

    }

}