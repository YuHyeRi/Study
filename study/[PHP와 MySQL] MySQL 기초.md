# [PHP와 MySQL] MySQL 기초

**MySQL이란?**

PHP를 사용하면 손쉽게 데이터베이스에 연결하고 그 내용을 관리할 수 있다. 
MySQL은 PHP와 함께 사용되는 가장 대중적인 데이터베이스 시스템이다.

이러한 MySQL의 특징은 다음과 같다.

1. 오픈 소스이므로 무료로 다운받아 사용할 수 있다.
2. 다양한 운영체제에서 사용할 수 있으며 여러가지의 프로그래밍 언어를 지원한다.
3. 크기가 큰 데이터도 아주 빠르고 효과적으로 처리할 수 있다.
4. 널리 알려진 표준 SQL형식을 사용한다.
5. MySQL 응용 프로그램을 사용자의 용도에 맞게 수정할 수 있다.
6. MySQL은 데이터를 테이블에 저장하며 각 테이블은 관련된 데이터를 행과 열의 형태로 
저장한다.

<aside>
💡 SQL(Structured Query Language)이란 데이터베이스에서 자료를 처리할 때 사용하는 구조화된 질의어를 의미한다.

</aside>

MySQL과 같은 데이터베이스는 많은 데이터를 효과적으로 저장하고 관리할 수 있도록 도와준다.

예를 들어 학교(School)라는 데이터베이스에는 다음과 같은 테이블을 만들어 데이터를 관리할 수 
있다.

- 학생(Student)
- 선생님(Teacher)
- 수업(Class)

데이터베이스에 대한 더 자세한 사항은 MySQL 수업에서 확인할 수 있다.

[데이터 베이스 =>](http://www.tcpschool.com/mysql/DB)

MySQL에 대한 더 자세한 사항은 MySQL 수업에서 확인할 수 있다.

[MySQL 수업 확인 =>](http://www.tcpschool.com/mysql/intro)

MySQL을 다운받거나 MySQL 최신 표준에 대한 더 자세한 사항을 알고 싶다면 다음 링크를 참고하면 된다.

[www.mysql.com  =>](http://www.mysql.com/)

---

**쿼리(query)**

PHP에서 쿼리를 사용하여 MySQL과 같은 데이터베이스에 작업을 요청할 수 있다.
쿼리란 데이터베이스에 보내는 요청(request) 또는 질문이라고 이해할 수 있다.

예를 들어 다음과 같은 쿼리는 Student 테이블에서 Name이라는 필드를 모두 선택해줄 것이다.

쿼리에 대한 더 자세한 사항은 MySQL 기본 수업에서 확인할 수 있다.

[MySQL 기본 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_syntax)

<aside>
💡 MySQL에서 각 테이블은 유일한 이름과 자신만의 타입을 가지는 열(column)과 관계된 데이터의 묶음을 나타내는 행(row)으로 구성된다. 열은 필드(field)라고도 부르며 행은 레코드(record)라고도 불린다.

</aside>

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-MySQL-MySQL-de8e144d19c1420d9251d1c7a98953d7?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_mysql_basic](http://www.tcpschool.com/php/php_mysql_basic)
