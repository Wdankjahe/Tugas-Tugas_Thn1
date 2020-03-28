
package javaapplication1;


import java.util.Scanner;
public class JavaApplication1 {
    public static void main(String[] args) {
        
        
        Scanner sc=new Scanner(System.in);
               int x,y;
               try{
               System.out.println("Angka: ");
               x=sc.nextInt();
               System.out.println("Angka 2: ");
               y=sc.nextInt();
              
               System.out.println("Hasil bagi: "+x/y);
               }catch(java.util.InputMismatchException e)
               {
                   System.out.println("Format angka Salah !");
               }catch(ArithmeticException r)
               {
                   System.out.println("Angka tidak bisa dibagi 0");
               }catch(Exception e)
               {
                   System.out.println("Error");
               }finally
               {
                   
                   System.out.println("Program selesai");
               }              
        
        
        int pil;
        Scanner iput= new Scanner(System.in);
        do{
        System.out.print("=====Tugas Pemrograman Java=====");
        System.out.println("");
        System.out.println("1. Calculator Matriks (50 poin)");
        System.out.println("2. Oddities (20 poin)");
        System.out.println("3. Dice Game (20 poin)");
        System.out.println("4. Exit (10 poin)");
        System.out.print("Pilihan : ");
        pil=iput.nextInt();
        
        switch(pil)
        {
            case 1:Calmat();break;
            case 2:Odesi();break;
            case 3:Gameddu();break;
            case 4:break;
            default:System.out.println("Inputan Salah!");break;
        }
        }while(pil!=4);
       }
    static void Calmat()
    {
    
        int[][] a;
        a= new int[2][2];
        int[][] b;
        b= new int[2][2];
        int[][] kli;
        kli= new int[2][2];
        int i,j=0;
        
        Scanner caca= new Scanner(System.in);
        System.out.println("====Menu 1 : Matriks====");
        System.out.println("Matriks A");
        for (i = 0; i < 2; i++) {
            
            for (j = 0; j < 2; j++) {
                
                System.out.println("Masukkan Matriks A elemen "+i+","+j+" : ");
                a[i][j]=caca.nextInt();                
            }
        }
        System.out.println("");
        for (i = 0; i < 2; i++) {
            
            for (j = 0; j < 2; j++) {
                
                System.out.println("Masukkan Matriks B elemen "+i+","+j+" : ");
                b[i][j]=caca.nextInt();                
            }
        }
        System.out.print("Matrix A      ");  System.out.print(" Matrix B");
        System.out.println("");
        for ( i =0 ; i < 2; i++) 
        {
                System.out.print("| ");
                System.out.print(a[i][0]); 
                System.out.print("  "); 
                System.out.print(a[i][1]); System.out.print(" |");
                System.out.print("       | ");
                System.out.print(b[i][0]); 
                System.out.print("  "); 
                System.out.print(b[i][1]); System.out.print(" |");
                System.out.println("");
        }
        System.out.println("A+B =");
        for (i= 0; i < 2; i++) 
        {          
                System.out.print("| ");
                System.out.print(a[i][0]+b[i][0]); 
                System.out.print("  "); 
                System.out.print(a[i][1]+b[i][1]); System.out.print(" |");
                System.out.println("");   
        }
        System.out.println("");
        
        System.out.println("A-B =");
        for (i= 0; i < 2; i++) 
        {           
                System.out.print("| ");
                System.out.print(a[i][0]-b[i][0]); 
                System.out.print("  "); 
                System.out.print(a[i][1]-b[i][1]); System.out.print(" |");
                System.out.println("");                        
        }
        System.out.println("");

        System.out.println("A*B =");
        for (i= 0; i < 2; i++) 
        {
                kli[i][0]=a[i][0]*b[0][0]+a[i][1]*b[1][0];
                kli[i][1]=a[i][0]*b[0][1]+a[i][1]*b[1][1];
                System.out.println("| "+kli[i][0] +"  "+ kli[i][1]+" |");   
        }
    }
    
    static void Odesi()
    {
        int g;
        int y;
        int f;
        int[] l;
        
        Scanner an;
        an= new Scanner(System.in);
        System.out.printf("====Menu 2 : Oddities====\n");
        System.out.print("Masukkan jumlah Test-case = ");
        g=an.nextInt();
        l=new int[g];
        for ( f = 1; f <= g; f++) 
        {
            System.out.printf("Angka %d = ",f);
            l[f-1]=an.nextInt();
            
           
        }
        for ( f = 1; f <= g; f++) 
        {
            System.out.printf("Testcase #%d :",f);
            if (l[f-1]%2==0) 
            {
                System.out.print("even");   
            }else if (l[f-1]%2==1 || l[f-1]%2==-1)
            {
                System.out.print("odd");
            }else
            {
                System.out.print("Bukan angka jelas");
            }
            System.out.println("");
        }
    }
    
    static void Gameddu()
    {
        //g=ronde, i=nomornya,y=test case, k=testcasenya,
        int g;
        int i;
        int y;
        int k;
        int[] wn;
        int plh;
        Scanner ddus= new Scanner(System.in);
        int ttl1=0,ttl2=0;
        int ddu1,ddu2;
        String nme1=" : Jojo win";
        String nme2=" : Juan win";
        System.out.println("====Menu 3 : Dice Game====");
        System.out.print("Masukkan jumlah Test-Case =");
        y=ddus.nextInt();
        wn= new int[y];
        for ( k = 1; k <=y; k++) 
        {
            System.out.println("Tes-Case #"+k);
            System.out.print("Masukkan jumlah ronde =");
            g=ddus.nextInt();
            for (i = 1;  i<=g; i++) 
            {
                do{
                System.out.println("Ronde #"+i);
                System.out.print("Masukkan angka dadu (1 dadu) Jojo =");
                ddu1=ddus.nextInt();
                if(ddu1>6 || ddu1 <1)
                {
                    System.out.println("Masukan angka 1-6");
                }else
                {
                ttl1+=ddu1;                
                }
                }while (ddu1 >6 || ddu1 <1);
                do{
                System.out.print("Masukkan angka dadu(1 dadu) Juan=");
                ddu2=ddus.nextInt();
                if(ddu2>6 ||  ddu2 <1)
                {
                    System.out.println("Masukan angka 1-6");                    
                }else
                {
                ttl2+=ddu2;                
                }
                
                }while (ddu2>6 ||  ddu2 <1);
            }
            if(ttl1>ttl2)
            {
                wn[k-1]=1;
            }else if(ttl2>ttl1)
            {
                wn[k-1]=2;
            }else
            {
                wn[k-1]=0;
            }
            ttl1=0;
            ttl2=0;
        }
        for (k =1; k <= y; k++) 
        {
            System.out.print("Testcase #"+k);
            switch(wn[k-1])
            {
                case 0:System.out.println(" : tie");break;
                case 1:System.out.println(nme1);break;
                case 2:System.out.println(nme2);break;
               default:System.out.println("Nogame");break;                    
            }            
        }        
    }
}
