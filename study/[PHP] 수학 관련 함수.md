# [PHP] 수학 관련 함수

**최댓값과 최솟값**

max 함수는 전달받은 수 중에서 가장 큰 수를 반환하며 min 함수는 가장 작은 수를 반환한다.

```php
echo "1, 5, 7, 3, 2 중 가장 큰 값은 ".max(1, 5, 7, 3, 2)."입니다.";
echo "1, 5, 7, 3, 2 중 가장 작은 값은 ".min(1, 5, 7, 3, 2)."입니다.";
```

---

**올림과 내림**

floor 함수는 인수로 전달받은 값과 같거나 작은 수 중에서 가장 큰 정수를 반환한다.
또한 ceil 함수는 반대로 인수로 전달받은 값과 같거나 큰 수 중에서 가장 작은 정수를 반환한다.
PHP에서 소수점에서의 반올림은 round 함수를 사용하여 수행할 수 있다.

```php
echo floor(10.95);  // 10 
echo floor(11.01);  // 11
echo floor(-10.95); // -11
echo floor(-11.01); // -12

echo ceil(10.95);   // 11
echo ceil(11.01);   // 12
echo ceil(11);      // 11
echo ceil(-10.95);  // -10
echo ceil(-11.01);  // -11

echo round(10.49);  // 10
echo round(10.5);   // 11
echo round(-10.5);  // -11
echo round(-10.51); // -11
```

<aside>
💡 floor(), ceil(), round() 함수의 반환값은 인수로 음수를 전달받을 때 특히 유의해서 고려해야 합니다.

</aside>

---

**지수와 로그**

pow() 함수는 전달받은 수의 거듭제곱을 반환한다.
첫 번째 인수로는 밑수를 전달하고, 두 번째 인수로는 지수를 전달한다.

exp() 함수는 인수로 지수를 전달받아, e의 거듭제곱을 계산하여 반환한다.
log() 함수는 전달받은 수의 자연로그 값을 계산하여 반환한다.

```php
echo "2의 3제곱은 ".pow(2, 3)."입니다.";
echo "e의 3제곱은 ".exp(3)."입니다.";
echo "log3은 ".log(3)."입니다.";
```

---

**삼각 함수**

PHP에서는 스크립트에서 간단히 삼각 함수를 사용할 수 있다.
sin() 함수는 전달받은 수의 사인값을, cos() 함수는 코사인값을, tan() 함수는 탄젠트값을 반환한다.

```php
echo "sin3.14는 ".sin(pi()/2)."입니다."; // sin(π/2) == 1
echo "cos3.14는 ".cos(M_PI)."입니다.";   // cos(π) == -1
echo "tan3.14는 ".tan(M_PI/4)."입니다."; // tan(π/4) == 1
```

<aside>
💡 pi() 함수는 파이(π) 값을 반환하며, M_PI 상수와 같은 값을 반환합니다.

</aside>

---

**기타 함수**

abs 함수는 전달받은 수의 절댓값을 반환한다.
rand 함수는 0보다 크거나 같고 getrandmax 함수의 반환값보다 작은 하나의 정수를 무작위로 
생성하여 반환한다.

```php
echo "-3의 절댓값은 ".abs(-3)."입니다.";
echo "0부터 ".getrandmax()"까지의 정수를 하나 무작위로 생성합니다 : ".rand();
```

<aside>
💡 getrandmax() 함수는 rand() 함수로 생성할 수 있는 정수의 최댓값을 나타냅니다.

</aside>

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-be6409c63ef743928b2bafb63b430200?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_builtInFunction_math](http://www.tcpschool.com/php/php_builtInFunction_math)
