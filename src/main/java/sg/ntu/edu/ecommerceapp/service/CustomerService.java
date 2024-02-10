package sg.ntu.edu.ecommerceapp.service;

import java.util.ArrayList;

import sg.ntu.edu.ecommerceapp.entity.Customer;

public interface CustomerService {

    Customer createCustomer(String firstName, String lastName,String email, String contactNo,int YOB);

    Customer getCustomer(Long id);

    ArrayList<Customer> getAllCustomers();

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

    ArrayList<Customer> searchCustomers(String firstName);
}
