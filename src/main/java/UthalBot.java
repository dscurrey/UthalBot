import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class UthalBot {

    private String prefix;
    private DiscordApi api;
    private File config;
    private static Logger logger = LogManager.getLogger(UthalBot.class);

    public UthalBot() {
        //TODO: Fix this
        config = new File("bot.properties");//new File(UthalBot.class.getClassLoader().getResource("bot.properties").getPath());
        api = new DiscordApiBuilder().setToken(getToken()).login().join();

        MessageListener messageListener = new MessageListener();
        api.addMessageCreateListener(messageListener);

        logger.info("Invite Link: " +api.createBotInvite());
    }

    private String getToken() {
        String token = "";
        try {
            FileReader reader = new FileReader(config);
            Properties properties = new Properties();
            properties.load(reader);
            token = properties.getProperty("bot.token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

}
