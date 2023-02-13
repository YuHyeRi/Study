# [PHP] 상수

**상수(constant)**

상수란 변수와 마찬가지로 데이터를 저장할 수 있는 메모리 공간을 의미한다. 
하지만 상수가 변수와 다른 점은 한 번 선언되면 스크립트가 실행되는 동안 그 데이터를 변경하거나 해제(undefined)할 수 없다는 점이다.

---

**define 함수**

PHP에서는 define 함수를 사용하여 상수를 선언할 수 있다.

define 함수의 원형은 다음과 같다.

```php
define(상수이름, 상숫값, 대소문자구분여부)
```

세 번째 인수의 기본값은 false이다.

```php
define("PHP", "PHP 수업에 잘 오셨습니다!<br>"); // 대소문자를 구분함.(기본 설정)
echo PHP; // PHP 수업에 잘 오셨습니다!
echo php; // php
define("PHP", "<br>PHP 수업에 잘 오셨습니다!", true); // 대소문자를 구분하지 않음.
echo php; // PHP 수업에 잘 오셨습니다!
echo Php; // PHP 수업에 잘 오셨습니다!
```

이렇게 선언된 상수는 스크립트의 어디에서라도 참조할 수 있다. 
단, 해당 상수가 선언되기 이전의 스크립트 영역에서는 해당 상수를 참조할 수 없다.

```php
function defFunc()
{
    echo PHP; // PHP
    define("PHP", "PHP 수업에 잘 오셨습니다!");
    echo PHP; // PHP 수업에 잘 오셨습니다!
}
defFunc();
echo PHP;     // PHP 수업에 잘 오셨습니다!
```

위의 예제에서 상수가 선언되기 전의 영역에서 호출한 echo 함수는 해당 상수의 값을 참조하지 못한다. 또한, 함수 내부에서 선언된 상수가 함수의 호출이 종료된 후에도 사용할 수 있음을 보여준다.

---

**마법 상수(magic constants)**

PHP는 어떤 스크립트에서도 사용할 수 있는 미리 정의된 다양한 상수를 제공한다.

다음 예제는 PHP에서 미리 정의된 모든 상수를 출력해주는 예제이다.

```php
echo "<pre>";
print_r(get_defined_constants(true));
echo "</pre>";
```

PHP는 위와 같이 미리 정의된 상수 이외에도 어디에 사용하느냐에 따라 용도가 변경되는 8개의 마법 상수를 제공한다.
이러한 마법 상수는 대소문자를 구분하지 않는다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/acdb6069-39a7-4454-a2c1-66b418797272/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230213%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230213T025925Z&X-Amz-Expires=86400&X-Amz-Signature=74947071b5a954ce0b2eea3e085838bf5e60a240f1d9e9f45ede8d9bbda5f746&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
function magicCons() {
    echo __LINE__;     // 파일의 현재 줄 번호를 반환함.
    echo __FUNCTION__; // 함수의 이름을 반환함.
    echo __METHOD__;   // 클래스의 메소드 이름을 반환함.
}
magicCons();
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-51dae100727442c2b664d5df38f66939?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_basic_constants](http://www.tcpschool.com/php/php_basic_constants)
