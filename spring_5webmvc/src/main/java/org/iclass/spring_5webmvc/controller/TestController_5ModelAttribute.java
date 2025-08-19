package org.iclass.spring_5webmvc.controller;

import java.util.List;

import org.iclass.spring_3mybatis.dto.ProductDto;
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
public class TestController_5ModelAttribute {
    // 자동 주입 필요 -> 생성자
    private ProductMapper productMapper;

    // 연습
    @GetMapping("/product/list")
    public String product_list(Model model) {
        // 테이블에서 모든 행을 조회하여 애트립뷰트 저장 & view 로 전달
        List<ProductDto> pdList = productMapper.selectAll();
        model.addAttribute("pdList", pdList);
        return "product/list";  // "폴더명 / html 파일명"
    }

    @GetMapping("/product/search")
    public String search(@ModelAttribute(name = "keyword") String keyword, @ModelAttribute(name = "page") String page) {
        log.info("파라미터 : {}, {}", keyword, page);
        log.info("product/search.html 로 2개의 값을 keyword, pagd 애트리뷰트 이름으로 전달합니다.");
        return "/product/search";
    }
    
    @GetMapping("/product/search2")
    public String search2(@ModelAttribute ProductDto dto) {
        // 기본 애트리뷰트 이름은 productDto, 이름 변경은 name = "dto" 와 같이 합니다.
        log.info("파라미터 dto : {}", dto);
        log.info("product/search.html 로 dto 에 저장된 파라미터 값이 search.html 에 보이는지 확인하기");
        return "/product/search";
    }
    // @ModelAttribute 는 단일 파라미터에서는 잘 사용하지 않음, 주로 여러개 필드를 묶은 dto 에서 사용

    @PostMapping("/product/list")
    public String prod_search(@ModelAttribute(name = "keyword") String keyword, Model model) {
        log.info("ModelAttribute : {}", keyword);
        model.addAttribute("pdList", productMapper.selectByKeyword(keyword));
        return "product/list";
    }
    // @ModelAttribute : 파라미터 + 애트리뷰트, Model : 애트리뷰트 저장
}
