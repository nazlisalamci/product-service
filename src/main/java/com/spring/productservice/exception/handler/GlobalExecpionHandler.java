package com.spring.productservice.exception.handler;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.productservice.exception.enums.FriendlyMessageCodes;
import com.spring.productservice.exception.exceptions.ProductNotCreatedException;
import com.spring.productservice.exception.utils.FriendlyMessageUtils;
import com.spring.productservice.response.FriendlyMessage;
import com.spring.productservice.response.InternalApiResponse;

@RestControllerAdvice
public class GlobalExecpionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotCreatedException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException exception){
        return InternalApiResponse.<String>builder()
        .friendlyMessage(FriendlyMessage.builder()
        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),FriendlyMessageCodes.Error))
        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), exception.getFriendlyMessageCode()))
        .build())
        .httpStatus(HttpStatus.BAD_REQUEST)
        .hasError(true)
        .errorMessage(Collections.singletonList(exception.getMessage()))
        .build();
    }
    
}
