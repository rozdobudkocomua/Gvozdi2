package ua.com.rozdobudko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.rozdobudko.model.Product;
import ua.com.rozdobudko.service.ProductService;

import java.util.Map;

/**
 * Controller for {@link ua.com.rozdobudko.model.Product}'s pages.
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/index")
    public String listProducts(Map<String, Object> map){
        map.put("product2", new Product());
        map.put("productList", productService.getAll());

        return "product2";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("product") Product product,
                             BindingResult result) {

        productService.addProduct(product);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{productId}")
    public String deleteContact(@PathVariable("productId") Long productId) {

        productService.delete(productId);

        return "redirect:/index";
    }
}
