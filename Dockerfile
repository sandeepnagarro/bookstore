FROM java:8
ADD target/docker-book-store.jar docker-book-store.jar
ENTRYPOINT ["java", "-jar", "docker-book-store.jar"]
EXPOSE 8080
