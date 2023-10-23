package com.sowfte.schoolmgt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String studentEmail;
    private String studentName;
    private String studentAddress;
    private String studentDepartment;
    private String studentClass;
}
