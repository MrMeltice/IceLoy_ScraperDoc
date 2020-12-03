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
    Document doc = Jsoup.connect("https://www.dualshockers.com/ps5-pros-and-cons-launch-sony/").get();
    
    //https://www.denofgeek.com/games/ps5-review/#:~:text=PlayStation%205%20Specs&text=Taken%20on%20its%20own%20merits,the%20console's%20SSD%20and%20RAM.
    
    //https://www.pocket-lint.com/games/reviews/playstation/154419-ps5-review-playstation-5

    //https://www.techradar.com/reviews/ps5

    //https://www.metacritic.com/feature/reviews-for-the-sony-playstation-5-console-hardware
    
    //https://www.denofgeek.com/games/ps5-review/#:~:text=PlayStation%205%20Specs&text=Taken%20on%20its%20own%20merits,the%20console's%20SSD%20and%20RAM.

    //https://www.dualshockers.com/ps5-pros-and-cons-launch-sony/


    
    //set said 'text' from Document doc to String variable
    String unprocessedText = doc.text();

    //access a method from Clean to process the string
    rawText.removeStop(unprocessedText);

    //Count amount of positve and negative in the Clean text
    rawText.Rating();

    System.out.println("Positive Sentiment: " + rawText.getPositiveRate() + "/" + Sentiment.countWordAL);
    System.out.println("Negative Sentiment: " + Sentiment.negative + "/" + Sentiment.countWordAL);

    System.out.println("Ratio: " + Sentiment.positive + "/" + Sentiment.negative);

    //EndCode
    System.out.format("\n\n\nCode deactivated...");

  }
}