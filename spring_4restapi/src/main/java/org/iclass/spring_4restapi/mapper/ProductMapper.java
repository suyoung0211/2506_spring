package org.iclass.spring_4restapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_4restapi.dto.ProductDto;

// dao 역할을 하는 인터페이스
@Mapper     // 설정의 xml 파일로 구현체 정의합니다. -> 빈 생성
public interface ProductMapper {
    ProductDto selectByPk(String pcode);

    List<ProductDto> selectByKeyword(String keyword);

    int insert(ProductDto dto);

    int update(ProductDto dto);

    int delete(String pcode);

}
