# [Spring Security] 인증/인가의 Exception
<br>

## *인증/인가 예외의 큰그림*

Spring Security에서 인증/인가에 대한 예외처리는 ***FilterSecurityFilter***와 ***ExceptionTranslationFilter***가 처리를 하게 된다. 
해당 필터는 AuthenticationException(인증예외)과 AccessDeniedException(인가예외을 처리 한다. 
해당 예외들은 필터들 중 가장 마지막에 위치한 FilterSecurityFilter에서 발견을 하게 되는데 FilterSecurityFilter는 앞에 위치한 
ExceptionTranslationFilter에서 try/catch 로 해당 예외들을 받기 위해 FilterSecurityFilter를 호출하여 사용하게 된다. 
FilterSecurityFilter에서 발생하는 인증/인가 예외는 FilterSecurityFilter를 호출한 ExceptionTranslationFilter에게로 인증/인가 예외를 throw하고 ExceptionTranslationFilter는 throw 받은 인증/인가 예외를 처리하는 일을 한다.

간단히 설명하자면, 
인증/인가의 exception은 *AccessDeniedException, AuthenticationException*. 
이를 *처리하는데 사용되는 필터는 FilterSecurityFilter, ExceptionTranslationFilter*인데 동작은 ExceptionTranslationFilter가 try/catch문을 통해 exception을 발견하는 FilterSecurityFilter를 호출하고 발생한 exception을 처리하게 된다.
<br><br>
## ***AuthenticationException***

AuthenticationException은 인증에 문제가 생길 떄 발생하는 예외이다. 
해당 예외를 처리하는 방법은 다음과 같이 2 step이 있다.
<br>

**step1. AuthenticationEntryPoint 호출하기**

- ***AuthenticationEntryPoint***은 인터페이스로 Spring Security에서 제공하는 AuthenticationEntryPoint 인터페이스를 구현한 구현체를 호출해준다.
- 이를 호출함으로써 로그인페이지로 이동, 401 오류 전달 등의 작업을 해준다.
<br>

**step2. 인증 예외가 발생하기 전의 요청 정보를 저장한다**

- ex) 웹 서핑을 하며 특정 페이지로 이동하려고 했는데 해당 페이지는 인증이 필요하여 이동하려던 페이지가 아닌 로그인 페이지로 이동하게 된 경험을 해보았는가? 
이때 로그인을 하면 초기 페이지가 아닌 이전에 요청하였던 페이지로 이동하게 된다.
- 이렇게 예외가 발생하기 전 원래 이동하고자 하였던 페이지로 요청 정보를 저장하고 로그인 후에 해당 페이지로 이동하게 하기 위해 요청 정보 저장을 한다.
- 요청 정보 저장을 할 떄는 RequestCache와 SavedRequest를 사용한다.
    - ***RequestCache*** : 사용자의 이전 요청 정보를 세션에 저장하고 꺼내오는 일을 함
    - ***SavedRequest*** : 사용자가 요청하였던 요청의 파라미터 값과 헤더 값을 저장함. 
    즉, 요청 정보를 실제로 저장하는 것은 SavedRequest  구현체가 수행하며 이를 세션에 
    저장하는 것은 RequestCache 인터페이스의 구현체가 수행함
- AuthenticationException을 처리할 때는 *authenticationEntryPoint*를 사용하며 
*commence*를 재정의하여 사용하여야 한다.
<br><br>
## *AccessDeniedException*

AccessDeniedException은 권한이 없는 데이터에 접속을 하려고 할 때 발생하는 예외이다. 
이는 AccessDeniedHandler에서 처리를 해준다. 
AccessDeniedHandler를 사용할 때는 handle을 재정의하여 사용해야 한다.
<br><br>
## *AuthenticationException, AccessDeniedException을 적용한 예시 코드*

```java
protected void configure(HttpSecurity http) throws Exception {
      http
          .formLogin()
          .successHandler(
            new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                // 해당 객체에 이전에 요청받은 url정보를 세션에 저장하고 인증이 된다면 해당 url로 이동하게 설정
		                 RequestCache requestCache = new HttpSessionRequestCache();
                     SavedRequest savedRequest = requestCache.getRequest(request, response);
                     String redirectUrl = savedRequest.getRedirectUrl();
                     response.sendRedirect(redirectUrl);
                  }
             }
          );
        http
            .exceptionHandling()
            .authenticationEntryPoint(new AuthenticationEntryPoint() {
                @Override
                  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                     response.sendRedirect("/login");
                 }
             })
             .accessDeniedHandler(new AccessDeniedHandler() {
                 @Override
                 public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                     response.sendRedirect("/denied");
                 }
             });
  }
```
<br>
👉 노션 : https://www.notion.so/Spring-Security-Exception-59bcea556b1149188dd329e274a04b88
<br>
👉 출처 : [https://velog.io/@seongwon97/Spring-Security-인증인가의-Exception](https://velog.io/@seongwon97/Spring-Security-%EC%9D%B8%EC%A6%9D%EC%9D%B8%EA%B0%80%EC%9D%98-Exception)
