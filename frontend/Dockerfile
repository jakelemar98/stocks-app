FROM node:12-alpine as node
WORKDIR /usr/src/app

COPY ./stocks/package*.json ./

RUN npm install

COPY ./stocks/ .

RUN npm run build

#stage 2
FROM nginx:1.13.12-alpine

COPY --from=node /usr/src/app/dist/angular-docker /usr/share/nginx/html

COPY ./nginx.conf /etc/nginx/conf.d/default.conf

CMD ["nginx", "-g", "daemon off;"]
