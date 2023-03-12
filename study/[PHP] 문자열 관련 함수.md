# [PHP] 문자열 관련 함수

**문자열 길이**

strlen 함수는 전달받은 문자열의 길이를 반환한다.
이 때 문자열의 길이란 문자열에 포함된 문자의 개수를 의미한다.

```php
$str = "12345678";
echo strlen($str); // 8
```

만약 strlen 함수에 영문자만이 아닌 한글이 포함된 문자열이 전달되면, 문자열의 길이가 아닌 
문자열의 총 바이트 수를 반환한다.
따라서 한글이 포함된 문자열의 정확한 문자열 길이를 반환받기 위해서는 mb_strlen 함수를 사용해야 한다.

mb_strlen 함수는 문자열 뿐만 아니라 두 번째 인수로 인코딩 방식까지 전달받을 수 있다. 
이렇게 전달받은 인코딩 방식으로 해당 문자열을 해석하여 정확한 문자열의 길이를 반환해준다.
만약 두 번째 인수를 전달받지 못하면, 현재 시스템의 내부 인코딩 방식을 사용할 것이다.

```php
$str = "한글로된문자열";

echo strlen($str);             // 7 * 3 = 21
echo mb_strlen($str);          // 7 * 3 = 21
echo mb_strlen($str, "UTF-8"); // 7
```

<aside>
💡 UTF-8 인코딩 방식에서는 영문자는 한 문자당 1바이트, 한글은 한 문자당 3바이트로 표현된다.

</aside>

---

**문자열 비교하기**

strcmp 함수는 전달받은 두 개의 문자열을 서로 비교한다.
첫 번째 인수의 문자열이 두 번째 인수의 문자열보다 크면 양수를, 작으면 음수를 반환한다. 
또한 두 문자열이 완전히 같으면 0을 반환한다.

이 때 strcmp 함수는 비교할 때 대소문자를 구분한다.
하지만 strncasecmp 함수를 사용하면 대소문자를 구분하지 않고 두 개의 문자열을 비교할 수 있다.

strnatcmp 함수는 strcmp 함수와 비슷하며 strnatcasecmp 함수는 strcasecmp 함수와 비슷하다.
차이점으로는 strnatcmp 함수와 strnatcasecmp 함수는 영숫자 순으로 문자열을 비교한다는 점이다.

```php
echo strcmp("abc", "ABC");     // 양수
echo strcasecmp("abc", "ABC"); // 0
echo strcmp("2", "10");        // 양수
echo strnatcmp("2", "10");     // 음수
```

위의 예제에서 strcmp 함수는 ‘2’를 ‘10’보다 크다고 인식하지만, strnatcmp 함수에서는 작다고 인식한다.

---

**특정 문자열 검색**

strstr 함수와 strchr 함수는 해당 문자열에서 전달받은 문자여로가 처음으로 일치하는 부분을 찾는다.
해당 문자열에 일치하는 부분이 존재하면 처음으로 일치하는 부분을 포함한 이후의 모든 문자를 
같이 반환한다.
하지만 일치하는 부분이 존재하지 않으면 false를 반환한다.

strchr 함수는 해당 문자열에서 전달받은 문자열과 마지막으로 일치하는 부분을 찾는다.
해당 문자열에 일치하는 부분이 존재하면, 마지막으로 일치하는 부분을 포함한 이후의 모든 문자를 같이 반환한다.
하지만 일치하는 부분이 존재하지 않으면 false를 반환한다.

stristr 함수는 대소문자를 구분하지 않고 strstr 함수와 같은 동작을 수행한다.

```php
echo strstr("ABCabcDEFabc", "abc");   // abcDEFabc
echo strrchr("ABCabcDEFabc", "abc")"; // abc
echo stristr("ABCabcDEFabc", "abc");  // ABCabcDEFabc
```

---

**특정 문자열 위치 찾기**

strpos 함수는 해당 문자열에서 전달받은 문자열과 처음으로 일치하는 부분의 시작 인덱스를 
반환한다.
strpos 함수는 해당 문자열에서 전달받은 문자열과 마지막으로 일치하는 부분의 시작 인덱스를 
반환한다.

```php
echo strpos("ABCabcDEFabc", "abc");  // 3
echo strrpos("ABCabcDEFabc", "abc"); // 9
```

<aside>
💡 PHP에서 숫자 인덱스는 언제나 0부터 시작한다.

</aside>

---

**문자열 추출하기**

substr 함수는 해당 문자열에서 특정 인덱스부터 전달받은 길이만큼의 일부분을 추출하여 반환한다.

전달받은 인덱스가 양수인 경우에는 해당 인덱스부터 해당 문자열 끝까지를 반환한다.
만약 전달받은 인덱스가 음수라면 해당 문자열 끝부터 전달받은 음수의 절댓값만큼의 문자열을 
반환한다.

전달받은 길이가 양수인 경우에는 반환할 문자열의 길이를 나타낸다.
만약 전달받은 길이가 음수라면 특정 인덱스부터 문자열 끝부터 전달받은 음수의 절댓값까지의 
문자열을 반환한다.

```php
$str = "Hello, World!";
echo substr($str, 3);     // 네 번째 문자부터 끝까지 출력
echo substr($str, -3);    // 끝에서부터 세 글자 출력
echo substr($str, 1, 5);  // 두 번째 문자부터 다섯 글자 출력
echo substr($str, 1, -5); // 두 번째 문자부터 뒤에서 여섯 번째 문자까지 출력
```

---

**문자열 대소문자 바꾸기**

strtolower 함수는 전달받은 문자열의 모든 문자를 소문자로 바꿔준다.
또한 strtoupper 함수는 전달받은 문자열의 모든 문자를 대문자로 바꿔준다.

ucfirst 함수는 전달받은 문자열의 첫 번째 문자만을 대문자로 바꿔준다.
또한 ucwords 함수는 전달받은 문자열에서 단어별로 첫 번째 문자만을 대문자로 바꿔준다.

```php
echo strtolower("HELLO, WORLD!"); // 모두 소문자로 바꿈.
echo strtoupper("hello, world!"); // 모두 대문자로 바꿈.
echo ucfirst("hello, world!");    // 문자열의 첫 번째 문자만 대문자로 바꿈.
echo ucwords("hello, world!");    // 각 단어의 첫 번째 문자를 대문자로 바꿈.
```

---

**문자열 합치고 나누기**

explode() 함수는 특정 문자를 기준으로 전달받은 문자열을 나누어서 하나의 배열로 반환한다.
implode() 함수와 join() 함수는 전달받은 배열의 각 요소를 특정 문자를 사용하여 하나로 합쳐친 
문자열로 반환한다.

strtok() 함수는 전달받은 문자열을 특정 문자를 기준으로 토큰화한다.
이 함수는 해당 문자열을 한 번에 모두 나누지 않고, 한 번에 하나씩만을 토큰화한다.
첫 번째 토큰을 얻기 위해서는 strtok() 함수에 인수로 해당 문자열과 기준이 되는 문자를 함께 
전달하면 된다.
그 이후에는 기준이 되는 문자만을 전달해주면 자동으로 두 번째 토큰을 반환한다.

```php
$str = "hello, beautiful, world!";

$array = explode(',', $str);  // ','를 기준으로 문자열을 나눔.
echo $array[0];               // hello
echo $array[1];               // beautiful
echo $array[2];               // world!

$str2 = implode('!', $array); // '!'를 기준으로 문자열을 결합함.
echo $str2;                   // hello! beautiful! world!

$token = strtok($str2, '!');  // '!'를 기준으로 토큰화
echo $token;                  // hello
while($token != ""){          // 문자열이 끝날 때까지
    $token = strtok('!');     // '!'를 기준으로 토근화하고 출력함.
    echo $token;              // beautiful, world
}
```

---

**문자열 대체하기**

str_replace() 함수는 해당 문자열에서 전달받은 문자열을 모두 찾은 후에, 찾은 문자열을 대체 문자열로 교체한다.
substr_replace() 함수는 해당 문자열에서 특정 위치의 문자들을 대체 문자열로 교체한다.
substr_replace() 함수는 해당 문자열에서 교체를 시작할 부분의 인덱스를 세 번째 인수로 전달받는다.
전달받은 인덱스가 0 또는 양수인 경우에는 해당 문자열의 앞에서부터, 음수인 경우에는 뒤에서부터 시작 인덱스를 찾는다.

또한, 선택 사항으로 해당 문자열에서 교체할 부분의 길이를 네 번째 인수로 전달받을 수 있다.
이때 길이를 전달하지 않으면 시작 인덱스부터 해당 문자열의 끝까지 모두 대체된다.

전달된 길이가 양수이면, 시작 인덱스부터 교체할 글자의 개수를 나타낸다.
하지만 전달된 길이가 음수이면, 시작 인덱스부터 문자열 끝부터 음수의 절댓값까지의 문자열을 
대체 문자열로 대체한다.
만약 길이로 0이 전달되면, 해당 문자열의 시작 인덱스에 대체 문자열을 삽입한다.

```php
$str = "hello, world!";
echo str_replace('o', '*', $str);      // 문자열의 모든 'o'를 '*'로 대체함.
echo substr_replace($str, '*', 2);     // 세 번째 문자부터 끝까지를 '*'로 대체함.
echo substr_replace($str, '*', -2);    // 끝에서 두 번째 문자부터 끝까지를 '*'로 대체함.
echo substr_replace($str, '*', 2, 4);  // 세 번째 문자부터 네 글자를 '*'로 대체함.
echo substr_replace($str, '*', 2, -4); // 세 번째 문자부터 끝에서 다섯 번째 문자까지를 '*'로 대체함.
echo substr_replace($str, '*', 2, 0);  // 두 번째 문자 뒤에 '*'을 삽입함.
```

---

**문자열 다듬기**

ltrim() 함수는 문자열 앞부분에 있는 공백을 제거하고, rtrim() 함수와 chop() 함수는 문자열 끝부분에 있는 공백을 제거한다.
또한, trim() 함수는 문자열의 처음과 끝부분에 있는 공백을 모두 제거한다.

이 함수들이 제거하는 문자는 다음과 같다.

- 띄어쓰기 " "
- 탭 문자 "\t"
- 줄 바꿈 문자 "\n", "\r"
- 널 문자 "\0"
- 수직 탭 문자 "\x0B"

```php
$str = "  hello, world!  ";
echo "'".ltrim($str)."'<br/>"; // 문자열의 처음 부분 공백을 모두 지움. 
echo "'".rtrim($str)."'<br/>"; // 문자열의 끝부분 공백을 모두 지움.
echo "'".trim($str)."'";       // 문자열의 처음과 끝부분 공백을 모두 지움.
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-c7bafe7de73d4ef9837d0f7045817bf9?pvs=4
<br>
👉 출처 : [http://www.tcpschool.com/php/php_builtInFunction_string](http://www.tcpschool.com/php/php_builtInFunction_string)
