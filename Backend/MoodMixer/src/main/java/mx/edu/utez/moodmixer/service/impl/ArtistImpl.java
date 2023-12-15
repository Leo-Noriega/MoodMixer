package mx.edu.utez.moodmixer.service.impl;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.moodmixer.model.dao.ArtistDao;
import mx.edu.utez.moodmixer.model.dao.UserDao;
import mx.edu.utez.moodmixer.model.dto.ArtistDto;
import mx.edu.utez.moodmixer.model.entity.Artist;
import mx.edu.utez.moodmixer.model.entity.User;
import mx.edu.utez.moodmixer.service.IArtist;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArtistImpl implements IArtist {
    private final ArtistDao artistDao;
    private final UserDao userDao;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public Artist save(ArtistDto artist) {
        User user = userDao.findById(artist.getId_user()).orElse(null);
        Artist artistSave = Artist
                .builder()
                .name(artist.getName())
                .genres(artist.getGenres())
                .url(artist.getUrl())
                .user(user)
                .build();
        return artistDao.save(artistSave);
    }

    @Override
    public Artist findById(int id) {
        return artistDao.findById(id).orElse(null);
    }

    @Override
    public List<Artist> findAll() {
        return (List<Artist>) artistDao.findAll() ;
    }

    @Override
    public void delete(Artist artist) {
        artistDao.delete(artist);
    }
}
