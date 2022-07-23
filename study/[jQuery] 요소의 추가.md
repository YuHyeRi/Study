# [jQuery] 요소의 추가

제이쿼리는 새로운 요소나 콘텐츠를 손쉽게 추가할 수 있도록 여러 메소드를 제공한다.

### ***기존 요소의 내부에 추가***

다음 메소드를 사용하면 기존 요소의 내부에 새로운 요소나 콘텐츠를 추가할 수 있다.

- ***append()*** : 선택한 요소의 마지막에 새로운 요소나 콘텐츠를 추가
- ***prepend()*** : 선택한 요소의 처음에 새로운 요소나 콘텐츠를 추가
- ***appendTo()*** : 선택한 요소를 해당 요소의 마지막에 삽입
- ***prependTo()*** : 선택한 요소를 해당 요소의 처음에 삽입
- ***html()*** : 해당 요소의 html 콘텐츠를 반환하거나 설정
- ***text()*** : 해당 요소의 텍스트 콘텐츠를 반환하거나 설정
<br><br>

### ***.append() 메소드 →** 선택한 요소의 ‘마지막’에 새로운 요소나 콘텐츠를 추가*

```jsx
$(function(){
	$('button').on('click',function(){
		$('#list').append('<li>새로 추가된 아이템이에요!</li>');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_01)
<br><br>

### ***.prepend() 메소드 →** 선택한 요소의 ‘처음’에 새로운 요소나 콘텐츠를 추가*

```jsx
$(function() {
    $("button").on("click", function() {
       $("li").prepend("새로 추가된 콘텐츠에요!");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_02)
<br><br>

### ***.appendTo() 메소드 →** 선택한 요소를 ‘해당 요소의 마지막’에 삽입. 동작은 .append()와 같지만 소스와 타겟의 위치가 서로 반대이다.*

```jsx
$(function() {
    $("#firstBtn").on("click", function() {
        // id가 "list"인 요소의 맨 마지막에 id가 "firstItem"인 요소를 추가함.
        $("#firstItem").appendTo("#list");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_03)
<br><br>

### ***.prependTo() 메소드 →** 선택한 요소를 ‘해당 요소의 처음’에 삽입. 동작은 .prepend()와 같지만 소스와 타겟의 위치가 서로 반대이다.*

```jsx
$(function() {
    $("button").on("click", function() {
        $("<b>새로 추가된 콘텐츠에요!</b>").prependTo(".item");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_04)

---
<br><br>

### ***기존 요소의 외부에 추가***

다음 메소드를 사용하면 기존 요소의 앞이나 뒤에 새로운 요소나 콘텐츠를 추가할 수 있다.

- ***.before()*** : 선택한 요소의 바로 앞에 새로운 요소나 콘텐츠를 추가
- ***.after()*** : 선택한 요소의 바로 뒤에 새로운 요소나 콘텐츠를 추가
- ***.insertBefore()*** : 선택한 요소를 해당 요소의 앞에 삽입
- ***.insertAfter()*** : 선택한 요소를 해당 요소의 뒤에 삽입
<br><br>

### ***.before() 메소드 →** 선택한 요소의 ‘바로앞’에 새로운 요소나 콘텐츠를 추가*

```jsx
$(function(){
	$('button').on('click',function(){
		// id가 'firstRow'인 요소의 바로 앞에 새로운 <tr> 요소를 추가함
		$('#firstRow').before('<tr><td>새로운 행이에요!</td></tr>');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_05)
<br><br>

### ***.after() 메소드 →** 선택한 요소의 ‘바로뒤’에 새로운 요소나 콘텐츠를 추가*

```jsx
$(function() {
    $("button").on("click", function() {
        // id가 "firstRow"인 요소의 바로 뒤에 새로운 <tr>요소를 추가함.
        $("#firstRow").after("<tr><td>새로운 행이에요!</td></tr>");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_06](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_06)
<br><br>

### ***.insertBefore() 메소드 →** 선택한 요소를 ‘해당 요소의 앞’에 삽입. 동작은 .before()와 같지만 소스와 타겟의 위치가 서로 반대이다.*

```jsx
$(function() {
    $("button").on("click", function() {
        // id가 "secondColumn"인 요소의 바로 앞에 새로운 <td>요소를 추가함.
        $("<td>새로운 셀이에요!</td>").insertBefore("#secondColumn");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_07](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_07)
<br><br>

### ***.insertAfter() 메소드 →** 선택한 요소를 ‘해당 요소의 뒤’에 삽입. 동작은 .after()와 같지만 소스와 타겟의 위치가 서로 반대이다.*

```jsx
$(function() {
    $("button").on("click", function() {
        // id가 "secondColumn"인 요소의 바로 뒤에 새로운 <td>요소를 추가함.
        $("<td>새로운 셀이에요!</td>").insertAfter("#secondColumn");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_08](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_08)

---
<br><br>

### ***기존 요소를 포함하는 요소의 추가***

- ***.wrap()*** : 선택한 요소를 포함하는 새로운 요소를 추가함
- .**wrapAll()** : 선택한 모든 요소를 포함하는 새로운 요소를 추가함
- **.wraplnner()** : 선택한 요소에 포함되는 새로운 요소를 추가함
<br><br>

### ***.wrap() 메소드 → ‘선택한 요소’를 포함하는 새로운 요소를 추가***

```jsx
$(function() {
    $("button").on("click", function() {
        // class가 "content"인 각 요소를 포함하는 새로운 요소를 추가함.
        $(".content").wrap("<div class='wrapper'></div>");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_09](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_09)
<br><br>

### ***.wrapAll() 메소드 → ‘선택한 모든 요소’를 포함하는 새로운 요소를 추가***

```jsx
$(function() {
    $("button").on("click", function() {
        // class가 "content"인 모든 요소를 포함하는 새로운 요소를 추가함.
        $(".content").wrapAll("<div class='wrapper'></div>");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_10](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_10)
<br><br>

### ***.wraplnner() 메소드 → ‘선택한 요소에 포함되는’ 새로운 요소를 추가***

```jsx
$(function() {
    $("button").on("click", function() {
        // class가 "content"인 각 요소에 포함되는 새로운 요소를 추가함.
        $(".content").wrapInner("<div class='wrapper'></div>");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementManupulating_insert_11](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementManupulating_insert_11)



<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-1ef6275a0c744cd9a67f654566f791ef
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementManupulating_insert](http://www.tcpschool.com/jquery/jq_elementManupulating_insert)
