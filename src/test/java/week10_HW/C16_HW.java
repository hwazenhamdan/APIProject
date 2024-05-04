package week10_HW;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import static org.hamcrest.Matchers.equalTo;

public class C16_HW {
    //Write an automation test that will add a 'contact' then read, update and delete the created contact then negative assert the deleted contact
    // using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
    }

    @Test

    public void CreateUser() {
        String requestBody = """
                {
                      "firstName": "manila",
                      "lastName": "barry",
                      "birthdate": "1999-04-06",
                      "email": "manila_bb@gmail.com",
                      "phone": "+1345544443",
                      "street1": "1 Main St.",
                      "street2": "Apartment A",
                      "city": "Leenz",
                      "stateProvince": "US",
                      "postalCode": "24246",
                      "country": "Austria"
                  }""";


        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/contacts");

      //  userId = response.jsonPath().getString("_id");

        response.then().statusCode(200);
    }

    @Test
    public void ReadUser() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/contacts/")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("manila"))
                .body("lastName", equalTo("barry"))
                .body("birthdate", equalTo("1999-04-06"))
                .body("email", equalTo("manila_bb@gmail.com"))
                .body("phone", equalTo("+1345544443"))
                .body("street1", equalTo("1 Main St."))
                .body("street2", equalTo("Apartment A"))
                .body("city", equalTo("Leenz"))
                .body("stateProvince", equalTo("KS"))
                .body("postalCode", equalTo("12345"))
                .body("country", equalTo("Austria"));



    }

    @Test
    public void UpdateUser() {
        String requestBody = """
                {
                    "firstName": "manilaup",
                    "lastName": "barryup",
                    "birthdate": "1999-02-01",
                    "email": "manila_up@gmail.com",
                    "phone": "+1345544443",
                    "street1": "13 School St.",
                    "street2": "Apt. 5",
                    "city": "Leenz",
                    "stateProvince": "QC",
                    "postalCode": "23543",
                    "country": "Austria"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/contacts/")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("manilaup"))
                .body("lastName", equalTo("barryup"))
                .body("birthdate", equalTo("1999-02-01"))
                .body("email", equalTo("manila_up@gmail.com"))
                .body("phone", equalTo("+1345544443"))
                .body("street1", equalTo("13 School St."))
                .body("street2", equalTo("Apt. 5"))
                .body("city", equalTo("Leenz"))
                .body("stateProvince", equalTo("QC"))
                .body("postalCode", equalTo("23543"))
                .body("country", equalTo("Austria"));

    }

    @Test
    public void DeleteUser() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/contacts/")
                .then()
                .statusCode(200);
    }
}

