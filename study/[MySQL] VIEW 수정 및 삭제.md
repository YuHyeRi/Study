# [**MySQL] VIEW 수정 및 삭제**

**뷰 수정**

CREATE문을 사용하여 생성된 뷰는 ALTER문을 사용하여 수정할 수 있다

MySQL에서 뷰를 수정하는 문법은 다음과 같다.

```sql
ALTER VIEW 뷰이름 AS
SELECT 필드이름1, 필드이름2, ...
FROM 테이블이름
```

MySQL에서 뷰를 수정하는 문법은 뷰를 생성하는 문법과 거의 같다.

다음 예제는 생성된 MyView라는 이름의 뷰를 ID와 Name 필드만 가지도록 수정하는 예제이다.

```sql
ALTER VIEW MyView AS
SELECT ID, Name
FROM Reservation;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_alterDrop_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_alterDrop_01)

---

**뷰 삭제**

DROP문을 사용하여 생성된 뷰를 삭제할 수 있다.

MySQL에서 뷰를 삭제하는 문법은 다음과 같다.

```sql
DROP VIEW 뷰이름
```

다음 예제는 생성된 MyView라는 이름의 뷰를 삭제하는 예제이다.

```sql
DROP VIEW MyView;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_alterDrop_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_alterDrop_02)

---


<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-VIEW-f47e20e50c0c445587734cf9b1de1795
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_view_alterDrop](http://www.tcpschool.com/mysql/mysql_view_alterDrop)
