
package javaexample109readwriteprimitivafromtofile2;

import java.io.File;
import java.io.IOException;


public class myHelper {
     
    public static File CreateFileInFolder(String folderName, String fileName) {
        
        File folder = myHelper.CreateWorkingFolder(folderName);
        
        myHelper.FolderCheck(folder);
        
        File fil = myHelper.CreateWorkingFile(folder, fileName);
        
        myHelper.FileCheck(fil);
        
        return fil;
    }
  
    private static File CreateWorkingFolder(String folderName) {
        
        File folder = new File("." + File.separatorChar + folderName);
        
        folder.mkdir();
        
        return folder;
    }
    
    
    private static File CreateWorkingFile(File folder, String fileName) {
        
        File fil = new File(folder, fileName);
        try {
        fil.createNewFile();
        return fil;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    private static void FolderCheck(File folder) {
        
        if(folder.isDirectory())
            System.out.println("A folder, named (" + folder.getName() + "), is created....");
        else System.out.println("Error....");
    }
    
    private static void FileCheck(File fil) {
        
        if(fil.isFile())
            System.out.println("A file, named (" + fil.getPath() + "), is created....");
        else System.out.println("Error....");
        
    }
    
    public static String ByteArray2String(byte[] array) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < array.length; i++) {
            ch = (char) array[i];
            sb.append(ch);
        }
        return sb.toString();
        
    }
}
