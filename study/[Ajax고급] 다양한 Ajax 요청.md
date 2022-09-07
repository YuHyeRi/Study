# [Ajax고급] 다양한 Ajax 요청

### *주기적으로 Ajax 요청하기*

Ajax는 클라이언트가 서버에 데이터를 요청하는 *클라이언트 풀링 방식*을 사용하므로 서버 푸시 방식의 실시간 서비스는 만들 수 없다. 
그러나 주기적으로 Ajax 요청을 보내도록 설정하여 실시간 서비스와 비슷한 동작을 하도록 만들 수는 있다.

다음 예제는 0.5초마다 주기적으로 Ajax 요청을 보내 현재 서버 시간을 출력하는 예제이다.

```jsx
function sendRequest() {
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
            document.getElementById("text").innerHTML = httpRequest.responseText;
        }
    };

    httpRequest.open("GET", "/examples/media/ajax_periodic_request.php");
    httpRequest.send();
}

sendRequest();
window.setInterval("sendRequest()", 500); // 매 0.5초마다 Ajax 요청을 보냄.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_request_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_request_01)

**ajax_periodic_request.php**

```php
<?php
    header("Pragma: no-cache"); // 이 두줄의 코드는 웹 브라우저에게 응답 내용을 캐시로 남기지 말라는
    header("Cache-Control: no-cache,must-revalidate");                // 의미를 전달하는 응답 헤더임.
    header("Content-Type: text/plain");
    $current = date("Y-m-d H:i:s");
    echo ("현재 서버 시간은 ".$current."입니다.");
?>
```

위의 예제에서는 0.5초마다 XMLHttpRequest 객체를 계속 초기화한다. 
이 때 서버에서의 응답이 0.5초 이상 걸리게 되면 화면에는 아무것도 표시되지 않을 수도 있다. 

따라서 setInterval 메소드보다 ***setTimeout*** 메소드를 사용하여 응답을 받고 일정 시간이 지난 후에 
다시 요청하는 것이 바람직하다.

다음 예제는 응답을 받고나서 0.5초가 지난 후에 sendRequest 함수를 다시 호출하는 예제이다.

```jsx
function sendRequest() {
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {

        if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
            document.getElementById("text").innerHTML = httpRequest.responseText;
            self.setTimeout("sendRequest()", 500); // 응답을 받은 후 0.5초 뒤에 다시 Ajax 요청을 보냄.
        }
    };

    httpRequest.open("GET", "/examples/media/ajax_periodic_request.php");
    httpRequest.send();
}

sendRequest();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_request_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_request_02)

---

### *데이터가 변경된 경우에만 Ajax 응답하기*

서버에 주기적으로 Ajax 요청을 계속하게 되면 네트워크와 서버의 자원을 많이 소모하게 된다. 

따라서 웹 페이지의 내용이 변경된 경우에만 서버가 응답을 보내도록 설정하는 것이 많은 자원을 
절약하게 만들 수 있다. 

이러한 방법은 Ajax 요청 헤더에 이전 요청 시간을 헤더로 포함해서 보내는 것으로 설정할 수 있다. 
그러면 서버는 전달받은 시간 이후에 변경된 내용이 있는 경우에만 응답하면 된다.

---

### *Ajax 요청 취소*

서버로 보낸 Ajax 요청에 대한 응답이 도착하기 전에 해당 요청으르 취소해야 할 때는 ***abort*** 메소드를 사용하면 된다.

```jsx
function abortRequest() {
	httpRequest.abort();
	document.getElementById("text").innerHTML = "Ajax 요청을 취소했습니다.";
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_request_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_request_03)

**ajax_request_abort.php**

```php
<?php
    sleep(3); // 3초 뒤에 Ajax 응답을 보냄.
    ...
?>
```

위의 예제에서 PHP 파일은 sleep 함수를 사용하여 3초 뒤에 Ajax 응답을 보낸다. 
그러나 응답이 오기 전에 abort 메소드를 호출하면 서버는 Ajax 응답으르 보내지 않을 것이다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/Ajax-Ajax-9d34b2a6bf8748658b0f7979c3b29312
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_advance_request](http://www.tcpschool.com/ajax/ajax_advance_request)
