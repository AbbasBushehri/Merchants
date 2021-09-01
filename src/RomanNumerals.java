// class for converting roman numerals to integers
import java.util.*;

public class RomanNumerals {
    //converts an array of roman numeral variables to an integer value
    public static int romanToInteger(String[] array){
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);
        String roman = "";

        for(int i = 0; i <array.length; i++){
            roman += Main.romanMap.get(array[i]); //converting the roman variables to their values (ex: glob->V)
        }

        int result=0;
        for(int i=0;i<roman.length();i++)
        {
            char ch = roman.charAt(i);      // Current Roman Character

            //Case 1: Current character is greater than previous (ex: IV)
            //In this case use the following formula to add to result
            if(i>0 && numbersMap.get(ch) > numbersMap.get(roman.charAt(i-1)))
            {
                result += numbersMap.get(ch) - 2*numbersMap.get(roman.charAt(i-1));
            }

            // Case 2: Current character is >= to previous character (ex: VI) or is single numeral (ex: V)
            // In this case just add the corresponding number to result.
            else
                result += numbersMap.get(ch);
        }

        return result;
    }

}
