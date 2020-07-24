module.exports = {
    name: 'egg',
    description: 'Egg.',
    execute(message, args) {
        message.channel.send('Egg.', {
            files: ["./egg.png"]
        });
    },
};