package com.sowfte.schoolmgt.repository;

import com.sowfte.schoolmgt.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <StudentEntity, Long> {
}
