# [PHP] 반복문

**반복문**

반복문이란 프로그램 내에서 같은 명령을 일정 횟수만크므 반복하여 수행하는 명령문이다. 
프로그램이 처리하는 대부분의 코드느느 반복적인 형태가 많으므로, 반복문은 가장 많이 사용되는 명령문 중 하나이다.

PHP에서 사용되는 대표적인 반복문의 형태는 다음과 같다.

1. while문
2. do/while문
3. for문
4. foreach문

---

**while문**

while문은 특정 조건을 만족할 때까지 계속 주어진 명령문을 반복해서 실행하는 명령문이다.
while문을 순서도로 표현하는 다음 그림과 같이 표현할 수 있다. 

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1428e897-ba87-482d-a820-d4b87e202c2c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230225T024933Z&X-Amz-Expires=86400&X-Amz-Signature=64aba4aa587691d01694d074bce92c621e6cfc1fed667dbb6426c74013abbd7c&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

while문의 문법은 다음과 같다.

```php
while (조건식) {
    조건식의 결과가 참인 동안 반복적으로 실행하고자 하는 명령문;
}
```

while문은 우선 표현식이 참인지를 판단하여 참이면 내부의 명령문을 실행한다. 
내부의 명령문을 전부 실행하고 나면 다시 표현식으로 돌아와 또 한번 표현식이 참인지를 판단하게 된다.
이렇게 표현식의 검사를 통해 반복해서 실행되는 반복문을 루프(loop)라고 한다.

```php
$i = 0;
while ($i < 5) {
    echo ($i++)."<br>";
}
```

while문 내부에 표현식의 결과를 변경하는 명령문이 존재하지 않을 경우, 프로그램은 루프를 영원히 반복하게 된다.
이것을 무한 루프에 빠졌다고 하며, 무한 루프에 빠진 프로그램은 영원히 종료되지 않는다.
무한 루프는 특별 의도한 경우가 아니라면 반드시 피해야 하는 상황이다.

따라서 while문을 작성할 때는 표현식의 결과가 어느 순간에는 거짓을 갖도록 표현식을 변경하는 
명령문을 반드시 포함해야 한다.

<aside>
💡 while문에서 실행될 명령문이 한 줄 뿐이라면 중괄호({})를 생략할 수 있다.

</aside>

---

**do/while문**

while문은 루프에 진입하기 전에 먼저 표현식부터 검사한다.
하지만 do/while문은 먼저 루프를 한 번 실행한 후에 표현식을 검사한다.
즉, do/while문은 표현식의 결과와 상관없이 무조건 한 번은 루프를 실행한다.

do/while문을 순서도로 표현하면 다음 그림과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/71ec556f-1e36-4574-b31d-03c0d92dc3c0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230225T024949Z&X-Amz-Expires=86400&X-Amz-Signature=80b697e4a4d565164867eeee694b25884111d14c655310fc6a7d8678cb62afe6&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

do/while문의 문법은 다음과 같다.

```php
do {
    조건식의 결과가 참인 동안 반복적으로 실행하고자 하는 명령문;
} while (조건식);
```

```php
$i = 0;
$j = 0;
while ($i > 5) {
    echo "변수 i의 값은 ".(++$i)."입니다.<br>";
}
do { // do / while문은 조건식과 상관없이 반드시 한 번은 루프를 실행함
    echo "변수 j의 값은 ".(++$j)."입니다.<br>";
} while ($j > 5);
```

---

**for문**

for문 while문과는 달리 자체적으로 초기식, 표현식, 증감식을 모두 포함하고 있는 반복문이다. 
따라서 while문보다는 좀 더 간결하게 반복문을 표현할 수 있다.
for문을 순서도로 표현하면 다음 그림과 같이 표현할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b7d29731-b5b3-4396-a369-b2cc01ce5f99/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230225T025005Z&X-Amz-Expires=86400&X-Amz-Signature=1c1c41e31e21102978e3929c3954c93728d0205b2736645d8390f3737c1b3fef&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

for문의 문법은 다음과 같다.

```php
for (초기식; 조건식; 증감식) {
    조건식의 결과가 참인 동안 반복적으로 실행하고자 하는 명령문;
}
```

for문을 구성하는 초기식, 표현식, 증감식은 각각 생략될 수 있다.
또한 쉼표 연산자(,)를 사용하면 여러 개의 초기식이나 증감식을 동시에 사용할 수도 있다.

for문을 사용하면 앞선 예쩨의 while문을 더욱 더 간결하게 표현할 수 있다.

```php
for ($i = 0; $i < 5; $i++) {
    echo "{$i}<br>";

}
```

<aside>
💡 for문에서 실행될 명령문이 한 줄 뿐이라면 중괄호를 생략할 수 있다.

</aside>

---

**foreach문**

foreach문은 일반적인 for 문과는 전혀 다른 형태의 반복문이다.
foreach문은 배열의 모든 요소를 손쉽게 순회할 수 있도록 해준다.

이 반복문은 루프마다 배열의 각 요소를 지정된 변수에 대입한다.
이렇게 대입받은 변수를 이용하면 루프 안에서 배열의 각 요소에 순차적으로 접근할 수 있다. 
따라서 foreach문은 정확히 배열의 길이만큼 반복된다.

foreach문의 문법은 다음과 같다.

```php
foreach (배열 as 값을저장할변수) {
    실행하고자 하는 명령문;
}
```

```php
$arr = array(2, 4, 6, 8);
foreach ($arr as $value) {
    echo "변수 \$value의 현재값은 {$value}입니다.<br>";
}
unset($value);
```

<aside>
💡 위의 예제에서 변수 $value는 foreach문 내에서만 사용하는 변수이다. 따라서 foreach문의 끝난 뒤에는 unset() 함수를 사용하여 해제해주는 것이 좋다.

</aside>

다음 예제는 배열의 값 뿐만 아니라 키 값도 저장하여 활용하는 예제이다.

```php
$arr = array(
    "둘" => 2,
    "넷" => 4,
    "여섯" => 6,
    "여덟" => 8,
);
foreach ($arr as $key => $value) {
    echo "배열 \$arr에서 키값 '{$key}'에 대한 값은 {$value}입니다.<br>";
}
unset($value);
```

<aside>
💡 foreach문에서 실행될 명령문이 한 줄 뿐이라면 중괄호를 생략할 수 있다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-9d91e04e81a5474d9611df75077c5ff4?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_control_loop](http://www.tcpschool.com/php/php_control_loop)
