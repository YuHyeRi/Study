# [**MySQL] UPDATE**

**UPDATE**

MySQL에서는 UPDATE문을 사용하여 레코드의 내용을 수정할 수 있다.

```sql
UPDATE 테이블이름
SET 필드이름1=데이터값1, 필드이름2=데이터값2, ...
WHERE 필드이름=데이터값
```

UPDATE문은 해당 테이블에서 WHERE절의 조건을 만족하는 레코드의 값만을 수정한다.

다음 예제는 Reservation테이블에서 Name 필드의 값이 ‘홍길동’인
모든 레코드의 RoomNum 값을 2002로 변경하는 예제이다.

```sql
UPDATE Reservation
SET RoomNum = 2002
WHERE Name = '홍길동';
```


만약 WHERE 절으르 생략하면 해당 테이블의 모든 레코드의 RoomNum 필드의 값이 2002로 
변경된다.

```sql
UPDATE Reservation
SET RoomNum = 2002;
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-UPDATE-55d2ac3219184885981f8e31cdd03202
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_update](http://www.tcpschool.com/mysql/mysql_basic_update)
