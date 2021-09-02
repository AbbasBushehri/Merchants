import org.junit.Assert;
import org.junit.Test;

import java.io.*;

@SuppressWarnings("SpellCheckingInspection")
public class TestMerchant {

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void mainTest() {

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(("glob is I" +
                "\r\nprok is V" +
                "\r\npish is X" +
                "\r\ntegj is L" +
                "\r\nglob glob Silver is 34 Credits" +
                "\r\nglob prok Gold is 57800 Credits" +
                "\r\npish pish Iron is 3910 Credits" +
                "\r\nhow much is pish tegj glob glob ?" +
                "\r\nhow many Credits is glob prok Silver ?" +
                "\r\nhow many Credits is glob prok Gold ?" +
                "\r\nhow many Credits is glob prok Iron ?" +
                "\r\nHow much wood could a woodchuck chuck if a woodchuck could chuck wood ?").getBytes());

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
