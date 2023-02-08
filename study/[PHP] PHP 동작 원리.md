# [PHP] PHP 동작 원리

**웹 프로그래밍 언어**

웹 시스템 중 서버 측에서 실행되는 서버 사이드 언어를 웹 프로그래밍 언어라고도 부른다. 
이러한 웹 프로그래밍 언어 중 가장 많이 사용되는 언어는 다음과 같다.

1. PHP
2. JSP
3. ASP.NET

예전에는 많은 상업용 사이트가 PHP를 사용하였지만, 보안상의 취약성으로 인해 JSP나 ASP.NET으로 대체되고 있다.
그러나 아직도 소규모나 개인 사이트는 대부분의 사이트가 PHP를 사용하여 제작되고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9656ea5c-06a6-42e1-b0ee-53f87a2527a5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230208%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230208T031858Z&X-Amz-Expires=86400&X-Amz-Signature=844a35edc93b3fc472b826a06f91ac16e71ea0760289c6a928f09cf7e3599177&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<aside>
💡 언어별로 서로 장단점이 다르므로 사용목적이나 상황에 따라 알맞는 언어를 고르는 것이 바람직하다.

</aside>

---

**PHP 동작원리**

PHP는 웹 시스템인 클라이언트 /서버 환경에서 동작하는 서버 사이드 스크립트 언어이다.
다음 그림은 PHP 동작 원리를 간단하게 보여준다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/bd349987-971e-471f-a2e1-57695393f291/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230208%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230208T031846Z&X-Amz-Expires=86400&X-Amz-Signature=c12e77a9d14e98d8bf8a139d555832f3de1ec03c4eefc4d9e877a29937f27ad0&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

① : 클라이언트가 웹 브라우저를 통해 웹 서버에 원하는 웹 페이지를 요청한다.

② : 웹 서버는 클라이언트가 요청한 웹 페이지의 로직 및 데이터베이스와의 연동을 위해 PHP 파서(parser)에 이에 대한 처리를 요청한다.

③ : 이때 PHP 파서는 데이터베이스와의 연동이 필요하면 데이터베이스와 데이터의 처리를 수행한다.

④ : PHP 파서는 웹 페이지의 로직 및 데이터베이스와의 작업 처리 결과를 웹 서버로 전달한다.

⑤ : 웹 서버는 전달받은 데이터로 웹 페이지를 완성하여 웹 브라우저로 응답을 전송한다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-PHP-28159d4da73a4981b2c5e2e7e4da05f1
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_intro_works](http://www.tcpschool.com/php/php_intro_works)
