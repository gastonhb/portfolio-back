FROM amazoncorretto:18
MAINTAINER gastonhb
COPY target/back-0.0.1.jar back-0.0.1.jar
ENTRYPOINT ["java","-jar","/back-0.0.1.jar"]
