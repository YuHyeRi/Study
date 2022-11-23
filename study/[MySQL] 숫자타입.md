# [**MySQL] 숫자타입**

**타입(data type)**

MySQL에서 테이블을 정의할 때는 필드별로 저장할 수 있는 타입까지 명시해야 한다.
MySQL에서 제공하는 기본 타입은 다음과 같다.

1. 숫자 타입
2. 문자열 타입
3. 날짜와 시간 타입

---

**숫자 타입**

MySQL은 SQL표준에서 지원하는 모든 숫자 타입을 제공한다.
MySQL에서 제공하는 숫자타입은 다음과 같다.

1. 정수 타입(integer types)
2. 고정 소수점 타입(fixed-point types)
3. 부동 소수점 타입(floating-point types)
4. 비트값 타입(bit-value type)

---

**정수 타입**

MySQL은 SQL 표준 정수 타입은 INTEGER(또는 INT)와 SMALLINT를 제공한다.
또한 표준 정수 타입의 범위를 더욱 확장한 TINYINT, MEDIUMINT, BIGINT까지 제공하고 있다.

각 정수 타입에 다라 요구되는 저장 공간과 표현할 수 있는 최댓값과 최솟값까지 달라진다. 
또한 정수 타입은 음수까지 표혀할 수 있는 SIGNED 타입과 양수만을 표현할 수 있는 UNSIGNED 
타입으로도 구분된다.

MySQL 정수 타입에 다른 표현할 수 있는 최댓값, 최솟값과 요구되는 저장 공간의 크기는 다음과 
같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2a5aeec9-37f6-46a2-ab93-6053de535587/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T014903Z&X-Amz-Expires=86400&X-Amz-Signature=aa3a200a1a88c7cf4e6f3de86908c0ca727d2de5696f6aa08e7e9281a27902e6&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

다음 예제는 ALTER TABLE 문을 사용하여 Reservation 테이블에 4바이트의 정수를 저장할 수 
있는 Price 필드를 추가한다. 
이렇게 Price 필드를 추가한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 상세 정보를 확인
하면, 다음 실행 결과와 같이 나타난다.

```sql
ALTER TABLE Reservation
ADD Price INT;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_01)


그리고서 INSERT INTO문을 사용하여 Price 필드 값으로 1000을 가지는 새로운 레코드를 추가하고 
있다. 마지막으로 SELECT문을 사용하여 Reservation 테이블의 모든 레코드를 선택하여 확인한다.

---

**고정 소수점 타입**

MySQL에서 고정 소수점 타입인 DECIMAL은 실수의 값을 정확하게 표현하기 위해 사용된다.
DECIMAL에서 사용하는 고정 소수점 방식은 실수를 표현할 때 소수부의 자릿수를 고정하여 
표현한다.
즉, 소수부의 자릿수를 미리 정해 놓고, 고정된 자릿수로만 소수 부분을 표현하는 방식이다.
MySQL에서 DECIMAL 타입은 NUMERIC을 구현하여 만들어졌다.
따라서 대부분의 경우 DECIMAL 대신 NUMERIC을 사용해도 똑같이 동작한다.

```sql
DECIMAL(M,D)
```

M은 소수 부분을 포함한 실수의 총 자릿수를 나타내며, 최댓값은 65이다.
D는 소수 부분의 자릿수를 나타내며, D가 0이면 소수 부분을 가지지 않는다.

다음 예제는 ALTER TABLE 문을 사용하여 Reservation 테이블의 RoomNum 필드 타입을 고정 소수점 타입으로 변경한다.
이렇게 RoomNum 필드의 타입을 변경한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 
상세 정보를 확인하면, 다음실행 결과와 같이 나타난다.

```sql
ALTER TABLE Reservation
MODIFY COLUMN RoomNum DECIMAL(7,2);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_02)


위의 예제에서 RoomNum 필드는 -99999.99부터 99999.99까지의 실수를 저장할 수 있도록 
변경된다.
그리고서 INSERT INTO 문을 사용하여 RoomNum 필드 값으로 99999.99를 가지는 새로운 레코드를 추가한다.

---

**부동 소수점 타입**

MySQL에서 부동 소수점 타입인 FLOAT과 DOUBLE은 실수의 값을 대략적으로 표현하기 위해 
사용된다.
MySQL은 IEEE 754 표준에 따라 FLOAT는 4바이트를 사용하며, DOUBLE은 8바이트를 사용한다.
SQL 표준에서 FLOAT는 정밀도에 필요한 최소한의 비트 수를 명시할 수 있다.

```sql
FLOAT(P)
```

P가 0부터 24까지의 값을 가질 때는 FLOAT 값으로 취급되며, 25부터 53까지의 값을 가질 때는 DOUBLE 값으로 취급된다.

또한, MySQL은 FLOAT과 DOUBLE을 고정 소수점 타입과 같이 사용할 수 있는 비표준 문법도 
지원한다.

```sql
FLOAT(M,D)
DOUBLE(M,D)
```

M은 소수 부분을 포함한 실수의 총 자릿수를 나타내며, D는 소수 부분의 자릿수를 나타낸다.

다음 예제는 ALTER TABLE 문을 사용하여 Reservation 테이블의 RoomNum 필드 타입을 
부동 소수점 타입으로 변경한다.
이렇게 RoomNum 필드의 타입을 변경한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 상세 정보를 확인하면, 다음 실행 결과와 같이 나타난다.

```sql
ALTER TABLE Reservation
MODIFY COLUMN RoomNum FLOAT(7,2);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_03)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4ce1cc73-6685-44a0-ac0d-d62d5d2014cc/Untitled.png)

위의 예제에서 RoomNum 필드는 이제 -99999.99부터 99999.99까지의 실수를 저장할 수 있도록 
변경된다.
그리고서 INSERT INTO 문을 사용하여 RoomNum 필드 값으로 99999.99를 가지는 레코드를 
추가한다.
마지막으로 SELECT 문을 사용하여 Reservation 테이블의 모든 레코드를 선택하여 확인한다.
이처럼 RoomNum 필드 값으로 99999.009를 입력하면, 실수의 총 자릿수가 명시한 7자리를 초과한다.
따라서 이 값은 7자리로 맞춰지기 위해 반올림되어 99999.01로 자동 변환되어 저장된다.

---

**비트값 타입**

MySQL에서 비트값 타입인 BIT는 비트의 값을 저장한다.
즉, 0과 1로 구성되는 바이너리(binary) 값을 저장할 수 있다.

```sql
BIT(M)
```

M의 범위는 1부터 64까지 설정할 수 있으며, 명시한 M 비트의 값을 저장할 수 있다.
만약 명시한 M 비트보다 짧은 길이의 비트 값을 입력하면, 입력한 값 앞에 0을 추가하여 자동으로 
길이를 맞춘다.

다음 예제는 ALTER TABLE 문을 사용하여 Reservation 테이블에 BIT(7) 타입을 저장할 수 있는 Code 필드를 추가한다.
이렇게 Code 필드를 추가한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 상세 정보를 확인하면, 다음 실행 결과와 같이 나타난다.

```sql
ALTER TABLE Reservation
ADD Code BIT(7);
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_04](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_numeric_04)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1a3509a8-0b51-4ef0-886a-42d274328d6f/Untitled.png)

그리고서 INSERT INTO 문을 사용하여 Code 필드의 값으로 각각 b'100'과 b'100001'을 가지는 새로운 레코드를 추가한다.
이때 Code 필드의 값인 b'100'과 b'100001'은 각각 b'0000100'과 b'0100001'로 자동 변환되어 
저장된다.
마지막으로 SELECT 문을 사용하여 Reservation 테이블에서 Code 필드의 값이 NULL이 아닌 모든 
레코드를 선택한 후, 해당 레코드의 Code 필드 값을 확인한다.

<aside>
💡 이진수 b'100'은 십진수 4를 나타내며, 이진수 b'100001'은 십진수 33을 나타낸다.

MySQL에서는 이러한 바이너리 값을 출력하기 위해 BIN()와 같은 변환 함수를 제공하고 있다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-a0e7df798e07423cac85561daba6e6ce
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_datatype_numeric](http://www.tcpschool.com/mysql/mysql_datatype_numeric)
