import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; //Imports array lists to place words in.
import java.util.HashSet; // Imports hash set for comaprison to arraylist.

public class ReadFile {
  public static void main(String[] args) {
    // Creates list for each of the two txt files.
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    // Open input219.txt, remove all punctuation and convert each word into a list item.
    try {
      File myObj = new File("Input219.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNext()){
        list.add(myReader.next().replaceAll("[^\\w\\s\\ ]", "").toLowerCase()); // adds each word to list and removes punctuation.
      }
      myReader.close();
    } catch (FileNotFoundException e) { // runs in case of error reading file.
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    // Open google-10000-english-no-swears.txt and convert each word into a list item.
    try {
      File myObj2 = new File("google-10000-english-no-swears.txt");
      Scanner myReader2 = new Scanner(myObj2);
      while (myReader2.hasNext()){
        list2.add(myReader2.next());// adds each word to list.
      }
      myReader2.close();
    } catch (FileNotFoundException e) { // runs in case of error reading file.
      System.out.println("An error occurred.");
      e.printStackTrace();
      
    }     
      
    // remove all words not present in google-10000-english-no-swears.txt from input219.txt
    ArrayList<String> listpluslist2 =new ArrayList<String>(list);    
    listpluslist2.addAll(list2);
    HashSet<String> listunionlist2 =new HashSet<String>(list);
    listunionlist2.addAll(list2);

    System.out.println("--------------------------------------------------");
    for(String s:listunionlist2)
    {
      listpluslist2.remove(s);
    }
    System.out.println("All banned words removed:");
    System.out.println(listpluslist2);
    System.out.println("--------------------------------------------------");
    // insert result into merge sort class.
    MergeSort run = new MergeSort(listpluslist2);
    run.sort();
    run.print();
}

}