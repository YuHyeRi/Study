# [PHP] PHP 개요

**웹 시스템(web system)**

우리가 매일 사용하고 있는 인터넷을 구성하는 시스템을 웹 시스템이라고 한다. 
이러한 웹 시스템은 다음 그림과 같이 클라이언트와 서버로 구성된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/95795ab9-79c5-49d7-bd85-d003e6c044f8/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230206%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230206T092014Z&X-Amz-Expires=86400&X-Amz-Signature=2c949ac594e6b00681312931e4bb665afc368e59f54101b8526b9a3b073dbb2f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

서버란 간단히 말해 웹 서비를 제공하는 컴퓨터를 의미한다.
클라이언트란 서버가 제공하는 웹 서비스를 이용하는 사용자 또는 사용자의 기기(브라우저)를 
의미한다.

---

**클라이언트 사이드와 서버 사이드**

웹 시스템에서의 처리는 클라이언트와 서버 중 어느 쪽에서 수행되는 작업인가에 따라 다음과 같이 구분할 수 있다.

1. 클라이언트 사이드
2. 서버 사이드

클라이언트 사이드란 클라이언트 측에서 수행하는 처리를 의미한다.
웹 시스템에서 브라우저는 서버에서 수신한 HTML 문서를 해석하여 여러분의 화면에 표시해준다.
이러한 클라이언트 사이드에서 자주 사용하는 스크립트 언어에는 자바스크립트가 있다.

서버 사이드란 서버 측에서 수행하는 처리를 의미한다.
브라우저에서 요청한 HTML 문서에 서버 사이드 스크립트 언어의 코드가 포함되어 있으면, 
서버는 이 부분을 처리하고 그 결과를 브라우저에 보내준다.
이러한 서버 사이드에서 자주 사용하는 스크립트 언어가 PHP이다.

<aside>
💡 이처럼 서버에 미리 저장된 파일이 아닌 서버에 있는 데이터들을 서버 사이드 스크립트 언어로 가공하여 생성되는 페이지를 동적 웹 페이지라고 한다.

</aside>

---

**PHP(PHP: Hypertext Preprocessor)**

PHP는 C언어를 기반으로 만들어진 서버 측에서 실행되는 서버 사이드 스크립트 언어이다.

PHP로 작성된 코드를 HTML 코드 안에 추가하면, 웹 서버는 해당 코드를 해석하여 자동으로 HTML 문서를 생성한다.
따라서 PHP를 사용하면 동적으로 빠르게 HTML 문서를 만들 수 있다.

[PHP 수업 시작 =>](http://www.tcpschool.com/php/php_intro_intro)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-PHP-0042235f3919409cb8f261020f63bd07
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/intro](http://www.tcpschool.com/php/intro)
