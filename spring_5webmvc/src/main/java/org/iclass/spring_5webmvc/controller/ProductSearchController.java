package org.iclass.spring_5webmvc.controller;

import org.iclass.spring_3mybatis.dto.ProductSearchDto;
import org.iclass.spring_3mybatis.mapper.ProductMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class ProductSearchController {
    private ProductMapper productMapper;

    // 전체 목록
    @GetMapping("/product/searchAll")
    public String getMethodName(Model model) {
        model.addAttribute("pdList", productMapper.selectAll());
        return "product/searchAll";
    }

    // 검색을 위한 Post 요청 처리
    @PostMapping("/product/searchAll")
    public String searchAll(@ModelAttribute(name = "searchDto") ProductSearchDto dto, Model model) {
        model.addAttribute("pdList", productMapper.searchAll(dto));
        return "product/searchAll";
    }

}
