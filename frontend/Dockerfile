# Parto de una imagen base, solo con NGINX
FROM nginx

ENV TZ=America/Argentina/Buenos_Aires
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Version para la app minificada
COPY dist /usr/share/nginx/html/

#pp/images/logo.pngParche para poner el LOGO sin renombrarlo
#COPY logo.png /usr/share/nginx/html/images/

# Copio la configuracion del nginx con el proxy para el backend
COPY default.conf /etc/nginx/conf.d/
