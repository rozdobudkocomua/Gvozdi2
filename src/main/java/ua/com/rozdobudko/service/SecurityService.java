package ua.com.rozdobudko.service;

/**
 * Service for Security.
 *
 */

public interface SecurityService {

    String findLoggedInUsername(); //ищем залогиненных пользователей

    void autoLogin(String username, String password);
}
