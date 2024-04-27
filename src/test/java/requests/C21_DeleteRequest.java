package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C21_DeleteRequest extends JsonPlaceHolderBaseUrl {

/*
    Given
        https://jsonplaceholder.typicode.com/todos/198
    When
        I send DELETE Request to the Url
    Then
        Status code is 200
        And Response body is { }
*/

    @Test
    public void deleteRequestTest(){
        //Set the url
        spec.pathParams("first","todos","second","198");

        //Set the expected data
        Map<Object, Object> expectedData = new HashMap<>();

        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");//First create a data and delete it. Do not delete some else's data.
        response.prettyPrint();

        //Do assertion
        Map<Object, Object> actualData = response.as(Map.class);
        System.out.println("actualData = " + actualData);

        //Assertion logic is up to you
        assertEquals(response.statusCode(), 200);
        //1st way:
        assertTrue(actualData.isEmpty());
        //2nd way:
        assertEquals(actualData, expectedData);
        //3rd way:
        assertEquals(actualData.size(), 0);
    }

}