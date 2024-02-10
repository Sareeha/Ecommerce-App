package sg.ntu.edu.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.ntu.edu.ecommerceapp.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
