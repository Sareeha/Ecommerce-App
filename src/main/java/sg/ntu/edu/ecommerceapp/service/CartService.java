package sg.ntu.edu.ecommerceapp.service;

import java.util.ArrayList;

import sg.ntu.edu.ecommerceapp.entity.Cart;

public interface CartService {
    Cart createCart(Cart cart);

    Cart getCart(Long id);

    ArrayList<Cart> getAllCarts();

    Cart updateCart(Long id, Cart cart);

    void deleteCart(Long id);
}
