/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.User;
import business.model.UserNotExistException;
import infra.StorageReader;
import java.util.ArrayList;
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
public class UserControlTest {
    
    private ArrayList<User> collection;
    
    public UserControlTest() {
        collection = new ArrayList<User>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        collection = new ArrayList<User>();
    }
    
    @After
    public void tearDown() {
        collection.clear();
        UserControl.clear();
    }

    /**
     * Test of add_user method, of class UserControl.
     */
    @Test
    public void testAdd_user_String_String() {
        System.out.println("add_user");
        
        String login_valido = "Joao Lucas", 
               login_valido2 = "Alexandre", 
               login_valido3 = "LeonardoLuiz";
        
        String password_valido = "H3LL0W0RLD", 
               password_valido2 = "H3110W0R1D", 
               password_valido3 = "OLAMUNDO123";
        
        
        User user1 = new User(login_valido, password_valido), 
             user2 = new User(login_valido2, password_valido2),
             user3 = new User(login_valido3, password_valido3);
        
        collection.add(user1);
        collection.add(user2);
        collection.add(user3);
        
        UserControl.add_user(login_valido, password_valido);
        UserControl.add_user(login_valido2, password_valido2);
        UserControl.add_user(login_valido3, password_valido3);
        
        ArrayList<User> uc_users = UserControl.get_array_list();
        
        for(int i = 0; i < collection.size(); i++){
            String login1 = collection.get(i).get_login(),
                   login2 = uc_users.get(i).get_login();
            String senha1 = collection.get(i).get_password(),
                   senha2 = uc_users.get(i).get_password();
            
            if(!login1.equals(login2) || !senha1.equals(senha2))
                fail("Ocorreu uma falha na logica de adicao de usuario");
        }

    }

    /**
     * Test of add_user method, of class UserControl.
     */
    @Test
    public void testAdd_user_ArrayList() {
        System.out.println("add_user");
        
        String login_valido = "Joao Lucas", 
               login_valido2 = "Alexandre", 
               login_valido3 = "LeonardoLuiz";
        
        String password_valido = "H3LL0W0RLD", 
               password_valido2 = "H3110W0R1D", 
               password_valido3 = "OLAMUNDO123";
        
        
        User user1 = new User(login_valido, password_valido), 
             user2 = new User(login_valido2, password_valido2),
             user3 = new User(login_valido3, password_valido3);
        
        collection.add(user1);
        collection.add(user2);
        collection.add(user3);
        
        UserControl.add_user(collection);
        
        ArrayList<User> uc_users = UserControl.get_array_list();
        
        for(int i = 0; i < collection.size(); i++){
            String login1 = collection.get(i).get_login(),
                   login2 = uc_users.get(i).get_login();
            String senha1 = collection.get(i).get_password(),
                   senha2 = uc_users.get(i).get_password();
            
            if(!login1.equals(login2) || !senha1.equals(senha2))
                fail("Ocorreu uma falha na logica de adicao de usuario");
        }
        
    }

    /**
     * Test of remove_user method, of class UserControl.
     */
    @Test
    public void testRemove_user() throws Exception {
        System.out.println("remove_user");
        
        String login_valido = "Joao Lucas", 
               login_valido2 = "Alexandre", 
               login_valido3 = "LeonardoLuiz";
        
        String password_valido = "H3LL0W0RLD", 
               password_valido2 = "H3110W0R1D", 
               password_valido3 = "OLAMUNDO123";
        
        
        User user1 = new User(login_valido, password_valido),
             user2 = new User(login_valido2, password_valido2),
             user3 = new User(login_valido3, password_valido3);
        
        collection.add(user1);
        collection.add(user3);
        
        UserControl.add_user(login_valido, password_valido);
        UserControl.add_user(login_valido2, password_valido2);
        UserControl.add_user(login_valido3, password_valido3);
        
        try{
            UserControl.remove_user(user2.get_login());
            
            ArrayList<User> uc_users = UserControl.get_array_list();
            
            for(int i = 0; i < collection.size(); i++){
            String login1 = collection.get(i).get_login(),
                   login2 = uc_users.get(i).get_login();
            String senha1 = collection.get(i).get_password(),
                   senha2 = uc_users.get(i).get_password();
            
            if(!login1.equals(login2) || !senha1.equals(senha2))
                fail("Ocorreu uma falha na logica de adicao de usuario");
        }
            
        }catch(UserNotExistException unee){
            fail("Ocorreu uma falha na remocao de usuario");
        }
        
        try{
            UserControl.remove_user("inexistente");
        }catch(UserNotExistException unee){
            //Tudo certo
        }
        
    }

    /**
     * Test of list method, of class UserControl.
     */
    @Test
    public void testList() {
        System.out.println("list");
        
        User user1 = new User(), 
             user2 = new User("Joao", "123OLAMUNDO"), 
             user3 = new User("Alexandre", "teste1234");
        
        UserControl.add_user(user1.get_login(), user1.get_password());
        UserControl.add_user(user2.get_login(), user2.get_password());
        UserControl.add_user(user3.get_login(), user3.get_password());

        String list_all = user1.get_info();

        assertEquals(list_all, UserControl.list(user1.get_login()));
    }

    /**
     * Test of list_all method, of class UserControl.
     */
    @Test
    public void testList_all() {
        System.out.println("list_all");
        
        User user1 = new User(),
             user2 = new User("Joao", "123OLAMUNDO"),
             user3 = new User("Alexandre", "teste1234");
        
        UserControl.add_user(user1.get_login(), user1.get_password());
        UserControl.add_user(user2.get_login(), user2.get_password());
        UserControl.add_user(user3.get_login(), user3.get_password());

        String list_all = user1.get_info() + user2.get_info() + user3.get_info();

        assertEquals(list_all, UserControl.list_all());
    }

    /**
     * Test of save_storage method, of class UserControl.
     */
    @Test
    public void testSave_storage() {
        System.out.println("save_storage");
        String path = "TestCase.txt";
        String uc_list, file_list;
        boolean overwrite = true;
        
        String login_valido = "Joao Lucas", 
               login_valido2 = "Alexandre", 
               login_valido3 = "LeonardoLuiz";
        
        String password_valido = "H3LL0W0RLD", 
               password_valido2 = "H3110W0R1D", 
               password_valido3 = "OLAMUNDO123";

        UserControl.add_user(login_valido, password_valido);
        UserControl.add_user(login_valido2, password_valido2);
        UserControl.add_user(login_valido3, password_valido3);
        
        uc_list = UserControl.list_all();
        
        UserControl.save_storage(path, overwrite);
        UserControl.clear();
        
        StorageReader.load(path);
        
        file_list = UserControl.list_all();
        
        assertEquals(file_list, uc_list);
        
    }


}
