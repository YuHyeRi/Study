# [**MySQL] VIEW 생성 및 대체**

**뷰(view)란?**

뷰는 데이터베이스에 존재하는 일종의 가상 테이블을 의미한다.
이러한 뷰는 실제 테이블처럼 행과 열을 가지고 있지만, 실제로 데이터를 저장하고 있지는 않다.

MySQL에서 뷰는 다른 테이블이나 다른 뷰에 저장되어 있는 데이터를 보여주는 역할만을 수행한다. 즉, 뷰를 사용하면 여러 테이블이나 뷰를 하나의 테이블처럼 볼 수 있다.

---

**뷰의 특징**

MySQL에서 뷰가 가지는 장점은 다음과 같다.

1. 특정 사용자에게 테이블 전체가 아닌 필요한 필드만을 보여줄 수 있다.
2. 복잡한 쿼리를 단순화해서 사용할 수 있다.
3. 쿼리를 재사용할 수 있다.

그러나 이러한 뷰도 다음과 같은 단점을 가지고 있다.

1. 한번 정의된 뷰는 변경할 수 없다.
2. 삽입, 삭제, 갱신 작업에 많은 제한 사항을 가진다.
3. 자신만의 인덱스를 가질 수 없다.

---

뷰의 생성

CREATE문을 사용하여 뷰를 생성할 수 있다.

MySQL에서 뷰를 생성하는 문법은 다음과 같다.

```sql
CREATE VIEW 뷰이름 AS
SELECT 필드이름1, 필드이름2, ..
FROM 테이블이름
WHERE 조건
```

뷰의 이름을 명시하고 AS키워드 다음에 SELECT문을 사용하여 해당 뷰가 접근할 수 있는 필드를 
명시한다. 이 때 WHERE절을 사용하여 특정 조건을 설정할 수도 있다.
이렇게 CREATE VIEW문은 SELECT문에서 선택된 필드를 가지는 새로운 뷰를 생성한다.

<aside>
💡 뷰는 원본 테이블과 같은 이름을 가질 수 없다.

</aside>

다음 예제는 Reservation 테이블에서 Name, ReserveDate, Dday 필드를 가지는 MyView라는 
이름의 뷰를 생성하는 예제이다.

```sql
CREATE VIEW MyView AS
SELECT Name, ReserveDate, ReserveDate - Curdate() AS Dday
FROM Reservation;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_createReplace_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_createReplace_01)

위의 예제에서 생성된 MyView의 Dday필드는 ReserveDate 필드 값과 현재 날짜와의 차이를 
계산하여 생성된다. 
따라서 여러분이 실행한 결과에서 Dday 필드의 값은 위의 실행 결과와는 약간 다를 것 이다.
이 때 사용되는 Curdate() 함수는 현재 날짜를 받아오는 함수이다.
Curdate() 함수에 대한 더 자세한 사항은 MySQL 날짜와 시간 관련 함수 수업에서 확인할 수 있다.

[MySQL 날짜와 시간 관련 함수 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_builtInFunction_dateTime)

<aside>
💡 뷰는 테이블과 마찬가지로 SELECT문을 사용하여 저장하고 있는 데이터를 확인할 수 있다.

</aside>

---

**뷰 대체**

CREATE문에 OR REPLACE절을 추가하여 기존에 존재하는 뷰를 새로운 뷰로 대체할 수 있다.

MySQ에서 뷰를 대체하는 방법은 다음과 같다.

```sql
CREATE OR REPLACE VIEW 뷰이름 AS
SELECT 필드이름1, 필드이름2, ...
FROM 테이블이름
WHERE 조건
```

CREATE OR REPLACE VIEW  문은 OR REPLACE 절이 추가된 것을 제외하면, 뷰를 생성하는 문법과 
완전히 같다.
이때 해당 뷰가 존재하지 않으면 CREATE VIEW 문과 같은 결과를 반환한다.

다음 예제는 앞선 예제에서 생성한 MyView에서 ReserveDate 필드를 RoomNum 필드로 대체하는 
예제이다.

```sql
CREATE OR REPLACE VIEW MyView AS
SELECT Name, RoomNum, Date - Curdate() AS Dday
FROM Reservation;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_createReplace_02](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_view_createReplace_02)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-VIEW-1dc1e32a232647e6b267fb47b7f43de7
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_view_createReplace](http://www.tcpschool.com/mysql/mysql_view_createReplace)
