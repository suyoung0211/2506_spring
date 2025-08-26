package org.iclass.spring_8secu.dto;

import java.time.LocalDate;

import org.iclass.spring_8secu.entity.UsersEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UsersDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private LocalDate birth;
    private String nickname;

    public static UsersDTO of(UsersEntity entity) {
        return UsersDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .username(entity.getUsername())
            .password(entity.getPassword())
            .birth(entity.getBirth())
            .nickname(entity.getNickname())
            .build();
    }

    public static UsersEntity toEntity(UsersDTO dto) {
        return UsersEntity.builder()
            .id(dto.getId())
            .name(dto.getName())
            .username(dto.getUsername())
            .password(dto.getPassword())
            .birth(dto.getBirth())
            .nickname(dto.getNickname())
            .build();
    }
}
