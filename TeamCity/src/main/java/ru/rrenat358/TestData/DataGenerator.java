package ru.rrenat358.TestData;


import ru.rrenat358.models.NewProjectDescription;
import ru.rrenat358.models.Project;
import ru.rrenat358.models.User;

public class DataGenerator {


    public DataEntity entityDataGenerator() {

        var user = User.builder()
                .username("user01")
                .password("1111")
                .build();


        var projectDescription = NewProjectDescription
                .builder()
                .parentProject(Project.builder()
                        .locator("_Root")
                        .build())
                .name(DataRandomizer.getString_Test_5_AZ())
                .id(DataRandomizer.getString_Test_3_09())
                .copyAllAssociatedSettings(true)
                .build();

        return DataEntity.builder()
                .user(user)
                .newProjectDescription(projectDescription)
                .build();

    }



}
