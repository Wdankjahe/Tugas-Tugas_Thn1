public class TesAlgoritmas {
    public static void main(String[] args) {
    char alp;    
    String tes="abcdefhijklmnopqrstuvwxyz1234567890";
    char[] ai={'a','b','e','i','k','l','o','s','y'};
    char[] voc={'a','i','u','e','o'};
    int jmlvcl=0;
    char[] al={'4','8','3','!','ʞ','£','0','$','¥'};
    String hsl="";    
    String alv2,aiv2;
    String hsl2=tes;
    
    int i=3;    
        
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
        for (int j = 0; j < ai.length; j++) {           
            hsl2=hsl2.replace(ai[j],al[j]);
        }
        for (int k = 0; k < tes.length(); k++) {
            for (int j = 0; j < voc.length; j++) {
            if (tes.charAt(k)==voc[j]) {
                jmlvcl++;
            }

        }
        }
        
        System.out.println("Awal "+tes);
        System.out.println("hasil "+hsl);
        System.out.println("Hasil alay " +hsl2);
        System.out.println("Panjang kalimat asli: " + tes.length());
        System.out.println("Jumlah vokal : " + jmlvcl);
        
        
        
}
}
