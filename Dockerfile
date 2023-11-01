FROM openjdk:11-oracle
EXPOSE 8282
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]

