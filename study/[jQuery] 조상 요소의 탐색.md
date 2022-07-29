# [jQuery] 조상 요소의 탐색

## ***트리 탐색(tree traversing)***

특정 요소로부터 다른 요소들과의 관계를 통해 선택하길 원하는 요소까지 dom 트리를 
검색해 나아가는 과정을 의미한다.
이러한 트리 탐색은 다음과 같이 세 영역으로 나눌 수 있다.

1. 조상(ancestor) 요소 탐색
2. 형제(sibling) 요소 탐색
3. 자손(descendant) 요소 탐색

---
<br><br>

### ***조상(ancestor) 요소 탐색***

- **.parent()**
    
    → 선택한 요소의 부모 요소를 선택함
    
- **.parents()**
    
    → 선택한 요소의 조상 요소를 모두 선택함
    
- **.parentsUntil()**
    
    → 선택한 요소의 조상 요소 중에서 지정한 선택자에 해당하는 요소 바로 이전까지의 요소를 
    모두 선택함
    
- **.closest()**
    
    → 선택한 요소를 포함한 조상 요소 중에서 지정한 선택자에 해당하는 요소 중 
    가장 첫 번째 요소를 선택함
    

---
<br><br>

### *⭐ .parent()*

선택한 요소의 부모 요소를 선택한다. 
이 때 선택자를 인수로 전달하여 전달받은 선택자에 해당하는 부모 요소만을 선택할 수도 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("p").parent()                        // <p>요소의 부모 요소를 선택함.
            .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_AncestorTraversing_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_AncestorTraversing_01)
<br>

*👉 .css() 메소드는 선택한 요소에 인수로 전달받은 스타일을 설정한다.*
<br>

### *⭐ .parents()*

선택한 요소의 조상 요소를 모두 선택한다. 
이 때 선택자를 인수로 전달하여 전달받은 선택자에 해당하는 조상 요소만을 선택할 수도 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("p").parents("div")                  // <p>요소의 조상 요소 중에서 <div>요소를 모두 선택함.
            .css({"border": "2px solid red"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_AncestorTraversing_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_AncestorTraversing_02)
<br>

### *⭐ **.parentsUntil()***

선택한 요소의 조상 요소 중에서 전달받은 선택자에 해당하는 요소 바로 이전까지의 요소만을 
모두 선택한다. 이 때 선택자를 인수로 전달하지 않으면 .parent()와 같이 선택한 요소의 조상 요소를 모두 선택한다.

```jsx
$(function() {
    $("button").on("click", function() {
        // <p>요소의 조상 요소 중에서 첫 번째 <div>요소의 바로 이전까지의 요소를 모두 선택함.
        $("p").parentsUntil("div")
            .css({"border": "2px solid red"});    // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_AncestorTraversing_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_AncestorTraversing_03)
<br>

### *⭐ **.closest()***

자신을 포함한 조상 요소 중에서 전달받은 선택자에 해당하는 요소의 집합에서 
가장 첫 번째 요소를 선택한다. 이 메소드가 요소의 집합을 구하는 방식은 .parent() 메소드와 
비슷하지만 해당 요소의 조상 요소뿐만 아니라 해당 요소 자신까지도 검사하는 점이 다르다.

```jsx
$(function() {
    $("#parents").on("click", function() {
        // 아이디가 "origin"인 요소의 조상 요소 중에서 <div>요소를 모두 선택함.
        $("#origin").parents("div")
            .css({"border": "2px solid red"});
    });

    $("#closest").on("click", function() {
        // 아이디가 "origin"인 요소 자신과 조상 요소 중에서 첫 번째 <div>요소를 선택함.
        $("#origin").closest("div")
            .css({"border": "2px solid green"});
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_AncestorTraversing_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_AncestorTraversing_04)
<br><br>

👉 노션 : https://www.notion.so/tgmary09/jQuery-a731853b2ca949fc93d9d0f400d49221
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementTraversing_AncestorTraversing](http://www.tcpschool.com/jquery/jq_elementTraversing_AncestorTraversing)
