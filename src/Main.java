import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[] numeralsArray = {"I", "V", "X", "L", "C", "D", "M"};
    static List numeralsList = Arrays.asList(numeralsArray.clone());
    static HashMap<String, String> romanMap = new HashMap<>(); //variables that represent roman numerals
    static HashMap<String, Integer> creditMap = new HashMap<>();//variables that represent credit values
    static String failure = "I have no idea what you are talking about."; //error message

    public static void main(String args[])
    {
//        // we take input as a String
//        String romanNumber="MCMXCIV";
//        int result = RomanNumerals.romanToInteger(romanNumber);
//
//        System.out.println("The Roman Number is: "+romanNumber);
//        System.out.println("Its Integer Value is: "+result);
//
//        System.out.println();
//
//        romanNumber="DCCXCIX";
//        result = RomanNumerals.romanToInteger(romanNumber);
//
//        System.out.println("The Roman Number is: "+romanNumber);
//        System.out.println("Its Integer Value is: "+result);

        while(true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine(); //get input
            String[] words = input.split(" ");
            if(words.length==3 && words[1].equals("is") && numeralsList.contains(words[2])){ //Mode 1
                romanMap.put(words[0], words[2]); //update roman numeral map
            } else {
                System.out.println(failure);
            }
        }

    }



}
