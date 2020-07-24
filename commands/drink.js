module.exports = {
    name: 'drink',
    description: 'Uthal\'s drink commnand.',
    execute(message, args) {
        message.channel.send('**I\'ll drink to that!**');
    },
};