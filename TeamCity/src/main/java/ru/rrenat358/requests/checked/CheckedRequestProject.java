package ru.rrenat358.requests.checked;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import ru.rrenat358.models.Project;
import ru.rrenat358.models.User;
import ru.rrenat358.requests.CrudInterface;
import ru.rrenat358.requests.unchecked.UncheckedRequestProject;
import ru.rrenat358.specifications.RestSpec;

import static io.restassured.RestAssured.given;

public class CheckedRequestProject implements CrudInterface {

//    public static final String PROJECT_ENDPOINT = "/app/rest/projects";

    private User user;

    public CheckedRequestProject(User user) {
        this.user = user;
    }

    @Override
    public Project create(Object object) {
        return new UncheckedRequestProject(user).create(object)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class);
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
    public Object delete(Object object) {
        return null;
    }



}
