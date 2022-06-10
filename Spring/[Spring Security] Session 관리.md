# [Spring Security] Session 관리
생성된 계정으로 서버로부터 인증을 받게 되면 서버에 하나의 세션이 생성된다. 
그리고 다른 브라우저 또는 다른 PC에서 같은 계정으로 로그인을 할 경우 이전에 서버에서 만들어진 세션을 같이 공유하는 것이 아닌 새로운 세션을 생성하여 사용하게 된다. 

이번 포스트에서는 이러한 세션의 개수 제한 등의 여러 설정에 대해 알아보고자 한다.
<br><br>
## *1. 동시 세션 관리*

Spring Security에서는 한 개의 계정에 대해 생성되는 세션의 갯수를 설정하고 
세션이 최대 개수가 되었을 때 처리할 방법을 쉽게 설정할 수 있다. 
해당 설정은 1-1에서 설명할 `maximumSessions()`, `maxSessionsPreventsLogin()`를 통해 할 수 있다.
<br>
### *1-1 동시 세션 관리 설정 코드*

```java
protected void configure(HttpSecurity http) throws Exception {     
        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
                .invalidSessionUrl("/invalid")
                .expiredUrl("/expired ");
    }
```

- **maximumSessions(1)** : 최대 허용 가능 세션 수를 설정하는 API이다.
(값으로 -1을 넣으면 무제한으로 세션 생성을 허용하게 된다.)
- **maxSessionsPreventsLogin(true)** : 위에서 설정한 최대 허용 세션의 수가 되었을 때 
추가적인 인증 요청(세션생성)이 있을 경우 어떻게 처리를 할지를 정하는 API이다.
(true이면 현재 사용자 인증 실패, false(디폴트값)이면 기존 세션 만료)
- **invalidSessionUrl(”/invalid”)** : 세션이 유효하지 않을 때 이동할 페이지를 설정하는 API
- **expiredUrl(”/expired”)** : 세션이 만료된 경우 이동할 페이지를 정하는 API

### *🟡 최대 세션의 갯수일 때 처리 방법*

*maximumSessions()의 설정이 1이라 하였을 때를 가정함

1. ***이전의 사용자 세션 만료***
    1. 사용자1이 로그인을 하면 서버에 해당 계정에 대한 세션이 생성된다
    2. 사용자2가 사용자1이 로그인하였던 동일 계정으로 로그인을 시도하게 되면 
    여러 filter 중 SessionManageMentFilter에서 maximumSessions()의 값이 1인 것을 확인한다.
    3. 서버는 새롭게 접근을 시도한 사용자2의 세션을 새로 생성하고 인증을 해주며 
    사용자1의 세션은 session.isExpired() == true 으로 변경하여 세션만료 설정을 해준다.
    4. 사용자1이 다시 request를 요청하면 **ConcurrentSessionFilter**에서 session.isExpired() 값을 
    확인하여 세션 만료 여부를 확인 후 새로운 세션을 만들도록 인증을 요청하게 된다.
    
2. ***새로운 사용자 인증 실패***
    1. 사용자1이 로그인을 하면 서버에 해당 계정에 대한 세션이 생성된다.
    2. 사용자2가 사용자1이 로그인 하였던 동일 계정으로 로그인을 시도하게 되면 여러 filter 중 **SessionManageMentFilter**에서 maximumSessions()의 값이 1인 것을 확인한다.
    3. 서버에서는 사용자2의 세션을 생성하지 않고 인증 예외를 발생시킨다.
    
    - ***ConcurrentSessionFilter*** : 매 요청마다 사용자 세션의 session.isExpired() 여부를 확인하여 
    세션이 만료 되어있을 경우 로그아웃 처리(만료처리)를 해주는 필터이다.
    - ***SessionManageMentFilter*** : 동시적 세션제어, 세션 고정 보호, 세션 생성 정책 등의 
    세션의 전반적인 관리를 해주는 필터이다.
    - 위 두 필터의 세션 만료에 대한 전반적인 동작은 다음과 같다.
    
    <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9375d2dc-d109-4a0b-b270-2a04e5e989bd/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220610%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220610T021316Z&X-Amz-Expires=86400&X-Amz-Signature=2bc9609eb34c43eeb1aca38b72d1fea9bde323fe368d38e4186d31358a48f7c5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
    
    👉 노션 : [https://velog.io/@seongwon97/Spring-Security-세션-관리](https://velog.io/@seongwon97/Spring-Security-%EC%84%B8%EC%85%98-%EA%B4%80%EB%A6%AC)
