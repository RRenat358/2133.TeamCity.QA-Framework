package ru.rrenat358.TestData;


import ru.rrenat358.models.NewProjectDescription;
import ru.rrenat358.models.Project;
import ru.rrenat358.models.User;

public class GeneratorData {

    public EntityData entityDataGenerator() {

        var user = User.builder()
                .username("user01")
                .password("1111")
                .build();


        var projectDescription = NewProjectDescription
                .builder()
                .parentProject(Project.builder()
                        .locator("_Root")
                        .build())
                .name(RandomData.getString())
                .id(RandomData.getString())
                .copyAllAssociatedSettings(true)
                .build();

        return EntityData.builder()
                .user(user)
                .newProjectDescription(projectDescription)
                .build();



    }



}
