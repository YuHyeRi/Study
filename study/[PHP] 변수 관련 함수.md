# [PHP] 변수 관련 함수

**변수의 타입 변경**

gettype 함수는 전달받은 변수의 타입을 반환한다.
변수를 전달하면 타입에 따라 해당 타입의 이름을 문자열로 반환한다.
단 float현의 경우에는 ‘float’가 아닌 ‘double’을 반환하며, 표준 타입이 아닌 경우에는 
‘unknown type’을 반환한다.

settype 함수를 사용하면 전달받은 변수의 타입을 변경할 수 있다.
이 때 변환할 타입으로는 boolean, integer, string, array, object를 사용할 수 있다. 
또한 PHP 4.2.0부터는 float와 null 타입도 사용할 수 있다.
settype 함수는 전달받은 변수의 타입을 성공적으로 변경하면 true를 반환하고, 그러지 못했을 경우에는 false를 반환한다.

```php
$x = 5;
echo gettype($x);      // integer

settype($x, "string");
echo gettype($x);      // string
```

<aside>
💡 PHP 4.2.0부터는 ‘boolean’ 대신에 ‘bool’을 사용할 수 있으며, ‘integer’ 대신에 ‘int’를 대신 사용할 수 있다.

</aside>

gettype 함수는 내부적으로 문자열을 비교하기 때문에 실행 속도가 느리다.
또한 앞으로 나올 PHP 버전에서 반환되는 문자열이 바뀔 수 있으므로, 변수가 어떤 타입인지를 
검사할 때는 다음과 같은 함수를 사용하는 것이 더 좋다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/68298ba5-3b71-4eaf-9a1c-c42acd6c8b17/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230309%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230309T044913Z&X-Amz-Expires=86400&X-Amz-Signature=ea3f2ab17b70977ff97f5302c2cc819e5aa8a8f40cb2a82775654db9ec311f86&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<aside>
💡 is_scalar 함수로 확인할 수 있는 PHP에서의 스칼라값은 integer, float, string, boolean 타입의 값을 의미한다. PHP에서 array, object, resource 타입의 값은 스칼라값이 아니다.

</aside>

---

**변수의 상태 변경**

isset 함수는 전달받은 변수가 선언되어 있는지를 검사한다.
선언된 변수가 존재하면 true를, 존재하지 않으면 false를 반환한다.

unset 함수는 전달받은 변수를 제거한다.

empty 함수는 전달받은 변수가 비어있는지를 검사한다.
전달받은 변수가 존재하고, 해당 변수가 비어있지 않으면 false를 반환한다.

PHP에서는 다음과 같은 값을 가지는 변수를 비어있다고 인식한다.

- 정수 0
- 실수 0.0
- 문자열 “0”
- 빈 문자열 “”
- null
- false
- 빈 배열 array()
- 초기화되지 않은 변수

```php
$var;
var_dump(isset($var)); // false
var_dump(empty($var)); // true

$var = 5;
var_dump(isset($var)); // true
var_dump(empty($var)); // false

$var = 0;
var_dump(isset($var)); // true
var_dump(empty($var)); // true

unset($var);
var_dump(isset($var)); // false
var_dump(empty($var)); // true
```

위의 예제에서 변수 $var를 선언만 하고 초기화하지 않은 상태에서 isset 함수에 인수로 전달하면 false를 반환한다.
하지만 초기화를 수행한 후에 isset 함수에 인수로 전달하면 true를 반환한다.
단, 정수 0과 같이 비어있는 거로 간주하는 값으로 초기화된 변수는 empty 함수가 true를 반환한다.

이 때 unset 함수로 변수 자체를 삭제하고, isset 함수에 인수로 전달하면 false를 반환한다.
또한 선언되지 않거나 삭제된 변수를 empty 함수에 인수로 전달하면 true를 반환한다. 
이것은 empty 함수가 내부적으로 다음과 같이 동작하기 때문이다.

```php
!isset($var) | $var==false
```

즉 empty 함수는 변수가 존재하지 않거나, false 값을 가질 때 모두 true를 반환한다.

---

**특정 타입으로 변경**

PHP에서는 변수를 특정 타입으로 변환하기 위해서 다음과 같은 함수를 제공한다.

intval 함수는 전달받은 변수에 해당하는 정수를 반환한다.
floatval 함수와 doubleval 함수는 전달받은 변수에 해당하는 실수를 반환한다.
strval은 전달받은 변수에 해당하는 문자열을 반환한다.

```php
$x = "123.56789abc";
echo intval($x);   // 123
echo floatval($x); // 123.56789
echo strval($x);   // 123.56789abc
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-8ebd096d019d4b50bf7400d489726392?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_builtInFunction_variable](http://www.tcpschool.com/php/php_builtInFunction_variable)
