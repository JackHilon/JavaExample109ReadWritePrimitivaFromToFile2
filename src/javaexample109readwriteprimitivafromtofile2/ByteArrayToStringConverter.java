
package javaexample109readwriteprimitivafromtofile2;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.SortedMap;


public class ByteArrayToStringConverter {
        
     // https://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ISO-8859-1
    /*
    x-windows-50220
    x-windows-50221
    x-windows-874
    x-windows-949
    x-windows-950
    x-windows-iso2022jp
    */
    
    //..........................................................................
    
    // To show all charset available on JVM
            /*
            SortedMap<String, Charset> map = Charset.availableCharsets();
            map.keySet().stream().forEach(System.out::println);
            */
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    /*
    x-windows-50220
    x-windows-50221
    x-windows-874
    x-windows-949
    x-windows-950
    x-windows-iso2022jp
    */
    
    //..........................................................................
    //==========================================================================
    
    private static String Run(byte[] array) {
        return Run1(array);
    }
    
    //=================================(1)======================================
    public static String Run1(byte[] array) {
        String s = new String(array);
        return s;
    }
    
    //=================================(2)======================================
    
    public static String Run2(byte[] array) {
        String s = new String(array, Charset.forName("x-windows-50220"));
        return s;
    }
    
    //=================================(3)======================================
    
    public static String Run3(byte[] array) {
        String s = Base64.getEncoder().encodeToString(array);
        return s;
    }
    
    //=================================(4)======================================
    
    public static String Run4(byte[] array) {
        String s = Base64.getEncoder().withoutPadding().encodeToString(array);
        return s;
    }
    
    //=================================(5)======================================
        
    public static String Run5(byte[] array) {
        String s = new String(array, StandardCharsets.UTF_8);
        return s;
    }
    
    //=================================(6)======================================
    
    public static String Run6(File fil) {
        try{
        byte[] array = Files.readAllBytes(fil.toPath());
        String s = Base64.getEncoder().encodeToString(array);
        return s;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }
    
        
    
    
    //##########################################################################
    
    public static void ShowDefaultCharset() {
     
        System.out.println("Default Charset: " + Charset.defaultCharset().name());
    }
    
    //##########################################################################
    
    public static void ShowAllCharset() {
        // To show all charset available on JVM
        SortedMap<String, Charset> map = Charset.availableCharsets();
        map.keySet().stream().forEach(System.out::println);
    }
    
    //--------------------------------------------------------------------------
    
    /**
     Summary:
    (*) For text data byte[], we use new String(bytes, StandardCharsets.UTF_8), UTF-8 for character encoding.
    (*) For binary data byte[], we use the Base64 binary encoding.
     */
}
