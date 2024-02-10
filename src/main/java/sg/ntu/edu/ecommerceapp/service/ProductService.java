package sg.ntu.edu.ecommerceapp.service;

import java.util.ArrayList;

import sg.ntu.edu.ecommerceapp.entity.Category;
import sg.ntu.edu.ecommerceapp.entity.Product;

public interface ProductService {

    // Product createProduct(Product product);

    // Product getProduct(Long id);

    // ArrayList<Product> getAllProducts();

    // Product updateProduct(Long id, Product product);

    // void deleteProduct(Long id);

    // ArrayList<Product> searchProducts(String name);

    Product createProduct(Product product);

    Product getProduct(Long id);

    ArrayList<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    ArrayList<Product> findProductsByCategory(Category category, ArrayList<Product> unfilteredProducts);

    ArrayList<Product> findProductsByAmount(Double minAmount, Double maxAmount, ArrayList<Product> unfilteredProducts);

    ArrayList<Product> searchProducts(String name);


}