package UthalBot;

import UthalBot.command.DrinkCommand;
import UthalBot.command.HelpCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class UthalBot {

    public static String prefix;
    private String token;
    private DiscordApi api;
    private File config;
    private static Logger logger = LogManager.getLogger(UthalBot.class);

    public UthalBot() {

        readConfig();

        api = new DiscordApiBuilder().setToken(token).login().join();

        setupCMDs();

        logger.info("Invite Link: " +api.createBotInvite());
    }

    private void readConfig(){
        config = /*new File("bot.properties");//*/new File(UthalBot.class.getClassLoader().getResource("bot.properties").getPath());
        try {
            FileReader reader = new FileReader(config);
            Properties properties = new Properties();
            properties.load(reader);
            token = properties.getProperty("bot.token");
            prefix = properties.getProperty("bot.prefix");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupCMDs(){
        api.addMessageCreateListener(new DrinkCommand());
        api.addMessageCreateListener(new HelpCommand());
    }

}
