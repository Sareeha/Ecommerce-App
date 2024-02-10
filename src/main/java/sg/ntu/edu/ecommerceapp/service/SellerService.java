package sg.ntu.edu.ecommerceapp.service;

import java.util.ArrayList;

import sg.ntu.edu.ecommerceapp.entity.Product;
import sg.ntu.edu.ecommerceapp.entity.Seller;

public interface SellerService {
   Seller createSeller(Seller seller);

    Seller getSeller(Long id);

    ArrayList<Seller> getAllSellers();

    Seller updateSeller(Long id, Seller seller);

    void deleteSeller(Long id);
    
    Product addProductToSeller(Long id, Product product);

    ArrayList<Seller> searchSellers(String firstName);

}
