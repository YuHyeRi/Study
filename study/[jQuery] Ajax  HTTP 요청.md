# [jQuery] **Ajax : HTTP 요청**

### *HTTP 요청 방식*

클라이언트인 브라우저가 서버에 HTTP 요청을 보낼 때는 다음 방식 중 하나를 사용한다.

- GET 방식
- POST 방식

---

### *GET 방식*

GET 방식은 *주소에 데이터(data)를 추가*하여 전달하는 방식이다.
GET 방식의 HTTP 요청은 브라우저에 의해 캐시되어(cached) 저장된다.
또한 GET 방식은 보통 쿼리 문자열(query string)에 포함되어 전송되므로 길이의 제한이 있다.
따라서, *보안상 취약점이 존재*하므로 중요한 데이터는 POST 방식을 사용하여 요청하는 것이 좋다.

---

### *POST 방식*

POST 방식은 데이터(data)를 별도로 첨부하여 전달하는 방식이다.
POST 방식의 HTTP 요청은 브라우저에 의해 캐시되지 않으므로 브라우저 히스토리에도 남지 않는다.
또한 POST 방식의 HTTP 요청에 의한 데이터는 쿼리 문자열과는 별도로 전송된다.
따라서, 데이터의 길이에 대한 제한도 없으며 *GET 방식보다 보안성*이 높다.

---

### *GET 방식와 POST 방식의 비교*

| 특징 | GET 방식 | POST 방식 |
| --- | --- | --- |
| 캐시화 | 캐시될 수 ⭕ | 캐시되지 ❌ |
| 브라우저 
히스토리 | 히스토리에 쿼리 문자열이 기록 | 히스토리에 기록되지 않음 |
| 데이터 길이 | 데이터의 길이가 url 주소의 길이 이내로 
제한됨
(익스플로러에서 url 주소가 가질 수 있는 최대 길이는 2,083자이며 이 중에서 순수 경로 길이는 2,048자까지만 허용됨) | 제한 없음 |
| 데이터 타입 | 오직 ASCII 문자 타입의 데이터만 전송할 수 있음 | 제한 없음 |
| 보안성 | 데이터가 url 주소에 포함되어 전송되므로 아무나 볼 수 있어 보안에 매우 취약 | 브라우저 히스토리에도 기록되지 않고 데이터가 따로 전송되므로 GET 방식보다 보안성이 높음 |

<aside>
💡 현재 주요 웹 브라우저에서 사용할 수 있는 url 주소의 최대 길이는 익스플로러를 제외하면
제한을 두지 않고 있다.

</aside>

---

### *$.get() 메소드*

제이쿼리에서는 Ajax를 이용하여 GET 방식의 HTTP 요청을 구현한 $.get() 메소드를 제공한다.
이 메소드를 사용하면 서버에 GET 방식의 HTTP 요청을 보낼 수 있다.

$.get() 메소드의 원형은 다음과 같다.

```jsx
$.get(URL주소[,콜백함수]);
```

url 주소는 클라이언트가 HTTP 요청을 보낼 서버의 주소이다. 
콜백함수는 HTTP 요청이 성공했을 때 실행할 함수를 정의한다.

```jsx
$(function() {
    $("#requestBtn").on("click", function() {
        // GET 방식으로 서버에 HTTP Request를 보냄.
        $.get("/examples/media/request_ajax.php",
            { species: "고양이", name: "나비", age: 3, }, // 서버가 필요한 정보를 같이 보냄.
            function(data, status) {
                $("#text").html(data + "<br>" + status); // 전송받은 데이터와 전송 성공 여부를 보여줌.
            }
        );
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_httpRequest_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_httpRequest_01)

---

### *$.post() 메소드*

제이쿼리에서는 Ajax를 이용하여 POST 방식의 HTTP 요청을 구현한 $.post() 메소드를 제공한다.
이 메소드를 사용하면 서버에 POST 방식의 HTTP 요청을 보낼 수 있다.

$.post() 메소드의 원형은 다음과 같다.

```jsx
$.post(URL주소[,데이터][,콜백함수]);
```

url 주소는 클라이언트가 HTTP 요청을 보낼 서버의 주소이다.
데이터는 HTTP 요청과 함께 서버로 보낼 데이터를 전달한다.
콜백함수는 HTTP 요청이 성공했을 때 실행할 함수를 정의한다.

```jsx
$(function() {
    $("#requestBtn").on("click", function() {
        // POST 방식으로 서버에 HTTP Request를 보냄.
        $.post("/examples/media/request_ajax.php",
            { name: "홍길동", grade: "A" },              // 서버가 필요한 정보를 같이 보냄.
            function(data, status) {
                $("#text").html(data + "<br>" + status); // 전송받은 데이터와 전송 성공 여부를 보여줌.
            }
        );
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_httpRequest_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_httpRequest_02)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-Ajax-HTTP-809771dc2d634076afa6048494e19123
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_ajax_httpRequest](http://www.tcpschool.com/jquery/jq_ajax_httpRequest)
