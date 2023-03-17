# [PHP] 정규 표현식의 활용

**정규 표현식의 활용**

앞서 살펴본 정규 표현식을 활용하면, 다음과 같은 데이터가 해당 형식에 맞는지를 손쉽게 확인할 수 있다.

1. 전화번호
2. 이메일 주소

---

**전화번호 확인**

정규 표현식을 이용하면 해당 전화번호가 유효한 형식의 전화번호인지 확인할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/bd7a6235-babc-49a7-9648-b9fd77316902/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230317%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230317T004441Z&X-Amz-Expires=86400&X-Amz-Signature=2b6364d623049e32e6e5af2e78bbc1aa16fe561e56313f83dc8174589ea6ff5b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

①번 정규 표현식은 전화번호의 맨 앞자리가 2자리이고, 국번이 4자리인 전화번호만을 검색할 수 
있다.
하지만 지역번호나 핸드폰의 경우에는 전화번호의 맨 앞자리가 3자리이며, 국번이 3자리인 
전화번호도 아직 존재한다.
따라서 ②번 정규 표현식과 같이 전화번호의 맨 앞자리가 2자리나 3자리이고, 
국번도 3자리나 4자리인 전화번호까지 검색할 수 있도록 해야한다.

```php
$tel = "02-1234-5678";
$cell = "010-1234-5678";
$pattern_01 = "/^[[:digit:]]{2}\-[[:digit:]]{4}\-[[:digit:]]{4}/";

if (preg_match($pattern_01, $tel, $matches_01)) {
    var_dump($matches_01);
} else {
    echo "{$tel}은 유효한 형식의 전화번호가 아닙니다.<br>";
}

if (preg_match($pattern_01, $cell, $matches_02)) {
    var_dump($matches_02);
} else {
    echo "{$cell}은 유효한 형식의 전화번호가 아닙니다.<br>";
}

$pattern_02 = "/^[[:digit:]]{2,3}\-[[:digit:]]{3,4}\-[[:digit:]]{4}/";

if (preg_match($pattern_02, $tel, $matches_03)) {
    var_dump($matches_03);
} else {
    echo "{$tel}은 유효한 형식의 전화번호가 아닙니다.<br>";
}

if (preg_match($pattern_02, $cell, $matches_04)) {
    var_dump($matches_04);
} else {
    echo "{$cell}은 유효한 형식의 전화번호가 아닙니다.<br>";
}
```

<aside>
💡 정규 표현식에서 '\'문자 바로 뒤에 일반 문자가 나오면, 해당 문자는  특수 문자로 인식된다.

또한, '\'문자 바로 뒤에 특수 문자가 나오면, 해당 문자는 일반 문자로 인식된다.

위의 예제에서 사용된 '-'문자는 범위를 나타내는 특수 문자이므로, '\-'는 단순히 전화번호에서 사용되는 '-'기호로 인식된다.

</aside>

---

**이메일 주소 확인**

전화번호 뿐만 아니라 이메일 주소도 특정 형식을 가진다. 
따라서 정규 표현식을 이용하면 해당 이메일 주소가 유효한 형식의 이메일 주소인지를 확인할 수 있다.

해당 전화번호가 유효한 형식의 전화번호인지를 다음 정규 표현식을 이용하여 확인할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0e188407-cc97-447a-85ca-ac6d749a83ae/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230317%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230317T004425Z&X-Amz-Expires=86400&X-Amz-Signature=aed67f64a512c10f8e7c0ea3e0c3a649aab7b27ca49b55c5147f0e791c3d69c9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

위의 예제에서 사용된 다음 정규 표현식의 의미는 숫자나 영문 대소문자, 언더스코어(_) 또는 ‘-’ 기호를 포함한 문자가 1번 이상 반복되는 문자열을 의미한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/21ed1bca-c6a5-4ae9-8e97-526350db63ab/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230317%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230317T004411Z&X-Amz-Expires=86400&X-Amz-Signature=cbafaf2a34e0057bc217cbdf7d0bf3de602299493488998504b4f6df546b95c9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

①번 정규 표현식은 '@'문자와 '.'문자를 각각 하나씩만 포함하는 이메일 주소만을 검색한다.
따라서 이 정규 표현식은 도메인 이름이 '.com'이나 '.net'과 같이 '.'문자를 하나만 포함하는 
이메일 주소만 검색할 수 있다.
즉, 위의 예제처럼 '.'문자를 2개 이상 포함하는 이메일 주소는 정확하게 인식하지 못한다.
그러므로 '.'문자를 2개 이상 포함하는 이메일 주소는 ②번 정규 표현식과 같이 좀 더 자세히 
표현해야 한다.

다음 정규 표현식은 '.'문자로 시작하고, 숫자나 영문 대소문자, 언더스코어(_) 또는 '-'기호를 포함한 문자가 1번 이상 반복되는 문자열이 1번 또는 2번 반복되는 문자열을 의미한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9f52e3f1-f7bd-4e86-91b0-64ac49453199/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230317%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230317T004354Z&X-Amz-Expires=86400&X-Amz-Signature=8ec7f4ff19f5fbdb0adcede0ff919e69c0ad5eb206844e38c66fce1377f8133a&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
$com = "help@abcd.com";
$co = "help@abcd.co.kr";
$pattern_01 = "/([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)\.([0-9a-zA-Z_-]+)/";

if (preg_match($pattern_01, $com, $matches_01)) {
    var_dump($matches_01[0]);
} else {
    echo "{$com}은 유효한 형식의 이메일 주소가 아닙니다.<br>";
}

if (preg_match($pattern_01, $co, $matches_02)) {
    var_dump($matches_02[0]);
} else {
    echo "{$co}은 유효한 형식의 이메일 주소가 아닙니다.<br>";
}

$pattern_02 = "/([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}/";

if (preg_match($pattern_02, $com, $matches_03)) {
var_dump($matches_03[0]);
    } else {
echo "{$com}은 유효한 형식의 이메일 주소가 아닙니다.<br>";
    }

if (preg_match($pattern_02, $co, $matches_04)) {
    var_dump($matches_04[0]);
} else {
    echo "{$co}은 유효한 형식의 이메일 주소가 아닙니다.<br>";
}
```

PHP에서는 유효한 형식의 이메일 주소인지를 확인하기 위해 정규 표현식뿐만 아니라 filter_var() 
함수를 제공한다.

```php
$com = "help@abcd.com"
$co = "help@abcd.co.kr";

if (filter_var($com, FILTER_VALIDATE_EMAIL)) {
    echo $com;
} else {
    echo "{$com}은 유효한 형식의 이메일 주소가 아닙니다.<br>";
}

if (filter_var($co, FILTER_VALIDATE_EMAIL)) {
    echo $co;
} else {
    echo "{$co}은 유효한 형식의 이메일 주소가 아닙니다.<br>";
}
```

filter_var() 함수에 대한 더 자세한 사항은 PHP Form 입력 형식 검증 수업에서 확인할 수 있다.

[PHP Form 입력 형식 검증 수업 확인 =>](http://www.tcpschool.com/php/php_form_format)

---

**한글 확인**

정규 표현식에서는 영문자뿐만 아니라 한글도 사용할 수 있다.

해당 문자가 한글인지를 확인하는 정규 표현식은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0b4890c2-a8b5-430c-a31c-d721d8641772/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230317%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230317T004339Z&X-Amz-Expires=86400&X-Amz-Signature=9fe3cdae6986ca1054d5ff9ff285534d3adbc16f4f32f8a953147995385d8289&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

한글 소리 마디(hangul syllables)란 초성 19개, 중성 21개, 종성 28개로 이루어지는 총 11,172개의 
한글 문자를 가리킨다.
위의 ①번과 ②번 정규 표현식은 둘 다 현대 한글에서 표현할 수 있는 11,172개의 한글 소리 마디를 모두 검색할 수 있다.

이 두 정규 표현식은 대부분의 경우 잘 동작하겠지만, ①번 정규 표현식은 언어 설정이 한글이 아닌 시스템에서는 동작이 안 될 수도 있다.
②번 정규 표현식처럼 'u'플래그를 추가하여 해당 정규 표현식 문자열을 UTF-8로 인코딩된 것처럼 
취급할 수 있다.

```php
$eng = "gil-dong Hong";
$kor = "홍길동";
$pattern = "/[가-힣]+/"; // 한글 소리 마디

if (preg_match($pattern, $eng, $matches_01)) {
    var_dump($matches_01);
} else {
    echo "{$eng}에는 한글이 포함되어 있지 않습니다.<br>";
}

if (preg_match($pattern, $kor, $matches_02)) {
    var_dump($matches_02);
} else {
    echo "{$eng}에는 한글이 포함되어 있지 않습니다.<br>";
}
```

다음 예제는 해당 문자열에서 한글만을 제거하는 예제이다.

```php
$text = "123가나abc다라";
$pattern = "/[\\x{ac00}-\\x{d7af}]+/u";         // 한글 소리 마디(UTF-8)

$arr = preg_match_all('/./u', $text, $matches); // 줄 바꿈 문자(\n)를 제외한 임의의 한 문자씩 검색함.
echo preg_replace($pattern, '', $text);         // 해당 문자가 한글이면, 빈 문자열로 대체함.
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-2eac0d6a96be40428c72e2f708e4158e?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_regularExpression_application](http://www.tcpschool.com/php/php_regularExpression_application)
