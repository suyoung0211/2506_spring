package org.iclass.spring_7jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.iclass.spring_7jpa.entity.UserAccountEntity;
import org.iclass.spring_7jpa.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserAccountRepositoryTest {
    
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Test
    void findByUserId() {
        Optional<UserAccountEntity> entity = userAccountRepository.findById("wonder");
        if (entity.isPresent()) {
            log.info("{}", entity.get());
        }
        assertNotNull(entity);
    }
}
