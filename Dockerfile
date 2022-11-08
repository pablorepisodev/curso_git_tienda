FROM openjdk:11
EXPOSE 8080
ADD target/tienda.jar tienda.jar
ENTRYPOINT ["java", "-jar", "/tienda.jar"]