# [**MySQL] 문자열 타입**

문자열 타입

MySQL은 다양한 형태의 문자열 타입을 제공한다.

1. CHAR와 VARCHAR

2. BINARY와 VARBINARY

3. BLOB과 TEXT

4. ENUM

5. SET

---

**CHAR와 VARCHAR**

CHAR와 VARCHAR는 둘다 문자열 데이터를 저장할 수 있는 타입이다.

하지만 저장 방식과 추출 방식 그리고 최대 길이를 다루는 방식에서 차이점을 가진다.

CHAR는 문자열을 길이가 한 번 설정되면 그대로 고정되는 고정 길이의 문자열로 다룬다.

하지만 VARCHAR는 문자열을 길이가 고정되지 않는 가변 길이의 문자열로 다룬다.

```sql
CHAR(M)
VARCHAR(M)
```

M은 저장할 수 있는 문자열의 최대 길이를 나타낸다.

이때 CHAR는 0부터 255까지 설정할 수 있으며, VARCHAR는 0부터 65,535까지 설정할 수 있다.

CHAR는 설정한 크기보다 작은 길이의 문자열이 입력되면, 
나머지 공간을 공백으로 채워 길이를 M과 같게 만든다,

하지만 VARCHAR는 실제 입력된 문자열의 길이만큼만 저장하고 사용한다.

```sql
ALTER TABLE Reservation ADD Note CHAR(4);
INSERT INTO Reservation(Note) VALUES(' ');
INSERT INTO Reservation(Note) VALUES('ab');
INSERT INTO Reservation(Note) VALUES('abcd');
INSERT INTO Reservation(Note) VALUES('abcdefgh');

ALTER TABLE Reservation MODIFY COLUMN Note VARCHAR(4);
INSERT INTO Reservation(Note) VALUES(' ');
INSERT INTO Reservation(Note) VALUES('ab');
INSERT INTO Reservation(Note) VALUES('abcd');
INSERT INTO Reservation(Note) VALUES('abcdefgh');
```

위 예제에서 수행되는 각 INSERT 문의 결과와 필요한 저장 공간은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4787851c-3b18-4aeb-b388-b9f09202f2d3/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221124%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221124T094920Z&X-Amz-Expires=86400&X-Amz-Signature=15d9682e6b3a479b236365bd15016f5d7305ac03e99ee9a49e8c2364c14e72d3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

---

**BINARY와 VARBINARY**

BINARY와 VARBINARY는 각각 CHAR와 VARCHAR과 거의 비슷하다.

다만 BINARY와 VARBINARY는 문자 집합이 아닌 바이너리(binary) 데이터를 저장할 때 사용된다는 점만이 다르다.

```sql
BINARY(M)
VARBINARY(M)
```

---

**BLOB과 TEXT**

BLOB은 Binary Large Object를 의미하며 다양한 크기의 바이너리 데이터를 저장할 수 있는 타입이다.

저장할 수 있는 데이터의 최대 크기에 따라 TINYBLOB, BLOB, MEDIUMBLOB, LONGBLOB로 구분된다.

TEXT는 VARCHAR와 비슷하지만, VARCHAR와는 달리 기본값을 가질 수 없다.

또한, TEXT는 BLOB과도 비슷하지만, BLOB과는 달리 문자열의 대소문자를 구분한다.

저장할 수 있는 데이터의 최대 크기에 따라 TINYTEXT, TEXT, MEDIUMTEXT, LONGTEXT로 구분된다.

다음 예제는 ALTER TABLE 문을 사용하여 Reservation 테이블에 TEXT 타입인 Note 필드를 추가한다.

이렇게 Note 필드를 추가한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 상세 정보를 
확인하면, 다음 실행 결과와 같이 나타난다.

```sql
ALTER TABLE Reservation
ADD COLUMN Note TEXT;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_string_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_string_01)


그리고서 INSERT INTO 문을 사용하여 Note 필드 값으로 'MySQL 자료형 수업입니다.'라는 문자열을 가지는 새로운 레코드를 추가한다.

마지막으로 SELECT 문을 사용하여 Reservation 테이블의 모든 레코드를 선택하여 확인한다.

---

**ENUM**

ENUM은 미리 정의한 집합 안의 요소 중 하나만을 저장할 수 있는 타입이다.

ENUM을 사용하면 가독성을 높일 수 있으며, 특정 숫자에 문자열로 의미를 부여할 수 있다.

ENUM 목록 집합은 최대 65,535개의 ENUM 데이터를 포함할 수 있다.

이렇게 설정된 ENUM 데이터는 내부적으로 정수로 변환되어 인식된다.

```sql
ENUM('데이터값1','데이터값2',...)
```

다음 예제는 ALTER TABLE 문을 사용하여 Reservation 테이블에 4개의 값 중 하나를 가질 수 있는 ENUM 형인 RoomType 필드를 추가하는 예제이다.

이렇게 RoomType 필드를 추가한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 상세 정보를 확인하면, 다음 실행 결과와 같이 나타난다.

```sql
ALTER TABLE Reservation
ADD COLUMN RoomType ENUM('Single', 'Twin', 'Double', 'Triple');
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_string_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_string_02)


그리고서 INSERT INTO 문을 사용하여 RoomType 필드의 값으로 
각각 문자열 'Single'과 정수 2를 가지는 새로운 레코드를 추가한다.

마지막으로 SELECT 문을 사용하여 Reservation 테이블의 모든 레코드를 선택하여 확인한다.

위의 예제에서 ENUM 목록 집합의 각 데이터는 내부적으로 0부터 시작하여 1씩 증가하며 
각각 대응된다.

단, 0은 빈 문자열('')과 대응되며, 1부터 집합의 첫 번째 요소와 대응된다.

따라서 'Single'은 그대로 'Single'이라는 문자열로 저장되지만, 
정수 2는 문자열인 'Twin'으로 변환되어 저장된다.

---

**SET**

SET은 미리 정의한 집합 안의 요소 중 여러 개를 동시에 저장할 수 있는 타입이다.

SET 목록 집합은 최대 64개의 SET 데이터를 포함할 수 있다.

```sql
SET('데이터값1', '데이터값2', ...)
```

다음 예제는 ALTER TABLE 문을 사용하여 Reservation 테이블에 3개의 값 중 여러 개를 가질 수 있는 SET 형인 Request 필드를 추가하는 예제이다.

이렇게 Request 필드를 추가한 후에 DESCRIBE 문을 사용하여 Reservation 테이블의 상세 정보를 
확인하면, 다음 실행 결과와 같이 나타난다.

```sql
ALTER TABLE Reservation
ADD COLUMN Request SET('Breakfast', 'Extra Bed', 'Non-Smoking');
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_string_03](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_datatype_string_03)


그리고서 INSERT INTO 문을 사용하여 Request 필드 값으로 'Breakfast,Extra Bed'라는 문자열을 
가지는 새로운 레코드를 추가한다.

마지막으로 SELECT 문을 사용하여 Reservation 테이블의 모든 레코드를 선택하여 확인한다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-14a3116002f2416abadd77dce52713ae
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_datatype_string](http://www.tcpschool.com/mysql/mysql_datatype_string)
