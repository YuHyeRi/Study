# [**MySQL] 흐름 제어**

**흐름 제어**

MySQL은 프로그램의 순차적인 흐름을 제어해야 할 때 사용할 수 있는 다양한 연산자와 함수를 제공한다.

1. CASE
2. IF()
3. ISNULL()
4. NULLIF()

---

**CASE**

CASE 연산자는 값을 서로 비교하거나, 표현식의 논리값에 따라 다른 값을 반환한다.
CASE 연산자의 문법은 다음과 같다.

```sql
1. CASE value
    WHEN [compare_value] THEN result
    [WHEN [compare_value] THEN result] ...
    [ELSE result]
END

2. CASE
    WHEN [condition] THEN result 
    [WHEN [condition] THEN result] ...
    [ELSE result]
END
```

첫 번째 CASE 문법에서는 value와 compare_value값이 같으면, THEN절의 result 값을 반환한다. 
만약 서로 값이 같지 않으면, ELSE절의 result 값을 반환한다. 
이 때 ELSE 절이 없으면, NULL을 반환한다.

두 번째 CASE 문법에서는 condition의 논리값이 참이면, THEN절의 result 값을 반환한다. 
만약 논리값이 거짓이라면, ELSE 절의 result 값을 반환한다. 
이 때 ELSE 절이 없으면, NULL을 반환한다.

*예제*

```sql
SELECT CASE 0
    WHEN 0 THEN 'zero'
    WHEN 1 THEN 'one'
    ELSE 'more'
END;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_01)

*실행결과*

zero

---

**IF()**

IF() 함수는 첫 번째 인수로 전달받은 표현식의 논리값에 따라 다른 값을 반환한다.
IF 함수의 원형은 다음과 같다.

```sql
IF(expr1, expr2, expr3)
```

만약 expr1이 참이면 expr2를 반환하고, 거짓이면 expr3를 반환한다.

*예제*

```sql
SELECT IF(0 < 1, 'yes', 'no');
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_02)

*실행결과*

yes

---

**IFNULL()**

IFNULL 함수는 첫 번째 인수로 전달받은 값이 NULL인지 아닌지를 검사하여 다른 값을 반환한다. 
IFNULL 함수의 원형은 다음과 같다.

```sql
IFNULL(expr1, expr2)
```

만약 expr1의 값이 NULL이 아니면 expr1 그 자체를 반환하고, NULL이면 expr2를 반환한다.

*예제*

```sql
SELECT IFNULL(NULL, '전달받은 값이 null입니다.');
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_03)

*실행결과*

전달받은 값이 null입니다.

---

**NULLIF()**

NULLIF() 함수는 인수로 전달받은 두 값이 서로 같은지를 검사하여 다른 값을 반환한다.
NULLIF 함수의 원형은 다음과 같다.

```sql
NULLIF(expr1, expr2)
```

만약 expr1과 expr2의 값이 서로 같으면 NULL을 반환하고, 같지 않으면 expr1을 반환한다. 
따라서 NULLIF 함수는 다음 예제의 CASE문과 같은 동작을 수행한다.

*예제*

```sql
CASE
    WHEN expr1 = expr2 
    THEN NULL 
    ELSE expr1 
END
```

*예제*

```sql
SELECT NULLIF(3, 3);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_04](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_flowControl_04)

*실행결과*

NULL

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-f843d088f949445e866ed8d6177621a9
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_operator_flowControl](http://www.tcpschool.com/mysql/mysql_operator_flowControl)
