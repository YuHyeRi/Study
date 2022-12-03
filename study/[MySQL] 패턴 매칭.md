# [**MySQL] 패턴 매칭**

**패턴 매칭(pattern matching)**

MySQL은 데이터의 특정 패턴을 검색하기 위한 다음과 같은 패턴 매칭 연산자를 제공한다.

1. LIKE
2. REGEXP

또한, 임의의 문자나 문자열을 대체하기 위해서 와일드카드(wildcard)문자를 사용할 수도 있다.

---

**LIKE**

LIKE 연산자는 특정 패턴을 포함하는 데이터만을 검색하기 위해 사용한다.

다음 예제는 Reservation 테이블에서 ‘장’으로 시작하는 이름(Name)으로 예약한 레코드를 선택하는 예제이다.

*예제*

```sql
SELECT * FROM Reservation
WHERE Name LIKE '장%';
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_01)

<aside>
💡 ‘%’는 0개 이상의 문자라는 의미의 와일드카드(wildcard) 문자이다.

</aside>

만약 특정 패턴을 포함하지 않는 데이터를 검색하고 싶을 때는 NOT LIKE 연산자를 사용하면 된다. 

다음 예제는 Reservation 테이블에서 ‘장’으로 시작하지 않는 이름(Name)으로 예약한 레코드를 선택하는 예제이다.

*예제*

```sql
SELECT * FROM Reservation
WHERE Name NOT LIKE '장%';
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_02)

---

**와일드카드(wildcard)**

와일드카드란 문자열 내에서 임의의 문자나 문자열을 대체하기 위해 사용되는 기호를 의미한다. MySQL에서 사용할 수 있는 와일드카드 문자는 다음과 같다.

| 와일드카드 | 설명 |
| --- | --- |
| % | 0개 이상의 문자를 대체함 |
| _ | 1개의 문자를 대체함 |

다음 예제는 RoomNum 필드의 값이 20으로 시작하고, 바로 뒤에 두 자리 숫자가 더 나오는 레코드를 선택하는 예제이다. 아래의 예제에서 RoomNum필드의 값이 200이나 20,000인 레코드는 선택되지 않을 것이다.

*예제*

```sql
SELECT * FROM Reservation
WHERE RoomNum LIKE '20__';
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_03)

---

**REGEXP**

LIKE 연산자보다 더욱 복잡한 패턴을 검색하고 싶을 때는 REGEXP 연산자를 사용할 수 있다. 
REGEXP 연산자는 정규 표현식을 토대로 하는 패턴 매칭 연산을 제공한다.

REGEXP 연산자와 함께 사용할 수 있는 패턴은 다음과 같다.

| 패턴 | 설명 |
| --- | --- |
| . | 줄 바꿈 문자(\n)를 제외한 임의의 한 문자를 의미함 |
| * | 해당 문자 패턴이 0번 이상 반복됨 |
| + | 해당 문자 패턴이 1번 이상 반복됨 |
| ^ | 문자열의 처음을 의미 |
| $ | 문자열의 끝을 의미 |
| | | 선택을 의미함 (OR) |
| […] | 괄호([])안에 있는 어떠한 문자를 의미함 |
| [^…] | 괄호([])안에 있지 않은 어떠한 문자를 의미함 |
| {n} | 반복되는 횟수를 지정함 |
| {m,n} | 반복되는 횟수의 최솟값과 최댓값을 지정함 |

다음 예제는 Name 필드의 값이 ‘홍’으로 시작하거나, ‘산’으로 끝나는 레코드를 선택하는 예제이다.

*예제*

```sql
SELECT * FROM Reservation
WHERE Name REGEXP '^홍|산$';
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_04](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_04)

만약 해당 패턴과 일치하지 않는 데이터를 찾고 싶을 때는 NOT REGEXP 연산자를 사용하면 된다. 

다음 예제는 Name 필드의 값이 ‘홍’으로 시작하지 않고, ‘산’으로 끝나지도 않는 레코드를 선택하는 예제이다.

*예제*

```sql
SELECT * FROM Reservation
WHERE Name NOT REGEXP '^홍|산$';
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_05](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_patternMatching_05)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-04b17b1e80754aaf99c255f3f7343894
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_operator_patternMatching](http://www.tcpschool.com/mysql/mysql_operator_patternMatching)
