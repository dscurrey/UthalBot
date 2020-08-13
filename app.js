const fs = require('fs');
const Discord = require('discord.js');
const {prefix, token} = require('./config.json');

console.log('Bot Version: v1.1.2')

const client = new Discord.Client();
client.commands = new Discord.Collection();

const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'));
for (const file of commandFiles) {
    const command = require(`./commands/${file}`);
    client.commands.set(command.name, command);
}

client.once('ready', () => {
    console.log('UthalBot Ready.');
});

client.login(token)

client.on('message', message => {
    if (/steelstorm/i.test(message.content))
    {
        message.react('⚔');
    }

    if (!message.content.startsWith(prefix) || message.author.bot) return;
    const args = message.content.slice(prefix.length).trim().split(/ +/);
    const commandName = args.shift().toLowerCase();

    const command = client.commands.get(commandName);

    if (!command) return;
    if (command.args && !args.length) {
        let reply = `No args provided, ${message.author}.`;
        if (command.usage) {
            reply += `\nThe proper usage would be: \`${prefix}${commandName} ${command.usage}\``;
        }
        return message.channel.send(reply);
    }

    try {
        command.execute(message, args);
    } catch (error) {
        console.error(error);
        message.reply('An error occurred.');
    }
});
