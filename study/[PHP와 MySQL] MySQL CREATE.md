# [PHP와 MySQL] MySQL CREATE

**데이터베이스 생성**

MySQL의 CREATE DATABASE문은 새로운 데이터베이스를 생성할 때 사용한다.

다음 예제는 Hotel이라는 새로운 데이터베이스를 생성하는 PHP 예제이다.

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
①      $sql = "CREATE DATABASE Hotel";
②      $connect->exec($sql);
        echo "데이터베이스 생성 성공!";
    }
    catch(PDOException $ex)
    {
        echo "데이터베이스 생성 실패! : ".$ex->getMessage()."<br>";
    }
    $connect = null;
?>
```

위 예제의 ①번 라인에서는 Hotel이라는 이름의 데이터베이스를 생성하는 SQL 구문(statement)을 
작성한다.
이렇게 작성한 SQL 구문을 ②번 라인의 exec() 메소드에 인수로 전달하여 실행하고 있다.

<aside>
💡 exec() 메소드는 인수로 전달받은 SQL 구문을 실행하고 해당 구문에 의해 영향을 받은 레코드의 개수를 반환한다.

</aside>

---

**테이블 생성**

데이터베이스는 하나 이상의 테이블로 구성되며 이러한 테이블에 데이터를 저장하여 관리할 수 
있다.
MySQL의 CREATE TABLE 문은 새로운 데이터베이스를 생성할 때 사용한다.

다음 예제는 4개의 필드를 갖는 Reservation 테이블을 생성하는 PHP 예제이다.

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
①      $sql = "CREATE TABLE Reservation
        (
            ID INT PRIMARY KEY,
            Name VARCHAR(30) NOT NULL,
            ReservDate DATE NOT NULL,
            RoomNum INT
        )";
        $connect->exec($sql);
        echo "테이블 생성 성공!";
    }
    catch(PDOException $ex)
    {
        echo "테이블 생성 실패! : ".$ex->getMessage()."<br>";
    }
    $connect = null;
?>
```

위 예제의 ①번 라인에서는 4개의 필드를 갖는 Reservation이라는 이름의 테이블을 생성하는 SQL 
구문을 작성한다.
테이블을 생성할 때는 필드의 이름뿐만 아니라 타입, 제약조건 등을 함께 명시할 수 있다.

MySQL CREATE 문에 대한 더 자세한 사항은 MySQL CREATE 문 수업에서 확인할 수 있다.

[MySQL CREATE 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_create)

MySQL 제약조건에 대한 더 자세한 사항은 MySQL 제약조건 수업에서 확인할 수 있다.

[MySQL 제약조건 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_constraint_notNull)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-MySQL-MySQL-CREATE-55261b5f9e134b7481ed9aa25bbcfb53?pvs=4
<br>

👉🏻 출처 : [http://www.tcpschool.com/php/php_mysql_create](http://www.tcpschool.com/php/php_mysql_create)
