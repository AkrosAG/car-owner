FROM node:lts AS builder
WORKDIR /usr/src/app

COPY ./package*.json ./
RUN npm install

COPY ./ ./
RUN npm run build

FROM nginx:stable AS deploy

COPY --from=builder /usr/src/app/dist/car-owner-ui/ /usr/share/nginx/html/

EXPOSE 80 80
