package org.iclass.spring_7jpa.repository;

import org.iclass.spring_7jpa.entity.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;



@Repository
public interface TodoRepository  extends JpaRepository<TodoEntity, Long> {
    // JpaRepository<TodoEntity, Long> 에서 상속 받은 메소드는 바로 사용 가능
    // Junit 테스트로 확인
    // 커스텀 메소드 정의 : 메소드 이름에 포함된 필드(컬럼) 이름은 정확히
    
    // where username = ?
    List<TodoEntity> findByUsername(String username);
    
    // where username = ? order by createdAt desc
    List<TodoEntity> findByusernameOrderByCreatedAt(String username);

    // where createdAt = ?
    List<TodoEntity> findByCreatedAt(LocalDateTime createdAt);

    // where createdAt > ?
    List<TodoEntity> findByCreatedAtAfter(LocalDateTime createdAt);

    // where username = ?
    Page<TodoEntity> findByUsername(String username, Pageable pageable);
}
