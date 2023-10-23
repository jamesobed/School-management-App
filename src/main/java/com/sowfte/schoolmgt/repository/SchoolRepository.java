package com.sowfte.schoolmgt.repository;

import com.sowfte.schoolmgt.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository <SchoolEntity, Long> {
}
