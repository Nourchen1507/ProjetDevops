FROM openjdk:11-oracle
ADD target/achat-1.0.jar achat-1.0.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]

