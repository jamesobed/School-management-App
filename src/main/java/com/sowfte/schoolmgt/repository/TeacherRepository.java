package com.sowfte.schoolmgt.repository;

import com.sowfte.schoolmgt.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository <TeacherEntity, Long> {
}
