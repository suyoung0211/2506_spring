package org.iclass.spring_4restapi.controller;

import java.util.List;
import java.util.Map;

import org.iclass.spring_4restapi.dto.BuyDto;
import org.iclass.spring_4restapi.dto.CustomerBuyDto;
import org.iclass.spring_4restapi.service.BuyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
@AllArgsConstructor
public class BuyRestController {
    private BuyService service;

    @GetMapping("/api/buy/{customerid}")
    public ResponseEntity<List<BuyDto>> selectByCustomer(@RequestParam String customerid) {
        return ResponseEntity.ok().body(service.selectByCustomer(customerid));
    }
    
    @GetMapping("/api/buy/{pcode}")
    public ResponseEntity<List<BuyDto>> selectByPcode(@RequestParam String pcode) {
        return ResponseEntity.ok().body(service.selectByPcode(pcode));
    }

    @GetMapping("/api/buy/{year}")
    public ResponseEntity<List<BuyDto>> selectByYear(@RequestParam String year) {
        return ResponseEntity.ok().body(service.selectByYear(year));
    }

    @GetMapping("/api/buy/sum/{pcode}")
    public ResponseEntity<?> selectSumByPcode(@RequestParam String pcode) {
        int result = service.selectSumByPcode(pcode);
        return ResponseEntity.ok().body(Map.of(pcode, result));
    }

    @GetMapping("/api/buy/sale/{customerid}")
    public ResponseEntity<List<CustomerBuyDto>> selectSaleByCustomer(@RequestParam String customerid) {
        return ResponseEntity.ok().body(service.selectSaleByCustomer(customerid));
    }

    @GetMapping("/api/buy/count/{year}")
    public ResponseEntity<?> selectCountByYear(@RequestParam String year) {
        return ResponseEntity.ok().body(service.selectCountByYear(year));
    }

    @GetMapping("/api/buy/count")
    public ResponseEntity<?> selectAllCountByYear() {
        return ResponseEntity.ok().body(service.selectAllCountByYear());
    }
    
    
    
    
    
    

}
