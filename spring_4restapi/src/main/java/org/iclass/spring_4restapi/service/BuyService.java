package org.iclass.spring_4restapi.service;

import java.util.List;
import java.util.Map;

import org.iclass.spring_4restapi.dto.BuyDto;
import org.iclass.spring_4restapi.dto.CustomerBuyDto;
import org.iclass.spring_4restapi.mapper.BuyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class BuyService {
    private BuyMapper mapper;

    public List<BuyDto> selectByCustomer(String customer_id) {
        return mapper.selectByCustomer(customer_id);
    }

    public List<BuyDto> selectByPcode(String pcode) {
        return mapper.selectByPcode(pcode);
    }

    public List<BuyDto> selectByYear(String year) {
        return mapper.selectByYear(year);
    }

    public int selectSumByPcode(String pcode) {
        return mapper.selectSumByPcode(pcode);
    }
    public List<CustomerBuyDto> selectSaleByCustomer(String cutomer_id) {
        return mapper.selectSaleByCustomer(cutomer_id);
    }

    public Map<String, Integer> selectCountByYear(String year) {
        return mapper.selectCountByYear(year);
    }

    public List<Map<String, Object>> selectAllCountByYear() {
        return mapper.selectAllCountByYear();
    }


}
