
package javaexample109readwriteprimitivafromtofile2;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Read {
    
    // https://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html

    public static void Run(File fil) {
        
        try{
            
            FileInputStream fis = new FileInputStream(fil);
            
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            DataInputStream dis = new DataInputStream(bis);
                        
            byte[] vector = new byte[1000];
            dis.read(vector);
            
            String s = ByteArrayToStringConverter.Run1(vector);
            System.out.println(s);
            
            // close
            dis.close();
            bis.close();
            fis.close();
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
