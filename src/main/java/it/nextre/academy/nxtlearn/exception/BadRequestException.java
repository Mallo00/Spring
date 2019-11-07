package it.nextre.academy.nxtlearn.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(){
        this("BAD REQUEST");
    }
    public BadRequestException(String msg){
        super(msg);
    }
}//end class
