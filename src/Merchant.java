import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Merchant {
    static String[] numeralsArray = {"I", "V", "X", "L", "C", "D", "M"};
    static List numeralsList = Arrays.asList(numeralsArray);
    static HashMap<String, String> romanMap = new HashMap<>(); //variables that represent roman numerals
    static HashMap<String, Double> creditMap = new HashMap<>();//variables that represent credit values
    static String failure = "I have no idea what you are talking about"; //error message

    static private Scanner scanner;
    static private PrintStream printStream;

    public Merchant(InputStream inputStream, PrintStream printStream){
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public static void main(String args[]){
        Merchant merchant = new Merchant(System.in, System.out);
        merchant.merchantConsole();
    }


    public static void merchantConsole()
    {
        while(true) {
            String input = scanner.nextLine(); //get input
            String[] words = input.split(" ");
            int length = words.length;

            if(length==3 && words[1].equals("is") && numeralsList.contains(words[2])){//Mode 1, update roman map
                romanMap.put(words[0], words[2]);
            }
            else if(words[length-1].equals("Credits") && words[length-3].equals("is")){//Mode 2, update credit map
                updateCreditMap(words, length);
            }
            else if(words[length-1].equals("?") && words[0].equals("how") && words[1].equals("much")){//Mode 3
                //This Mode is for getting the integer value of roman numeral variables
                String [] romanArray = Arrays.copyOfRange(words, 3, length-1);
                int result = RomanNumerals.romanToInteger(romanArray);
                printStream.println(String.join(" ", romanArray) + " is " + result);
            }
            else if(words[length-1].equals("?") && words[0].equals("how") && words[1].equals("many")){//Mode 4
                //This Mode is for getting an integer value with both credit and roman variables involved
                getCredits(words,length);
            } else { //error
                printStream.println(failure);
                break;
            }
        }

    }

    private static void getCredits(String[] words, int length) {
        String creditKey = words[length-2];
        double creditVal = creditMap.get(creditKey); //get the credit variable's value
        String [] romanArray = Arrays.copyOfRange(words, 4, length-2);
        int romanInt = RomanNumerals.romanToInteger(romanArray); //get the roman numeral variables' value
        double result = romanInt * creditVal; //multiply them to get the result
        printStream.println(String.join(" ", romanArray) + " " + creditKey + " is " + (int)result + " Credits");
    }

    private static void updateCreditMap(String[] words, int length) {
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
