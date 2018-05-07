package my.acounts;

import java.awt.EventQueue;
import java.io.File;

public class Begining {

    public static void main(String[] args) {
       
        EventQueue.invokeLater( new Runnable(){
            @Override
            public void run() {
            
                PreparationForOpening();
                new FirstFrame();
            }
        });
    }
    
    private static void PreparationForOpening() {

        File file=new File("E://My Little Programs//Programs Files//My Acounts//File.txt");
        if ( !file.exists() )
            System.exit(0);
    }
}
