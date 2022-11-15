# [**MySQL] 기본 문법**

**MySQL 구문**

MySQL에서 데이터베이스에 대한 작업 명령은 SQL 구문을 이용하여 처리된다.

```sql
SELECT * FROM Reservation;
```

서버와의 연결을 끊는 구문인 QUIT와 같은 경우를 제외한 일반적인 구문 뒤에는 세미콜론(;)을 
붙인다.
이러한 세미콜론은 SQL 구문을 구분하는 기준이 된다.

또한, MySQL은 키워드와 구문에서 대소문자를 구분하지 않는다.

```sql
1. SELECT * FROM Reservation;
2. select * from Reservation;
3. SeLeCt * FrOm Reservation;
```

위의 예제는 모두 같은 결과를 보여주겠지만, 되도록 1번이나 2번처럼 대소문자를 일관되게 
사용하는 것이 좋다.

<aside>
💡 MySQL에서 키워드와 구문, 문자열은 대소문자를 구분하지 않는다. 하지만 테이블 명과 필드의 이름은 대소문자를 구분하므로 주의해서 사용해야 한다.

</aside>

---

**MySQL 주석**

주석이란 코드에 대한 이해를 돕는 설명을 적거나 디버깅을 위해 작성하는 일종의 메모이다. 
MySQL 서버는 주석을 무시하므로 실제 실행 결과에는 아무런 영향을 주지 않는다.

MySQL에서 주석을 작성하는 방법은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e4857ca2-8104-4e00-8593-c829ed12bfbe/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221115%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221115T012553Z&X-Amz-Expires=86400&X-Amz-Signature=922c1b68da00964c833c4a6802a2a23f90dad3f553ebeca1681f21dd817ab21f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

위의 두 번째 방법에서 두 개 이상의 하이픈(-) 뒤에는 반드시 한 칸의 공백이 존재해야만 주석으로 정상 인식된다.

---

**MySQL 주요 구문**

MySQL에서 자주 사용하는 주요 구문에 대해 알아보기 위해 예제를 통해 다음과 같은 테이블을 작성해 볼 것이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/82341c3a-57fd-4eda-84c8-a635980398f7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221115%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221115T012537Z&X-Amz-Expires=86400&X-Amz-Signature=89aca8141a7e27f2ed54bcf993393d9402da5f854447b3ea638d40fabd2e0b9f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

이를 통해 살펴볼 MySQL 주요 구문은 다음과 같다.

1. CREATE DATABASE
2. ALTER DATABASE
3. CREATE TABLE
4. ALTER TABLE
5. DROP TABLE
6. INSERT INTO
7. UPDATE
8. DELETE
9. SELECT
10. CREATE INDEX
11. DROP INDEX

---

**MySQL 코딩 연습**

우리가 수업에서 사용할 코딩 연습에서의 MySQL은 다음과 같이 동작한다.

1. MySQL 코딩 연습은 데이터베이스 정보가 사용자별로 유지되므로, 
쿼리의 결과가 계속 누적된다.
따라서 처음의 데이터베이스 정보로 돌아가기 위해서는 브라우저를 닫고 다시 열어야 한다.
2. MySQL 코딩 연습은 한 번에 한 개의 쿼리만을 처리할 수 있다.
여러 개의 쿼리를 실행해 보려면, 실행하고자 하는 쿼리만을 주석 해지하고 나머지 쿼리는 모두 주석 처리해야 한다.
3. 우리가 앞으로 예제에서 사용할 데이터베이스의 기본 스키마는 다음과 같다.

```sql
CREATE TABLE Reservation(ID INT, Name VARCHAR(30), ReserveDate DATE, RoomNum INT);
CREATE TABLE Customer (ID INT, Name VARCHAR(30), Age INT, Address VARCHAR(20));

INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(1, '홍길동', '2016-01-05', 2014);
INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(2, '임꺽정', '2016-02-12', 918);
INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(3, '장길산', '2016-01-16', 1208);
INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(4, '홍길동', '2016-03-17', 504);

INSERT INTO Customer (ID, Name, Age, Address) VALUES (1, '홍길동', 17, '서울');
INSERT INTO Customer (ID, Name, Age, Address) VALUES (2, '임꺽정', 11, '인천');
INSERT INTO Customer (ID, Name, Age, Address) VALUES (3, '장길산', 13, '서울');
INSERT INTO Customer (ID, Name, Age, Address) VALUES (4, '전우치', 17, '수원');
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-29dcddcc0f07498a827c3854cd8f356e
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_syntax](http://www.tcpschool.com/mysql/mysql_basic_syntax)
