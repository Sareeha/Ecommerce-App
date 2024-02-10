package sg.ntu.edu.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.ntu.edu.ecommerceapp.entity.Customer;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom query to find all customers with a certain first name
    List<Customer> findByFirstName(String firstName);
}
