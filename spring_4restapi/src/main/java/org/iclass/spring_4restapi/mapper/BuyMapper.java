package org.iclass.spring_4restapi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_4restapi.dto.BuyDto;
import org.iclass.spring_4restapi.dto.CustomerBuyDto;

// dao 역할을 하는 인터페이스
@Mapper
public interface BuyMapper {
  List<BuyDto> selectByCustomer(String customer_id);

  List<BuyDto> selectByPcode(String pcode);

  List<BuyDto> selectByYear(String year);

  int selectSumByPcode(String pcode);

  // join
  List<CustomerBuyDto> selectSaleByCustomer(String cutomer_id);

  // count 집계 합수
  Map<String, Integer> selectCountByYear(String year);
  
  // 
  List<Map<String, Object>> selectAllCountByYear();
  
}
