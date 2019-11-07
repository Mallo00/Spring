package it.nextre.academy.nxtlearn.controller;

public class BadRequestException extends RuntimeException {
    public BadRequestException(){
        this("BAD REQUEST");
    }
    public BadRequestException(String msg){
        super(msg);
    }
}//end class
