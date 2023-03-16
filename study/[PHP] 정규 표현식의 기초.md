# [PHP] 정규 표현식의 기초

**특수 문자(special characters)**

정규 표현식을 사용하여 단순한 패턴을 검색하고자 할 때는 찾고자 하는 문자열을 직접 나열한다.
하지만 숫자만을 검색하거나 띄어쓰기를 찾는 등 정확히 일치하는 패턴보다 더 복잡한 조건을 
사용하려면 특수 문자를 사용해야 한다.
이렇게 정규 표현식에서 사용하는 특정 의미를 가지는 기호를 특수 문자 또는 메타(meta)문자라고 한다.

정규 표현식에서 사용할 수 있는 대표적인 특수 문자는 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/62a490d8-28b9-4b95-bf3e-a73c62d34264/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230316%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230316T083534Z&X-Amz-Expires=86400&X-Amz-Signature=c84a31fdb63d375f5dd5dbe3313c4dfccebd84e108a01d168bf7b98d697d12ba&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

다음 예제는 대표적인 특수 문자를 사용한 정규 표현식으로 검색할 수 있는 문자열의 예제이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e7beceb9-5300-4a68-a3ed-dfb0909fb3a7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230316%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230316T083518Z&X-Amz-Expires=86400&X-Amz-Signature=ab8d6b7b7deb79087b703b3b2c24e994a2b715647de2e2d7a6a2b33f22eaf38e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

---

**양화사(quantifier)**

정규 표현식에서는 특수 문자로 수량을 나타내는 다양한 양화사를 사용할 수 있다.

- '*'는 바로 앞의 문자가 0번 이상 나타날 경우를 검색 ({0, }와 같음)
- '+'는 바로 앞의 문자가 1번 이상 나타날 경우를 검색 ({1, }과 같음)
- '?'는 바로 앞의 문자가 0번 또는 1번만 나타날 경우를 검색 ({0,1}과 같음)
- '{n,m}'은 바로 앞의 문자가 반복되는 횟수를 지정,
    
    바로 앞의 문자가 최소 n번이상 최대 m번이하로 나타날 경우를 검색 (n과 m은 반드시 양의 정수이어야만 함)
    

```php
$subject = "PHP is cooooool!";

// 문자 'l' 바로 앞에 문자 'o'가 0 또는 1번 나타나는 경우를 검색함.
preg_match_all('/o?l/', $subject, $match_01);

// 문자 'l' 바로 앞에 문자 'o'가 0번 이상 나타나는 경우를 검색함.
preg_match_all('/o*l/', $subject, $match_02);

// 문자 'l' 바로 앞에 문자 'o'가 1번 이상 나타나는 경우를 검색함.
preg_match_all('/o+l/', $subject, $match_03);

// 영문 소문자가 1번 이상 나타나는 경우를 검색함.
// 즉, 영문 소문자만으로 이루어진 부분 문자열을 검색함.
preg_match_all('/[a-z]+/', $subject, $match_04);
```

```php
$subject = "PHP is cooooool!";
 
// 문자 'l' 바로 앞에 문자 'o'가 최소 2번 이상 최대 4번 이하로 나타나는 경우를 검색함.
preg_match_all('/o{2,4}l/', $subject, $match_01);
var_dump($match);

// 문자 'l' 바로 앞에 문자 'o'가 최소 2번 이상 나타나는 경우를 검색함.
preg_match_all('/o{2,}l/', $subject, $match_02);
var_dump($match);

// 문자 'l' 바로 앞에 문자 'o'가 정확히 6번 나타나는 경우를 검색함.
preg_match_all('/o{6}l/', $subject, $match_03);
```

---

**위치 문자**

정규 표현식에서는 해당 문자열에서 패턴을 검색할 단어의 위치까지 지정할 수 있다.

- '^'는 단어의 맨 앞에 위치한 해당 패턴만을 검색
- '$'는 단어의 맨 뒤에 위치한 해당 패턴만을 검색

```php
$subject = "abcdef defabc";

// 단어가 문자열 "abc"로 시작하는 경우를 검색하여, 해당 부분 문자열을 'ABC'로 대체함.
$match_01 = preg_replace('/^abc/', 'ABC',$subject);

// 단어가 문자열 "abc"로 끝나는 경우를 검색하여, 해당 부분 문자열을 'ABC'로 대체함.
$match_02 = preg_replace('/abc$/', 'ABC', $subject);
```

<aside>
💡 preg_replace() 함수는 해당 문자열에서 전달받은 정규 표현식과 일치하는 패턴을 검색하여, 해당 부분을 두 번째 인수로 전달되는 문자열로 대체한 새로운 문자열을 반환한다.

</aside>

---

**선택 문자**

정규 표현식에서는 특수문자 '|'를 사용하여 여러 개의 검색 패턴을 사용할 수 있다.
즉, 특수문자 '|'로 구분된 정규 표현식 중 어느 하나에만 일치해도 검색된다.

```php
$subject = "ABCdefGHIjkl";

// 문자열 'abc' 또는 'def' 또는 'jkl'만을 검색함.
// 즉, 위의 세 문자열 중 어느 하나에만 일치해도 검색됨.
preg_match_all('/abc|def|jkl/', $subject, $match);
```

---

**문자 클래스(character class)**

문자 클래스란 정규 표현식에서 명시된 범위에 해당하는 한 문자만을 선택하기 위해 사용되는 문자이다. 이러한 문자 클래스는 꺽쇠 괄호([ ])를 사용한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/fc775fcd-afbc-43fa-a72a-5dbe4e5408fe/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230316%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230316T083501Z&X-Amz-Expires=86400&X-Amz-Signature=bf71dd0f70463e028d7e3c5b0261628548e3d2476a3a73fcd7d5be4e68a28202&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```php
$subject = "@ap";

preg_match("/.ap/", $subject, $match_01);        // "ap" 문자열 앞에 임의의 한 문자가 나타나는 경우를 검색함.
preg_match("/[a-zA-Z]ap/", $subject, $match_01); // "ap" 문자열 앞에 영문자 한 문자가 나타나는 경우를 검색함.
```

위의 예제에서 사용된 특수 문자’.’는 줄 바꿈 문자를 제외한 임의의 문자 하나를 의미한다.
이 문자를 잘 사용하면 검색하고자 하는 문자의 범위를 더욱 제한할 수 있다.

---

**POSIX 문자 클래스**

앞서 살펴본 문자 클래스 이외에도 POSIX 정규 표현식에서만 사용할 수 있는 문자 클래스가 존재한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/34b1d7e4-e07b-4623-a4ad-c19ef6025f1e/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230316%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230316T083418Z&X-Amz-Expires=86400&X-Amz-Signature=c4810b6d141406468562354decf80720a1e4242a2fdcd7d09bbdcea9f889b7f5&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

위의 표와 같이 POSIX에서만 사용할 수 있는 문자 클래스는 기본적으로 꺽쇠 괄호([ ])를 포함한다.
따라서 이러한 POSIX 전용 문자 클래스는 다음과 같이 꺽쇠 괄호를 두 번 사용하여 표현된다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-d38b9eb2fc434fd48d4030e91aa2bd21?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_regularExpression_basic](http://www.tcpschool.com/php/php_regularExpression_basic)
