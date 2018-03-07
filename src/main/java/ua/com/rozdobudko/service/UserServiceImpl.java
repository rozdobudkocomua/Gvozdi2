package ua.com.rozdobudko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.rozdobudko.dao.RoleDao;
import ua.com.rozdobudko.dao.UserDao;
import ua.com.rozdobudko.model.Role;
import ua.com.rozdobudko.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserService} interface.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); //пароль от пользователя кодируем с помощью BCrypt
        Set<Role> roles = new HashSet<>(); //по умолчанию пользователям назначаем роль юзера
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user); //сохраняем
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username); //получаем пользоватлея по имени
    }
}
