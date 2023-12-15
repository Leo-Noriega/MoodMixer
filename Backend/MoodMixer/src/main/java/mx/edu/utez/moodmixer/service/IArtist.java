package mx.edu.utez.moodmixer.service;

import mx.edu.utez.moodmixer.model.dto.ArtistDto;
import mx.edu.utez.moodmixer.model.entity.Artist;

import java.util.List;

public interface IArtist {
    Artist save(ArtistDto artist);
    Artist findById(int id);
    List<Artist> findAll();
    void delete(Artist artist);
}
