## [jQuery] 필터링 메소드
<br>

### *.first(), .last()*

- .first() : 선택한 요소 중 첫 번 째 요소를 선택
- .last() : 마지막 요소를 선택

```jsx
$(function() {
    $("#firstBtn").on("click", function() {
        $("li").first()                           // 선택한 <li>요소 중에서 첫 번째 요소만을 선택함.
            .css({"border": "2px solid green"});  // 해당 요소의 CSS 스타일을 변경함.
    });

    $("#lastBtn").on("click", function() {
        $("li").last()                            // 선택한 <li>요소 중에서 마지막 요소만을 선택함.
            .css({"border": "2px solid orange"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_filtering_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_01)

---

### *.eq()*

선택한 요소 중에서 전달받은 인덱스에 해당하는 요소를 선택한다.
이 때, 선택한 요소 집합의 맨 처음 요소를 인덱스 0으로 놓고 앞에서부터 검색한다.
아래 예제처럼 .eq() 메소드는 *음의 정수*도 인수로 전달 받을 수 있다.
이 때는 ***선택한 요소 집합의 맨 마지막 요소를 인덱스 -1로 놓고 뒤에서부터 검색한다.***

```jsx
$(function() {
    $("#clockwiseBtn").on("click", function() {
        $("li").eq(1)                             // 선택한 <li>요소 중에서 두 번째 요소만을 선택함.
            .css({"border": "2px solid green"});  // 해당 요소의 CSS 스타일을 변경함.
    });

    $("#counterBtn").on("click", function() {
        $("li").eq(-1)                            // 선택한 <li>요소 중에서 뒤에서부터 첫 번째 요소만을 선택함.
            .css({"border": "2px solid orange"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_02)

---

### *.**filter()***

선택한 요소 중에서 전달받은 선택자에 해당하거나 함수 호출의 결과가 참(true)인 요소를 모두 선택한다. 이 메소드는 인수로 선택자나 제이쿼리 객체, html dom 요소 등을 전달받을 수 있다. 또한 요소 집합의 각 요소를 검사할 수 있는 함수를 전달할 수도 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("li").filter(":odd")                   // 선택한 <li>요소 중에서 인덱스가 홀수인 요소만을 선택함.
            .css({"border": "2px solid green"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_03)

odd 선택자는 인덱스가 홀수인 요소를 모두 선택하는 선택자이다.
*그러나 위의 예제에서 odd 선택자는 두 번째와 네 번째 요소를 선택해준다.*
***이 것은 제이쿼리의 인덱스가 언제나 0부터 시작하기 때문이다.***
따라서 odd나 even 선택자를 사용할 때는 언제나 인덱스가 0부터 시작한다는 사실을 염두해두고 사용해야 한다.

---

### *.not()*

선택한 요소 중에서 전달받은 선택자에 해당하거나, 함수 호출의 겨로가가 참(true)인 요소를 제외한 나머지 요소를 모두 선택한다.
즉, filter() 메소드와 정반대로 동작하여 요소를 선택한다.
아래 예제에서 .not() 메소드에 인수로 전달된 식별자는 ‘인덱스가 2보다 작은’ 이라는 의미를 가지는 식별자이다. 
따라서 .not() 메소드는 인덱스가 2보다 작지 않은, 즉 인덱스가 2인 요소와 2보다 큰 요소를 모두 선택해준다.

```jsx
$(function() {
    $("button").on("click", function() {
    // 선택한 <li>요소 중에서 인덱스가 2보다 작지 않은 요소만을 선택함.
    $("li").not(":lt(2)")
        .css({"border": "2px solid green"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_04)

---

추가 중





<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-10677e9d8b3e4e7aba910dd7fc888fae
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementTraversing_filtering](http://www.tcpschool.com/jquery/jq_elementTraversing_filtering)
