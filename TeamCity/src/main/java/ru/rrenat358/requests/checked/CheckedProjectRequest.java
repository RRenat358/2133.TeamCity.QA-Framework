package ru.rrenat358.requests.checked;

import org.apache.http.HttpStatus;
import ru.rrenat358.models.Project;
import ru.rrenat358.models.User;
import ru.rrenat358.requests.CrudInterface;
import ru.rrenat358.requests.unchecked.UncheckedProjectRequest;

import static io.restassured.RestAssured.given;

public class CheckedProjectRequest implements CrudInterface {

//    public static final String PROJECT_ENDPOINT = "/app/rest/projects";

    private User user;

    public CheckedProjectRequest(User user) {
        this.user = user;
    }

    @Override
    public Project create(Object object) {
        return new UncheckedProjectRequest(user).create(object)
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
