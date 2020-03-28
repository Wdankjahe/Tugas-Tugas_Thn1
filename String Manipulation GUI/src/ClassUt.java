

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassUt extends JFrame{
    String hsl="";    
    
    char alp;
    
    JButton[] masuk=new JButton[5];
    JLabel textAr=new JLabel();
    JTextArea[] input=new JTextArea[2];
    JRadioButton[] pil=new JRadioButton[3]; 
    int en;
    int tefile;
    String pat;
    String is1,is2;
    File fl;
    BufferedReader br;
    FileWriter fw;
      
    ClassUt()
    {        
        ButtonGroup bg= new ButtonGroup();
        this.setTitle("Program nge-ALAY");
        this.setDefaultCloseOperation(3);
        this.pack();
        this.setSize(372,504);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        
        this.add(textAr);
        textAr.setText(".:ALAY&RAHASIA2AN yuk:.");
        textAr.setFont(new Font("Tekton Pro",Font.PLAIN,20));
        textAr.setBounds(70,20,300,50);
        
        for (int i = 0; i < 2; i++) {
            input[i]=new JTextArea();                          
        }    
         for (int i = 0; i < 3; i++) {
            pil[i]=new JRadioButton();                          
        }    
        for (int i = 0; i < 5; i++) {
            masuk[i]=new JButton();                          
        }     
        this.add(input[0]);
        input[0].setBounds(33,60,300,140);
        this.add(input[1]);
        input[1].setBounds(33,205,300,140);
        input[1].setEditable(false);
             bg.add(pil[0]);
            bg.add(pil[1]);
            bg.add(pil[2]);
            this.add(pil[0]);
            pil[0].setBounds(210,350,60,35);
            pil[0].setText("Alay");
            pil[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                en=1;
            }
        });
            this.add(pil[1]);
            pil[1].setBounds(270,350,80,35);
            pil[1].setText("Cecar");
            pil[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                en=2;
                
            }
        });
            this.add(pil[2]);
            pil[2].setBounds(230,380,80,35);
            pil[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                en=3;              
            }
        });
            pil[2].setText("Normal");
            
            this.add(masuk[0]);
            masuk[0].setText("Open");
            masuk[0].setBounds(33,350,80,35);
            
            masuk[0].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                   SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                JFileChooser jf = new JFileChooser();
                jf.setCurrentDirectory(new File(System.getProperty("user.home")));
               
                try {
                    UIManager.setLookAndFeel(UIManager.getLookAndFeel());
                    jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    jf.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            return f.getName().endsWith(".txt");
                        }

                        @Override
                        public String getDescription() {
                            return "Standard Text file";
                        }
                    });
                } catch (Exception ex) {
                    
                }
                
                tefile=jf.showOpenDialog(null);
                if (tefile == JFileChooser.APPROVE_OPTION) {
                    fl=jf.getSelectedFile();
                }
                
                pat=fl.getPath();
                
                try {
                    br=new BufferedReader(new FileReader(fl));
                    
                    is1="";
                    is2="";
                    while ((is1=br.readLine())!=null) { 
                        is2+=is1+"\n";
                        
                    }
                    input[0].setText(is2);
                    br.close();
                } catch (Exception ex) {
                   
                }
                
                
            }
             });
      
                } catch (Exception ex) {
                    
                }
            }
        });
            this.add(masuk[1]);
            masuk[1].setText("Save");
            masuk[1].setBounds(120,350,80,35);    
            masuk[1].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                   SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                JFileChooser jf = new JFileChooser(); 
                try {
                    UIManager.setLookAndFeel(UIManager.getLookAndFeel());
                jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    jf.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            return f.getName().endsWith(".txt");
                        }

                        @Override
                        public String getDescription() {
                            return "Standard Text file";
                        }
                    });
                } catch (Exception ex) {
                    Logger.getLogger(ClassUt.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                               
                tefile=jf.showSaveDialog(null);                
                
                try {
                    
                    
                    is1=input[1].getText();
                    fw=new FileWriter(jf.getSelectedFile()+".txt");
                    
                    fw.write(is1);                                                            
                    fw.close();
                } catch (Exception ex) {
                    
                }
                
                
            }
        });
      
                } catch (Exception ex) {
                    
                }
            }
        });
            this.add(masuk[2]);
            masuk[2].setText("Wrap");            
            masuk[2].setBounds(33,390,80,35);
            masuk[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Fitur belum ada!");
            }
        });
            this.add(masuk[3]);
            masuk[3].setText("Clear");
            masuk[3].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 2; i++) {
                    input[i].setText("");
                }
                bg.clearSelection();
            }
        });
            masuk[3].setBounds(120,390,80,35);  
            this.add(masuk[4]);
            masuk[4].setText("Proses"); 
            masuk[4].setBounds(220,430,80,35); 
            masuk[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                pemilih(en);
            }
        });

        

        
    }
    public static void main(String[] args) {
        new ClassUt();
    }
    public String cecar()
    {
        String tes=input[0].getText();
        int i=3;
        hsl="";
        for (int j= 0; j < tes.length(); j++) {
            alp=tes.charAt(j);
            if (alp>= 'a' && alp <= 'z') {
                alp = (char) (alp+i);
                if (alp>'z') {
                    alp = (char) (alp-'z'+'a'-1);
                }
                hsl+=alp;
                
            }else if (alp>='A' && alp <='Z') {
                alp=(char)(alp+i);
                if (alp>'Z') {
                    alp=(char) (alp -'Z' + 'A'-1);
                    
                }
                hsl+=alp;
                
            }
            else   {
                hsl+=alp;
            }
        }
        return hsl;
    }
    public void normal(String inputan)
    {
         input[1].setText(inputan);
    }
    public void pemilih(int pil)
    {
        
        switch(pil)
        {
            case 1:input[1].setText(Al4y().concat(" "+Hurufs()));break;
            case 2:input[1].setText(cecar().concat(" "+Hurufs()));break;
            case 3:normal(input[0].getText()); break;            
        }
    }
    
    public String Hurufs()
    {
        char[] voc={'a','i','u','e','o'};
        char[] voC={'A','I','U','E','O'};
        int jmlvcl1=0,jmlvcl2=0;
        String cek;
        int pnj;
        if (en==2) {
            pnj=cecar().length();
            cek=cecar();
        }else if (en==1)
        {
            pnj=Al4y().length();
            cek=Al4y();
        }else
        {
            pnj=0;
            cek="";
        }
         for (int k = 0; k < input[0].getText().length(); k++) {
            for (int j = 0; j < voc.length; j++) {
            if (input[0].getText().charAt(k)==voc[j]||input[0].getText().charAt(k)==voC[j]) {
                jmlvcl1++;
            }

        }
        }
         for (int k = 0; k < pnj; k++) {
            for (int j = 0; j < voc.length; j++) {
            if (cek.charAt(k)==voc[j]||cek.charAt(k)==voC[j]) {
                jmlvcl2++;
            }

        }
        }
         if (en==2) {
            pnj=cecar().length();
        }else if (en==1)
        {
            pnj=Al4y().length();
        }else
        {
            pnj=0;
        }
         return "\n\nPanjang Karakter Kalimat Asli : " + input[0].getText().length() + "\n"+
"Jumlah Huruf Vokal Kalimat Asil : " +jmlvcl1+"\n"+
"\n" +
"Panjang Karakter Kalimat Setelah dienkripsi : " +pnj+"\n"+
"Jumlah Huruf Vokal Kalimat Setelah dienkripsi : "+jmlvcl2;
    }
    
    public String Al4y()
    {
        hsl=input[0].getText();
        char[] al={'4','8','3','!','ʞ','£','0','$','¥'};
        char[] ai={'a','b','e','i','k','l','o','s','y'};
        char[] aib={'A','B','E','I','K','L','O','S','Y'};
        for (int j = 0; j < al.length; j++) {           
            hsl=hsl.replace(ai[j],al[j]);
            hsl=hsl.replace(aib[j],al[j]);
        }
        return hsl;
    }
   
}
