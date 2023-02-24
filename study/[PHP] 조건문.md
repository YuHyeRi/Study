# [PHP] 조건문

**PHP 표현식**

표현식은 PHP에서 가장 중요한 구성요소이다.
표현식이란 모든 것이 값을 갖는다는 의미이며, PHP에서 사용하는 거의 모든 것이 표현식에 속한다. 표현식에는 변수와 상수, 함수까지도 포함되며, 제어문이나 명령문도 모두 표현식에 속한다.

---

**제어문**

표현식 중에서도 프로그램의 순차적인 프름을 제어해야 할 때 사용하는 명령문을 제어문이라고 
한다. 이러한 제어문에는 조건문, 반복문 등이 포함된다.

---

**조건문**

조건문이란 프로그램 내에서 주어진 조건식의 결과에 따라 별도의 명령을 수행하도록 제어하는 
명령문이다. 조건문 중에서 가장 기본이 되는 명령문은 if문이다.

---

**if문**

if문은 조건식의 결과가 참이면 주어진 명령문을 실행하며, 거짓이면 아무것도 실행하지 않는다.
if문을 순서도로 표현하면 다음 그림과 같이 표현할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/36c4a821-0e39-497d-b464-6869e6857f7b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230224%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230224T034813Z&X-Amz-Expires=86400&X-Amz-Signature=c8f8fcb017cb63ee829b2b97240c78a7d3c5c6419691a984163e7c4068e12c50&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

if문의 문법은 다음과 같다.

```php
if (조건식) {
    조건식의 결과가 참일 때 실행하고자 하는 명령문;
}
```

```php
$num_01 = 10;
$num_02 = 20;
if ($num_01 == $num_02) {
    echo "{$num_01}과 {$num_02}은 같은 수입니다.";
}
if ($num_01 < $num_02) {
    echo "{$num_01}은 {$num_02}보다 작은 수입니다.";
}
if ($num_01 > $num_02) // 실행될 명령문이 한 줄뿐이라면 중괄호({})를 생략할 수 있음.
    echo "{$num_01}은 {$num_02}보다 큰 수입니다.";
```

<aside>
💡 if문에서 실행될 명령문이 한 줄뿐이라면 중괄호({})를 생략할 수 있다.

</aside>

---

**else문**

if문과 같이 사용할 수 있는 else문은 if문의 조건식 결과가 거짓일 때 주어진 명령문을 실행한다.
else문을 순서도로 표현하면 다음 그림과 같이 표현할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ce7bd5e6-c13f-4272-a427-72df609ca0ab/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230224%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230224T034831Z&X-Amz-Expires=86400&X-Amz-Signature=846cda2e225a5e760d6d69955bf260eda96f0b30e65c924e7663e26c766685a0&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

else문의 문법은 다음과 같다.

```php
if (조건식) {
    조건식의 결과가 참일 때 실행하고자 하는 명령문;
}
else {
    조건식의 결과가 거짓일 때 실행하고자 하는 명령문;
}
```

else문을 사용하면 앞선 예제를 좀 더 직관적으로 표현할 수 있다.

```php
$num_01 = 20;
$num_02 = 20;
if ($num_01 == $num_02) {
    echo "{$num_01}과 {$num_02}은 같은 수입니다.";
}
else {
    if ($num_01 < $num_02)
        echo "{$num_01}은 {$num_02}보다 작은 수입니다.";
    else // $num_01 > $num_02
        echo "{$num_01}은 {$num_02}보다 큰 수입니다.";
}
```

<aside>
💡 else문에서도 실행될 명령문이 한 줄뿐이라면 중괄호({})를 생략할 수 있다.

</aside>

---

**elseif문**

elseif문은 if문처럼 조건식을 설정할 수 있으므로 중첩된 if문을 좀 더 간결하게 표현할 수 있다.
하나의 조건문 안에서 if문과 else문은 단 한번만 사용될 수 있다.
하지만 elseif문은 여러 번 사용되어 다양한 조건을 설정할 수 있다.

<aside>
💡 C언어에서는 else if문을 작성할 때 else와 if 사이에 반드시 공백이 있어야 한다. 하지만 PHP에서 elseif와 else if 둘 다 사용할 수 있다.

</aside>

elseif문을 순서도로 표현하면 다음과 같이 표현할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c111e9f8-60fa-45c2-8fbd-22cf665e8f63/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230224%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230224T034848Z&X-Amz-Expires=86400&X-Amz-Signature=d3513e43ef5c1a77001dcb3c8d11e717664ecbc4c3d1837adb298c288380826b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

elseif문의 문법은 다음과 같다.

```php
if (조건식1) {
    조건식1의 결과가 참일 때 실행하고자 하는 명령문;
}
elseif (조건식2) {
    조건식2의 결과가 참일 때 실행하고자 하는 명령문;
}
else {
    조건식1의 결과도 거짓이고, 조건식2의 결과도 거짓일 때 실행하고자 하는 명령문;
}
```

elseif문을 사용하면 앞선 예제를 더욱 간결하게 표현할 수 있다.

```php
$num_01 = 30;
$num_02 = 20;
if ($num_01 == $num_02) {
    echo "{$num_01}과 {$num_02}은 같은 수입니다.";
}
elseif ($num_01 < $num_02) {
    echo "{$num_01}은 {$num_02}보다 작은 수입니다.";
}
else { // $num_01 > $num_02
    echo "{$num_01}은 {$num_02}보다 큰 수입니다.";
}
```

<aside>
💡 elseif문에서도 실행될 명령문이 한 줄 뿐이라면 중괄호를 생략할 수 있다.

</aside>

---

**삼항 연산자에 의한 조건문**

PHP에서는 C언어와 마찬가지로 간단한 if/else문을 삼항 연산자를 이용하여 간단히 표현할 수 있다.
삼항 연산자에 대한 더 자세한 수업은 아래에서 확인할 수 있다.

[PHP 기타 연산자 수업 확인 =>](http://www.tcpschool.com/php/php_operator_etc)

---

**switch 문**

switch 문은 if/else 문과 마찬가지로 주어진 조건 값에 따라 프로그램이 다른 명령을 수행하도록 하는 조건문이다.
이러한 switch문은 if/else문보다 가독성 측면에서 더 좋다.

<aside>
💡 PHP의 switch문에서는 주어진 조건 값과 case절의 값을 일치 연산자(===)를 사용하여 엄격하게 비교하지 않고, 동등 연산자(==)를 사용하여 느슨하게 비교한다.

</aside>

switch문의 문법은 다음과 같다.

```php
switch (조건 값)
{
    case 값1:
        조건 값이 값1일 때 실행하고자 하는 명령문;
        break;
    case 값2:
        조건 값이 값2일 때 실행하고자 하는 명령문;
        break;
    ...
    default:
        해당 case가 없을 때 실행하고자 하는 명령문;
        break;
}
```

default절은 조건 값이 위에 나열된 어떠한 case절에도 해당하지 않을 때 실행된다. 
이 구문은 반드시 존재해야 하는 것은 아니며, 필요할 때만 선언할 수 있다.
각 case절 및 default절은 반드시 break키워드를 포함하고 있어야 한다.
break 키워드는 조건 값에 해당하는 case절이나 default 절이 실행된 뒤에 전체 switch문을 빠져나가게 해준다.

<aside>
💡 default 절의 위치가 반드시 switch문의 맨 마지막일 필요는 없다.

</aside>

break 키워드에 대한 더 자세한 사항은 PHP 기타 제어문 수업에서 확인할 수 있다.

[PHP 기타 제어문 수업 확인 =>](http://www.tcpschool.com/php/php_control_etc)

```php
$var = "오렌지";
switch ($var) {
    case "귤":
        echo "여기 있는 과일은 귤입니다.";
        break;
    case "사과":
        echo "여기 있는 과일은 사과입니다.";
        break;
    case "바나나":
        echo "여기 있는 과일은 바나나입니다.";
        break;
    default:
        echo "여기 있는 과일은 처음 보는 과일입니다.";
        break;
}
```

다음 예제와 같이 여러 개의 case 절을 사용하여 여러 개의 조건을 한 번에 표현할 수도 있다.

```php
$var = "아보카도";
switch ($var) {
    case "귤":
    case "사과":
    case "바나나":
    case "아보카도":
        echo "여기 있는 과일은 제가 먹어본 과일입니다.";
        break;
    case "파파야":
    case "두리안":
    case "석가":
        echo "여기 있는 과일은 제가 먹어보지 못한 과일입니다.";
        break;
    default:
        echo "여기 있는 것은 과일이 아닙니다.";
        break;
}
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-aa8fdec94b664e8a91782fb6d53f8af4?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_control_condition](http://www.tcpschool.com/php/php_control_condition)
