package UthalBot.command;

import UthalBot.UthalBot;
import com.vdurmont.emoji.EmojiParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

/**
 * A test command for using Emoji in the bot
 */
public class EmojiCommand extends BotCommands {

    private static Logger logger = LogManager.getLogger(ValCommand.class);

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        this.prefix = UthalBot.prefix;
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().toLowerCase().contains("steelstorm")){
            logger.info("\"Steelstorm Detected, applying reaction\" "+this.toString()+"/Channel: "+event.getChannel());
            event.getMessage().addReaction(EmojiParser.parseToUnicode(":crossed_swords:"));
        }
    }

}
