FROM java:8
VOLUME /tmp
ADD build/libs/cloudshaala-services-0.1.0.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.profiles.active=server", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
