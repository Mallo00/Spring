package it.nextre.academy.nxtlearn.controller;

import it.nextre.academy.nxtlearn.exception.NotFoundException;
import it.nextre.academy.nxtlearn.exception.PersonaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.*;


public class ExceptionHandlerRest extends PersonaNotFoundException {

    //Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    Logger logger;

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFound(NotFoundException e) {
        logger.debug("LOG: handleNotFound()");
        return new MyError(HttpStatus.NOT_FOUND, e.getMessage())
                .getPage();
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequest(NotFoundException e) {
        logger.debug("LOG: handleBadRequest()");
        return new MyError(HttpStatus.BAD_REQUEST, e.getMessage())
                .getPage();
    }

}//end class

class MyError {

    private HttpStatus statusCode;
    private Object body;
    private Map<String, Object> data = new HashMap<>();
    private MultiValueMap<String, String> customHeaders = new HttpHeaders();

    public MyError(HttpStatus statusCode, Object body) {
        this.statusCode = statusCode;
        this.body = body;
        this.data.put("data", body);
        this.data.put("status", statusCode);
        this.data.put("error", statusCode.toString().substring(3).trim());
        this.data.put("timestamp", Instant.now().toEpochMilli());
    }

    public ResponseEntity getPage() {
        return new ResponseEntity(data, statusCode);
    }

    public MyError addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }


    public MyError addHeader(String key, String value) {
        this.customHeaders.put(key, Arrays.asList(value));
        return this;
    }

    public MyError addHeaders(String key, List<String> value) {
        this.customHeaders.put(key, value);
        return this;
    }
}
