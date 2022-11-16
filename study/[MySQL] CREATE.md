# [**MySQL] CREATE**

**CREATE**

MySQL에서는 다음과 같은 CREATE 문을 사용하여 데이터베이스와 테이블을 만들 수 있다.

1. CREATE DATABASE
2. CREATE TABLE

---

**데이터베이스 생성**

CREATE DATABASE 문은 새로운 데이터베이스를 생성해준다.

```sql
CREATE DATABASE 데이터베이스이름
```

다음 예제는 Hotel이라는 새로운 데이터베이스를 생성하는 예제이다.

```sql
CREATE DATABASE Hotel;
```

<aside>
💡 생성된 데이터베이스 목록은 SHOW DATABASES 구문을 통해 확인할 수 있다.

</aside>

---

**데이터베이스의 선택**

데이터베이스를 생성한 후에 해당 데이터베이스를 사용하기 위해서는 
우선 데이터베이스를 선택해야 한다.

MySQL에서는 USE문을 사용하여 데이터베이스를 선택할 수 있다.

```sql
USE 데이터베이스이름
```

다음 예제는 Hotel 데이터베이스를 선택하는 예제이다.

```sql
USE Hotel;
```

<aside>
💡 유닉스 환경의 MySQL에서는 데이터베이스 이름의 대소문자를 구분한다. 그러나 윈도우 환경의 MySQL에서는 데이터베이스의 이름에 대소문자를 구분하지 않는다. 하지만 될 수 있으면 언제나 데이터베이스의 이름은 대소문자를 구분하여 사용하는 것이 가독성 측면에서 좋다.

</aside>

---

**테이블 생성**

데이터베이스는 하나 이상의 테이블로 구성되며, 
이러한 테이블에 데이터를 저장하여 관리할 수 있다.

CREATE TABLE문은 새로운 테이블을 생성해 준다.

```sql
CREATE TABLE 테이블이름
(
	필드이름1 필드타입1,
	필드이름2 필드타입2
)
```

테이블을 생성하기 위해서는 테이블 이름, 필드 목록과 각 필드의 타입을 명시해야 한다. 
필드의 타입이란 해당 필드에 저장될 데이터가 가질 수 있는 타입을 의미한다.

<aside>
💡 MySQL에서는 위의 문법처럼 하나의 쿼리를 여러 줄에 걸쳐 입력할 수 있다.

</aside>

데이터베이스에서 사용되는 타입에 대한 더 자세한 사항은 MySQL 타입 수업에서 확인할 수 있다.

[MySQL 타입 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_datatype_numeric)

다음 예제는 4개의 필드를 갖는 Test 테이블을 생성하는 예제이다.

```sql
CREATE TABLE Test
(
	ID INT,
	Name VARCHAR(30),
	ReserveDate DATE,
  RoomNum INT
);
```

<aside>
💡 MySQL 코딩 연습에서는 한번에 단 하나의 쿼리만을 실행해 볼 수 있다. 따라서 예제가 수행된 결과를 확인하고 싶다면, 예제 내의 주석 처리된 부분을 차례대로 해제하고 다시 실행하면 된다.

</aside>

<aside>
💡 생성된 테이블 목록은 SHOW TABLES 구문을 통해 확인할 수 있다. 또한 해당 테이블의 상세 정보는 DESCRIBE 구문이나 DESC 구문을 통해 확인할 수 있다.

</aside>

---

**제약조건(constraint)**

데이터의 무결성을 지키기 위해 데이터를 입력받을 때 실행되는 검사 규칙을 의미한다. 
이러한 제약 조건은 CREATE 문으로 테이블을 생성할 때나, 
ALTER문으로 필드를 추가할 때도 설정할 수도 있다.

CREATE TABLE 문에서 사용할 수 있는 제약 조건은 다음과 같다.

1. NOT NULL : 해당 필드는 NULL 값을 저장할 수 없게 된다.
2. UNIQUE : 해당 필드는 서로 다른 값을 가져야만 한다.
3. PRIMARY KEY : 해당 필드는 NOT NULL과 UNIQUE 제약 조건의 특징을 모두 가지게 된다.
4. FOREIGN KEY : 하나의 테이블을 다른 테이블에 의존하게 만든다.
5. DEFAULT : 해당 필드의 기본값을 설정한다.

또한, AUTO_INCREMENT 키워드를 사용하면 해당 필드의 값을 1부터 시작하여 새로운 레코드가 
추가될 때마다 1씩 증가된 값을 저장한다.
이 때, AUTO_INCREMENT 키워드 다음에 대입 연산자(=)를 사용하여 시작값을 변경할 수 있다.

제약 조건에 대한 더 자세한 사항은 MySQL 제약 조건 수업에서 확인할 수 있다.

[MySQL 제약 조건 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_constraint_notNull)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-CREATE-255bdfc61b0345a88ed95b17f99473bb
<br>
 👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_create](http://www.tcpschool.com/mysql/mysql_basic_create)
