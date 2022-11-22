# [**MySQL] SELECT**

**SELECT**

MySQL에서는 SELECT문을 사용하여 테이블의 레코드를 선택할 수 있다.

```sql
SELECT 필드이름
FROM 테이블이름 
[WHERE 조건]
```

FROM절은 레코드를 선택할 테이블의 이름을 명시한다.
해당 테이블에서 선택하고 싶은 필드의 이름을 SELECT 키워드 바로 뒤에 명시하면 된다.
이 때 WHERE절을 사용하면 선택할 레코드의 조건을 좀 더 상세히 설정할 수 있다.

---

**데이터의 모든 필드 선택**

SELECT문과 함께 별포(*) 기호를 사용하면 해당 테이블의 모든 필드를 선택할 수 있다.

```sql
SELECT *
FROM 테이블이름
```

이 방식은 해당 테이블의 ‘모든 필드’를 선택해야 할 경우에 유용하게 사용할 수 있다.

다음 예제는 Reservation 테이블의 모든 필드를 선택하는 예제이다.

```sql
SELECT *
FROM Reservation;
```

---

**특정 조건의 레코드 선택**

SELECT문과 함께 WHERE절을 사용하면 검색할 레코드의 조건을 설정할 수 있다. 
이러한 WHERE절은 테이블의 크기가 매우 작거나 특정 조건에 맞는 레코드만을 선택하고 싶을 때 
유용하게 사용된다.

다음 예제는 Name 필드의 값이 ‘홍길동’인 레코드만을 선택하는 예제이다.

```sql
SELECT *
FROM Reservation
WHERE Name = '홍길동';
```

이러한 WHERE절에는 여러 개의 조건을 같이 명시할 수도 있다.
이 때 여러 개의 조건은 AND나 OR 연산자를 이용하여 연결한다.

다음 예제는 ID 값이 3이하면서 ReserveDate 필드의 값이 2016년 2월 1일 이후인 레코드만을 
선택하는 예제이다.

```sql
SELECT *
FROM Reservation
WHERE ID <= 3 AND ReserveDate > '2016-02-01';
```

---

**특정 필드만을 선택**

SELECT 키워드 다음에 필드 이름을 명시하면 해당 테이블의 특정 필드만을 불러올 수 있다. 
이 때 쉼표(,)를 사용하여 여러 개의 필드 이름을 한 번에 명시할 수 있다.

다음 예제는 Reservation 테이블에서 Name 필드와 RoomNum 필드만을 선택하는 예제이다.

```sql
SELECT Name, RoomNum
FROM Reservation;
```

이 때에도 WHERE 문을 사용하여 특정 조건을 만족하는 레코드만을 선택할 수 있다.

다음 예제는 ID 값이 3이하이면서 ReserveDate 필드의 값이 2016년 2월 1일 이후인 레코드의 
Name 필드와 ReserveDate 필드만을 선택하는 예제이다.

```sql
SELECT Name, ReserveDate 
FROM Reservation
WHERE ID <= 3 AND ReserveDate > '2016-02-01';
```

---

**중복되는 값 제거**

만약 같은 필드에 중복되는 값을 가지는 레코드가 있다면 DISTINCT 키워드를 사용하여 
그 값이 한 번만 선택되도록 설정할 수 있다.

다음 예제는 Reservation 테이블에서 Name 필드를 선택하는 예제이다.
이 때 DISTINCT 키워드를 사용했기 때문에 중복된 값은 단 한 번만 선택된다.

```sql
SELECT DISTINCT Name
FROM Reservation;
```

---

**선택한 결과의 정렬**

SELECT 문으로 선택한 결과를 ORDER BY절을 사용하여 정렬할 수 있다.
ORDER BY절의 기본 설정은 오름차순이며 ASC 키워드를 사용하여 직접 오름차순을 명시할 수도 
있다.

다음 예제는 Reservation 테이블의 모든 레코드를 ReserveDate 필드의 오름차순으로 정렬하여 선택하는 예제이다.

```sql
SELECT * 
FROM Reservation
ORDER BY ReserveDate;
```

만약 내림차순으로 정렬하고자 할 때는 맨 마지막에 DESC 키워드를 추가하면 된다.

다음 예제는 Reservation 테이블의 모든 레코드를 ReserveDate 필드의 내림차순으로 정렬하여 선택하는 예제이다.

```sql
SELECT * 
FROM Reservation
ORDER BY ReserveDate DESC;
```

PHP에서 문자열 타입을 데이터로 가지는 필드를 정렬할 때는 기본적으로 대소문자를 구분하지 않는다. 하지만 대소문자까지 구분하여 정렬하고 싶을 때는 ORDER BY BINARY 절을 사용하면 된다.

또한, 여러 필드의 데이트를 쉼표(,)를 사용하여 한 번에 정렬할 수도 있다.

다음 예제는 Reservation 테이블의 모든 레코드를 먼저 ReserveDate 필드의 내림차순으로 정렬한 뒤에, 또다시 RoomNum 필드의 내림차순으로 정렬하여 선택하는 예제이다.

```sql
SELECT *
FROM Reservation
ORDER BY ReserveDate DESC, RoomNum ASC;
```

---

**별칭(alias)을 이용한 처리**

MySQL에서는 테이블과 필드에 임시로 별칭을 부여하고 해당 별칭을 SELECT 문에서 사용할 수 있다.
이러한 별칭은 복잡한 테이블 이름이나 필드의 이름을 좀 더 읽기 쉽도록 만들어 준다.

```sql
1. SELECT 필드이름 AS 별칭
FROM 테이블이름
 
2. SELECT 필드이름
FROM 테이블이름 AS 별칭;
```

위의 첫 번째 문법은 해당 필드에 새로운 별칭을 부여하고 두 번째 문법은 해당 테이블에 새로운 
별칭을 부여하는 문법이다.

다음 예제는 Reservation 테이블의 RoomNum 필드와 Name 필드에 하나의 새로운 별칭을 부여하는 예제이다.

```sql
SELECT ReserveDate, CONCAT(RoomNum, " : ", Name) AS ReserveInfo
FROM Reservation;
```

<aside>
💡 CONCAT() 함수는 인수로 전달받은 문자열을 모두 결합하여 하나의 문자열로 반환하는 함수이다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-SELECT-cb298e69f2b54f6fac383520a365afeb
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_select](http://www.tcpschool.com/mysql/mysql_basic_select)
