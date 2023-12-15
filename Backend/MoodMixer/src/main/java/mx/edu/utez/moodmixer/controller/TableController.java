package mx.edu.utez.moodmixer.controller;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.moodmixer.model.dto.ArtistDto;
import mx.edu.utez.moodmixer.model.entity.Artist;
import mx.edu.utez.moodmixer.model.entity.User;
import mx.edu.utez.moodmixer.service.IArtist;
import mx.edu.utez.moodmixer.service.IUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RequestMapping("/moodmixer")
public class TableController {
    private final IUser userService;
    private final IArtist artistService;

    // Select de la tabla artist
    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @GetMapping("/table")
    @Transactional(readOnly = true)
    public List<Artist> getArtists() {
        return artistService.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @PostMapping("/table")
    @Transactional(rollbackFor = {SQLException.class})
    public ArtistDto saveArtist(@RequestBody ArtistDto artistDto) {
        Artist artistSave = artistService.save(artistDto);
        return ArtistDto.builder()
                .name(artistSave.getName())
                .genres(artistSave.getGenres())
                .url(artistSave.getUrl())
                .build();
    }

    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @PutMapping("/table")
    @Transactional(rollbackFor = {SQLException.class})
    public ArtistDto updateArtist(@RequestBody ArtistDto artistDto) {
        System.out.println(artistDto);
        Artist artistUpdate = artistService.save(artistDto);
        System.out.println(artistUpdate);
        return ArtistDto.builder()
                .name(artistUpdate.getName())
                .genres(artistUpdate.getGenres())
                .url(artistUpdate.getUrl())
                .build();
    }

    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @DeleteMapping("/table/{id}")
    public void deleteArtist(@PathVariable int id) {
        Artist artist = artistService.findById(id);
        artistService.delete(artist);
    }

}
