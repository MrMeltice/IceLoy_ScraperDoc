import java.util.ArrayList;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.Scanner;
import java.util.*;


class Main {
  public static void main(String[] args)  throws IOException {
    //Start text
    System.out.format("Initializing code...\n\n\n");
    //Making an arraylist for the websites
    ArrayList<String> linkAL = new ArrayList<String>();
    //Scanner 
    Scanner sc = new Scanner(System.in);

    
    System.out.println("How many link(s) would you like to parse? : ");

    int numLinks = sc.nextInt();

    for (int i = 1; i < numLinks + 1 ; i++){
      Scanner a = new Scanner(System.in);
      System.out.format("\nInput Link Number %d\n", i);
      String link = a.nextLine();
      linkAL.add(link);
    }

    Sentiment rawText = new Sentiment();

    //Checkpoint* Iteration 4 complete = parse multiple website and store values => Represent data
    
    for (int i = 0; i < linkAL.size(); i++ ) {
      Document doc = Jsoup.connect(linkAL.get(i)).get();


      //Set said 'text' from Document doc to String variable
      String uncleanText = doc.text();
      //Clean text
      rawText.removeStop(uncleanText);
      //Rate text pos and neg
      rawText.Rating();
      
      System.out.println(linkAL.get(i));
      System.out.format("|\n|\n");
      System.out.println("▼");

      rawText.getRate();
      
      System.out.format("\n\n--------------------------------------------\n");



    }
    rawText.getTotalRate();

    
    
    //EndCode
    System.out.format("\n\n\nCode deactivated...");

  }
}