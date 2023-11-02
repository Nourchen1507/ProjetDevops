FROM openjdk:11-oracle
EXPOSE 8282
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]

