package week08_HW;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.List;

public class C07_HW {
      /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void Homework07(){

        Response response = RestAssured.get("https://reqres.in/api/unknown/");
        response.prettyPrint();

        //Status code is 200
        response.then().statusCode(200);

        JsonPath jsonPath = response.jsonPath();

        //Print all pantone_values
        List<String> pantoneValue = jsonPath.getList("data.pantone_value");
        System.out.println("pantone_value : " + pantoneValue);

        // Print all ids greater than 3 on the console ,Assert that there are 3 ids greater than 3
        List<Integer> idlist = jsonPath.getList("data.findAll { it.id > 3 }.id");
        System.out.println("ids Greater Than 3 : " + idlist);
        assertEquals(idlist.size(),3);

        // Print all names whose ids are less than 3 on the consol ,Assert that the number of names whose ids are less than 3 is 2
        List<String> names = jsonPath.getList("data.findAll { it.id < 3 }.name");
        System.out.println("names : " + names);
        assertEquals(names.size(), 2);
    }
}
