FROM openjdk:17-jdk-slim

WORKDIR /gestaoprodutos

COPY target/*.jar /gestaoprodutos/produtos.jar

EXPOSE 10000

CMD java -XX:+UseContainerSupport -jar produtos.jar
