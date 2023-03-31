# [PHP] Form 필수 입력 검증

**필수 입력 검증**

필수 입력 검증이란 사용자가 반드시 입력해야 하는 필수 input 요소에 데이터가 모두 입력되었는지를 검증하는 것이다.

다음 예제는 앞선 예제에 이름, 성별, 관심 분야에 대해 필수 입력 검증을 추가한 예제이다.

```php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // 이름에 대한 필수 입력 검증
    if (empty($_POST["name"])) {
        $nameMsg = "이름을 입력해 주세요!";
    } else {
        $name = $_POST["name"];
    }

    // 성별에 대한 필수 입력 검증
①  if (!isset($_POST["gender"]) || $_POST["gender"]==false) {
        $genderMsg = "성별을 선택해 주세요!";
    } else {
        $gender = $_POST["gender"];
    }

    $email = $_POST["email"];
    $website = $_POST["website"];

    // 관심 있는 분야에 대한 필수 입력 검증
    if (empty($_POST["favtopic"])) 
        $favtopicMsg = "하나 이상 골라주세요!";
    } else {
        $favtopic = $_POST["favtopic"];
    }

    $comment = $_POST["comment"];
}
```

위의 예제는 서버로 전달된 입력 데이터를 empty 함수나 isset 함수로 검사하여 필수 입력에 해당
하는 데이터가 비어있다면 특정 메시지를 출력한다.

PHP에서 empty() 함수는 다음 구문과 완전히 같은 동작을 한다.

```php
!isset($var) || $var==false
```

따라서 1번 라인의 isset() 함수가 포함된 구문은 다음과 같은 empty() 함수로 대체할 수 있다.

```php
if (empty($_POST["gender"])) {
```

위의 예제는 전송받은 데이터를 서버 사이드에서 검증하여 필수 입력 데이터의 입력 여부를 검사
하는 예제이다.
이러한 필수 입력 검증은 클라이언트 사이드에서도 HTML의 required 속성을 이용하여 수행할 수 
있다.

[HTML5 Input 요소의 속성 수업 확인 =>](http://www.tcpschool.com/html/html5_element_inputattr)

위의 예제에서는 필수 입력 검증을 통해 필수 입력에 해당하는 데이터가 비어있으면, 다음 코드에 
특정 메시지를 출력한다.

```html
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
    <p class="alert">* : 필수 입력 사항</p>
    이름 : <input type="text" name="name"><span class="alert"> * <?php echo $nameMsg ?></span>
    성별 :
    <input type="radio" name="gender" value="female">여자
    <input type="radio" name="gender" value="male">남자 <span class="alert"> * <?php echo $genderMsg ?></span>
    이메일 : <input type="text" name="email">
    홈페이지 : <input type="text" name="website">
    관심 있는 분야 :
    <input type="checkbox" name="favtopic[]" value="movie"> 영화
    <input type="checkbox" name="favtopic[]" value="music"> 음악
    <input type="checkbox" name="favtopic[]" value="game"> 게임
    <input type="checkbox" name="favtopic[]" value="coding"> 코딩
    <span class="alert"> * <?php echo $favtopicMsg ?></span>
    기타 : <textarea name="comment"></textarea>
    <input type="submit" value="전송">
</form>
```

위와 같이 PHP 스크립트 코드는 HTML 문서의 어느 부분에나 위치할 수 있다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-Form-8c2ff9b76096410ba9e76463276d5f95?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_form_required](http://www.tcpschool.com/php/php_form_required)
