package UthalBot.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import UthalBot.UthalBot;

/**
 * Class for the UthalBot.command "Drink"
 * Should send a quote in response to UthalBot.command
 */
public class DrinkCommand extends BotCommands implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        this.prefix = UthalBot.prefix;
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.DRINK)){
            logger.info("Command Received: "+this.toString());
            new MessageBuilder()
                    .append("\"I'll drink to that!\"", MessageDecoration.BOLD)
                    .send(event.getChannel());
        }
    }
}
