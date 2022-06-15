# [Spring Security] ****CsrfFilter 개념, 사용법****

### ***CSRF란?***

사이트 간 요청 위조인 Cross-Site Request Forgery의 약자로 사용자가 자신의 의지와 무관하게 
공격자가 의도한 행동을 하며 특정 웹 페이지를 보안에 취약하게 한다거나 데이터의 수정, 삭제 등의 동작을 하게 만드는 공격 방법이다.
<br><br>

### *공격방법*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a95265f7-c6ba-41c2-8855-1b7ba0f0b6f4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220615%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220615T023602Z&X-Amz-Expires=86400&X-Amz-Signature=30e28dfb69a95378b68e1a89719ae1b884bf7c8bf46c3b8e19dccfc40f10cdd7&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

1. 악성 스크립트 등을 통해 조작할 내용의 게시글 작성
2. 악성 게시글은 DB에 저장됨
3. 관리자 또는 특정 사용자(희생자)가 공격자가 작성한 게시글을 클릭
4. 악성 게시글은 사용자가 웹 클라이언트를 통해 읽혀지는 동안 클라이언트 언어로 인식되어 동작
    1. 악성 스크립트가 동작하여 특정 사용자의 권한이 필요한 경우 해당 권한을 통해 동작함
5. 희생자에겐 정상적인 게시글로 동작

게시글 외에도 해당 방법으로 CSRF 코드가 포함된 이메일을 통해서도 공격할 수 있다. 
실제로 2008년 옥션 해킹사고도 CSFR 공격이었다.

(출처 : [https://kk-7790.tistory.com/73](https://kk-7790.tistory.com/73))
<br><br>

### *방어 방법*

1. ***Referrer 검증***
    1. request header에 있는 요청을 한 페이지의 정보가 담긴 referrer 속성을 검증하여 차단한다.
    2. 프록시 툴, 패킷 등을 통해 확인하면 다른 페이지로 이동할 경우 그 전 페이지 정보를 가지고 이동한다. 이 때 전 페이지 정보가 없거나 외부 사이트에서 요청을 한 경우 요청을 처리하지 않는 방법이 있다.
    
2. ***CAPTCHA 사용***
    1. 회원정보 변경, 게시글 작성 등 CSRF의 공격을 막아야 하는 페이지에서 캡쳐를 사용하여 
    인증이 가능한 것만 요청을 처리해주는 방법이 있다.
    2. 캡쳐는 랜덤 이미지를 통해 인증이 되므로 사용자 몰래 요청하는 것이 불가능 하다는 장점이 있다.

1. ***CSRF 토큰 사용 (Spring Security에서 지원)***
    1. 특정 권한이 필요한 페이지 (ex. 회원정보수정)는 해당 페이지와 실제 동작이 일어나는 
    페이지 사이에 토큰을 생성하여 그 값을 비교하여 토큰이 존재하지 않거나 다른 경우 동작을 허용하지 않는 방법이 있다.

<br><br>

### *Spring Security의 **CsrfFilter***

스프링 시큐리티는 기본적으로 CSFR Token을 사용하여 CSFR 공격을 막아주는 CsrfFilter를 제공한다. 동작 방법은 다음과 같다.

1. CsrfFilter는 클라이언트로부터 request가 있을 경우 csrf token을 발급한다. 
2. 클라이언트는 PATCH, POST, PUT, DELETE request를 보낼 때 csrk token을 header에 담아 
request를 보낸다.
3. 서버에서는 서버에 저장된 csrf 값과 비교를 하고 값이 같지 않다면 AccessDeniedException을 
발생시키고 값이 같다면 해당 request를 처리해준다.
<br><br>

### ***CsrfFilter 활성화/비활성화***

해당 설정의 디폴트 값은 활성화 되는 것이다.

```java
http.csrf();            // 활성화
http.csrf().disabled(); // 비활성화
```

<br><br>
👉 노션 : https://www.notion.so/Spring-Security-CsrfFilter-b287f2aa3e6048cfa2b41a43f1e0edc8
<br>
👉 출처 : [https://velog.io/@seongwon97/Spring-Security-CsrfFilter-개념-사용법](https://velog.io/@seongwon97/Spring-Security-CsrfFilter-%EA%B0%9C%EB%85%90-%EC%82%AC%EC%9A%A9%EB%B2%95)
