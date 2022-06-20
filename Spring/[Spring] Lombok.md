# Lombok

## *Lombok이란?*

자바 클래스를 만들 때 자주 사용되는 getter/setter나 toString 등의 코드를 어노테이션으로 
대체하여 선언하고 자바 코드를 컴파일할 때 그에 맞는 코드를 생성해준다.

- Lombok을 사용하면 코드의 길이를 줄여 코드를 단순화하고 코드의 가독성을 키울 수 있다.
- 코드 자동 생성을 통해 생산성이 향상된다.
- 반복되는 코드의 다이어트를 통한 가독성 유지 및 유지보수성을 향상시킨다.

---

## *Lombok 사용 설정*

### *🟡 ****Eclipse*****

- 롬복 설치
1. 플러그인 설치 → [https://projectlombok.org/download](https://projectlombok.org/download)
2. 명령 프롬프트를 실행하고 lombok.jar가 다운로드 된 곳으로 이동하여 아래와 같이 java로 lombok.jar를 실행한다.
    - 롬복 파일이 E드라이브의 Project에 있을 경우
    
    <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9ee1cc85-8197-4947-b1ef-c71acbde6975/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000504Z&X-Amz-Expires=86400&X-Amz-Signature=0fb711c5a48d0dc6d843bd4a76046bb01425ce1a520323ab7c592afc992a16bc&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
    

3. java -jar로 롬복을 실행하면 이클립스나 스프링부트를 위한 STS(Spring Tool Suite)와 같은 IDE를 찾게 된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/989e0bb7-d174-44d1-8256-eb9d203de2ef/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000516Z&X-Amz-Expires=86400&X-Amz-Signature=86a04a7e602773585d7f8c438d1aba6dbc1d6ea928483f6d8f02468aab04e78e&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

4. 인스톨러가 떴으면 Specify location… 이라고 적혀 있는 버튼을 클릭하여 이클립스 계열 경로를 지정한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/66fd7d23-e2d6-4c88-9846-33c4a37f4e47/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000528Z&X-Amz-Expires=86400&X-Amz-Signature=0f19072cf004414acb48c23f2c65edc54a21052944390e6c5af0e3f90b865cc8&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

5. 위와 같이 경로를 지정하였으면 Install 버튼을 클릭하여 진행한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/478c1eab-2b96-45e2-8de9-3efaf033cad7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000541Z&X-Amz-Expires=86400&X-Amz-Signature=462c7d48ef2863d165236483a44dfd297cd6639b859e8fcc00f3a1190ff9a8e2&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

6. 설치가 완료 되면 Quit Installer를 클릭하여 인스톨 화면을 종료한 후 IDE를 재실행한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/83e3c0c2-5e7e-4fac-83d1-1468e1accca7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000558Z&X-Amz-Expires=86400&X-Amz-Signature=7c3d26ef94205171e281303a217872309c3bf1b6ff9398e6c8e990b3aa1bae55&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- 스프링부트에서 롬복 설정
1. Gradle 의존성 추가

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6c51b3fe-a0c7-45a7-9b28-ca0335f86f03/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000611Z&X-Amz-Expires=86400&X-Amz-Signature=033b092c56b68a1d0a9e72354d0f64f6bededc0c277fc65a45ec599e9ca69792&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

2. 롬복을 지정하고 스프링부트를 프로젝트를 생성하였다면 build.gradle 에 다음과 같이 롬복이 생성된 것을 확인할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/bf1698c7-f00e-415b-bd66-c62e384ea697/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000625Z&X-Amz-Expires=86400&X-Amz-Signature=702ff559e5aafa835c9a8c4f977328adc579a00abca6222baa9f9662843145ba&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0f1294af-7193-4324-a1e4-87ddce05782c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000656Z&X-Amz-Expires=86400&X-Amz-Signature=45f4d7d339125ab54ef940e47dfef3d324ff58f29612336cde1d38552742cba0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

### *🟡 IntelliJ*

프로젝트 생성시에 아래 사진과 같이 Developer Tools에 위치한 Lombok을 선택하여 프로젝트를 생성해준다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8d3aade2-7bf1-46f0-a3e3-686e2824dfc6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T000706Z&X-Amz-Expires=86400&X-Amz-Signature=59f1a45a05927fdeccc0f2a875c851907198b6b9e2713abb919f7e6ca892cbdc&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

만약 프로젝트 생성시에 추가를 못하였다면 **build.gradle**의 dependencies에 아래의 코드를 추가한 후 dependency update를 해준다.

```java
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'
```

---

### ***Lombok사용 예제***

***@Getter, @Setter***

```java
public class User {
    private String name;
    private String email;
    private LocalDateTime createdAt; // 생성된 시간
    private LocalDateTime updatedAt; // 업데이트된 시간

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
```

Lombok을 사용하지 않는다면 우리는 User class에서 getter, setter 메서드를 구현하기 위해 
위와 같이 변수를 하나씩 선언해주어야 한다. User class에서 변수가 4개라도 getter, setter를 만드는데만 8개의 메서드가 만들어졌으니 실제 DTO를 생성하다보면 훨씬 더 많은 변수들을 만들게 될 것이고 그에 따라 선언하는 메서드의 수도 크게 늘어날 것이다.

이러한 코드들은 Lombok의 @Getter, @Setter 어노테이션을 사용하면 코드를 단순화 시킬 수 있다.

```java
@Getter
public class User {
    
@Setter
private String name;
private String email;
private LocalDateTime createdAt; // 생성된 시간
private LocalDateTime updatedAt; // 업데이트된 시간
}
```

@Getter, @Setter는 전체 클래스에 할 수도 있으며 특정 변수에만 지정할 수도 있다. 특정 변수에 
대해서만 지정할 경우 위의 name에 위치한 @Setter처럼 변수위에 지정하면 된다.

***@ToString***

```java
public class User {
    private String name;
    private String email;
    private LocalDateTime createdAt; // 생성된 시간
    private LocalDateTime updatedAt; // 업데이트된 시간

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
```

ToString의 경우도 Overriding을 하며 새로 지정해야 하는 번거로움이 있었으나 Lombok을 사용하면 아래와 같이 @ToString 어노테이션을 붙임으로서 단순화시킬 수 있다. 
@ToString(exclude = "regionMoneyName")와 같이 특정 변수를 제외시킬 수도 있다.

```java
@ToString
public class User {
    private String name;
    private String email;
    private LocalDateTime createdAt; // 생성된 시간
    private LocalDateTime updatedAt; // 업데이트된 시간

}
```

***@NoArgsConstructor***

파라미터 없이 생성되는 기본 생성자를 생성해주는 어노테이션

```java
@NoArgsConstructor
public class User {
    private String name;
    private String email;
    private LocalDateTime createdAt; // 생성된 시간
    private LocalDateTime updatedAt; // 업데이트된 시간

    // public User() { }  해당 코드가 생략된다.
}

User user = new User();
```

***@AllArgsConstructor***

@NoArgsConstructor가 아무런 변수를 받지 않는 생성자를 만들어주는 어노테이션이었다면,
@AllArgsConstructor는 객체가 가지고 있는 모든 변수를 받는 생성자를 만들어준다.

```java
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private LocalDateTime createdAt; // 생성된 시간
    private LocalDateTime updatedAt; // 업데이트된 시간

//    아래의 constructor를 @AllArgsConstructor이 대신 만들어준다.
//    public User(String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
//        this.name = name;
//        this.email = email;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }
}
```

추가중

<br>
👉 노션 : https://www.notion.so/Lombok-e4e1e338706649a0b22475484480e375
<br>
👉 출처 : [https://needjarvis.tistory.com/696](https://needjarvis.tistory.com/696)
<br>
👉 출처 : [https://velog.io/@seongwon97/Spring-Boot-Lombok](https://velog.io/@seongwon97/Spring-Boot-Lombok)
