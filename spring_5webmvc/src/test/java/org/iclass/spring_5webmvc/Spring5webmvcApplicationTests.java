package org.iclass.spring_5webmvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.iclass.spring_3mybatis.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Transactional
@ComponentScan(basePackages = { "org.iclass" })		// Bean 을 만들 패키지 설정
@MapperScan(basePackages = {"org.iclass"})			// Sql Mapper 인터페이스 찾을 패키지 설정

class Spring5webmvcApplicationTests {
	@Autowired
	private ProductMapper productMapper;

	@Test
	void contextLoads() {
		assertNotNull(productMapper);
	}


}
