package my.acounts.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import my.acounts.Records.Consts;

public class FeedBack extends JFrame implements FocusListener,ActionListener{
    
    private JPanel PTitle,PCenter,POptions,PInput,PSubmit;
    private JLabel Title,Result;
    private JButton Suggest,Bug,Submit;
    private JTextArea Input;
    private JScrollPane Scroll;
    
    private int OK = 0;
    private final Consts Const = new Consts();
    
    public FeedBack(){
        
        SetFrameAndPanels();
        SetComponents();
        AddComponentsToFrame();
    }

    private void SetFrameAndPanels() {
    
        this.setTitle("My Acounts");
        this.setSize( 390 , 370 );
        this.setResizable(false);
        this.setLocation( 477 , 199 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        PTitle = new JPanel();
        PTitle.setBackground(Color.BLACK);
        
        POptions = new JPanel();
        POptions.setBackground(Color.BLACK);
        POptions.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        POptions.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PInput = new JPanel();
        PInput.setBackground(Color.BLACK);
        PInput.setBorder(new EmptyBorder(10,0,0,0));
        
        PSubmit = new JPanel();
        PSubmit.setBackground(Color.BLACK);
        
        PCenter = new JPanel();
        PCenter.setLayout(new BorderLayout());
        PCenter.setBorder(new EmptyBorder(10,20,10,20));
        PCenter.setBackground(Color.BLACK);
    }
    private void SetComponents() {
    
        Title = new JLabel();
        Title.setText("FeedBack");
        Title.setForeground(Color.WHITE);
        
        Suggest = new JButton();
        Suggest.setBackground(Color.BLACK);
        Suggest.setText("Suggest");
        Suggest.setForeground(Color.WHITE);
        Suggest.addActionListener( this );
        
        Bug = new JButton();
        Bug.setBackground(Color.BLACK);
        Bug.setText("Bug");
        Bug.setForeground(Color.WHITE);
        Bug.addActionListener( this );
        
        Result = new JLabel();
        Result.setBackground(Color.BLACK);
        
        Input = new JTextArea();
        Input.setColumns(25);
        Input.setRows(12);
        Input.setLineWrap(true);
        Input.setWrapStyleWord(true);
        Input.setBorder(new EmptyBorder(3,3,3,3));
        Input.setForeground(Color.decode("#00D3FE"));
        Input.setBackground(Color.BLACK);
        Input.addFocusListener( this );
        
        Scroll = new JScrollPane(Input);
        Scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#00D3FE")));
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        Submit = new JButton();
        Submit.setText("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener( this );
    }
    private void AddComponentsToFrame() {
    
        PTitle.add(Title);
        
        POptions.add(Suggest);
        POptions.add(Bug);
        POptions.add(Box.createHorizontalStrut(5));
        POptions.add(Result);
        
        PSubmit.add(Submit);
        
        PInput.add(Scroll);
        
        PCenter.add(POptions,BorderLayout.NORTH);
        PCenter.add(PInput,BorderLayout.CENTER);
        PCenter.add(PSubmit,BorderLayout.SOUTH);
        
        this.add(PTitle,BorderLayout.NORTH);
        this.add(PCenter,BorderLayout.CENTER);
        Input.requestFocus();
    }

    @Override
    public void focusGained(FocusEvent e) {
    
        Input.setBackground(Color.decode("#181C17"));
    }

    @Override
    public void focusLost(FocusEvent e) {
    
        Input.setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if ( e.getSource()==Suggest ){
            Suggest.setBackground(Color.decode("#979C96"));
            Suggest.setForeground(Color.BLACK);
            if ( Bug.getBackground()!=Color.BLACK ){
                Bug.setBackground(Color.BLACK);
                Bug.setForeground(Color.WHITE);
            }
            OK = 1;
        }
        else if ( e.getSource()==Bug ){
            Bug.setBackground(Color.decode("#979C96"));
            Bug.setForeground(Color.BLACK);
            if ( Suggest.getBackground()!=Color.BLACK ){
                Suggest.setBackground(Color.BLACK);
                Suggest.setForeground(Color.WHITE);
            }
            OK = 2;
        }
        else{
            if ( OK==0 ){
                Result.setForeground(Color.red);
                Result.setText("Please Choose Suggest / Bug");
            }
            else if ( Input.getText().length()==0 ){
                Result.setForeground(Color.red);
                Result.setText("Please Enter The Data");
            }
            else{
                Save();
                if ( Bug.getBackground()!=Color.BLACK ){
                    Bug.setBackground(Color.BLACK);
                    Bug.setForeground(Color.WHITE);
                }
                if ( Suggest.getBackground()!=Color.BLACK ){
                    Suggest.setBackground(Color.BLACK);
                    Suggest.setForeground(Color.WHITE);
                }
                OK = 0;
                Input.setText("");
                Input.requestFocus();
                Result.setText("It Submitted Thanks");
                Result.setForeground(Color.GREEN);
            }
        }
    }
    private void Save() {
    
        File file = new File("E:\\My Programs\\ProgramsFiles\\MyAcounts\\FeedBack.txt");
        try( PrintWriter in = new PrintWriter(new FileOutputStream(file,true)) ){
            in.println();
            if ( Bug.getBackground()!=Color.BLACK )
                in.println("Bug :-");
            else
                in.println("Suggest :-");
            in.println();
            String Text = Input.getText();
            for (int i=0;i<Text.length();i++)
                if ( Text.charAt(i)=='\n' )
                    in.println();
                else
                    in.print(Text.charAt(i));
            in.println();
            in.println("**************************************************************");
            in.println("**************************************************************");
            in.close();
        }
        catch( Exception E){
            Const.GetOut("From FeedBack in Line 218");
        }
    }
}
