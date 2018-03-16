FROM springio/gs-spring-boot-docker

ENV APP_NAME /app/bin/partner

WORKDIR /app

COPY ./target/classes/. .

COPY . .

EXPOSE 8080

CMD  ${APP_NAME}