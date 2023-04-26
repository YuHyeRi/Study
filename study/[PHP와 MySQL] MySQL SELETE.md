# [PHP와 MySQL] MySQL SELETE

**레코드 선택**

MySQL에서는 SELECT문을 사용하여 테이블의 레코드를 선택할 수 있다.

다음 예제는 Reservation 테이블에 저장된 모든 레코드의 Name 필드와 ReserveDate 필드의 값을 
선택하여 출력하는 PHP 예제이다.

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
①      $sql = "SELECT Name, ReserveDate FROM Reservation";
②      foreach ($connect->query($sql) as $field) {
            echo $field['Name']."님의 예약일자 : ";
            echo $field['ReserveDate']."<br>";
        }
    }
    catch(PDOException $ex)
    {
        echo "레코드 선택 실패! : ".$ex->getMessage()."<br>";
    }
    $connect = null;
?>
```

위 예제의 ①번 라인에서는 Reservation 테이블에 존재하는 모든 레코드의 Name 필드와 ReserveDate 필드의 값을 선택하는 SQL 구문을 작성한다.
이렇게 작성된 SQL 구문은 ②번 라인의 query() 메소드를 통해 실행된다.
또한, ②번 라인에서는 query() 메소드의 반환 결과를 foreach 문을 사용하여 출력하고 있다.

<aside>
💡 query() 메소드는 인수로 전달받은 SQL 구문을 실행하고 그 결과 집합에 해당하는 PDOStatement 객체를 반환한다.

</aside>

MySQL SELECT 문에 대한 더 자세한 사항은 MySQL SELECT 문 수업에서 확인할 수 있다.

[MySQL SELECT 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_select)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-MySQL-MySQL-SELETE-8b60cd3b3d4f4cafb7783512f283f737?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_mysql_select](http://www.tcpschool.com/php/php_mysql_select)
