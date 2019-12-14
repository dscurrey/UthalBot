FROM openjdk:8

WORKDIR /

ADD UthalBot.jar UthalBot.jar
ADD bot.properties bot.properties

EXPOSE 8080

CMD java -jar UthalBot.jar