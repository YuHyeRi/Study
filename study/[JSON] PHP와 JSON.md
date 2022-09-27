# [****JSON] PHP와 JSON****

PHP는 서버 측에서 실행되는 스크립트 언어이다. 
PHP는 개발자가 동적으로 웹 페이지를 쉽고 빠르게 만들 수 있도록 도와준다. 
이 때 서버로부터 읽어들이는 데이터로 JSON 데이터가 많이 사용된다.

따라서 PHP를 사용하여 JSON 데이터를 다뤄야할 필요성이 생긴다. 
PHP는 이러한 JSON 데이터를 다루기 위해 다음과 같은 메소드를 제공하고 있다.

1. json_encode()
2. json_decode()

### **json_encode() 함수**

PHP의 json_encode 함수는 전달받은 값을 JSON 형식의 문자열로 변환하여 반환한다.

```jsx
string json_encode(mixed $value)
```

$value에는 변환할 값을 전달하여, 이 값의 타입은 resource 타입을 제외한 PHP의 모든 타입이 
올 수 있다. 이 함수는 UTF-8로 인코딩 된 값을 인수로 전달해야만 정상적으로 동작한다. 

다음 예제는 json_encode 함수를 이용하여 PHP 배열을 문자열로 변환하는 예제이다.

```jsx
$value = array('apple'=>'Fruits', '1'=>1, '참'=>true); // PHP 배열
echo json_encode($value);
```

[http://www.tcpschool.com/examples/tryit/tryphp.php?filename=json_use_php_01](http://www.tcpschool.com/examples/tryit/tryphp.php?filename=json_use_php_01)

위의 예제처럼 한글은 UTF-8로 인코딩되어 유니코드 코드 포인트 값으로 저장된다.

<aside>
💡 json_encode() 함수는 PHP 5.2.0부터 제공됩니다.

</aside>

### **json_decode() 함수**

PHP의 json_decode() 함수는 전달받은 JSON 형식의 문자열을 PHP 변수로 변환합니다.

```jsx
mixed json_decode(string $json)
```

$json에는 변환할 문자열을 전달한다. 이 때 해당 문자열은 반드시 유효한 JSON 형식의 문자열이여야 한다. 만약 JSON 형식에 맞지 않는 문자열을 전달하면 json_decode() 함수는 null 값을 반환할 것입니다. 

또한, 두 번째 인수로 true를 전달하면 결과를 PHP 객체가 아닌 연관 배열로 반환해 준다. 
다음 예제는 json_decode 함수를 이용하여 JSON 형식의 문자열을 PHP 배열로 변환하는 예제이다.

```jsx
$json = '{"apple":"Fruits", "1":1, "참":true}';
var_dump(json_decode($json, true));
```

[http://www.tcpschool.com/examples/tryit/tryphp.php?filename=json_use_php_02](http://www.tcpschool.com/examples/tryit/tryphp.php?filename=json_use_php_02)

<aside>
💡 json_encode() 함수는 PHP 5.2.0부터 제공됩니다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-PHP-JSON-cd3b4b6d79474de0ab3c75fea21cbdb4
<br>

👉 출처 : [http://www.tcpschool.com/json/json_use_php](http://www.tcpschool.com/json/json_use_php)
