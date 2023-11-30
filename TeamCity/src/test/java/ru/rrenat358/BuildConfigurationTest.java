package ru.rrenat358;


import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class BuildConfigurationTest extends BaseApiTest {


    @Test
    public void buildConfiguration() {

        String token = RestAssured.get("http://user01:1111@localhost:8111/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
        System.out.println(token);

    }


}
