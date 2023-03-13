# [PHP] 날짜와 시간 관련 함수

**날짜와 시간의 형식화**

date 함수는 전달받은 형식에 맞춰 날짜와 시간 정보를 문자열로 반환한다.
date 함수에 인수로 전달할 수 있는 날짜와 시간 표현의 형식은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c7c54fd0-0c2e-459e-bcf4-ce2c8e7812a6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230313%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230313T015007Z&X-Amz-Expires=86400&X-Amz-Signature=b3ee9708012914d3cc0d8cd2eab4c1688b02d445fbd57a6427469207eb6ad027&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4b96a973-c80d-4017-9893-ff823a3fd7a0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230313%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230313T015023Z&X-Amz-Expires=86400&X-Amz-Signature=cfbaec2e4302d7034a28456935e2009702df3b6d3d8e0c8ef1de352c74a3df9f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/87fb6f40-7004-4789-8586-da218faf92b3/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230313%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230313T015036Z&X-Amz-Expires=86400&X-Amz-Signature=91a4ed2a0d8e144f95a09be8f325a2c6d96cfc835edaff97e0128d1543e5d585&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

타임스태프란 GMT 기준 1970년 1월 1일 0시 0분부터 지금까지의 시간을 초(second) 단위로 
나타낸 것이다.

date 함수에서는 두 번째 인수로 타임스탬프값을 전달하지 않아도 되며, 이때는 현재 날짜와 시간을 사용하게 된다.

```php
echo date("Y/m/d h:i:s");
```

---

**타임 스탬프(timestamp)**

mktime() 함수는 시, 분, 초, 월, 일, 연도를 인수로 전달받아서, 해당 날짜와 시간을 나타내는 
타임스탬프(timestamp)를 반환한다.
time() 함수는 인수를 전달받지 않고, 현재 날짜와 시간에 대한 타임스탬프를 반환한다.

```php
echo mktime(0, 0, 0, 1, 1, 2000)."<br>";  // 2000년 1월 1일을 나타내는 타임스탬프
echo mktime()."<br>";                     // 현재 날짜와 시간을 나타내는 타임스탬프
echo time();                              // 현재 날짜와 시간을 나타내는 타임스탬프
```

mktime() 함수는 호출할 때 인수를 시, 분, 초, 월, 일, 연도순으로 전달해야 하며, 오른쪽부터 
차례대로 생략할 수 있다.
이 함수에 인수를 전달하지 않으면, 현재 날짜와 시간에 대한 타임스탬프 값을 반환하며, 
따라서 time() 함수와 같은 동작을 하게 된다.

---

**날짜와 시간 정보**

getdate() 함수는 인수로 전달받은 타임스탬프에 해당하는 정보를 연관 배열의 형태로 반환한다.
getdate() 함수가 반환하는 연관 배열의 키와 값은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c47ac209-0879-45cb-88b6-44c9751340da/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230313%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230313T015049Z&X-Amz-Expires=86400&X-Amz-Signature=d2d8d63a7f3efaa013e3a1380d0ed529c0b75f497af6b4163bb6106c957f54f9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

인수를 전달하지 않으면 현재 날짜와 시간의 타임스탬프를 반환한다.

```php
$array = getdate();

foreach ($array as $key => $value) {
    echo $key." ".$value."<br>";
}
```

---

**타임 존(Time zone)**

date_default_timezone_set() 함수는 해당 스크립트에서 사용되는 날짜와 시간에 관련된 모든 함수에서 사용될 타임 존을 설정한다.
date_default_timezone_get() 함수는 현재 설정되어 있는 타임 존을 반환한다.

```php
echo date_default_timezone_get()." : ".date("h:i:s"); // 현재 타임 존과 시간을 받아옴.
date_default_timezone_set("America/Los_Angeles");     // 타임 존을 변경함.
echo date_default_timezone_get()." : ".date("h:i:s");
```

<aside>
💡 이 두 함수는 PHP 5.1.0 부터 추가된 함수이다.

</aside>

---

**날짜의 유효성 검사**

checkdate() 함수는 전달받은 날짜의 유효성을 검사한다.
이 함수에 인수로 월, 일, 연도를 전달하면, 해당 날짜가 유효한 날짜인지를 확인해 준다.

이 함수는 윤년까지 고려하여 다음과 같은 사항들을 검사한다.

1. 월이 1월부터 12월까지인지를 검사한다.
2. 일자가 해당 월에 존재하는 날짜인지를 검사한다.
3. 연도가 0에서 32767까지의 정수인지를 검사한다.

만약 전달받은 날짜가 유효하다면 true를 반환하고, 유효하지 않다면 false를 반환한다.

```php
var_dump(checkdate(1, 31, 2000)); // 유효한 날짜
var_dump(checkdate(2, 31, 2000)); // 유효하지 않은 날짜
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-d0f243ab9a684de3ab9cb034c39f1eaa?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_builtInFunction_dateTime](http://www.tcpschool.com/php/php_builtInFunction_dateTime)
