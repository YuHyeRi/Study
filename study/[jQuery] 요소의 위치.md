# [jQuery] 요소의 위치

제이쿼리는 선택한 요소의 위치 정보를 손쉽게 얻을 수 있도록 다양한 메소드를 제공한다.
<br>

### ***.offset() 메소드와 .position() 메소드***

offset 메소드는 선택한 요소 집합의 첫 번째 요소의 위치를 html 문서를 기준으로 반환한다.

```jsx
$(function() {
    $("button").on("click", function() {
        var paraPosition = $("#para").offset(); // id가 "para"인 요소의 위치 정보를 저장함.
        var str = "p 요소의 위치는 ";

        str += "left가 " + paraPosition.left + "픽셀이고,<br>"; // id가 "para"인 요소의 left 위치를 반환함.
        str += "top은 " + paraPosition.top + "픽셀입니다.";     // id가 "para"인 요소의 top 위치를 반환함.

        $("#text").html(str);
    });
});
```


또한 offset 메소드가 호출될 때 인수를 전달 받으면 선택한 요소의 위치를 인수로 전달받은 값으로 설정한다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#para").offset({ top: 200, left: 100 }); // id가 "para"인 요소의 위치를 설정함.

        var paraPosition = $("#para").offset();     // id가 "para"인 요소의 위치 정보를 저장함.
        var str = "p 요소의 위치는 ";

        str += "left가 " + paraPosition.left + "픽셀이고,<br>"; // id가 "para"인 요소의 left 위치를 반환함.
        str += "top은 " + paraPosition.top + "픽셀입니다.";     // id가 "para"인 요소의 top 위치를 반환함.

        $("#text").html(str);
    });
});
```


position 메소드는 offset 메소드와 달리,
선택한 요소가 웹 페이지에 위치할 때 기준이 되었던 부모 요소(offset parent)를 기준으로 하는 
상대 위치를 반환한다.

```jsx
$(function() {
    $("button").on("click", function() {
        var str = "";
        var offsetPosition = $("#para").offset(); // offset() 메소드를 사용해 id가 "para"인 요소의 위치 정보

        str += "offset() 메소드를 사용해 구한 p 요소의 위치는<br>";
        str += "left가 " + offsetPosition.left + "픽셀이고, ";    // id가 "para"인 요소의 left 위치를 반환함.
        str += "top은 " + offsetPosition.top + "픽셀입니다.<br>"; // id가 "para"인 요소의 top 위치를 반환함.

        var posPosition = $("#para").position();  // position() 메소드를 사용해 id가 "para"인 요소의 위치 정보

        str += "position() 메소드를 사용해 구한 p 요소의 위치는<br>";
        str += "left가 " + posPosition.left + "픽셀이고, ";       // id가 "para"인 요소의 left 위치를 반환함.
        str += "top은 " + posPosition.top + "픽셀입니다.";        // id가 "para"인 요소의 top 위치를 반환함.

        $("#text").html(str);

    });
});
```


***offset 메소드와 position 메소드의 차이점은 다음과 같다.***

| offset | position |
| --- | --- |
| html 문서를 기준 | 선택한 요소가 웹 페이지에 위치할 때 기준이 되는 부모 요소를 기준 |

### *기준이 되는 조상 요소*

position 메소드에서 기준으로 사용되는 부모요소는 ***offsetParent*** 메소드를 사용하여 확인할 수 있다

```jsx
$(function() {

    $("button").on("click", function() {
        // id가 "para"인 요소가 위치할 때 기준이 된 조상 요소를 선택함.
        $("#para").offsetParent()
            .css("border", "1px solid red"); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```


위의 예제에서 아이디가 para인 요소를 웹 페이지에 위치시킬 때 기준이 되는 부모요소는 
position 속성값이 relative로 설정된 ul 요소이다. 이렇게 정적 위치 지정방식을 제외한 다른 방식(relative, fixed, absolute)으로 위치가 설정된 요소가 위치를 정할 때 기준이 될 수 있다. 
*만약 위와 같은 위치가 설정된 요소가 존재하지 않으면, html 요소를 기준으로 삼게 된다.*

---

### ***.scrollLeft() 메소드와 .scrollTop() 메소드***

**scrollLeft 메소드는** 선택한 요소 집합의 첫 번째 요소의 수평 스크롤 바의 현재 위치를 얻거나, 
해당 요소의 수평 스크롤 바의 위치를 인수로 전달받은 값으로 설정한다.
**scrollTop 메소드는** 선택한 요소 집합의 첫 번째 요소의 수직 스크롤 바의 현재 위치를 얻거나, 
해당 요소의 수직 스크롤 바의 위치를 인수로 전달받은 값으로 설정한다.

다음 예제는 아이디가 divBox인 요소의 수평 스크롤 바와 수직 스크롤 바의 현재 위치를 출력하는 
예제이다.

```jsx
$(function() {
    $("button").on("click", function() {
        // id가 "divBox"인 요소의 수평 스크롤 바의 현재 위치를 반환함.
        var str = "수평 스크롤 바의 현재 위치는 left 방향으로 " + $("#divBox").scrollLeft() + "픽셀이고,<br>";

        // id가 "divBox"인 요소의 수직 스크롤 바의 현재 위치를 반환함.
        str += "수직 스크롤 바의 현재 위치는 top 방향으로 " + $("#divBox").scrollTop() + "픽셀입니다.";

        $("#text").html(str);
    });
});
```


다음 예제는 아이디가 divBox인 요소의 수평 스크롤바와 수직 스크롤바의 위치를 직접 설정하는 
예제이다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#divBox").scrollLeft(70); // id가 "divBox"인 요소의 수평 스크롤 바의 위치를 설정함.
        $("#divBox").scrollTop(200); // id가 "divBox"인 요소의 수직 스크롤 바의 위치를 설정함.

         // id가 "divBox"인 요소의 수평 스크롤 바의 현재 위치를 반환함.
        var str = "수평 스크롤 바의 현재 위치는 left 방향으로 " + $("#divBox").scrollLeft() + "픽셀이고,<br>";

        // id가 "divBox"인 요소의 수직 스크롤 바의 현재 위치를 반환함.
        str += "수직 스크롤 바의 현재 위치는 top 방향으로 " + $("#divBox").scrollTop() + "픽셀입니다.";

        $("#text").html(str);
    });
});
```


---

### *요소의 위치에 관한 메소드*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2de5b9c3-eeff-47e5-9208-679132a11798/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220805%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220805T012824Z&X-Amz-Expires=86400&X-Amz-Signature=f856fdc4ad69377a01579297790da521b310aebe6f4a41c023b75e361db4e413&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-298d5c841d6c4f78836a258b3b2f856b
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementDimension_position](http://www.tcpschool.com/jquery/jq_elementDimension_position)
