
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



    
    class Node 
    {
        Bilgi sporcu;
        Node previous;//previous node name
        Node next;//next node name
    
    
        public Node()
        {
            sporcu=null;
            previous=null;
            next=null;
        
        }
    
        public Node(Bilgi sporcu, Node newPrevious, Node newNext)
        {
            this.sporcu=sporcu;
            previous=newPrevious;
            next=newNext;
        }
    
        public Node(Bilgi sporcu)
        {
            this.sporcu=sporcu;
        }
    }
    
    
   
    public class LinkedList{
        private Node head;
        private Node tail;
    
    
    public LinkedList()
    {
        head=null;
        tail=null;
    }
    
    public boolean isEmpty()
    {
        return head==null;
    }
    
    public String printstraight()
    {
        if(isEmpty())
        {
            return "Liste boş";
        }
        
        Node current=head;
        int i = 1;
        String bos = "";
        while(current!=null)
        {
            bos = bos+ String.valueOf(i)+". sporcu =\t"+current.sporcu.getAdSoyad()+" "
                    +current.sporcu.getDate() + "  "
                    +current.sporcu.getKulüp()+"\n"+"----------------------------------------------------------------------------------"+"\n";
            i++;
            current=current.next;
            /*System.out.printf(i+". sporcu =\t");
            System.out.print(current.sporcu.getAdSoyad());
            System.out.print(current.sporcu.getDate());
            System.out.print(current.sporcu.getKulüp());
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------");
            i++;
            current=current.next;*/
        }
        return bos;
    }
    
    public String printreverse()
    {
        if(isEmpty())
        {
            
            return "Liste boş...";
        }
        Node current = head;
        Node last =head;
        

        while (last.next!=null)
        {
            //Node temp = new Node();
            //temp = current;
            //current.previous=temp;
            current = last;
            last = last.next;
            last.previous=current;
        }
        
        int i = 1 ;
        String bos ="";
        while(last!=null)
        {
            bos = bos+ "Tersten bastrıldığında "+String.valueOf(i)+ ". sporcu =    "
                    +last.sporcu.getAdSoyad()+" "+last.sporcu.getDate()+"  "+last.sporcu.getKulüp()
                    +"\n"+"----------------------------------------------------------------------------------"+"\n";
            /*System.out.print("Tersten bastırıldığında "+i+". sporcu =\t");
            System.out.print(tail.sporcu.getAdSoyad());
            System.out.print(tail.sporcu.getDate());
            System.out.print(tail.sporcu.getKulüp());
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------");*/
            i++;
            last = last.previous;
        }
        return bos;
        
    }
    
    
    public String delete(String sporcuIsmi) throws NullPointerException
    {
        try
        {
            if(isEmpty())
            {
                return "Liste boş";
            }
            //Node temp = head ;
            /*
            Listede birden fazla aynı isimde oyuncu varsa ve kullanıcı bu ortak ismi girerse listedeki aynı isimde olan 
            tüm sporcuları silmek için bir for döngüsü yapıp bu döngüyü node sayısı kadar döndüreceğiz ve bu for'un altında 
            silme işlemi node sayısı kadar çalışacak. Her seferinde silme olmayacak sileceği isimden buldukça silme işlemini
            gerçekleştirecek.
            */
            /*int sayac = 1;
            while (temp.next !=null)
            {
                sayac++;
                temp = temp.next;
            }*/
            
            
            
            
                Node previousNode = head;
                Node currentNode = head;
                if(head.next!=null && currentNode.sporcu.getAdSoyad().compareToIgnoreCase(sporcuIsmi)!=0)
                {
                    currentNode = head.next;
                
                
                    while(currentNode.sporcu.getAdSoyad().compareToIgnoreCase(sporcuIsmi)!=0)
                    {
                        previousNode = currentNode;
                        currentNode = currentNode.next;//Silinmesi gereken node' a kadar geldi   
                    }
                
                    if(currentNode.next!=null)
                    {
                        currentNode = currentNode.next;//Bu silinmesi gereken node'dan bir sonraki node.
                        previousNode.next = currentNode;
                        currentNode.previous = previousNode;
                        //currentNode ve previousNode arasındaki node ile bağlantıyı yok ettik ve böylece listeden çıkmış oldu
                    }
                    else
                    {
                        previousNode.next = null;
                    
                    }   
                }
                //Listede sadece head varsa ve o da silinmesi gereken değerse head'i null'a eşitler ve liste boşalmış olur.
                else if(head.next==null && currentNode.sporcu.getAdSoyad().compareToIgnoreCase(sporcuIsmi)==0 )
                {
                    head = null;
                }
                //Silinmek istenen değer baştaysa ve head.next!=null ise head node'unu bir kaydırır ve eski head node'u ile bağlantı kesilmiş olur.
                else
                {
                    head = head.next; //previousNode yerine head yazıldı
                }
                if(isEmpty())
                {
                    System.out.println("Listede eleman kalmadı. Silmek için önce eleman ekleyiniz.");
                    
                }
            
            
        
            
            
    }
        catch(NullPointerException e)
        {
            if(findData(sporcuIsmi).equals("Aradığınız sporcu listede bulunamadı\n"))//findData aranan ögeyi bulamadığında bu string döndürmektedir.
            {
                return "Aradığınız sporcu listede bulunamadı...";
            }
            else
            {
                return "Lütfen kısıtlamalara uygun şekilde silme işlemi yapınız";
            }
            
        }
        
        return "Sporcu başarıyla silindi..";
         
    }
    
    public void insertInOrder(Bilgi insert)
    {
        if (isEmpty())
        {
            head=new Node(insert);
            tail = head;
        }
        
        else if(head.sporcu.getAdSoyad().compareToIgnoreCase(insert.getAdSoyad())>0)
        {
            head = new Node(insert,null,head);
        }
        else if(tail.sporcu.getAdSoyad().compareToIgnoreCase(insert.getAdSoyad())<=0)
        {
            tail = new Node(insert,tail,null);
            
            //tail = tail.next = new Node(insert,tail,null);
        }
        else
        {
            Node currentNode = head.next;
            Node previousNode =head;
            
            while(currentNode!=null && currentNode.sporcu.getAdSoyad().compareToIgnoreCase(insert.getAdSoyad())<=0)
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            previousNode.next = new Node(insert,previousNode,currentNode);
        }
    }
    
    public void writeFile() 
    {
        Node node = new Node();
        node = head;
            try 
            {
                PrintWriter outputStream = new PrintWriter("Dosya");
                int i = 1;
                while(node!=null)
                {
                    outputStream.printf(i+". sporcu =\t");
                    outputStream.print(node.sporcu.getAdSoyad());
                    outputStream.print(node.sporcu.getDate());
                    outputStream.print(node.sporcu.getKulüp());
                    outputStream.println();
                    outputStream.println("----------------------------------------------------------------------------------");
                    i++;
                    if(node.next!=null)
                    {
                        node = node.next;
                    }
                    else
                    {
                        break;
                    }
                    
                }
                outputStream.close();
            } 
            catch (FileNotFoundException ex) 
            {
                System.out.println("Dosya İşleminde Hata!");
                //Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        while (node.next!=null)
        {
            
            
            
            node = node.next;
        }
    }
    
    public int size()
    {
        int sayac =0;
        Node temp = head;
        while (temp!=null)
        {
            temp = temp.next;
            sayac++;
        }
        return sayac;
    }
    
    public Node find(String target)
    {
        Node position = head;
        String itemAtPosition;
        
        while (position!=null)
        {
            itemAtPosition = position.sporcu.getAdSoyad();
            if(itemAtPosition.equalsIgnoreCase(target))
            {
                return position;
            }
            position = position.next;
        }
        return null;
    
    }
    
    public String findData(String target)
    {
        Node result = find(target);
        if(result==null)
            return "Aradığınız sporcu listede bulunamadı\n";
        else
            
            return result.sporcu.getAdSoyad()+" "+result.sporcu.getDate()+" "+result.sporcu.getKulüp()+"\n";
    }

    
    
    
    }

    
    /*public void add(Bilgi sporcu)
    {
        Node node = new Node();
        node.setSporcu(sporcu);
        
        if(head==null)
        {
            head=node;
        }
        
        Node temp = new Node();
        while (temp.getNext()!=null)
        {
            
            
            
            
            temp = temp.getNext();
        }
        
        /*else if(node.getPrevious().getSporcu().getAdSoyad().compareToIgnoreCase(node.getSporcu().getAdSoyad())<0)//mesela ali vs azim
        {
            node.getPrevious().setnext( );
        }
    }*/



