FROM openjdk:11
COPY target/comeback-0.0.1-SNAPSHOT.jar comebackT.jar
ENTRYPOINT ["java", "-jar", "comeback-0.0.1-SNAPSHOTS.jar"]
