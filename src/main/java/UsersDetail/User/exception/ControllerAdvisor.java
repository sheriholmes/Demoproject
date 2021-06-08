package UsersDetail.User.exception;

import UsersDetail.User.model.ErrorResponse;
import UsersDetail.User.model.Method;
import UsersDetail.User.model.Request;
import UsersDetail.User.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {

        Error error = new Error();
        error.setCode(HttpStatus.NOT_FOUND.getReasonPhrase());
        error.setDescription(ex.getMessage());
        error.setAdditionalInfo(ex.getLocalizedMessage());

        Request req = new Request();
        req.setQueryString(((ServletWebRequest) request).getRequest().getQueryString());
        req.setUri(String.valueOf(((ServletWebRequest) request).getRequest().getRequestURL()));
        req.setMethod(Method.valueOf(((ServletWebRequest) request).getRequest().getMethod()));

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(error);
        errorResponse.setRequest(req);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(WebRequest request) {

        Error error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        error.setDescription("Something is wrong");
        error.setAdditionalInfo(" Due to some external dependency which isn't working .");


        Request req = new Request();
        req.setQueryString(((ServletWebRequest) request).getRequest().getQueryString());
        req.setUri(String.valueOf(((ServletWebRequest) request).getRequest().getRequestURL()));
        req.setMethod(Method.valueOf(((ServletWebRequest) request).getRequest().getMethod()));

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(error);
        errorResponse.setRequest(req);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
//        ErrorDetails errorDetails = new ErrorDetails(new Date(),"Validation Error",
//                exception.getBindingResult().getFieldError().getDefaultMessage());
//
//        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
//    }
//
//}