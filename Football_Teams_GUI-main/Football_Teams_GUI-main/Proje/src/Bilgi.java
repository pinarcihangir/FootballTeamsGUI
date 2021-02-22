
import java.util.Date;
import java.util.ArrayList;



public class Bilgi 
{
    private String adSoyad;
    private Date birthDate;
    private String date;//Bu String tipindeki date'i dosyaya yazdırırken kullancağız
    private ArrayList<String> kulüp= new ArrayList<String>();

    public Bilgi()
    {
        adSoyad="";
        birthDate=null;
        date = "";
        
    }
    /*public Bilgi(String adSoyad, Date birthDate, ArrayList<String> kulüp)
    {
        this.adSoyad=adSoyad;
        this.birthDate=birthDate;
        this.kulüp=kulüp;
    }*/
    //Bu constructor nasıl yazılması gerektiği hakkında hiçbir fikrim yok
    //Yazılıp yazılmalı mı ondan bile emin değilim.
    
    public String getAdSoyad() {
        return adSoyad;
    }

    
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    
    public Date getBirthDate() {
        return birthDate;
    }

    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    
    public ArrayList<String> getKulüp() {
        return kulüp;
    }

    
    public void setKulüp(ArrayList<String> kulüp) {
        this.kulüp = kulüp;
    }
    
    public void KulüpEkle(String KulüpAdı)
    {
        kulüp.add(KulüpAdı);
    
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
