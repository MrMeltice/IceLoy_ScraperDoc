import java.util.ArrayList;

//Lets client object find amount of positive and negative sentiment
public class Sentiment {
  int positive, negative, ambiguous;
  //New ArrayList word
  ArrayList<String> words = new ArrayList();

  ArrayList<String> Wantedword = new ArrayList();

  //public method removing stop words
  public void removeStop (String text) {
    
    //change stringed text into char and put them into to an array
    char[] charList = text.toCharArray();
    //String[] StringList = {" ", " ", " ", " ", " "};
    String currentWord = "";

    //for every char in charList.Array 
    for (int index = 0; index < charList.length; index++) {
      if (charList[index] == ' '){

        if (!currentWord.equals("")){

          words.add(currentWord.toLowerCase());
        }
        currentWord = "";

      }else{

        if ((charList[index] <= 122 && charList[index] >= 97) || (charList[index] <= 90 && charList[index] >= 65)) {

          currentWord += charList[index];

        }
      }
    }
  }
}