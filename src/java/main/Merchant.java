package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.*;

public class Merchant {
    static final String[] numeralsArray = {"I", "V", "X", "L", "C", "D", "M"};
    static final List<String> numeralsList = Arrays.asList(numeralsArray);
    static final HashMap<String, String> romanMap = new HashMap<>(); //variables that represent roman numerals
    static final HashMap<String, Double> creditMap = new HashMap<>();//variables that represent credit values
    static final String ERROR = "I have no idea what you are talking about"; //error message

     private Scanner scanner;
     private Logger logger;

    public Merchant(InputStream inputStream, Logger logger){
        this.scanner = new Scanner(inputStream);
        this.logger = logger;
    }


    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(Merchant.class);
        Merchant merchant = new Merchant(System.in, logger);

        merchant.merchantConsole();
    }

    public void merchantConsole()
    {
        while(true) {
            String input = scanner.nextLine(); //get input
            String[] words = input.split(" ");
            int length = words.length;

            String preWord = ""; //string will make mode selection easier later on
            if(length>=3){
                preWord = words[0] + " " +  words[1] + " " + words[2];
            }

            if(length==3 && words[1].equals("is") && numeralsList.contains(words[2])){//Mode 1, update roman map
                romanMap.put(words[0], words[2]);
            }
            else if(words[length-1].equals("Credits") && words[length-3].equals("is")){//Mode 2, update credit map
                updateCreditMap(words, length);
            }
            else if(words[length-1].equals("?") && preWord.equals("how much is")){//Mode 3
                //This Mode is for getting the integer value of roman numeral variables
                String [] romanArray = Arrays.copyOfRange(words, 3, length-1);
                int result = RomanNumerals.romanToInteger(romanArray);
                String message = String.join(" ", romanArray) + " is " + result;
                logger.info(message);
            }
            else if(words[length-1].equals("?") && preWord.equals("how many Credits")){//Mode 4
                //This Mode is for getting an integer value with both credit and roman variables involved
                getCredits(words,length);
            } else { //error
                logger.info(ERROR);
                break;
            }
        }

    }

    private void getCredits(String[] words, int length) {
        String creditKey = words[length-2];
        double creditVal = creditMap.get(creditKey); //get the credit variable's value
        String [] romanArray = Arrays.copyOfRange(words, 4, length-2);
        int romanInt = RomanNumerals.romanToInteger(romanArray); //get the roman numeral variables' value
        double result = romanInt * creditVal; //multiply them to get the result
        String message = String.join(" ", romanArray) + " " + creditKey + " is " + (int)result + " Credits";
        logger.info(message);
    }

    private void updateCreditMap(String[] words, int length) {
        int creditVal = Integer.parseInt(words[length-2]);//there should be an integer right before "Credits"
        String key = words[length-4];//This is the name of the credit variable
        //First part of string should be variables representing roman numerals
        //So I get an array of just these roman variables
        String[] romanArray = Arrays.copyOfRange(words, 0, length-4);
        int romanInt = RomanNumerals.romanToInteger(romanArray); //convert the roman numeral variables to integer
        double value = creditVal * 1.0 / romanInt; //get the value of the credit variable
        creditMap.put(key, value); //Finally update map
    }


}
