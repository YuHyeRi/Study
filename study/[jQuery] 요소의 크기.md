# [jQuery] 요소의 크기

제이쿼리는 선택한 요소의 크기에 관한 정보를 손쉽게 받아오거나 설정할 수 있도록 다양한 메소드를 제공한다.

---

### *inner와 outer*

제이쿼리에서 요소의 크기는 다음과 같이 구성된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/65abd721-62a4-4e26-ac3a-f36a2969ac50/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220804%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220804T020130Z&X-Amz-Expires=86400&X-Amz-Signature=5ae53caf2899dd998c00c60fbb858da12465a95640896e68d51c97e8a93c419d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

접두사로 inner가 붙은 메소드는 선택한 요소의 크기에 패딩(padding) 영역이 포함된 크기 정보를 
반환한다. 
접두사로 outer가 붙은 메소드는 패딩 영역 뿐만 아니라 테두리(border) 영역까지 포함된 크기 정보를 반환한다. 또한 접두사로 outer가 붙은 메소드에 인수로 true 값을 전달하면 패딩과 테두리 영역 뿐만 아니라 마진(margin) 영역까지 포함된 크기 정보를 반환한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d3910afb-43a0-46f6-b219-18f7441dfddf/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220804%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220804T020147Z&X-Amz-Expires=86400&X-Amz-Signature=5085df12197756a17ad901465d15a1b13b26f6b406f30b62e20d4a0ba47998c5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---
<br>

### ***.width()와 .height() 메소드***

width 메소드는 선택한 요소 집합의 첫 번째 요소의 너비를 반환하거나 선택된 요소의 너비를 
전달된 값으로 설정한다.
height 메소드는 width 메소드와 같은 동작을 높이에 대해 실행한다.

```jsx
$(function() {
    $("button").on("click", function() {
        var str = "이 div 요소의 ";
        str += "너비는 " + $("#divBox").width() + "픽셀이고,<br>"; // id가 "divBox"인 요소의 너비를 반환함.
        str += "높이는 " + $("#divBox").height() + "픽셀입니다."   // id가 "divBox"인 요소의 높이를 반환함.
        $("#text").html(str);
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementDimension_size_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementDimension_size_01)
<br>

이 메소드들을 이용하면 브라우저의 뷰포트(viewport)나 html 문서의 크기도 알아낼 수 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        var str = "";
        str += "브라우저 뷰포트의 크기는 " + $(window).width() + "X" + $(window).height() + "입니다.<br>";
        str += "HTML 문서의 크기는 " + $(document).width() + "X" + $(document).height() + "입니다.";
        $("#text").html(str);
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementDimension_size_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementDimension_size_02)
<br>

width와 height 메소드가 호출될 때 인수를 전달 받으면 선택된 요소의 크기를 인수로 전달받은 
값으로 설정한다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#divBox").width("400");  // id가 "divBox"인 요소의 너비를 설정함.
        $("#divBox").height("200"); // id가 "divBox"인 요소의 높이를 설정함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementDimension_size_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementDimension_size_03)

---
<br>

### ***다양한 크기 정보를 반환하는 메소드***

다음 예제는 위에서 살펴본 크기 정보를 반환하는 다양한 메소드 사이의 차이점을 확인하는 
예제이다.

```jsx
$(function() {
    $("button").on("click", function() {
        var str = "이 div 요소의 ";
        // id가 "divBox"인 요소의 크기를 반환함.
        str += "크기는 " + $("#divBox").width() + "X" + $("#divBox").height() + "이고,<br>";
        // id가 "divBox"인 요소의 패딩 영역을 포함한 크기를 반환함.
        str += "패딩 영역을 포함한 크기는 " + $("#divBox").innerWidth() +
            "X" + $("#divBox").innerHeight() + "이고,<br>";
        // id가 "divBox"인 요소의 패딩 영역과 테두리를 포함한 크기를 반환함.
        str += "테두리까지 포함한 크기는 " + $("#divBox").outerWidth() +
            "X" + $("#divBox").outerHeight() + "이고,<br>";
        // id가 "divBox"인 요소의 패딩 영역과 테두리, 마진 영역까지 포함한 크기를 반환함.
        str += "마진 영역까지 포함한 크기는 " + $("#divBox").outerWidth(true) +
            "X" + $("#divBox").outerHeight(true) + "입니다.";
        $("#text").html(str);
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementDimension_size_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementDimension_size_04)

---
<br>

### *요소의 크기에 관한 메소드*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/30786883-4939-4ab1-b64d-a76ad5bf22a5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220804%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220804T020204Z&X-Amz-Expires=86400&X-Amz-Signature=7f1051c46ae072e2e90e81c3abc0de2bd5161e46b749c7553e5b9ada302a0e86&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-6afdcdc04f1b4220ba99cabad02e896a
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementDimension_size](http://www.tcpschool.com/jquery/jq_elementDimension_size)
