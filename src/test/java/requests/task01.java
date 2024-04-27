package requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class task01 {
//    / Base URL should be used as Spec
// Given https://gorest.co.in/public/v2/todos/47900
// When user send Request via GET Method
// Then Assert that Status Code is "200"
// And Assert that Content Type is "application/json"
// And Assert that Response Body is as follows:
//    {
//        "id": 47900,
//            "user_id": 6861183,
//            "title": "Et minus libero aegrotatio teres quia.",
//            "due_on": "2024-04-25T00:00:00.000+05:30",
//            "status": "pending"
//    }
    @Test
    public void task01(){
        Response response = given().get("https://gorest.co.in/public/v2/todos/47900");
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType("application/json");

        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.getInt("data.id");
        String title = jsonPath.getString("data.title");
        String due_on = jsonPath.getString("data.due_on");
        String status = jsonPath.getString("data.status");


        // Do assertion
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(id , 47900);
        softAssert.assertEquals(title , "Et minus libero aegrotatio teres quia.");
        softAssert.assertEquals(due_on , "2024-04-25T00:00:00.000+05:30");
        softAssert.assertEquals(status , "#pending");

        softAssert.assertAll();
    }
}
