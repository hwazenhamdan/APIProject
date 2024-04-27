package week09_HW;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class C11_HW {
     /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/
     @Test
     public void Homework11(){
         //sends  request
         Response response = RestAssured.get("https://automationexercise.com/api/productsList");

         //Print response
         response.jsonPath().prettyPrint();

         // Assert that the number of "Women" user type is 12
         int womenUser = response.jsonPath().getList("products.findAll { it.category.usertype.usertype == 'Women' }").size();
         assertEquals(womenUser, 12);
     }
}
