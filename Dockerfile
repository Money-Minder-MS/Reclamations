FROM eclipse-temurin:17
COPY target/Reclamation-1.0-SNAPSHOT.jar rec.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","rec.jar"]