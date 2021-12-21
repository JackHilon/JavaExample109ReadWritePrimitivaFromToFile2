
package javaexample109readwriteprimitivafromtofile2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Write {
    

public static void Run(File fil) {
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fil);
            
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            
            DataOutputStream dos = new DataOutputStream(bos);
            
            String str = "Total cost is: ";
            double cost = 23423.66;
            
            // writing
            dos.writeUTF(str);
            dos.writeDouble(cost);
            
            System.out.println(str + " "+ cost);
            
            // close
            dos.close();
            bos.close();
            fos.close();
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
