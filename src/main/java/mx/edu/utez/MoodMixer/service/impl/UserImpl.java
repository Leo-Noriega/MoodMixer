package mx.edu.utez.MoodMixer.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.MoodMixer.model.dao.UserDao;
import mx.edu.utez.MoodMixer.model.dto.UserDto;
import mx.edu.utez.MoodMixer.model.entity.UserBean;
import mx.edu.utez.MoodMixer.service.IUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserImpl implements IUser {
    private final UserDao userDao;

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public UserBean save(UserDto userDto) {
        UserBean user = UserBean.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .last_name(userDto.getLast_name())
                .estado_animo(userDto.getEstado_animo())
                .build();
        return userDao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserBean findById(int id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserBean> findAll() {
        return null;
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public void delete(UserBean userBean) {

    }
}
