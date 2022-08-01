# [jQuery] 기타 탐색 메소드

### *add()*

→ 선택한 요소의 집합에 전달받은 요소를 추가

```jsx
$(function() {
    $("button").on("click", function() {
        $("li").add("p")                         // 선택한 <li>요소의 집합에 <p>요소를 추가함.
            .css({"border": "2px solid green"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_etc_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_etc_01)

다음 예제는 앞서 살펴본 .append() 메소드의 예제이다.

```jsx
(function() {
    $("button").on("click", function() {
        $("#list").append("<li>새로 추가된 아이템이에요!</li>");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_01)

위 예제에서 알 수 있듯이 .add() 메소드는 선택한 ‘요소의 집합’에 인수로 전달받은 요소를 추가하는 메소드이다. 
하지만 .append() 메소드는 선택한 ‘요소’의 마지막에 새로운 요소나 콘텐츠를 추가하는 메소드이다.
<br>

### *.each()*

→ 선택한 요소 집합의 요소마다 전달받은 콜백 함수를 실행

```jsx
$(function() {
    $("button").on("click", function() {
        $("li").each(function() {            // 선택한 <li>요소 집합의 각 <li>요소를 선택함.
            $(this).toggleClass("boldFont"); // 각 <li>요소마다 클래스를 추가하거나 제거함.
        });
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_etc_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_etc_02)

위의 예제는 선택한 <li> 요소 집합의 각 <li> 요소에 .each() 메소드를 사용하여 클래스를 추가
하거나 제거하는 예제이다. 이처럼 .each() 메소드를 사용하면 선택한 요소 집합의 각 요소마다
콜백 함수를 따로 실행시킬 수 있다.
<br>

### *.end()*

→ 마지막으로 실행한 메소드의 실행 전 상태로 선택한 요소의 집합을 복원해준다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#divBox")     // id가 "divBox"인 요소의
            .find("p")   // 자손 요소 중에서 <p>요소를 모두 선택하고,
            .end()       // 선택된 요소의 집합을 find() 메소드의 실행 전으로 복원함.
            .css("border", "2px solid green"); // 따라서 id가 "divBox"인 요소의 CSS 스타일을 설정함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_etc_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_etc_03)

위의 예제에서 .end() 메소드가 없다면 아이디가 ‘divBox’인 요소의 자손 요소 중에서 모든 <p> 요소에 스타일을 설정하게 될 것이다.
<br>

### *.offsetParent()*

→ 선택한 요소를 위치시킬 때 기준으로 사용된 조상 요소를 선택할 수 있다.

```jsx
$(function() {

    $("button").on("click", function() {
        // id가 "para"인 요소가 위치할 때 기준이 된 조상 요소를 선택함.
        $("#para").offsetParent()
            .css("border", "1px solid red"); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementDimension_position_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementDimension_position_04)

위의 예제에서 아이디가 ‘para’인 요소를 웹 페이지에 위치시킬 때 기준이 되는 부모 요소는 position 속성값이 relative로 설정된 <ul> 요소이다. 이렇게 정적 위치(static position) 지정 방식을 제외한 
다른 방식(relative, fixed, absolute)으로 위치가 설정된 요소가 위치를 정할 때 기준이 될 수 있다. 
만약 위와 같은 위치가 설정된 요소가 존재하지 않으면 <html> 요소를 기준으로 삼게 된다.
<br>

### *.contents()*

→ 선택한 요소의 자식 요소를 덱스트 노드와 주석 노드까지 모두 포함하여 선택해준다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("iframe")     // <iframe>요소의
            .contents() // 자식 요소를 모두 선택한 후,
            .find("a")  // 그 중에서 <a>요소를 모두 선택하고,
            .css("backgroundColor", "aqua"); // 선택된 모든 <a>요소의 CSS 스타일을 설정함.
    });
});
```

위의 예제는 <iframe> 요소의 모든 자식 요소를 선택한 후 그 중에서 <a> 요소만의 css 스타일을 변경하는 예제이다. 버튼을 누르면 <iframe> 요소에 로드된 모든 자식 요소 중 <a> 요소의 배경색만이 변경될 것이다. 이처럼 제이쿼리의 .contents() 메소드를 사용하면 <iframe> 요소의 내용에도 직접 접근할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/807c77ba-c7c3-42c9-b290-635de0c62afc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220801%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220801T093403Z&X-Amz-Expires=86400&X-Amz-Signature=384b057fd7d65f6af92d934d4878b9f814441bc158ac41bdbb4c3e80818f5aef&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-578f842b3ba7476da10dd8a87ae003c5
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementTraversing_etc](http://www.tcpschool.com/jquery/jq_elementTraversing_etc)
