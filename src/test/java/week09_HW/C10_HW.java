package week09_HW;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class C10_HW {

    // Using the https://petstore.swagger.io/ document,
    // write an automation test that finds the number of "pets" with the status "available"
    // and asserts that there are more than 100.
    @Test
    public void Homework10() {

        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();

        int availableCount = response.jsonPath().getList("findAll { it.status == 'available' }").size();
        assertTrue(availableCount > 100,"The pets is not more than 100");


    }
}
