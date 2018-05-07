package my.acounts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SecondFrame extends JFrame{
    
    private JPanel PLocation,PAcount,PPassWord,PButton,PButtona,PRemove;
    private JLabel Location,ShowLocation,Acount,ShowAcount,PassWord,sPassWord;
    private JButton Back,Next,Pre,Remove;
    private Box Show_Acount,Small_Box,Big_Box;
    private Font font;
    
    private final String File_Path = "E://My Little Programs//Programs Files//My Acounts//File.txt";
    
    private List<Acount> acount=new ArrayList<Acount>();
    private Acount ac;
    
    private int Order=0;
    private int Size=0;
    
    public SecondFrame(){
     
        GetAcounts();
        
        CreateFrame();
        CreatePanels();
        CreateComponents();
        SetText();
        
        AddComponentsToFrame();
    }
    
    
    private void GetAcounts(){
        
        try{
        
            File file=new File(File_Path);
            Scanner output=new Scanner(file);
            int count=1;
            
            while(output.hasNext()){
                
                String X=output.nextLine();
                if (X.charAt(0)=='='){
                    
                    String get="";
                    for (int i=0;i<X.length();i++)
                        if (X.charAt(i)!='='&&X.charAt(i)!='>'&&X.charAt(i)!=' ')
                            get+=X.charAt(i);
                    
                    SetData( GetDataDecoding(get) , count );
                    count++;
                }
            }
            
            output.close();
        }
        catch(Exception e){
            
            this.dispose();
            System.exit(0);
        }
        Size=acount.size();
    }
    
    private void SetData(String Data,int count){
        
        if (count%3==1){
            ac=new Acount();
            ac.SetSite(Data);
        }
        else if (count%3==2)
            ac.SetName(Data);
        else {
            ac.SetPassWord(Data);
            acount.add(ac);
        }
    }
    
    private String GetDataDecoding(String Data){
        
        String get="";
        try{
            for (int i=0;i<Data.length();){

                int f=0;
                for (;;i++){
                    if (Data.charAt(i)=='.')
                        break;
                    f*=10;
                    f+=((int)Data.charAt(i)-48);
                }
                f/=2;
                get+=(char) (f);
                i++;
            }
        }
        catch(Exception E){
            
            this.dispose();
            System.exit(0);
        }
        return get;
    }
    
    
    private void CreateFrame(){
        
        this.setTitle("My Acounts");
        this.setSize( 400 , 330 );
        this.setResizable(false);
        this.setLocation( 450 , 200 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
    
    private void CreatePanels(){
        
        PLocation=new JPanel();
        //PLocation.setBackground(Color.red);
        PLocation.setLayout(new FlowLayout(FlowLayout.LEFT));
        PLocation.setBorder(new EmptyBorder(10,0,0,0));
        
        PAcount=new JPanel();
        //PAcount.setBackground(Color.BLUE);
        PAcount.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PPassWord=new JPanel();
        //PPassWord.setBackground(Color.GREEN);
        PPassWord.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        Show_Acount=Box.createVerticalBox();
        Show_Acount.setBorder(new EmptyBorder(8,8,8,8));
        
        PButton=new JPanel();
        //PButton.setBackground(Color.YELLOW);
        PButton.setBorder(new EmptyBorder(5,0,0,0));
        
        PRemove=new JPanel();
        PRemove.setBorder(new EmptyBorder(5,0,0,0));
        
        Small_Box=Box.createVerticalBox();
        Small_Box.setBorder(new EmptyBorder(8,8,8,8));
        
        PButtona=new JPanel();
        //PButtona.setBackground(Color.PINK);
        PButtona.setBorder(new EmptyBorder(10,0,0,0));
        
        Big_Box=Box.createVerticalBox();
        Big_Box.setBorder(new EmptyBorder(5,5,5,5));
    }
    
    private void CreateComponents(){
        
        font=new Font("Serif",Font.PLAIN,15);
        
        Location=new JLabel();
        Location.setText("Web     ==>> ");
        Location.setFont(font);
        
        ShowLocation=new JLabel();
        ShowLocation.setFont(font);
        ShowLocation.setForeground(Color.red);
        
        Acount=new JLabel();
        Acount.setText("Acount ==>> ");
        Acount.setFont(font);
        
        ShowAcount=new JLabel();
        ShowAcount.setFont(font);
        ShowAcount.setForeground(Color.red);
        
        PassWord=new JLabel();
        PassWord.setText("Pass     ==>> ");
        PassWord.setFont(font);
        
        sPassWord=new JLabel();
        sPassWord.setFont(font);
        sPassWord.setForeground(Color.red);
        
        Pre=new JButton();
        Pre.setText("Previes");
        Pre.addActionListener(new PreAction());
        
        Next=new JButton();
        Next.setText("Next");
        Next.addActionListener(new NextAction());
        
        Remove=new JButton();
        Remove.setText("Remove Acount");
        Remove.addActionListener(new RemoveAction());
        
        Back=new JButton();
        Back.setText("Back");
        Back.addActionListener(new BackAction());
    }
    
    private void SetText(){
        
        if (Size!=0){
            ShowLocation.setText(acount.get(0).GetSite());
            ShowAcount.setText(acount.get(0).GetName());
            sPassWord.setText(acount.get(0).GetPassWord());
        }
    }
    
    private void AddComponentsToFrame(){
        
        PLocation.add(Location);
        PLocation.add(ShowLocation);
        
        PAcount.add(Acount);
        PAcount.add(ShowAcount);
        
        PPassWord.add(PassWord);
        PPassWord.add(sPassWord);
        
        Show_Acount.add(PLocation);
        Show_Acount.add(Box.createVerticalStrut(3));
        Show_Acount.add(PAcount);
        Show_Acount.add(Box.createVerticalStrut(3));
        Show_Acount.add(PPassWord);
        
        PButton.add(Pre);
        PButton.add(Box.createHorizontalStrut(50));
        PButton.add(Next);
        
        PRemove.add(Remove);
        
        Small_Box.add(Show_Acount);
        Small_Box.add(Box.createVerticalStrut(5));
        Small_Box.add(PButton);
        Small_Box.add(Box.createVerticalStrut(5));
        Small_Box.add(PRemove);
        
        PButtona.add(Back);
        
        Big_Box.add(Small_Box);
        Big_Box.add(Box.createVerticalStrut(5));
        Big_Box.add(PButtona);
        
        this.add(Big_Box,BorderLayout.CENTER);
    }
    
    
    
    private class PreAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            if (Order-1>-1&&Size>0){
                
                Order--;
                ShowLocation.setText(acount.get(Order).GetSite());
                ShowAcount.setText(acount.get(Order).GetName());
                sPassWord.setText(acount.get(Order).GetPassWord());
            }
        }
    }
    
    private class NextAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            if (Order+1<=Size-1){
                
                Order++;
                ShowLocation.setText(acount.get(Order).GetSite());
                ShowAcount.setText(acount.get(Order).GetName());
                sPassWord.setText(acount.get(Order).GetPassWord());
            }
        } 
    }
    
    private class RemoveAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            int confirm=JOptionPane.showConfirmDialog( null , "Remove This Acount ???" );
            if (confirm==0&&Size!=0){
                
                acount.remove(Order);
                Size--;
                
                if (Order-1>-1&&Size>0){
                    
                    Order--;
                    ShowLocation.setText(acount.get(Order).GetSite());
                    ShowAcount.setText(acount.get(Order).GetName());
                    sPassWord.setText(acount.get(Order).GetPassWord());
                }
                else{
                
                    ShowLocation.setText("");
                    ShowAcount.setText("");
                    sPassWord.setText("");
                }
            }
        }
        
    }
    
    private class BackAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            try{
                File file=new File(File_Path);
                file.delete();
                file.createNewFile();
                
                PrintWriter input=new PrintWriter(file);
                
                for (int i=0;i<Size;i++){
                    
                    input.println( SetDataEncoding( Integer.toString(i) ) );
                    
                    input.print("===>> ");
                    input.println( SetDataEncoding( acount.get(i).GetSite() ));

                    input.print("===>> ");
                    input.println( SetDataEncoding( acount.get(i).GetName() ));

                    input.print("===>> ");
                    input.println( SetDataEncoding( acount.get(i).GetPassWord() ));

                    input.print("*******************************************************");
                    input.println("*******************************************************");
                }
                input.close();
            }
            catch(Exception E){     System.exit(0);     }
            
            SecondFrame.this.dispose();
            new FirstFrame();
        }
        
        private String SetDataEncoding(String Data){
        
            String set="";
            for(int i=0;i<Data.length();i++){
                int f=(int) Data.charAt(i)*2;
                set+=(f+".");
            }
            return set;
        }
    }
}
