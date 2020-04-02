# Docker image for springboot file run
# VERSION 1.0.0
# Author: yuanhong
# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER yuanhong <1027928543@qq.com>
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ADD course-learning-server.jar CourseLearning.jar

# 运行jar包
RUN bash -c 'touch /CourseLearning.jar'

EXPOSE 9000

ENTRYPOINT ["java","-jar","CourseLearning.jar"]
