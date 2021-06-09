package UsersDetail.User.exception;

import UsersDetail.User.model.ErrorResponse;
import UsersDetail.User.model.Method;
import UsersDetail.User.model.Request;
import UsersDetail.User.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


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

    @ControllerAdvice
    public static class MethodArgumentNotValidExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(code = HttpStatus.BAD_REQUEST)
        @ResponseBody
        public MethodArgumentNotValidExceptionHandler.ValidationError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
            BindingResult result = ex.getBindingResult();

            List<String> errorList = new ArrayList<>();
            result.getFieldErrors().forEach((fieldError) -> {
                errorList.add(fieldError.getObjectName() + "." + fieldError.getField() + " : " + fieldError.getDefaultMessage() + " : rejected value [" + fieldError.getRejectedValue() + "]");
            });
            result.getGlobalErrors().forEach((fieldError) -> {
                errorList.add(fieldError.getObjectName() + " : " + fieldError.getDefaultMessage());
            });

            return new MethodArgumentNotValidExceptionHandler.ValidationError(HttpStatus.BAD_REQUEST, ex.getMessage(), errorList);
        }

        public static class ValidationError {
            private int errorCode;
            private String error;
            private String errorMessage;
            private List<String> fieldErrors = new ArrayList<>();

            public ValidationError(HttpStatus status, String message, List<String> fieldErrors) {
                this.errorCode = status.value();
                this.error = status.name();
                this.errorMessage = message;
                this.fieldErrors = fieldErrors;
            }

            public int getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(int errorCode) {
                this.errorCode = errorCode;
            }

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            public String getErrorMessage() {
                return errorMessage;
            }

            public void setErrorMessage(String errorMessage) {
                this.errorMessage = errorMessage;
            }

            public List<String> getFieldErrors() {
                return fieldErrors;
            }

            public void setFieldErrors(List<String> fieldErrors) {
                this.fieldErrors = fieldErrors;
            }
        }
    }
}


