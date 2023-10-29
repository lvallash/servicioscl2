package pe.edu.cibertec.apprestcl2.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
