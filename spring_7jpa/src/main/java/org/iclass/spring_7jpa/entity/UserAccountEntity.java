package org.iclass.spring_7jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "user_account")
@Entity
public class UserAccountEntity {
    
    @Id
    @Column(nullable = false)
    private String userid;
    
    @Column(nullable = false)
    private String username;
    
    private String password;
    
    private LocalDateTime birth;
    
    // @Enumerated(EnumType.STRING) // 열거형 타입 상수이름으로 문자열처리
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private LocalDateTime regdate;
}
