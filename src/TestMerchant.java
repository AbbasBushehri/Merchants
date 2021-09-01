import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class TestMerchant {

    @Test
    public void mainTest() {

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(("glob is I" +
                "\nprok is V" +
                "\npish is X" +
                "\ntegj is L" +
                "\nglob glob Silver is 34 Credits" +
                "\nglob prok Gold is 57800 Credits" +
                "\npish pish Iron is 3910 Credits" +
                "\nhow much is pish tegj glob glob ?" +
                "\nhow many Credits is glob prok Silver ?" +
                "\nhow many Credits is glob prok Gold ?" +
                "\nhow many Credits is glob prok Iron ?" +
                "\nHow much wood could a woodchuck chuck if a woodchuck could chuck wood ?").getBytes());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        Merchant merchant = new Merchant(inputStream, ps);
        merchant.merchantConsole();
        String output = byteArrayOutputStream.toString().trim();

        Assert.assertEquals(output, "pish tegj glob glob is 42" +
                "\r\nglob prok Silver is 68 Credits" +
                "\r\nglob prok Gold is 57800 Credits" +
                "\r\nglob prok Iron is 782 Credits" +
                "\r\nI have no idea what you are talking about");
    }
}
