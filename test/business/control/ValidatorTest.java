/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.LoginValidationException; 
import business.model.PasswordValidationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao
 */
public class ValidatorTest {
    
    LoginValidationException lve;
    
    public ValidatorTest() {
        lve = new LoginValidationException();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validate_login method, of class Validator.
     */
    @Test
    public void testValidate_login() throws Exception {
        System.out.println("validate_login");
        
        String login_valido = "Joao Lucas",
               login_valido2 = "Alexandre",
               login_valido3 = "LeonardoLuiz";
        
        String login_invalido = "Joao Lucas Fabiao Amorim", //Comprimento maior do que 12
               login_invalido2 = "Alex123", //Possui número
               login_invalido3 = ""; //String vazia

        assertTrue(Validator.validate_login(login_valido));
        assertTrue(Validator.validate_login(login_valido2));
        assertTrue(Validator.validate_login(login_valido3));

        try{
            Validator.validate_login(login_invalido);
            fail("LoginValidationException deveria ocorrer aqui");
        }catch(LoginValidationException lve){
            //Tudo certo
        }

        try{
            Validator.validate_login(login_invalido2);
            fail("LoginValidationException deveria ocorrer aqui");
        }catch(LoginValidationException lve){
            //Tudo certo
        }

        try{
            Validator.validate_login(login_invalido3);
            fail("LoginValidationException deveria ocorrer aqui");
        }catch(LoginValidationException lve){
            //Tudo certo
        }
    }

    /**
     * Test of validate_password method, of class Validator.
     */
    @Test
    public void testValidate_password() throws Exception {
        System.out.println("validate_password");
        
        String password_valido = "H3LL0W0RLD", 
               password_valido2 = "H3110W0R1D", 
               password_valido3 = "OLAMUNDO123";
        
        String password_invalido = "H3LL0 W0RLD", //Senha possui um caracter invalido: " "
               password_invalido2 = "HelloWorld", //Possui menos de 2 digitos
               password_invalido3 = "123456789", //Nao possui letra
               password_invalido4 = "T3RR4"; //Comprimento menor do que 8

        assertTrue(Validator.validate_password(password_valido));
        assertTrue(Validator.validate_password(password_valido2));
        assertTrue(Validator.validate_password(password_valido3));

        try{
            Validator.validate_password(password_invalido);
            fail("PasswordValidationException deveria ocorrer aqui");
        }catch(PasswordValidationException lve){
            //Tudo certo
        }

        try{
            Validator.validate_password(password_invalido2);
            fail("PasswordValidationException deveria ocorrer aqui");
        }catch(PasswordValidationException lve){
            //Tudo certo
        }
        
        try{
            Validator.validate_password(password_invalido3);
            fail("PasswordValidationException deveria ocorrer aqui");
        }catch(PasswordValidationException lve){
            //Tudo certo
        }
        
        try{
            Validator.validate_password(password_invalido4);
            fail("PasswordValidationException deveria ocorrer aqui");
        }catch(PasswordValidationException lve){
            //Tudo certo
        }
    }
    
}
