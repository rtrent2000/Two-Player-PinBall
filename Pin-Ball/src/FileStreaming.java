import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileStreaming {
	
	 private static FileWriter outputStream = null;
     
	 private static File file = new File("Highscores.txt");
     private static outputStream = new FileWriter(file);
     private static Scanner sc = new Scanner(file);
     
     private static ArrayList<Integer> scores = new ArrayList<Integer>();
	 private static String[] names = new String[10];
     
     public static void writer(String name, int score)
     {
    	 reader();
    	 int element;
    	 do
    	 {
    		 //Clears text file
    		outputStream.flush();
    		if(scores.get(0) != null)
    		{
    			for(int i = 0; i < 10; i++)
    			{
    				if((score < scores.get(i).intValue()))
    				{
    					scores.add(i,new Integer(score));
    					element = i;
    					break;
    				}
    			}
    		} 
    		else
    		{
    			scores.add(0,new Integer(score));
    		}
    		
    		
    	 }while(score != scores.get(element));
     }
     
     public static void reader()
     {
    	 
    	 
    	 for(int i = 0;i < 10; i++)
    	 {
    		 if(sc.hasNextLine())
    		 {
    			 //names[i] = sc.next();
    			 //scores[i] = sc.nextInt();
    			 //sc.nextLine();
    			 names[i] = "ryan";
    			 scores.add(i,new Integer(5));
    		 }
    		 else
    			 break;
    	 }
     }
     public static void writeForLoop(String name[],int score[])
     {
    	 for(int i = 0; i < 10; i++)
    	 {
    		 outputStream.write(name[i]);
    		 outputStream.write(score[i]);
    		 outputStream.write("/n");
    	 }
     }
}
