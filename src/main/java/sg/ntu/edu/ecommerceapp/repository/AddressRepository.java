package sg.ntu.edu.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.ntu.edu.ecommerceapp.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCity(String city);
}

