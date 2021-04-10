package com.image.portal.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AppExceptionHandler {
/*
    *//**
     * This handles exceptions more gracefully where we receive an internal error.
     * In cases where we cannot find the user we return a 404 instead of an error 500.
     * @param ex
     * @param request
     * @param response
     * @return
     *//*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex,
                                         HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }*/
}
