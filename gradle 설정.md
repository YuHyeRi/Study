# gradle 설정

# Port Number

server.port=8282

# MYSQL Connect

spring.datasource.url=jdbc:mysql://localhost:3306/study?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=test
spring.datasource.password=tiger

# ORM JPA

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true

# View Resolver

spring.thymeleaf.prefix=classpath:templates/
spring.thymeleaf.check-template-location=true
spring.thymeleaf.suffix=.html
spring.thymeleaf.cache=false
