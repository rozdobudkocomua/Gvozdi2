package ua.com.rozdobudko.service;

import ua.com.rozdobudko.model.Product;

import java.util.List;

/**
 * Service class for {@link ua.com.rozdobudko.model.Product}
 */
public interface ProductService {

    void delete(Long id);

    void save(Product product);

    Product addProduct(Product product);

    Product findById(Long id);

    Product editProduct(Product product);

    List<Product> getAll();

}
