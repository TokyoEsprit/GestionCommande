/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hpp
 */
public class AccessFile {
   
public int read ()  throws IOException {
     String file ="src/Utils/User.txt";
     BufferedReader reader = new BufferedReader(new FileReader(file));
     String currentLine = reader.readLine();
     reader.close();
    return Integer.parseInt(currentLine);
}
public void Write(String id){
    File file ;
    file = new File("src/Utils/file.txt");
    System.out.println(file.getAbsolutePath());
    
    try {
        
        FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
        writer.write(id);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
   }
 }
public void delete() throws IOException{
    try{         
        File f= new File("src/Utils/file.txt");            
        f.delete() ;                    
        }
    catch(Exception e)  
    {  
    e.printStackTrace();  
    }  
    }    
}
    
        
 
    

