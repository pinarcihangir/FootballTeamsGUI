
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.util.NoSuchElementException;


public class TokenAlma 
{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static LinkedList list = new LinkedList();
    
    
    public static void main(String[] args)throws Exception, ParseException, NullPointerException 
    {
        
         try 
        {
            
            //Burada program çalışmazsa sporcu.txt adresinin yeniden ayarlanması gerekir.
            Scanner scanner =new Scanner(new File("src//sporcu.txt"));
            
            while(scanner.hasNextLine())
            {
                String delimiter= ",";
                String satir = scanner.nextLine();
                StringTokenizer st1 = new StringTokenizer(satir,delimiter);
                Bilgi oyuncu = new Bilgi();
                oyuncu.setAdSoyad(st1.nextToken());
                    /*Bu kısımıda dosyada verilmiş olan doğum tarihini Date tipine çevirebilmek
                      için gerekli düzenlemeler yapılıyor.
                    */
                    String sDate1 = st1.nextToken();
                    String bos="";
                    String delimiter2 = "/";
                    StringTokenizer sDate = new StringTokenizer(sDate1,delimiter2);
                    int sayac = 0;
                    while (sDate.hasMoreTokens())
                    {
                        String tokenler = sDate.nextToken();
                        
                        if(tokenler.length()==1 && sayac==1)
                        {
                            bos=bos+"0"+tokenler;
                                
                        }
                        else
                        {
                            if (sayac==0 && tokenler.length()==1)
                            {
                                bos = bos+"0"+tokenler;
                            }
                            bos+=tokenler;
                        }
                        
                        
                        sayac++;
                        if(sayac<=2)
                        {
                            bos+=".";
                        }
                        
                    }
                    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    String dateInString =bos;
                    Date date = formatter.parse(dateInString);
                    
                    //bilgi.setBirthDate(bos);
                    //Bunu Date'e çevirmenin yolunu bul
                    //System.out.println(formatter.format(date));
                    //System.out.println(date);
                    //System.out.println(date.toString());
                    //bilgi.setBirthDate(formatter.format(date));
                    oyuncu.setBirthDate(date);
                    oyuncu.setDate(bos);// Tarihleri String tipinde tutmamızı sağlıyor.
                    
                    
                while (st1.hasMoreTokens())
                {
                    //Buraya da kulüp ArrayList'e ekleyeceğimiz tokenler gelecek
                    
                    oyuncu.KulüpEkle(st1.nextToken());
                    
                    //Buradan tokenleri LinkedList'e ekleyeceğiz ekleyeceğiz.
                    //System.out.println("Tokenler =  "+st1.nextToken());// Bu kısım test için daha sonra silinmeli
                    //st1.nextToken();
                }
                //System.out.println("Oyuncu adı = "+oyuncu.getAdSoyad());
                //System.out.println("Oyuncu doğum tarihi = "+oyuncu.getBirthDate());
                //System.out.println("Oynadığı takımlar = "+oyuncu.getKulüp());
                //System.out.println("Oyuncu String tipinde Doğum tarihi = "+oyuncu.getDate());
                
                list.insertInOrder(oyuncu);
                
               
            }

            
            
            
            //list.writeFile();
            
            
            
            
            
            JFrame frame = new JFrame();
            frame.setSize(WIDTH,HEIGHT);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            
            frame.setLayout(new BorderLayout());
            frame.setTitle("SPORCU LİSTESİ");
            
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2,1));
            
            //Bu kısım sorulacak
            //frame.getContentPane().add(panel);
            
            
            JPanel ustpanel = new JPanel();
            // Üst panele ekleyeceğimi kısımlar
            JLabel listeLabel = new JLabel("EKRAN:                           ");
            ustpanel.add(listeLabel,BorderLayout.CENTER);
            JTextArea ekran = new JTextArea(15,48);
            JScrollPane scrollpane = new JScrollPane(ekran,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            
            ustpanel.add(scrollpane,BorderLayout.SOUTH);
            
            
            
            JPanel altpanel = new JPanel();
            // Alt panelde olacak elemanlar buraya girilecek
            JLabel girisLabel = new JLabel("Sporcunun adını giriniz ");
            altpanel.add(girisLabel,BorderLayout.CENTER);
            JTextField giris = new JTextField(50);
            altpanel.add(giris,BorderLayout.BEFORE_LINE_BEGINS);
            
            
            
            
            JPanel buttonPanel = new JPanel();
            
            buttonPanel.setLayout(new FlowLayout());
            JButton addButton = new JButton("Spocu Ekle");
            
            addButton.addActionListener(new ActionListener(){
                Bilgi oyuncu2 = new Bilgi();
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    String delimiter3 = ",";
                    String kullanilacakString = giris.getText();
                    
                    /*Yukarıda yaptığımız gibi Bilgi class'ından oyuncu adındaki nesnenin bilgilerini ayarlayıp
                    LinkedList olarak oluşturduğumuz ve Node nesnelerinden oluşan listeye ekleyeceğiz*/
                    try
                    {
                    StringTokenizer st3 = new StringTokenizer(kullanilacakString,delimiter3);
                    oyuncu2.setAdSoyad(st3.nextToken());//Ad soyad alıyor
                    String sDate1 = st3.nextToken();//Düzenleyeceğimiz tarih tokenini alıyor
                    String bos2 = "";
                    String delimiter4 = "/";
                    StringTokenizer sDate = new StringTokenizer(sDate1,delimiter4);
                    int sayac = 0;
                    while (sDate.hasMoreTokens())
                    {
                        //İkinci token tarih tokeni oluyor ve bu tarih tokenini formal şekilde biçimlendiriyoruz
                        //Mesela 3/9/1999 şeklinde aldığı tarihi 03.09.1999 şeklinde çeviriyor
                        String tokenler = sDate.nextToken();
                        
                        if(tokenler.length()==1 && sayac==1)
                        {
                            bos2=bos2+"0"+tokenler;
                                
                        }
                        else
                        {
                            if (sayac==0 && tokenler.length()==1)
                            {
                                bos2 = bos2+"0"+tokenler;
                            }
                            bos2+=tokenler;
                        }
                        
                        
                        sayac++;
                        if(sayac<=2)
                        {
                            bos2+=".";
                        }
                        
                    }
                    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    String dateInString =bos2;
                    //parse metodu ParseException hatası atıyor. Bunu nasıl throw new Exception ile çözebileceğimizi hocaya sor.
                    
                    try {
                         Date date = formatter.parse(dateInString);
                        oyuncu2.setBirthDate(date);
                    } catch (ParseException ex) {
                        //Logger.getLogger(TokenAlma.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Parsing Error");
                    }
                    
                    oyuncu2.setDate(bos2);
                    while (st3.hasMoreTokens())
                    {
                        oyuncu2.KulüpEkle(st3.nextToken());
                    }
                    ekran.setText(null);
                    ekran.append("Sporcu listeye başarılı şekilde eklendi...");
                    }catch(NoSuchElementException aee)
                    {
                        ekran.setText(null);
                        ekran.append("Lütfen kısıtlamalara uygun şekilde sporcu ekleyiniz");
                    }
                    list.insertInOrder(oyuncu2);
                    
                    
                     
                }
            });
            buttonPanel.add(addButton);
            
            
            
            
            
            JButton deleteButton = new JButton("Sporcu sil");
            
            deleteButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String kullanilacakString = giris.getText();
                    ekran.setText(null);
                    ekran.append(list.delete(kullanilacakString));
                }
            });
            buttonPanel.add(deleteButton);
            
            JButton listButton = new JButton("Listeyi Görüntüle");
            
            listButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    //Listeyi yazdırmadan önce listeyi temizledik.
                    ekran.setText(null);
                    ekran.setText(list.printstraight());
                    /*for(int i = 0; i<list.size();i++)
                    {
                        String oyuncuSatir = "";
                        oyuncuSatir += oyuncu.getAdSoyad();
                        oyuncuSatir +=" ";
                        oyuncuSatir += oyuncu.getDate();
                        oyuncuSatir +=" ";
                        oyuncuSatir += oyuncu.getKulüp();
                        oyuncuSatir += newline;
                        oyuncuSatir+="\n";
                        ekran.append(oyuncuSatir);
                        
                    }*/
                }
            });
            buttonPanel.add(listButton);
            
            JButton findButton = new JButton("Sporcu Bul");
            findButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ekran.setText(null);
                    String kullanilacakString = giris.getText();
                    ekran.append(list.findData(kullanilacakString));
                }
            });
            buttonPanel.add(findButton);
            
            JButton closeButton = new JButton("Programı sonlandırmak için tıklayınız");
            
            closeButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    list.writeFile();
                    System.exit(0);
                }
            });
            
            JMenu siralamaMenu = new JMenu("Sırala");
            JMenuItem duzSirala = new JMenuItem("A'dan Z' ye");
            duzSirala.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ekran.setText(null);
                    ekran.append(list.printstraight());
                }
            });
            siralamaMenu.add(duzSirala);
            JMenuItem tersSirala = new JMenuItem("Z'den A' ya");
            tersSirala.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ekran.setText(null);
                    ekran.append(list.printreverse());
                }
            });
            siralamaMenu.add(tersSirala);
            JMenuBar bar = new JMenuBar();
            bar.add(siralamaMenu);
            frame.setJMenuBar(bar);
        
            
            
            
            
            panel.add(ustpanel);
            
            panel.add(altpanel);

            
            buttonPanel.add(closeButton);
            altpanel.add(buttonPanel,BorderLayout.SOUTH);
            
            
            
            
            
            frame.add(panel);
            frame.setVisible(true);
            
            
        } catch (IOException e) 
        {
            System.out.println("Dosya Bulunamadı \nVeya Dosya Açılamadı...");
            System.exit(0);
        }
            
            
            
            
            
        
    }
}
    

