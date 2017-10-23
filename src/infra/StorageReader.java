package infra;

import business.control.UserControl;
import business.model.StorageException;
import business.model.User;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StorageReader {
    private static FileReader fin;
    
    public static void load(String path){
        BufferedReader bf;
        String line, login, password;
        String[] tokens;
        ArrayList<User> users = new ArrayList<User>();
        
        try {
            fin = new FileReader(path);
            bf = new BufferedReader(fin);
            
            while(bf.ready()){
                line = bf.readLine();
                //System.out.println(line);
                tokens = line.split(",");
                login = tokens[0];
                password = tokens[1];
                users.add(new User(login, password));
            }
            UserControl.add_user(users);
            
            bf.close();
            fin.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
        } catch (IOException ex) {
            throw new StorageException();
        }
    }
}
