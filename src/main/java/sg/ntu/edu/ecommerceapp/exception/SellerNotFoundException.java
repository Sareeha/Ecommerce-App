package sg.ntu.edu.ecommerceapp.exception;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(Long id) {
        super("Could not find seller with id: " + id + ".");
    }
}
