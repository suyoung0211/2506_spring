package org.iclass.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.board.dto.CommunityCommentDTO;
import org.iclass.board.service.CommunityCommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class CommunityCommentsController {
/* 
 * URL (EndPoint)
 * /api/commets -> 댓글 추가
 * /api/commets/{idx} -> 댓글 삭제
 * /api/commets/{mref} -> 메인글 댓글 목록
 */

    private CommunityCommentsService service;
    
    @PostMapping("/api/comments")
    public ResponseEntity<?> save(@Valid @RequestBody CommunityCommentDTO dto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            bindResult.getFieldErrors().forEach(err -> {
            map.put(err.getField(), err.getDefaultMessage());
        });
      log.info("map : {}", map);
      return ResponseEntity.badRequest().body(map);
    }
        int result = service.insert(dto);
        
        // 잘못된 값으로 예외가 생기면 Exception  처리하는 코드가 필요
        // (@Valid, dto 에 검증할 내용 작성)
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("success", result));
    }

    @DeleteMapping("/api/comments/{idx}/{mref}")
    public ResponseEntity<?> delete(@PathVariable int idx, @PathVariable int mref) {
        int result = service.delete(idx, mref);
        // idx 를 없는 값을 처리한다면 result 는 0. 없는 댓글 삭제

        if (result ==1) {
            return ResponseEntity.ok().body(Map.of("success", result));
        } else {
            return ResponseEntity.badRequest().body(Map.of("no content", result));
        }
    }
    
    @GetMapping("/api/comments/{mref}")
    public ResponseEntity<List<CommunityCommentDTO>> list(@PathVariable int mref) {
        return ResponseEntity.ok().body(service.selectCommentList(mref));
    }
}