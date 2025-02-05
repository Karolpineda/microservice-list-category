# Usar una imagen base con OpenJDK 17
FROM openjdk:17-jdk-slim

# Fijar el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml
COPY pom.xml ./pom.xml

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Copiar todo el código fuente
COPY src ./src

# Ejecutar Maven para construir el archivo .jar
RUN mvn clean package -DskipTests

# Exponer el puerto en el que la aplicación estará corriendo
EXPOSE 8086

# Ejecutar el JAR
CMD ["java", "-jar", "target/microservice-create-category-0.0.1-SNAPSHOT.jar"]
