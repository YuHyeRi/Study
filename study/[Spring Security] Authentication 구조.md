# [Spring Security] ****Authentication 구조****

### ***Authentication의 구조***

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/562012de-50ff-4b47-8fb1-3c4c0ef164c4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220531%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220531T223840Z&X-Amz-Expires=86400&X-Amz-Signature=c7540c13a9a5bd258861249da5300601998a89d9d44406a69d9b0ac6a0579ddf&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- Spring에서 로그인을 한다는 것은 SecurityContext authenticated가 true인 Authentication 객체를 갖고 있는 상태를 말한다.
(이때, Authentication은 AnonymousAuthenticationToken이 아니어야 한다.)
- `SecurityContextHolder`는 인증을 보관하는 보관소이며 `Authentication`을 갖고 있는 `SecurityContext`를 보관한다.
- `AuthenticationProvider`은 Authentication을 제공하며 이는 여러개가 존재할 수 있다.
- `AuthenticationProvider`를 관리하는 interface를 `AuthenticationManager`라고 하며 `ProviderManager`는 AuthenticationManager를 구현한다
- Authentication은 권한의 정보와 인증 대상에 대한 Principal(접근주체), Credential(비밀번호)의 정보를 갖는 인터페이스다.

*🟡 **Authentication에 들어가는 내용***

**Set <GrantedAuthority> authorities** : 인증된 권한 정보 목록

**principal** : 인증 대상에 관한 정보로 사용자의 아이디 혹은 User 객체가 저장

**credentials** : 인증확인을 위한 정보로 주로 비밀번호 (※ 인증후에는 보안을 위해 삭제)

**details** : 그 밖에 필요한 정보로 IP, 세션정보, 기타 인증요청에서 사용했던 정보들

**boolean authenticated** : 인증이 되었는지를 체크

### ***Authentication을 제공하는 필터***

- UsernamePasswordAuthenticationFilter : 폼 로그인을 처리
- OAuth2LoginAuthenticationFilter : 소셜 로그인을 처리
- RememberMeAuthenticationFilter : remember-me 쿠키 로그인을 처리
- AnonymousAuthenticationFilter : 로그인하지 않았다는 것을 인증
- SecurityContextPersistenceFilter : 기존 로그인 유지 (기본적으로 session을 이용함)
- BearerTokenAuthenticationFilter : JWT 로그인을 처리해줌
- BasicAuthenticationFilter : AJAX 로그인 (session이 있는 경우에 사용)
- OpenIDAuthenticationFilter : OpenID 로그인을 처리해줌

#### 👉 출처 : [https://velog.io/@seongwon97/Spring-Boot-Authentication의-구조](https://velog.io/@seongwon97/Spring-Boot-Authentication%EC%9D%98-%EA%B5%AC%EC%A1%B0)
#### 👉 노션 : https://www.notion.so/Spring-Security-Authentication-d94dfe048e784116a4d5dc72a6d66795
