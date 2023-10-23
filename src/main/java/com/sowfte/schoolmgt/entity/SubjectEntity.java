package com.sowfte.schoolmgt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @ManyToMany
//    @JoinTable(
//            name = "subject_school",
//            joinColumns = @JoinColumn(name = "sub_id"),
//            inverseJoinColumns = @JoinColumn(name = "sch_id")
//    )
//    private Set<SchoolEntity> schoolOfferingSubject= new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "tutor_id",
            referencedColumnName = "id"
    )
    private TeacherEntity tutor;
    @ManyToMany
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "sub_id"),
            inverseJoinColumns = @JoinColumn(name = "stud_id")
    )
    private Set<StudentEntity> enrolledStudent= new HashSet<>();

public  void enrolledStudent(StudentEntity studentPayload){
    enrolledStudent.add(studentPayload);
}

}
