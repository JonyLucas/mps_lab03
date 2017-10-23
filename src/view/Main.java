package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserForm uf = new UserForm();
                JFrame jf = new JFrame("MPS Lab 03");
                jf.setContentPane(uf);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setSize(320, 265);
                jf.setVisible(true);
                
            }
        });
        
    }
    
}
