# 使用官方的Maven镜像作为基础镜像
FROM maven:3.8.6-eclipse-temurin-21 as builder

# 将Maven项目的源代码添加到镜像中
COPY src /home/app/src
COPY pom.xml /home/app

# 切换到应用目录
WORKDIR /home/app

# 构建Maven项目
RUN mvn clean package

# 使用官方的OpenJDK 21镜像作为基础镜像（如果官方镜像不存在，你可能需要自行构建或使用其他方式安装Java 21）
FROM eclipse-temurin:21-jdk-focal

# 将构建好的JAR文件从builder镜像复制到此镜像中
COPY --from=builder /home/app/target/*.jar /usr/local/lib/app.jar

# 设置环境变量，以便容器可以识别Java应用的JAR文件路径
ENV JAVA_OPTS=""
ENV APP_FILE="/usr/local/lib/app.jar"

# 暴露端口（如果你的应用需要）
EXPOSE 8080

# 设置容器启动时执行的命令
CMD ["sh", "-c", "java $JAVA_OPTS -jar $APP_FILE"]