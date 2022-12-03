# [**MySQL] 타입 변환**

**타입 변환(type casting)**

MySQL은 비교나 검색을 수행할 때 데이터의 타입이 서로 다른 경우, 내부적으로 타입이 같아지도록 자동 변환하여 처리한다. 
하지만 사용자가 명시적으로 타입을 변환할 수 있도록 다양한 연산자와 함수도 같이 제공하고 있다.

1. BINARY
2. CAST()
3. CONVERT()

---

**BINARY**

BINARY 연산자는 뒤에 오는 문자열을 바이너리 문자열로 변환한다.
BINARY 연산자는 문자가 아닌 바이트를 기준으로 하여 비교나 검색 작업을 수행할 수 있다.

다음 예제는 BINARY 연산자를 이용하여 문자 ‘a’와 ‘A’를 비교하는 예제이다.
아래 예제처럼 BINARY  연산자를 이용하면 비교하려는 문자의 바이트 값을 비교한다. 
따라서 문자 ‘a’과 ‘A’가 서로 다른 값으로 인식된다.

*예제*

```sql
SELECT BINARY 'a' = 'A', // 참 0
'a' = 'A';               // 거짓 1
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_typeCasting_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_typeCasting_01)

*실행결과*

0

1

---

**CAST()**

CAST 함수는 인수로 전달받은 값을 명시된 타입으로 변환하여 반환한다.
이 때 변환하고자 하는 타입을 AS절을 이용하여 직접 명시할 수 있다.

*문법*

```sql
CAST(expr AS type)
```

AS절에서 사용할 수 있는 타입은 다음과 같다.

1. BINARY
2. CHAR
3. DATE
4. DATETIME
5. TIME
6. DECIMAL
7. JSON (MySQL 5.7.8부터 제공됨)
8. NCHAR
9. SIGNED [INTEGER]
10. UNSIGNED [INTEGER]

다음 예제는 CAST함수를 이용하여 문자열 데이터를 UNSIGNED 타입으로 변환하는 예제이다.

*예제*

```sql
SELECT 4 / '2',
4 / 2,
4 / CAST('2' AS UNSIGNED);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_typeCasting_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_typeCasting_02)

*실행결과*

2

2.0000

2.0000

위의 예제에서 문자열 타입의 데이터를 묵시적으로 타입 변환하여 수행한 나눗셈 연산의 결과는 
정수 타입으로 반환된다. 하지만 정수 타입끼리 나눗셈 연산을 한 결과는 실수 타입으로 반환된다. 
따라서 문자열 타입의 데이터를 CAST 함수를 사용하여, 명시적으로 타입 변환해야만 올바른 나눗셈 연산 결과를 얻을 수 있다.

---

**CONVERT()**

CONVERT 함수도 CAST 함수처럼 인수로 전달받은 값을 명시된 타입으로 변환하여 반환한다. CONVERT 함수는 두 번째 인수로 변환하고자 하는 타입을 직접 전달할 수 있다.

*문법*

```sql
1. CONVERT(expr, type)
2. CONVERT(expr USING transcoding_name)
```

USING절은 서로 다른 문자셋(character set)간의 데이터 변환을 위해 사용된다. 
이 때 사용할 수 있는 타입은  CAST 함수와 같다.

다음 예제는 CONVERT 함수를 이용하여 문자열 데이터의 문자셋을 UTF-8로 변환하는 예제이다.

*예제*

```sql
SELECT CONVERT('abc' USING utf8);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_typeCasting_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_typeCasting_03)

*실행결과*

abc

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-66f85bcd5a6843c195c38387c879788c
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_operator_typeCasting](http://www.tcpschool.com/mysql/mysql_operator_typeCasting)
