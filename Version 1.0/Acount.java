package my.acounts;

public class Acount {
 
    private String Site="",Name="",PassWord="";
    
    public Acount(){
        
    }
    
    
    public void SetSite(String Site){
        this.Site=Site;
    }
    
    public void SetName(String Name){
        this.Name=Name;
    }
    
    public void SetPassWord(String PassWord){
        this.PassWord=PassWord;
    }
    
    
    public String GetSite(){
        return this.Site;
    }
    
    public String GetName(){
        return this.Name;
    }
    
    public String GetPassWord(){
        return this.PassWord;
    }
}
