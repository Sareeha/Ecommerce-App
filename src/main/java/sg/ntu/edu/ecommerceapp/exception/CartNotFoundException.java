package sg.ntu.edu.ecommerceapp.exception;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(Long id) {
        super("Could not find cart with id: " + id + ".");
    }
}
