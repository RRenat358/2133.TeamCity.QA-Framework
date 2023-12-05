package ru.rrenat358.TestData;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.rrenat358.models.NewProjectDescription;
import ru.rrenat358.models.User;
import ru.rrenat358.requests.unchecked.UncheckedProjectRequest;


@Data
@Builder
public class DataEntity {

    private User user;

//    private Project project;
    public NewProjectDescription newProjectDescription;



    public void deleteNewProjectDescription() {
        new UncheckedProjectRequest(user).delete(newProjectDescription.getId());
    }
}
