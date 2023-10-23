package com.sowfte.schoolmgt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class TeacherEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String address;
    private String department;

    @JsonIgnore
    @OneToMany (mappedBy = "tutor")
    private Set<SubjectEntity> subjects = new HashSet<>();

}
