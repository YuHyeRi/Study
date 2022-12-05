# [**MySQL] 제약조건_NOT NULL**

**제약조건(constraint)**

제약조건이란 데이터의 무결성을 지키기 위해 데이터를 입력받을 때 실행되는 검사 규칙을 의미한다. 이러한 제약조건은 CREAT문으로 테이블을 생성할 때나 ALTER문으로 필드를 추가할 때도 설정할 수도 있다.

MySQL에서 사용할 수 있는 제약조건은 다음과 같다.

1. NOT NULL
2. UNIQUE
3. PRIMARY KEY
4. FOREIGN KEY
5. DEFAULT

---

**NOT NULL**

NOT NULL 제약조건을 설정하면 해당 필드는 NULL 값을 저장할 수 없다. 
즉, 이 제약조건이 설정된 필드는 무조건 데이터를 가지고 있어야 한다.

NOT NULL 제약조건은 CREATE문으로 테이블을 생성할 때나, 나중에 ALTER문으로 추가할 수도 있다.

---

**CREATE문으로 NOT NULL 설정**

CREATE문으로 테이블을 생성할 때 해당 필드의 타입 뒤에 NOT NULL을 명시하면 해당 필드는 
NULL값을 가질 수 없다.

*문법*

```sql
CREATE TABLE 테이블이름
(
    필드이름 필드타입 NOT NULL,
    ...
)
```

다음 예제는 CREATE TABLE문을 사용하여 Test 테이블을 생성하면서, ID 필드에 NOT NULL 제약조건을 설정한다.

이렇게 ID필드에 NOT NULL 제약조건을 설정하여 DESCRIBE문을 사용하여 Test테이블의 상세정보를 확인하면, 다음 실행결과와 같이 나타난다.

*예제*

```sql
CREATE TABLE Test
(
    ID INT NOT NULL,
    Name VARCHAR(30),
    ReserveDate DATE,
    RoomNum INT
);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_notNull_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_notNull_01)

그리고서 INSERT INTO문을 사용하여 새로운 레코드를 하나 추가하고 있다.
마지막으로 SELECT문을 사용하여 Test 테이블의 모든 레코드를 선택하여 확인한다.

위의 예제에서는 이제부터 Test 테이블에 INSERT문으로 새로운 레코드를 추가할 때 ID필드의 값으로 NULL을 사용할 수 없다.

NOT NULL 제약조건이란 해당 필드에 NULL값을 저장할 수 없도록 설정하는 것으로, 
해당 필드를 생략하지 못하도록 하는 제약조건은 아니다.

따라서 INSERT문으로 레코드를 저장할 때 NOT NULL 제약조건이 설정된 필드의 값을 생략할 수도 있다.

다음 예제는 ID필드에 NOT NULL 제약조건이 설정된 Test테이블에 ID필드가 생략된 레코드를 저장하는 예제이다.

*예제*

```sql
INSERT INTO Test (Name, ReserveDate, RoomNum)
VALUES('이순신', '2016-02-16', 1108);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_notNull_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_notNull_02)

이처럼 NOT NULL 제약조건이 설정된 필드의 값이 생략된 레코드도 정상적으로 저장되는 것을 확인할 수 있다.

---

**ALTER문으로 NOT NULL 설정**

ALTER문으로 테이블에 새로운 필드를 추가하거나 수정할 때도 NOT NULL 제약조건을 설정할 수 
있다.
테이블에 새로운 필드를 추가할 때 NOT NULL 제약조건을 설정하는 문법은 다음과 같다.

*문법*

```sql
ALTER TABLE 테이블이름
ADD 필드이름 필드타입 NOT NULL
```

기존 필드에 NOT NUL 제약조건을 설정하는 문법은 다음과 같다.

*문법*

```sql
ALTER TABLE 테이블이름
MODIFY COLUMN 필드이름 필드타입 NOT NULL
```

다음 예제는 ALTER TABLE문을 사용하여 Reservation 테이블의 Name 필드에 NOT NULL 제약조건을 설정한다.
이렇게 Name필드에 NOT NULL 제약조건을 설정한 후에 DESCRIBE문을 사용하여 
Reservation 테이블의 상세정보를 확인하면, 다음 실행 결과와 같이 나타난다.

*예제*

```sql
ALTER TABLE Reservation 
MODIFY COLUMN Name VARCHAR(30) NOT NULL;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_notNull_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_notNull_03)

그리고서 INSERT INTO문을 사용하여 새로운 레코드를 하나 추가한다.
마지막으로 SELECT문을 사용하여 Reservation 테이블의 모든 레코드를 선택하여 확인한다.
위의 예제에서는 이제부터 Reservation 테이블에 레코드를 추가할 때 Name 필드의 값으로 NULL을 사용할 수 없다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-_NOT-NULL-544bbd78988d45dc858c16d60a009460
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_constraint_notNull](http://www.tcpschool.com/mysql/mysql_constraint_notNull)
