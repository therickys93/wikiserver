FROM alpine
RUN apk update && apk add --no-cache git nss bash openjdk8 libstdc++
RUN rm -rf /var/cache/apk/*
ADD . /app
WORKDIR /app
RUN ./gradlew clean stage
CMD /bin/bash run.sh
