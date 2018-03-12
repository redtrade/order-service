FROM openjdk:8-jre-alpine
COPY build/libs/order-service-1.0.jar /usr/src/order-service/
WORKDIR /usr/src/order-service
ENTRYPOINT ["java", "-jar", "order-service-1.0.jar"]
