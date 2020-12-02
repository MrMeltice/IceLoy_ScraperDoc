import java.util.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Lets client object find amount of positive and negative sentiment
public class Sentiment {
  int positive, negative, ambiguous;
  //New ArrayList word

  //public method removing stop words
  public void removeStop(String text){
    int wordCount;
    //change stringed text into char and put them into to an array
    char[] charArray = text.toCharArray();
    
    /*
    String charList = new String(charArray);       

    //for every char in charList.Array [FAIL SAFE]
  
    for (int index = 0; index < charList.length - 1 ; index++){
      if(charList.charAt(index) >= 0 && charList.charAt(index) <= 31){
        charList.remove(index);
      }
      else if(charList.charAt(index) >= 33 && charList.charAt(index) <= 64){
        charList.remove(index);
      }
    }
  */
    //Take list of char and convert it into a string type
    String strList = new String(charArray);
 
    strList = strList.replaceAll("[^a-zA-Z]", " ");

    //Take string w/ no speacial character (except WhiteSpaces) and shove it into a string array using split() with WhiteSpaces as the delimiter
    String[] wordArray = strList.split(" ");
    //[JAVA] the value of the local variable  wordList is not used
    
    ArrayList<String> wordList = new ArrayList();

    for (String l : wordArray) {
      wordList.add(l.toLowerCase());
    }

    //Remove blank string value until there is no more blank value to remove     
    while (wordList.remove("")){
      
    }


    for (String s : wordList) {
      System.out.print(s + ",");
    }
    
    
    wordList.remove(1);
    System.out.print(wordList.size());
  }
}