package my.acounts.Records;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Consts {
    
    public String File_Path(){
        return "E:\\My Programs\\ProgramsFiles\\MyAcounts\\File.txt";
    }
    public Font GetFont(){
        return new Font("Serif",Font.PLAIN,15);
    }
    
    public void GetOut( String Location){
        JOptionPane.showMessageDialog( null, Location );
        System.exit(0);
    }
    
    public String SetDataEncoding( String Data){
        
        String SetData="";
        for(int i=0;i<Data.length();i++)
            SetData+=( (int) Data.charAt(i)*2 +".");
        
        return SetData;
    }
    public String GetDataDecoding( String Data, String Location){
        
        String GetData="";
        try{
            for (int i=0;i<Data.length();){
                int Number=0;
                for (;;i++){
                    if (Data.charAt(i)=='.')
                        break;
                    Number*=10;
                    Number+=((int)Data.charAt(i)-48);
                }
                Number/=2;
                GetData+=(char)Number;
                i++;
            }
        }
        catch(Exception E){
            GetOut(Location+" Wrong In Converting");
        }
        return GetData;
    }
    
    public void Save( Acount acount, String Location){
        try{
            File file=new File( File_Path() );
            try (PrintWriter input = new PrintWriter(new FileOutputStream(file,true))) {
                input.print("===>> ");
                input.println( SetDataEncoding( acount.Site ) );
                input.print("===>> ");
                input.println( SetDataEncoding( acount.Name ) );
                input.print("===>> ");
                input.println( SetDataEncoding( acount.Password ) );
                input.print("===>> ");
                input.println( SetDataEncoding( acount.Type ) );
                input.println("*******************************************************");
            }
        }
        catch(Exception E){
            GetOut(Location);
        }
    }
}