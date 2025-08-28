package org.iclass.spring_9jwt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.iclass.spring_9jwt.dto.Role;
import org.iclass.spring_9jwt.entity.BoardEntity;
import org.iclass.spring_9jwt.entity.UsersEntity;
import org.iclass.spring_9jwt.repository.BoardRepository;
import org.iclass.spring_9jwt.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SampleDataTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    static List<String> users = new ArrayList<>();

    @Test
    @Order(1)
    void createUsers() {    // 이름, 패스워드, username, role
        UsersEntity user = UsersEntity.builder()
            .name("aa")
            .password(passwordEncoder.encode("1111"))
            .username("aa@naver.com")
            .role(Role.USER)
            .build();
        users.add(user.getUsername());
        userRepository.save(user);
        
        user = UsersEntity.builder()
            .name("bb")
            .password(passwordEncoder.encode("1111"))
            .username("bb@naver.com")
            .role(Role.ADMIN)   // ADMIM 권한 테스트용
            .build();
        users.add(user.getUsername());
        userRepository.save(user);
        
        user = UsersEntity.builder()
            .name("cc")
            .password(passwordEncoder.encode("1111"))
            .username("cc@naver.com")
            .role(Role.USER)
            .build();
        users.add(user.getUsername());
        userRepository.save(user);
        
        user = UsersEntity.builder()
            .name("dd")
            .password(passwordEncoder.encode("1111"))
            .username("dd@naver.com")
            .role(Role.USER)
            .build();
        users.add(user.getUsername());
        userRepository.save(user);
        
        user = UsersEntity.builder()
            .name("ee")
            .password(passwordEncoder.encode("1111"))
            .username("ee@naver.com")
            .role(Role.USER)
            .build();
        users.add(user.getUsername());
        userRepository.save(user);
    }

    @Test
    @Order(2)
    void createBoards() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            LocalDateTime baseTime = LocalDateTime.of(2025,8,10,0,0,0);
            BoardEntity board = BoardEntity.builder()
                .title("오늘의 명언 " + i)
                .content("하늘은 스스로 돕는자를 돕는다.")
                .username(users.get(i % 5))
                .build();
            boardRepository.save(board);    // insert
            board.setCreatedAt(baseTime.plusDays(i + 10).plusHours(i).plusMinutes(i));
            // board.setUpdatedAt(baseTime.plusMonths(i).plusDays(i + 11));     // PreUdate 로 동작안함
            boardRepository.save(board);    // update
        });
    }
}