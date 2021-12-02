# the first stage of our build
FROM adoptopenjdk:14-jre-hotspot as bulder
WORKDIR application
COPY . .
RUN ./gradlew build -x test -i --stacktrace
RUN ls

# the will extract the layers
FROM adoptopenjdk:14-jre-hotspot as extractor
WORKDIR application
ARG JAR_FILE=application/build/libs/*.jar
COPY --from=bulder ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# the second stage of our build will copy the extracted layers
FROM adoptopenjdk:14-jre-hotspot
WORKDIR application
COPY --from=extractor application/dependencies/ ./
COPY --from=extractor application/spring-boot-loader/ ./
COPY --from=extractor application/snapshot-dependencies/ ./
COPY --from=extractor application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]