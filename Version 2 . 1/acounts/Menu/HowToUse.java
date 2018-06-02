package my.acounts.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import my.acounts.Records.Consts;

public class HowToUse extends JFrame implements ActionListener{
    
    private JPanel PTitle,PForward,PShow,PBackward;
    private JLabel Title,Show;
    private JButton Backward,Forward;
    
    private final Consts Const = new Consts();
    private int number = 1;
    
    public HowToUse(){
        
        SetFrameAndPanels();
        SetComponents();
        AddComponentsToPanels();
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
        
        PBackward = new JPanel();
        PBackward.setBackground(Color.BLACK);
        PBackward.setLayout(new BorderLayout());
        PBackward.setBorder( BorderFactory.createCompoundBorder(
                new EmptyBorder(100,5,100,5),   BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"), 1),
                            new EmptyBorder(5,5,5,5))));
        
        PShow = new JPanel();
        PShow.setLayout(new BorderLayout());
        PShow.setBackground(Color.BLACK);
        
        PForward = new JPanel();
        PForward.setBackground(Color.BLACK);
        PForward.setLayout(new BorderLayout());
        PForward.setBorder( BorderFactory.createCompoundBorder(
                new EmptyBorder(100,5,100,5),   BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.decode("#00D3FE"), 1),
                            new EmptyBorder(5,5,5,5))));
    }
    private void SetComponents() {
    
        Title = new JLabel();
        Title.setText("How To Use Program");
        Title.setBackground(Color.BLACK);
        Title.setForeground(Color.WHITE);
        Title.setBorder(new EmptyBorder(10,10,10,10));
        
        Backward = new JButton();
        Backward.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Backword.PNG"));
        Backward.setBackground(Color.BLACK);
        Backward.setBorder(new EmptyBorder(30,15,30,15));
        Backward.addActionListener( this );
        
        Show = new JLabel();
        Show.setIcon(SetIcon(1));
        
        Forward = new JButton();
        Forward.setIcon(new ImageIcon("E:\\My Programs\\ProgramsFiles\\MyAcounts\\Icons\\Forward.PNG"));
        Forward.setBackground(Color.BLACK);
        Forward.setBorder(new EmptyBorder(30,15,30,15));
        Forward.addActionListener( this );
    }
    private void AddComponentsToPanels() {
    
        PTitle.add(Title);
        
        PBackward.add(Backward,BorderLayout.CENTER);
        
        PShow.add(Show,BorderLayout.CENTER);
        
        PForward.add(Forward,BorderLayout.CENTER);
        
        this.add(PTitle,BorderLayout.NORTH);
        this.add(PBackward,BorderLayout.WEST);
        this.add(PShow,BorderLayout.CENTER);
        this.add(PForward,BorderLayout.EAST);
    }

    private ImageIcon SetIcon(int i){
    
        File file = new File("E:\\My Programs\\ProgramsFiles\\MyAcounts\\HowToUse\\P"+i+".PNG");
        if ( !file.exists() ){
            Const.GetOut("From HowToUse in Line 111 (image not found)");
        }
        Image image;
        try{
            image = ImageIO.read(file);
            image = image.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        }
        catch(Exception e){
            Const.GetOut("From HowToUse in Line 120 (image not found)");
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if ( e.getSource()==Backward && number>1)
            number--;
        else if ( e.getSource()==Forward && number<12 )
            number++;
        Show.setIcon(SetIcon(number));
    }
}
