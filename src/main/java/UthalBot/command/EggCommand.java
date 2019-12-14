package UthalBot.command;

import UthalBot.UthalBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.EnumSet;

public class EggCommand extends BotCommands {

    private static Logger logger = LogManager.getLogger(ValCommand.class);

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        this.prefix = UthalBot.prefix;
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().equalsIgnoreCase(prefix+CMD.EGG)){
            logger.info("Command Received: "+this.toString()+"/Channel: "+event.getChannel());
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("Egg")
                    .setColor(Color.GREEN)
                    .setImage(new File("https://scx2.b-cdn.net/gfx/news/hires/2017/egg.png"));
            event.getChannel().sendMessage(embed);
        }
    }
}
