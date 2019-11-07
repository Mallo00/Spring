package it.nextre.academy.nxtlearn.controller;

import it.nextre.academy.nxtlearn.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //è in ascolto dall'interno
public class ExceptionHandlerController {

    //@ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFound(NotFoundException e) {/*risposta http, header e body. posso tornare html, json...*/
        System.out.println("Gestorenotfound");
        return new MyErrorPage(HttpStatus.NOT_FOUND, e.getMessage()).getPage();
    }


    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound1(NotFoundException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errors/404.html");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        modelAndView.addObject("mex", e.getMessage());
        return modelAndView;
    }




}//end class

class MyErrorPage {

    private HttpStatus statusCode;
    private Object body;

    public MyErrorPage(HttpStatus statusCode, Object body) {
        System.out.println("Costruttore error page");
        this.statusCode = statusCode;
        this.body = body;
    }

    public ResponseEntity getPage() {
        System.out.println("GetPage");
        return new ResponseEntity(body, statusCode);
    }


}
