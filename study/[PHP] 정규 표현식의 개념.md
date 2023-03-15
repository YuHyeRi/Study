# [PHP] 정규 표현식의 개념

**정규 표현식(regular expression)이란?**

정규 표현식은 문자열에서 특정한 규칙을 가지는 문자열의 집합을 찾아내기 위한 검색 패턴이다.
이러한 검색 패턴은 모든 종류의 문자열 검색이나 교체 등의 작업에서 사용할 수 있다.

PHP에서는 다음과 같은 두 가지의 정규 표현식을 지원한다.

1. POSIX
2. PCRE(Perl-Compatible Regular Expression)

POSIX 정규 표현식은 배우기가 쉽고 실행 속도가 빠른 편이다.
그에 비해 PCRE 정규 표현식은 POSIX 정규 표현식을 확장하였기에 더 강력하고 유연하게 동작한다.
그러나 여기서는 좀 더 간단한 형식의 POSIX 정규 표현식을 살펴볼 것이다.

---

**정규 표현식 리터럴**

PHP에서 정규 표현식 리터럴은 다음 문법을 사용하여 표현한다.

```php
/검색패턴/플래그
```

정규 표현식 리터럴은 슬래시(/) 기호로 시작하여 슬래시(/) 기호로 끝난다.
또한 필요에 따라 플래그를 추가하여 기본 검색 설정을 변경할 수도 있다.

---

**preg_match 함수**

preg_match 함수는 해당 문자열에서 전달받은 정규 표현식과 일치하는 패턴을 검색한다.

```php
preg_match($pattern, $subject [,$matches]);
```

첫 번째 인수로 전달받은 정규 표현식에 해당하는 패턴을 두 번째 인수로 전달받은 문자열에서 검색한다. 이렇게 검색된 결과는 배열로 반환되며, 세 번째 인수로 반환값이 저장될 배열을 직접 전달할 수도 있다.
preg_match 함수는 정규 표현식에 해당하는 패턴이 검색되면 더는 검색하지 않고 검색을 중단한다.
이 함수는 일치하는 패턴이 존재하면 1을 반환하고 존재하지 않으면 0을 반환한다.

---

**단순한 패턴 검색**

정규 표현식을 사용하여 단순한 패턴을 검색하고자 할 때는 찾고자 하는 문자열을 직접 나열한다.
예를 들어 다음과 같은 정규 표현식은 정확히 ‘abc’ 라는 문자열만이 일치할 것이다.

```php
/abc/
```

다음 예제는 정규 표현식을 이용한 단순한 패턴 검색 예제이다.

```php
$subject = "간장 공장 공장장은 강 공장장이고, 된장 공장 공장장은 장 공장장이다.";

if (preg_match('/공장/', $subject)) {
    echo "해당 문자열에서 '공장'을 발견했습니다.<br>";
} else {
    echo "해당 문자열에서 '공장'을 발견하지 못했습니다.<br>";
}

if (preg_match('/장공/', $subject)) 
    echo "해당 문자열에서 '장공'을 발견했습니다.<br>";
} else {
    echo "해당 문자열에서 '장공'을 발견하지 못했습니다.<br>";
}
```

위의 예제에서 첫 번째 정규 표현식은 해당 문자열이 ‘공장’이라는 부분 문자열을 표함하고 있으므로 1을 반환한다.
하지만 두 번째 정규 표현식은 해당 문자열이 ‘장 공’ 이라는 부분 문자열은 포함하고 있지만, 
정확히 ‘장공’이라는 부분 문자열을 포함하지 않으므로 아무것도 일치하지 않는다.
preg_match 메소드는 해당 문자열에서 인수로 전달받은 정규 표현식과 일치하는 부분 문자열을
찾지 못하면 0을 반환한다.

---

**플래그(flags)**

정규 표현식 리터럴을 작성할 때 플래그를 사용하여 기본 검색 설정을 변경할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b04b79a2-39c9-4105-a14e-bb76ee175608/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230315%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230315T120327Z&X-Amz-Expires=86400&X-Amz-Signature=e666aafc6c21776f806b071045870c5264859e9eadeb046a11197cda51546f7c&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
$subject = "bcabcAB";

// 기본 설정으로 검색 패턴을 비교할 때 대소문자를 구분함.
preg_match_all('/AB/', $subject, $matches_01);      // "AB"

// 검색 패턴을 비교할 때 대소문자를 구분하지 않도록 설정함.
preg_match_all('/AB/i', $subject, $matches_02); // "ab", "AB"
```

<aside>
💡 preg_match_all 함수는 해당 문자열에서 전달받은 정규 표현식과 일치하는 패턴을 모두 검색하여 세 번째 인수로 전달되는 배열에 저장한다.

</aside>

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-859a4e574c844612af750cb48dbe0179?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_regularExpression_concept](http://www.tcpschool.com/php/php_regularExpression_concept)
