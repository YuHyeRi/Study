# [jQuery] 자손 요소의 탐색

### ***.children()***

→ 선택한 요소의 자식 요소를 모두 선택한다. 
이 때 선택자를 인수로 전달하여 전달받은 선택자에 해당하는 자식 요소만을 선택할 수도 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("ul").children()                     // <ul>요소의 자식 요소를 모두 선택함.
            .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_descendantsTraversing_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_descendantsTraversing_01)
<br>

### *.find()*

→ 선택한 요소의 자손 요소 중에서 전달받은 선택자에 해당하는 자손 요소를 모두 선택한다. 
이 때 별표(*)를 인수로 전달하여 선택한 요소의 자손 요소를 모두 선택할 수도 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("li").find("*")                      // 각 <li>요소의 자손 요소을 모두 선택함.
            .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_descendantsTraversing_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_descendantsTraversing_02)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-7aa6779000d447da87930eb24b32a79a
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementTraversing_descendantsTraversing](http://www.tcpschool.com/jquery/jq_elementTraversing_descendantsTraversing)
