package my.acounts.Activities;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import my.acounts.Records.Consts;
import my.acounts.Records.Acount;

public class CreateAcounts extends JFrame implements ActionListener{
    
    private JPanel PTitle,PLocation,PAcount,PPass,PCon_Pass,PType,PSave;
    private JLabel Title,Location,Acount,PassWord,Convirm_PassWord,Type;
    private JTextField TLocation,TAcount;
    private JPasswordField Pass,Con_Pass;
    private JButton Save,Show,Info;
    private JComboBox JType;
    private Box box;
    
    private final Consts Const=new Consts();
    
    public CreateAcounts(){
        
        CreateFrameAndPanels();
        CreateComponents();
        AddComponentsToFrame();
    }
    
    private void CreateFrameAndPanels() {
        
        this.setTitle("My Acounts");
        this.setSize( 340 , 360 );
        this.setResizable(false);
        this.setLocation( 450 , 140 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        PTitle=new JPanel();
        PTitle.setBorder(new EmptyBorder(5,5,5,5));
        PTitle.setLayout(new BorderLayout());
        
        PLocation=new JPanel();
        PLocation.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PAcount=new JPanel();
        PAcount.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PPass=new JPanel();
        PPass.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PCon_Pass=new JPanel();
        PCon_Pass.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PType=new JPanel();
        PType.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PSave=new JPanel();
        
        box=Box.createVerticalBox();
        box.setBorder(new EmptyBorder(15,15,15,15));
    }
    private void CreateComponents() {
        
        Info=new JButton();
        Info.setText("Info");
        Info.addActionListener( this );
        
        Title=new JLabel();
        Title.setText( "Hello Hady" );
        Title.setForeground(Color.red);
        Title.setHorizontalAlignment(JLabel.CENTER);
        
        Show=new JButton();
        Show.setText("Show");
        Show.addActionListener( this );
        
        Location=new JLabel();
        Location.setText("Location : ");
        
        TLocation=new JTextField();
        TLocation.setFont( Const.GetFont() );
        TLocation.setColumns(18);
        TLocation.setBorder(new EmptyBorder(2,3,2,3));
        TLocation.setLayout(new FlowLayout(FlowLayout.CENTER));
        TLocation.setHorizontalAlignment(JTextField.CENTER);
        TLocation.setForeground(Color.RED);
        
        Acount=new JLabel();
        Acount.setText("Handel : ");
        
        TAcount=new JTextField();
        TAcount.setFont( Const.GetFont() );
        TAcount.setBorder(new EmptyBorder(2,3,2,3));
        TAcount.setColumns(18);
        TAcount.setHorizontalAlignment(JTextField.CENTER);
        TAcount.setForeground(Color.red);
        
        PassWord=new JLabel();
        PassWord.setText("PassWord : ");
        
        Pass=new JPasswordField();
        Pass.setBorder(new EmptyBorder(3,3,3,3));
        Pass.setColumns(18);
        Pass.setHorizontalAlignment(JTextField.CENTER);
        Pass.setForeground(Color.red);
        Pass.setEchoChar('*');
        Pass.setFont( Const.GetFont() );
        
        Convirm_PassWord=new JLabel();
        Convirm_PassWord.setText("Convirm Pass :");
        
        Con_Pass=new JPasswordField();
        Con_Pass.setBorder(new EmptyBorder(3,3,3,3));
        Con_Pass.setColumns(18);
        Con_Pass.setHorizontalAlignment(JTextField.CENTER);
        Con_Pass.setForeground(Color.red);
        Con_Pass.setEchoChar('*');
        Con_Pass.setFont( Const.GetFont() );
        
        Type=new JLabel();
        Type.setText("Set Type : ");
        
        JType=new JComboBox();
        JType.setMaximumRowCount(4);
        JType.addItem("Competitive");
        JType.addItem("Social Media");
        JType.addItem("Mails");
        JType.addItem("Learning");
        JType.addItem("Reading");
        JType.addItem("Other");
        JType.setSelectedIndex(-1);
        
        Save=new JButton();
        Save.setText("Save Acount");
        Save.addActionListener( this );
    }
    private void AddComponentsToFrame() {
        
        PTitle.add(Info,BorderLayout.WEST);
        PTitle.add(Title,BorderLayout.CENTER);
        PTitle.add(Show,BorderLayout.EAST);
        
        PLocation.add(Location);
        PLocation.add(Box.createHorizontalStrut(20));
        PLocation.add(TLocation);
        
        PAcount.add(Acount);
        PAcount.add(Box.createHorizontalStrut(30));
        PAcount.add(TAcount);
        
        PPass.add(PassWord);
        PPass.add(Box.createHorizontalStrut(10));
        PPass.add(Pass);
        
        PCon_Pass.add(Convirm_PassWord);
        PCon_Pass.add(Con_Pass);
        
        PType.add(Type);
        PType.add(Box.createHorizontalStrut(20));
        PType.add(JType);
        
        PSave.add(Save);
        
        box.add(PLocation);
        box.add(Box.createVerticalStrut(5));
        box.add(PAcount);
        box.add(PPass);
        box.add(PCon_Pass);
        box.add(PType);
        box.add(PSave);
        
        this.add(PTitle,BorderLayout.NORTH);
        this.add(box,BorderLayout.CENTER);
    }

    // For Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Info":
                this.dispose();
                new Info();
                break;
            case "Show":
                this.dispose();
                new ShowAcounts();
                break;
            default:
                if ( CheckData() ){
                    SaveData();
                    SetData();
                }
                else
                    JOptionPane.showMessageDialog( null, "Please Enter Full Info");
                break;
        }
    }
    private boolean CheckData(){

        if ( TLocation.getText().length()==0 )
            return false;
        if ( TAcount.getText().length()==0 )
            return false;
        if ( String.valueOf( Pass.getPassword() ).length()==0 )
            return false;
        if ( !String.valueOf(Pass.getPassword()).equals( String.valueOf(Con_Pass.getPassword()) ) )
            return false;
        return JType.getSelectedIndex() != -1;
    }
    private void SaveData(){

        Acount acount=new Acount();

        acount.Site=TLocation.getText();
        acount.Name=TAcount.getText();
        acount.Password=String.valueOf( Pass.getPassword() );
        acount.Type=JType.getSelectedItem().toString();

        Const.Save( acount , "From SaveAcounts In Line 231");
        JOptionPane.showMessageDialog(null,"Operation Complete \" Saved Acount \" ");
    }
    private void SetData(){

        TLocation.setText("");
        TAcount.setText("");
        Pass.setText("");
        Con_Pass.setText("");
        JType.setSelectedIndex(-1);
    }
}