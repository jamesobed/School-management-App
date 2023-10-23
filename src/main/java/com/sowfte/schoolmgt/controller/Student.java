package com.sowfte.schoolmgt.controller;

import com.sowfte.schoolmgt.dto.StudentDto;
import com.sowfte.schoolmgt.entity.StudentEntity;
import com.sowfte.schoolmgt.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class Student {
    private final StudentService service;

    @GetMapping()
    public ResponseEntity<String> home(){
        return  ResponseEntity.ok("Welcome to student management API");
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<StudentEntity>> getAllStud(){
        var response = service.getAllStud();
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getOneStud(@PathVariable Long id){
        var response = service.getStud(id);
        return  ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<StudentEntity> registerStud(@RequestBody StudentDto payload){
        var response = service.registerStud(payload);
        return  ResponseEntity.ok(response);
    }
}
