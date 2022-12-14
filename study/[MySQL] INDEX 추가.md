# [**MySQL] INDEX 추가**

**인덱스 추가**

ALTER문을 사용하여 테이블에 인덱스를 추가할 수 있다.
MySQL에서 추가할 수 있는 인덱스의 타입은 다음과 같다.

1. 기본 인덱스
2. UNIQUE INDEX
3. FULLTEXT INDEX

---

**기본 인덱스 추가**

기본 인덱스에서 필드의 값은 같은 값이 여러 번 저장될 수 있으며, NULL 값을 가질 수도 있다.

*문법*

```sql
ALTER TABLE 테이블명
ADD INDEX 인덱스명 (필드명)
```

다음 예제는 Reservation 테이블의 Name 필드에 기본 인덱스를 추가하는 예제이다.

```sql
ALTER TABLE Reservation
ADD INDEX NameIdx (Name);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_add_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_add_01)

---

**UNIQUE INDEX 추가**

UNIQUE INDEX에서 필드의 값은 중복될 수 없으나, NULL 값을 가질 수는 있다.

*문법ㄴ*

```sql
ALTER TABLE 테이블명
ADD UNIQUE 인덱스명 (필드명)
```

다음 예제는 Reservation 테이블의 ID 필드에 UNIQUE INDEX를 추가하는 예제이다.

```sql
ALTER TABLE Reservation
ADD UNIQUE IdIdx (ID);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_add_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_add_02)

---

**FULLTEXT INDEX 추가하기**

FULLTEXT INDEX는 일반적인 인덱스와는 달리 매우 빠르게 테이블의 모든 테스트 필드를 검색한다.
이 인덱스는 검색 엔진과 유사한 방법으로 자연어를 이용하여 데이터를 검색할 수 있도록 
모든 데이터의 문자열 단어를 저장한다.

*문법*

```sql
ALTER TABLE 테이블명
ADD FULLTEXT INDEX명 (필드명)
```

다음 예제는 Reservation 테이블의 Name 필드에 FULLTEXT INDEX를 추가하는 예제이다.

```sql
ALTER TABLE Reservation
ADD FULLTEXT NameFtIdx (Name);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_add_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_add_03)

위의 예제처럼 FULLTEXT 인덱스의 인덱스 타입은 언제나 FULLTEXT이다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-INDEX-1911d606959e463895ead59be73e8f29
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_index_add](http://www.tcpschool.com/mysql/mysql_index_add)
