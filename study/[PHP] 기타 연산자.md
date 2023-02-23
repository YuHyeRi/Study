# [PHP] 기타 연산자

**삼항 연산자(ternary operator)**

삼항 연산자는 유일하게 피연산자를 세 개나 가지는 조건 연산자이다.

삼항 연산자의 문법은 다음과 같다.

```php
조건식? 반환값1 : 반환값2
```

물음표 앞의 표현식에 따라 결괏값이 참이면 1을 반환하고, 결괏값이 거짓이면 반환값 2를 반환한다.

```php
$num_01 = 15;
$num_02 = 8;
$result = ($num_01 > $num_02) ? $num_01 : $num_02;

echo "둘 중에 더 큰수는 {$result}입니다.";
```

삼항 연산자는 짧은 if / else 문 대신 사용할 수 있으며 코드를 간결하게 만들어준다.
if / else 문에 대한 더 자세한 사항은 PHP 조건문 수업에서 확인할 수 있다.

[PHP 조건문 수업 확인 =>](http://www.tcpschool.com/php/php_control_condition)

---

**문자열 연산자(string operator)**

PHP에서 문자열 연산자(.)를 사용하여 문자열을 연결할 수 있다.
이 연산자는 얼핏 보기에는 연산자가 아닌 것처럼 보이지만 양쪽에 위치한 두 문자열을 연결해주는 역할을 한다.

또한 echo 함수에서는 쉼표 연산자(,)를 이용하여 문자열을 연결할 수 있다.

```php
$str_01 = "PHP 수업";
$str_02 = "에 오신것을 환영합니다!";

echo "두 문자열을 합친 문자열은 '".($str_01.$str_02)."'입니다.<br>";
echo $str_01, $str_02;
```

PHP에서는 문자열 내에 변수의 이름을 포함시켜 해당 변수의 값을 동적으로 문자열에 삽입할 수도 있다.

이에 대한 더 자세한 사항은 PHP 변수 수업에서 확인할 수 있다.

[PHP 변수 수업 확인 =>](http://www.tcpschool.com/php/php_basic_variable)

---

**배열 합집합 연산자(array union operator)**

배열 합집합 연산자(+)는 피연산자로 오는 두 배열의 합집합을 반환한다.

왼쪽 피연산자로 오는 배열의 키값은 유지하면서 거기에 맞춰 오른쪽 피연산자로 오는 배열을
 덧붙이는 방식을 취한다.

따라서 같은 키에 대한 값에는 왼쪽 피연산자로 오는 배열의 값이 저장된다.

```php
$arr_01 = array("1st" => "PHP", "2nd" => "MySQL");
$arr_02 = array("1st" => "HTML", "2nd" => "CSS", "3rd" => "JavaScript");

$result_01 = $arr_01 + $arr_02; // [PHP, MySQL, JavaScript]
var_dump($result_01);
$result_02 = $arr_02 + $arr_01; // [HTML, CSS, JavaScript]
var_dump($result_02);
```

위 예제에서 두 배열의 첫 번째와 두 번째 요소의 키값이 서로 같다.
이 때 어느 집합이 앞에 위치하는가에 따라 합집합 연산의 결과가 달라지는 것을 확인할 수 있다.

다음 예제는 연관 배열이 아닌 인덱스를 가지는 배열에서 배열 합집합 연산을 하는 예제이다.

```php
$arr_01 = array("PHP", "MySQL");
$arr_02 = array("HTML", "CSS", "JavaScript");

$result_01 = $arr_01 + $arr_02; // [PHP, MySQL, JavaScript]
var_dump($result_01);
$result_02 = $arr_02 + $arr_01; // [HTML, CSS, JavaScript]
var_dump($result_02);
```

위의 예제에서 인덱스를 가지는 배열에서도 배열 합집합 연산은 같은 결과를 반환하는 것을 확인할 수 있다.

---

**instanceof 연산자**

다음와 같은 사항을 확인하고자 할 때 사용할 수 있다.

1. 해당 변수가 어떤 클래스에서 생성된 객체(object)인지를 확인할 때
2. 해당 변수가 부모 클래스에서 상속받은 클래스인지를 확인할 때
3. 해당 변수가 클래스의 인스턴스인지 아닌지를 확인할 때
4. 해당 변수가 인터페이스로 구현한 클래스의 객체 인스턴스인지 아닌지를 확인할 때

```php
interface Interface01
{
}
class Class01
{
}
class Class02 extends Class01 implements Interface01
{
}

/* 어떤 클래스(class)에서 생성된 객체(object)인지를 확인할 때 */
$var_01 = new Class01; // Class01 클래스 객체를 생성함.
var_dump($var_01 instanceof Class01);     // true
var_dump($var_01 instanceof Class02);     // false

/* 부모 클래스(parent class)에서 상속받은 클래스인지를 확인할 때 */
$var_02 = new Class02; // Class02 클래스 객체를 생성함.
var_dump($var_02 instanceof Class01);     // true
var_dump($var_02 instanceof Class02);     // true

/* 클래스의 인스턴스(instance)인지 아닌지를 확인할 때 */
$var_03 = new Class01; // Class01 클래스 객체를 생성함.
var_dump(!($var_03 instanceof Class02));  // true

/* 인터페이스(interface)로 구현한 클래스의 객체 인스턴스(object instance)인지 아닌지를 확인할 때 */
$var_04 = new Class02; // Class02 클래스 객체를 생성함.
var_dump($var_04 instanceof Class02);     // true
var_dump($var_04 instanceof Interface01); // true
```

<aside>
💡 instanceof 연산자의 사용 용도를 자세히 알기 위해서는 객체 지향 프로그램에 대한 기본 지식이 필요하다. 따라서 지금은 넘어가도 상관없으며 나중에 필요할 때 참고하는 것도 좋다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-434c3d3ce01a493ea5b9e0fd5500bcba?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_operator_etc](http://www.tcpschool.com/php/php_operator_etc)
