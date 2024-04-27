package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C18_PostRequestPojo extends JsonPlaceHolderBaseUrl {
/*
     Given
        https://jsonplaceholder.typicode.com/todos
        {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestPojoTest(){
        //Set the url
        spec.pathParams("first","todos");

        //Set the expected data --> With Pojo Class
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPlaceHolderPojo actualDa = response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualDa = " + actualDa);

        assertEquals(response.statusCode(), 201);
        assertEquals(actualDa.getUserId(), expectedData.getUserId());
        assertEquals(actualDa.getTitle(), expectedData.getTitle());
        assertEquals(actualDa.getCompleted(), expectedData.getCompleted());


    }


}