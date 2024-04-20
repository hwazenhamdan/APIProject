package week08_HW;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import test_data.JsonPlaceTestData_HW;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;


import java.util.Map;

public class C08_HW extends JsonPlaceTestData_HW {
      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
      @Test
      public void Homework08(){

            Map<String, Object> expectedData
                    = JsonPlaceTestData_HW.expectedDataMap("morpheus","leader", 496 ,"2022-10-04T15:18:56.372Z");

            io.restassured.response.Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(expectedData)
                    .post("https://reqres.in/api/users");
            response.prettyPrint();


            //Do assertion
            response
                    .then()
                    .statusCode(201)
                    .body("name", equalTo(expectedData.get("name"))
                            ,"job", equalTo(expectedData.get("job"))
                            ,"id",equalTo(expectedData.get("id"))
                            ,"createdAt",equalTo(expectedData.get("createdAt"))
                    );

      }

}
