package mx.edu.utez.moodmixer.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ArtistDto {
    private int id_artist;
    private String name;
    private String genres;
    private String url;
    private int id_user;
}
