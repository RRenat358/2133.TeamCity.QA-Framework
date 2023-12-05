package ru.rrenat358.requests.checked;

import org.apache.http.HttpStatus;
import ru.rrenat358.models.Project;
import ru.rrenat358.models.User;
import ru.rrenat358.requests.CrudProject;
import ru.rrenat358.requests.unchecked.UncheckedProjectRequest;

import static io.restassured.RestAssured.given;

public class CheckedProjectRequest implements CrudProject {

//    public static final String PROJECT_ENDPOINT = "/app/rest/projects";

    private User user;

    public CheckedProjectRequest(User user) {
        this.user = user;
    }

    @Override
    public Project create(Object object) {
        return new UncheckedProjectRequest(user)
                .create(object)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class);
    }

    @Override
    public Object get(Object object) {
        return new UncheckedProjectRequest(user)
                .get(object)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class);
    }


    @Override
    public Object update(Object id, Object object) {
        return new UncheckedProjectRequest(user)
                .update(id, object)
//                .equals(HttpStatus.SC_OK)
//                .then()
//                .toString()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .extract().as(Project.class)
                ;
    }

    @Override
    public Object delete(Object object) {
        return new UncheckedProjectRequest(user)
                .delete(object)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
    }



}
