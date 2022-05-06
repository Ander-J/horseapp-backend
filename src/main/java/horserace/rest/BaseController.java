package horserace.rest;

import horserace.exception.CustomBadRequestException;
import horserace.exception.CustomNotFoundException;
import horserace.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseBody
    public ErrorMessage handleBadRequest(CustomBadRequestException e){
        return e.errorMessage;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseBody
    public ErrorMessage handleNotFound(CustomNotFoundException e) {
        return e.errorMessage;
    }

}
