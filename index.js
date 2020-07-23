const Discord = require('discord.js');
const {prefix, token} = require('./config.json');
const client = new Discord.Client();

client.once('ready', () => {
    console.log('UthalBot Ready.');
});

client.login(token)

client.on('message', message => {
    if (message.content === `${prefix}ping`) {
        message.channel.send('Pong.');
    }
});
