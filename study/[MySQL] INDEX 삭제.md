# [**MySQL] INDEX 삭제**

**인덱스 삭제**

ALTER문을 사용하여 테이블에 추가된 인덱스를 삭제할 수 있다.
MySQL에서 인덱스를 삭제하는 방법은 다음과 같다.

1. ALTER 
2. DROP

---

**ALTER문으로 인덱스 삭제하기**

*문법*

```sql
ALTER TABLE 테이블명
DROP INDEX 인덱스명
```

다음 예제는 Reservation 테이블에서 NameIdx라는 이름의 인덱스를 삭제하는 예제이다.

```sql
ALTER TABLE Reservation
DROP INDEX NameIdx;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_drop_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_drop_01)

---

**DROP문으로 인덱스 삭제하기**

*문법*

```sql
DROP INDEX 인덱스명
ON 테이블명
```

DROP문은 내부적으로 ALTER문으로 자동 변환되어 명시된 이름의 인덱스를 삭제해준다.

다음 예제는 Reservation 테이블에서 IdIdx라는 이름의 인덱스를 삭제하는 예제이다.

```sql
DROP INDEX IdIdx
ON Reservation;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_drop_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_index_drop_02)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-INDEX-30f8152457ec461c9368e0fc5bc9252a
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_index_drop](http://www.tcpschool.com/mysql/mysql_index_drop)
