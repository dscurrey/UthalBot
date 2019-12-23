package UthalBot.command;

import UthalBot.UthalBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.EnumSet;

public class HelpCommand extends BotCommands {

    private static Logger logger = LogManager.getLogger(HelpCommand.class);

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        this.prefix = UthalBot.prefix;
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.HELP)){
            logger.info("Command Received: "+this.toString()+"/Channel: "+event.getChannel());
            MessageBuilder helpMsg = new MessageBuilder()
                    .append("Command List\n", MessageDecoration.BOLD);
            EnumSet.allOf(CMD.class)
                    .forEach(cmd -> helpMsg.append(prefix+cmd.toString().toLowerCase()+"\n"));
            helpMsg.send(event.getChannel());
        }
    }
}
