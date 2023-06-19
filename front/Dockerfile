# Use uma imagem base adequada para o seu projeto frontend
FROM nginx:latest

# Copie o conteúdo do diretório do projeto frontend para o diretório padrão do Nginx
COPY . /usr/share/nginx/html

# Exponha a porta em que o Nginx está ouvindo
EXPOSE 80

# Inicie o servidor Nginx quando o contêiner for iniciado
CMD ["nginx", "-g", "daemon off;"]
