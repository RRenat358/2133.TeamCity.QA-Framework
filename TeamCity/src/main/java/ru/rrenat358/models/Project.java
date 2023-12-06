package ru.rrenat358.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    private String id;
    private String name;
    private String parentProjectId;
    private String locator;


}
