# [MySQL,PHP] **MySQL SELECT**

**레코드 선택**

SELECT문을 사용하면 테이블에 저장된 레코드를 선택할 수 있다.

다음 예제는 Reservation 테이블에 저장된 모든 레코드의 Name 필드와 ReserveDate 필드의 값을 
선택하여 출력하는 PHP 예제이다.

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

①  $sql = "SELECT Name, ReserveDate FROM Reservation";
②  $result = mysqli_query($connection, $sql);
③  if (mysqli_stmt_num_rows($result) > 0) {
④      while ($row = mysqli_fetch_assoc($result)) {
⑤          echo $row['Name']."님의 예약일자 : ".$row['ReserveDate']."<br>";
        }
    } else {
        echo "검색된 결과가 없습니다.";
    }
    mysqli_close($connection);
?>
```

①번 라인에서는 Reservation 테이블에 존재하는 모든 레코드의 Name 필드와 ReserveDate 필드의 값을 선택하는 SQL 구문을 작성한다.
이렇게 작성된 SQL 구문은 ②번 라인에서 mysqli_query() 함수를 통해 실행되고, 그 결과 집합은 변수 $result에 저장된다.
③번 라인에서는 mysqli_stmt_num_rows() 함수를 사용하여 결과 집합의 총 행(row)의 수를 검사하며, 그 결과가 하나 이상일 때만 while 문을 실행시키고 있다.
④번 라인에서 mysqli_fetch_assoc() 함수는 인수로 전달받은 결과 집합에서 하나의 행(row)을 불러와 연관 배열(associative array)로 반환한다.
따라서 ⑤번 라인에서 선택한 필드의 이름을 인덱스로 사용하여 결과를 출력할 수 있게 된다.

MySQL SELECT 문에 대한 더 자세한 사항은 MySQL SELECT 문 수업에서 확인할 수 있습니다.

[MySQL SELECT 문 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_basic_select)

<aside>
💡 연관 배열(associative array)이란 배열의 인덱스를 정수가 아닌 다양한 타입으로 설정한 
배열을 의미한다.

</aside>

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-PHP-MySQL-SELECT-b3948a492c4f47c9a010bb3006ebd8df
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_php_select](http://www.tcpschool.com/mysql/mysql_php_select)
