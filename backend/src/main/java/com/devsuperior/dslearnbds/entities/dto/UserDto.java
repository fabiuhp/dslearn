package com.devsuperior.dslearnbds.entities.dto;

import com.devsuperior.dslearnbds.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
