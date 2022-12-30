# [MySQL,PHP] **MySQL 연결**

**서버와의 연결**

PHP를 사용하여 MySQL 데이터베이스에 접속하기 위해서는 우선 서버와의 연결이 필요하다.
MySQLi에서는 서버와의 연결을 위해 mysqli_connect() 함수를 제공하고 있다.

다음 예제는 MySQLi를 사용하여 서버와 연결하는 예제이다.

```php
<?php
    $servername = "localhost";
    $user = "choi";
    $password = "0219";

①  $connect = mysqli_connect($servername, $user, $password);
    if (!$connect) {
②      die("서버와의 연결 실패! : ".mysqli_connect_error());
    }
    echo "서버와의 연결 성공!";
?>
```

위의 예제의 1번 라인에서는 myslqi_connect() 함수에 서버 이름, 사용자명과 비밀번호를 전달하여 서버와의 연결을 시도한다.

만약 서버와의 연결에 실패했다면, mysqli_connect_error() 함수를 사용하여 마지막 에러 메시지를 
출력한다.

<aside>
💡 die() 함수는 인수로 전달받은 메시지를 출력하고, 현재 실행중인 PHP 스크립트를 종료시키는 함수이다.

</aside>

---

**서버와의 연결 종료**

이렇게 생성된 서버와의 연결은 PHP 스크립트가 끝나면 자동으로 같이 종료된다.
그러나 PHP 스크립트가 끝나기 전에 서버와의 연결을 종료하고 싶다면, mysqli_close() 함수를 
호출하면 된다.

```php
<?php
    mysqli_close($connect);
?>
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-PHP-MySQL-869ff66ca2494c2d8f5673742a079053
<br>
 👉🏻출처 : [http://www.tcpschool.com/mysql/mysql_php_connection](http://www.tcpschool.com/mysql/mysql_php_connection)
