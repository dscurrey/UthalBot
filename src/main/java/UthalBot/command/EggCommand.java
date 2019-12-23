package UthalBot.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;

public class EggCommand extends BotCommands {

    private static final Logger logger = LogManager.getLogger(EggCommand.class);

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        setupPrefix();
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.EGG)){
            logger.info("Command Received: "+this.toString()+"/Channel: "+event.getChannel());
            new MessageBuilder()
                    .addAttachment(new File("egg.png"))
                    .send(event.getChannel());
        }
    }
}
