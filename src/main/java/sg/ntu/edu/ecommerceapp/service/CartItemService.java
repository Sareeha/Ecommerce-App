package sg.ntu.edu.ecommerceapp.service;

import java.util.ArrayList;

import sg.ntu.edu.ecommerceapp.entity.CartItem;

public interface CartItemService {
    CartItem createCartItem(CartItem cartItem);

    CartItem getCartItem(Long id);

    ArrayList<CartItem> getAllCartItems();

    CartItem updateCartItem(Long id, CartItem cartItem);

    void deleteCartItem(Long id);

}
