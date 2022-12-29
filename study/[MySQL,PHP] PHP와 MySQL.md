# [MySQL,PHP] **PHP와 MySQL**

**PHP와 MySQL**

MySQL은 C언어, C++, JAVA, PHP 등 다양한 프로그래밍 언어와 결합하여 사용할 수 있다.
이 중에서도 MySQL을 이용한 웹 개발에는 PHP가 가장 많이 사용되고 있다.

PH는 MySQL을 조작하기 위한 많은 함수를 별도로 제공하고 있다.
이러한 함수를 사용하면 PHP 스크립트 상에서 MySQL과 관련된 거의 모든 작업을 수행할 수 있다.

[PHP 수업부터 배우고 오기 =>](http://www.tcpschool.com/php/intro)

---

**MySQLi과 PDO**

예전에는 PHP에서 MySQL 데이터베이스에 연결하기 위해 MySQL extension이라는 API를 사용했다.
MySQL extension은 mysql_로 시작하는 다양한 함수를 사용하여 MySQL 데이터베이스를 관리할 수 있었다.

하지만 이 API는 PHP 5.5.0부터는 사용을 권장하지 않고(deprecated) 있으며, PHP 7.0.0에서는 삭제되었다.

따라서 현재 PHP를 사용하여 MySQL 데이터베이스에 연결하기 위해 사용할 수 있는 API는 다음과 
같다.

1. MySQL improved extension(MySQLi extension)
2. PHP Data Objects(PDO)

위의 두 가지 API는 각각 장단점을 가지지만 MySQL 환경에서 성능상의 큰 차이를 보이지는 않는다.
그러나 MySQLi는 객체 기반 형식과 절차식 형식으로 모두 사용하라 수 있다.

MySQLi를 다운 받거나 MySQLi에 대한 더 자세한 사항을 알고 싶다면 다음 링크를 참고하면 된다.

[PHP.net : MySQLi =>](http://php.net/manual/kr/book.mysqli.php)

우리 MySQL 수업에서는 MySQLi의 절차적 형식을 사용한 예제들을 살펴볼 것이다.
만약 PDO를 사용한 PHP 예제를 살펴보고 싶다면 PHP와 MySQL 수업에서 확인할 수 있다.

[PHP와 MySQL 수업 확인 =>](http://www.tcpschool.com/php/php_mysql_connection)

---

**PHP와 MySQL의 동작 원리**

PHP와 연동되어 사용되는 MySQL의 동작 원리는 다음 그림과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/aed55671-5dba-4b80-89ad-7ada477bdd64/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221229%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221229T023117Z&X-Amz-Expires=86400&X-Amz-Signature=7c0523a3c9cf1a96f1d1967acb96ef6775327f290b02aa326e9b79a8b2411508&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

1. 클라이언트가 브라우저를 통해 웹 서버에 원하는 웹 페이지를 요청한다.
2. 웹 서버는 클라이언트가 요청한 웹 페이지의 내용 작성 및 데이터베이스와의 연동을 위해 
PHP 파서에 이것에 대한 처리를 요청한다.
3. 이 때 PHP 파서는 데이터베이스와의 연동이 필요하면 데이터베이스에 접속해서 SQL문을 확인하고 데이터베이스와 데이터의 처리를 수행한다.
4. PHP 파서는 웹 페이지의 내용 작성 및 데이터베이스의 작업 처리 결과를 웹 서버로 전달한다.
5. 웹 서버는 완성된 웹 페이지를 클라이언트의 브라우저로 전송한다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-PHP-PHP-MySQL-079ddd359b1d4a63bb7e9c3a424c1134
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_php_intro](http://www.tcpschool.com/mysql/mysql_php_intro)
