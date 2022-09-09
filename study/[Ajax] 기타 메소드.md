# [Ajax] 기타 메소드

### ***$.get() 메소드***

제이쿼리에서는 Ajax를 이용하여 GET 방식의 HTTP 요청을 구현한 $.get 메소드를 제공한다. 
이 메소드를 사용하면 서버에 GET 방식의 HTTP 요청을 보낼 수 있다.

$.get 메소드의 원형은 다음과 같다.

<aside>
💡 $.get(URL주소[,콜백함수]);

</aside>

URL 주소는 클라이언트가 HTTP 요청을 보낼 서버의 주소이다. 
콜백함수는 HTTP 요청이 성공했을 때 실행할 함수를 정의한다.

```jsx
$(function() {
    $("#requestBtn").on("click", function() {
        // GET 방식으로 서버에 HTTP 요청을 보냄.
        $.get("/examples/media/jquery_ajax_data.txt",

        function(data, status) {
            $("#text").html(data + status); // 전송받은 데이터와 전송 성공 여부를 보여줌.
        });
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_jquery_etc_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_jquery_etc_01)

---

### ***$.post() 메소드***

제이쿼리에서는 Ajax를 이용하여 POST 방식의 HTTP 요청을 구현한 $.post 메소드를 제공한다. 
이 메소드를 사용하면 서버에 POST 방식의 HTTP 요청을 보낼 수 있다.

$.post 메소드의 원형은 다음과 같다.

<aside>
💡 $.post(URL주소[,데이터][,콜백함수]);

</aside>

URL 주소는 클라이언트가 HTTP 요청을 보낼 서버의 주소이다. 
데이터는 HTTP 요청과 함께 서버로 보낼 데이터를 전달한다. 
콜백함수는 HTTP 요청이 성공했을 때 실행할 함수를 정의한다.

```jsx
$(function() {
    $("#requestBtn").on("click", function() {
        // POST 방식으로 서버에 HTTP 요청을 보냄.
        $.post("/examples/media/request_ajax.php",

            { name: "이순신", grade: "A+" },             // 서버가 필요한 정보를 같이 보냄.

            function(data, status) {
                $("#text").html(data + "<br>" + status); // 전송받은 데이터와 전송 성공 여부를 보여줌.
            }
        );
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_jquery_etc_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_jquery_etc_02)

---

### ***load() 메소드***

이 메소드는 선택한 요소에서 호출하는 유일한 제이쿼리 Ajax 메소드이다. 
이 메소드는 서버에서 데이터를 읽어들인 후에 해당 HTML 코드를 선택한 요소에 배치한다. 

이 때 선택자를 URL 주소와 함께 전송하면 읽어들인 HTML 코드 중에서 선택자와 일치하는 요소만을 배치한다.

```jsx
$(function() {
    $("#requestBtn").on("click", function() {
        // URL 주소에 존재하는 HTML 코드에서 <li>요소를 읽은 후에 id가 "list"인 요소에 배치함.
        $("#list").load("/examples/tryit/htmlexample/jq_elementTraversing_etc_01.html li");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_jquery_etc_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_jquery_etc_03)

load 메소드의 인수로 URL 주소와 함께 선택자를 전달할 때는 위의 예제와 같이 하나의 문자열로 
전송해야 한다. 이 때 URL 주소와 선택자는 띄어쓰기로 구분할 수 있다.

다음 예제는 test.txt 파일 내에서 아이디가 para인 요소만을 읽어들여 아이디가 box인 요소 안에 
배치하는 예제이다.

```jsx
$("#box").load("test.txt #para");
```

---

### ***Ajax 메소드***

제이쿼리는 Ajax와 관련된 다양한 메소드를 제공하고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/923b38be-29b6-43f8-bdba-07e9a79f6cfc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220909%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220909T235059Z&X-Amz-Expires=86400&X-Amz-Signature=a47bd273d966686d7372fccb30a21dad4608b864e61da7ab0bb4c12b6a7c8ce9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br><br>
👉 노션 : https://www.notion.so/tgmary09/Ajax-d9bd2a0f6403434e90391f1bb4cfd04d
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_jquery_etc](http://www.tcpschool.com/ajax/ajax_jquery_etc)
