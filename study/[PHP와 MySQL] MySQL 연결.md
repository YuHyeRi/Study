# [PHP와 MySQL] MySQL 연결

**MySQL extension**

예전에는 PHP에서 MySQL 데이터베이스에 연결하기 위해 MySQL extension이라는 API를 사용했다. MySQL extension은 mysql_로 시작하는 다양한 함수를 사용하여 MySQL 데이터베이스를 관리할 수 있다.
하지만 이 API는 PHP 5.0부터는 사용을 권장하지 않고 있으며 PHP 7.0에서는 삭제되었다.

MySQL extension에 대한 더 자세한 사항은 MySQL 사용 수업에서 확인할 수 있다.

[MySQL 사용 수업 확인 =>](http://www.tcpschool.com/mysql/mysql_use_connect)

---

**MySQLi와 PDO**

따라서 현재 PHP에서 MySQL 데이터베이스에 연결하기 위해 사용할 수 있는 API는 다음과 같다.

1. MySQL improved extension(MySQLi extension)
2. PHP Data Objects(PDO)

위의 두 가지 API는 각각 장단점을 가지지만 MySQL 환경에서 성능상의 큰 차이를 보이지는 않는다.
따라서 자신이 사용하기 편한 API를 선택하는 것이 좋다.

MySQLi를 다운받거나 MySQLi에 대한 더 자세한 사항을 알고 싶다면 다음 링크를 참고하면 된다.

[PHP.net : MySQLi =>](http://php.net/manual/kr/book.mysqli.php)

PDO를 다운받거나 PDO에 대한 더 자세한 사항을 알고 싶다면 다음 링크를 참고하면 된다.

[PHP.net : PDO =>](http://php.net/manual/kr/book.pdo.php)

우리 수업에서는 PDO를 사용하여 MySQL 데이터베이스에 연결하고 관리하는 방법을 살펴볼 것
이다.

<aside>
💡 MySQLi는 MySQL 데이터베이스에서만 동작하지만 PDO는 MySQL를 포함한 12개의 다른 데이터베이스에서도 똑같이 동작할 것이다.

</aside>

---

**서버와의 연결**

PHP를 사용하여 MySQL 데이터베이스에 접속하기 위해서는 우선 서버와의 연결이 필요하다.

다음 예제는 PDO를 사용하여 서버와 연결하는 예제이다.

```php
<?php
    $servername = "localhost";
    $dbname = "testDB";
    $user = "choi";
    $password = "0219";

    try
    {
①      $connect = new PDO('mysql:host=$servername;dbname=$dbname', $user, $password)
②      $connect->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        echo "서버와의 연결 성공!";
    }
③  catch(PDOException $ex)
    {
        echo "서버와의 연결 실패! : ".$ex->getMessage()."<br>";
    }
?>
```

위 예제의 ①번 라인에서는 서버 이름, 데이터베이스 이름, 사용자명과 비밀번호를 전달하여 
새로운 PDO 객체를 생성한다.
②번 라인에서는 생성된 PDO 객체에 에러 모드(error mode)를 설정하고 있다.
이렇게 에러 모드를 설정하면, PDO 생성자는 에러가 발생할 때마다 PDOException 예외를 던질 것
이다.

---

**서버와의 연결 종료**

이렇게 생성된 서버와의 연결은 PHP 스크립트가 끝나면 자동으로 같이 종료된다.
하지만 PHP 스크립트가 끝나기 전에 서버와의 연결을 종료하고 싶다면 다음 예제처럼 PDO 객체에 null을 대입하면 된다.

```php
<?php
	$connect= null;
?>
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-MySQL-MySQL-f2dad05d2eba4b66957afe9c880c6311?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_mysql_connection](http://www.tcpschool.com/php/php_mysql_connection)
