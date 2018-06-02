package my.acounts.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import my.acounts.Activities.CreateAcounts;

public class Info extends JFrame implements ActionListener{
    
    private JPanel PTitle,PShow;
    private JLabel Title,Show;
    
    public Info(){
        
        SetFrameAndPanels();
        SetComponentsAndAddToFram();
    }
    
    private void SetFrameAndPanels() {
    
        this.setTitle("My Acounts");
        this.setSize( 340 , 360 );
        this.setResizable(false);
        this.setLocation( 503 , 199 );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        PTitle=new JPanel();
        PTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        PTitle.setBackground(Color.BLACK);
        
        PShow=new JPanel();
        PShow.setBorder(new EmptyBorder(10,10,10,10));
        PShow.setBackground(Color.BLACK);
    }
    private void SetComponentsAndAddToFram() {
        
        Title=new JLabel();
        Title.setText("About");
        Title.setForeground(Color.WHITE);
        Title.setHorizontalAlignment(JLabel.CENTER);
        
        Show=new JLabel();
        Show.setText("<html>\n" +
"<head>\n" +
"    <style type=text/css>\n" +
"        span{color: #23E400;}\n" +
"        p{\n" +
"            font-size: 10px;\n" +
"            color: #FFFFFF;\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <br><p style=\"margin-left: 12px\">Project Name &nbsp;: &nbsp;<span>My Acounts</span></p>\n" +
"    <br><p >Project Purpose &nbsp;: &nbsp;<span>To Save Acounts</span></p>\n" +
"    <br><p >Version Number &nbsp;: &nbsp;<span>2 . 1</span></p>\n" +
"    <br><p style=\"margin-left: 47px\">Author &nbsp;: &nbsp;<span>Hady Eslam</span></p>\n" +
"    <br><p >Version Release Date &nbsp;: &nbsp;<span>01 / 06 / 2018</span></p>\n" +
"    <br><p >Project Release Date &nbsp;&nbsp;: &nbsp;<span>28 / 12 / 2017</span></p>\n" +
"</body>\n" +
"</html>\"");
        
        PTitle.add(Title);
        
        PShow.add(Show);
        
        this.add(PTitle,BorderLayout.NORTH);
        this.add(PShow,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        this.dispose();
        new CreateAcounts();
    }
}