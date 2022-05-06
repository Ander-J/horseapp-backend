package horserace.exception;

public class CustomBadRequestException extends RuntimeException {
    public final ErrorMessage errorMessage;

    public CustomBadRequestException(ErrorMessage errorMessage){
        super(errorMessage.toString());
        this.errorMessage = errorMessage;
    }
}
