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

#### 👉 출처 : [https://velog.io/@seongwon97/Spring-Security-Form-Login](https://velog.io/@seongwon97/Spring-Security-Form-Login)
#### 👉 노션 : https://www.notion.so/Spring-Security-Form-Login-ae3fee95a94d4feb94e64f27a7cc5dc9
