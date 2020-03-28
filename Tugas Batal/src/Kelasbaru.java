/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author D. Erik
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Kelasbaru {
    
    
    public static void main(String[] args)
   {
       ArrayList nama = new ArrayList();
       nama.add("contoh");
       nama.add(3.4);
       nama.add(3);
       nama.add(true);
       System.out.println(nama);
        
        int plh;
        int y;
        int hsl;
          Scanner iput = new Scanner(System.in);
          System.out.println("Input : ");
          hsl=iput.nextInt();
          do{
          System.out.println("Angka : " + hsl);
          System.out.println("Menu : ");
          plh=iput.nextInt();
          switch(plh)
          {
              case 1:System.out.println("Masukkan Angka 2 : ");
              y=iput.nextInt();
              hsl=tmbah(hsl,y);
          break;
              case 2:System.out.println("Masukkan Angka 2 : ");
              y=iput.nextInt();
              hsl=krang(hsl,y);break;
              case 3: System.out.println("Masukkan Angka 2 : ");
              y=iput.nextInt();
              hsl=kli(hsl,y);break;
              case 4: System.out.println("Masukkan Angka 2 : ");
              y=iput.nextInt();
              hsl=bgi(hsl,y);break;
              case 5: System.out.println("Masukkan Angka 2 : ");
              y=iput.nextInt();
              hsl=modulai(hsl,y);break;
              case 6: 
              hsl=fktorial(hsl);break;
              case 7:hsl=0;break;
              case 8 :System.out.println("Selamat tinggal");break;
              default:System.out.println("Inputan salah!");break;
          }
          
          }while (plh !=8);
    }
     static int tmbah(int a, int b)
    {
            
        return a+b;
         
    }
     static int krang(int a,int b)
     {
         return a-b;
     }
     static int kli(int a,int b)
     {
         return a*b;
     }
     static int bgi(int a, int b)
     {
         return a/b;
     }
     static int modulai(int a, int b)
     {
         return a%b;
     }
     static int fktorial(int a)
     {
         int k=1;
         for(int x=1;x<=a;x++)
         {
             k=k*x;
         }
         return k;
     }
     
    
}
