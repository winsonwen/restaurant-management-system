FROM java:8

EXPOSE 9001

VOLUME /tmp
ADD /restaurant-management-system-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=pro"]
