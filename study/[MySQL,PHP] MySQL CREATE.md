# [MySQL,PHP] **MySQL CREATE**

**데이터베이스 생성**

MySQL의 CREATE DATABASE문은 새로운 데이터베이스를 생성할 때 사용한다.

다음 예제는 Hotel이라는 새로운 데이터베이스를 생성하는 PHP 예제이다.

```php
<?php
    $servername = "localhost";
    $user = "choi";
    $password = "0219";

    $connect = mysqli_connect($servername, $user, $password);
    if (!$connect) {
        die("서버와의 연결 실패! : ".mysqli_connect_error());
    }

①  $sql = "CREATE DATABASE Hotel";

②  if (mysqli_query($connect, $sql)) {
        echo "데이터베이스 생성 성공!";
    } else {
        echo "데이터베이스 생성 실패! : ".mysqli_error($connection);
    }
   mysqli_close($connection);
?>
```

위의 예제의 1번 라인에서는 Hotel 이라는 이름의 데이터베이스를 생성하는 SQL구문을 작성한다.
이렇게 작성한 SQL구문을 2번 라인에서는 mysqli_query() 함수에 인수로 전달하여 실행한다.

mysqli_query() 함수는 인수로 전달받은 SQL 구문을 실행하여, 그 결과를 반환하는 함수이다.
이 함수는 해당 구문의 실행에 실패하면 FALSE를 반환한다.

그리고 SELECT, SHOW, DESCRIBE, EXPLAIN 문을 성공적으로 실행했을 경우에는 해당 결과가 저장된 결과 집합인 mysqli_result 객체를 반환하며, 그 외의 구문이 성공적으로 실행되면 TRUE를 반환한다.

---

**테이블 생성**

데이터베이스는 하나 이상의 테이블로 구성되며 이러한 테이블에 데이터를 저장하여 관리할 수 
있다. MySQL의 CREATE TABLE문은 새로운 데이터베이스를 생성할 때 사용한다.

다음 예제는 4개의 필드를 갖는 Reservation 테이블을 생성하는 PHP 예제이다.

```php
<?php
    $servername = "localhost";
    $user = "choi";
    $password = "0219";
    $dbname = "testDB";

    $connect = mysqli_connect($servername, $user, $password, $dbname);
    if (!$connect) {
        die("서버와의 연결 실패! : ".mysqli_connect_error());
    }

①  $sql = "CREATE TABLE Reservation
    (
        ID INT PRIMARY KEY,
        Name VARCHAR(30) NOT NULL,
        ReservDate DATE NOT NULL,
        RoomNum INT
    )";

    if (mysqli_query($connect, $sql)) {
        echo "테이블 생성 성공!";
    } else {
        echo "테이블 생성 실패! : ".mysqli_error($connection);
    }
    mysqli_close($connection);
?>
```

위의 예제의 1번 라인에서는 4개의 필드를 갖는 Reservation 이라는 이름의 테이블을 생성하는 SQL 구문을 작성한다. 
테이블을 생성할 때는 필드의 이름 뿐만 아니라 타입, 제약조건 등을 함께 명시할 수 있다.

<aside>
💡 mysqli_error() 함수는 마지막으로 발생한 에러에 대한 정보를 문자열로 반환하는 함수이다.

</aside>

MySQL CREATE문에 대한 더 자세한 사항은 MySQL CREATE문 수업에서 확인할 수 있다.

[MySQL CREATE 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_create)

MySQL 제약조건에 대한 더 자세한 사항은 MySQL 제약조건 수업에서 확인할 수 있습니다.

[MySQL 제약조건 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_constraint_notNull)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-PHP-MySQL-CREATE-e7adc5e79b634939b90b189e0340732b
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_php_create](http://www.tcpschool.com/mysql/mysql_php_create)
