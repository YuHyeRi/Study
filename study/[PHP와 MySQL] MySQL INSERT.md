# [PHP와 MySQL] MySQL INSERT

**레코드 추가**

새로운 데이터베이스와 테이블을 생성한 후에는 INSERT INTO문을 사용하여 테이블에 새로운 
레코드를 추가할 수 있다.

다음 예제는 Reservation 테이블에 새로운 레코드를 추가하는 PHP 예제이다.

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
       // VALUES 절을 통해 전달한 데이터로 Reservation 테이블에 새로운 레코드를 추가하는 SQL 구문
①      $sql = "INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(5, '이순신', '2016-02-16', 1108)";
②      $connect->exec($sql);
        echo "레코드 추가 성공!";
    }
    catch(PDOException $ex)
    {
        echo "레코드 추가 실패! : ".$ex->getMessage()."<br>";
    }
    $connect = null;
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에 새로운 레코드를 추가하는 SQL 구문을 작성한다.
이때 VALUES 절을 사용하여 새로운 레코드를 구성할 데이터를 함께 전달하고 있다.
이렇게 작성한 구문을 ②번 라인의 exec() 메소드에 인수로 전달하여 실행하고 있다.

<aside>
💡 문자열 데이터에는 따옴표를 사용해야 하며 숫자 데이터에는 따옴표를 사용하지 않아도 된다.

</aside>

MySQL INSERT 문에 대한 더 자세한 사항은 MySQL INSERT 문 수업에서 확인할 수 있다.

[MySQL INSERT 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_insert)

---

**여러 레코드 추가**

여러 레코드를 한번에 추가하고 싶을 때는 beginTransaction 메소드로 새로운 트랜젝션을 시작할 수 있다.
그리고 commit 메소드로 해당 트랜젝션을 커밋(commit)할 수 있다.

<aside>
💡 트랜젝션이란 데이터베이스에서 데이터의 일관성을 보장하기 위해 사용하는 가장 작은 작업 단위이다.

</aside>

<aside>
💡 커밋이란 해당 트랜젝션의 내용을 데이터베이스에 영구히 반영하는 것을 의미한다. 즉, 커밋이 된 이후에는 데이터베이스의 내용을 해당 트랜젝션 이전으로 되돌릴 수 없다.

</aside>

다음 예제는 Reservation 테이블에 여러 개의 새로운 레코드를 한 번에 추가하는 PHP 예제이다.

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
①      $connect->beginTransaction(); // 새로운 트랜젝션을 시작함.
②      $connect->exec("INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(1, '홍길동', '2016-01-05', 2014)");
③      $connect->exec("INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(2, '임꺽정', '2016-02-12', 918)");
④      $connect->exec("INSERT INTO Reservation(ID, Name, ReserveDate, RoomNum) VALUES(3, '장길산', '2016-01-16', 1208)");
⑤      $connect->commit();           // 해당 트랜젝션을 커밋(commit)함.
        echo "레코드 추가 성공!";
    }
    catch(PDOException $ex)
    {
        echo "레코드 추가 실패! : ".$ex->getMessage()."<br>";
    }
    $connect = null;
?>
```

위 예제의 ①번 라인에서는 beginTransaction() 메소드를 호출하여 자동 커밋 모드(autocommit mode)의 사용을 중지하고, 새로운 트랜젝션을 시작한다.
따라서 ②, ③, ④번 라인에서 exec() 메소드를 호출해도 해당 트랜젝션을 자동으로 커밋(commit)하지 않을 것이다.
즉, ⑤번 라인처럼 commit() 메소드를 호출해야만 비로서 해당 트랜젝션을 데이터베이스에 커밋(commit)하게 된다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-MySQL-MySQL-INSERT-30b2e0c5c11745e1873352ae1b9e400e?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_mysql_insert](http://www.tcpschool.com/php/php_mysql_insert)
