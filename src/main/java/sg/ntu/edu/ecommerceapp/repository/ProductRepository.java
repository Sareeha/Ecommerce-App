package sg.ntu.edu.ecommerceapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.ntu.edu.ecommerceapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
