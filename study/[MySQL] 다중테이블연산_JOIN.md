# [**MySQL] 다중테이블연산_JOIN**

**JOIN**

JOIN은 데이터베이스 내의 여러 테이블에서 가져온 레코드를 조합하여 
하나의 테이블이나 결과 집합으로 표현해준다.
이러한 JOIN은 보통 SELECT문과 함께 자주 사용된다.

표준 SQL에서는 레코드를 조합하는 방식에 따라 JOIN을 다음과 같이 구분한다.

1. INNER JOIN
2. LEFT JOIN
3. RIGHT JOIN

---

**INNER JOIN**

INNER JOIN은 ON절과 함께 사용되며 ON절의 조건을 만족하는 데이터만을 가져온다.

*문법*

```sql
1. 첫번째 테이블 이름
INNER JOIN 두번째 테이블 이름
ON 조건

2. 첫번째 테이블 이름
JOIN 두번째 테이블 이름
ON 조건
```

ON절에서는 WHERE절에서 사용할 수 있는 모든 조건을 사용할 수 있다.
표준 SQL과는 달리 MySQL에서는 JOIN, INNER JOIN, CROSS JOIN이 모두 같은 의미로 사용된다.

다음 예제는 Reservation 테이블의 Name 필드와 Customer 테이블의 Name 필드가 서로 일치하는 
레코드만을 INNER JOIN으로 가져오는 예제이다.

```sql
1. SELECT *
FROM Reservation
INNER JOIN Customer
ON Reservation.Name = Customer.Name;

2. SELECT *
FROM Reservation
JOIN Customer
ON Reservation.Name = Customer.Name;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_join_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_join_01)

*결과*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ad7ca996-193d-49ac-af84-f94fd4be929d/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221210T095930Z&X-Amz-Expires=86400&X-Amz-Signature=106b6127d2c4b0a446e74bad8a15781b09489a804939a5960ea311ba71307148&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

위의 두 에제의 실행결과처럼 JOIN의 결과는 하나의 테이블 형태로 반환된다.

INNER JOIN의 결과를 벤 다이어그램으로 나타내면 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c9a68d6c-4525-435a-b021-add189e2ce35/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221210T095913Z&X-Amz-Expires=86400&X-Amz-Signature=2cdc56324b70727d360904b12d5f2792c0023932f9b3fd70d8bd0cd5cfcf1b7c&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

INNER JOIN의 경우에는 앞서 살펴본 표준 SQL 방식과는 별도로 MySQL에서만 사용할 수 있는 
방식이 따로 존재한다. 

다음 예제는 앞서 살펴본 INNER JOIN 예제와 같은 실행 결과를 보여준다.

```sql
SELECT *
FROM Reservation, Customer
WHERE Reservation.Name = Customer.Name;
```

위의 예제처럼 테이블의 이름이 같거나 복잡한 경우에는, 별칭(alias)을 사용하여 SQL구문을 
간략화할 수 있다.

다음 예제는 앞의 예제를 별칭(alias)을 사용하여 간략화한 예제이다.

```sql
SELECT *
FROM Reservation AS r, Customer AS c
WHERE r.Name = c.Name;
```

---

**LEFT JOIN**

LEFT JOIN은 첫 번째 테이블을 기준으로, 두 번째 테이블을 조합하는 JOIN이다.

이 때 ON절의 조건을 만족하지 않는 경우에는 첫 번쨰 테이블의 필드 값은 그대로 가져온다. 
그러나 해당 레코드의 두 번째 테이블의 필드 값은 모두 NULL로 표시된다.

*문법*

```sql
첫번째 테이블 이름
LEFT JOIN 두번째 테이블 이름
ON 조건
```

ON절에서는 WHERE절에서 사용할 수 있는 모든 조건을 사용할 수 있다.

다음 예제는 Reservation 테이블의 Name 필드를 기준으로 Customer 테이블의 Name 필드와 
일치하는 레코드만을 LEFT JOIN으로 가져온 후, 그 중에서 ReserveDate 필드의 값이 
2016년 02월 01일 이후인 레코드만을 선택하는 예제이다.

```sql
SELECT *
FROM Reservation
LEFT JOIN Customer
ON Reservation.Name = Customer.Name
WHERE ReserveDate > '2016-02-01';
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_join_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_join_02)

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/31e7c093-7b51-4139-8521-e73372d966a2/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221210T095853Z&X-Amz-Expires=86400&X-Amz-Signature=e43b02ae3daf2a6d3b24c53e535af224b308e9104b38e3c2996f3a7a55a3e534&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

위의 예제에서 두 개의 Name값이 일치하면 INNER JOIN과 같이 두 테이블의 모든 필드를 그대로 
가져온다.
하지만 두 개의 Name값이 일치하지 않는 경우에는 Customer 테이블의 모든 필드를 NULL로 표시
된다.

LEFT JOIN의 결과를 벤 다이어그램으로 나타내면 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4a3810ea-6f9c-4175-b662-1f4127fb9c31/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221210T095834Z&X-Amz-Expires=86400&X-Amz-Signature=8ef5bc716617ba3a29e6f24f78c093173cb5090ead0371d1b5d7cc87a10be11b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

---

**RIGHT JOIN**

RIGHT JOIN은 LEFT JOIN과는 반대로 두 번째 테이블을 기준으로, 첫 번쨰 테이블을 조합하는 
JOIN이다.

이 때 ON절의 조건을 만족하지 않는 경우에는 두 번째 테이블의 필드 값은 그대로 가져온다.
그러나 해당 레코드의 첫 번째 테이블의 필드 값은 모두 NULL로 표시된다.

*문법*

```sql
첫번째 테이블 이름
LEFT JOIN 두번째 테이블 이름
ON 조건
```

ON절에서는 WHERE절에서 사용할 수 있는 모든 조건을 사용할 수 있다.

다음 예제는 Customer 테이블의 Name 필드를 기준으로 Reservation 테이블의 Name 필드와 일치
하는 레코드만을 RIGHT JOIN으로 가져오는 예제이다.

```sql
SELECT *
FROM Reservation
RIGHT JOIN Customer
ON Reservation.Name = Customer.Name;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_join_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_join_03)

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/34789132-b559-4bc4-af7d-3d465308c8b7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221210T095817Z&X-Amz-Expires=86400&X-Amz-Signature=72756d8611440dd1f4f5fab1cf7c985f78c854b4f3483b13d95ab946b1021647&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

위의 예제에서 두 개의 Name값이 일치하면, INNER JOIN과 같이 두 테이블의 모든 필드를 그대로 
가져온다.
그러나 두 개의 Name값이 일치하지 않는 경우에는 Reservation테이블의 모든 필드를 
NULL로 표시된다.

RIGHT JOIN의 결과를 벤 다이어그램으로 나타내면 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9c602710-2eaf-4707-af71-9712017c17b1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221210T095802Z&X-Amz-Expires=86400&X-Amz-Signature=1dd7bca1c1e584846a12b44c009c04ac9ddaf5cc425a2b052c868b668cbc7b50&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-_JOIN-e86c1bdac22a45909759e49d7c5d1c94
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_multipleTable_join](http://www.tcpschool.com/mysql/mysql_multipleTable_join)
