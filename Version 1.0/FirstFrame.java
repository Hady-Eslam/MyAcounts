package my.acounts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FirstFrame extends JFrame{
    
    private JPanel PLocation,PAcount,PPassWord,PSave,PShow;
    private JLabel Location,Acount,PassWord;
    private JTextField EnterLocation,EnterAcount,EnterPassWord;
    private JButton Save,Show;
    private Box Small_Box,Big_Box;
    private Font font;
    
    private final String File_Path = "E://My Little Programs//Programs Files//My Acounts//File.txt";
    
    private int Acounts=0;
    
    public FirstFrame(){
        
        Count();
        
        CreateFrame();
        CreatePanels();
        CreateComponents();
        
        AddComponentsToFrame();
    }
    
    private void Count(){
    
        try{
            File file=new File(File_Path);
            Scanner output=new Scanner(file);
            
            while(output.hasNext()){
                
                String X=output.nextLine();
                if (X.charAt(0)!='='&&X.charAt(0)!='*')
                    Acounts++;
            }
            output.close();
        }
        catch(Exception e){     System.exit(0);     }
    }
    
    private void CreateFrame() {
        
        this.setTitle("My Acounts");
        this.setSize( 400 , 450 );
        this.setResizable(false);
        this.setLocation( 450 , 140 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
    
    private void CreatePanels(){
        
        PLocation=new JPanel();
        PLocation.setLayout(new FlowLayout(FlowLayout.CENTER));
        PLocation.setBorder(new EmptyBorder(25,3,0,0));
        
        PAcount=new JPanel();
        PAcount.setBorder(new EmptyBorder(0,3,0,0));
        PAcount.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PPassWord=new JPanel();
        PPassWord.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PSave=new JPanel();
        PSave.setLayout(new FlowLayout(FlowLayout.CENTER));
        PSave.setBorder(new EmptyBorder(30,0,0,0));
        
        PShow=new JPanel();
        PShow.setLayout(new FlowLayout(FlowLayout.CENTER));
        PShow.setBorder(new EmptyBorder(15,0,0,0));
        
        Big_Box=Box.createVerticalBox();
        Big_Box.setBorder(new EmptyBorder(5,5,5,5));
        
        Small_Box=Box.createVerticalBox();
        Small_Box.setBorder(new EmptyBorder(5,5,5,5));
    }
    
    private void CreateComponents() {
        
        font=new Font("Serif",Font.PLAIN,15);
        
        Location=new JLabel();
        Location.setText("Location / WebSite : ");
        
        Acount=new JLabel();
        Acount.setText("Acount / Handel : ");
        
        PassWord=new JLabel();
        PassWord.setText("PassWord : ");
        
        EnterLocation=new JTextField();
        EnterLocation.setFont(font);
        EnterLocation.setColumns(30);
        EnterLocation.setBorder(new EmptyBorder(2,3,2,3));
        EnterLocation.setLayout(new FlowLayout(FlowLayout.CENTER));
        EnterLocation.setHorizontalAlignment(JTextField.CENTER);
        EnterLocation.setForeground(Color.RED);
        
        EnterAcount=new JTextField();
        EnterAcount.setFont(font);
        EnterAcount.setBorder(new EmptyBorder(2,3,2,3));
        EnterAcount.setColumns(20);
        EnterAcount.setHorizontalAlignment(JTextField.CENTER);
        EnterAcount.setForeground(Color.red);
        
        EnterPassWord=new JTextField();
        EnterPassWord.setFont(font);
        EnterPassWord.setBorder(new EmptyBorder(2,3,2,3));
        EnterPassWord.setColumns(20);
        EnterPassWord.setHorizontalAlignment(JTextField.CENTER);
        EnterPassWord.setForeground(Color.red);
        
        Save=new JButton();
        Save.setText("Save Acount");
        Save.addActionListener(new SaveAction());
        
        Show=new JButton();
        Show.setText("Show My Acounts");
        Show.addActionListener(new ShowAction());
    }
    
    private void AddComponentsToFrame() {
        
        PLocation.add(Location);
        PLocation.add(EnterLocation);
        
        PAcount.add(Acount);
        PAcount.add(Box.createHorizontalStrut(3));
        PAcount.add(EnterAcount);
        
        PPassWord.add(PassWord);
        PPassWord.add(Box.createHorizontalStrut(30));
        PPassWord.add(EnterPassWord);
        
        PSave.add(Save);
        
        Small_Box.add(PLocation);
        Small_Box.add(Box.createVerticalStrut(3));
        Small_Box.add(PAcount);
        Small_Box.add(Box.createVerticalStrut(3));
        Small_Box.add(PPassWord);
        Small_Box.add(Box.createVerticalStrut(3));
        Small_Box.add(PSave);
        
        PShow.add(Show);
        
        Big_Box.add(Small_Box);
        Big_Box.add(Box.createVerticalStrut(5));
        Big_Box.add(PShow);
        
        this.add(Big_Box,BorderLayout.CENTER);
    }
    
    
    private String SetDataEncoding(String Data){
        
        String set="";
        for(int i=0;i<Data.length();i++){
            int f=(int) Data.charAt(i)*2;
            set+=(f+".");
        }
        return set;
    }
    
    
    
    private class SaveAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (EnterLocation.getText().length()!=0&&EnterAcount.getText().length()!=0){
                
                try{
                    File file=new File(File_Path);
                    PrintWriter input=new PrintWriter(new FileOutputStream(file,true));

                    input.println( SetDataEncoding( Integer.toString( Acounts ) ) );
                    
                    input.print("===>> ");
                    input.println( SetDataEncoding(EnterLocation.getText()));

                    input.print("===>> ");
                    input.println( SetDataEncoding(EnterAcount.getText()));

                    input.print("===>> ");
                    input.println( SetDataEncoding(EnterPassWord.getText()));

                    input.println("*******************************************************");
                    input.println("*******************************************************");

                    input.close();
                }
                catch(Exception E){     System.exit(0);     }
                
                EnterLocation.setText("");
                EnterAcount.setText("");
                EnterPassWord.setText("");
            }
        }
    }
    
    private class ShowAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            FirstFrame.this.dispose();
            new SecondFrame();
        } 
    }
}
