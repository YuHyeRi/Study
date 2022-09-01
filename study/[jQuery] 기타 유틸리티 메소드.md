# [jQuery] 기타 유틸리티 메소드

### *기타 유틸리티 메소드*

제이쿼리는 타입 검사 메소드 뿐만 아니라 편리한 기능을 제공하는 다수의 유틸리티 메소드를 
제공한다.

---

### ***$.each() 메소드***

$.each() 메소드는 객체나 배열에서 모두 사용할 수 있는 범용적인 반복함수이다.
length 속성이 있는 *배열이나 배열과 같은 객체를 전달받아 그 길이만큼 반복해서 콜백함수를 실행*한다. 객체의 경우에는 객체가 가지고 있는 프로퍼티의 개수만큼 반복해서 콜백함수를 실행한다.

다음 예제는 $.each() 메소드에 배열을 인수로 전달하여 각 배열 요소를 출력하는 예제이다.

```jsx
$(function() {
    $("button").on("click", function() {
        $.each([1, true, "JQuery"], function(index, value) {
            $("#text").append("배열의 " + (index + 1) + "번째 요소의 값은 " + value + "입니다.<br>");
        });
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_01)

다음 예제는 $.each() 메소드에 객체를 인수로 전달하여 객체의 각 프로퍼티를 출력하는 예제이다.

```jsx
$(function() {
    var kitty = {
					        name: "나비",
					        family: "코리안 숏 헤어",
					        age: 2
    }

    $("button").on("click", function() {
        $.each(kitty, function(key, value) {
            $("#text").append("해당 객체의 " + key + " 프로퍼티의 값은 " + value + "입니다.<br>");
        });
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_02)

---

### ***$.extend() 메소드***

$.extend() 메소드는 *두 개 이상의 객체의 모든 프로퍼티를 하나의 객체로 병합*한다.
이 메소드는 인수로 전달받은 첫 번째 객체에서 두 번째 객체의 모든 프로퍼티를 추가한다.
그리고서 첫 번째 객체에서 세 번째 객체의 모든 프로퍼티를 추가한다.
이와같은 순서대로 인수를 전달받은 모든 객체의 프로퍼티를 첫 번째 객체에 모두 추가한다.

```jsx
$(function() {
    var kitty = {
        name: "나비",
        family: "코리안 숏 헤어",
        age: 2
    }

    var owner = {
        name: "홍길동",
        region: "서울",
        gender: "남자"
    }

    var puppy = { name: "멍멍이" }
 
    $("button").on("click", function() {
        // kitty 객체에 owner 객체와 puppy 객체의 모든 프로퍼티를 합침.
        $.extend(kitty, owner, puppy);
        $.each(kitty, function(key, value) {
            $("#text").append("해당 객체의 " + key + " 프로퍼티의 값은 " + value + "입니다.<br>");
        });
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_03)

위의 예제는 kitty객체에 owner객체와 puppy객체의 모든 프로퍼티를 순서대로 병합한다.
이 때 중복되는 name 프로퍼티의 값은 **가장 마지막으로 추가된 값이 설정**된다.
따라서 name 프로퍼티의 값은 가장 마지막으로 병합한 puppy객체의 name 프로퍼티의 값으로 설정된다.

<aside>
💡 $.extend() 메소드에 인수로 전달되는 첫 번째 객체는 원본 객체 자체가 변형된다는 사실에 유의해야 한다.

</aside>

---

### ***$.trim() 메소드***

$.trim() 메소드는 문자열의 시작과 끝에 위치한 공백문자(whitespace)를 제거한다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#text").html($.trim("   문자열의 시작과 뒤에 많은 공백 문자가 있습니다!          "));
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_04)

---

### ***$.inArray() 메소드***

$.inArray() 메소드는 전달받은 값을 배열에서 검색한 후 값이 일치하는 요소의 인덱스를 반환한다.
만약 배열에 전달받은 값과 일치하는 요소가 없으면 -1을 반환한다.

```jsx
$(function() {
    $("button").on("click", function() {
        var arr = [1, true, "JQuery"];
        $("#text").html("해당 요소의 인덱스는 " + $.inArray(true, arr) + "입니다.");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_ectMethod_05)

---

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ba51e6ec-41c2-4a7e-87d6-8ff2926e9602/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220901%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220901T013613Z&X-Amz-Expires=86400&X-Amz-Signature=bfd3185d00c507cef6507ab144c294c9377f71a37009fc3af9cf8c90568db079&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9a3d0261-f87f-467e-8558-b6cb1d2cd5c4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220901%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220901T013638Z&X-Amz-Expires=86400&X-Amz-Signature=5b802a6a16ca73a478815e8be6ba421ee86daa0367ea04b767c6aa8db7a86986&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-ba0521c7eedb47cc956394cd82e0fc2b
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_utilityMethod_ectMethod](http://www.tcpschool.com/jquery/jq_utilityMethod_ectMethod)
