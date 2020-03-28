
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesServer {
   
    
    public static void main(String[] args) { 
        try {
            ServerSocket server;
            String ip;
            PrintStream output;
            DataInputStream input;
            Socket serviceSock=null;
            String inpAd="";
            server = new ServerSocket(3000);
            System.out.println("Server ready");
            serviceSock = server.accept();
            BufferedReader readi = new BufferedReader(new InputStreamReader(System.in));
            OutputStream ostrl=serviceSock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostrl, true);
            InputStream istr = serviceSock.getInputStream();
            BufferedReader receivee= new BufferedReader(new InputStreamReader(istr));
            String receive, send;
            do
            {
                if ((receive=receivee.readLine())!= null&& !receive.equals("NO")) {
                    System.out.println(receive);
                    
                }else 
                {
                    break;
                }
                send = readi.readLine();
                pwrite.println(send);
                pwrite.flush();
            }while(true);
        istr.close();

        ostrl.close();
        server.close();
//        input.close();
//         try {
//            server=new ServerSocket(212);
//            System.out.println("Server ready"); 
//            //ip sendiri
//            ip=InetAddress.getLocalHost().getHostAddress();
//          System.out.println(ip);
//            //kode terima
//            serviceSock =server.accept();
//             System.out.println("A client is trying to connect");
//             
//             input = new DataInputStream(serviceSock.getInputStream());
//            //kode ambil data dari klien
//             inpAd = input.readLine();
//             output=new PrintStream(serviceSock.getOutputStream());             
//             System.out.println("Client inputed "+inpAd);
//             if (inpAd.equals(ip)) {
//                System.out.println("Selamat IP benar");
//                output.print(1);
//                while(true)
//                {
//                    System.out.println("Masuk");
//                    inpAd = input.readLine();
//                    System.out.println(inpAd);
//                    output.print(inpAd); 
//                    if (inpAd.equals("NO")) {
//                        break;
//                    }
//                    output.flush();
//                    
//                }
//                
//             }else
//             {
//                 System.out.println("Ip salah");
//                 output.print(0);
//                  input.close();
//             serviceSock.close();
//             server.close();
//             }
//             input.close();
//             serviceSock.close();
//             server.close();
//        } catch (IOException ex) {
//             System.out.println(ex.getMessage());
//        }
        } catch (IOException ex) {
            Logger.getLogger(TesServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
       
    
            
}
