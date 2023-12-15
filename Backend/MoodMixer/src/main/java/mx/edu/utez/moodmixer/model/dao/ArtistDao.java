package mx.edu.utez.moodmixer.model.dao;

import mx.edu.utez.moodmixer.model.entity.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistDao extends CrudRepository<Artist, Integer> {
}
