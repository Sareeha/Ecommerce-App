package sg.ntu.edu.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.ntu.edu.ecommerceapp.entity.Order;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository <Order,Long> {
    Optional<Order> findByOrderId(long orderId);
}
