const {prefix} = require('../config.json');

module.exports = {
    name: 'help',
    description: 'Lists info on all commands, or on a specific command',
    usage: '[command name]',
    execute(message, args) {
        const data = [];
        const {commands} = message.client;

        if (!args.length) {
            data.push('List of commands:');
            data.push(commands.map(command => command.name).join(', '));
            data.push(`You can send \`${prefix}help [command name]\` to get info on a specific command.`);

            return message.author.send(data, {split: true}).then( () => {
                if (message.channel.type === 'dm') return;
                message.reply('DM Sent.')
            })
            .catch(error => {
                console.error('An error occurred.');
                message.reply('An error occurred.');
            });
        }

        const name = args[0].toLowerCase();
        const command = commands.get(name);
        if (!command) {
            return message.reply(`Command invalid.`)
        }

        data.push(`**Name** ${command.name}`);

        if (command.description) data.push(`**Description** ${command.description}`);
        if (command.usage) data.push(`**Usage** ${command.usage}`);

        message.channel.send(data, {split: true});
    }
}