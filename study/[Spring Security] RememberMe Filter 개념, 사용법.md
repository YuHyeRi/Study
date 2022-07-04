# [Spring Security] RememberMe Filter 개념, 사용법

### *Remember Me 기능이란?*

**사용자 세션이 만료되고 웹 브라우저가 종료된 후에도 애플리케이션이 사용자의 정보를 기억하는 
기능**이다. 사용자가 로그인을 할 때 Remember Me 기능을 활성화 시킬 경우 *서버에서는 Remember Me 쿠키를 생성*하게 된다. 그 후 로그인을 할 때 애플리케이션에 저장되어 있는 Remember Me 
쿠키를 갖고 *http header에 쿠키를 담아서* request를 보내게 되며 서버는 http header를 확인한 후 
*토큰 기반의 인증을 통해* 유효성 검사를 하고 로그인 승인을 해준다.

- 인증 성공 (Remember Me 쿠키 설정)
- 인증 실패 (쿠키가 존재하면 쿠키 무효화)
- 로그아웃 (쿠키가 존재하면 쿠키 무효화)
<br><br><br>

### *Remeber Me 동작원리*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ca9cee93-df07-4a02-9794-67d30b8734b5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220609%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220609T013327Z&X-Amz-Expires=86400&X-Amz-Signature=c9eb383e95a93382d4d10968981b0c667225fd2e259c2066af5cede03979ccc3&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

1. **RememberMeAuthenticationFilter**는 세션에 SecurityContext가 Null일 때 
(인증 객체가 없는 경우) 또는 사용자의 Request http header가 Remember Me 쿠키가 있는 경우 동작을 하게 된다.
2. **RemembeMeService**는 인터페이스로 **TokenBasedRememberMeServices**와 **PersistentTokenBasedRememberMeServices** 구현체가 있다. 
이 두 구현체가 실제로 Remember Me 인증 처리를 하는 구현체이다.
    - **TokenBasedRememberMeServices**는 메모리에 있는 토큰과 사용자가 Request header에 
    담아서 보낸 토큰을 비교하여 인증을 한다. *(기본적으로 14일만 토큰을 유지함)*
    - **PersistentTokenBasedRememberMeServices**는 DB에 저장된 토큰과 
    사용자가 Request header에 담아 보낸 토큰을 비교하여 인증을 한다.  *(영구적 방법)*
3. Request에서 토큰을 추출한다.
4. 토큰이 존재하는지 확인 후 토큰이 없다면 다음 Filter로 넘어간다.
5. 토큰이 올바른 형태이고 해당 토큰 값과 서버의 값이 일치하며 사용자의 정보가 일치하는지 
확인 후 Authentication을 생성하고 **AuthenticationManager**를 통해 인증처리를 하게 된다.

💡 3~5 과정은 RememberMeServices의 내부에서 일어나는 과정이다.
<br><br><br>

### *Remember Me 기능 사용하기*

http.rememberMe()를 config에 넣어주게 되면 해당 기능이 활성화 된다.
아래 사진은 Remember Me 기능이 활성화 된 Spring Security의 기본 폼 이미지 이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a33209de-f65f-49d1-945c-2ef86eb6a062/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220609%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220609T013339Z&X-Amz-Expires=86400&X-Amz-Signature=e18a3a3897401ae2c6ed9f19aa08ccb218be1bf95fe4c8d45a15eb9dce04ffd8&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

Remember Me의 설정 API는 다음과 같다.

```java
protected void configure(HttpSecurity http) throws Exception {
        http.rememberMe()
                .rememberMeParameter(“remember”)
                .tokenValiditySeconds(3600)
                .alwaysRemember(true)
                .userDetailsService(userDetailsService)
    }
```

- **rememberMeParameter(“remember”)** : Remember Me의 파라미터 명을 설정하는 API로 
디폴트 값은 remember-me 이다.
- **tokenValiditySeconds(3600)** : Remember Me 쿠키 만료 시간을 설정하는 API로 
디폴트 값은 14일이다.
- **alwaysRemember(true)** : Remember Me 기능이 활성화 되지 않아도 항상 실행하도록 설정하는 기능으로 일반적으로 false 이다.
- **userDetailsService(userDetailsService)** : Remember Me 기능을 수행할 때 시스템의 사용자 계정을 조회할 때 처리를 설정하는 API이다.
<br><br>

👉 출처 : [https://velog.io/@seongwon97/Spring-Security-Remember-Me](https://velog.io/@seongwon97/Spring-Security-Remember-Me)<br>
👉 노션 : https://www.notion.so/Spring-Security-RememberMe-Filter-d13b32390f394c41801d971b83946536
