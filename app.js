const fs = require('fs');
const Discord = require('discord.js');
const {prefix, token} = require('./config.json');
const logger = require('pino')({
    prettyPrint: true
});

logger.info('Bot Version: v1.2')

const client = new Discord.Client();
client.commands = new Discord.Collection();

const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'));
for (const file of commandFiles) {
    const command = require(`./commands/${file}`);
    client.commands.set(command.name, command);
}

client.once('ready', () => {
    logger.info('UthalBot Ready.');
});

client.login(token).catch(function(e) {
   logger.error(e);
});

client.on('message', message => {
    if (/steelstorm/i.test(message.content)) {
        message.react('⚔').catch(function(e) {
            logger.error(e);
        });
    }

    if (!message.content.startsWith(prefix) || message.author.bot) return;
    logger.debug('Valid message read.');
    const args = message.content.slice(prefix.length).trim().split(/ +/);
    const commandName = args.shift().toLowerCase();

    const command = client.commands.get(commandName);

    if (!command) {
        logger.debug('Invalid command.')
        return;
    }
    if (command.args && !args.length) {
        logger.debug('Invalid args received.')
        let reply = `No args provided, ${message.author}.`;
        if (command.usage) {
            reply += `\nThe proper usage would be: \`${prefix}${commandName} ${command.usage}\``;
        }
        return message.channel.send(reply);
    }

    try {
        logger.info('Executing: '+ message.content)
        command.execute(message, args);
    } catch (error) {
        logger.error(error);
        message.reply('An error occurred.');
    }
});
