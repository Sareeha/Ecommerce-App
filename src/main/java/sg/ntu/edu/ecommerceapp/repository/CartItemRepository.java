package sg.ntu.edu.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.ntu.edu.ecommerceapp.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    
}
