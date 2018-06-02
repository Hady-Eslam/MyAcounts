package my.acounts;

import my.acounts.Activities.CreateAcounts;
import java.awt.EventQueue;

public class Begining {

    public static void main(String[] args) {
       
        EventQueue.invokeLater( () -> {
            new CreateAcounts();
        });
    }
}