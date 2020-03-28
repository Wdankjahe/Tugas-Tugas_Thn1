import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.text.*;

public class Klien extends JFrame  {
    //klien merah, server biru
    PrintStream output;
    String res;
    DataInputStream input;
    BufferedReader give;
    Socket clien;
    OutputStream ost ;
    PrintWriter pwrite ;
    InputStream ist;
    BufferedReader rec;  
    String hsilcon;
   boolean daduDah = false;
    int i=0,dadu=0,dadu2=0;   
    String ip;    
    String respon;
    int curLoc=0;
    Boolean out=false;
    Boolean win=false,reset = false;
    boolean thr=false;
    int k=0;
    int l;
    int loc1=0,loc2=0;
    int tulisdoang;
    ImageIcon mrah = new ImageIcon("Merah.png");
    ImageIcon biru = new ImageIcon("Biru.png");
    ImageIcon cur,waiting;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    int we=65,he=65;
    JButton acak=new JButton();
    JLabel giliran=new JLabel();
    JTextPane[] layout=new JTextPane[100];   
    JTextPane ddu = new JTextPane();
    StyledDocument doc = ddu.getStyledDocument();
   StyleContext con = StyleContext.getDefaultStyleContext();   
   
    SimpleAttributeSet atset = new SimpleAttributeSet();
    StyledDocument doc2;
    
    Runnable r=new moveWait();

    public class moveWait implements Runnable
    {
        
        @Override
        public void run() {

            moving();
            
                 
        
        }
        
       public void moving()
       {
            
           if (cur==mrah) {
                ddu.setText(Integer.toString(dadu)); 
               curLoc = loc1;
               
               acak.setEnabled(false);
               
               for (int j = 0; j < dadu; j++) {
                   
                   
                   layout[loc1].setText(Integer.toString(loc1+1));
                   if (loc1==99 && reset==true) {
                       
                       loc1=0;
                       layout[0].setText(Integer.toString(1));
                       curLoc=0;
                       
                       
                   }else
                   {
                       
                       loc1++;
                       
                   }
                   
                   if ((curLoc+dadu)==99) {
                       win=true;
                       reset=false;
                       
                       
                   }else if((curLoc+dadu)>99)
                   {
                       
                       reset=true;
                   }
                   if (loc1==loc2) {
                       layout[loc1].setText(Integer.toString(loc1));
                       layout[loc1].insertIcon(cur);                   
                   layout[loc2].insertIcon(waiting);
                   }else
                   {
                        layout[loc1].insertIcon(cur);                   
                   layout[loc2].insertIcon(waiting);
                   }
                   
                   try {
                       Thread.sleep(1000);
                       
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Klien.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                   
               }
               Thread.currentThread().interrupt();
               
               if (win==true&&cur==mrah) {
                   JOptionPane.showMessageDialog(null, "Winner Merah");
               }
//               System.out.println("Merah");

               ddu.setText("");
               cur=biru;
               waiting=mrah;
               thr=true;
               giliran.setIcon(cur);
               
               giliran.setText("  Giliran Biru");
           }else if(cur==biru)
           {
               
               curLoc=loc2;
               
               for (int j = 0; j <dadu2 ; j++) {
                   layout[loc2].setText(Integer.toString(loc2+1));
                   if (loc2==99 && reset==true) {
                       
                       loc2=0;
                       layout[0].setText(Integer.toString(1));
                       curLoc=0;
                       
                       
                   }else
                   {
                       
                       loc2++;
                       
                   }
                   
                   if ((curLoc+dadu2)==99) {
                       win=true;
                       reset=false;
                       
                       
                   }else if((curLoc+dadu2)>99)
                   {
                       
                       reset=true;
                   }
                   if (loc1==loc2) {
                       layout[loc2].setText(Integer.toString(loc2));
                       layout[loc2].insertIcon(cur);                   
                   layout[loc1].insertIcon(waiting);
                   }else
                   {
                        layout[loc2].insertIcon(cur);                   
                   layout[loc1].insertIcon(waiting);
                   }
                   
                   try {
                       Thread.sleep(1000);
                       
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Klien.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   if (win==true&&cur==biru) {
                   JOptionPane.showMessageDialog(null, "Winner Biru");
               }
                   
               }
               
               
               Thread.currentThread().interrupt();
               
               cur=mrah;
               waiting=biru;
//               System.out.println("Biru");
               acak.setEnabled(true);
               giliran.setIcon(cur);
             daduDah = false;
               giliran.setText("  Giliran Merah");

                
          }
       }
        
    }
    //885,682
    Klien()
    {
        
       
        
        StyleConstants.setAlignment (atset, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), atset, false);
        
        this.setTitle("Klien");
        this.setDefaultCloseOperation(3);
        
        this.setSize(885,682);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        Font font=new Font("Serif", Font.PLAIN, 15);
        String[] type = {"Tahoma","Comic Sans"};
        int[] size = {15,150};
        Style style ;
        
        for (int j = 0; j < 100; j++) {
             
             layout[j]=  new JTextPane();   
            doc2=layout[j].getStyledDocument();
            doc2.setParagraphAttributes(0, doc2.getLength(), atset, false); 
            StyleConstants.setAlignment(atset, StyleConstants.ALIGN_CENTER);
            k=j+1;            
            this.add(layout[j]);
            layout[j].setBorder(border);
            layout[j].setEnabled(false);    
            layout[j].setDisabledTextColor(Color.black);            
            layout[j].setFont(font);
            layout[j].setText( "\n"+Integer.toString(k));
       
            }
            
         
             l=0;
          for (int j = 0; j < 10; j++) {
             
             layout[j].setBounds(l,he*i,we,he);
             l+=he;
            }
          
         i++;
          for (int j = 10; j < 20; j++) {
              l-=he;
             layout[j].setBounds(l,he*i,we,he);
             
            }
          i++;
          l=0;
          for (int j = 20; j < 30; j++) {
              
             layout[j].setBounds(l,he*i,we,he);
              l+=he;
            }
         i++;
          for (int j = 30; j < 40; j++) { 
              l-=he;
             layout[j].setBounds(l,he*i,we,he);
             
            }
          i++;
          l=0;
          for (int j = 40; j < 50; j++) {
             
             layout[j].setBounds(l,he*i,we,he);
              l+=he;
            }
         i++;
          for (int j = 50; j < 60; j++) {
              
               l-=he;
             layout[j].setBounds(l,he*i,we,he);
             
            }
          i++;
          l=0;
          for (int j = 60; j < 70; j++) {
               
             layout[j].setBounds(l,he*i,we,he);
              l+=he;
            }
         i++;
          for (int j = 70; j < 80; j++) {
               l-=he;
             layout[j].setBounds(l,he*i,we,he);
              
            }
          i++;
          l=0;
          for (int j = 80; j < 90; j++) {
             
             layout[j].setBounds(l,he*i,we,he);
              l+=he;
            }
          
         i++;
          for (int j = 90; j < 100; j++) {
               l-=he;
             layout[j].setBounds(l,he*i,we,he);
              
            }
          
          layout[0].insertIcon(mrah);
          layout[0].insertIcon(biru);
          
          this.add(ddu);
          ddu.setBounds(680, 100, 160, 160);
          ddu.setBorder(border);
          
          ddu.setEnabled(false);
          ddu.setBackground(Color.getHSBColor(0, 0, (float) 0.93));
          ddu.setDisabledTextColor(Color.black);
          ddu.setFont(new Font("Tahoma", Font.PLAIN,15));
          this.add(acak);
          acak.setBounds(700,270,120,50);          
          acak.setText("Acak Dadu");
          acak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              output.println("go");
             
             output.flush();
            new Thread(r).start();
            
            }
        });
          cur = mrah;
          waiting = biru;
          this.add(giliran);
          giliran.setBounds(710,330 ,150,100);
          giliran.setText("  Giliran Merah");
          
          giliran.setBackground(Color.getHSBColor(0, 0, (float) 0.93));
          giliran.setFont(font);
          giliran.setIcon(cur);
          
           try {
        
            
        ip=JOptionPane.showInputDialog(null, "Masukkan IP Address dari komputer yang berjalan pada port 9090 ");
        give= new BufferedReader(new InputStreamReader(System.in));                         
        clien= new Socket("localhost",9090);
        ist= clien.getInputStream();  
        ost= clien.getOutputStream();
        pwrite = new PrintWriter(ost,true);
        output = new PrintStream(clien.getOutputStream());
        input = new DataInputStream(clien.getInputStream());
         DataInputStream inDadu = new DataInputStream(clien.getInputStream());
        PrintStream givDadu = new PrintStream(clien.getOutputStream());
        pwrite.println(ip);
        rec = new BufferedReader(new InputStreamReader(ist));
        pwrite.flush();
        System.out.println("klien");
        
               if ((hsilcon=input.readLine())!=null && hsilcon.equals("Berhasil")) {
                   
                  
                    do {    
                        
                       
                        if (!daduDah) {
                            dadu=Randi();
                             pwrite.print(dadu);
                             pwrite.flush();
                            dadu2=inDadu.read()-48;
                            daduDah=true;
                           
                        }
                       
//                       if (cur==mrah ) {
//                    
//                       }else 
                           if(cur==biru)
                       {             
//                           System.out.println("Biru!");
                           if ((respon=inDadu.readLine()).equals("go")) {
//                               System.out.println(respon);
                               new Thread(r).start();
                               
                           }
                                                    
                        
                       }
                           
                           System.out.print("\b");
//                       output.flush();
                      
                   } while (clien.isConnected());
                   
                      
                    
               }else
               {
                   int lo=JOptionPane.showConfirmDialog(null, hsilcon, "Koneksi gagal", JOptionPane.YES_NO_CANCEL_OPTION);
                   if (lo==JOptionPane.CANCEL_OPTION) {
                       System.exit(0);
                   }
               }

        } catch (IOException ex) {
            Logger.getLogger(Klien.class.getName()).log(Level.SEVERE, null, ex);
        }
          
//          if () {
//            
//        }
         
          
    }
    
    public static void main(String[] args) {
       new Klien();
        
        
        
    }   
    public static int Randi()
    {        
        int rando = ThreadLocalRandom.current().nextInt(1,7);
        return rando;
   }
    
        
    
    
}
