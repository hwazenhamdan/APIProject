package week08_HW;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class C05_HW {
      /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */
      @Test
      public void Homework05(){
            Response response = RestAssured.get("https://reqres.in/api/users/23");
            response.prettyPrint();

            //  HTTP Status code should be 404
            int statusCode = response.getStatusCode();
            assertEquals(statusCode, 404);

            // Status Line should be HTTP/1.1 404 Not Found
            String statusLine = response.getStatusLine();
            assertEquals(statusLine, "HTTP/1.1 404 Not Found");

            // Server is "cloudflare"
            String server = response.getHeader("Server");
            assertEquals(server, "cloudflare");

            // Response body should be empty
            String ResponseBody = response.getBody().asString();
            assertEquals(ResponseBody, "{}");

      }
}
