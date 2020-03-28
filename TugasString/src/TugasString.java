import java.util.Scanner;
public class TugasString 
{
    
    public static void main(String[] args) {
        Scanner ipt;        
        ipt = new Scanner(System.in);
        int pil;
        do{
        System.out.println("===== Tugas 7 : String Manipulation =====");
        System.out.println("1. Backspace");
        System.out.println("2. Int to String");
        System.out.println("3. Palindrom");
        System.out.println("4. Exit");
        System.out.print("Pilihan = ");
        
        pil=ipt.nextInt();
        switch(pil)
        {
            case 1: Bcksps(); break;
            case 2: inTostring();break;
            case 3: Plindrom(); break;
            case 4:break;
            default:break;
        }
        }while(pil!=4);   
    }
    
    public static void Bcksps()
    {
        //pake replace
        Scanner bksps;
        bksps=new Scanner(System.in);
        String iputan;        
        String pisa;       
        System.out.println("Masukkan String =");
        iputan=bksps.nextLine();                
        pisa=iputan.replaceAll("<", "\b");
        System.out.println(pisa);
}
    public static void inTostring()
    {
        //pake replace angka, di soal batasnya 999., 0 tidak ada
        String[] nums={"","satu ", "dua ", "tiga ", "empat ", "lima ","enam ", "tujuh ", "delapan ", "sembilan ","sepuluh ","sebelas "};         
        Scanner in;
        String[] splt;
        String num;
        String inS;
        char[] ko;
        String[] kol;
        int indxBerang=0;
        int hsl;
        int[] brangka;
        int allchr=0;
        
        in=new Scanner(System.in);
        System.out.print("Masukkan kalimat (0<=angka<=10000) ,format:<kalimat> <angka> <kalimat>: ");
        inS=in.nextLine();
        splt=inS.split(" ");
        brangka=new int[splt.length];
       
       if(splt.length>1)
       {
            for (int i = 0; i < splt.length; i++) 
        {
            
            ko=splt[i].toCharArray();
                  
            for (int j = 0; j < ko.length; j++) {
                if(Character.isDigit(ko[j]))
                {
                    allchr++;
                }else{
                    brangka[i]=0;
                    
                }
                
            }
            if(allchr==ko.length)
                {
                    
                    brangka[i]=allchr;
                }
                else
                {
                    brangka[i]=0;
                }
            allchr=0;
        }
        for (int i = 0; i <splt.length; i++) {
            if(brangka[i]!=0)
            {
                hsl=Integer.parseInt(splt[i]);
                if(hsl>0 && hsl<=11)                    
                {
                    if (hsl<10) {
                        for (int j = 0; j < 12; j++) {
                        num=Integer.toString(j);
                        splt[i]=splt[i].replaceAll(num,nums[j]);
                    }
                    }
                    else
                    {                        
                        splt[i]=splt[i].replaceAll(splt[i],nums[hsl]);
                    }                     
                    
                }else if(hsl>=12 && hsl<20)
                {
                    kol=new String[splt[i].length()];
                    
                   splt[i]= numbrGenMortone(2, splt[i], kol, 1,1,0,hsl);
                                        
       }else if(hsl>=20&& hsl<100)
       {
                    kol=new String[splt[i].length()];
                    splt[i]=numbrGenMortone(2, splt[i], kol, 2,0,1,hsl);             
       }else if(hsl>=100 && hsl<1000)
        {
                    kol=new String[splt[i].length()];
                    if(hsl<200){
                        splt[i]=numbrGenMortone(3, splt[i], kol, 5,0,1,hsl);
                    }else
                    {
                        splt[i]=numbrGenMortone(3, splt[i], kol, 3,0,1,hsl);
                    }
                   
        }else if(hsl>=1000 && hsl<10000)
        {
                    kol=new String[splt[i].length()];
                    if(hsl<2000){
                        splt[i]=numbrGenMortone(4, splt[i], kol, 6,0,1,hsl);
                    }else
                    {
                        splt[i]=numbrGenMortone(4, splt[i], kol, 4,0,1,hsl);
                    }
                    
                   
        }else if (hsl==10000)
        {
            splt[i]=splt[i].replace("10000","sepuluh ribu");
        }
       else
       {
           splt[i]=splt[i].replace("0", "nol");
//           System.out.println(splt[i]);
       }
                
  }
        }
        for (int i = 0; i < splt.length; i++) 
        {
        System.out.print(splt[i].concat(" "));    
        }
           System.out.println("");
       }else
       {
           ko=inS.toCharArray();                   
            for (int j = 0; j < ko.length; j++) {
                if(Character.isDigit(ko[j]))
                {
                    allchr++;
                }else{
                    allchr=0;
                    
                }
                                
            
            
        }
            if (allchr!=ko.length) {
                allchr=0;
               
           }
            if(allchr!=0)
            {
                 hsl=Integer.parseInt(inS);
                if(hsl>0 && hsl<=11)                    
                {
                    if (hsl<10) {
                        for (int j = 0; j < 12; j++) {
                        num=Integer.toString(j);
                        inS=inS.replaceAll(num,nums[j]);
                    }
                    }
                    else
                    {                        
                        inS=inS.replaceAll(inS,nums[hsl]);
                    }
                     
                    
                }else if(hsl>=12 && hsl<20)
                {
                    kol=new String[inS.length()];
                    
                    inS=numbrGenMortone(2, inS, kol, 1,1,0,hsl);
                                        
       }else if(hsl>=20&& hsl<100)
       {
                    kol=new String[inS.length()];
                    inS=numbrGenMortone(2, inS, kol, 2,0,1,hsl);             
       }else if(hsl>=100 && hsl<1000)
        {
                    kol=new String[inS.length()];
                    if(hsl<200){
                       inS= numbrGenMortone(3, inS, kol, 5,0,1,hsl);
                    }else
                    {
                        inS=numbrGenMortone(3, inS, kol, 3,0,1,hsl);
                    }
                   
        }else if(hsl>=1000 && hsl<10000)
        {
                    kol=new String[inS.length()];
                    if(hsl<2000){
                        inS=numbrGenMortone(4, inS, kol, 6,0,1,hsl);
                    }else
                    {
                        inS=numbrGenMortone(4, inS, kol, 4,0,1,hsl);
                    }
                   
        }else if (hsl==10000)
        {
            inS=inS.replace("10000","sepuluh ribu");
        }
       else
       {
           inS=inS.replace("0", "nol");
           System.out.println(inS);
       }
            }
           
           System.out.println(inS);
        System.out.println("");
        
        
     
    }}
    public static void Plindrom()
    {
     Scanner pdrom;
     Scanner nomer;
     pdrom=new Scanner(System.in);
     nomer=new Scanner(System.in);
     String[] iputn;
     String inputdoang;
     int tstks;
     String[] vlue;
     int smakah;
     int t;     
        System.out.println("Masukkan jumlah test case : ");
     tstks=nomer.nextInt();
     vlue=new String[tstks];     
     iputn=new String[tstks];
        for (int i = 1; i <= tstks; i++) 
        {
            System.out.println("Masukkan String(huruf besar diabaikan) Test-Case ke-"+i);
            inputdoang=pdrom.nextLine();
            iputn[i-1]=inputdoang.toLowerCase();
        }
        for(int i=0;i<tstks;i++)
        {
            
            smakah=0;            
            if(iputn[i].length()>1){                           
            t=iputn[i].length();
            for(int k=0;k<iputn[i].length();k++)
            {
                if(iputn[i].substring(t-1,t).equals(iputn[i].substring(k,k+1)))
                {
                    smakah++;
                }
                t--;
                if(smakah==iputn[i].length())
                {
                    vlue[i]="True";
                }else
                {
                    vlue[i]="False";
                }
            }
            }else
            {
                vlue[i]="True";
            }
            
        }
        int nmr=1;
        for(int i=1;i<=tstks;i++)
        {
            System.out.println("Test-Case #"+nmr+" : "+vlue[i-1]);
            nmr++;
        }
     
     
    }
    
    public static String numbrGenMortone(int jmlAng,String inS,String[] kol,int ting,int cse,int cse2,int tnm)
    {
        String num;
        String[] nums={"","satu ", "dua ", "tiga ", "empat ", "lima ","enam ", "tujuh ", "delapan ", "sembilan ","sepuluh ","sebelas "};         
        String[] numsbel={"nol","belas ","puluh ", "ratus ","ribu ","seratus ", "seribu ",""};
        kol=new String[inS.length()];
        String[] ko2;
        ko2=new String[inS.length()];
        String ouut;
      ouut=new String();
        int tin;
      
        switch(jmlAng)
        {
            case 2:kol[0]=inS.substring(cse,cse+1);
            ko2[0]=inS.substring(cse,cse+1);
            kol[1]=inS.substring(cse2, cse2+1); 
            ko2[1]=inS.substring(cse2, cse2+1);break;
            case 3:kol[0]=inS.substring(cse,cse+1);
            ko2[0]=inS.substring(cse,cse+1);
            kol[1]=inS.substring(cse2, cse2+1); 
            ko2[1]=inS.substring(cse2, cse2+1);
            kol[2]=inS.substring(cse2+1, cse2+2);
            ko2[2]=inS.substring(cse2+1, cse2+2);break;
            case 4: kol[0]=inS.substring(cse,cse+1);
            ko2[0]=inS.substring(cse,cse+1);
            kol[1]=inS.substring(cse2, cse2+1); 
            ko2[1]=inS.substring(cse2, cse2+1);
            kol[2]=inS.substring(cse2+1, cse2+2);
            ko2[2]=inS.substring(cse2+1, cse2+2);
            kol[3]=inS.substring(cse2+2, cse2+3);
            ko2[3]=inS.substring(cse2+2, cse2+3);break;
            case 5:break;
        }
            
        
        for (int dgit = 1; dgit <= jmlAng; dgit++) {
                        
                        switch(dgit)
                        {
                            //digit depan sekali
                            case 1:
                        
                        
                         for(int i = 0; i <10 ; i++) {
                           num=Integer.toString(i);
                             if (ting==5||ting==6) {
                                 kol[0]=kol[0].replace(num, numsbel[ting]);
                             }else{
                                kol[0]=kol[0].replace(num, nums[i].concat(numsbel[ting])); 
                             }
                             ouut=kol[0];
                                
                                                            
                        }                               
                        
                     break;
                     //digit kedua
                            case 2:
                        
                        if(kol[1].equals("0"))
                        {
                            
                            kol[1]=kol[1].replaceFirst("\\d", numsbel[7]);
                            ouut=ouut.concat(kol[1]);
                            
                        }else
                        {
                            for(int i = 0; i <12 ; i++) 
                            {
                           num=Integer.toString(i);
                           
                           if(tnm<20)
                           {
                               kol[1]=kol[1].replace(num, numsbel[7]);
                           }else if(tnm>100&&tnm<1000)
                           {
                               if (tnm<200) {
                                   if(kol[1].equals("1"))
                              {
                                  if(kol[2].equals("0"))
                                  {
                                      kol[1]=kol[1].replace(num, "");
                                  }else if(kol[2].equals("1"))
                                  {
                                       kol[1]=kol[1].replace(num, "");
                                  }else
                                  {
                                       kol[1]=kol[1].replace(num,"");
                                  }
                                 
                              }
                              else 
                              {
                                  kol[1]=kol[1].replace(num, nums[i]);
                              }
                               }else
                               {
                                   if(kol[1].equals("1"))
                                    {
                                  kol[1]=kol[1].replace(num, "");
                                   }
                              else 
                              {
                                  kol[1]=kol[1].replace(num, nums[i]);
                              }
                               }
                               
                               
                           }else if(tnm>1000 && tnm<10000)
                           {
                              
                              if(kol[1].equals("1"))
                              {
                                  if(kol[2].equals("1"))
                                  {
                                      kol[1]=kol[1].replace(num, numsbel[5]);
                                  }else if(kol[2].equals("0"))
                                  {
                                      kol[1]=kol[1].replace(num, numsbel[5]);
                                  }else
                                  {
                                      kol[1]=kol[1].replace(num, numsbel[5].concat(nums[i]));
                                  }
                                      
                                  
                                  
                              }
                              else 
                              {
                                  if(kol[1].equals("1"))
                                  {
                                      kol[1]=kol[1].replaceAll("\\d", "Tess");
                                        
                                  }else
                                  {
                                  kol[1]=kol[1].replace(num, nums[i].concat(numsbel[3]));    
                                  }
                                 
                              }                                                             
                           }else
                           {
                               kol[1]=kol[1].replace(num, numsbel[7].concat(nums[i]));
                           }
                                
                                                            
                           }  
                            ouut=ouut.concat(kol[1]);
                        }
                        
                        
                                break;
                                //digit ketiga
                            case 3:
                               
                        if(ko2[2].equals("0")&&ko2[1].equals("0"))
                        {
                            kol[2]=kol[2].replaceFirst("\\d", "");
                            ouut=ouut.concat(kol[2]);
                        }
                        else
                        {
                            for(int i = 0; i <12 ; i++) 
                            {
                           num=Integer.toString(i);
                                if (tnm<1000) {
                                if(ko2[1].equals("0"))
                                {
                                 kol[2]=kol[2].replace(num, "".concat(nums[i]));   
                                }else if(ko2[1].equals("1"))
                                {
                                 if(kol[2].equals("0"))
                                 {
                                   kol[2]=kol[2].replace(num, nums[10]);   
                                 }else if(kol[2].equals("1"))
                                 {
                                   kol[2]=kol[2].replace(num, nums[11]);     
                                 }else
                                 {
                                   kol[2]=kol[2].replace(num, nums[i].concat(numsbel[1]));     
                                 }                                                                                               
                                }else if(kol[2].equals("0"))
                                {                                 
                                   kol[2]=kol[2].replace(num, numsbel[2]);                                                                                                                                   
                                }
                                else 
                                {
                                    if(kol[2].equals("0"))
                                    {
                                      kol[2]=kol[2].replace(num, numsbel[7].concat(nums[i]));  
                                    }else
                                    {
                                     kol[2]=kol[2].replace(num, numsbel[2].concat(nums[i]));   
                                    }
                                     
                                }
                                
                                
                            }else
                            {
                                 if(kol[2].equals("1")||ko2[1].equals("1"))
                                  {
                                      kol[2]=kol[2].replace(num, numsbel[7]);
                                  }else if(kol[2].equals("1")&&ko2[3].equals("0"))
                                  {
                                      kol[2]=kol[2].replace(num, "".concat(nums[10]));
                                  }else if(kol[2].equals("0"))
                                  {
                                      kol[2]=kol[2].replace(num, nums[i]);
                                  }
                                 else
                                  {
                                      if(kol[2].equals("1"))
                                      {
                                          tin=5;
                                      }else if(kol[2].equals("0"))
                                      {
                                          tin=7;
                                      }else
                                      {
                                          tin=7;
                                      }
                                      kol[2]=kol[2].replace(num, numsbel[tin].concat(nums[i]));
                                  }
                                
   
                            }
                        }
                        ouut=ouut.concat(kol[2]);
                        }
                            break;
                        //digit keempat
                        case 4:
                                
                        if(ko2[1].equals("0")&&ko2[2].equals("0")&&ko2[3].equals("0"))
                        {
                            kol[3]=kol[3].replaceAll("\\d", "");
                            ouut=ouut.concat(kol[3]);
                        }

                        else
                        {
                            for(int i = 0; i <12 ; i++) 
                            {
                           num=Integer.toString(i);
                                if(ko2[2].equals("0")&&ko2[3].equals("0"))
                                {
                                 kol[3]=kol[3].replace(num, "".concat(nums[i]));   
                                }else if(ko2[2].equals("1"))
                                {
                                    switch(kol[3])
                                    {
                                        case "0" : kol[3]=kol[3].replace(num, nums[10]);    break;
                                        case "1" :kol[3]=kol[3].replace(num, nums[11]);  break;
                                        default: kol[3]=kol[3].replace(num, nums[i].concat(numsbel[1]));break;
                                    }
                                    
                                 
                                }else if(ko2[2].equals("0"))
                                {
                                 kol[3]=kol[3].replace(num, nums[i]);   
                                }else
                                {
                                 kol[3]=kol[3].replace(num, numsbel[2].concat(nums[i]));   
                                }
                                
                                                            
                        }    
                          ouut=ouut.concat(kol[3]);  
                        }break;
                        default: break;
                    } 
                    }
        
                        
                       
                        return ouut;
    }
    }
