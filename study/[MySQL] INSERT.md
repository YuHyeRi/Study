# [**MySQL] INSERT**

**INSERT**

MySQL에서는 INSERT INTO문을 사용하여 테이블에 새로운 레코드를 추가할 수 있다.

---

**테이블에 레코드 추가**

INSERT INTO문과 함께 VALUES절을 사용하여 해당 테이블에 새로운 레코드를 추가할 수 있다.

```sql
1. INSERT INTO 테이블이름(필드이름1, 필드이름2, 필드이름3, ...)
   VALUES (데이터값1, 데이터값2, 데이터값3, ...)

2. INSERT INTO 테이블이름
   VALUES (데이터값1, 데이터값2, 데이터값3, ...)
```

또한 두 번째 문법처럼 필드의 이름을 생략할 수 있으며, 
이 경우에는 데이터베이스의 스키마와 같은 순서대로 필드의 값이 자동 대입된다.

이 때 생략할 수 있는 필드는 다음과 같다.

1. NULL 을 저장할 수 있도록 설정된 필드
2. DEFAULT 제약 조건이 설정된 필드
3. AUTO_INCREMENT 키워드가 설정된 필드

다음 예제는 Reservation 테이블에 새로운 레코드를 추가하는 예제이다.

```sql
INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum)
VALUES(5, '이순신', '2016-02-16', 1108);
```


<aside>
💡 데이터의 값이 문자열이면 반드시 따옴표(””)를 사용해야 한다.

</aside>

다음 예제와 같이 추가하는 레코드가 반드시 모든 필드의 값을 가져야 할 필요는 없다.

```sql
INSERT INTO Reservation(ID, Name)
VALUES (6, '김유신');
```


Reservation 테이블은 총 4개의 필드를 가지지만, 
위의 예제처럼 ID와 Name 필드만을 가지는 레코드를 추가할 수도 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-INSERT-3969e2e3ecdf4fc6bb2a4d5ed7e6a0eb
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_insert](http://www.tcpschool.com/mysql/mysql_basic_insert)
