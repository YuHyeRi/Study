# [PHP] 쿠키

**쿠키(cookie)란?**

쿠키란 엡 사이트에 접속할 때 서버에 의해 사용자의 컴퓨터에 저장되는 정보를 의미한다.

웹 사이트는 이렇게 저장된 사용자의 정보르르 클라이언트 측의 컴퓨터에 남겨서 필요할 때마다 
재사용한다.
사용자의 컴퓨터에 마치 과자 부스러기가 남아있는 것과 같다고 해서 쿠키라는 명칭이 붙었다.

현재 이러한 쿠키는 로그인 정보나 장바구니 정보를 저장하는 용도로 많이 활용되고 있다.
하지만 사용자의 정보가 컴퓨터에 고스란히 남기 때문에 사생활 침해의 우려가 있으며 보안과 관련된 이슈를 가지고 있다.

---

**쿠키 생성**

PHP에서는 setcookie() 함수를 이용하여 쿠키를 생성할 수 있다.

```php
setcookie ( $name [, $value [, $expire [, $path [, $domain [, $secure [, $httponly ]]]]]] )
```

setcookie() 함수의 매개변수 중에서 쿠키 명을 제외한 매개변수는 모두 옵션이다.
쿠키는 명시된 지속 시간이 지나면 무효가 되며 지속 시간을 전달하지 않으면 브라우저가 닫히기 
전까지 계속 유효하다.
또한 사용자가 직접 삭제하지 않는 한 브라우저에 계속 남아있다.

쿠키를 생성할 때 유효한 주소와 경로를 매개변수로 전달할 수 있다.
만약 HTTPS 프로토콜에서 사용하려면 secure값을 true로 설정해야 한다.
또한 HTTP 프로토콜에서만 사용하도록 하려면 httponly 값을 true로 설정하면 된다.

이렇게 생성된 쿠키는 $_COOKIE[”쿠키이름”]을 통해 접근할 수 있다.

```php
<?php
    $cookieName = "city";
    $cookieValue = "서울";
    setcookie($cookieName, $cookieValue, time()+60, "/"); // 쿠키가 60초 간 지속됨.
?>
...
<?php
    if(!isset($_COOKIE[$cookieName])) { // 해당 쿠키가 존재하지 않을 때
        echo "{$cookieName}라는 이름의 쿠키는 아직 생성되지 않았습니다.";
    } else {                            // 해당 쿠키가 존재할 때
        echo "{$cookieName}라는 이름의 쿠키가 생성되었으며, 생성된 값은 '".$_COOKIE[$cookieName]."'입니다.";
    }
?>
```

<aside>
💡 setcookie() 함수가 포함된 PHP 스크립트 코드는 <html> 태그보다 앞서 위치해야 한다.

</aside>

---

**쿠키 삭제**

PHP에서 unset() 함수나 setcookies() 함수를 사용하면 생성된 쿠키를 삭제할 수 있다.

```php
<?php
    $cookieName = "city";
    $cookieValue = "서울";
    setcookie($cookieName, $cookieValue, time()-60, "/"); // 쿠키를 삭제함. unset($_COOKIE["city"])와 같음.
?>
...
<?php
    echo "{$cookieName}라는 이름의 쿠키가 삭제되었습니다.";
?>
```

<aside>
💡 isset() 함수는 전달받은 변수가 설정되어 있고 그 값이 null이 아닌지를 검사한다.

</aside>
<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-c3e2a904c43d4c3ba7b632fc82bf170c?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_cookieSession_cookie](http://www.tcpschool.com/php/php_cookieSession_cookie)
