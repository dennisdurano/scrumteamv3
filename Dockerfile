from java:8
volume /tmp
ARG JAR_FILE
COPY ${JAR_FILE} scrumteamv2.jar
env java_opts='Xmx256m -Xms128m'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /scrumteamv2.jar"]
