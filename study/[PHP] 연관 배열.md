# [PHP] 연관 배열

**연관 배열(associative array)**

PHP에서는 숫자 뿐만 아니라 문자열도 배열 요소의 인덱스로 사용할 수 있다.
만약 정수와 문자열 이외에 다른 타입의 값을 키값으로 사용하면, 내부적으로 정수와 문자열로 
타입 변환이 이루어진다.

배열 인덱스에서 발생하는 타입 변환에 대한 더 자세한 사항은 PHP 기본 타입 수업에서 확인할 수 
있다.

[PHP 기본 타입 수업 확인 =>](http://www.tcpschool.com/php/php_basic_datatype)

연관 배열은 이처럼 배열의 인덱스를 정수 뿐만이 아니라 다양한 타입으로 설정한 배열을 의미한다.
이러한 연관 배열을 사용하면 키값에 좀 더 명확한 의미를 부여할 수 있다.

연관 배열을 생성하는 방법은 정수를 인덱스로 하는 배열을 생성하는 다음과 같다.

```php
$배열이름 = array();
```

---

**연관 배열의 참조**

연관 배열의 각 요소를 참조하고 싶을 때는 배열 이름과 함께 키를 사용하면 된다.
연관 배열에 특정 키 값으로 값을 저장하는 방법은 다음과 같다.

```php
$배열이름["키"] = 값;
```

```php
$array = array();        // 배열 생성
$array["apple"] = 1000;  // 연관 배열 요소 추가
$array["banana"] = 2000; 
$array["orange"] = 1500;
```

또한 연관 배열을 생성하면서 동시에 배열 요소를 초기화할 수도 있다.
이 떄는 키와 값 사이에 ‘⇒’ 를 넣어 주어 배열 요소에 저장될 키와 값을 지정할 수 있다.
이 방법을 사용하면 초기화 리스트에 따라 각각의 배열 요소가 순서대로 추가된 배열이 생성된다.

```php
$배열이름 = array("키1" => 값1, "키2" => 값2, ...);
```

다음 예제는 앞선 예제와 같은 배열을 생성과 동시에 초기화하는 예제이다.

```php
// 연관 배열 생성과 동시에 초기화
$array = array("apple" => 1000, "banana" => 2000, "orange" => 1500);
echo $array["apple"].", ".$array["banana"].", ".$array["orange"];
```

또한 생성된 연관 배열에 새로운 요소를 추가할 수도 있다.

```php
$array = array("apple" => 1000); // 연관 배열 생성과 동시에 초기화
$array["banana"] = 2000;         // 생성된 연관 배열에 요소 추가
$array["orange"] = 1500;
```

만약 해당 배열이 존재하지 않으면, 해당 이름으로 새로운 배열을 만든 후에 배열 요소를 추가한다.

```php
$array["apple"] = 1000;  // 배열이 존재하지 않으므로, 먼저 배열을 생성한 후에 요소가 추가됨.
$array["banana"] = 2000;
$array["orange"] = 1500;
echo $array["apple"].", ".$array["banana"].", ".$array["orange"];
```

---

**루프를 이용한 연관 배열로의 접근**

연관 배열의 인덱스는 숫자가 아니므로, for문을 사용하여 배열 요소에 접근할 수 없다.
대신에 foreach문이나 each 함수를 사용하여 접근해야 한다.

foreach문을 사용하면 연관 배열 요소의 키값과 요소의 값을 변수에 따로 저장하여 루프 내에서 
사용할 수 있다.

```php
$array = array("apple" => 1000, "banana" => 2000, "orange" => 1500);

foreach ($array as $key => $value) {
    echo $key." ".$value."<br>";
}
```

each 함수는 배열 커서가 현재 가리키고 있는 배열 요소를 반환하고, 다음 배열 요소를 가리키도록 한다.
이 함수는 가리키는 요소의 다음 요소가 배열의 마지막 요소라면 더는 동작하지 않는다.

```php
$array = array("apple" => 1000, "banana" => 2000, "orange" => 1500);

while($element = each($array)) {
    echo $element['key']." ".$element['value']."<br>";
}
```
<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-81d143cd72dc4d60aacffe9a71b0b3db?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_array_associative](http://www.tcpschool.com/php/php_array_associative)
