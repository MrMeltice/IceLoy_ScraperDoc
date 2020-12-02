import java.util.ArrayList;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class Main {
  public static void main(String[] args)  throws IOException {
    Sentiment rawText = new Sentiment();

    //Start text
    System.out.format("Initializing code...\n\n\n");



    //pull text from link using jsoup
    Document doc = Jsoup.connect("https://www.metacritic.com/feature/reviews-for-the-sony-playstation-5-console-hardware").get();
    
    //set said 'text' from Document doc to String variable
    String unprocessedText = doc.text();

    //access a method from Clean to process the string
    rawText.removeStop(unprocessedText);

    /*
    for(String i : Sentiment.wordAL){
      System.out.print(i +", ");
    }
    System.out.print("Total words : " + Sentiment.countWordAL);
    */


    rawText.Rating();

    System.out.println("Positive Sentiment: " + Sentiment.positive + "/" + Sentiment.countWordAL);
    System.out.print("Negative Sentiment: " + Sentiment.negative + "/" + Sentiment.countWordAL);

    System.out.println("Ratio: " + Sentiment.positive + "/" + Sentiment.countWordAL);


    /*
    for(String i : Sentiment.stopAL){
      System.out.print(i +", ");
    }
    System.out.print("Total words : " + Sentiment.countStopAL);
    */


    //EndCode
    System.out.format("\n\n\nCode deactivated...");

  }
}