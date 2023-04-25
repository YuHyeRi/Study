# [PHP와 MySQL] MySQL DELETE

**레코드 삭제**

MySQL에서는 DELETE문을 사용하여 테이블의 레코드를 삭제할 수 있다.

다음 예제는 Reservation 테이블에서 Name 필드의 값이 '홍길동'인 레코드만을 삭제하는 PHP 예제이다.

```php
<?php
    $servername = "localhost";
    $dbname = "testDB";
    $user = "choi";
    $password = "0219";

    try
    {
       $connect = new PDO('mysql:host=$servername;dbname=$dbname', $user, $password);
       $connect->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
①      $sql = "DELETE FROM Reservation WHERE Name = '홍길동'";
②      $connect->exec($sql);
    }
    catch(PDOException $ex)
    {
        echo "레코드 삭제 실패! : ".$ex->getMessage()."<br>";
    }
    $connect = null;
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에서 Name 필드의 값이 '홍길동'인 레코드만을 삭제하는 SQL 구문을 작성한다.
이렇게 작성한 구문을 ②번 라인의 exec() 메소드에 인수로 전달하여 실행하고 있다.

<aside>
💡 만약 DELETE문에서 WHERE절을 생략하면 해당 테이블에 저장된 모든 데이터가 삭제될 것이다. 따라서 DELETE문을 사용하여 레코드를 삭제할 때는 언제나 주의를 기울여야 한다.

</aside>

MySQL DELETE 문에 대한 더 자세한 사항은 MySQL DELETE 문 수업에서 확인할 수 있다.

[MySQL DELETE 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_delete)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-MySQL-MySQL-DELETE-049736a956194b3c9f1c41d1e0cffac6?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_mysql_delete](http://www.tcpschool.com/php/php_mysql_delete)
