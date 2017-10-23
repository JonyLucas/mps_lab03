package business.control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import business.model.User;
import business.model.UserNotExistException;
import business.model.LoginValidationException;
import business.model.PasswordValidationException;
import business.model.StorageException;
import infra.StorageWriter;

public class UserControl {
    
    private static ArrayList<User> users = new ArrayList<User>();
    
    public static void add_user(String login, String password){
        try{
            Validator.validate_login(login);
            Validator.validate_password(password);
            User user = new User(login, password);
            users.add(user);
        }catch(LoginValidationException | PasswordValidationException lve){
            JOptionPane.showMessageDialog(null, lve.getMessage());
        }

    }
    
    public static void add_user(ArrayList<User> loaded_users){
        try{
            for(User user : loaded_users){
                Validator.validate_login(user.get_login());
                Validator.validate_password(user.get_password());
                users.add(user);
            }
        }catch(LoginValidationException | PasswordValidationException lve){
            JOptionPane.showMessageDialog(null, lve.getMessage());
        }

    }
    
    public static void remove_user(String login) throws UserNotExistException{
        boolean exist = false;
        int size = users.size();
        
        for(int i = 0; i < size; i++){
            User user = users.get(i);
            if(user.get_login().equals(login)){
                users.remove(user);
                exist = true;
                i--;
                size = users.size();
            }
        }
        
        if(!exist)
            throw new UserNotExistException();
        
    }
    
    public static String list(String login){
        String list = "";
        
        for(User user : users){
            if(user.get_login().equals(login)){
                list += user.get_info();
            }
        }
        
        JOptionPane.showMessageDialog(null, list);
        
        return list;
        
    }
    
    public static String list_all(){
        String list = "";
        
        for(User user : users){
            list += user.get_info();
        }
        
        JOptionPane.showMessageDialog(null, list);
        
        return list;
    }
    
    public static void save_storage(String path, boolean overwrite){
        try{
            if(overwrite)
            StorageWriter.clear_file(path);
        
        for(User user : users){
            StorageWriter.save(path, user);
        }
        }catch(StorageException se){
            JOptionPane.showMessageDialog(null, se.getMessage());
        }
    }
    
    /**Metodos usados no teste unitario**/
    public static ArrayList<User> get_array_list(){
    	return users;
    }
    
    public static void clear(){
    	users.clear();
    }
    
}
