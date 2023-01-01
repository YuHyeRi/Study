# [MySQL,PHP] **MySQL INSERT**

**레코드 추가**

INSERT INTO문으르 사용하면 테이블에 새로운 레코드를 추가할 수 있다.

다음 예제는 Reservation 테이블에 새로운 레코드를 추가하는 PHP 예제이다.

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
    echo "서버와의 연결 성공!";

    // VALUES 절을 통해 전달한 데이터로 Reservation 테이블에 새로운 레코드를 추가하는 SQL 구문

①  $sql = "INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum)
        VALUES(5, '이순신', '2016-02-16', 1108)";

    if (mysqli_query($connect, $sql)) {
        echo "레코드 추가 성공!";
    } else {
        echo "레코드 추가 실패! : ".mysqli_error($connection);
    }
    mysqli_close($connection);
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에 새로운 레코드를 추가하는 SQL 구문을 작성한다.
이때 VALUES 절을 사용하여 새로운 레코드를 구성할 데이터를 함께 전달하고 있다.

<aside>
💡 문자열데이터에는 따옴표를 사용해야 하며 숫자데이터에는 따옴표를 사용하지 않아도 ok

</aside>

MySQL INSERT 문에 대한 더 자세한 사항은 MySQL INSERT 문 수업에서 확인할 수 있습니다.

[MySQL INSERT 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_insert)

---

**여러 레코드 추가**

mysqli_multi_query() 함수를 사용하면, 여러 레코드를 한 번에 추가할 수 있다.
이때 각각의 INSERT 문은 반드시 세미콜론(;)으로 구분하여 하나의 문자열로 전달해야 한다.

다음 예제는 Reservation 테이블에 여러 개의 새로운 레코드를 한 번에 추가하는 PHP 예제이다.

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
    echo "서버와의 연결 성공!";

①  $sql = "INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum)
        VALUES(1, '홍길동', '2016-01-05', 2014);";

②  $sql .= "INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum)
        VALUES(2, '임꺽정', '2016-02-12', 918);";

③  $sql .= "INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum)
        VALUES(3, '장길산', '2016-01-16', 1208)";

    if (mysqli_query($connect, $sql)) {
        echo "레코드 추가 성공!";
    } else {
        echo "레코드 추가 실패! : ".mysqli_error($connection);
    }
    mysqli_close($connection);
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에 새로운 레코드를 추가하는 SQL 구문을 작성하고 있다.
그리고 ②번과 ③번 라인에서 새로운 레코드를 추가하는 SQL 구문을 더 작성하여 그것을 문자열 
형태로 추가하고 있다.
이때 SQL 구문 사이에는 세미콜론(;)이 반드시 추가되어야 한다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-PHP-MySQL-INSERT-c05a6c1a0ee8448889feca3ed94a88a0
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_php_insert](http://www.tcpschool.com/mysql/mysql_php_insert)
