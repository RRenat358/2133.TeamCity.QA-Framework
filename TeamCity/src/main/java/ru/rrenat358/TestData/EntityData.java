package ru.rrenat358.TestData;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.rrenat358.models.NewProjectDescription;
import ru.rrenat358.models.Project;
import ru.rrenat358.models.User;



@Getter
@Setter
@Builder
public class EntityData {

    private User user;

//    private Project project;

    public NewProjectDescription newProjectDescription;


}
