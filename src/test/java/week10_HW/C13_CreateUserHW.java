package week10_HW;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;
import pojos.pojo_Hw13;


public class C13_CreateUserHW {
    //Write an automation test that will create a 'user' then read, update and delete the created user
    // using the "https://petstore.swagger.io/" document. (Create a classes for each request.)
    protected RequestSpecification spec;
    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();

    }
    @Test
    public void CreateUser(){
        spec.pathParams("first", "user");
        String strJson = """
                {
                  "id": 4532,
                  "username": "manila_9",
                  "firstName": "manila",
                  "lastName": "barry",
                  "email": "manila_bb@gmail.com",
                  "password": "56783",
                  "phone": "+1536789876",
                  "userStatus": 1
                }
                """;

        pojo_Hw13 expectedData = ObjectMapperUtils.convertJsonToJava(strJson, pojo_Hw13.class);
        System.out.println("expectedData = " + expectedData);

        Response response = RestAssured.given(spec)
                .contentType("application/json")
                .body(strJson).post("{first}");
                response.prettyPrint();

        response
                .then()
                .statusCode(200);


    }
}
