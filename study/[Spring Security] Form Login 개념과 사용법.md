# [Spring Security] Form Login 개념과 사용법

## *Form Login 이란?*

Form Login은 Spring Security에서 제공하는 인증 방식이다.

Form Login의 동작 방식은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6a3e2168-d74b-495f-8bfa-d95fe946572a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220605%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220605T053858Z&X-Amz-Expires=86400&X-Amz-Signature=84eb6ef61500e7657231664d12a1daa27a9dd0056ef126047fc7ea6c99447886&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

1. 사용자가 Sever에 특정 URL을 요청하였을 때 해당 URL이 인증이 필요할 경우 Server는 
Login 페이지를 return 하게 된다.
2. 사용자는 username(ID)과 password를 입력하여 로그인 요청을 하면 Post mapping으로 해당 데이터가 서버에 전송된다.
3. Server는 해당 로그인 정보를 확인한다. 해당 유저 정보가 존재한다면 Session과 Token을 
생성하고 저장해둔다.

이러한 과정을 거친 후 사용자가 원래 접속하려던 URL에 접속 요청을 할 경우,
세션에 저장된 인증 토큰으로 접근을 할 수 있게 되며 세션에 인증 토큰이 있는 동안은 해당 사용자가 인증된 사용자라 판단하여 인증을 유지하게 된다.




## *Form Login 사용하기*

Form Login  사용은 앞서 [기본 동작 구조 이해하기](https://www.notion.so/Spring-Security-a839666059d54d9b855c0f9010921c0a)의 ‘사용자 기능 정의하기’ 파트에서 설명한 `configure()` 메서드를 재정의하는 곳에 작성한다.

`http.formLogin()`을 추가하게 된다면 Form 로그인 기능이 작동하게 되며 다음과 같다.

```java
protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
       .loginPage(“/login.html")   			   // 사용자 정의 로그인 페이지
       .defaultSuccessUrl("/home)		       // 로그인 성공 후 이동 페이지
       .failureUrl(＂/login.html?error=true“)	        // 로그인 실패 후 이동 페이지
       .usernameParameter("username")			// 아이디 파라미터명 설정
       .passwordParameter(“password”)			// 패스워드 파라미터명 설정
       .loginProcessingUrl(“/login")			// 로그인 Form Action Url
       .successHandler(loginSuccessHandler())		// 로그인 성공 후 핸들러
       .failureHandler(loginFailureHandler())		// 로그인 실패 후 핸들러
}
```

사용예시

```java
http
        .formLogin()
        .loginPage("/loginPage")
        .defaultSuccessUrl("/")
        .failureUrl("/login")
        .usernameParameter("userId")
        .passwordParameter("passwd")
        .loginProcessingUrl("/login_proc")
        .successHandler(
                new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        System.out.println("authentication : " + authentication.getName());
                        response.sendRedirect("/"); // 인증이 성공한 후에는 root로 이동
                    }
                }
        )
        .failureHandler(
                new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        System.out.println("exception : " + exception.getMessage());
                        response.sendRedirect("/login");
                    }
                }
        )
        .permitAll()
```

- **loginPage("/loginPage")** : 인증이 필요할 때 이동하는 페이지를 설정하는 api. 
해당 api 설정을 하지 않을 경우 기본적으로 Spring Security가 제공하는 템플릿으로 연결된다.
작성한 코드로는 인증이 필요할 때 ‘~/loginPage’ url로 mapping 시켜주게 된다.
- **defaultSuccessUrl("/")** : 인증 **성공 시** default로 이동하는 url을 지정하는 api. 
작성된 코드로는 인증이 성공하였을 때 root 페이지로 mapping 시켜주게 된다.
- **failureUrl("/login")** : 인증이 **실패하였을** 때 이동하는 페이지를 지정하는 api. 
작성된 코드로는 인증이 실패하였을 때, ‘~/login’ url로 mapping 시켜주게 된다.
- **usernameParameter("userId"), passwordParameter("passwd")** : Spring Security에서 기본값인 username, password의 파라미터값을 변경하게 해주는 api
- **loginProcessingUrl("/login_proc")** : 폼 태그의 action url을 설정하는 api. 
default 값은 default login 이다.
- **successHandler()** : 로그인이 성공했을 때, success handler를 호출하는 api. 
파라미터로는 AuthenticationSuccessHandler 인터페이스를 구현한 것을 넣으면 된다. 
작성된 코드로는 인증이 성공하였을 때, 인증 객체에 저장된 사용자의 이름을 출력한 후 
root 페이지로 이동하게 된다.
- **failureHandler()** : 로그인이 실패하였을 때 failure handler를 호출하는 api. 
파라미터로는 AuthenticationFailureHandler 인터페이스를 구현한 것을 넣으면 된다. 
작성된 코드로는 인증이 실패하였을 때, exception 메시지를 출력하고 login 페이지로 
리다이렉트되어 이동하게 된다.
- **permitAll()** : http.authorizeRequests().anyRequest().authenticated(); 와 같이 인가(Authorization) 관련 코드가 있다고 할 때 만약 인증을 받지 않았다면, 어떤 Request들도 접근이 불가능하다. 
그러면 우리가 로그인 페이지로 사용할 loginPage도 인증을 받지 않으면 접근이 불가능한데 permitAll을 붙여주면 해당 경로는 인증을 받지 않아도 누구나 접근이 가능해진다.




## *Form Login 인증 필터 동작 과정*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ad1aa138-35de-4adc-9183-06f5da50be03/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220607%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220607T020147Z&X-Amz-Expires=86400&X-Amz-Signature=6d1fb91dcca3f416ebc5fbeefcc097b9cd429b9d9a3a4a02c9d6958d3cc52ec4&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

1. Form Login을 사용하게 된다면 인증 필터인 *UsernamePasswordAuthenticationFilter*가 실행된다.
2. *AntPathRequestMatcher*는 요청 정보의 url이 해당 값으로 시작되는지 체크하며, 요청 정보가
일치하지 않는다면 2-1인 Filter로 이동한다.
    
    (※ url의 값은 .loginProcessingUrl(”/login”)의 값 변경에 따라 변경된다.)
    
3. 요청 정보가 일치하면 Username과 Password 정보가 담긴 *Authentication* 객체를 생성하여
*AuthenticationManager*에 넘긴다.
4. *AuthenticationManager*는 이전 과정에서 받은 *Authentication* 객체를 *AuthenticationProvider*에 
넘겨주어 인증을 체크하도록 한다.
5. *AuthenticationProvider*는 실질적으로 인증을 체크하는 역할을 한다.
**인증 성공시** 최종적인 Authenticatoin 객체를 생성하여 Authenticatoin 객체를 넘기며,
**인증 실패시** 5-1의 AuthenticationException을 호출하여 UsernamePasswordAuthenticationFilter가 시작된 초기 부분으로 이동하게 된다.
6. *AuthenticationManager*는 *AuthenticationProvider*로부터 받은 *최종 Authentication* 객체를 다음 과정으로 넘겨준다.
7. 최종 Authentication 객체는 *Security Context*에 저장된다.
8. Security Context에 저장된 후에는 *SuccessHandler*를 호출하여 실행하게 된다.

이 후에는 `SecurityContextHolder.getContext().getAuthentication()`코드를 통해 인증 객체를 
꺼내서 쓸 수 있다.

👧🏻 최종 Authentication 객체는 [Authentication의 구조](https://www.notion.so/Spring-Security-Authentication-d94dfe048e784116a4d5dc72a6d66795)에서 Authentication에 들어가는 내용 부분을 통해 확인할 수 있습니다.




#### 👉 출처 : [https://velog.io/@seongwon97/Spring-Security-Form-Login](https://velog.io/@seongwon97/Spring-Security-Form-Login)
#### 👉 노션 : https://www.notion.so/Spring-Security-Form-Login-ae3fee95a94d4feb94e64f27a7cc5dc9
