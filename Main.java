import java.util.ArrayList;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class Main {
  public static void main(String[] args)  throws IOException {
    //Start text
    System.out.format("Initializing code...\n\n\n");

    ArrayList<String> linkAL = new ArrayList<String>();
    linkAL.add("https://www.denofgeek.com/games/ps5-review/#:~:text=PlayStation%205%20Specs&text=Taken%20on%20its%20own%20merits,the%20console's%20SSD%20and%20RAM.");
    linkAL.add("https://www.techradar.com/reviews/ps5");
    linkAL.add("https://www.metacritic.com/feature/reviews-for-the-sony-playstation-5-console-hardware");
    linkAL.add("https://www.dualshockers.com/ps5-pros-and-cons-launch-sony/");

    Sentiment rawText = new Sentiment();
    
    for (int i = 0; i < linkAL.size(); i++ ) {
      Document doc = Jsoup.connect(linkAL.get(i)).get();

      
      //Set said 'text' from Document doc to String variable
      String uncleanText = doc.text();
      //Clean text
      rawText.removeStop(uncleanText);
      //Rate text pos and neg
      rawText.Rating();
      

      System.out.println(linkAL.get(i));

      System.out.format("\n\n");

      System.out.println("Positive Sentiment: " + rawText.getPositiveRate() + "/" + Sentiment.countWordAL);

      System.out.println("Negative Sentiment: " + rawText.getNegativeRate() + "/" + Sentiment.countWordAL);

      System.out.println("Ratio: " + Sentiment.positive + "/" + Sentiment.negative);
      System.out.format("\n\n");

      




    }

    
    
    //EndCode
    System.out.format("\n\n\nCode deactivated...");

  }
}