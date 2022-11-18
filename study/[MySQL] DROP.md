# [**MySQL] DROP**

**DROP**

MySQL에서는 다음과 같은 DROP문을 사용하여 데이터베이스와 테이블을 삭제할 수 있다.

1. DROP DATABASE
2. DROP TABLE

---

**데이터베이스 삭제**

DROP DATABASE 문은 해당 데이터베이스를 삭제해준다.

```sql
DROP DATABASE 데이터베이스이름
```

<aside>
💡 데이터베이스를 삭제하면 해당 데이터베이스의 모든 테이블과 데이터도 다 같이 삭제되므로 주의해야 한다.

</aside>

다음 예제는 Hotel 데이터베이스를 삭제하는 예제이다.

```sql
DROP DATABASE Hotel;
```

---

**테이블 삭제**

DROP TABLE 문은 해당 테이블을 삭제해준다.

```sql
DROP TABLE 테이블이름
```

<aside>
💡 테이블을 삭제하면 해당 테이블의 모든 데이터도 다 같이 삭제되므로 주의해야 한다.

</aside>

만약 테이블 자체가 아닌 테이블의 데이터만을 지우고 싶을 때는 
TRUNCATE TABLE문을 사용할 수 있다.

이 구문을 사용하면 테이블 자체는 그대로 남게 되며, 
해당 테이블에 저장된 데이터만이 모두 삭제된다.

```sql
TRUNCATE TABLE 테이블이름
```

다음은 Reservation 테이블의 모든 데이터만을 삭제하는 예제이다.

```sql
TRUNCATE TABLE Reservation;
```

위의 예제가 실행된 후에 SELECT 문으로 Reservation 테이블의 모든 데이터를 불러오면 해당 테이블에 어떠한 데이터도 저장되어 있지 않다.

다음 예제는 Reservation 테이블의 모든 데이터뿐만 아니라 테이블 그 자체도 삭제하는 예제이다.

```sql
DROP TABLE Reservation;
```

DROP DATABASE 문이나 DROP TABLE 문을 사용하여 데이터베이스나 테이블을 삭제하려고 할 때, 
만약 삭제하려는 이름의 데이터베이스나 테이블이 존재하지 않으면 에러가 발생한다.

이 때 다음과 같이 IF EXISTS절을 사용하면 삭제하려는 데이터베이스나 테이블이 존재하지 않아서 
발생하는 에러를 미리 방지할 수 있다.

```sql
1. DROP DATABASE IF EXISTS Hotel;
2. DROP TABLE IF EXISTS Reservation;
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-DROP-209c4fd5099c40e590ba242775b82fb9
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_basic_drop](http://www.tcpschool.com/mysql/mysql_basic_drop)
