package UthalBot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

public class Main {

    public static final Logger logger = LogManager.getLogger(Main.class);
    public static UthalBot bot;


    public static void main(String[] args) {

        FallbackLoggerConfiguration.setDebug(true);

        bot = new UthalBot();

        logger.info("Ready.");
    }
}
