package com.sowfte.schoolmgt.controller;

import com.sowfte.schoolmgt.dto.TeacherDto;
import com.sowfte.schoolmgt.entity.TeacherEntity;
import com.sowfte.schoolmgt.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
public class Teacher {
    private final TeacherService service;

    @GetMapping("/all-teachers")
    public ResponseEntity<List<TeacherEntity>> getAllStud(){
        var response = service.getAllTeacher();
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherEntity> getOneStud(@PathVariable Long id){
        var response = service.getTeacher(id);
        return  ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<TeacherEntity> registerStud(@RequestBody TeacherDto payload){
        var response = service.registerTeacher(payload);
        return  ResponseEntity.ok(response);
    }
}
