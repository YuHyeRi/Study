# [jQuery] 요소의 복제 및 삭제

### ***요소의 복사***

선택한 요소나 콘텐츠를 복사하여 새로운 요소나 콘텐츠를 생성할 수 있다.

***🟣 .clone() : 선택한 요소를 복사하여 새로운 요소를 생성***

```jsx
$(function(){
	$('button').on('click',function(){
		// id가 'firstItem'인 요소를 복사하여 id가 'list'인 요소에 추가함
		$('#firstItem').clone().appendTo('#list');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_cloneDelete_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_cloneDelete_01)

다음 예제는 앞서 살펴본 .appendTo() 메소드의 예제이다

```jsx
$(function() {
    $("#firstBtn").on("click", function() {
        // id가 "list"인 요소의 맨 마지막에 id가 "firstItem"인 요소를 추가함.
        $("#firstItem").appendTo("#list");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_03)

.clone() 메소드는 기존의 html 요소를 복사하여 새로운 html 요소를 생성할 뿐이다. 
따라서 반드시 .append() 메소드나 .appendTo() 메소드와 같은 다른 메소드를 이용하여 요소를 추가해야 한다.

.clone() 메소드를 사용하지 않고 .appendTo() 메소드만을 사용하면, 
기존에 존재하는 html 요소를 그대로 추가하는 점이 다르다.

<aside>
💡 .appendTo() : 선택한 요소를 ‘해당 요소의 마지막’에 삽입해주는 메소드

</aside>

---
<br><br>

### ***요소의 대체***

선택한 요소나 콘텐츠를 지정된 요소나 콘텐츠로 대체할 수 있다.

***🟣 .replaceAll() : 선택한 요소를 지정된 요소로 대체함***

이 메소드는 인수로 선택자나 제이쿼리 객체, html dom 요소, 배열 등을 전달받을 수 있다.

```jsx
$(function() {
    $("button").on("click", function() {
        // class가 "item"인 각 요소를 id가 "firstItme"인 요소로 대체함.
        $("#firstItem").replaceAll(".item");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_cloneDelete_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_cloneDelete_02)
<br>

***🟣 .replaceWith() : 선택한 모든 요소를 지정된 요소로 대체함***

인수로 html 코드 형식의 문자열이나 제이쿼리 객체, html dom 요소, 배열 등을 전달받을 수 있다. 
또한, 선택한 요소를 대체할 수 있는 컨텐츠를 반환하는 함수를 인수로 전달받을 수 있다.

.replaceWith() 메소드 동작은 .replaceAll() 메소드와 비슷하지만 소스와 타겟의 위치가 서로 반대
이다. 또한 .replaceWith() 메소드는 지정된 요소로 대체되어 제거된 기존 요소를 반환한다.

```jsx
$(function() {
    $("button").on("click", function() {
        // class가 "item"인 모든 요소를 id가 "firstItme"인 요소로 대체함.
        $(".item").replaceWith($("#firstItem"));
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_cloneDelete_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_cloneDelete_03)

<aside>
💡 .replaceAll() 메소드와 .replaceWith() 메소드는 제거된 요소와 관련된 모든 데이터와 이벤트 핸들러도 같이 제거한다.

</aside>

---
<br><br>

### *요소의 삭제*

선택한 요소나 콘텐츠를 삭제할 수 있다.

***🟣 .remove() : 선택한 요소를 dom 트리에서 삭제함
 → 삭제된 요소와 연관된 제이쿼리 데이터나 이벤트도 함께 삭제함***

```jsx
$(function() {
    $("button").on("click", function() {
        // class가 "content"인 요소 중에서 class가 각각 "first", "second"인 요소를 모두 삭제함.
        $(".content").remove(".first, .second");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_cloneDelete_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_cloneDelete_04)
<br>

***🟣 .detach() : 선택한 요소를  dom 트리에서 삭제함
 → 삭제된 요소와 연관된 제이쿼리 데이터나 이벤트는 유지됨***

.detach() 메소드가 반환하는 제이쿼리 객체를 .append()나 .prepend()와 같은 메소드에 
인수로 전달하면 삭제한 요소를 다시 복구할 수도 있다.

```jsx
$(function() {
    var data;

    $("#detachBtn").on("click", function() {
        data = $(".content").detach(); // class가 "content"인 요소를 모두 삭제함.
    });
    $("#restoreBtn").on("click", function() {
        $("#container").append(data);  // detach() 메소드로 삭제되었던 모든 요소를 다시 추가함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_cloneDelete_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_cloneDelete_05)
<br>

***🟣 .empty() : 선택한 요소의 자식 요소를 모두 삭제함***

.remove()나 .detach() 메소드와는 달리 선택된 요소 그 자체는 삭제되지 않는다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#container").empty(); // id가 "container"인 요소의 자식 요소를 모두 삭제함.
   });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_cloneDelete_06](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_cloneDelete_06)
<br>

***🟣 .unwrap() : 선택한 요소의 부모 요소를 삭제함***

```jsx
$(function() {
    $("button").on("click", function() {
        $("span").unwrap(); // 모든 <span>요소의 부모 요소를 삭제함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_cloneDelete_07](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_cloneDelete_07)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-ded90be4246b4f88810effc8e745eff2
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementManupulating_cloneDelete](http://www.tcpschool.com/jquery/jq_elementManupulating_cloneDelete)
