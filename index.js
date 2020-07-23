const Discord = require('discord.js');
const client = new Discord.Client();

client.once('ready', () => {
    console.log('UthalBot Ready.');
});

client.login('login-token')

client.on('message', message => {
    console.log(message.content);
});
