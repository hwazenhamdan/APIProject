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

public class C13_ReadUserHW {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();

    }
    @Test
    public void ReadUser(){
        String username = "testUser";
        //spec.pathParams("first", "user");
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/user/" + username)
                .then()
                .extract().response();

        response
                .then()
                .statusCode(200);

}}
