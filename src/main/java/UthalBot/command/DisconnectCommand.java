package UthalBot.command;

import UthalBot.Main;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class DisconnectCommand extends BotCommands {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        setupPrefix();
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.DISCONNECT) && event.getMessageAuthor().isServerAdmin()){
            logger.warn("Disconnect Command Received");
            new MessageBuilder()
                    .append("Disconnecting...")
                    .send(event.getChannel());
            Main.bot.api.disconnect();
        }
    }
}
