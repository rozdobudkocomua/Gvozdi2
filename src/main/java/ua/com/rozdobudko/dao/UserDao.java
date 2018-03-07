package ua.com.rozdobudko.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.rozdobudko.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
