FROM matiasdg/java8-jce
ENV JAVA_HOME=/usr/lib/jvm/default-jvm
#VOLUME /tmp

ADD build/libs/backend-0.0.1-SNAPSHOT.jar app.jar

ADD seppreprod.colonseguros.com.ar.crt seppreprod.colonseguros.com.ar.crt
ADD sep.colonseguros.com.ar.crt sep.colonseguros.com.ar.crt

RUN $JAVA_HOME/bin/keytool -noprompt -import -alias colonprod -file sep.colonseguros.com.ar.crt -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit
RUN $JAVA_HOME/bin/keytool -noprompt -import -alias colonpreprod -file seppreprod.colonseguros.com.ar.crt -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit

ENV TZ=America/Argentina/Buenos_Aires
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
