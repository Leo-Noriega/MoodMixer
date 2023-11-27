package mx.edu.utez.MoodMixer.service;

import mx.edu.utez.MoodMixer.model.dto.UserDto;
import mx.edu.utez.MoodMixer.model.entity.UserBean;

import java.util.List;

public interface IUser {
    UserBean save(UserDto userDto);

    UserBean findById(int id);

    List<UserBean> findAll();

    void delete(UserBean userBean);
}
