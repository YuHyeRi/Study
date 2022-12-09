# [**MySQL] 제약조건_DEFAULT**

**DEFAULT**

DEFAULT 제약조건은 해당 필드의 기본값을 설정할 수 있게 해준다.
만약 레코드를 입력할 때 해당 필드 값을 전달하지 않으면, 자동으로 설정된 기본값을 저장한다.

---

**CREATE문으로 DEFAULT 설정**

CREATE문에서 테이블을 생성할 때 다음과 같이 제약 조건을 설정할 수 있다.
CREATE문으로 테이블을 생성할 때 해당 필드의 타입 뒤에 DEFAULT를 명시하면, 
해당 필드의 기본값을 설정할 수 있다.

*문법*

```sql
CREATE TABLE 테이블이름
(
    필드이름 필드타입 DEFAULT 기본값,
    ...
)
```

다음 예제는 CREATE TABLE문을 사용하여 Test 테이블을 생성하면서 Name 필드에 DEFAULT 
제약조건을 이용하여 기본값을 설정하는 예제이다.
이렇게 Name 필드에 기본값을 설정한 후에 DESCRIBE 문을 사용하여 Test 테이블의 상세정보를 확인하면, 다음 실행 결과와 같이 나타난다.

*예제*

```sql
CREATE TABLE Test
(
    ID INT,
    Name VARCHAR(30) DEFAULT 'Anonymous',
    ReserveDate DATE,
    RoomNum INT
);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_default_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_default_01)

그리고서 INSERT INTO문을 사용하여 Name 필드의 값을 가지지지 않는 새로운 레코드를 추가한다.
이처럼 새로운 레코드를 추가할 때 Name 필드 값을 전달하지 않으면, 
자동으로 기본값인 ‘Anonymous’가 저장된다.

---

**ALTER 문으로 DEFAULT 설정**

ALTER 문으로 테이블에 새로운 필드를 추가하거나 수정할 때도 DEFAULT 제약조건을 설정할 수 
있다.
테이블에 새로운 필드를 추가할 때 DEFAULT 제약조건을 설정하는 문법은 다음과 같다.

*문법*

```sql
ALTER TABLE 테이블이름
ADD 필드이름 필드타입 DEFAULT 기본값
```

기존 필드에 DEFAULT 제약조건을 설정하는 문법은 다음과 같다.

*문법*

```sql
1. ALTER TABLE 테이블이름
   MODIFY COLUMN 필드이름 필드타입 DEFAULT 기본값

2. ALTER TABLE 테이블이름
   ALTER 필드이름 SET DEFAULT 기본값
```

위의 두 문법은 모두 해당 필드에 DEFAULT 제약조건을 설정한다.

다음 예제는 ALTER TABLE문을 사용하여 Reservation 테이블의 Name 필드에 DEFAULT 제약 조건을 이용하여 기본값을 설정하는 예제이다.
이렇게 Name 필드에 DEFAULT 제약조건을 설정한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 상세 정보를 확인하면, 다음 실행 결과와 같이 나타난다.

*예제*

```sql
ALTER TABLE Reservation
ALTER Name SET DEFAULT 'Anonymous';
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_default_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_default_02)

그리고서 INSERT INTO문을 사용하여 Name 필드의 값을 가지지 않는 새로운 레코드를 추가한다. 
이처럼 새로운 레코드를 추가할 때 Name 필드 값을 전달하지 않으면, 
자동으로 기본값인 ‘Anonymous’가 저장된다.

다음과 같은 방법을 사용하여 DEFAULT 제약조건을 삭제할 수 있다.

*문법*

```sql
ALTER TABLE 테이블이름
ALTER 필드이름 DROP DEFAULT
```

다음 예제는 Reservation 테이블의 Name 필드에 설정된 DEFAULT 제약 조건을 삭제하는 예제이다.

*예제*

```sql
ALTER TABLE Reservation
ALTER Name DROP DEFAULT;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_default_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_default_03)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-_DEFAULT-9db63a16e9da4030ae6aa60f29aaa600
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_constraint_default](http://www.tcpschool.com/mysql/mysql_constraint_default)
