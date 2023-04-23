# [PHP와 MySQL] MySQL UPDATE

**레코드 수정**

MySQL에서는 UPDATE문을 사용하여 레코드의 내용을 수정할 수 있다.

다음 예제는 Reservation 테이블의 레코드의 내용을 수정하는 PHP 예제이다.

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
       // SET 절을 통해 전달한 데이터로 Reservation 테이블의 레코드를 수정하는 SQL 구문
①      $sql = "UPDATE Reservation SET RoomNum = 2002 WHERE Name = '홍길동'";
②      $statement = $connect->prepare($sql);
③      $statement->execute();
④      echo $statement->rowCount()."개의 레코드 수정 성공!";
    }
    catch(PDOException $ex)
    {
        echo "레코드 수정 실패! : ".$ex->getMessage()."<br>";
    }
    $connect = null;
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에 저장된 Name 값이 '홍길동'인 레코드의 RoomNum 값을 2002로 수정하는 SQL 구문을 작성한다.
이렇게 작성된 SQL 구문은 ②번 라인에서 prepare() 메소드를 통해 준비된 상태로 설정된다.
③번 라인에서는 이렇게 준비된 상태인 SQL 구문을 PDOStatement 클래스의 execute() 메소드를 
사용하여 실행하고 있다.

<aside>
💡 prepare() 메소드는 인수로 전달받은 SQL 구문을 준비된 상태로 설정하고 이에 해당하는 PDOStatement 객체를 반환한다.

</aside>

<aside>
💡 execute() 메소드는 준비된 SQL 구문을 실행하고 해당 구문에 의해 영향을 받은 레코드의 개수를 반환한다.

</aside>

MySQL UPDATE 문에 대한 더 자세한 사항은 MySQL UPDATE 문 수업에서 확인할 수 있다.

[MySQL UPDATE 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_update)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-MySQL-MySQL-UPDATE-7cb901970779448d83f7e87607f59d68?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_mysql_update](http://www.tcpschool.com/php/php_mysql_update)
