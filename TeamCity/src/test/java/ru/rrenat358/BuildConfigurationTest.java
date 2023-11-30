package ru.rrenat358;


import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import ru.rrenat358.models.User;
import ru.rrenat358.specifications.RestSpec;

public class BuildConfigurationTest extends BaseApiTest {


    @Test
    public void buildConfiguration() {

        var user = User.builder()
                .username("user01")
                .password("1111")
                .build();

//        String token = RestAssured.get("http://user01:1111@localhost:8111/authenticationTest.html?csrf")
        String token = RestAssured
                .given()
                .spec(RestSpec.getInstance().AuthSpec(user))
                .get("/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();

        System.out.println(token);

    }


}
