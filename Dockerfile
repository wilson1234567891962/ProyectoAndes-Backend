FROM openjdk:8
EXPOSE 8082
ADD log4j.properties log4j.properties
ADD db.json db.json
ADD Reporte_Diario.xlsx Reporte_Diario.xlsx
ADD umb-rutas-bb2a2-firebase-adminsdk-i5tag-814f006d29.json umb-rutas-bb2a2-firebase-adminsdk-i5tag-814f006d29.json
ADD target/login.management.jar login.management.jar
ENTRYPOINT ["java","-jar","/login.management.jar"]
