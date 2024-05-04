package week10_HW;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojos.pojo_Hw13;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C13_UpdateUserHW {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();

    }
    @Test
    public void UpdateUser(){
        spec.pathParams("first", "user", "second", "amily");
        //Set the expected data
        String strJson = """
                            {
                              "id": 455332,
                              "username": "david_7",
                              "firstName": "rony",
                              "lastName": "david",
                              "email": "david76@gmail.com",
                              "password": "7857",
                              "phone": "+392123993",
                              "userStatus": 1
                            }
                """;

        Response response = given()
                .contentType("application/json")
                .body(strJson)
                .when()
                .put("{first}/{second}")
                .then()
                .extract().response();

                 response.prettyPrint();


    }
}
