package com.sowfte.schoolmgt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String studentEmail;
    private String studentName;
    private String studentAddress;
    private String studentDepartment;
    private String studentClass;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudent")
    private Set<SubjectEntity> subjects = new HashSet<>();
}
