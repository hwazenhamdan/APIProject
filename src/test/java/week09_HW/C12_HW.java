package week09_HW;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.pojoPet_HW;

import static io.restassured.RestAssured.given;

public class C12_HW {
    //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
/*
{
    "id": 0,
    "category": {
        "id": 0,
        "name": "string"
    },
    "name": "doggie",
    "photoUrls": [
        "string"
    ],
    "tags": [
        {
            "id": 0,
            "name": "string"
        }
    ],
    "status": "available"
}
 */
    // Create a new pet and read it.
        @Test
        public void createPetTest() {
            String url = ("https://petstore.swagger.io/v2/pet");

            pojoPet_HW pet = new pojoPet_HW(4235,"doggie","available");
            Response response=
                    given()
                            .contentType(ContentType.JSON)
                            .body(pet).post(url);
                             response.prettyPrint();

                   }

    // Update pet.
    @Test
    public void updatePet() {
        String url = ("https://petstore.swagger.io/v2/pet");

        pojoPet_HW updatedPet = new pojoPet_HW(4554,"Jony","available");
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .body(updatedPet).put(url);
                         response.prettyPrint();
    }
    // Delete pet.
    @Test
    public void deletePet() {
        String url = ("https://petstore.swagger.io/");
        Response response=
                given().delete(url);
             response.prettyPrint();
    }

    }

