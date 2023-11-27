package mx.edu.utez.MoodMixer.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {
    private int id_user;
    private String username;
    private String password;
    private String email;
    private String name;
    private String last_name;
    private String estado_animo;
}
