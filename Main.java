import java.util.ArrayList; 
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document; 

class Main {
  public static void main(String[] args)  throws IOException {
    Clean rawText = new Clean();
    
    //pull text from link using jsoup
    Document doc = Jsoup.connect("https://www.metacritic.com/feature/reviews-for-the-sony-playstation-5-console-hardware").get();
    
    //set said 'text' from Document doc to String variable
    String unprocessedText = doc.text();

    //access a method from Clean to process the string
    rawText.removeStop(unprocessedText);
    

    //print out string of char concatinated [Runs through String i which is process]
    for (String i : rawText.words){
      System.out.print(i);
    }
    

  }
}