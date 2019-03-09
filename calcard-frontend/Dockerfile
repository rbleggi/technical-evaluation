FROM finizco/nginx-node:latest
COPY nginx.conf /etc/nginx/
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
RUN npm run build
COPY /app/dist /usr/share/nginx/html
EXPOSE 80