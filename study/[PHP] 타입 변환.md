# [PHP] 타입 변환

**자동 타입 변환(type juggling)**

PHP에서는 변수를 선언할 때 타입을 명시할 필요가 없다.
왜냐하면 PHP에서 변수의 타입은 해당 변수에 대입하는 값에 따라 자동으로 결정되기 때문이다. 
이렇게 타입이 상황에 따라 자동으로 변환되는 것을 자동 타입 변환이라고 한다.
따라서 PHP의 타입 강도(type strength)는 매우 약하며, 타입이 동적으로 결정된다.

```php
$var = "문자열"; // string
$var = 10;       // int
$var = 3.14;     // float
```

---

**강제 타입 변환(type casting)**

PHP에서는 변수에 값을 대입할 때마다 변수의 타입이 그것에 맞게 변하게 된다.
하지만 사용자가 직접 데이터의 타입을 변환해야 할 경우도 많다.

PHP에서는 이러한 강제 타입 변환을 타입 캐스트 연산자인 괄호(())를 사용하여 수행할 수 있다. 
변환시키고자 하는 데이터나 변수의 앞에 괄호를 붙이고, 그 괄호 안에 변환할 타입을 적으면 된다.

```php
$var_01 = 10;
var_dump($var_01);           // int(10)  
$var_02 = (boolean) $var_01;
var_dump($var_02);           // bool(true)

$var_03 = 0;
var_dump($var_03);           // int(0)  
$var_04 = (boolean) $var_03;
var_dump($var_04);           // bool(false)
```

---

**가변 변수(variable variables)**

PHP에서는 변수의 타입 뿐만 아니라 변수의 이름까지 동적으로 바꿀 수 있다. 
이러한 변수를 가진 변수를 가변 변수라고 하며,  해당 변수의 값을 또 다른 변수의 이름으로 
취급한다.

```php
$PHP = "HTML";
$HTML = "CSS";
$CSS = "JavaScript";
$JavaScript = "Ajax";
$Ajax = "PHP";  

echo $PHP;       // HTML
echo $$PHP;      // $HTML -> CSS
echo $$$PHP;     // $$HTML -> $CSS -> JavaScript
echo $$$$PHP;    // $$$HTML -> $$CSS -> $JavaScript -> Ajax
echo $$$$$PHP;   // $$$$HTML -> $$$CSS -> $$JavaScript -> $Ajax -> PHP
echo $$$$$$PHP;  // $$$$$HTML -> $$$$CSS -> $$$JavaScript -> $$Ajax -> $PHP -> HTML
echo $$$$$$$PHP; // $$$$$$HTML -> $$$$$CSS -> $$$$JavaScript -> $$$Ajax -> $$PHP -> $HTML -> CSS ...
```

위의 예제에서 알 수 있듯이 PHP에서는 달러($) 기호를 사용하여 변수의 이름을 유동적으로 
설정하거나 사용할 수 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-10f8b2102de24dc4b555c51c33ae8a2a?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_basic_typeJuggling](http://www.tcpschool.com/php/php_basic_typeJuggling)
