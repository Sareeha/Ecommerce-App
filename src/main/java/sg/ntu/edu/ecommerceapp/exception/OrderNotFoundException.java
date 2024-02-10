package sg.ntu.edu.ecommerceapp.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Could not find Order with id: " + id + ".");
    }

}
