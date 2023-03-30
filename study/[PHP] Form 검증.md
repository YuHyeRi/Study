# [PHP] Form 검증

**Form 검증 (vaildation)**

HTML form 요소는 텍스트 입력, 체크박스, 라디오 버튼 등 다양한 input 요소를 포함할 수 있다.
이러한 input 요소별로 사용자가 입력한 데이터가 적합한 데이터인지를 검사하는 검증 규칙을 설정할 수 있다.

다음 예제는 여러 예제에서 계속 사용하게 될 form 요소를 이용한 간단한 회원가입 양식 예제이다.

```html
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    이름 : <input type="text" name="name">
    성별 :
    <input type="radio" name="gender" value="female">여자
    <input type="radio" name="gender" value="male">남자
    이메일 : <input type="text" name="email">
    홈페이지 : <input type="text" name="website">
    관심 있는 분야 :
    <input type="checkbox" name="favtopic[]" value="movie"> 영화
    <input type="checkbox" name="favtopic[]" value="music"> 음악
    <input type="checkbox" name="favtopic[]" value="game"> 게임
    <input type="checkbox" name="favtopic[]" value="coding"> 코딩
    기타 : <textarea name="comment"></textarea>
    <input type="submit" value="전송">
</form>
```

위의 form 예제에서는 method 속성값으로 “post”를 사용하여 POST 방식으로 HTTP 요청을 보내게 된다.
또한 form 요소의 action 속성값으로는 다음과 같은 PHP 코드를 사용하고 있다.

```php
<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>
```

위의 예쩨에서 사용된 $_SERVER는 PHP에서 제공하는 슈퍼 글로벌 인덱스로 “PHP_SELF”를 사용하면 현재 실행 중인 PHP 스크립트의 파일 이름을 반환한다.
htmlspecialchars() 함수는 인수로 전달받은 문자열에 포함된 특수 문자열을 HTML 엔티티로 변환해 준다.
이 함수를 사용함으로써 입력 문자열에 사용자가 안 좋은 의도로 HTML 코드를 삽입하는 것을 막을 수 있다.
따라서 위의 PHP 코드를 action 속성값으로 사용하면 해당 form 요소로 입력받은 데이터를 다른 
페이지로 전송하지 않고 현재 페이지로 보내게 된다.

[HTML 엔티티 수업 확인 =>](http://www.tcpschool.com/html/html_text_entities)

다음 예제는 사용자가 form 요소를 통해 입력한 데이터를 해당 페이지 자체에서 처리하는 예제이다.

```php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST["name"];
    $gender = $_POST["gender"];
    $email = $_POST["email"];
    $website = $_POST["website"];
    $favtopic = $_POST["favtopic"];
    $comment = $_POST["comment"];
}
```

위의 예제에서 사용된 $_SERVER["REQUEST_METHOD”]는 페이지에 접근하기 위해 사용된 HTTP 
요청 방식을 반환한다.
따라서 위의 예제는 POST 방식의 HTTP 요청에서만 동작할 것이다.

위의 예제에서 PHP 스크립트로 처리된 결과를 보여주는 코드는 다음과 같다.

```php
echo "<h2>입력된 회원 정보</h2>";
echo "이름 : ".$name."<br>";
echo "성별 : ".$gender."<br>";
echo "이메일 : ".$email."<br>";
echo "홈페이지 : ".$website."<br>";
echo "관심 있는 분야 : ";
if (!empty($favtopic)) {
    foreach ($favtopic as $value) {
        echo $value." ";
    }
}
echo "<br>기타 : ".$comment; ?>
```

위의 예제에서 관심있는 분야는 HTML 체크박스를 통해 여러 입력을 동시에 전달받는다.
따라서 변수$favtopic은 배열을 사용하여 입력된 값들을 보여주게 된다.

그러나 만약 사용자가 체크박스를 하나도 선택하지 않은 상태에서 입력을 전송하게 되면 배열을 
사용한 코드에서는 오류가 발생할 것이다.
따라서 위와 같이 먼저 empty() 함수를 사용하여 입력된 값이 하나라도 있는지를 검사한 후에 코드를 실행해야 안전하다.

<aside>
💡 위의 예제는 사용자가 입력한 데이터를 처리할 때 어떠한 검사도 하지 않는다.

</aside>

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-Form-5d12f08d590e4cdab4810b2b0cf11b8a?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_form_validation](http://www.tcpschool.com/php/php_form_validation)
