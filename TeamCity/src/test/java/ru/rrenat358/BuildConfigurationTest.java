package ru.rrenat358;


import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import ru.rrenat358.models.NewProjectDescription;
import ru.rrenat358.models.Project;
import ru.rrenat358.models.User;
import ru.rrenat358.requests.checked.AuthRequest;
import ru.rrenat358.requests.checked.CheckedProjectRequest;
import ru.rrenat358.specifications.RestSpec;

public class BuildConfigurationTest extends BaseApiTest {


    @Test
    public void buildConfiguration() {

        var user = User.builder()
                .username("user01")
                .password("1111")
                .build();

//        String token = RestAssured.get("http://user01:1111@localhost:8111/authenticationTest.html?csrf")
//        String token = new AuthRequest(user).getTokenFromUser();
//        System.out.println(token);

        var projectDescription = NewProjectDescription
                .builder()
                .parentProject(Project.builder()
                        .locator("_Root")
                        .build())
                .name("Project-02")
                .id("P02")
                .copyAllAssociatedSettings(true)
                .build();

        var project = new CheckedProjectRequest(user).create(projectDescription);





    }


}
