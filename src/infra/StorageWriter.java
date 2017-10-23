package infra;

import business.model.StorageException;
import business.model.User;

import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StorageWriter {
    
    private static FileWriter fout;    
    
    public static void save(String path, User user){
        try {
            fout = new FileWriter(path, true);
            fout.write(user.get_login() + ",");
            fout.write(user.get_password() + "\n");
            fout.close();
        } catch (IOException ex) {
            Logger.getLogger(StorageWriter.class.getName()).log(Level.SEVERE, null, ex);
            throw new StorageException();
        }
    }
    
    public static void clear_file(String path){
        try {
            fout = new FileWriter(path);
            fout.write("");
            fout.close();
        } catch (IOException ex) {
            throw new StorageException();
        }
    }
}
