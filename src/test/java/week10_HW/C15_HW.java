package week10_HW;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import static org.hamcrest.Matchers.equalTo;
public class C15_HW {
    //Write an automation test that will create a 'user' then read, update and delete the created user
    // using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.
    private String userId;
    private String token;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void CreateUser() {
        String requestBody = """
                        {
                         "firstName": "manila",
                         "lastName": "barry",
                         "email": "manila_bb@gmail.com",
                         "password": "56783"
                         }""";


        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users");

        userId = response.jsonPath().getString("_id");

        response.then().statusCode(200);
    }

    @Test
    public void ReadUser() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users/me")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("manila"))
                .body("lastName", equalTo("barry"))
                .body("email", equalTo("manila_bb@gmail.com"));


    }

    @Test
    public void UpdateUser() {
        String requestBody = """
                  {
                   "firstName": "manilaa",
                   "lastName": "barry",
                   "email": "manila_bb@gmail.com",
                   "password": "56783"
                                        }""";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/users/me")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("manila"))
                .body("lastName", equalTo("barry"))
                .body("email", equalTo("manila_bb@gmail.com"));
    }

    @Test
    public void DeleteUser() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/users/me")
                .then()
                .statusCode(200);
    }
}

