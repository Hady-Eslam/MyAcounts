package my.acounts.Activities;

import my.acounts.Menu.Info;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import my.acounts.Menu.FeedBack;
import my.acounts.Menu.HowToUse;
import my.acounts.Records.Consts;
import my.acounts.Records.Acount;

public class CreateAcounts extends JFrame implements ActionListener ,FocusListener{
    
    private JPanel PTitle,PLocation,PAcount,PPass,PCon_Pass,PType,PSave,Center,PResult;
    private JLabel Title,Location,LWrong,Acount,AWrong,PassWord,PWrong,Convirm_PassWord,CWrong,Type,TWrong,Result;
    private JTextField TLocation,TAcount;
    private JPasswordField Pass,Con_Pass;
    private JButton Save,Show;
    private JComboBox JType;
    private Box box;
    
    private JMenuBar MenuBar;
    private JMenu Menu;
    private JMenuItem Use,FeedBack,About;
    
    private final Consts Const=new Consts();
    
    public CreateAcounts(){
        
        CreateFrameAndPanels();
        CreateComponents();
        AddComponentsToFrame();
    }
    
    private void CreateFrameAndPanels() {
        
        this.setTitle("My Acounts");
        this.setSize( 450 , 400 );
        this.setResizable(false);
        this.setLocation( 448 , 173 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        MenuBar = new JMenuBar();
        MenuBar.setBackground(Color.BLACK);
        MenuBar.setBorderPainted(true);
        MenuBar.setBorder(BorderFactory.createCompoundBorder(
                    new EmptyBorder(2,5,2,5),
                    BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE)));
        
        PTitle=new JPanel();
        PTitle.setBorder(new EmptyBorder(5,5,5,5));
        PTitle.setLayout(new BorderLayout());
        PTitle.setBackground(Color.BLACK);
        
        PLocation=new JPanel();
        PLocation.setLayout(new FlowLayout(FlowLayout.LEFT));
        PLocation.setBackground(Color.BLACK);
        
        PAcount=new JPanel();
        PAcount.setLayout(new FlowLayout(FlowLayout.LEFT));
        PAcount.setBackground(Color.BLACK);
        
        PPass=new JPanel();
        PPass.setLayout(new FlowLayout(FlowLayout.LEFT));
        PPass.setBackground(Color.BLACK);
        
        PCon_Pass=new JPanel();
        PCon_Pass.setLayout(new FlowLayout(FlowLayout.LEFT));
        PCon_Pass.setBackground(Color.BLACK);
        
        PType=new JPanel();
        PType.setLayout(new FlowLayout(FlowLayout.LEFT));
        PType.setBackground(Color.BLACK);
        
        PResult = new JPanel();
        PResult.setBackground(Color.BLACK);
        
        PSave=new JPanel();
        PSave.setBackground(Color.BLACK);
        PSave.setBorder(new EmptyBorder(0,0,10,0));
        
        box=Box.createVerticalBox();
        box.setBackground(Color.BLACK);
        
        Center = new JPanel();
        Center.setBorder( BorderFactory.createLineBorder(Color.BLACK, 10));
        Center.setBackground(Color.BLACK);
        Center.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    private void CreateComponents() {
        
        Menu = new JMenu();
        Menu.setText("Help");
        Menu.setForeground(Color.WHITE);
        
        Use = new JMenuItem();
        Use.setText("How To Use");
        Use.setBackground(Color.BLACK);
        Use.setForeground(Color.WHITE);
        Use.addActionListener( this );
        
        FeedBack = new JMenuItem();
        FeedBack.setText("FeedBack");
        FeedBack.setBackground(Color.BLACK);
        FeedBack.setForeground(Color.WHITE);
        FeedBack.addActionListener( this );
        
        About = new JMenuItem();
        About.setText("About");
        About.setBackground(Color.BLACK);
        About.setForeground(Color.WHITE);
        About.addActionListener( this );
        
        Title=new JLabel();
        Title.setText( "Hello Hady" );
        Title.setForeground(Color.red);
        Title.setHorizontalAlignment(JLabel.CENTER);
        
        Show=new JButton();
        Show.setIcon( new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Acount.PNG"));
        Show.addActionListener( this );
        Show.setBackground(Color.BLACK);
        
        Location=new JLabel();
        Location.setText("Location : ");
        Location.setForeground(Color.WHITE);
        
        TLocation=new JTextField();
        TLocation.setFont( Const.GetFont() );
        TLocation.setColumns(18);
        TLocation.setLayout(new FlowLayout(FlowLayout.CENTER));
        TLocation.setHorizontalAlignment(JTextField.CENTER);
        TLocation.setForeground(Color.decode("#00D3FE"));
        TLocation.setBackground(Color.BLACK);
        TLocation.addFocusListener( this );
        TLocation.setBorder( GetBorder( 1, Color.decode("#00D3FE")) );
        
        LWrong = new JLabel();
        LWrong.setForeground(Color.red);
        LWrong.setBackground(Color.BLACK);
        
        Acount=new JLabel();
        Acount.setText("Handel : ");
        Acount.setForeground(Color.WHITE);
        
        TAcount=new JTextField();
        TAcount.setFont( Const.GetFont() );
        TAcount.setColumns(18);
        TAcount.setHorizontalAlignment(JTextField.CENTER);
        TAcount.setForeground(Color.decode("#00D3FE"));
        TAcount.setBackground(Color.BLACK);
        TAcount.setBorder( GetBorder( 1, Color.decode("#00D3FE")) );
        TAcount.addFocusListener( this );
        
        AWrong = new JLabel();
        AWrong.setForeground(Color.red);
        AWrong.setBackground(Color.BLACK);
        
        PassWord=new JLabel();
        PassWord.setText("PassWord : ");
        PassWord.setForeground(Color.WHITE);
        
        Pass=new JPasswordField();
        Pass.setColumns(18);
        Pass.setHorizontalAlignment(JTextField.CENTER);
        Pass.setForeground(Color.decode("#00D3FE"));
        Pass.setEchoChar('*');
        Pass.setFont( Const.GetFont() );
        Pass.setBackground(Color.BLACK);
        Pass.addFocusListener( this );
        Pass.setBorder( GetBorder( 1, Color.decode("#00D3FE")) );
        
        PWrong = new JLabel();
        PWrong.setForeground(Color.red);
        PWrong.setBackground(Color.BLACK);
        
        Convirm_PassWord=new JLabel();
        Convirm_PassWord.setText("Convirm Pass :");
        Convirm_PassWord.setForeground(Color.WHITE);
        
        Con_Pass=new JPasswordField();
        Con_Pass.setColumns(18);
        Con_Pass.setHorizontalAlignment(JTextField.CENTER);
        Con_Pass.setForeground(Color.decode("#00D3FE"));
        Con_Pass.setEchoChar('*');
        Con_Pass.setFont( Const.GetFont() );
        Con_Pass.setBackground(Color.BLACK);
        Con_Pass.addFocusListener( this );
        Con_Pass.setBorder( GetBorder( 1, Color.decode("#00D3FE")) );
        
        CWrong = new JLabel();
        CWrong.setForeground(Color.red);
        CWrong.setBackground(Color.BLACK);
        
        Type=new JLabel();
        Type.setText("Set Type : ");
        Type.setForeground(Color.WHITE);
        
        JType=new JComboBox();
        JType.setBackground(Color.BLACK);
        JType.setForeground(Color.decode("#00D3FE"));
        JType.setMaximumRowCount(4);
        JType.addItem("Competitive");
        JType.addItem("Social Media");
        JType.addItem("Mails");
        JType.addItem("Learning");
        JType.addItem("Reading");
        JType.addItem("Other");
        JType.setSelectedIndex(-1);
        JType.addFocusListener( this );
        
        TWrong = new JLabel();
        TWrong.setForeground(Color.red);
        TWrong.setBackground(Color.BLACK);
        
        Result = new JLabel();
        Result.setBackground(Color.BLACK);
        
        Save=new JButton();
        Save.addActionListener( this );
        Save.setIcon( new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\OK.PNG"));
        Save.setBackground(Color.BLACK);
    }
    private void AddComponentsToFrame() {
        
        MenuBar.add(Menu);
        
        Menu.add(Use);
        Menu.add(FeedBack);
        Menu.add(About);
        
        PTitle.add(Title,BorderLayout.CENTER);
        PTitle.add(Show,BorderLayout.EAST);
        
        PLocation.add(Location);
        PLocation.add(Box.createHorizontalStrut(20));
        PLocation.add(TLocation);
        PLocation.add(LWrong);
        
        PAcount.add(Acount);
        PAcount.add(Box.createHorizontalStrut(30));
        PAcount.add(TAcount);
        PAcount.add(AWrong);
        
        PPass.add(PassWord);
        PPass.add(Box.createHorizontalStrut(10));
        PPass.add(Pass);
        PPass.add(PWrong);
        
        PCon_Pass.add(Convirm_PassWord);
        PCon_Pass.add(Con_Pass);
        PCon_Pass.add(CWrong);
        
        PType.add(Type);
        PType.add(Box.createHorizontalStrut(22));
        PType.add(JType);
        PType.add(TWrong);
        
        PResult.add(Result);
        
        PSave.add(Save);
        
        box.add(PLocation);
        box.add(PAcount);
        box.add(PPass);
        box.add(PCon_Pass);
        box.add(PType);
        box.add(PResult);
        
        Center.add(box);
        
        this.setJMenuBar(MenuBar);
        this.add(PTitle,BorderLayout.NORTH);
        this.add(Center,BorderLayout.CENTER);
        this.add(PSave,BorderLayout.SOUTH);
        TLocation.requestFocus();
    }
    
    private Border GetBorder( int Size, Color color){
        return BorderFactory.createCompoundBorder( 
                    BorderFactory.createLineBorder(color, Size, true),
                    new EmptyBorder(1,1,1,1)
               );
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if ( e.getSource() == Show ){
            this.dispose();
            new ShowAcounts();
        }
        else if ( e.getSource()==Save ){
            if ( CheckData() ){
                SaveData();
                SetData();
                Result.setForeground(Color.GREEN);
                Result.setText("Acount Saved");
            }
            else{
                Result.setForeground(Color.red);
                Result.setText("Please Enter Full Info");
            }
        }
        else if ( e.getSource()==About )
            new Info();
        else if ( e.getSource()==FeedBack )
            new FeedBack();
        else
            new HowToUse();
    }
    private boolean CheckData(){

        boolean Wrong = false;
        if ( TLocation.getText().length()==0 ){
            TLocation.setBorder( GetBorder( 3,Color.RED));
            LWrong.setText("Enter Location");
            Wrong = true;
        }
        if ( TAcount.getText().length()==0 ){
            TAcount.setBorder( GetBorder( 3,Color.RED));
            AWrong.setText("Enter Handel");
            Wrong = true;
        }
        if ( String.valueOf( Pass.getPassword() ).length()==0 ){
            Pass.setBorder( GetBorder( 3,Color.RED));
            PWrong.setText("Enter Password");
            Wrong = true;
        }
        if ( !String.valueOf(Pass.getPassword()).equals( String.valueOf(Con_Pass.getPassword()) ) ){
            Con_Pass.setBorder( GetBorder( 3,Color.RED));
            CWrong.setText("Password Wrong");
            Wrong = true;
        }
        if ( JType.getSelectedIndex() == -1 ){
            JType.setBorder( GetBorder(1,Color.RED));
            TWrong.setText("Enter Type");
            Wrong = true;
        }
        return !Wrong;
    }
    private void SaveData(){

        Acount acount=new Acount();

        acount.Site=TLocation.getText();
        acount.Name=TAcount.getText();
        acount.Password=String.valueOf( Pass.getPassword() );
        acount.Type=JType.getSelectedItem().toString();

        Const.Save( acount , "From SaveAcounts In Line 372");
    }
    private void SetData(){

        TLocation.setText("");
        TAcount.setText("");
        Pass.setText("");
        Con_Pass.setText("");
        JType.setSelectedIndex(-1);
    }

    @Override
    public void focusGained(FocusEvent e) {
    
        if ( e.getSource()==TLocation ){
            TLocation.setBorder( GetBorder(3, Color.decode("#00D3FE")) );
            TLocation.setBackground(Color.decode("#211D1D"));
            if ( LWrong.getText().length()!=0 )
                LWrong.setText("");
        }
        else if ( e.getSource()==TAcount ){
            TAcount.setBorder( GetBorder(3, Color.decode("#00D3FE")) );
            TAcount.setBackground(Color.decode("#211D1D"));
            if ( AWrong.getText().length()!=0 )
                AWrong.setText("");
        }
        else if ( e.getSource()==Pass ){
            Pass.setBorder( GetBorder(3, Color.decode("#00D3FE")) );
            Pass.setBackground(Color.decode("#211D1D"));
            if ( PWrong.getText().length()!=0 )
                PWrong.setText("");
        }
        else if ( e.getSource()==Con_Pass ){
            Con_Pass.setBorder( GetBorder(3, Color.decode("#00D3FE")) );
            Con_Pass.setBackground(Color.decode("#211D1D"));
            if ( CWrong.getText().length()!=0 )
                CWrong.setText("");
        }
        else{
            JType.setBorder( BorderFactory.createLineBorder(Color.decode("#00D3FE"),1) );
            if ( TWrong.getText().length()!=0 )
                TWrong.setText("");
        }
        Result.setText("");
        this.revalidate();
    }

    @Override
    public void focusLost(FocusEvent e) {
    
        if ( e.getSource()==TLocation ){
            TLocation.setBorder( GetBorder(1, Color.decode("#00D3FE")) );
            TLocation.setBackground(Color.BLACK);
        }
        else if ( e.getSource()==TAcount ){
            TAcount.setBorder( GetBorder(1, Color.decode("#00D3FE")) );
            TAcount.setBackground(Color.BLACK);
        }
        else if ( e.getSource()==Pass ){
            Pass.setBorder( GetBorder(1, Color.decode("#00D3FE")) );
            Pass.setBackground(Color.BLACK);
        }
        else if ( e.getSource()==Con_Pass ){
            Con_Pass.setBorder( GetBorder(1, Color.decode("#00D3FE")) );
            Con_Pass.setBackground(Color.BLACK);
        }
        else
            JType.setBorder( BorderFactory.createLineBorder(Color.decode("#00D3FE"),0) );
        this.revalidate();
    }
}