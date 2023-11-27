package mx.edu.utez.MoodMixer.model.dao;

import mx.edu.utez.MoodMixer.model.entity.UserBean;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserBean, Integer> {
}
