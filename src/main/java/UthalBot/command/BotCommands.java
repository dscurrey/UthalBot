package UthalBot.command;

import UthalBot.Main;
import UthalBot.UthalBot;
import org.apache.logging.log4j.Logger;
import org.javacord.api.listener.message.MessageCreateListener;

abstract class BotCommands implements MessageCreateListener {

    String prefix;
    protected Logger logger = Main.logger;

    void setupPrefix()
    {
        this.prefix = UthalBot.prefix;
    }

}
