FROM mongo:latest
ENV MONGO_INITDB_DATABASE taskdb
ADD mongo-init.js /docker-entrypoint-initdb.d/

FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY target/*.jar taskmongo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/taskmongo-0.0.1-SNAPSHOT.jar"]