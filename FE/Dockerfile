# Usa Flutter como base
FROM ghcr.io/cirruslabs/flutter:latest AS build

# Directorio de trabajo
WORKDIR /app

# Copia archivos del proyecto
COPY . .

# Build en modo web
RUN flutter build web

# Servidor Nginx
FROM nginx:alpine

# Copia de archivos compilados
COPY --from=build /app/build/web /usr/share/nginx/html

# LISTEN 80
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
