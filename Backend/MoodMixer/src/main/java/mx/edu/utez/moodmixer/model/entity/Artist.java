package mx.edu.utez.moodmixer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artist")
    private int id_artist;

    @Column(name = "name")
    private String name;

    @Column(name = "genres")
    private String genres;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({"artists"})
    private User user;
}
