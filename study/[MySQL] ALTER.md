# [**MySQL] ALTER**

**ALTER**

MySQL에서는 다음과 같은 ALTER문을 사용하여 데이터베이스와 테이블의 내용을 수정할 수 있다.

1. ALTER DATABASE
2. ALTER TABLE

---

**데이터베이스 수정**

ALTER DATABASE 문은 데이터베이스의 전체적인 특성을 수정할 수 있게 해준다. 
이러한 데이터베이스의 특성은 데이터베이스의 디렉터리 db.opt 파일에 저장되어 있다.

다음과 같은 구문을 통해 데이터베이스의 문자 집합이나 콜레이션을 변경할 수 있다.

```sql
1. ALTER DATABASE 데이터베이스이름 CHARACTER SET=문자집합이름
2. ALTER DATABASE 데이터베이스이름 COLLATE=콜레이션이름
```

<aside>
💡 콜레이션(collation)이란 데이터베이스에서 검색이나 정렬과 같은 작업을 할 때 사용하는 비교를 위한 규칙의 집합을 의미한다.

</aside>

다음 예제는 Hotel 데이터베이스의 문자 집합과 콜레이션을 변경하는 예제이다.

```sql
ALTER DATABASE Hotel CHARACTER SET=euckr_bin COLLATE=euckr_korean_ci;
```

자주 사용되는 대표적인 CHARACTER SET은 다음과 같다.

1. utf8 : UTF-8 유니코드를 지원하는 문자셋 (1~3바이트)
2. euckr : 한글을 지원하는 문자셋 (1~2바이트)

또한, 자주 사용되는 대표적인 COLLATE는 다음과 같다.

1. utf8_bin
2. utf8_general_ci (기본 설정)
3. euckr_bin
4. euckr_korean_ci

<aside>
💡 COLLATE에서 ci는 case-insensitive를 의미하며, 대소문자를 구분하지 않게 설정된다.

</aside>

---

**테이블 수정**

ALTER TABLE문은 테이블에 필드를 추가, 삭제하거나 필드의 타입을 변경할 수 있게 해준다.

1. ADD 
2. DROP
3. MODIFY COLUMN

---

**새로운 필드 추가**

ALTER TABLE 문과 함께 ADD문을 사용하면 테이블에 필드를 추가할 수 있다.

```sql
ALTER TABLE 테이블이름 ADD 필드이름 필드타입
```

다음 예제는 Reservation 테이블에 타입이 INT인 Phone 필드를 추가하는 예제다.

```sql
ALTER TABLE Reservation
ADD Phone INT;
```



---

**기존 필드의 삭제**

ALTER TABLE문과 함께 DROP문을 사용하면 테이블의 필드를 삭제할 수 있다.

```sql
ALTER TABLE 테이블이름 DROP 필드이름
```

다음 예제는 Reservation 테이블에서 RoomNum 필드를 삭제하는 예제이다.

```sql
ALTER TABLE Reservation
DROP RoomNum;
```



---

**필드 타입 변경**

ALTER TABLE문과 함께 MODIFY COLUMN문을 사용하면 테이블의 필드 타입을 변경할 수 있다.

```sql
ALTER TABLE 테이블이름 MODIFY COLUMN 필드이름 필드타입
```

다음 예제는 Reservation 테이블의 ReserveDate 필드 타입을 DATE에서 VARCHAR(20)으로 변경하는 예제이다.

```sql
ALTER TABLE Reservation
MODIFY COLUMN ReserveDate VARCHAR(20);
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-ALTER-5fe13952df244b62916e237a72ba43c3
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_alter](http://www.tcpschool.com/mysql/mysql_basic_alter)
