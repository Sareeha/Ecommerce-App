package sg.ntu.edu.ecommerceapp.exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(Long id) {
        super("Could not find address with id: " + id + ".");
    }
}

