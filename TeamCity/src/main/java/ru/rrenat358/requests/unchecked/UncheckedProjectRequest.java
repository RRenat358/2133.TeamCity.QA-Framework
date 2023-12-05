package ru.rrenat358.requests.unchecked;

import io.restassured.response.Response;
import ru.rrenat358.models.User;
import ru.rrenat358.requests.CrudProject;
import ru.rrenat358.specifications.RestSpec;

import static io.restassured.RestAssured.*;

public class UncheckedProjectRequest implements CrudProject {

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
    public Response  get(Object string) {
        return given()
                .spec(RestSpec.getInstance().authSpec(user))
                .get(PROJECT_ENDPOINT + "/id:" + string);

    }

    @Override
    public Object update(Object id, Object object) {
        return given()
                .spec(RestSpec.getInstance().authSpec(user))
                .body(object)
                .put(PROJECT_ENDPOINT + "/id:" + id);
    }

    @Override
    public Response delete(Object object) {
        return given()
                .spec(RestSpec.getInstance().authSpec(user))
                .delete(PROJECT_ENDPOINT + "/id:" + object);
    }



}
