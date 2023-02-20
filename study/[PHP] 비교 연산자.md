# [PHP] 비교 연산자

**비교 연산자(comparison operator)**

비교 연산자는 피연산자 사이의 상대적인 크기를 판단하여 참과 거짓을 반환한다. 
비교 연산자는 모두 두 개의 피연산자를 가지는 이항 연산자이며 피연산자들의 결합 방향은 
왼쪽에서 오른쪽이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5139bd2e-5e65-47f7-98c8-a84bba1aeeba/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230220%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230220T030632Z&X-Amz-Expires=86400&X-Amz-Signature=1c4830ba08d8697de4147c74e56511dd8a717e8c9304da4d0fc210015a8793c7&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<aside>
💡 !=와 <> 연산자는 정확히 같은 동작을 하며, 연산자의 우선순위에서만 차이가 발생한다.

</aside>

```php
$num_01 = 3;
$num_02 = 3.0;
$num_03 = 3;

var_dump($num_01 == $num_02);  // true
var_dump($num_01 === $num_02); // false
var_dump($num_01 != $num_03);  // false
```

위의 예제에서 변수 $num_01과 $num_02의 값은 3으로 서로 같지만, 
타입은 각각 정수와 실수로 서로 다르다.

따라서 동등 연산자(==, equal)와 일치 연산자(===, strict equal)의 결과가 다르게 반환된다.

---

**다양한 타입의 비교**

PHP에서는 다양한 타입의 값을 서로 비교해야 할 때 다음 규칙에 따라 비교한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/3766a6bd-0bfe-493d-bf5e-dfc311f164b8/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230220%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230220T030644Z&X-Amz-Expires=86400&X-Amz-Signature=b7bb86477b41ebe3a85ff68022b459b75e4fcf9f5ec3e1891eef8e9ed66dd0b7&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
① var_dump(0 < true);           // true
② var_dump("123abc" == 123);    // true
③ var_dump("123abc" === 123);   // false

$arr_01 = array("a" => 10)
$arr_02 = array("a" => 5);
$arr_03 = array("a" => 5, "c" => 7);

④ var_dump($arr_01 >= $arr_02); // true
⑤ var_dump($arr_01 >= $arr_03); // false
⑥ var_dump("문자열" < $arr_01); // true
```

위 예제의 ①번 라인에서는 불리언 타입과 숫자 0을 비교하므로, 숫자 0은 불리언 false 값으로 
변환되어 비교된다.
②번 라인에서는 문자열과 숫자를 비교하므로, 숫자로 시작되는 문자열 "123abc"는 숫자 123으로 
변환되어 비교된다.
이때 만약 문자열이 위의 예제처럼 숫자가 아닌 영문자나 언더스코어(_)로 시작하면, 숫자 0으로 
변환되어 비교될 것이다.
하지만 ③번 라인에서 알 수 있듯이 문자열이 숫자로 변환되어 비교된다고 해도 해당 타입까지 
변하는 것은 아니다.
위 예제의 ④번 라인에서는 배열끼리 비교하므로, 배열의 길이가 같은 경우에는 같은 키를 가지는 
값을 서로 비교한다.
하지만 ⑤번 라인처럼 배열의 길이가 다른 경우에는 배열 요소의 수가 적은 쪽이 작다고 판단된다.
⑥번 라인에서처럼 배열이랑 다른 타입을 비교하면, 언제나 배열이 크다고 판단된다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-8ca63f790a164315a89bd468fc60d991?pvs=4
<br>
 👉 출처 : [http://www.tcpschool.com/php/php_operator_comparison](http://www.tcpschool.com/php/php_operator_comparison)
