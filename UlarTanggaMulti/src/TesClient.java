
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesClient {
    public static void main(String[] args) {
        try {
            Socket clientSock=null;
            PrintStream output;
            String res;
            DataInputStream input;
            BufferedReader message;
            clientSock = new Socket("localhost", 3000);
            message=new BufferedReader(new InputStreamReader(System.in));
            OutputStream ost= clientSock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ost, true);
            InputStream ist= clientSock.getInputStream();
            BufferedReader rece= new BufferedReader(new InputStreamReader(ist));
            System.out.println("Chacha");
            String receiv,sendi;
            while(true)
            {
                sendi=message.readLine();
                pwrite.println(sendi);
                pwrite.flush();
                if ((receiv=rece.readLine())!=null&& !receiv.equals("NO")) {
                    System.out.println("");
                    System.out.println(receiv);
                    
                }else 
                {
                    break;
                }
                
            }   
//            output.close();
//            input.close();
            ost.close();
            clientSock.close();
            
//        try {
//            //untuk socket, localhost itu addressnya, port samain aja
//            clientSock = new Socket("localhost",212);
//            output = new PrintStream(clientSock.getOutputStream());
//            input= new DataInputStream(clientSock.getInputStream());
//            message = new BufferedReader(new InputStreamReader(System.in));
//             System.out.println("Message:");            
//            output.println(message.readLine());
//            res=input.readLine();
//            System.out.println(res);
//            
//            while(true)
//            {
//            System.out.println("Message:");            
//            output.println(message.readLine());
//            res=input.readLine();
//            System.out.println(res);
//                if (res.equals("NO")) {
//                    break;
//                }
//                output.flush();
//               
//            }
//            
//            output.close();
//            clientSock.close();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
        } catch (IOException ex) {
            Logger.getLogger(TesClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
}
}
