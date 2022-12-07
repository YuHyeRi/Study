# [**MySQL] 제약조건_PRIMARY KEY**

**PRIMARY KEY**

PRIMARY KEY 제약조건을 설정하면, 해당 필드는 NOT NULL과 UNIQUE 제약조건의 특징을 
모두 가지게 된다.
따라서 이 제약조건이 설정된 필드는 NULL값을 가질 수 없으며, 또한 중복된 값을 가져서도 안된다.
이러한 PRIMARY KEY 제약조건을 기본키라고 한다.

UNIQUE는 한 테이블의 여러 필드에 설정할 수 있지만, PRIMARY KEY는 테이블당 오직 하나의 필드에만 설정할 수 있다.
이러한 PRIMARY KEY 제약조건은 테이블의 데이터를 쉽고 빠르게 찾도록 도와주는 역할을 한다.

---

**CREATE 문으로 PRIMARY KEY 설정**

CREATE문에서 테이블을 생성할 때 다음과 같이 PRIMARY KEY 제약조건을 설정할 수 있다.
CREATE문으로 테이블을 생성할 때 해당 필드의 타입 뒤에 PRIMARY KEY를 명시하면, 
해당 필드가 기본 키로 설정된다.

*문법*

```sql
1. CREATE TABLE 테이블이름
(
    필드이름 필드타입 PRIMARY KEY,
    ...
)

2. CREATE TABLE 테이블이름
(
    필드이름 필드타입,
    ...,
    [CONSTRAINT 제약조건이름] PRIMARY KEY (필드이름)
)
```

위의 두 문법은 모두 해당 필드에 PRIMARY KEY 제약조건을 설정한다.
이 때 두 번째 문법을 사용하면, 해당 제약조건에 이름을 설정할 수 있다.

다음 예제는 CREATE TABLE문을 사용하여 Test 테이블을 생성하면서 ID필드를 기본키로 설정하는 
예제이다.
이렇게 ID필드를 기본키로 설정한 후에 DESCRIBE문을 사용하여 Test테이블의 상세정보를 확인하면, 다음 실행결과와 같이 나타난다.

*예제*

```sql
CREATE TABLE Test 
(
    ID INT PRIMARY KEY,
    Name VARCHAR(30),
    ReserveDate DATE,
    RoomNum INT
);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_primaryKey_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_primaryKey_01)

그리고서 INSERT INTO문을 사용하여 ID필드의 값으로 NULL을 가지는 레코드와 같은 ID 필드 값을 가지는 2개의 레코드를 추가한다.
이 때 새로운 레코드를 추가하는 첫 번째와 세 번째 INSERT INTO문은 에러를 발생시킨다.

---

**ALTER 문으로 PRIMARY KEY 설정**

ALTER문으로 테이블에 새로운 필드를 추가하거나 수정할 때도 PRIMARY KEY 제약조건을 설정할 수 있다.
테이블에 새로운 필드를 추가할 때 해당필드를 기본 키로 설정하는 문법은 다음과 같다.

*문법*

```sql
1. ALTER TABLE 테이블이름
   ADD 필드이름 필드타입 PRIMARY KEY

2. ALTER TABLE 테이블이름
   ADD [CONSTRAINT 제약조건이름] PRIMARY KEY (필드이름)
```

또한, 기존에 존재하는 필드를 기본 키로 설정하는 문법은 다음과 같다.

*문법*

```sql
1. ALTER TABLE 테이블이름
   MODIFY COLUMN 필드이름 필드타입 PRIMARY KEY

2. ALTER TABLE 테이블이름
   MODIFY COLUMN [CONSTRAINT 제약조건이름] PRIMARY KEY (필드이름)
```

<aside>
💡 PRIMARY KEY 제약조건을 추가할 기존 필드는 NULL 값을 갖지 않도록 먼저 선언되어야 
한다.

</aside>

다음 예제는 ALTER TABLE문을 사용하여 Reservation 테이블의 ID 필드에 CustomerID라는 이름을
가지는 PRIMARY KEY 제약 조건을 설정하는 예제이다.
이렇게 ID필드에 PRIMARY KEY 제약조건을 설정한 후에 DESCRIBE 문을 사용하여 Reservation 
테이블의 상세 정보를 확인하면, 다음 실행 결과와 같이 나타난다.

*예제*

```sql
ALTER TABLE Reservation
CONSTRAINT CustomerID ADD PRIMARY KEY (ID);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_primaryKey_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_primaryKey_02)

그리고서 INSERT INTO문을 사용하여 ID필드의 값으로 NULL을 가지는 레코드와 같은 ID필드 값을 
가지는 2개의 레코드를 추가한다.
이 때 새로운 레코드를 추가하는 두 번째와 세 번째 INSERT INTO문은 에러를 발생시킨다.

다음과 같은 방법을 사용하여 설정된 PRIMARY KEY 제약조건을 삭제할 수 있다.

*문법*

```sql
ALTER TABLE 테이블이름
DROP PRIMARY KEY
```

다음 예제는 Reservation 테이블에서 PRIMARY KEY 제약 조건을 삭제하는 예제이다.

*예제*

```sql
ALTER TABLE Reservation
DROP PRIMARY KEY;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_primaryKey_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_primaryKey_03)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-_PRIMARY-KEY-fa322e1a85db41bd9c3bdd1b445fec98
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_constraint_primaryKey](http://www.tcpschool.com/mysql/mysql_constraint_primaryKey)
