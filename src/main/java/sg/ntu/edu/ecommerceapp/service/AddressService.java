package sg.ntu.edu.ecommerceapp.service;

import java.util.ArrayList;

import sg.ntu.edu.ecommerceapp.entity.Address;

public interface AddressService {

    Address createAddress(Address address);

    Address getAddress(Long id);

    ArrayList<Address> getAllAddresses();

    Address updateAddress(Long id, Address address);

    void deleteAddress(Long id);

    ArrayList<Address> searchAddressesByCity(String city);
}

