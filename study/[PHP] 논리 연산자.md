# [PHP] 논리 연산자

**논리 연산자(logical operator)**

논리 연산자는 논리식을 판단하여, 참과 거짓을 반환한다.
and, or, xor 연산자는 두 개의 피연산자를 가지는 이항 연산자이며 피연산자들의 결합 방향은 
왼쪽에서 오른쪽이다.
! 연산자는 피연산자가 단 하나뿐인 단항 연산자이며 피연산자의 결합 방향은 오른쪽에서 왼쪽이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/aa8c9af2-74ef-4572-ad26-3aa7743d393c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230221%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230221T043025Z&X-Amz-Expires=86400&X-Amz-Signature=fa982bdc779c5dc10b477353b8757b02e16981594f88be52419508f421132011&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<aside>
💡 and와 &&연산자, or와 ||연산자는 정확히 같은 동작을 하며, 연산자의 우선순위에서만 차이가 발생한다.

</aside>

다음은 논리 연산자의 모든 동작의 결과를 보여주는 진리표(truth table)이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/94ee509f-fad0-46ea-88de-c8cd72191a6c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230221%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230221T043047Z&X-Amz-Expires=86400&X-Amz-Signature=162abf0bccb5aa734aae637615bd0eb5fbeedbbafb047bfa90d113d0f0726568&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
$num_01 = true;
$num_02 = false;

var_dump($num_01 and $num_02);      // true and false -> false
var_dump($num_01 or $num_02);       // true or false -> true
var_dump($num_01 xor $num_02);      // true xor false -> true
var_dump( (3 < 5) or ("12" > 20) ); // true or false -> true
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-e6178174662941018e72f826efa564dc?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_operator_logic](http://www.tcpschool.com/php/php_operator_logic)
