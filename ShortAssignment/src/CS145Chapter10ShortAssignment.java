// CS145 
// Chapter 10 - Short Assignment
// Array Lists

import java.util.*;

public class CS145Chapter10ShortAssignment
{
  public static void main(String[] args)
  {
    List<String> myList = new ArrayList<>();
    
    myList.add("Four");
    myList.add("score");
    myList.add("and");
    myList.add("seven");
    myList.add("years");
    myList.add("ago.");

    System.out.print("Before: ");
    System.out.println(myList);
    
    swapPairsChallengeMode(myList);
    //swapPairs(myList);
    
    System.out.print("After:  ");    
    System.out.println(myList);

    // Round 2 - Odd
    System.out.println();
    System.out.println("***********");
    System.out.println();
    
    myList.clear();
    
    myList.add("1");
    myList.add("2");
    myList.add("3");
    myList.add("4");
    myList.add("5");
    myList.add("6");
    myList.add("7");    
    myList.add("8");   
    myList.add("9");             

    System.out.print("Before: ");
    System.out.println(myList);

    swapPairsChallengeMode(myList);
    //swapPairs(myList);
    
    System.out.print("After:  ");    
    System.out.println(myList);

  }

  /**
   * This method will take in a List<String> and swaps the strings in a pairwise fashion.
   *
   * @param list Takes in a List<String> and swaps the strings in a pairwise fashion.
   * @return this returns the list.
   */
  public static List<String> swapPairs(List<String> list) {

    // Properties
    String wordOne, wordTwo;
    int size = list.size();


    if(size % 2 == 0) {

      // The list has an even number.
      for(int i = 0; i < size; i = i + 2) {

        // Set the properties
        wordOne = list.get(i);
        wordTwo = list.get(i + 1);

        // Swap the words
        list.set(i, wordTwo);
        list.set(i + 1, wordOne);

      }

    } else {

      // The list has an odd number.
      for(int i = 0; i < size - 1; i = i + 2) {

        // Set the properties
        wordOne = list.get(i);
        wordTwo = list.get(i + 1);

        // Swap the words
        list.set(i, wordTwo);
        list.set(i + 1, wordOne);

      }

    }

    return list;

  }

  /**
   * This method will take in a List<String> and swaps the strings in a pairwise fashion.
   *
   * NOTES - I figured this way was possible since you can do something similar with
   * Swift, and while reading chapter 10 i came across "Collections.sort"(Another similar thing in Swift)
   * , which got me wondering so i looked up the Java API and read about Collections.swap.
   *
   * @param list Takes in a List<String> and swaps the strings in a pairwise fashion.
   * @return this returns the list.
   */
  public static List<String> swapPairsChallengeMode(List<String> list)  {

    for(int i = 0; i < list.size() - 1; i = i + 2) {
      Collections.swap(list, i, i + 1);
    }

    return list;

  }


}

    
    
    