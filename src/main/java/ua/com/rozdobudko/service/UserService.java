package ua.com.rozdobudko.service;

import ua.com.rozdobudko.model.User;

/**
 * Service class for {@link ua.com.rozdobudko.model.User}
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
