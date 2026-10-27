package br.com.kaiocandido.exception.handler;

import br.com.kaiocandido.exception.ExceptionRespose;
import br.com.kaiocandido.exception.ResourceNotFoundException;
import br.com.kaiocandido.exception.UnsuportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustumizeEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionRespose> handleAllExceptions(Exception exception, WebRequest webRequest){

        ExceptionRespose response = new ExceptionRespose(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsuportedMathOperationException.class)
    public final ResponseEntity<ExceptionRespose> handleBadRequestExceptions(Exception exception, WebRequest webRequest){

        ExceptionRespose response = new ExceptionRespose(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionRespose> handleNotFoundExceptions(Exception exception, WebRequest webRequest){

        ExceptionRespose response = new ExceptionRespose(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
