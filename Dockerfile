FROM node:12

WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install

VOLUME /usr/src/app

COPY . .

CMD [ "node", "index.js" ]
