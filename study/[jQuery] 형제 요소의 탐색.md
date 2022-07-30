# [jQuery] 형제 요소의 탐색

### *.siblings()*

→ 선택한 요소의 형제 요소 중에서 지정한 선택자에 해당하는 요소를 모두 선택

```jsx
$(function() {
    $("button").on("click", function() {
        $("h4").siblings()                 // <h4>요소의 형제 요소를 모두 선택함.
        .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_SiblingTraversing_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_SiblingTraversing_01)
<br>

### *.next()*

→ 선택한 요소의 바로 다음에 위치한 형제 요소를 선택

```jsx
$(function() {
    $("button").on("click", function() {
        $("h4").next()                     // <h4>요소의 바로 다음 형제 요소를 선택함.
            .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    }); 
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_SiblingTraversing_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_SiblingTraversing_02)
<br>

### *.nextAll()*

→ 선택한 요소의 다음에 위치한 형제 요소를 모두 선택

```jsx
$(function() {
    $("button").on("click", function() {
        $("h4").nextAll()                  // <h4>요소의 다음에 있는 형제 요소를 모두 선택함.
        .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_SiblingTraversing_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_SiblingTraversing_03)
<br>

### *.nextUntil()*

→ 선택한 요소의 형제 요소 중에서 지정한 선택자에 해당하는 요소 바로 이전까지의 요소를 모두 선택

```jsx
$(function() {
    $("button").on("click", function() {
        // <h4>요소의 형제 요소 중에서 첫 번째 <p>요소의 바로 이전까지의 모든 요소를 선택함.
        $("h4").nextUntil("p")
            .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_SiblingTraversing_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_SiblingTraversing_04)
<br>

- .prev() : 선택한 요소의 바로 이전에 위치한 형제 요소를 선택
- .prevAll() : 선택한 요소의 이전에 위치한 형제 요소를 모두 선택
- .prevUntil() : 선택한 요소의 형제 요소 중에서 지정한 선택자에 해당하는 요소 바로 다음까지의 요소를 모두 선택

⇒ 이 메소드들은 각각 .next(), .nextAll(), .nextUntil() 메소드와 정반대로 동작하여 요소들을 선택해 줌
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-6bf94afec7194eb6997b4bad97a98d25
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementTraversing_SiblingTraversing](http://www.tcpschool.com/jquery/jq_elementTraversing_SiblingTraversing)
