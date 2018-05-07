package my.acounts.Activities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import my.acounts.Records.Consts;
import my.acounts.Records.Acount;

public class ShowAcounts extends JFrame implements ActionListener{
    
    private JPanel PTitle,PLocation,PAcount,PPassWord,PType,PPre_Next,PRemove;
    private JLabel Title,Location,ShowLocation,Acount,ShowAcount,ShowPassword,Type,ShowType,ID;
    private JCheckBox Show;
    private JButton Back,Next,Pre,Remove;
    private Box Small,box,Big;
    
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
        Acount acount=new Acount();
        try{
            File file=new File( Const.File_Path() );
            Scanner output=new Scanner( file );
            int count=1;
            
            while(output.hasNext()){
                
                String Get=output.nextLine();
                switch ( count%5 ) {
                    case 1:
                        acount.Site=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 54" );
                        break;
                    case 2:
                        acount.Name=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 57" );
                        break;
                    case 3:
                        acount.Password=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 60" );
                        break;
                    case 4:
                        acount.Type=Const.GetDataDecoding( Get.substring(6) ,"From ShowAcounts In Line 63" );
                        break;
                    default:
                        Acounts.add( acount );
                        acount=new Acount();
                        break;
                }
                count++;
            }
            output.close();
        }
        catch(Exception E){
            Const.GetOut("From ShowAcounts In Line 75");
        }
    }
    
    private void CreateFrameAndPanels(){
        
        this.setTitle("My Acounts");
        this.setSize( 340 , 360 );
        this.setResizable(false);
        this.setLocation( 450 , 140 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        PTitle=new JPanel();
        PTitle.setLayout(new BorderLayout());
        PTitle.setBorder(new EmptyBorder(5,5,5,5));
        
        PLocation=new JPanel();
        PLocation.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PAcount=new JPanel();
        PAcount.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PPassWord=new JPanel();
        PPassWord.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PType=new JPanel();
        PType.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        Small=Box.createVerticalBox();
        Small.setBorder(new EmptyBorder(5,5,5,5));
        
        PPre_Next=new JPanel();
        
        PRemove=new JPanel();
        
        box=Box.createVerticalBox();
        box.setBorder(new EmptyBorder(5,5,5,5));
        
        Big=Box.createVerticalBox();
        Big.setBorder(new EmptyBorder(5,5,5,5));
    }
    private void CreateComponents(){
        
        Back=new JButton();
        Back.setText("<<==");
        Back.addActionListener( this );
        
        Title=new JLabel();
        Title.setText("Show Acounts");
        Title.setHorizontalAlignment(JLabel.CENTER);
        
        ID=new JLabel();
        ID.setText("0");
        ID.setForeground(Color.red);
        
        Location=new JLabel();
        Location.setText("Web     ==>> ");
        
        ShowLocation=new JLabel();
        ShowLocation.setFont( Const.GetFont() );
        
        Acount=new JLabel();
        Acount.setText("Acount ==>> ");
        
        ShowAcount=new JLabel();
        ShowAcount.setFont( Const.GetFont() );
        
        ShowPassword=new JLabel();
        ShowPassword.setFont( Const.GetFont() );
        
        Show=new JCheckBox();
        Show.setText("Show Pass ==>>");
        Show.setSelected(false);
        Show.addActionListener( this );
        
        Type=new JLabel();
        Type.setText("Type     ==>> ");
        
        ShowType=new JLabel();
        ShowType.setFont( Const.GetFont() );
        
        if ( !Acounts.isEmpty() )
            SetData();
        
        Pre=new JButton();
        Pre.setText("<=");
        Pre.addActionListener( this );
        
        Next=new JButton();
        Next.setText("=>");
        Next.addActionListener( this );
        
        Remove=new JButton();
        Remove.setText("Remove");
        Remove.addActionListener( this );
    }
    private void AddComponentsToFrame(){
        
        PTitle.add(Back,BorderLayout.WEST);
        PTitle.add(Title,BorderLayout.CENTER);
        PTitle.add(ID,BorderLayout.EAST);
        
        PLocation.add(Location);
        PLocation.add(ShowLocation);
        
        PAcount.add(Acount);
        PAcount.add(ShowAcount);
        
        PPassWord.add(Show);
        PPassWord.add(ShowPassword);
        
        PType.add(Type);
        PType.add(ShowType);
        
        Small.add(PLocation);
        Small.add(PAcount);
        Small.add(PPassWord);
        
        Small.add(PType);
        
        PPre_Next.add(Pre);
        PPre_Next.add(Box.createHorizontalStrut(50));
        PPre_Next.add(Next);
        
        PRemove.add(Remove);
        
        box.add(Small);
        box.add(PPre_Next);
        box.add(Box.createVerticalStrut(5));
        box.add(PRemove);
        
        Big.add(box);
        
        this.add(PTitle,BorderLayout.NORTH);
        this.add(box,BorderLayout.CENTER);
    }
    
    private void SetData(){
        
        SetColor();
        ID.setText( ""+(Order+1) );
        ShowLocation.setText( Acounts.get(Order).Site );
        ShowAcount.setText( Acounts.get(Order).Name );
        if ( Show.isSelected() )
            ShowPassword.setText( Acounts.get(Order).Password );
        else
            ShowPassword.setText( "**********" );
        ShowType.setText( Acounts.get(Order).Type );
    }
    private void SetColor(){
        String type = Acounts.get(Order).Type;
        Color color;
        
        switch ( type.charAt(0) ) {
            case 'C':
                color=Color.decode("#F71607");
                break;
            case 'S':
                color=Color.decode("#0B0EBA");
                break;
            case 'M':
                color=Color.decode("#2DAF00");
                break;
            case 'L':
                color=Color.decode("#C42A8A");
                break;
            case 'R':
                color=Color.decode("#6E6900");
                break;
            default:
                color=Color.decode("#10A898");
                break;
        }
        
        ShowLocation.setForeground(color);
        ShowAcount.setForeground(color);
        ShowPassword.setForeground(color);
        ShowType.setForeground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if ( e.getActionCommand().equals("<<==") ){
            this.dispose();
            new CreateAcounts();
        }
        else if ( e.getActionCommand().equals("<=")&&Order-1>-1&&Acounts.size()>0 ){
            Order--;
            SetData();
        }
        else if ( e.getActionCommand().equals("=>")&&Order+1<Acounts.size() ){
            Order++;
            SetData();
        }
        else if ( e.getActionCommand().equals("Remove") ){
            RemoveAction();
        }
        else if ( e.getActionCommand().equals("Show Pass ==>>") ){
            SetData();
        }
    }
    private void RemoveAction() {
        
        if ( !Acounts.isEmpty() ){
            if ( JOptionPane.showConfirmDialog( null, "Remove This Acount ???" )==0 ){
                Acounts.remove(Order);
                if (Order-1>-1){
                    Order--;
                    Save();
                    SetData();
                }
                else if ( !Acounts.isEmpty() ){
                    Save();
                    SetData();
                }
                else{
                    ShowLocation.setText( "" );
                    ShowAcount.setText( "" );
                    ShowPassword.setText( "" );
                    ShowType.setText( "" );
                }
            }
        }
    }
    private void Save(){
        try{
            File file=new File( Const.File_Path() );
            file.delete();
            file.createNewFile();

            for (int i=0;i<Acounts.size();i++)
                Const.Save( Acounts.get(i) ,"From ShowAcounts In Line 309" );
            JOptionPane.showMessageDialog(null,"Operation Complete \" Acount Removed \"");
        }
        catch( Exception E ){
            Const.GetOut( "From ShowAcounts In Line 313" );
        }
    }
}