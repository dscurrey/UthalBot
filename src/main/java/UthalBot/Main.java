package UthalBot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        FallbackLoggerConfiguration.setDebug(true);

        UthalBot bot = new UthalBot();

        logger.info("Ready");
    }
}
