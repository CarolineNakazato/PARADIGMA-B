/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contatest;

/**
 *
 * @author PC
 */
class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String msg){ 
        super(msg); 
    } 
    public NumeroNegativoException(String msg, Throwable cause){ 
        super(msg, cause); 
    }
} 

