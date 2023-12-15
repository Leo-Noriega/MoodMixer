package mx.edu.utez.moodmixer.service;

import mx.edu.utez.moodmixer.model.dto.UserDto;
import mx.edu.utez.moodmixer.model.entity.User;

import java.util.List;

public interface IUser {
    User save(UserDto user);
    User findById(int id);
    User findByUsername(String username);
    List<User> findAll();
    void delete(User user);
}
