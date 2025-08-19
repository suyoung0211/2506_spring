package org.iclass.spring_5webmvc.controller;

import java.util.List;

import org.iclass.spring_3mybatis.dto.BuyDto;
import org.iclass.spring_3mybatis.mapper.BuyMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class TestController_Buy {
    private BuyMapper buyMapper;
    
    @GetMapping("/buy/list")
    public String buyList(Model model) {
        List<BuyDto> list = buyMapper.selectAll();
        model.addAttribute("list", list);
        return "/buy/list";
    }
    
}
