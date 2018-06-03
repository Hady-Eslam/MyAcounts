package my.acounts.Activities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import my.acounts.Records.Consts;
import my.acounts.Records.Acount;

public class ShowAcounts extends JFrame implements ActionListener,FocusListener{
    
    private JPanel PTitle,PLocation,PAcount,PPassWord,PType,PBackword,PForward,PRemove,Center,PID,PCTitle,PHandel_Password;
    private JLabel Title,Location,Acount,Password,Type,ID,Result;
    private JTextField ShowAcount,ShowPassword;
    private JButton Back,Backword,Forward,Remove,Modify;
    
    private ArrayList<Acount> Acounts=new ArrayList<>();
    private final Consts Const=new Consts();
    private int Order=0;
    
    public ShowAcounts(){
     
        GetAcounts();
        CreateFrameAndPanels();
        CreateComponents();
        AddComponentsToFrame();
    }
      
    private void GetAcounts(){
        Acount acount = new Acount();
        try{
            File file = new File( Const.File_Path() );
            try (Scanner output = new Scanner( file )) {
                int count = 1;
                
                while(output.hasNext()){
                    
                    String Get = output.nextLine();
                    switch ( count%5 ) {
                        case 1:
                            acount.Site=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 60" );
                            break;
                        case 2:
                            acount.Name=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 63" );
                            break;
                        case 3:
                            acount.Password=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 66" );
                            break;
                        case 4:
                            acount.Type=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 69" );
                            break;
                        default:
                            Acounts.add( acount );
                            acount=new Acount();
                            break;
                    }
                    count++;
                }
            }
        }
        catch(Exception E){
            Const.GetOut("From ShowAcounts In Line 81");
        }
    }
    private void SetData(){
        
        String type = Acounts.get(Order).Type,color;
        switch ( type.charAt(0) ) {
            case 'C':
                color = "#F71607";
                break;
            case 'S':
                color = "#0B0EBA";
                break;
            case 'M':
                color = "#2DAF00";
                break;
            case 'L':
                color = "#C42A8A" ;
                break;
            case 'R':
                color = "#6E6900";
                break;
            default:
                color = "#10A898";
                break;
        }
        
        ID.setText( "<html><p style=\"color: #FFFDFD\">Acount &nbsp;&nbsp;&nbsp;<span style=\"color: " + color + "\">"
                + String.valueOf(Order+1) +"</span></p></body></html>" );
        
        Location.setText( "<html><p style=\"color: "+color+"\">"+Acounts.get(Order).Site+"</p></html>" );
        
        ShowAcount.setText( Acounts.get(Order).Name );
        ShowAcount.setForeground(Color.decode(color));
        
        ShowPassword.setText( Acounts.get(Order).Password);
        ShowPassword.setForeground(Color.decode(color));
        
        Type.setText("<html><p style=\"color: #FFFDFD\"><br>Type : -<br><br><span style=\"color: " + color + "\">"
                + Acounts.get(Order).Type +"</span></p></body></html>");
    }
    
    private void CreateFrameAndPanels(){
        
        this.setTitle("My Acounts");
        this.setSize( 450 , 400 );
        this.setResizable(false);
        this.setLocation( 448 , 173 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        PTitle=new JPanel();
        PTitle.setLayout(new BorderLayout());
        PTitle.setBorder(new EmptyBorder(10,20,10,0));
        PTitle.setBackground(Color.BLACK);
        
        PBackword = new JPanel();
        PBackword.setLayout(new BorderLayout());
        PBackword.setBackground(Color.BLACK);
        PBackword.setBorder( BorderFactory.createCompoundBorder(
                new EmptyBorder(80,5,80,5),   BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"), 1),
                            new EmptyBorder(5,5,5,5))));
        
        PID = new JPanel();
        PID.setBackground(Color.BLACK);
        
        PLocation=new JPanel();
        PLocation.setBackground(Color.BLACK);
        PLocation.setBorder(BorderFactory.createLineBorder(Color.decode("#00D3FE"), 1));
        
        PCTitle = new JPanel();
        PCTitle.setLayout(new BorderLayout());
        PCTitle.setBackground(Color.BLACK);
        
        PType=new JPanel();
        PType.setLayout(new BorderLayout());
        PType.setBackground(Color.BLACK);
        PType.setPreferredSize(new Dimension(90,200));
        PType.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(5,5,5,5), BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"), 1), 
                            new EmptyBorder(5,5,5,5))));
        
        PAcount=new JPanel();
        PAcount.setLayout(new FlowLayout(FlowLayout.LEFT));
        PAcount.setBackground(Color.BLACK);
        
        PPassWord=new JPanel();
        PPassWord.setLayout(new FlowLayout(FlowLayout.LEFT));
        PPassWord.setBackground(Color.BLACK);
        
        PHandel_Password = new JPanel();
        PHandel_Password.setLayout(new GridLayout(4,1));
        PHandel_Password.setBackground(Color.BLACK);
        PHandel_Password.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(5,5,5,5), BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"), 1), 
                            new EmptyBorder(5,5,5,5))));
        
        Center = new JPanel();
        Center.setLayout(new BorderLayout());
        Center.setBackground(Color.red);
        
        PForward = new JPanel();
        PForward.setLayout(new BorderLayout());
        PForward.setBackground(Color.BLACK);
        PForward.setBorder( BorderFactory.createCompoundBorder(
                new EmptyBorder(80,5,80,5),   BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"), 1),
                            new EmptyBorder(5,5,5,5))));
        
        PRemove=new JPanel();
        PRemove.setLayout(new FlowLayout(FlowLayout.LEFT));
        PRemove.setBackground(Color.BLACK);
        PRemove.setBorder(new EmptyBorder(10,75,10,0));
    }
    private void CreateComponents(){
        
        Back=new JButton();
        Back.addActionListener( this );
        Back.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Back.PNG"));
        Back.setBackground(Color.BLACK);
        Back.setToolTipText("Back");
        
        Title=new JLabel();
        Title.setText("Show Acounts");
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setForeground(Color.WHITE);
        
        Backword=new JButton();
        Backword.addActionListener( this );
        Backword.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Backword.PNG"));
        Backword.setBackground(Color.BLACK);
        Backword.setBorder(new EmptyBorder(30,15,30,15));
        Backword.setToolTipText("Previos");
        
        ID=new JLabel();
        ID.setText("Acount   0");
        ID.setBackground(Color.BLACK);
        ID.setForeground(Color.WHITE);
        
        Location = new JLabel();
        Location.setText("");
        
        Type = new JLabel();
        Type.setText("<html><br>Type : -<html>");
        Type.setForeground(Color.WHITE);
        
        Acount = new JLabel();
        Acount.setText("Handel : -");
        Acount.setForeground(Color.WHITE);
        
        ShowAcount = new JTextField();
        ShowAcount.setColumns(15);
        ShowAcount.setEditable(false);
        ShowAcount.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ShowAcount.setBackground(Color.BLACK);
        ShowAcount.setFont(new Font("sans-Serif",Font.BOLD,12));
        ShowAcount.addFocusListener( this );
        
        Password = new JLabel();
        Password.setText("Password : -");
        Password.setForeground(Color.WHITE);
        
        ShowPassword = new JTextField();
        ShowPassword.setColumns(15);
        ShowPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ShowPassword.setEditable(false);
        ShowPassword.setBackground(Color.BLACK);
        ShowPassword.setFont(new Font("sans-Serif",Font.BOLD,12));
        ShowPassword.addFocusListener( this );
        
        if ( !Acounts.isEmpty() )
            SetData();
        
        Forward = new JButton();
        Forward.addActionListener( this );
        Forward.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Forward.PNG"));
        Forward.setBackground(Color.BLACK);
        Forward.setBorder(new EmptyBorder(30,15,30,15));
        Forward.setToolTipText("Next");
        
        Remove = new JButton();
        Remove.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\delete.PNG"));
        Remove.addActionListener( this );
        Remove.setBackground(Color.BLACK);
        Remove.setToolTipText("Delete Acount");
        
        Modify = new JButton();
        Modify.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Modify.PNG"));
        Modify.setBackground(Color.BLACK);
        Modify.setToolTipText("Modify Acount");
        Modify.addActionListener( this );
        
        Result = new JLabel();
        Result.setBackground(Color.BLACK);
        Result.setForeground(Color.GREEN);
    }
    private void AddComponentsToFrame(){
        
        PTitle.add(Back,BorderLayout.WEST);
        PTitle.add(Title,BorderLayout.CENTER);
        
        PBackword.add(Backword,BorderLayout.CENTER);
        
        PID.add(ID);
        
        PLocation.add(Location);
        
        PCTitle.add(PID,BorderLayout.NORTH);
        PCTitle.add(PLocation,BorderLayout.SOUTH);
        
        PType.add(Type,BorderLayout.NORTH);
        
        PAcount.add(ShowAcount);
        
        PPassWord.add(ShowPassword);
        
        PHandel_Password.add(Acount);
        PHandel_Password.add(PAcount);
        PHandel_Password.add(Password);
        PHandel_Password.add(PPassWord);
        
        Center.add(PCTitle,BorderLayout.NORTH);
        Center.add(PType,BorderLayout.WEST);
        Center.add(PHandel_Password,BorderLayout.CENTER);
        
        PForward.add(Forward,BorderLayout.CENTER);
        
        PRemove.add(Remove);
        PRemove.add(Modify);
        PRemove.add(Box.createHorizontalStrut(5));
        PRemove.add(Result);
        
        this.add(PTitle,BorderLayout.NORTH);
        this.add(PBackword,BorderLayout.WEST);
        this.add(Center,BorderLayout.CENTER);
        this.add(PForward,BorderLayout.EAST);
        this.add(PRemove,BorderLayout.SOUTH);
        Forward.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if ( e.getSource()==Back ){
            this.dispose();
            new CreateAcounts();
        }
        else if ( e.getSource()==Backword&&Order-1>-1&&Acounts.size()>0 ){
            Close();
            Order--;
            SetData();
            Result.setText("");
        }
        else if ( e.getSource()==Forward&&Order+1<Acounts.size() ){
            Close();
            Order++;
            SetData();
            Result.setText("");
        }
        else if ( e.getSource()==Remove ){
            Close();
            RemoveAction();
        }
        else if ( e.getSource()==Modify ){
            Edit();
        }
    }
    private void RemoveAction() {
        
        if ( Acounts.isEmpty() )
            return ;
        
        if ( JOptionPane.showConfirmDialog( null, "Remove This Acount ???" )!=0 )
            return ;
            
        Acounts.remove(Order);
        if (Order-1>-1){
            Order--;
            if ( Save() ){
                Result.setText("Operation Remove Completed");
                SetData();
            }
        }
        else if ( !Acounts.isEmpty() ){
            if ( Save() ){
                Result.setText("Operation Remove Completed");
                SetData();
            }
        }
        else{
            if ( Save() ){
                Result.setText("Operation Remove Completed");

                ID.setText("Acount   0");
                Location.setText( "" );
                Acount.setText( "Handel : - " );
                ShowAcount.setText("");
                Password.setText( "Password : -" );
                ShowPassword.setText("");
                Type.setText( "Type : -" );
            }
        }
    }
    private boolean Save(){
        try{
            File file=new File( Const.File_Path() );
            file.delete();
            file.createNewFile();
            
            for (int i=0;i<Acounts.size();i++)
                Const.Save( Acounts.get(i) ,"From ShowAcounts In Line 395" );
            return true;
        }
        catch( Exception E ){
            Const.GetOut( "From ShowAcounts In Line 399" );
        }
        return false;
    }

    private void Edit() {
    
        if ( !ShowAcount.isEditable() ){
            Open();
            ShowAcount.requestFocus();
        }
        else{
            Close();
            Acounts.get(Order).Name = ShowAcount.getText();
            Acounts.get(Order).Password = ShowPassword.getText();
            if ( Save() ){
                Result.setText("Operation Edit Completed");
                SetData();
            }
        }
    }
    private void Open(){
        ShowAcount.setEditable(true);
        ShowAcount.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#00D3FE"),1),
                new EmptyBorder(3,3,3,3)));

        ShowPassword.setEditable(true);
        ShowPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#00D3FE"),1),
                new EmptyBorder(3,3,3,3)));

        Modify.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\OK.PNG"));
        this.revalidate();
    }
    private void Close(){
        
        ShowAcount.setEditable(false);
        ShowAcount.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ShowPassword.setEditable(false);
        ShowPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Modify.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Modify.PNG"));
        this.revalidate();
    }

    @Override
    public void focusGained(FocusEvent e) {
    
        if ( e.getSource()==ShowAcount && ShowAcount.isEditable() ){
            ShowAcount.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.decode("#00D3FE"),3),
                        new EmptyBorder(3,3,3,3)));
            
            ShowAcount.setBackground(Color.decode("#211D1D"));
        }
        else if ( e.getSource()==ShowPassword && ShowPassword.isEditable() ){
            ShowPassword.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"),3),
                            new EmptyBorder(3,3,3,3)));
            ShowPassword.setBackground(Color.decode("#211D1D"));
        }
        this.revalidate();
    }

    @Override
    public void focusLost(FocusEvent e) {
    
        if ( e.getSource()==ShowAcount && ShowAcount.isEditable() ){
            ShowAcount.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"),1),
                            new EmptyBorder(3,3,3,3)));
            ShowAcount.setBackground(Color.BLACK);
        }
        else if ( e.getSource()==ShowPassword && ShowPassword.isEditable() ){
            ShowPassword.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"),1),
                            new EmptyBorder(3,3,3,3)));
            ShowPassword.setBackground(Color.BLACK);
        }
        this.revalidate();
    }
}
