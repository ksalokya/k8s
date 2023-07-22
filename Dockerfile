FROM openjdk:8
EXPOSE 8080
ADD target/boot-k8s.jar boot-k8s.jar
ENTRYPOINT ["java","-jar","/boot-k8s.jar"]