# [**MySQL] INDEX 생성**

**인덱스(index)란?**

인덱스는 테이블에서 원하는 데이터를 쉽고 빠르게 찾기 위해 사용한다.
이러한 인덱스는 자주 사용되는 필드 값으로 만들어진 원본 테이블의 사본이라고 생각할 수 있다.

MySQL은 데이터를 검색할 때 첫 번째 필드부터 차례대로 테이블 전체를 검색한다.
따라서 테이블이 크면 클수록 데이터를 탐색하는 시간도 많이 늘어나게 된다.

그러나 인덱스를 사용하면테이블 전체를 읽지 않아도 되므로, 검색과 질의에 대한 처리가 빠르게 
이루어진다. 이러한 인덱스는 사용자가 직접 접근할 수는 없으며, 검색과 질의에 대한 처리에서만 
사용된다.

이렇게 인덱스가 설정된 필드 값을 포함한 데이터의 삽입, 삭제, 수정 작업이 원본 테이블에서 
이루어질 경우, 인덱스도 함께 수정되어야 한다.
따라서 인덱스가 설정된 테이블의 처리 속도가 느려질 수 있다.
그러므로 인덱스는 수정보다는 검색이 자주 사용되는 테이블에서 사용하는 것이 더 좋다.

---

**인덱스 생성**

CREATE문을 사용하여 인덱스를 생성할 수 있다.

*문법*

```sql
CREATE INDEX 인덱스명
ON 테이블명 (필드명1, 필드명2, ...)
```

이 때 쉼표(,)를 사용하여 여러 필드를 가지는 인덱스를 생성할 수도 있다.

다음 예제는 Reservation 테이블의 Name 필드에 NameIdx라는 인덱스를 설정하는 예제이다.

```sql
CREATE INDEX NameIdx
ON Reservation (Name);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_create_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_create_01)

---

**인덱스 정보 보기**

위와 같이 생성한 인덱스는 다음과 같은 문법을 통해 확인할 수 있다.

*문법*

```sql
SHOW INDEX
FROM 테이블명
```

위와 같은 문법을 사용하면 해당 테이블에 생성된 모든 인덱스의 정보를 보여준다.
이 때 반환되는 인덱스 정보의 필드 값은 다음과 같다.

1. Table : 테이블의 이름을 표시함.
2. Non_unique : 인덱스가 중복된 값을 저장할 수 있으면 1, 저장할 수 없으면 0을 표시함.
3. Key_name : 인덱스의 이름을 표시하며, 인덱스가 해당 테이블의 기본 키라면 PRIMARY로 표시함.
4. Seq_in_index : 인덱스에서의 해당 필드의 순서를 표시함.
5. Column_name : 해당 필드의 이름을 표시함.
6. Collation : 인덱스에서 해당 필드가 정렬되는 방법을 표시함.
7. Cardinality : 인덱스에 저장된 유일한 값들의 수를 표시함.
8. Sub_part : 인덱스 접두어를 표시함.
9. Packed : 키가 압축되는(packed) 방법을 표시함.
10. Null : 해당 필드가 NULL을 저장할 수 있으면 YES를 표시하고, 저장할 수 없으면 ''를 표시함.
11. Index_type : 인덱스에 사용되는 메소드(method)를 표시함.
12. Comment : 해당 필드를 설명하는 것이 아닌 인덱스에 관한 기타 정보를 표시함.
13. Index_comment : 인덱스에 관한 모든 기타 정보를 표시함.

---

**UNIQUE INDEX 생성**

UNIQUE INDEX는 중복 값을 허용하지 않는 인덱스이다.

*문법*

```sql
CREATE UNIQUE INDEX 인덱스명
ON 테이블명 (필드명1, 필드명2, ...)
```

또한 쉼표(,)를 사용하여 여러 필드에 UNIQUE INDEX를 설정해줄 수도 있다.

다음 예제는 Reservation 테이블의 ID 필드에 IdIdx라는 UNIQUE INDEX를 설정하는 예제이다.

```sql
CREATE UNIQUE INDEX IdIdx
ON Reservation (ID);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_create_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_create_02)

---

**인덱스 정렬**

인덱스를 생성할 때 인덱스에 포함되는 필드의 정렬 방식을 설정할 수 있다.

- DESC : 내림차순 정렬
- ASC : 오름차순 정렬

*문법*

```sql
1. CREATE INDEX 인덱스명
   ON 테이블명 (필드명 DESC)

2. CREATE INDEX 인덱스명
   ON 테이블명 (필드명 ASC)
```

다음 예제는 Reservation 테이블의 Name 필드에 NameDescIdx라는 인덱스를 설정하는 예제이다.
이때 Name 필드의 값들은 내림차순으로 정렬된다.

```sql
CREATE INDEX NameDescIdx
On Reservation (Name DESC);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_create_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_create_03)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-INDEX-2ead7e598c68486da67a7f08233625b7
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_index_create](http://www.tcpschool.com/mysql/mysql_index_create)
