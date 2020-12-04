import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

//Lets client object find amount of positive and negative sentiment
public class Sentiment {
  
  static int countWordAL, countStopAL, positive, negative, Totalpos, Totalneg;
  static double AveragePos, AverageNeg;
  
  //New ArrayList => Reset
  static ArrayList<String> wordAL = new ArrayList();
  static ArrayList<String> stopAL = new ArrayList();
  static ArrayList<String> posAL = new ArrayList();
  static ArrayList<String> negAL = new ArrayList();

  //Count Arraylist => Stock 
  static ArrayList<Integer> posCount = new ArrayList();
  static ArrayList<Integer> negCount = new ArrayList();


  
  //public method removing stop words
  //Post removeStop method output: Clean text (Removed Blank Value, Num, Special Char, Stop-word) convert to array for comparison
  public void removeStop(String text){
    clear();


    //[CODE BELOW REMOVE ALL SPECIAL&NUM CHAR and ADD ALL WORDS PULLED FROM WEBSITE TO ARRAYLIST]

    //change stringed text into char and put them into to an array
    char[] charArray = text.toCharArray();

    //Take list of char and convert it into a string type
    String strList = new String(charArray);
 
    //regex replace all characters that are not alphabets with space
    strList = strList.replaceAll("[^a-zA-Z]", " ");
    
    //Take string w/ no speacial character (except WhiteSpaces) and shove it into a string array using split() with WhiteSpaces as the delimiter
    String[] wordArray = strList.split(" ");
    
    //For string l add every word in Array wordArray into the Arraylist wordList
    for (String l : wordArray) {
      wordAL.add(l.toLowerCase());
    }

    //Remove blank string value until there is no more blank value to remove
    while (wordAL.remove("")){
    }

    //CheckPoint* Iteration 1 complete = removed special characters between text and add words into Array, ready for comparison

    //-------------------------------------------------------------------//
    // [CODE BELOW ADD ELEMENT TO ARRAYLIST INSERTED FROM STOP.TXT FILE] //
    //-------------------------------------------------------------------//

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

    //--------------------------------------------------------------------------------------//
    // [CODE BELOW COMPARES ARRAYS WORDAL AND STOPAL AND REMOVE STOP WORD FROM THE WEBSITE] //
    //--------------------------------------------------------------------------------------//

    //Checkpoint* Iteration 3 complete = removed stop text from array => 
    for (int b = wordAL.size() - 1; b > 0; b--){
      for(int c = 0; c < stopAL.size(); c++){
        if(wordAL.get(b).equals(stopAL.get(c))){
          wordAL.remove(b);
        }
      }
    }

    //set total amount of word for data analytic purposes
    this.countWordAL = wordAL.size();
  }

  //Post Rating() method output: 
  public void Rating(){
    String posText = "";
    String negText = "";
    
    //----- CONVERT FILE => ARRAY ----------------------------------------------------------//
    // [CODE BELOW ADD ALL POS & NEG ELEMENT TO ARRAY INSERTED FROM POS.TXT & NEG.TXT FILE] //
    //--------------------------------------------------------------------------------------//

    //Try pulling file from pos.txt
    try {
      //Access negativeword from pos.text using java.io.File
      File posFile = new File("pos.txt");
      
      //New Scanner PosScanner
      Scanner myPosScan = new Scanner(posFile);

      //If there is still an element in file from scanner, concatenate posText with word from file
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
      
      //New Scanner myNegScan
      Scanner myNegScan = new Scanner(negFile);

      //If there is still an element in file from scanner, concatenate negText with word from file
      while(myNegScan.hasNextLine()) {
        negText += myNegScan.nextLine() + " ";
      }

      myNegScan.close();

    } catch (FileNotFoundException neg){
      System.out.println("Error Occurred at NegPrintError");
      neg.printStackTrace();
    }

    //----- CONVERT ARRAY => ARRAYLIST ---------------------------------------------------------//
    // [CODE BELOW ADD ALL POS & NEG ELEMENT TO ARRAYLIST INSERTED FROM POS.TXT & NEG.TXT FILE] //
    //------------------------------------------------------------------------------------------//
    
    //Split string by delimeter and add into array
    String[] posArray = posText.split(",");
    String[] negArray = negText.split(",");
    
    //Conevert Array to Arraylist
    for (String pos : posArray) {
      posAL.add(pos.toLowerCase());
    } 
    for (String neg : negArray) {
      negAL.add(neg.toLowerCase());
    }

    //Declare variable
    int ratePositive = 0;
    int rateNegative = 0;

    //----- INCREMENTING POS AND NEG -------------------------------------------------------------//
    // [CODE BELOW RUNS THROUGH EVERY INSTANCE OF MATCHING ELEMENTS AND INCREMENT RELATED VALUES] //
    //--------------------------------------------------------------------------------------------//

    

    //Increment Positive for every match in the array
    for (int x = wordAL.size()-1; x > 0; x--){
      for(int y = 0; y < posAL.size(); y++){
        if(wordAL.get(x).equals(posAL.get(y))){
          ratePositive++;
        }
      }
    }

    //Increment Negative for every match in the array
    for (int x = wordAL.size()-1; x > 0; x--){
      for(int y = 0; y < posAL.size(); y++){
        if(wordAL.get(x).equals(negAL.get(y))){
          rateNegative++;
        }
      }
    }

    //Set variable for main use
    this.negative = rateNegative;
    this.positive = ratePositive;

    negCount.add(rateNegative);
    posCount.add(ratePositive);

    
  }


  //Remove all element from arraylist for repeated use
  //Post clear() method: Clean out array wordAL, stopAL, posAL, and negAL
  public void clear(){
    for(int i = wordAL.size() - 1; i > 0; i--){
      wordAL.remove(i);
    }

    for(int i = stopAL.size() - 1; i > 0; i--){
      stopAL.remove(i);
    }
  
    for(int i = posAL.size() - 1; i > 0; i--){
      posAL.remove(i);
    }

    for(int i = negAL.size() - 1; i > 0; i--){
      negAL.remove(i);
    }
  }


  public void getRate() {

    System.out.println("Positive Sentiment: " + positive + "/" + countWordAL);

    System.out.println("Negative Sentiment: " + negative + "/" + countWordAL);

    double posDou = positive;
    double negDou = negative;

    System.out.println("Ratio: " + getRatio(posDou, negDou) + "/" + getRatio(negDou, negDou));

    getSummary(posDou, negDou);
    
  }

  public double getRatio(double top, double bot){
    double fraction = top/bot;
    return fraction;

  }

  
  //Add all pos
  public void getTotalRate(){
    for(int i = 0; i < posCount.size(); i++){
      Totalpos += posCount.get(i);
    }
    for(int i = 0; i < negCount.size(); i++){
      Totalneg += negCount.get(i);
    }
    
    AverageNeg = Totalneg/negCount.size();
    AveragePos = Totalpos/posCount.size();


    System.out.println("Average Positive Sentiment: " + AveragePos);

    System.out.println("Average Negative Sentiment: " + AverageNeg);

    System.out.println("Average Ratio: " + getRatio(AveragePos, AverageNeg) + "/" + getRatio(AverageNeg, AverageNeg));

    getSummary(AveragePos, AverageNeg);
  }

  //Provide a rating system for 
  public void getSummary(double pos, double neg){

    //Subtract the total ratio by one 
    double result = (pos/neg) - 1.0;
    if (result >= 4.0){
      System.out.print("Overhelmingly Positive");
    }
    else if(result >= 3.0){
      System.out.print("Very Positive");
    }
    else if(result >= 2.0){
      System.out.print("Mostly Positive");
    }
    else if(result >= 1.0){
      System.out.print("Mixed");
    }
    else if(result >= 0.0){
      System.out.print("Negative");
    }
    else if(result >= 0.75){
      System.out.print("Very Negative");
    }
    else if(result >= 0.5){
      System.out.print("Overhelmingly Negative");
    }
    else{
      System.out.print("HOLT CRAP HOW BAD IS THIS PRODUCT?!");
    }

  }

}