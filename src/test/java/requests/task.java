package requests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.asm.Advice;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class task {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("X-RapidAPI-Key","193fe7b932mshd018473dd984abbp13ba61jsn7f8835a09401").
                addHeader("X-RapidAPI-Host","community-zippopotamus.p.rapidapi.com").setBaseUri("https://community-zippopotamus.p.rapidapi.com").build();
    }
@Test
    public void as(){
    String requestBody = """
            {
                "post code": "90210",
                "country": "United States",
                "country abbreviation": "US",
                "places": [
                    {
                        "place name": "Beverly Hills",
                        "longitude": "-118.4065",
                        "state": "California",
                        "state abbreviation": "CA",
                        "latitude": "34.0901"
                    }
                ]
            }""";
   // spec.pathParams("first","90210","second","us");


    HashMap<String, Object>expectedData= ObjectMapperUtils.convertJsonToJava(requestBody,HashMap.class);

    System.out.println("expectedData="+expectedData);

    Response response = given().get("https://community-zippopotamus.p.rapidapi.com");
    response.prettyPrint();

    HashMap<String, Object>AData=ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
    System.out.println("Actual Data:"+ AData);

    assertEquals(expectedData.get("post code"),AData.get("post code"));
    assertEquals(expectedData.get("country"),AData.get("country"));
   // assertEquals(expectedData.get("place name"),AData.get("place name"));
   // assertEquals(expectedData.get("state"),AData.get("state"));
}

}
