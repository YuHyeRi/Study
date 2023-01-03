# [MySQL,PHP] **MySQL DELETE**

**레코드 삭제**

DELTE문을 사용하면 테이블에 저장된 레코드를 삭제할 수 있다.

다음 예제는 Reservation 테이블에서 Name필드의 값이 ‘홍길동’인 레코드만을 삭제하는 PHP이다.

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

①  $sql = "DELETE FROM Reservation
        WHERE Name = '홍길동'";

    if (mysqli_query($connect, $sql)) {
        echo "레코드 삭제 성공!";
    } else {
        echo "레코드 삭제 실패! : ".mysqli_error($connection);
    }
    mysqli_close($connection);
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에서 Name 필드의 값이 '홍길동'인 레코드만을 
찾아 삭제하는 SQL 구문을 작성한다.

<aside>
💡 만약 DELETE 문에서 WHERE 절을 생략하면, 해당 테이블에 저장된 모든 데이터가 삭제될 것이다. 따라서 DELETE 문을 사용하여 레코드를 삭제할 때는 언제나 주의를 기울여야 한다.

</aside>

MySQL DELETE 문에 대한 더 자세한 사항은 MySQL DELETE 문 수업에서 확인할 수 있다.

[MySQL DELETE 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_delete)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-PHP-MySQL-DELETE-1dc3d0cbd6d148b886b88726e220c1c0
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_php_delete](http://www.tcpschool.com/mysql/mysql_php_delete)
