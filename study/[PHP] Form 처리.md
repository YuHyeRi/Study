# [PHP] Form 처리

**Form 처리**

HTML form 요소가 전송한 데이터를 처리하기 위해서는 PHP와 같은 서버 사이드 스크립트 언어를 사용해야 한다.

form 요소에 대한 더 자세한 사항은 아래를 참고하자.

[HTML Form 요소 수업 확인 =>](http://www.tcpschool.com/html/html_input_forms)

다음 예제는 form 요소를 이용하여 사용자로부터 이름과 이메일을 입력받는 예제이다.

```html
<html>
<body>
	<form>
			이름 : <input type="text" name="name"><br>
			이메일 : <input type="text" name="email"><br>
			<input type="submit">
	</form>
</body>
</html>
```

위 예제처럼 form 요소의 action 속성값에는 form 요소를 처리할 서버의 PHP 스크립트 파일 주소를 명시한다.
그리고 전송(submit) 버튼을 누르면 PHP 스크립트로 form 요소를 통해 입력된 이름과 이메일 주소의 데이터가 전송된다.

다음 예제는 form 요소에서 전송한 데이터를 처리하는 PHP 스크립트의 예제이다.

```php
$name = $_POST["name"];
$email = $_POST["email"];

echo $name."님의 이메일 주소는 ".$email."입니다.";
```

위 예쩨처럼 form 요소에 포함된 input 요소의 name 속성값은 PHP 스크립트에서도 똑같이 사용된다.

---

**HTTP 요청 방식**

클라이언트인 브라우저가 서버에 HTTP 요청을 보낼 때는 다음 방식 중 하나를 사용한다.

1. GET 방식
2. POST 방식

두 방식 모두 form 요소를 통해 입력받은 데이터를 연관 배열에 담아 전송한다.
이 연관 배열의 키값은 input 요소의 name 속성값이 되며, 값은 사용자가 입력한 데이터가 된다. 
또한, 미리 선언된 전역 변수인 슈퍼 글로벌 배열($_GET, $_POST)을 사용하므로 어디에서든 제약 
없이 접근할 수 있다.

<aside>
💡 $_GET과 $_POST와 같은 슈퍼 글로벌 배열은 PHP 4.1.0부터 제공된다.

</aside>

<aside>
💡 input 요소의 name 속성값과 연관 배열의 키값은 모두 대소문자를 구분하니 주의해야 한다.

</aside>

---

**GET 방식**

GET 방식은 주소에 데이터(data)를 추가하여 전달하는 방식이다.

GET 방식의 HTTP 요청은 브라우저에 의해 캐시되어 저장된다.
또한 GET 방식은 보통 쿼리 문자열에 포함되어 전송되므로, 길이의 제한이 있다. 
따라서 보안상 취약점이 존재하므로 중요한 데이터는 POST 방식을 사용하여 요청하는 것이 좋다.

---

**POST 방식**

POST 방식은 데이터를 별도로 첨부하여 전달하는 방식이다.

POST 방식의 HTTP 요청은 브라우저에 의해 캐시되지 않으므로 브라우저 히스토리에도 남지 않는다.
또한 POST 방식의 HTTP 요청에 의한 데이터는 쿼리 문자열과는 별도로 전송된다. 
따라서 데이터의 길이에 대한 제한도 없으며 GET 방식보다 보안성이 높다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-Form-0acf2c2aa62b4382829dd75d62a6e3f9?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_form_handling](http://www.tcpschool.com/php/php_form_handling)
