# [HTTP헤더] 응답 헤더

### ***HTTP 응답 헤더***

Ajax에서는 서버로부터 전달받은 HTTP 응답 헤더 내용을 다음 메소드를 이용하여 확인할 수 있다.

1. ***getAllResponseHeaders*** : HTTP 응답 헤더의 모든 헤더를 문자열로 반환한다.
2. ***getResponseHeader*** : HTTP 응답 헤더 중 인수로 전달받은 이름과 일치하는 헤더의 값을 
문자열로 반환한다.

```jsx
var httpRequest = new XMLHttpRequest();

httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
        document.getElementById("text").innerHTML = httpRequest.responseText;
        document.getElementById("header").innerHTML = httpRequest.getAllResponseHeaders();
        document.getElementById("user").innerHTML =
            "testheader: " + httpRequest.getResponseHeader("testheader");
    }
};

httpRequest.open("GET", "/examples/media/ajax_response_header.php", true);
httpRequest.send();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_header_response_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_header_response_01)

**ajax_response_header.php**

```php
<?php
    header("testheader: 123");
?>
<p id="ajax_text">Ajax에서는 서버로부터 전달받은 HTTP 응답 헤더의 내용을 확인할 수 있습니다.</p>
```

위의 예제처럼 PHP 파일에서 header 함수를 사용하여 HTTP 응답 헤더를 직접 작성하여 전달할 
수 있다.

<aside>
💡 PHP에서 header 함수를 사용할 때는 헤더의 이름과 콜론 사이에 *공백을 사용하면 안된다.* 또한, 콜론 다음에 사용된 첫 번째 공백은 무시되므로 공백 문자 사용에 주의를 기울여야 
한다.

</aside>

---

### ***Content-Type 헤더***

위의 예제에서 Content-Type 헤더의 값은 “text/html”로 설정되어 있다. Content-Type 헤더의 값을 직접 설정하지 않으면 HTML 문서의 MIME 타입인 “text/html”로 자동 설정된다. 

대부분의 Ajax 응용 프로그램에서 다루게 되는 XML은 일반적인 파일 형태의 XML 문서가 아니다.

Ajax 요청을 받은 후에 PHP와 같은 서버 프로그램이 실행되어 동적으로 생성되는 XML 형태의 
데이터이다. 

따라서 데이터의 확장자가 xml이 아니므로 header 함수를 사용하여 응답 데이터의 MIME 타입이 “text/xml” 이라고 명시해야만 한다.

```jsx
var httpRequest = new XMLHttpRequest();

httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
        document.getElementById("text").value = httpRequest.responseText;
				document.getElementById("header").innerHTML = httpRequest.getAllResponseHeaders();
        document.getElementById("user").innerHTML =
            "testheader: " + httpRequest.getResponseHeader("testheader");
    }
};

httpRequest.open("GET", "/examples/media/ajax_response_header_xml.php", true);
httpRequest.send();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_header_response_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_header_response_02)

**ajax_response_header_xml.php**

```php
<?php
    header("testheader: 123");
    header("Content-Type: text/xml");
    echo ("<?xml version=\"1.0\" encodeing=\"UTF-8\"?>\n"); ?>

<message>
    Ajax에서는 서버로부터 전달받은 HTTP 응답 헤더의 내용을 확인할 수 있습니다.
</message>
```
<br><br><br>
👉 노션 : https://www.notion.so/tgmary09/HTTP-f96c41566c694296ab17b2961af78cab
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_header_response](http://www.tcpschool.com/ajax/ajax_header_response)
