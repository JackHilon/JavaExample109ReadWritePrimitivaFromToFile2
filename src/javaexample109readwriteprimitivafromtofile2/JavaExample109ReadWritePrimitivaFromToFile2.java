
package javaexample109readwriteprimitivafromtofile2;

import java.io.File;


public class JavaExample109ReadWritePrimitivaFromToFile2 {

    // Reading using byte-array
    
    public static void main(String[] args) {
        
        File fil = myHelper.CreateFileInFolder("myWorkingFolder", "myData.dat");
        
        //======================================================================
        
        Write.Run(fil);
        
        //======================================================================
        
        System.out.println("-------------------------------------------------");
        
        Read.Run(fil);
    }
    
}
