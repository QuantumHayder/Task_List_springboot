/*
 * package com.CRUD.H2_CRUD.advisor;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.web.bind.MethodArgumentNotValidException; import
 * org.springframework.web.bind.annotation.ResponseStatus; import
 * org.springframework.web.bind.annotation.RestControllerAdvice;
 * 
 * @RestControllerAdvice public class ExceptionHandler {
 * 
 * @ResponseStatus(HttpStatus.BAD_REQUEST)
 * 
 * @org.springframework.web.bind.annotation.ExceptionHandler(
 * MethodArgumentNotValidException.class) public Map<String, String>
 * handleInvalidArgument(MethodArgumentNotValidException ex){
 * 
 * Map<String, String> errorMap = new HashMap<>();
 * ex.getBindingResult().getFieldErrors().forEach(error->
 * errorMap.put(error.getField(),error.getDefaultMessage())); return errorMap; }
 * }
 */