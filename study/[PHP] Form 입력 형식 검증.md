# [PHP] Form 입력 형식 검증

**입력 형식 검증**

이메일 주소는 ‘@’문자와 ‘.’ 문자를 포함하는 유효한 이메일 주소의 형식이 따로 존재한다.
입력 형식 검증이란 사용자가 입력한 데이터가 이러한 형식에 맞는 유효한 데이터인가를 검증하는 것이다.

다음 예제는 앞선 예제에 이름, 이메일, 홈페이지에 대한 입력 형식 검증을 추가한 예제이다.

```php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["name"])) {
        $nameMsg = "이름을 입력해 주세요!";
    } else {
        $name = $_POST["name"];
        // 이름의 입력 형식 검증
①      if (!preg_match("/^[a-zA-Z가-힣 ]*$/", $name)) {
            $nameMsg = "영문자와 한글만 가능합니다!";
        }
    }
...
    if (empty($_POST["email"])) {
        $emailMsg = "";
    } else {
        $email = $_POST["email"];
        // 이메일의 입력 형식 검증
②      if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            $emailMsg = "이메일을 정확히 입력해 주세요!";
        }
    }
    if (empty($_POST["website"])) {
        $websiteMsg = "";
    } else {
        $website = $_POST["website"];
        // 홈페이지 URL 주소의 입력 형식 검증
③      if (!filter_var($email, FILTER_VALIDATE_URL)) {
            $websiteMsg = "홈페이지의 주소를 정확히 입력해 주세요!";
        }
    }
...
}
```

---

**이름 입력 형식 검증**

위의 예제에서 이름에는 영문자와 한글 그리고 띄어쓰기만으로 사용할 수 있도록 하고 있다.
이름과 같은 입력 형식 검증은 정규 표현식을 사용하여 검증할 수 있다.

PHP에서는 preg_match() 함수를 사용하여 정규 표현식을 이용한 검증을 할 수 있다.
이 함수는 전달받은 정규 표현식에 해당하는 패턴이 존재한다면 true를 반환하고, 
존재하지 않으면 false를 반환한다.

```php
if (empty($_POST["name"])) {
        $nameMsg = "이름을 입력해 주세요!";
    } else {
        $name = $_POST["name"];
        // 이름의 입력 형식 검증
①      if (!preg_match("/^[a-zA-Z가-힣 ]*$/", $name)) {
            $nameMsg = "영문자와 한글만 가능합니다!";
        }
    }
```

1번 라인에서 사용된 정규 표현식 "/^[a-zA-Z가-힣 ]*$/”의 의미는 영문 소문자와 영문 대문자, 
한글 그리고 띄어쓰기만으로 이루어진 문자열을 의미한다.
따라서 1번 라인에서는 변수 $name의 값이 이러한 정규 표현식에 해당하는 문자열인지를 검사하고 있다.
위의 예제에서 이름에 만약 영문 대소문자, 한글, 띄어쓰기 이외의 문자가 포함되면 오류 메시지를 
출력할 것이다.

[PHP 정규 표현식 수업 확인 =>](http://www.tcpschool.com/php/php_regularExpression_basic)

---

**이메일과 url 주소 입력 형식 검증**

PHP에서는 이메일과 url 주소에 대한 입력 형식 검증에 사용할 수 있는 filter_var() 함수를 제공하고 있다.
filter_var() 함수는 해당 변수가 전달받은 검증 필터(validate filter)에 맞는 유효한 값인지를 검사하는 함수이다.

PHP에서 사용할 수 있는 검증 필터는 다음과 같다.

<img src="https://file.notion.so/f/s/0f887ef7-08ff-45f4-b491-106bcfe3b844/Untitled.png?id=392a5bfd-505b-424e-95ab-39c0290e4c18&table=block&spaceId=cbbefbcc-680a-4e93-a93e-800d7ccbe4ee&expirationTimestamp=1680436952582&signature=XEFfkikJFTbIVoxQ8xbiZ5kXyC2JK31sUzcjihkXZt0&downloadName=Untitled.png">

<aside>
💡 MAC 주소란 네트워크 인터페이스에 할당된 고유 식별자로, 간단히 말해 컴퓨터가 가지고 있는 자신만의 고유 번호를 의미한다.

</aside>

<aside>
💡 펄 호환 정규 표현식(PCRE)이란 펄 프로그래밍 언어의 정규 표현식 기능에 착안하여 만든 정규 표현식으로 기존의 POSIX 정규 표현식보다 훨씬 더 강력하고 유연하게 동작한다.

</aside>

```php
if (empty($_POST["email"])) {
        $emailMsg = "";
    } else {
        $email = $_POST["email"];
        // 이메일의 입력 형식 검증
②      if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            $emailMsg = "이메일을 정확히 입력해 주세요!";
        }
    }
    if (empty($_POST["website"])) {
        $websiteMsg = "";
    } else {
        $website = $_POST["website"];
        // 홈페이지 URL 주소의 입력 형식 검증
③      if (!filter_var($website, FILTER_VALIDATE_URL)) {
            $websiteMsg = "홈페이지의 주소를 정확히 입력해 주세요!";
        }
    }
```

2번 라인에서는 filter_var 함수에 인수로 FILTER_VALIDATE_EMAIL 검증 필터를 전달한다.
따라서 변수 $email에 저장된 값이 유효한 이메일 주소인가를 검증하고 유효한 이메일 주소라면 true를 반환할 것이다.
3번 라인에서는 filter_var() 함수에 인수로 FILTER_VALIDATE_URL 검증 필터를 전달한다.
따라서 변수 $website에 저장된 값이 유효한 URL 주소인가를 검증하고 유효한 URL 주소라면 true를 반환할 것이다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-Form-0b487910783646a28e625c48fbaa5d59?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_form_format](http://www.tcpschool.com/php/php_form_format)
