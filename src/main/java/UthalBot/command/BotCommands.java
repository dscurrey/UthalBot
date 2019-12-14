package UthalBot.command;

import UthalBot.Main;
import org.apache.logging.log4j.Logger;
import org.javacord.api.listener.message.MessageCreateListener;

public abstract class BotCommands implements MessageCreateListener {

    protected String prefix;
    protected Logger logger = Main.logger;

}
