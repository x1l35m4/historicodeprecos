# Use a imagem base para construção
FROM ubuntu:latest AS build

# Instalar dependências
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
# Copiar código fonte
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

# Use a imagem slim para produção
FROM openjdk:17-jdk-slim

# Expor a porta
EXPOSE 8080

# Copiar o JAR gerado na etapa de build
COPY --from=build /target/historicodeprecos-0.0.1-SNAPSHOT.jar app.jar

# Entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]