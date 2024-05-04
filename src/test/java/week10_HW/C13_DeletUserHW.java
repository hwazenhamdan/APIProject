package week10_HW;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C13_DeletUserHW {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();

    }
    @Test
    public void DeletUser(){
        spec.pathParam("first", "user").pathParam("second", "david");

        Response response = given()
                .contentType("application/json")
                .when()
                .delete("/first/second")
                .then()
                .extract().response();

        response.then().statusCode(200);


    }
}
