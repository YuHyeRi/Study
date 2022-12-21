# [**MySQL] 수학 함수**

**올림과 내림**

FLOOR 함수는 인수로 전달받은 값과 같거나 작은 수 중에서 가장 큰 정수를 반환한다.
CEIL 함수는 반대로 인수로 전달받은 값과 같거나 큰 수 중에서 가자아 작은 정수를 반환한다.

```sql
SELECT FLOOR(10.95),
FLOOR(11.01),
FLOOR(-10.95),
FLOOR(-11.01);
```


```sql
SELECT CEIL(10.95),
CEIL(11.01),
CEIL(11),
CEIL(-10.95),
CEIL(-11.01);
```


또한 소수점에서의 반올림은 ROUND 함수를 사용하여 수행할 수 있다.
이 때 두번째 인수로 반올림할 소수점을 전달할 수도 있다.

```sql
SELECT ROUND(10.49),
ROUND(10.5),
ROUND(-10.5),
ROUND(-10.49);
```


---

**지수와 로그**

SQRT 함수는 전달받은 수의 제곱근 중 양수값을 반환한다.
POW 함수는 전달받은 수의 거듭제곱을 반환한다.
POW 함수의 첫 번째 인수로는 밑수를 전달하고, 두 번째 인수로는 지수를 전달한다.

EXP 함수는 인수로 지수를 전달받아, e의 거듭제곱을 계산하여 반환한다.
LOG 함수는 전달받은 수의 자연로그 값을 계산하여 반환한다.

```sql
SELECT SQRT(4), 
POW(2, 3),
EXP(3), 
LOG(3);
```


---

**삼각 함수**

MySQL에서는 다음 함수를 사용하여 쿼리에 간단히 삼각 함수를 사용할 수 있다.
SIN 함수는 전달받은 수의 사인값을, COS 함수는 코사인값을, TAN 함수는 탄젠트값을 반환한다.

```sql
SELECT SIN(PI()/2), 
COS(PI()), 
TAN(PI()/4);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_builtInFunction_math_05](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_builtInFunction_math_05)

위의 예제에서 사용된 PI 함수는 파이값을 반환하는 함수이다.

---

**기타 함수**

ABS(X) 함수는 전달받은 수의 절댓값을 반환한다.
RAND 함수는 0.0보다 크거나 같고 1.0보다 작은 하나의 실수를 무작위로 생성하여 반환한다.

```sql
SELECT ABS(-3), 
ROUND(RAND()*100, 0);
```


위의 예제에서 RAND 함수는 ROUND 함수의 인수로 전달되어 0부터 100사이의 무작위 정수를 
하나씩 생성한다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-4eca7643e4ce4ce7ac211fdb24bc0aea
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_builtInFunction_math](http://www.tcpschool.com/mysql/mysql_builtInFunction_math)
