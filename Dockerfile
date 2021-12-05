FROM openjdk:17-jdk-slim

WORKDIR /gestaoprodutos

COPY target/*.jar /gestaoprodutos/produtos.jar

EXPOSE 8080

CMD java -XX:+UseContainerSupport -jar produtos.jar