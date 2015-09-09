import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
/**
 * Write a description of class word_cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class project1
{
    /**
     * i need to make an arraylist to iterate over
     * i will read in a file with a scanner
     */
    public ArrayList<String> words(Scanner infile){
        ArrayList<String> Words = new ArrayList<String>();
        while(infile.hasNext()){
            String word = infile.next();
            Words.add(word);
        }
        return Words;
    }
    /**
     * this method will print the hashmap keys and values
     * may be temporary.
     */
    public void checker(HashMap<String,Integer> hm){
        int counter = 1;
        for(int i = 0;i<hm.size();i++){
             for(String s:hm.keySet()){
                 if(hm.get(s) == counter){
                      System.out.println("Word: " + s + " occurred " + hm.get(s) + " times");
                 
                }
             }
             counter++;
        }
    }
    public static void main(String [] args){
        HashMap<String,Integer> wordCloud = new HashMap<String,Integer>();
        if(args.length<1){
            System.out.println("no filename to read");
        }
        else{
            project1 mainObject = new project1();
            File fileToRead = new File(args[0]);
           try{
                 Scanner in = new Scanner(fileToRead);
                 ArrayList<String> someWords = mainObject.words(in);
                 for(String s:someWords){
                
                    if(wordCloud.containsKey(s)){
                        wordCloud.put(s,wordCloud.get(s)+1);//already contains s
                    }
                    else{
                        wordCloud.put(s,1);//hashmap does not yet contain s
                    }
                 }
             
            
           }catch(IOException e){
                System.out.println("error with file"+e);
           }
           mainObject.checker(wordCloud);
        }
    }
}
