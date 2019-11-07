package it.nextre.academy.nxtlearn.myUtil.eccezioni;

public class DivisionePerZeroException extends RuntimeException {
    public DivisionePerZeroException(String msg){
        super(msg);
    }
    public DivisionePerZeroException(){
        this("Divisione per zero non valida.");
    }

}//end class
