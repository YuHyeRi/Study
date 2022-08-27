# [jQuery] **Ajax_메소드**

### *$.ajax() 메소드*

제이쿼리는 Ajax와 관련된 다양하고도 편리한 많은 메소드를 제공한다.
그 중에서도 $.ajax() 메소드는 모든 제이쿼리 Ajax 메소드의 핵심이 되는 메소드이다.
$.ajax() 메소드는 HTTP 요청을 만드는 강력하고도 직관적인 방법을 제공한다.

$.ajax() 메소드의 원형은 다음과 같다.

```jsx
$.ajax(URL주소[,옵션])
```

*url 주소는 클라이언트가 HTTP 요청을 보낼 서버의 주소이다.*
옵션은 HTTP 요청을 구성하는 ***키와 값의 쌍으로 구성되는*** 헤더의 집합이다.

다음 예제는 $.ajax() 메소드에서 사용할 수 있는 대표적인 옵션을 설명하는 예제이다.

```jsx
$.ajax({
		url: '/examples/media/request_ajax.php',     // 클라이언트가 HTTP 요청을 보낼 서버의 url 주소
		date: {name: '홍길동'},   // HTTP 요청과 함께 서버로 보낼 데이터
		method: 'GET',           // HTTP 요청 방식(GET or POST)
		dataType: 'json'         // 서버에서 보내줄 데이터의 타입
})

// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
.done(function(json) {
    $("<h1>").text(json.title).appendTo("body");
    $("<div class=\"content\">").html(json.html).appendTo("body");
})

// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
.fail(function(xhr, status, errorThrown) {
    $("#text").html("오류가 발생했습니다.<br>")
    .append("오류명: " + errorThrown + "<br>")
    .append("상태: " + status);
})

// HTTP 요청이 성공하거나 실패하는 것에 상관없이 언제나 always() 메소드가 실행됨.
.always(function(xhr, status) {
    $("#text").html("요청이 완료되었습니다!");
});
```

다음 예제는 $.ajax() 메소드의 동작을 보여주는 간단한 예제이다.

```jsx
$(function() {
    $("#requestBtn").on("click", function() {
        $.ajax("/examples/media/request_ajax.php")
        .done(function() {
            alert("요청 성공");
        })

        .fail(function() {
            alert("요청 실패");
        })

        .always(function() {
            alert("요청 완료");
        });
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_method_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_method_01)

---

### ***load() 메소드***

load() 메소드는 선택한 요소에서 호출하는 유일한 제이쿼리 Ajax 메소드이다.
load() 메소드는 서버에서 데이터를 읽은 후 읽어들인 HTML 코드를 선택한 요소에 배치한다.
또한 선택자를 url 주소와 함께 전송하면 읽어들인 HTML 코드 중에서 선택자와 일치하는 요소만을 배치한다.

```jsx
$(function() {
    $("#requestBtn").on("click", function() {
        // URL 주소에 존재하는 HTML 코드에서 <li>요소를 읽은 후에 id가 "list"인 요소에 배치함.
        $("#list").load("/examples/tryit/htmlexample/jq_elementTraversing_etc_01.html li");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_method_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_method_02)

---

### *Ajax 메소드*

제이쿼리는 $.ajax() 메소드뿐만 아니라 Ajax와 관련된 다양한 메소드를 제공하고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cf37390c-db5d-4d0f-9ed4-7f5ffdeaa7a6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220827%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220827T043410Z&X-Amz-Expires=86400&X-Amz-Signature=bfe4498cf1bf829b3b6cc5c091423eeac62dd5de1e42e66583f8bc77e6719011&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-Ajax_-e96eed2ae66a46da9ca150701f184334
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_ajax_method](http://www.tcpschool.com/jquery/jq_ajax_method)
