package horserace.exception;

public class CustomNotFoundException extends RuntimeException{
    public final ErrorMessage errorMessage;

    public CustomNotFoundException(ErrorMessage errorMessage){
        super(errorMessage.toString());
        this.errorMessage = errorMessage;
    }
}
