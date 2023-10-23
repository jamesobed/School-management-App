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
public class SchoolEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String schoolLocation;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "schoolOfferingSubject")
//    private Set<SubjectEntity> schoolSubject = new HashSet<>();


}
