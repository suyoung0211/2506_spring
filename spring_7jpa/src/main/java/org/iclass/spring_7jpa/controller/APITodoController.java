package org.iclass.spring_7jpa.controller;

import java.util.Map;

import org.iclass.spring_7jpa.dto.TodoDto;
import org.iclass.spring_7jpa.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@AllArgsConstructor
@RestController
public class APITodoController {
    private TodoService service;

    // POST /api/todos
    @PostMapping("/api/todos")
    public ResponseEntity<?> write(@RequestBody TodoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.write(dto));
    }

    // GET /api/todos/{username}
    @GetMapping("/api/todos/{username}")
    public ResponseEntity<?> getMethodName(@PathVariable String username) {
        if (!service.validUser(username)) {
            return ResponseEntity.badRequest().body(Map.of("message", "존재하지 않는 username 입니다."));
        }
        return ResponseEntity.ok().body(service.userList(username));
    }
}
