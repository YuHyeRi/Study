# [**MySQL] 문자열 함수**

**MySQL 내장 함수**

MySQL은 사용자의 편의를 위해 다양한 기능의 내장 함수를 미리 정의하여 제공하고 있다.
MySQL에서 미리 정의하여 제공해주는 대표적인 내장 함수의 종류는 다음과 같다.

1. 문자열 함수
2. 수학 함수
3. 날짜와 시간 함수

---

**문자열 길이**

LENGTH 함수는 전달받은 문자열의 길이를 반환한다.

```sql
SELECT LENGTH('12345678');
```


---

**문자열 결합**

CONCAT 함수는 전달받은 문자열을 모두 결합하여 하나의 문자열로 반환한다.
만약 전달받은 문자열 중 하나라도 NULL이 존재하면, NULL을 반환한다.

```sql
SELECT CONCAT('Ora', 'cle Cor', 'poration'), 
CONCAT('Oracle', NULL, 'Corporation');
```


---

**특정 문자열의 위치 검색**

LOCATE 함수는 인수로 전달받은 문자열이 특정 문자열에서 처음으로 나타나는 위치를 찾아서 
해당 위치를 반환한다.
만약 전달받은 문자열이 특정 문자열 내에 존재하지 않으면 0을 반환한다.

다른 대부분의 프로그래밍 언어에서는 문자열의 첫 번째 문자의 인덱스를 0부터 시작하여 그 위치를 계산한다.
그러나 MySQL에서느느 문자열의 첫 번째 문자의 인덱스를 언제나 1부터 시작하므로 주의를 
기울여야 한다.

이 때 세 번째 인수로 특정 문자열에서 전달받은 문자열을 찾기 시작할 인덱스를 전달할 수도 있다.

```sql
SELECT LOCATE('abc', 'ababcDEFabc'), 
LOCATE('abc', 'ababcDEFabc', 4);
```


---

**문자열 추출**

LEFT 함수는 전달받은 문자열의 왼쪽부터 명시한 개수만큼의 문자를 반환한다.
RIGHT 함수는 전달받은 문자열의 오른쪽부터 명시한 개수만큼의 문자를 반환한다.

```sql
SELECT LEFT('MySQL PHP HTML Java', 5), 
RIGHT('MySQL PHP HTML Java', 4);
```


---

**문자열 대소문자 변경**

LOWER 함수는 전달받은 문자열의 문자를 모두 소문자로 변경한다.
UPPER 함수는 전달받은 문자열의 문자를 모두 대문자로 변경한다.

```sql
SELECT LOWER('MySQL PHP HTML Java'), 
UPPER('MySQL PHP HTML Java');
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_builtInFunction_string_05](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_builtInFunction_string_05)

---

**문자열 대체**

REPLACE 함수는 전달받은 문자열에서 특정 문자열을 찾은 후에 찾은 문자열을 대체 문자열로 
교체한다.

```sql
SELECT REPLACE('MySQL', 'My', 'MS ');
```


---

**문자열 다듬기**

TRIM 함수는 전달받은 문자열의 앞이나 뒤, 또는 양쪽 모두에 있는 특정 문자를 제거한다.

TRIM 함수에서 사용할 수 있는 지정자는 다음과 같다.

1. BOTH : 양 끝에 존재하는 특정 문자를 제거함. (기본설정)
2. LEADING : 전달받은 문자열 앞에 존재하는 특정 문자를 제거함.
3. TRAILING : 전달받은 문자열 뒤에 존재하는 특정 문자르르 제거함.

```sql
SELECT TRIM('   !!!MySQL PHP HTML Java!!!    '), 
TRIM(LEADING '!' FROM '!!!MySQL PHP HTML Java!!!')
```


---

**숫자로 이루어진 문자열의 형식화**

FORMAT 함수는 숫자 타입의 데이터를 세 자리마다 쉼표(,)를 사용하는 '#,###,###.##’ 형식으로 
변환해준다.
그러나 반환되는 데이터의 형식이 숫자 타입이 아닌 문자열 타입이므로, 주의를 기울여야 한다.
이 때 두 번째 인수로 반올림할 소수 부분의 자릿수까지 전달할 수 있다.

```sql
SELECT FORMAT(123456789.123456, 3);
```


<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-b552f2e94339419590368f3a11c8eaa3
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_builtInFunction_string](http://www.tcpschool.com/mysql/mysql_builtInFunction_string)
