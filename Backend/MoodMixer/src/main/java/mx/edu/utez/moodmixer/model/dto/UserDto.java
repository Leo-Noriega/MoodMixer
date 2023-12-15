package mx.edu.utez.moodmixer.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class UserDto {
    private int id_user;
    private String username;
}
