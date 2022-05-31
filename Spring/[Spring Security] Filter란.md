# [Spring Security] Filter란?

# Filter

### *Servlet Container의 Filter*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b49883a7-92fa-48a3-a3e0-2f00f4f6ea6b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220531%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220531T015844Z&X-Amz-Expires=86400&X-Amz-Signature=84d3a4ec39b37dd74c2b3b5da903bf181ea41b88ca7e8f961e89109a8bd55d71&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- 서블릿 컨테이너의 Filter는 Dispatch Servlet으로 가기 전에 먼저 적용된다.
- Filter들은 여러개가 연결되어 있어 Filter chain이라고도 불린다.
- *모든 Request들은 Filter chain을 거쳐야* Survlet에 도착하게 된다.

### *Security의 Filter*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4372586b-48e2-494d-8f71-f20c59b7e1dc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220531%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220531T015856Z&X-Amz-Expires=86400&X-Amz-Signature=4ba4a6dace77eda750ccf8deeb376e82789282533c96eb154e25cf768e677523&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- Spring Security는 *DelegatingFilterProxy 라는 필터를 만들어* 메인 Filter Chain에 끼워넣고, 
그 아래 다시 SecurityFilterChain 그룹을 등록한다.
- 그렇게 *URL에 따라 적용되는 Filter Chain을 다르게* 하는 방법을 사용한다.
- 어떠한 경우에는 해당 Filter를 무시하고 통과하게 할 수도 있다.
- `WebSecurityConfigurerAdapter`는 Filter chian을 구성하는 Configuration 클래스로 해당 클래스의 상속을 통해 Filter Chain을 구성할 수 있다.
- • `configure(HttpSecurity http)`를 override하며 filter들을 세팅한다.

```java
@EnableWebSecurity(debug = true) // request가 올 떄마다 어떤 filter를 사용하고 있는지 출력을 해준다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 사전에 prePost로 권한체크를 하겠다는 설정!!
public class SecurityConfig extends WebSecurityConfigurerAdapter {
// WebSecurityConfigurerAdapter`는 Filter chian을 구성하는 Configuration클래스

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    // HttpSecurity를 설정하는 것이 Filter들을 Setting하는 것이다.
        http.authorizeRequests((requests) ->
                requests.antMatchers("/").permitAll()
                        .anyRequest().authenticated()
        );
        http.formLogin(login->
                login.defaultSuccessUrl("/", false));
       http.httpBasic();
    }
}
```

### *Security Filter의 종류*

- HeaderWriterFilter : Request의 Http 헤더를 검사하여 header를 추가하거나 빼는 역할
- CorsFilter : 허가된 사이트나 클라이언트의 요청인지 검사하는 역할
- CsrfFilter : post나 put과 같이 리소스를 변경하는 요청의 경우, 내가 보냈던 리소스에서 올라온 요청인지 확인
- LogoutFilter : Request가 로그아웃하겠다고 하는 것인지 체크
- UsernamePasswordAuthenticationFilter : username / password로 로그인을 하려고 하는지 체크하여 승인이 되면 Authentication을 부여하고 이동할 페이지로 이동
- ConcurrentSessionFilter : 동시 접속을 허용할지 체크
- BearerTokenAuthenticationFilter : Authorization 헤더에 Bearer 토큰을 인증해주는 역할
- BasicAuthenticationFilter : Authorization 헤더에 Basic 토큰을 인증해주는 역할
- RequestCacheAwareFilter : Request한 내용이 다음에 필요할 수 있으므로, Cache에 담아주는 역할. 다음 Request가 오면 이전의 Cache 값을 줄 수 있음
- SecurityContextHolderAwareRequestFilter : 보안 관련 Servlet 3 스펙을 지원하기 위한 필터
- RememberMeAuthenticationFilter : 아직 Authentication 인증이 안된 경우, RememberMe 쿠키를 검사하여 인증을 처리해 줌
- AnonymousAuthenticationFilter : 앞선 필터를 통해 인증이 아직도 안되어있으면, 해당 유저는 익명 사용자라고 Authentication을 정해주는 역할 (→ Authentication가 Null인 것을 방지)
- SessionManagementFilter : 서버에서 지정한 세션정책에 맞게 사용자가 사용하고 있는지 검사하는 역할
- ExcpetionTranslationFilter : 해당 필터 이후에 인증이나 권한 예외가 발생하면 해당 필터가 처리
- FilterSecurityInterceptor : 사용자가 요청한 Request에 들어가고 결과를 리턴해도 되는 권한(Authorization)이 있는지 체크. 해당 필터에서 권한이 없다는 결과가 나오면 위의 ExcpetionTranslationFilter 필터에서 Exception을 처리해줌

### *Filter Chain 확인하는 방법*

`WebSecurityConfigurerAdapter`을 상속받아 Filter Chain을 만드는 클래스 위에 `@EnableWebSecurity(debug = true)`어노테이션을 붙여주면 현재 실행되는 Security Filter들을 확인할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7e97935f-833e-4db6-847f-9f132cfa8e6b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220531%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220531T015910Z&X-Amz-Expires=86400&X-Amz-Signature=ab3bf94999dc158c7984a345528ea18424f3e7a65a26873f9e65814338178d85&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

### *Filter Chain이 적용되는 URL 설정하는 방법*

- 해당 Filter를 동작시킬 URL을 설정하려면 `http.antMatcher`를 통해 설정해야한다.
- 모든 Request에 대해 동작하려면 다음과 같이 `http.antMatcher("/**")`로 하며 /api~~에 대해서 적용을 하고 싶다면 `http.antMatcher("/api/**")` 와 같이 해줘야한다.
- 여러 종류의 URL에 대해 여러 Filter를 만들고 싶다면, SecurityConfig 클래스를 여러 개 만들어주어야 하며, *여러개의 SecurityConfig는 순서가 중요하여* 클래스 위에 `@Order`어노테이션을 붙여줘야한다.

```java
@Order(1) // order가 낮은 것부터 먼저 설정을 한다.
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
     	http.antMatcher("/**"); // 해당 filter가 동작할킬 URL을 설정하려면 antMatcher를 통해 설정해야한다.
       
        http.authorizeRequests((requests) ->
                requests.antMatchers("/").permitAll()
                        .anyRequest().authenticated()
        );
        http.formLogin(login->
                login.defaultSuccessUrl("/", false));
       http.httpBasic();
    }
}
```

#### 👉 출처 : [https://velog.io/@seongwon97/Spring-Security-Filter란](https://velog.io/@seongwon97/Spring-Security-Filter%EB%9E%80)
#### 👉 노션 : https://www.notion.so/Spring-Security-Filter-1637742cca8e4e70a1a1029bd2e1a523
