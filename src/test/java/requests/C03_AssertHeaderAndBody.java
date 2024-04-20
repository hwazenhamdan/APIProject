package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C03_AssertHeaderAndBody {

/*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User sends a GET Request to the URL
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "Clarusway"
   And
       Server is "Cowboy"
*/

    @Test
    void assertionMethod() {
//        https://restful-booker.herokuapp.com/booking/0
//        User sends a GET Request to the URL
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/0");
        //response.prettyPrint();

//        HTTP Status code should be 404
//        Status Line should be HTTP/1.1 404 Not Found
//        Server is "Cowboy"

        //1st way: We can assert headers with method chain.
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "Cowboy");

        //2nd way:
        int statusCode = response.statusCode();
        assertEquals(statusCode, 404);

        String statusLine = response.statusLine();
        assertEquals(statusLine, "HTTP/1.1 404 Not Found");

        String server = response.header("Server");
        assertEquals(server, "Cowboy");

//        Response body contains "Not Found"
        String stringBody = response.asString();
        System.out.println("stringBody = " + stringBody);
        boolean isContain = stringBody.contains("Not Found");
        assertTrue(isContain);//If the boolean value between parenthesis is TRUE test will pass

//        Response body does not contain "Clarusway"
        assertFalse(stringBody.contains("Clarusway"));//If the boolean value between parenthesis is FALSE test will pass

    }


}