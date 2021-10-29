package com.example.demo.controller;

import com.example.demo.model.HelloResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RestControllerTest {
    @PostMapping("/test")
    public ResponseEntity<Object> testPost() {
        return ResponseEntity.ok(new HelloResponse("hello POST"));
    }

    @GetMapping("/test")
    public ResponseEntity<Object> testGet() {
        return ResponseEntity.ok(new HelloResponse("hello GET"));
    }

    @PutMapping("/test2")
    public ResponseEntity<Object> testPut() {
        return ResponseEntity.ok(new HelloResponse("hello PUT"));
    }

    @GetMapping("/test2")
    public ResponseEntity<Object> testGetTest2() {
        return ResponseEntity.ok(new HelloResponse("hello GET test2"));
    }
}
