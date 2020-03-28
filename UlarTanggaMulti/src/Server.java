
import java.net.Inet4Address;
import java.net.InetAddress;
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
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.ImageIcon;

import javax.swing.text.*;

public class Server extends JFrame{
    String ip;
    //klien merah, server biru
     ServerSocket server;
            
    PrintStream output;
      DataInputStream input;
       Socket serviceSock=null;
        String inpAd="";
        
        boolean daduDahAmbil=false;
       String respon;  
         BufferedReader readi ;
         OutputStream ostrl;
         PrintWriter pwrite;
         InputStream istr;
         BufferedReader receivee;
            String receive, send;
    int i=0,dadu=0,dadu2=0;       
    int tulisdoang;
    int curLoc=0;
    Boolean win=false,reset = false;
    boolean out = false;
    int k=0;
    int l;
    int loc1=0,loc2=0;
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
   Boolean thr=true;
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
        
            if(cur==mrah)
           {
    
               for (int j = 0; j <dadu ; j++) {
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

               cur=biru;
               waiting=mrah;

               giliran.setIcon(cur);
               acak.setEnabled(true);
               
               giliran.setText("  Giliran Biru");
           }else if (cur==biru) {
              ddu.setText(Integer.toString(dadu2));
               curLoc = loc2;
               acak.setEnabled(false);
               
               for (int j = 0; j < dadu2; j++) {
                   
                   
                   layout[loc2].setText(Integer.toString(loc2+1));
                   if (loc2==99 && reset==true) {
                       
                       loc2=0;
                       layout[0].setText(Integer.toString(1));
                       curLoc=0;
                       
                       
                   }else
                   {
                       
                       loc2++;
                       
                   }
                   
                   if (curLoc+dadu2==99) {
                       win=true;
                       reset=false;
                       
                       
                   }else if(curLoc+dadu2>99)
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
                   
                   
               }
               Thread.currentThread().interrupt();
             
               if (win==true&&cur==biru) {
                   JOptionPane.showMessageDialog(null, "Winner Biru");
               }

               cur=mrah;
               waiting=biru;
               ddu.setText("");
               
               giliran.setIcon(cur);
                daduDahAmbil = false;
                giliran.setText("  Giliran Merah");
           }
       }
        
       
        
    }
    //885,682
    Server()
    {
        
        
       
        
        
        StyleConstants.setAlignment (atset, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), atset, false);
        
        this.setTitle("Server");
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
          acak.setEnabled(false);
          
          acak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                pwrite.println("go");
                
            pwrite.flush();
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
        ip=InetAddress.getLocalHost().getHostAddress();
       server = new ServerSocket(9090);  
            JOptionPane.showMessageDialog(null, "Waiting for connection..");
            
        serviceSock = server.accept(); 
        ostrl=serviceSock.getOutputStream();
        pwrite = new PrintWriter(ostrl, true);
        DataInputStream inDadu2 = new DataInputStream(serviceSock.getInputStream());
        PrintStream givDadu = new PrintStream(serviceSock.getOutputStream());
        istr = serviceSock.getInputStream();
        receivee = new BufferedReader(new InputStreamReader(istr));
        readi = new BufferedReader(new InputStreamReader(System.in));
        input = new DataInputStream(serviceSock.getInputStream());
        inpAd = input.readLine();
        output = new PrintStream(serviceSock.getOutputStream());
            System.out.println(ip);
            
            
            if (inpAd.equals(ip)) {
               
                
                
                output.println("Berhasil"); 
                JOptionPane.showMessageDialog(null, "Berhasil terhubung \n"+ ip);
                output.flush();
                
                do {
                     
                     if (!daduDahAmbil) {
                        dadu=input.read()-48;
                        dadu2=Randi();
                        
                         
                        output.print(dadu2);
                        output.flush();
                        daduDahAmbil = true;
                        
                    }
                     
                     
                     if (cur==mrah) {
                         
                          if ((respon=input.readLine()).equals("go")) {
//                              System.out.println(respon);
                             new Thread(r).start(); 
                         }
                                              
                                              
                                                                  
                    }
                     System.out.print("\b");
                    
                   
//                    output.flush();
                   
                } while (serviceSock.isConnected());
                         
                    
                      
                   
     
                 
            }else
            {
                output.println("Failed wrong IP");
                JOptionPane.showMessageDialog(null, "Failed to connect");
                serviceSock.close();
                pwrite.close();
                istr.close();
                output.close();
                input.close();
                ostrl.close();
                receivee.close();
                server.close();
                      
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    public static void main(String[] args) {
       new Server();
        
    }   
    public static int Randi()
    {        
        int rando = ThreadLocalRandom.current().nextInt(1,7);
        return rando;
   }
    
}
