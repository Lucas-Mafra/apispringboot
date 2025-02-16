package lucidez.apispringboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lucidez.apispringboot.exception.ProdutoNullException;
import lucidez.apispringboot.exception.ProdutoPrecoException;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(ProdutoNullException.class)
    public ResponseEntity<Object> CapturarErrorNull() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("massage", "Campo com valor nulo, verifique e tente novamente.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    
    @ExceptionHandler(ProdutoPrecoException.class)
    public ResponseEntity<Object> CapturarErrorPreco() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("massage", "Produto com valor invalido, verifique e tente novamente.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
