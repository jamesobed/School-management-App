package com.sowfte.schoolmgt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private String email;
    private String name;
    private String phone;
    private String address;
    private String department;
}
