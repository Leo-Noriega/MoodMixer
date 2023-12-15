package mx.edu.utez.moodmixer.model.dao;

import mx.edu.utez.moodmixer.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
