package week08_HW;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class C03_HW {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void SimpleRequest(){

        Response response = RestAssured.get(" https://reqres.in/api/users/3");
        response.prettyPrint();
        // HTTP Status Code should be 200
        int StatusCode = response.statusCode();
        System.out.println("Status Code : "+StatusCode);

        //Content Type should be JSON
        String ContentType = response.contentType();
        System.out.println("Content Type is : "+ContentType);

        //Status Line should be HTTP/1.1 200 OK
        String StatusLine = response.statusLine();
        System.out.println("Status Line : "+StatusLine);


    }
}
