FROM node:12

COPY package*.json ./

RUN npm install

COPY . .
EXPOSE 5001
CMD ["npm", "run", "start"]