import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStreaming {
	
	 FileWriter outputStream = null;
     
     File file = new File("Highscores.txt");
     outputStream = new FileWriter(file);
     Scanner sc = new Scanner(file);
     
     public static void writer(String name, int score)
     {
    	 reader();
    	 do
    	 {
    		 //Clears txt file
    		 outputStream.flush();
    		 
    		 if(score > score[0])
    		 {
    			 name = name[0];
    			 score = score[0];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[0]) && (score > score[1]))
    		 {
    			 name = name[1];
    			 score = score[1];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[1]) && (score > score[2]))
    		 {
    			 name = name[2];
    			 score = score[2]; 
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[2]) && (score > score[3]))
    		 {
    			 name = name[3];
    			 score = score[3];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[3]) && (score > score[4]))
    		 {
    			 name = name[4];
    			 score = score[4];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[4]) && (score > score[5]))
    		 {
    			 name = name[5];
    			 score = score[5];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[5]) && (score > score[6]))
    		 {
    			 name = name[6];
    			 score = score[6];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[6]) && (score > score[7]))
    		 {
    			 name = name[7];
    			 score = score[7];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[7]) && (score > score[8]))
    		 {
    			 name = name[8];
    			 score = score[8];
    			 writeForLoop(name[], score[]);
    		 }
    		 else if((score < score[8]) && (score > score[9]))
    		 {
    			 name = name[9];
    			 score = score[9];
    			 writeForLoop(name[], score[]);
    		 }
    		 else
    		 {
    			 break;
    		 }
    		 
    	 }
     }
     
     public static void reader()
     {
    	 int score[];
    	 String name[];
    	 
    	 for(int i = 0;i < 10; i++)
    	 {
    		 if(sc.hasNextLine())
    		 {
    			 name[i] = sc.nextString();
    			 score[i] = sc.nextInt();
    			 sc.nextLine();
    		 }
    		 else
    			 break;
    	 }
     }
     public void writeForLoop(String name[]; int score[])
     {
    	 for(int i = 0; i < 10; i++)
    	 {
    		 outputStream.write(name[i]);
    		 outputStream.write(score[i]);
    		 outputStream.write("/n");
    	 }
     }
}
