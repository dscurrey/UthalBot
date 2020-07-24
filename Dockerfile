FROM node:12

WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install

VOLUME [ "/uthalbot" ]

COPY . .

CMD [ "node", "index.js" ]
