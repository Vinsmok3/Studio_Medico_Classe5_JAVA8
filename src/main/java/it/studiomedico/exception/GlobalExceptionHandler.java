package it.studiomedico.exception;

import it.studiomedico.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handleUserNotFoundException(UserNotFoundException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(BaseResponse.Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("USER_NOT_FOUND");
        }
        return br;
    }

}

