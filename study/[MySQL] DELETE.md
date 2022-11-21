# [**MySQL] DELETE**

**DELETE**

MySQL에서는 DELETE문을 사용하여 테이블의 레코드를 삭제할 수 있다.

```sql
DELETE FROM 테이블이름
WHERE 필드이름=데이터값
```

DELETE문은 해당 테이블에서 WHERE절의 조건을 만족하는 레코드만을 삭제한다. 
즉, 테이블에서 명시된 필드와 그 값이 일치하는 레코드만을 삭제해준다.

만약 WHERE절을 생략하면 해당 테이블에 저장된 모든 데이터가 삭제된다.

```sql
DELETE FROM 테이블이름;
```

<aside>
💡 이 때 테이블에 저장된 모든 데이터가 삭제되더라도 테이블은 여전히 남아있게 된다. 해당 테이블까지 삭제하고 싶을 때는 DROP TABLE문을 사용해야 한다.

</aside>

다음 예제는 Reservation 테이블에서 Name 필드의 값이 ‘홍길동’인 모든 레코드를 삭제하는 
예제이다.

```sql
DELETE FROM Reservation
WHERE Name = '홍길동';
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-DELETE-9d4f90e712be4a41b6191c53fdd6fa3f
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_delete](http://www.tcpschool.com/mysql/mysql_basic_delete)
