package sg.ntu.edu.ecommerceapp.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Could not find customer with id: " + id + ".");
    }
}
