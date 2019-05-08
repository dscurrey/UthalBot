import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class MessageListener implements MessageCreateListener {

    String prefix;

    public MessageListener() {
        confPrefix();
    }

    private void confPrefix(){
        //TODO: Fix this
        File config = /*new File("bot.properties");//*/new File(MessageListener.class.getClassLoader().getResource("bot.properties").getPath());
        try {
            FileReader reader = new FileReader(config);
            Properties properties = new Properties();
            properties.load(reader);
            prefix = properties.getProperty("bot.prefix");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        parseMessage(event.getMessage());
    }

    private void parseMessage(Message msg) {
        if(msg.getContent().equalsIgnoreCase(prefix+"drink")){
            new MessageBuilder()
                    .append("\"I'll drink to that!\"", MessageDecoration.BOLD)
                    .send(msg.getChannel());
        }
    }
}
