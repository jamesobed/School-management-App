package com.sowfte.schoolmgt.controller;

import com.sowfte.schoolmgt.dto.SchoolDto;
import com.sowfte.schoolmgt.dto.TeacherDto;
import com.sowfte.schoolmgt.entity.SchoolEntity;
import com.sowfte.schoolmgt.entity.TeacherEntity;
import com.sowfte.schoolmgt.service.SchoolService;
import com.sowfte.schoolmgt.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@AllArgsConstructor
public class School {
    private final SchoolService service;

    @GetMapping("/all-schools")
    public ResponseEntity<List<SchoolEntity>> getAllSchool(){
        var response = service.getAllSchool();
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolEntity> getOneSchool(@PathVariable Long id){
        var response = service.getSchool(id);
        return  ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<SchoolEntity> registerSchool(@RequestBody SchoolDto payload){
        var response = service.registerSchool(payload);
        return  ResponseEntity.ok(response);
    }
}
