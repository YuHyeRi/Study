# [MySQL,PHP] **MySQL UPDATE**

**레코드 수정**

UPDATE문을 사용하면 테이블에 저장된 레코드의 내용을 수정할 수 있다.

다음 예제는 Reservation 테이블의 레코드의 내용을 수정하는 PHP 예제이다.

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

    // SET 절을 통해 전달한 데이터로 Reservation 테이블의 레코드를 수정하는 SQL 구문

①  $sql = "UPDATE Reservation
        SET RoomNum = 2002
        WHERE Name = '홍길동'";

    if (mysqli_query($connect, $sql)) {
        echo "레코드 수정 성공!";
    } else {
        echo "레코드 수정 실패! : ".mysqli_error($connection);
    }
    mysqli_close($connection);
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에 저장된 Name 값이 '홍길동'인 레코드의 
RoomNum 값을 2002로 수정하는 SQL 구문을 작성한다.

MySQL UPDATE 문에 대한 더 자세한 사항은 MySQL UPDATE 문 수업에서 확인할 수 있다.

[MySQL UPDATE 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_update)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-PHP-MySQL-UPDATE-26fb321af60b4ca79e0fe877a19f4a11
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_php_update](http://www.tcpschool.com/mysql/mysql_php_update)
