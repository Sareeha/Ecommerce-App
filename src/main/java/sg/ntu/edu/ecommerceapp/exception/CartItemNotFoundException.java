package sg.ntu.edu.ecommerceapp.exception;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(Long id) {
        super("Could not find cartItem with id: " + id + ".");
    }

}
