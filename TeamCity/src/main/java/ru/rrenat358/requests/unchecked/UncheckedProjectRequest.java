package ru.rrenat358.requests.unchecked;

import io.restassured.response.Response;
import ru.rrenat358.models.User;
import ru.rrenat358.requests.CrudInterface;
import ru.rrenat358.specifications.RestSpec;

import static io.restassured.RestAssured.*;

public class UncheckedProjectRequest implements CrudInterface {

    public static final String PROJECT_ENDPOINT = "/app/rest/projects";

    private User user;

    public UncheckedProjectRequest(User user) {
        this.user = user;
    }

    @Override
    public Response create(Object object) {
        return given()
                .spec(RestSpec.getInstance().authSpec(user))
                .body(object)
                .post(PROJECT_ENDPOINT);
    }

    @Override
    public Object get(String string) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public Response delete(Object object) {
        return given()
                .spec(RestSpec.getInstance().authSpec(user))
                .delete(PROJECT_ENDPOINT + "/id:" + object);
    }



}
