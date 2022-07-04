### ***Spring Security란?***

- Spring Security는 Spring 기반 애플리케이션의 보안을 담당하는 스프링 하위 프레임워크이다.
- Spring Security는 ‘인증(Authentication)'과 '권한(Authorization)’에 대한 부분을 Filter의 흐름에 따라 처리를 하고 있다.
- 많은 보안 관련 옵션들을 제공해주어 개발자가 보안 로직을 하나씩 작성하지 않아도 되는 장점이 있다.

### ***인증(Authentication)과 권한(Authorization)***

- **인증(Authentication)**
    - 사이트에 접속하려는 자가 누구인지 확인하는 절차이다. (사용자가 본인인지 확인)
    - UsernamePassword를 통한 인증을 할 수 있다. (Session관리, Token관리)
    - SNS 로그인을 통한 인증 위임을 할 수도 있다.
- **권한(Authorization)**
    - 사용자가 어떤 일을 할 수 있는지 권한 설정하는 절차이다.
    - 특정 페이지/리소스에 접근할 수 있는지 권한을 판단한다.
    - Secured, PrePostAuthorize 어노테이션으로 쉽게 권한 체크를 할 수 있다.
    - 비즈니스 로직이 복잡한 경우 AOP를 이용해 권한 체크를 해야 한다.
    

👉 인증(Authentication) 절차를 거친 후에 권한(Authorization) 절차를 진행하게 된다.

👉 Spring Security에서는 이러한 인증과 인가를 위해 Principal을 아이디로, Credential을 비밀번호로 사용하는 Credential 기반의 인증 방식을 사용한다.

- Principal (접근주체) : 보호받는 Resource에 접근하는 대상
- Credentail (비밀번호) : Resource에 접근하는 대상의 비밀번호

### *Spring Security 의존성 추가 방법*

Spring security의 의존성이 추가되지 않은 경우 해당 url을 접속하였을 때, 아무런 보안, 인증 없이 접속이 가능하다. 그러한 프로젝트에 다음과 같이 Spring security 의존성을 추가해보겠다.

Maven 방식

```java
<dependency>
	<groupId>org.springframwork.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Gradle 방식

```java
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
```

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6932a6ef-0adc-4ef6-951e-48aed35d48f7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220529%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220529T110950Z&X-Amz-Expires=86400&X-Amz-Signature=43e21e426ab2bddc114ae90442d9803b616731f48a2d5cc7c689a76e4a28ceaf&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

security 의존성을 추가하면 다음 사진과 같이 특정 url에 접속을 할 때 인증을 받게 된다. 해당 로그인 화면은 Spring Security에서 제공하는 기본적인 로그인 페이지이며 사용자의 설정에 따라 사용자가 직접 만든 디자인의 페이지로 변경이 가능하다.

해당 페이지의 로그인 정보는 기본 설정으로 Username, 즉 id는 `user`가 기본 아이디이며 패스워드는 아래의 이미지의 네모로 표시된 부분이 기본 비밀번호가 된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ae4474fe-3748-4680-b7af-d6f98d0ec0d4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220529%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220529T111007Z&X-Amz-Expires=86400&X-Amz-Signature=22fb56e2b595cfd23e099fe423b6c1be568a1cead610ea782c2b10f4fc4b6fd2&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

해당 아이디와 비밀번호를 입력하여 접속을 하면 접속하고자 하였던 url에 접속을 할 수 있다.

<aside>
💡 아이디와 비밀번호는 [application.properties](http://application.properties) 에서 다음과 같이 고정된 id/pw를 설정하여 
테스트 할 수도 있다.

spring.security.user.name=user
spring.security.user.password=1111

</aside>

오늘은 Spring Security가 무엇인가와 Spring Security의 의존성 추가 방법에 대해 알아보았다.
다음 포스트부터 더욱 구체적인 Spring Security에 대해 알아보도록 하겠다.

#### 🟠 출처 : [https://velog.io/@seongwon97/Spring-Security-Spring-Security란](https://velog.io/@seongwon97/Spring-Security-Spring-Security%EB%9E%80)
#### 🟠 노션 : https://www.notion.so/Spring-Spring-Security-6eebf0e1d1a847d18cee57e5dba78d20
