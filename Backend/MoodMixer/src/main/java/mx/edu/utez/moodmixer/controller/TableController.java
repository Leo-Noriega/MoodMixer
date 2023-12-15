package mx.edu.utez.moodmixer.controller;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.moodmixer.model.dto.ArtistDto;
import mx.edu.utez.moodmixer.model.entity.Artist;
import mx.edu.utez.moodmixer.service.IArtist;
import mx.edu.utez.moodmixer.service.IUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RequestMapping("/moodmixer")
public class TableController {
    private final IUser userService;
    private final IArtist artistService;

    // Select de la tabla artist
    @GetMapping("/table")
    public List<Artist> getArtists() {
        return artistService.findAll();
    }

    @PostMapping("/table")
    public ArtistDto saveArtist(@RequestBody ArtistDto artistDto) {
        Artist artistSave = artistService.save(artistDto);
        return ArtistDto.builder()
                .name(artistSave.getName())
                .genres(artistSave.getGenres())
                .url(artistSave.getUrl())
                .build();
    }

}
