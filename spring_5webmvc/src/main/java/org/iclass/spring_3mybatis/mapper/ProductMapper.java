package org.iclass.spring_3mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_3mybatis.dto.ProductDto;
import org.iclass.spring_3mybatis.dto.ProductSearchDto;

@Mapper     // 설정의 xml 파일로 구현체 정읳바니다. -> 빈 생성
public interface ProductMapper {
    List<ProductDto> selectAll();

    List<ProductDto> searchAll(ProductSearchDto dto);

    ProductDto selectByPk(String pcode);

    List<ProductDto> selectByKeyword(String keyword);

    int insert(ProductDto dto);

    int update(ProductDto dto);

    int delete(String pcode);
}
