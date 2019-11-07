package it.nextre.academy.nxtlearn.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        System.out.println("Not found");
    }

    public NotFoundException(String msg){
        super(msg);
    }
}//end class
