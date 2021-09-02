package test;

import main.Merchant;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

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


        Logger logger = (Logger) LoggerFactory.getLogger(Merchant.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        Merchant merchant = new Merchant(inputStream, logger);
        merchant.merchantConsole();
        List<ILoggingEvent> logsList = listAppender.list;

        //substring removes [INFO] tag and trailing space
        Assert.assertEquals(logsList.get(0).toString().substring(7), "pish tegj glob glob is 42");
        Assert.assertEquals(logsList.get(1).toString().substring(7), "glob prok Silver is 68 Credits");
        Assert.assertEquals(logsList.get(2).toString().substring(7), "glob prok Gold is 57800 Credits");
        Assert.assertEquals(logsList.get(3).toString().substring(7), "glob prok Iron is 782 Credits");
        Assert.assertEquals(logsList.get(4).toString().substring(7), "I have no idea what you are talking about");
    }
}
