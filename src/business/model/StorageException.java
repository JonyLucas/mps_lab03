/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

/**
 *
 * @author aluno
 */
public class StorageException extends RuntimeException{
    public StorageException(){
        super("Ocorreu erro, meu amigo, tente novamente"); //Imprime mensagem amigavel ao usuario
    }
}
