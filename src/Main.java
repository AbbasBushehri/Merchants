public class Main {
    public static void main(String args[])
    {
        // we take input as a String
        String romanNumber="MCMXCIV";
        int result = RomanNumerals.romanToInteger(romanNumber);

        System.out.println("The Roman Number is: "+romanNumber);
        System.out.println("Its Integer Value is: "+result);

        System.out.println();

        romanNumber="DCCXCIX";
        result = RomanNumerals.romanToInteger(romanNumber);

        System.out.println("The Roman Number is: "+romanNumber);
        System.out.println("Its Integer Value is: "+result);
    }
}
