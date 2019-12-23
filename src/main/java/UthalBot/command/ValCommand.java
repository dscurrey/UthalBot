package UthalBot.command;

import UthalBot.UthalBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 * Class for the UthalBot.command "Val"
 * Should send a quote in response to UthalBot.command
 */
public class ValCommand extends BotCommands {

    private static Logger logger = LogManager.getLogger(ValCommand.class);

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        this.prefix = UthalBot.prefix;
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.VAL)){
            logger.info("Command Received: "+this.toString()+"/Channel: "+event.getChannel());
            new MessageBuilder()
                    .append("\"BASTARD!\"", MessageDecoration.BOLD)
                    .send(event.getChannel());
        }
    }

}
