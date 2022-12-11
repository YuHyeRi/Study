# [**MySQL] 다중테이블연산_UNION**

**UNION**

UNION은 여러 개의 SELECT문의 결과를 하나의 테이블이나 결과 집합으로 표현할 때 사용한다.
이 때 각각의 SELECT문으로 선택된 필드의 개수와 타입은 모두 같아야 하며, 
필드의 순서 또한 같아야 한다.

SELECT문에 UNION을 적용하는 문법은 다음과 같다.

*문법*

```sql
SELECT 필드이름
FROM 테이블이름

UNION

SELECT 필드이름
FROM 테이블이름
```

다음 예제는 두 SELECT문의 결과를 UNION을 이용하여 하나의 테이블로 출력하는 예제이다.

```sql
SELECT Name
FROM Reservation
UNION
SELECT Name
FROM Customer;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_union_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_union_01)

위의 예제에서 두 SELECT문의 결과는 하나로 합쳐져서 출력된다. 이 때 두 SELECT문의 결과에서 
중복된 레코드는 한 번만 표시된다.

---

**UNION ALL**

위의 예제처럼 UNION은 DISTINCT 키워드를 따로 명시하지 않아도 
기본적으로 중복되는 레코드를 제거한다.
따라서 이렇게 중복되는 레코드까지 모두 출력하고 싶다면, ALL 키워드를 사용해야 한다.

*문법*

```sql
SELECT 필드이름
FROM 테이블이름

UNION ALL

SELECT 필드이름
FROM 테이블이름
```

다음 예제는 SELECT문의 결과를 UNION ALL을 이용하여 하나의 테이블로 출력하는 예제이다.

```sql
SELECT Name
FROM Reservation
UNION ALL 
SELECT Name
FROM Customer;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_union_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_multipleTable_union_02)

위의 예제에서 두 SELECT문의 결과는 하나로 합쳐져서 출력된다.
이 때 두 SELECT문의 결과는 중복된 레코드까지 모두 표시한다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-_UNION-1ed30d66ccfb4efb9929755aa6ae8aa5
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_multipleTable_union](http://www.tcpschool.com/mysql/mysql_multipleTable_union)
