package ua.com.rozdobudko.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.rozdobudko.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

    Product findById(Long id);


}
