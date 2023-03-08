# [PHP] 함수의 활용

**조건적인 함수(conditional function)**

조건적인 함수는 특정 조건을 만족할 때만 선언되는 함수이다.
설정된 조건을 만족하지 못했을 때는 선언 자체가 되지 않으므로, 해당 함수를 호출할 수 없다.

```php
$makefunc = true;
//func(); // 이 부분은 func() 함수가 선언되기 전이므로, 함수를 호출할 수 없습니다.

if($makefunc) {
    function func()
    {
        echo "이제 함수를 사용할 수 있습니다";
    }
    func(); // 이 부분은 func() 함수가 선언되었으므로, 함수를 호출할 수 있습니다.
}
```

위의 예제처럼 함수가 선언되기 전에 먼저 호출되면 PHP는 오류를 발생시킨다.

---

**함수 안의 함수(function within function)**

PHP에서는 함수 안에 또 다른 함수를 선언할 수 있다.
PHP에서 모든 함수는 전역 함수이므로, 함수 내부에서 선언된 함수라도 해당 함수 외부에서 호출할 수 있다.

```php
function out()
{
    function in()
    {
        echo "이제 함수를 사용할 수 있습니다";
    }
}

① //in(); // 이 부분은 in() 함수가 선언되기 전이므로, 함수를 호출할 수 없습니다.
② out();
③ in();   // 이 부분은 in() 함수가 선언되었으므로, 함수를 호출할 수 있습니다.
```

위의 예제에서 in 함수는 out 함수 내부에서 정의된다.
따라서 1번 라인에서는 아직 단 한번도 out 함수가 호출되지 않았으므로, in 함수가 정의되어 있지 
않다.
2번 라인에서 out 함수가 호출되면서 비로소 in 함수도 같이 정의된다.
따라서 3번 라인에서는 정의된 in 함수를 호출할 수 있게 된다.

---

**재귀 함수(resursive function)**

재귀 함수란 함수 내부에서 함수가 자기 자신을 또 다시 호출하는 함수를 의미한다.
이러한 재귀 함수는 자기가 자신을 계속해서 호출하므로, 끝없이 반복될 것이다. 
따라서 함수 내에 재귀 호출을 중단하도록 조건이 변경될 명령문을 반드시 포함해야 한다.

프로그래밍을 처음 접하는 사람은 이러한 재귀함수가 왜 필요한가에 대해 이해하기 힘들 수 있다. 
하지만 재귀함수는 알고리즘이나 자료 구조론에서는 매우 중요한 개념 중 하나이다.
또한 재귀함수를 사용하면 복잡한 문제도 매우 간단하게 논리적으로 접근하여 표현할 수 있다.

```php
function factorial($num)
{
    if($num > 1)                           // 1이 될 때까지
        return $num * factorial($num - 1); // 1씩 감소시킨 값을 전달하여 자기 자신을 계속 호출함.
    else
        return 1;
}
echo factorial(4);
```

<aside>
💡 100번 이상의 재귀 호출은 스택의 한계에 도달하여 스크립트가 중단될 수 있으므로, 될 수 있으면 사용하지 않는 것이 좋다.

</aside>

---

**가변 함수(variable function)**

가변 함수란 변수를 사용하여 함수를 호출하는 것을 의미한다.
PHP에서는 변수 이름에 괄호(())를 붙이면, 해당 변수의 값과 같은 이름을 가지는 함수를 호출한다.
따라서 변수에 함수의 이름을 별도로 지정할 수 있다.

```php
function first()
{
    echo "first() 함수입니다.<br><br>";
}

function second($para)
{
    echo "second() 함수입니다.<br>";

    echo "함수 호출 시 전달받은 인수의 값은 {$para}입니다.";
}

$func = "first";
$func();    // first() 함수를 호출함.
$func = "second"
$func(20);  // second() 함수를 호출함.
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-b18f1bb7e2db401eb2c83f8968556e3d?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_function_application](http://www.tcpschool.com/php/php_function_application)
