# [Ajax] $.ajax() 메소드

### *제이쿼리와 Ajax*

Ajax를 이용하여 개발을 손쉽게 할 수 있도록 미리 여러가지 기능을 포함해 놓은 개발 환경을 
Ajax 프레임워크라고 한다. 그 중에서도 가장 널리 사용되고 있는 Ajax 프레임워크는 바로 제이쿼리(jQuery) 이다.

---

### ***$.ajax() 메소드***

제이쿼리는 Ajax와 관련된 다양하고도 편리한 메소드를 많이 제공하고 있다.

그 중에서도 $.ajax 메소드는 모든 제이쿼리 Ajax 메소드의 핵심이 되는 메소드이다. 
$.ajax 메소드는 HTTP 요청을 만드는 강력하고도 직관적인 방법을 제공한다.

$.ajax 메소드의 원형은 다음과 같다.

<aside>
💡 $.ajax([옵션])

</aside>

*URL 주소는 클라이언트가 HTTP 요청을 보낼 서버의 주소이다.* 
*옵션은 HTTP 요청을 구성하는 키와 값의 쌍으로 구성되는 헤더의 집합이다.*

다음 예제는 $.ajax 메소드에서 사용할 수 있는 대표적인 옵션을 설명하는 예제이다.

```jsx
$.ajax({
    url: "/examples/media/request_ajax.php", // 클라이언트가 요청을 보낼 서버의 URL 주소
    data: { name: "홍길동" },                // HTTP 요청과 함께 서버로 보낼 데이터
		type: "GET",                             // HTTP 요청 방식(GET, POST)
		dataType: "json"                         // 서버에서 보내줄 데이터의 타입
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

다음 예제는 $.ajax 메소드의 동작을 보여주는 간단한 예제이다.

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

$.ajax 메소드에 대한 더 자세한 사항은 제이쿼리 Ajax 메소드 수업에서 확인할 수 있다.

[제이쿼리 Ajax 메소드 수업 확인 =>](http://www.tcpschool.com/jquery/jq_ajax_method)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/Ajax-ajax-ac359807023c4a14925c80865b4e6863
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_jquery_ajax](http://www.tcpschool.com/ajax/ajax_jquery_ajax)
