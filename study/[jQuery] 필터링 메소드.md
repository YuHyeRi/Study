# [jQuery] 필터링 메소드

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
<br>

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
<br>

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
<br>

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
<br>

### *.has()*

선택한 요소 중에서 전달받은 선택자에 해당하는 요소를 자손 요소로 가지고 있는 요소를 모두 선택한다.
아래 예제는 선택한 <li> 요소 중에서 자손 요소로 <span> 요소를 가지고 잇는 요소만의 스타일을 변경하는 예제이다.

```jsx
$(function() {
    $("button").on("click", function() {
        // 선택한 <li>요소 중에서 자손 요소로 <span>요소를 가지고 있는 요소만을 선택함.
        $("li").has("span")
            .css({"border": "2px solid green"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_filtering_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_05)

---
<br>
    
### *.is()*

선택한 요소 중에서 전달받은 선택자에 해당하는 요소가 하나라도 존재하면 참을 반환한다.
아래 예제에서는 우선 선택한 span 요소의 모든 조상 요소를 다시 선택한다. 그리고서 선택된 모든 조상 요소 중에 ul 요소가 존재하는지 여부를 is 메소드를 통해 검사하고 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        // 선택한 <span>요소의 조상 요소 중에서 <ul>요소가 하나라도 존재하면 true를 반환함.
        if ($("span").parents().is("ul")) {
            $("#text").html("span 요소의 조상 요소에는 ul 요소도 존재합니다.");
        }
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_filtering_06](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_06)

---
<br>
    
### *.map()*

선택한 요소 집합의 각 요소마다 지정된 콜백 함수를 실행하고 그 반환값으로 구성된 제이쿼리 객체를 반환한다.
아래 예제는 선택한 li 요소 집합의 각 요소마다 해당 요소의 id값을 반환하는 콜백함수를 실행한다. 콜백함수의 실행으로 반환되는 값들은 get 메소드를 통해 하나의 배열로 반환되며 다시 join 메소드를 통해 하나의 문자열로 변환되어 반환된다.

```jsx
$(function() {
    $("button").on("click", function() {
        // 선택한 <li>요소마다 콜백함수를 실행하여 각 <li>요소의 id 값을 반환함.
        var ids = $("li").map(function() {
            return this.id;
        })

        .get()   // 반환된 모든 id 값을 하나의 배열로 반환함.
        .join(); // 배열의 모든 요소를 쉼표(,)로 구분하는 하나의 문자열로 반환함.
        $("#text").html(ids);
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_filtering_07](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_07)

---
<br>
    
### *.slice()*

선택한 요소 중에서 전달받은 인덱스 범위에 해당하는 요소만을 선택한다.
아래 예제는 선택한 li 요소 중에서 인덱스가 1과 같거나 그 이상인 요소만의 스타일을 변경하는 예제이다.

```jsx
$(function() {
    $("button").on("click", function() {
        // 선택한 <li>요소 중에서 인덱스가 1과 같거나 그 이상인 요소만을 선택함.
        $("li").slice(1)
            .css({"border": "2px solid green"}); // 해당 요소의 CSS 스타일을 변경함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementTraversing_filtering_08](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementTraversing_filtering_08)


<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-10677e9d8b3e4e7aba910dd7fc888fae
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementTraversing_filtering](http://www.tcpschool.com/jquery/jq_elementTraversing_filtering)
