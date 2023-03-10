# [PHP] 배열 관련 함수

**배열의 생성**

PHP에서 배열을 만들기 위해서는  array 함수를 사용한다.

```php
$arr = array(1, 2, 3, 4, 5);
```

---

**배열 요소의 개수**

count 함수와 sizeof 함수는 배열에 저장된 배열 요소의 개수를 반환한다.

array_count_values 함수는 전달받은 배열의 배열 요소 값을 모두 확인하여, 
해당 값이 몇 번 등장하는지를 확인한다.
그 후 배열 요소의 값을 키(key)로 하고 해당 값의 등장 빈도를 값(value)으로 하는 연관 배열을 
반환한다.

```php
$arr = array(1, 5, 7, 3, 3, 1, 2);

echo "배열 요소의 수는 ".count($arr)."입니다.";  // 7
echo "배열 요소의 수는 ".sizeof($arr)."입니다."; // 7

$acv = array_count_values($arr);                 // 1 : 2번, 5 : 1번, 7 : 1번, 3 : 2번, 2 : 1번
```

---

**배열의 탐색**

PHP 배열에는 현재 선택된 배열 요소가 어느 요소인지를 가리키는 포인터가 별도로 존재한다. 
이러한 내부 포인터를 배열 포인터라고 하며, 이 포인터는 배열이 생성되면 자동으로 배열의 첫 번째 요소를 가리킨다.

current 함수와 pos 함수는 배열 포인터가 현재 가리키고 있는 요소를 반환한다.
next 함수는 우선 배열 포인터를 앞으로 하나 이동시킨 후에, 해당 요소르르 반환한다.
prev 함수는 next 함수와는 반대로 우선 배열 포인터를 뒤로 하나 이동시킨 후에, 해당 요소를 
반환한다.
each 함수는 배열 포인터가 현재 가리키고 있는 요소의 키돠 값을 연관 배열로 반환하고, 
배열 포인터를 앞으로 하나 이동시킨다.
reset 함수는 배열 포인터가 첫 번째 요소를 가리키도록 한 뒤에 해당 요소의 값을 반환한다.
end 함수는 reset 함수와는 반대로 배열 포인터가 마지막 배열 요소를 가리키도록 한 뒤에, 
해당 요소의 값을 반환한다.

```php
$arr = array(2, 3, 7, 4, 6);

$element = current($arr);  // 배열의 첫 번째 요소를 가리킴.
while($element) {          // 배열의 마지막 요소까지
    echo $element;         // 해당 요소의 값을 출력하고,
    $element = next($arr); // 다음 요소를 가리킨 후에 해당 요소를 반환함.
}                          // 2, 3, 7, 4, 6

$element = end($arr);      // 배열의 마지막 요소를 가리킴.
while($element) {          // 배열의 첫 번째 요소까지
    echo $element;         // 해당 요소의 값을 출력하고,
    $element = prev($arr); // 이전 요소를 가리킨 후에 해당 요소를 반환함.
}                          // 6, 4, 7, 3, 2
```

---

**배열의 정렬**

sort 함수는 배열 요소들을 정렬 기준에 맞게 정렬한다.

sort 함수는 두 번째 인수로는 배열 요소를 정렬할 기준을 전달할 수 있다.
SORT_NUMERIC은 배열 요소를 숫자로 비교하며, SORT_STRING은 문자열로 비교하게 된다. 
만약 정렬 기준을 전달하지 않으면 배열 요소들의 타입을 변경하지 않고 그대로 비교하게 된다.

sort 함수는 대소문자를 구별하며 대문자가 소문자보다 앞쪽으로 정렬된다. 
이 함수는 배열 요소의 정렬에 성공하면 true를 반환하고 정렬에 실패하면 false를 반환한다.

```php
$arr = array(3, 2, 7, 6, 4);
sort($arr); // 배열 정렬 -> 2, 3, 4, 6, 7
```

다음 예제는 sort 함수를 호출하면서 정렬 기준을 인수로 함께 전달하는 예제이다.

```php
$arr = array(15, 2, 1, 21, 121);

① sort($arr, SORT_NUMERIC); // 배열 요소를 숫자로 비교함.   -> 1, 2, 15, 21, 121
② sort($arr, SORT_STRING);  // 배열 요소를 문자열로 비교함. -> 1, 121, 15, 2, 21
```

위 예제 1번 라인의 sort 함수는 배열 요소르르 숫자로 인식하고, 서로를 비교하여 정렬한다.

하지만 2번 라인의 sort 함수는 배열 요소르르 문자열로 인식하고 서로를 비교한다. 
문자열끼리의 비교는 우선 첫 번째 문자를 서로 비교한다.
따라서 첫 번째 문자가 ‘1’인 배열 요소들이 ‘2’인 배열 요소보다 앞쪽으로 정렬된다.
그 다음에는 두 번째 문자를 서로 비교하게 되는데 이 때 두 번째 문자가 없는 배열 요소는 가장 
앞쪽으로 정렬된다.
따라서 두 번째 문자가 ‘2’인 121이 두 번째 문자가 ‘5’인 15보다 앞쪽으로 위치하게 된다.

---

**연관 배열의 정렬**

연관 배열은 인덱스를 숫자가 아닌 문자열을 사용하므로, 키와 요소의 값으로 따로 정렬할 수 있다.
ksort 함수는 각 요소의 키를 기준으로 정렬한다.
또한 asort 함수는 각 요소의 값을 기준으로 정렬한다.

```php
$arr = array("apple" => 1000, "banana" => 2000, "orange" => 1500);

asort($arr); // 요소의 값을 기준으로 배열 정렬 -> apple, orange, banana
ksort($arr); // 키값을 기준으로 배열 정렬      -> apple, banana, orange
```

지금까지 살펴본 sort, ksort, asort 함수는 모두 정렬 기준에 따라 오름차순으로 배열 요소를 정렬한다.
따라서 배열 요소를 내림차순으로 정렬하기 위해서는 rsort, krsort, arsort 함수를 사용해야만 한다.

위와 같은 함수 이외에도 배열 요소를 정렬하기 위해 PHP에서 제공하는 함수는 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/862614e6-a5fa-408f-93b5-f1e12429d0f5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230310%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230310T120038Z&X-Amz-Expires=86400&X-Amz-Signature=c05c8e4b5bf26a9a2a839822d4ebbe655bdd7d89db70f8e233608f726f4962f8&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

---

**배열 요소의 재배치**

shuffle 함수는 배열 요소를 섞은 뒤에 무작위로 재배치한다.

```php
$arr = array(1, 2, 3, 4, 5);
shuffle($arr);              // 배열 요소를 무작위로 재배치함.
```

array_reverse 함수는 전달받은 배열의 순서를 역순으로 변경한 새로운 배열을 반환한다.

```php
$arr_01 = array(1, 2, 3, 4, 5);
$arr_02 = array_reverse($arr_01);       // 배열 요소를 역순으로 바꾼 새로운 배열을 반환함.

for($i = 0; $i < count($arr_02); $i++){ // 새로 생성된 배열인 $arr_02의 모든 요소를 출력함.
    echo $arr_02[$i].", ";              // 5, 4, 3, 2, 1
}

for($i = 0; $i < count($arr_01); $i++){ // 원본 배열인 $arr_01의 모든 요소를 출력함.
    echo $arr_01[$i].", ";              // 1, 2, 3, 4, 5
}
```

array_reverse 함수는 원본 배열에는 영향을 주지 않는 함수이다.
따라서 원본 배열과 순서가 정반대인 새로운 배열을 생성하여 반환한다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-5a2bd639a6e94b8888a1d13dafb49704?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_builtInFunction_array](http://www.tcpschool.com/php/php_builtInFunction_array)
