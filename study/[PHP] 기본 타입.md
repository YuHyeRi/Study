# [PHP] 기본 타입

타입(data type)이란 프로그램에서 다룰 수 있는 값의 종류를 의미한다.
PHP에서는 여러 가지 형태의 타입을 미리 정의하여 제공하고 있으며 이것을 기본 타입이라고 한다.

PHP에서 제공하는 기본 타입은 다음과 같다.

1. 불리언(boolean)
2. 정수(integer)
3. 실수(float)
4. 문자열(string)
5. 배열(array)
6. 객체(object)
7. 리소스(resource)
8. NULL

---

**불리언(boolean)**

불리언은 참과 거짓을 표현한다.
PHP에서 불리언은 상수인 true와 false를 사용해 나타내며 대소문자를 구분하지는 않는다.

PHP에서 다음 값들은 불리언 타입으로 변환되면, 모두 false로 인식된다.

- 불리언 : false
- 정수 : 0
- 실수 : 0.0
- 빈 문자열과 문자열 “0”
- 빈 배열
- NULL

따라서 위의 값들 이외의 모든 값(음수포함)은 true로 인식된다.

```php
var_dump((bool) false);   // false
var_dump((bool) "false"); // true
var_dump((bool) 0);       // false
var_dump((bool) -100);    // true
var_dump((bool) 0.0);     // false
var_dump((bool) "");      // false
var_dump((bool) "0");     // false
var_dump((bool) array()); // false
var_dump((bool) null);    // false
```

위의 예제에서 보면 상수 false와 문자열 “false”는 전혀 다른 의미로 해석되는 것을 확인할 수 있다. 문자열 “false”는 빈 문자열이나 문자열 “0”이 아니므로 true로 인식된다.

<aside>
💡 var_dump() 함수는 인수로 전달받은 변수의 타입과 값을 구조화된 정보로 보여주는 함수이다.

</aside>

---

**정수(integer)**

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/06dc08f4-3ccc-46ac-bcba-e1d772f94c0a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230214%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230214T020921Z&X-Amz-Expires=86400&X-Amz-Signature=f9022ecdbf6630d5df914d1f7575b8b4b17c71925de5131510453de0ba922143&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
echo "integer 타입의 크기는 ".PHP_INT_SIZE."바이트 입니다.<br>";
echo "integer 타입이 표현할 수 있는 가장 큰 수는 ".PHP_INT_MAX." 입니다.<br>";
$int_01 = 100;
$int_02 = 2147483647; // integer가 표현할 수 있는 범위를 넘지 않는 값을 대입함.
$int_03 = 2147483648; // integer가 표현할 수 있는 범위를 넘는 값을 대입함.
```

위의 예제에서 상수 PHP_INT_SIZE는 정수 타입의 크기르르 나타낸다. 
따라서 상서 PHP_INT_MAX의 값은 정수 타입이 표현할 수 있는 가장 큰 수를 가리킨다. 
PHP에서는 변수에 정수의 최대 범위를 넘는 값이 대입되면, 그 변수는 자동으로 실수형으로 
인식된다.

---

**실수(float)**

실수는 소수부나 지수부를 가지는 수를 의미하며, 정수보다 더 넓은 표현 범위를 가진다. 
PHP에서 실수의 표현 범위는 운영체제에 따라 달라지지만 대략 ~1.8e307까지 표현할 수 있다.

하지만 컴퓨터에서 실수를 표현하는 방식은 반드시 오차가 존재하는 한계를 지니므로 실수형끼리 직접 값을 비교하는 것은 피하는 것이 좋다.

```php
$float_01 = 3.14;
$float_02 = 1.23e-4;
$float_03 = 1.8E307; // float이 표현할 수 있는 범위를 넘지 않는 값을 대입함.
$float_04 = 1.8E308; // float이 표현할 수 있는 범위를 넘는 값을 대입함.
```

위의 예제처럼 PHP에서는 e 지수 표현과 E 지수 표현이 모두 가능하다. 
또한 변수에 실수의 최대 범위를 넘는 값이 대입되면, 그 변수는 자동으로 미리 정의된 상수인 
INF로 인식된다.

<aside>
💡 미리 정의된 상수인 INF는 무한(infinite)이라는 값을 의미한다.

</aside>

---

**문자열(string)**

문자열은 일련의 연속된 문자(character)들의 집합을 의미한다. 
PHP에서 문자열 리터럴은 큰 따옴표(””)나 작은따옴표(’’)로 감싸서 표현한다. 
오랫동안 사용되어 온 아스키(ASCll) 인코딩 환경에서 영문자는 한 글자당 1바이트, 
한글은 한 글자당 2바이트로 표현된다. 
하지만 UTF-8 인코딩 환경에서는 영문자는 한 글자당 1바이트, 한글은 한 문자당 3바이트로 
표현된다.

```php
$str_01 = "PHP";
$str_02 = "자바스크립트";

echo strlen($str_01); // 3
echo strlen($str_02); // 18
```

<aside>
💡 strlen() 함수는 인수로 전달받은 문자열의 길이를 반환하는 함수이다.

</aside>

---

**배열(array)**

PHP에서 배열은 한 쌍의 키(key)와 값(value)으로 이루어진 맵(map)으로 구성되는 순서가 있는 집합을 의미한다.
앱의 키값으로는 정수와 문자열만이 가능하며, 하나의 배열에 두 가지 키값을 같이 사용할 수 있다. 만약, 정수와 문자열 이외에 다른 타입의 값을 키값으로 사용하면, 내부적으로 다음과 같이 타입 변환이 이루어진다.

- 불리언은 true는 1로, false는 0으로 자동 타입 변환된다.
- 유효한 숫자로만 이루어진 문자열은 정수나 실수로 자동 타입 변환된다.
- 실수는 소수 부분이 제거되고, 정수로 자동 타입 변환된다.
- NULL은 빈 문자열(””)로 자동 타입 변환된다.
- 배열과 객체는 배열의 키값으로 사용할 수 없다.

타입 변환에 대한 더 자세한 사항은 PHP 타입 변환 수업에서 확인할 수 있다.

[PHP 타입 변환 수업 확인 =>](http://www.tcpschool.com/php/php_basic_typeJuggling)

```php
$arr = array(
    1 => "첫 번째 값",   // PHP의 배열에서 키값의 1과 "1"은 같은 값을 나타냄.
    "1" => "두 번째 값", // 같은 키값을 사용하여 두 번 선언했기 때문에 나중에 선언된 "두 번째 값"만 남게됨.
    10 => "세 번째 값",
    -10 => "네 번째 값"
);
var_dump($arr);
echo $arr[1];
echo $arr["1"];
echo $arr[10];
echo $arr[-10];
```

위의 예제에서 첫 번쨰 배열 요소의 키값인 1과 두 번째 배열 요소의 키값인 “1”은 같은 값으로 저장된다. PHP에서는 같은 키값으로 여러번 맵(map)을 선언할 경우, 그 키에 해당하는 값을 계속 
덮어써서 맨 마지막에 선언된 값만을 저장하게 된다.

배열에 대한 더 자세한 사항은 PHP 배열 수업에서 확인할 수 있다.

[PHP 배열 수업 확인 =>](http://www.tcpschool.com/php/php_array_basic)

---

**객체(object)**

객체는 클래스의 인스턴스(instance)를 저장하기 위한 타입이다. 
이러한 객체는 프로퍼티(properties)와 메소드(methods)를 포함할 수 있다.

```php
class Lecture {
    function Lecture() {
        $this->lec_01 = "PHP";
        $this->lec_02 = "MySQL";
    }
}
$var = new Lecture; // 객체 생성
echo $var->lec_01;  // 객체의 속성 접근
echo "<br>";
echo $var->lec_02;
```

클래스와 객체에 대한 더 자세한 사항은 PHP 클래스와 객체 수업에서 확인할 수 있다.

[PHP 클래스와 객체 수업 확인 =>](http://www.tcpschool.com/php/php_classObject_basic)

---

**리소스(resource)**

리소스는 PHP 외부에 존재하는 외부 자원을 의미한다. 
이러한 리소스는 데이터베이스 함수 등에서 데이터베이스 연결 등을 반환할 때 사용된다.

---

**NULL**

NULL은 오직 한 가지 값(NULL 상수)만을 가질 수 있는 특별한 타입이다. 
NULL 타입의 변수란 아직 어떠한 값도 대입되지 않은 변수를 의미한다.

```php
$var_01;
var_dump($var_01); // 초기화되지 않은 변수를 참조

$var_01 = 100;     // $var_01 변수를 초기화함.
var_dump($var_01);

unset($var_02);    // $var_01 변수를 삭제함.
var_dump($var_02); // 삭제된 변수를 참조
```

위의 예제처럼 PHP에서 초기화하지 않은 변수는 NULL로 자동 초기화된다. 
또한, 삭제되거나 존재하지 않는 변수를 참조할 경우에도 NULL을 반환한다.

<aside>
💡 unset() 함수는 인수로 전달받은 변수를 메모리에서 삭제하는 함수이다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-bab2e1a2a13d48cda2ace218491ccebd?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_basic_datatype](http://www.tcpschool.com/php/php_basic_datatype)
