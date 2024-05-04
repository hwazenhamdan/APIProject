package week10_HW;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class C14_HW {
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */
    protected RequestSpecification spec;
    int maxAge = 0;
    @BeforeMethod
    public void setSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com/api/v1")
                .setContentType(ContentType.JSON)
                .build();

    }
    @Test
    public void Homework14(){
        spec.pathParams("first", "employees");


        Response response = given(spec).get("{first}");
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .body("data", hasSize(24)//the number of employees
                        ,"data.employee_name",hasItems("Tiger Nixon","Garrett Winters")
                        ,"data.employee_age.max()", equalTo(66)
                        ,"data.find { it.employee_age == 19 }.employee_name", equalTo("Tatyana Fitzpatrick")
                        ,"data.employee_salary.sum()", equalTo(6644770));



    }
}
