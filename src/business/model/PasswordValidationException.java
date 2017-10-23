/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

/**
 *
 * @author joao
 */
public class PasswordValidationException extends Exception{
    public PasswordValidationException(){
        super("Erro de validação na senha");
    }
    
    public PasswordValidationException(String s){
        super(s);
    }
}
