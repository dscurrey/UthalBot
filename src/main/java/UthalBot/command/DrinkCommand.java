package UthalBot.command;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import UthalBot.UthalBot;

/**
 * Class for the UthalBot.command "Drink"
 * Should send a quote in response to UthalBot.command
 */
public class DrinkCommand extends BotCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        this.prefix = UthalBot.prefix;
        System.out.println(prefix);
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.DRINK)){
            new MessageBuilder()
                    .append("\"I'll drink to that!\"", MessageDecoration.BOLD)
                    .send(event.getChannel());
        }
    }
}
