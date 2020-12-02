import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

//Lets client object find amount of positive and negative sentiment
public class Sentiment {
  static int countWordAL, countStopAL, positive, negative;
  public int ambiguous;
  //New ArrayList word Array List
  static ArrayList<String> wordAL = new ArrayList();
  //New ArrayList stop word Array List
  static ArrayList<String> stopAL = new ArrayList();

  static ArrayList<String> posAL = new ArrayList();
  static ArrayList<String> negAL = new ArrayList();

  
  //public method removing stop words
  public void removeStop(String text){

    //[CODE BELOW REMOVE ALL SPECIAL&NUM CHAR and ADD ALL WORDS PULLED FROM WEBSITE TO ARRAYLIST]

    //change stringed text into char and put them into to an array
    char[] charArray = text.toCharArray();

    //Take list of char and convert it into a string type
    String strList = new String(charArray);
 
    strList = strList.replaceAll("[^a-zA-Z]", " ");
    
    //Take string w/ no speacial character (except WhiteSpaces) and shove it into a string array using split() with WhiteSpaces as the delimiter
    String[] wordArray = strList.split(" ");
    //[JAVA] the value of the local variable  wordList is not used
    
    

    //For string l add every word in Array wordArray into the Arraylist wordList
    for (String l : wordArray) {
      wordAL.add(l.toLowerCase());
    }

    //Remove blank string value until there is no more blank value to remove     
    while (wordAL.remove("")){
    }

    //CheckPoint* Iteration 1 complete = removed special characters between text and add words into Array, ready for comparison

    //[CODE BELOW ADD ELEMENT TO ARRAYLIST INSERTED FROM STOP.TXT FILE]
    
    //initialize blank local string variable
    String stopText = "";
    
    //Try pulling file from stop.txt
    try {
      //Access stopwords from stop.text using java.io.File
      File myFile = new File("stop.txt");
      //New Scanner myScan
      
      Scanner myScan = new Scanner(myFile);

      while(myScan.hasNextLine()) {
        stopText += myScan.nextLine() + " ";
      }
      myScan.close();
    } catch (FileNotFoundException e){
      System.out.println("Error Occurred");
      e.printStackTrace();
    }

    String[] stopArray = stopText.split(",");

    
    for (String a : stopArray) {
      stopAL.add(a.toLowerCase());
    }
    
    //CheckPoint* Iteration 2 complete = access txtfile and add it into array...  => compare with wordAL to remove stop words
    this.countStopAL = stopAL.size();
    
    //[CODE BELOW COMPARES ARRAYS WORDAL AND STOPAL AND REMOVE STOP WORD FROM THE WEBSITE ]

    //Checkpoint* Iteration 3 complete = removed stop text from array => 
    for (int b = wordAL.size()-1; b > 0; b--){
      for(int c = 0; c < stopAL.size() - 1; c++){
        if(wordAL.get(b).equals(stopAL.get(c))){
          wordAL.remove(b);
        }
      }
    }

    this.countWordAL = wordAL.size();
  }



  public void Rating(){
    String posText = "";
    String negText = "";
    
    //Try pulling file from pos.txt
    try {
      //Access negativeword from pos.text using java.io.File
      File posFile = new File("pos.txt");
      
      //New Scanner PosScanner
      Scanner myPosScan = new Scanner(posFile);

      while(myPosScan.hasNextLine()) {
        posText += myPosScan.nextLine() + " ";
      }
      
      myPosScan.close();

    } catch (FileNotFoundException pos){
      System.out.println("Error Occurred at PosPrintError");
      pos.printStackTrace();
    }

    //Try pulling file from neg.txt
    try {
      //Access neg from neg.text using java.io.File
      File negFile = new File("neg.txt");
      //New Scanner myScan
      
      Scanner myNegScan = new Scanner(negFile);

      while(myNegScan.hasNextLine()) {
        negText += myNegScan.nextLine() + " ";
      }

      myNegScan.close();

    } catch (FileNotFoundException neg){
      System.out.println("Error Occurred at NegPrintError");
      neg.printStackTrace();
    }
    
    
    String[] posArray = posText.split(",");

    String[] negArray = negText.split(",");
    
    
    for (String pos : posArray) {
      posAL.add(pos.toLowerCase());
    } 
    for (String neg : negArray) {
      negAL.add(neg.toLowerCase());
    }

    int ratePositive = 0;
    int rateNegative = 0;

    for (int x = wordAL.size()-1; x > 0; x--){
      for(int y = 0; y < posAL.size() - 1; y++){
        if(wordAL.get(x).equals(posAL.get(y))){
          ratePositive++;
        }
      }
    }

    
    for (int x = wordAL.size()-1; x > 0; x--){
      for(int y = 0; y < posAL.size() - 1; y++){
        if(wordAL.get(x).equals(negAL.get(y))){
          rateNegative++;
        }
      }
    }
    
    this.negative = rateNegative;
    this.positive = ratePositive;

  }
}