package UthalBot.command;

import UthalBot.UthalBot;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 * Class for the UthalBot.command "Val"
 * Should send a quote in response to UthalBot.command
 */
public class ValCommand extends BotCommands implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        this.prefix = UthalBot.prefix;
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.VAL)){
            new MessageBuilder()
                    .append("\"BASTARD!\"", MessageDecoration.BOLD)
                    .send(event.getChannel());
        }
    }

}
