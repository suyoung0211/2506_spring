package org.iclass.spring_4restapi.controller;

import java.util.List;
import java.util.Map;

import org.iclass.spring_4restapi.dto.ProductDto;
import org.iclass.spring_4restapi.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Slf4j
@RestController
@AllArgsConstructor
public class ProductRestController {
    private ProductService service;

    @GetMapping("/api/products/{pcode}")
    public ResponseEntity<ProductDto> selectByPk(@RequestParam String pcode) {
        return ResponseEntity.ok().body(service.selectByPk(pcode));
    }

    @GetMapping("/api/product/keyword")
    public ResponseEntity<List<ProductDto>> selectByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok().body(service.selectByKeyword(keyword));
    }
    
    @PostMapping("/api/products")
    public ResponseEntity<?> insert(@RequestBody ProductDto dto) {
        try {
            int result = service.insert(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("success", result));
        } catch (Exception e) {
            log.info("insert 예외 : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));
        }
    }
    
    @PutMapping("/api/prodict/{pcode}")
    public ResponseEntity<?> update(@PathVariable String pcode, @RequestBody ProductDto dto) {
        try {
            int result = service.update(dto);
            return ResponseEntity.ok().body(Map.of("success", result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));
        }
    }

    @DeleteMapping("api/customer/{pcode}")
    public ResponseEntity<?> delete(@PathVariable String pcode) {
        int result = service.delete(pcode);
        try {
            return ResponseEntity.ok().body(Map.of("success", result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    

}
