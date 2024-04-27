package week09_HW;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class C09_HW {
    /*
        Given
            1) https://petstore.swagger.io/v2/user

        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                               {
  "id": 1,
  "username": "john01",
  "firstName": "John",
  "lastName": "Doe",
  "email": "John101@gmail.com",
  "password": "123456",
  "phone": "654321",
  "userStatus": 1
}
                                              }
     */
    @Test
    public void Homework09(){
        String requestBody = """
                {
                     "id": 1,
                     "username": "john01",
                     "firstName": "John",
                     "lastName": "Doe",
                     "email": "John101@gmail.com",
                     "password": "123456",
                     "phone": "654321",
                     "userStatus": 1
                }""";

        //Send the request and post the response
        io.restassured.response.Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();

        // Assertions
        response
                .then()
                .statusCode(200)
                .body("message", equalTo("1")
                );

    }
}
