import java.util.*;

public class Main {
    static String[] numeralsArray = {"I", "V", "X", "L", "C", "D", "M"};
    static List numeralsList = Arrays.asList(numeralsArray);
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
            int length = words.length;

            if(length==3 && words[1].equals("is") && numeralsList.contains(words[2])){//Mode 1, update roman map
                romanMap.put(words[0], words[2]);
            }
            else if(words[length-1].equals("Credits") && words[length-3].equals("is")){//Mode 2, update credit map
                updateCreditMap(words, length);
            }
            else { //error
                System.out.println(failure);
            }
        }

    }

    private static void updateCreditMap(String[] words, int length) {
        int creditVal = Integer.parseInt(words[length-2]);//there should be an integer right before "Credits"
        String key = words[length-4];//This is the name of the credit variable
        //First part of string should be variables representing roman numerals
        //So I get an array of just these roman variables
        String[] romanArray = Arrays.copyOfRange(words, 0, length-4);
        String roman = "";
        for(int i = 0; i <romanArray.length; i++){
            roman += romanMap.get(romanArray[i]); //converting the roman variables to their values (ex: glob->V)
        }
        int romanInt = RomanNumerals.romanToInteger(roman); //convert the roman numerals to integer
        int value = creditVal / romanInt; //get the value of the credit variable
        creditMap.put(key, value); //finally update map
    }


}
