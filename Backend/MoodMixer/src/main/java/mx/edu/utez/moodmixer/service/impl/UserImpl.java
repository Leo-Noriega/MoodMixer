package mx.edu.utez.moodmixer.service.impl;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.moodmixer.model.dao.UserDao;
import mx.edu.utez.moodmixer.model.dto.UserDto;
import mx.edu.utez.moodmixer.model.entity.User;
import mx.edu.utez.moodmixer.service.IUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserImpl implements IUser {
    private final UserDao userDao;

    @Override
    @Transactional
    public User save(UserDto user) {
        User userSave = User
                .builder()
                .username(user.getUsername())
                .build();
        return userDao.save(userSave);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }
}
