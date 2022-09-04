# [HTTP헤더] 요청 헤더

### *HTTP 헤더*

클라이언트와 서버 사이에 이루어지는 HTTP  요청과 응답은 HTTP  헤더를 사용하여 수행된다. 
HTTP  헤더는 클라이언트와 서버가 서로에게 전달해야 할 다양한 종류의 데이터를 포함할 수 있다.

다음 예제는 HTTP  요청 헤더의 예제이다.

```xml
Accept: */*
Referer: http://codingsam.com/examples/tryit/tryhtml.php?filename=ajax_header_request_01
Accept-Language: ko-KR
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko
Host: codingsam.com
DNT: 1
Connection: Keep-Alive
```

*HTTP 헤더는 위의 예제와 같이 헤더 이름, 콜론(:), 공백, 헤어 값의 순서로 구성된다.* 
일부 헤더는 요청 헤더와 응답 헤더에 모두 사용되지만 
일부 헤더는 요청 헤더나 응답 헤더 중 하나에서만 사용된다.

HTTP 요청 헤더는 원래 웹 브라우저가 자동으로 설정해서 보내므로 사용자가 직접 설정할 수 
없었다. 
그러나 Ajax를 사용하여 HTTP 요청 헤더를 직접 설정할 수도 있고 
HTTP 응답 헤더의 내용을 직접 확인할 수도 있다.

---

### *HTTP 요청 헤더*

Ajax에서는 요청을 보내기 전에 *setRequestHeader* 메소드를 사용하여 
HTTP 요청 헤더를 작성할 수 있다.

setRequestHeader 메소드는 다음과 같은 문법으로 설정한다.

<aside>
💡 XMLHttpRequest인스턴스.setRequestHeader(헤더이름, 헤더값);

</aside>

헤더 이름은 HTTP 요청 헤더에 포함하고자 하는 헤더의 이름이며 그 값도 같이 전달한다.

```jsx
var httpRequest = new XMLHttpRequest();

httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
        document.getElementById("text").innerHTML = httpRequest.responseText;
    }
};

httpRequest.open("GET", "/examples/media/ajax_request_header.php", true);
httpRequest.setRequestHeader("testheader", "123");
httpRequest.send();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_header_request_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_header_request_01)

**ajax_request_header.php**

```php
<?php // HTTP 요청 헤더의 이름과 값을 모두 출력함.
    header("Content-Type: text/plain");
    $requestHeaders = apache_request_headers();
    foreach ($requestHeaders as $requestHeaders => $value) {
        echo nl2br("$requestHeaders: $value\n");
    }
?>
```

위의 예제에서 setRequestHeader 메소드로 추가된 testheader 헤더는 123의 값을 가지고 
HTTP 요청 헤더에 포함된다. 이렇게 Ajax에서는 HTTP 요청 헤더를 직접 작성하여 사용할 수 있다.

<aside>
💡 HTTP 규약에서 사용하는 헤더 이름은 모두 첫 글자가 영문 대문자이다.

</aside>
<br><br><br>
👉 노션 : https://www.notion.so/tgmary09/HTTP-a80e0a528ba446f9ad92a9c666b883c4
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_header_request](http://www.tcpschool.com/ajax/ajax_header_request)
