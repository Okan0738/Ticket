package com.okan.dto;

import com.okan.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private String projectName;
    private String projectDescription;
    private String ProjectCode;
    private UserDTO assignedManager;
    private LocalDateTime startedDate;
    private LocalDateTime endedDate;
    private String projectDetails;
    private Status status;


}
