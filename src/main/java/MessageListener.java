import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class MessageListener extends ListenerAdapter {

    String prefix;

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        Message msg = event.getMessage();
        String content = msg.getContentRaw();

        if(content.equalsIgnoreCase(prefix+Cmds.TEST)){
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Test!").queue();
        }
    }

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        super.onReady(event);
        confPrefix();
        System.out.println("Prefix: "+prefix);
    }

    private void confPrefix(){
        File config = new File(MessageListener.class.getClassLoader().getResource("bot.properties").getPath());
        try {
            FileReader reader = new FileReader(config);
            Properties properties = new Properties();
            properties.load(reader);
            prefix = properties.getProperty("bot.prefix");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
