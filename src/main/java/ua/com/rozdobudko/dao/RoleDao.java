package ua.com.rozdobudko.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.rozdobudko.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
