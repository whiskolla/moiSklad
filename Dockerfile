# Используем официальный образ OpenJDK для сборки приложения
FROM openjdk:17

# Устанавливаем директорию приложения
WORKDIR /app

# Копируем JAR файл с приложением в контейнер
COPY out/artifacts/moiSklad_jar/moiSklad.jar /app/moiSklad.jar

EXPOSE 8080

# Запускаем приложение при старте контейнера
CMD ["java", "-jar", "moiSklad.jar"]