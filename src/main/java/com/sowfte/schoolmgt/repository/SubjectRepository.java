package com.sowfte.schoolmgt.repository;

import com.sowfte.schoolmgt.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository <SubjectEntity, Long> {
}
