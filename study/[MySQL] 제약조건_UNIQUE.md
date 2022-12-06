# [**MySQL] 제약조건_UNIQUE**

**UNIQUE**

UNIQUE 제약조건을 설정하면 해당 필드는 서로 다른 값을 가져야 한다.
즉, 이 제약조건이 설정된 필드는 중복된 값을 저장할 수 없다.
UNIQUE 제약조건은 CREATE문으로 테이블을 생성할 때나, 나중에 ALTER문으로 추가할 수도 있다.

---

**CREATE문으로 UNIQUE 설정**

CREATE문에서 테이블을 생성할 때 다음과 같이 UNIQUE 제약조건을 설정할 수 있다.
CREATE문으로 테이블을 생성할 때 해당 필드의 타입 뒤에 UNIQUE를 명시하면, 
해당 필드에는 더는 중복된 값을 저장할 수 없다.

*문법*

```sql
1. CREATE TABLE 테이블이름
(
    필드명 필드타입 UNIQUE,
    ...
)

2. CREATE TABLE 테이블이름
(
    필드이름 필드타입,
    ...,
    [CONSTRAINT 제약조건이름] UNIQUE (필드이름)
)
```

위의 두 문법은 모두 해당 필드에 UNIQUE 제약조건을 설정한다.
이 때 두 번째 문법을 사용하면, 해당 제약 조건에 이름을 설정할 수 있다.

다음 예제는 CREATE TABLE문을 사용하면 Test 테이블을 생성하면서 ID필드에 UNIQUE 제약조건을 설정하는 예제이다.
이렇게 ID 필드에 UNIQUE 제약조건을 설정한 후에 DESCRIBE문을 사용하여 Test 테이블의 상세정보를 확인하면, 다음 실행결과와 같이 나타난다.

*예제*

```sql
CREATE TABLE Test 
(
    ID INT UNIQUE,
    Name VARCHAR(30),
    ReserveDate DATE,
    RoomNum INT
);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_unique_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_unique_01)

그리고서 INSERT INTO문을 사용하여 ID필드의 값이 1로 같은 2개의 레코드를 추가한다.
마지막으로 SELECT문을 사용하여 Test테이블의 모든 레코드를 선택하여 확인한다.
위의 예제에서는 이제부터 Test테이블에 새로운 레코드를 저장할 때 ID 필드의 값이 기존에 저장된 ID값과 중복되는 값을 가지는 레코드를 저장할 수 없다.

---

**ALTER문으로 UNIQUE 설정**

ALTER문으로 테이블에 새로운 필드를 추가하거나 수정할 때도 UNIQUE 제약조건을 설정할 수 있다.
테이블에 새로운 필드를 추가할 때 UNIQUE 제약조건을 설정하는 문법은 다음과 같다.

*문법*

```sql
1. ALTER TABLE 테이블이름
   ADD 필드이름 필드타입 UNIQUE

2. ALTER TABLE 테이블이름
   ADD [CONSTRAINT 제약조건이름] UNIQUE (필드이름)
```

기존 필드에 UNIQUE 제약조건을 설정하는 문법은 다음과 같다.

*문법*

```sql
1. ALTER TABLE 테이블이름
   MODIFY COLUMN 필드이름 필드타입 UNIQUE

2. ALTER TABLE 테이블이름
   MODIFY COLUMN [CONSTRAINT 제약조건이름] UNIQUE (필드이름)
```

위의 두 문법은 모두 해당 필드에 UNIQUE 제약조건을 설정한다.
이 때 두 번째 문법을 사용하면, 해당 제약조건에 이름을 설정할 수 있다.

다음 예제는 ALTER TABLE문을 사용하여 Reservation 테이블의 RoomNum 필드에 reservedRoom
이라는 이름을 가지는 UNIQUE 제약 조건을 설정한다.
이렇게 RoomNum 필드에 UNIQUE 제약조건을 설정한 후에 DESCRIBE 문을 사용하여 Reservation 
테이블의 상세 정보를 확인하면, 다음 실행 결과와 같이 나타난다.

*예제*

```sql
ALTER TABLE Reservation
ADD CONSTRAINT reservedRoom UNIQUE (RoomNum);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_unique_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_unique_02)

그리고서 INSERT INTO문을 사용하여 RoomNum 필드의 값이 818로 같은 2개의 레코드를 추가한다.
마지막으로 SELECT문을 사용하여 Reservation 테이블의 모든 레코드를 선택하여 확인한다.
위의 예제에서는 이제부터 Reservation 테이블에 INSERT 문으로 레코드를 저장할 때 RoomNum 
필드의 값이 기존에 저장된 RoomNum 값과 중복되면 안 된다.
제약조건에 이름을 설정하면, 다음과 같이 이름을 사용하여 해당 제약조건을 삭제할 수 있다.

*문법*

```sql
ALTER TABLE 테이블이름
DROP INDEX 제약조건이름
```

UNIQUE 제약조건을 설정하면, 해당 필드는 자동으로 인덱스(INDEX)로 만들어진다.

인덱스에 대한 더 자세한 사항은 아래 수업에서 확인할 수 있다.
[MySQL INDEX 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_index_create)

다음 예제는 reservedRoom이라는 UNIQUE 제약 조건의 이름을 사용하여, 
해당 제약 조건을 삭제하는 예제이다.

*예제*

```sql
ALTER TABLE Reservation
DROP INDEX reservedRoom;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_unique_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_constraint_unique_03)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-_UNIQUE-ce59467256294b64bb808b5d6dc24ca8
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_constraint_unique](http://www.tcpschool.com/mysql/mysql_constraint_unique)
