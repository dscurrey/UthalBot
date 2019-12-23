package UthalBot.command;

import com.vdurmont.emoji.EmojiParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.event.message.MessageCreateEvent;

/**
 * A test command for using Emoji in the bot
 */
public class SteelstormDetectCommand extends BotCommands {

    private static final Logger logger = LogManager.getLogger(SteelstormDetectCommand.class);

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        setupPrefix();
        if(event.getMessageAuthor().isBotUser()){
            return;
        }
        if(event.getMessageContent().toLowerCase().contains("steelstorm")){
            logger.info("\"Steelstorm Detected, applying reaction\" "+this.toString()+"/Channel: "+event.getChannel());
            event.getMessage().addReaction(EmojiParser.parseToUnicode(":crossed_swords:"));
        }
    }

}
