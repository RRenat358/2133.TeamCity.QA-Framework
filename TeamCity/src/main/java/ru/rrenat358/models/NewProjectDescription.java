package ru.rrenat358.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProjectDescription {

    private String id;
    private String name;

    private Project parentProject;

    private Boolean copyAllAssociatedSettings;


}
