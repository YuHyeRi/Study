# [Spring Security] Logout Filter 개념, 사용법

## *LogoutFilter*

로그아웃을 하기 위해서는 logout request를 받았을 때, Server의 세션을 무효화하고 쿠키 정보, 인증토큰, 인증토큰이 저장된 Security Context의 객체를 삭제해주어야 한다.
<br><br>
### *LogoutFilter 동작원리*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d1e2c683-b4ec-4eb4-b913-f4c0f3039a8f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220608%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220608T021916Z&X-Amz-Expires=86400&X-Amz-Signature=5925546dcf851f70f23ffb3c13253370505ce6835dde80909b7befd04888c914&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

1. AntPathRequestMatcher를 통해 logout을 처리하는 url이 들어왔는지 확인한다. 
만약 해당 url이 아닐 경우, 다음 Filter로 이동한다.
2. Authentication객체를 Security Context에서 찾고 해당 객체를 SecurityContextLogoutHander로 넘겨준다.
3. 기본적인 LogoutHandler는 4개가 존재하는데 그 중 SecurityContextLogoutHander는 
세션 무효화, 쿠키 삭제, SecurityContextHolder 내용 삭제 등의 작업을 해준다.
4. LogoutFilter의 작업이 끝나면 SimpleUrlLogoutSuccessHander가 동작을 하게 된다.
<br><br>
### *LogoutFilter 사용하기*

Spring Security의 Logout 기능을 사용하기 위해서는 `http.logout()`을 사용한다.

***세부 API***

```java
protected void configure(HttpSecurity http) throws Exception {
        http.logout() // 로그아웃 처리
                .logoutUrl("/logout") // 로그아웃 처리 URL
				        .logoutSuccessUrl("/login") // 로그아웃 성공 후 이동페이지
                .deleteCookies("JSESSIONID", "remember - me") // 로그아웃 후 해당 쿠키 삭제
                .addLogoutHandler(logoutHandler()) // 로그아웃 핸들러
                .logoutSuccessHandler(logoutSuccessHandler()) // 로그아웃 성공 후 핸들러
    }
```

- **logoutUrl("/logout")** : 로그인 처리를 할 url을 입력
(Spring Security에서는 원칙적으로 logout 실행시 post mapping을 함)
- **logoutSuccessUrl("/login")** : 로그아웃 성공 시 이동할 페이지의 경로를 입력
- **deleteCookies("JSESSIONID", "remember - me")** : 로그아웃 할 때서버에서 만든 쿠키를 삭제
하고 싶을 때 사용 (값은 삭제하고 싶은 쿠키명을 입력)
- **addLogoutHandler(logoutHandler())** : 로그아웃을 하였을 때, Spring Security가 기본적으로 
구현한 로그아웃 구현체는 세션을 무효화시키고 인증 토큰을 삭제하는 등의 동작을 한다. 
그 외에 추가적으로 개발자가 구현하고 싶은 내용이 있을 경우, 새로운 logoutHandler를 만들고 해당 API를 통해 사용할 수 있다.
- **logoutSuccessHandler(logoutSuccessHandler())** : 로그아웃 성공 시, logoutSuccessHandler를 호출하는 API. 파라미터로는 logoutSuccessHandler 인터페이스를 구현한 것을 넣는다.


💡 **`logoutSuccessUrl()`과 `logoutSuccessHandler()`의 차이**
- logoutSuccessUrl() : 단순히 로그아웃 성공시 해당 url로 이동하는 것이 전부<br>
- logoutSuccessHandler() : 그 외에 구체적인 여러 내용들을 설정할 수 있음<br>

<br><br>
👉 출처 : [https://velog.io/@seongwon97/Spring-Security-Logout-Filter](https://velog.io/@seongwon97/Spring-Security-Logout-Filter)<br>
👉 노션 : https://www.notion.so/Spring-Security-Logout-Filter-ce55f2a453e7492ebe11a293afb4019a
