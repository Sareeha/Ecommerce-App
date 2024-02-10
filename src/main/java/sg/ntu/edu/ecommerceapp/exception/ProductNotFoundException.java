package sg.ntu.edu.ecommerceapp.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productId) {
        super("Could not find product with id: " + productId + ".");
    }
}
