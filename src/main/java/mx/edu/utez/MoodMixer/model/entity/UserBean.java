package mx.edu.utez.MoodMixer.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "username", nullable = false, unique = true, length = 60)
    private String username;
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    @Column(name = "email", nullable = false, unique = true, length = 60)
    private String email;
    @Column(name = "name", nullable = false, length = 60)
    private String name;
    @Column(name = "last_name", nullable = false, length = 60)
    private String last_name;
    @Column(name = "estado_animo", nullable = false, length = 60)
    private String estado_animo;
}
