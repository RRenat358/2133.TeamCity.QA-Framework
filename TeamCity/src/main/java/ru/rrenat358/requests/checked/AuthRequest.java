package ru.rrenat358.requests.checked;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import ru.rrenat358.models.User;
import ru.rrenat358.specifications.RestSpec;

public class AuthRequest {

    private User user;

    public AuthRequest(User user) {
        this.user = user;
    }

    public String getTokenFromUser() {
        return RestAssured
                .given()
                .spec(RestSpec.getInstance().authSpec(user))
                .get("/authenticationTest.html?csrf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
    }
}
