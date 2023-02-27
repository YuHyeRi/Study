# [PHP] 기타 제어문

**루프의 제어**

일반적으로 조건식의 검사를 통해 루프로 진입하면, 다음 조건식을 검사하기 전까지 루프 안에 있는 모든 명령문을 실행한다.
사용자는 continue문과 break문을 통해 이러한 일반적인 루프의 흐름을 직접 제어할 수 있다.

---

**continue 문**

continue문은 루프 내에서 사용하여 해당 루프의 나머지 부분을 건너뛰고, 바로 다음 조건식의 
판단으로 넘어가게 한다.
보통 반복문 내에서 특정 조건에 대한 처리를 제외하고자할 때 자주 사용된다.

<aside>
💡 다른 언어와는 달리 PHP에서는 switch문에도 continue를 사용할 수 있어, switch문을 반복문처럼 사용할 수 있다.

</aside>

다음 예제는 1부터 100까지의 정수 중에서 4의 배수를 제외하고 출력하는 예제이다.

```php
$exceptNum = 4;
for ($i=0; $i<=100; $i++) {
    if ($i % $exceptNum == 0)
        continue;
    echo "{$i} ";
}
```

---

**break문**

break문은 루프 내에서 사용한다.
해당 반복문을 완전히 종료시키고, 반복문 다음에 위치한 명령문으로 이동시킨다. 
즉, 루프 내에서 조건식의 판단 결과에 상관없이 반복문을 완전히 빠져나가고 싶을 때 사용한다.

다음 예제는 1부터 100까지의 합을 구하는 예제이다.

```php
$sum = 0;
$startNum = 1;
$endNum = 100;
$i = $startNum;
while (true) { // 일부러 만든 무한 루프임.
    $sum += $i;
    if ($i == $endNum)
        break;
    $i++;
}
echo "{$startNum}에서부터 {$endNum}까지 더한 값은 {$sum}입니다.";
```

---

**goto문**

goto문은 프로그램의 흐름을 지정된 레이블로 무조건 변경하는 명령문이다. 
goto문은 다른 제어문과는 다르게 아무 조건 없이 제어를 옮겨준다.
따라서 가장 손쉽게 사용할 수 있지만, 반면에 프로그램의 프름을 매우 복잡하게 만들기도 한다. 
이러한 단점 때문에 현재는 거의 사용하지 않는다.

---

**제어문의 대체 문법**

PHP는 제어문을 위해 사용할 수 있는 또 하나의 대체 문법을 제공하는 있다. 
이 대체 문법은 조건문에서는 if문과 switch문, 반복문에서는 while문, for문과 foreach문에 사용할 수 있다.
대체 문법의 사용 방법은 우선 제어문의 여는 괄호({})를 콜론(:)으로 대체한다. 
그리고 닫는 괄호(})를 각각 endif; endswitch; endwhile; endfor; endforeach; 로 대체하면 된다.

```php
<?php $var = 5; ?>
<?php if ($var > 6): ?>
변수의 값은 6보다 큽니다.   <!-- 이 부분은 HTML 구문임 -->
<?php elseif ($var == 6): ?>
변수의 값은 6입니다.        <!-- 이 부분은 HTML 구문임 -->
<?php elseif ($var < 6): ?>
변수의 값은 6보다 작습니다. <!-- 이 부분은 HTML 구문임 -->
<?php endif; ?>
```

위의 예제에서 대체 문법으로 쓰인 elseif문 안에 있는 HTML 구문은 변수 $var의 값에 따라 
단 하나만이 출력될 것이다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/PHP-b8084349ee7c4e3e80a1971f35a6dc4e?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_control_etc](http://www.tcpschool.com/php/php_control_etc)
