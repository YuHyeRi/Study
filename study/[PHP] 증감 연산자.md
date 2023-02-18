# [PHP] 증감 연산자

**증감 연산자(increment and decrement operator)**

증감 연산자는 피연산자를 1씩 증가 혹은 감소시킬 때 사용하는 연산자이다.
이 연산자는 피연산자가 단 하나뿐인 단항 연산자이다.

증감 연산자는 해당 연산자가 피연산자의 어느 쪽에 위치하는가에 따라 연산의 순서 및 결과가 
달라진다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b0d5ef24-99c7-4cf1-af65-9dbb1c4feb73/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230218%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230218T032125Z&X-Amz-Expires=86400&X-Amz-Signature=bf68ffc17bd0bf0bbe5d1bc2830a6ccabe9dceab1cd8d8e5f4dbabc6d1489d90&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
$num_01 = 7;
$num_02 = 7;

echo "++\\$num_01 에 의한 결괏값은 ".(++$num_01 - 5)."이고, 변수의 값은 {$num_01}로 변했습니다.<br>";
echo "\\$num_02++ 에 의한 결괏값은 ".($num_02++ - 5)."이고, 변수의 값은 {$num_02}로 변했습니다.";
```

위의 예제에서 첫 번째 연산은 변수 $num_01의 값을 먼저 1 증가시킨 후에 전체 연산을 수행한다.
하지만 두 번째 연산은 먼저 모든 연산을 끝마친 후에 변수 $num_02의 값을 1 증가시킨다.

따라서 두 번째 연산에서 변수 $num_02의 증가는 전체 연산에 어떠한 영향도 미치지 않는다.

---

**증감 연산자의 연산 순서**

증감 연산자는 피연산자의 어느 쪽에 위치하는가에 따라 연산의 순서가 달라진다.

다음 예제는 증감 연산자의 연산 순서를 살펴보기 위한 예제이다.

```php
$x = 10;
$y = $x-- + 5 + --$x;

echo "변수 \\$x 의 값은 ".$x."이고, 변수 \\$y 의 값은 ".$y."으로 변경되었습니다.";
```

다음 그림은 위의 예제에서 수행되는 연산의 순서를 보여준다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2a2f34b9-1054-4c3a-b38a-15645e0a47b6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230218%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230218T032136Z&X-Amz-Expires=86400&X-Amz-Signature=30e8317ef0a91c1c6ccd46bec3db8b66e080e2017e02d17827f44dd511413197&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

① : 첫 번째 감소 연산자(decrement operator)는 피연산자의 뒤쪽에 위치하므로, 덧셈 연산이 
먼저 수행된다.
② : 덧셈 연산이 수행된 후에 감소 연산이 수행된다. ($x의 값 : 9)
③ : 두 번째 감소 연산자는 피연산자의 앞쪽에 위치하므로, 덧셈 연산보다 먼저 수행된다. 
($x의 값 : 8)
④ : 감소 연산이 수행된 후에 덧셈 연산이 수행된다.
⑤ : 마지막으로 변수 $y에 결괏값의 대입 연산이 수행됩니다. ($y의 값 : 23)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-68eee7ab9b62425eb5e7802915841397?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_operator_incAndDec](http://www.tcpschool.com/php/php_operator_incAndDec)
