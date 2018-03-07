package ua.com.rozdobudko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.rozdobudko.dao.ProductDao;
import ua.com.rozdobudko.model.Product;

import java.util.List;

/**
 * Implementation of {@link ProductService} interface
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void save(Product product) {
        //затем добавим присвоение категории
        productDao.saveAndFlush(product);
    }

    @Override
    public Product addProduct(Product product) {
        Product savedProduct = productDao.saveAndFlush(product);
        return savedProduct;
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }

    @Override
    public Product editProduct(Product product) {
        return productDao.saveAndFlush(product); //hibernate проверит, есть ли запись в БД, которую мы хотим сохранить, если есть, то он её обновит
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }
}
