FROM finizco/nginx-node:latest
COPY nginx.conf /etc/nginx/
RUN npm install
RUN npm run build
COPY dist /usr/share/nginx/html
EXPOSE 80