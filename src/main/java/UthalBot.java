import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class UthalBot {

    private String prefix;
    private JDABuilder builder;
    private File config;

    public UthalBot() {
        config = new File(UthalBot.class.getClassLoader().getResource("bot.properties").getPath());
        builder = new JDABuilder(AccountType.BOT);

        configBot();

        try {
            builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void configBot() {
        builder.setToken(getToken());
        builder.addEventListeners(new MessageListener());
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
