# [jQuery] 이벤트의 처리

### *이벤트의 연결(event binding)*

특정 요소에서 발생하는 이벤트를 처리하기 위해서는 이벤트 핸들러함수를 작성해야만 한다.
이렇게 작성된 이벤트 핸들러를 특정 요소에 연결하는 것을 이벤트의 연결(event binding)이라고 
한다.
제이쿼리는 이벤트의 연결을 위한 다양한 방법을 제공한다.
다음 예제는 id가 btn인 요소에 클릭(click) 이벤트 핸들러를 연결하는 다양한 방법이다.

```jsx
1. $("#btn").click(function(event) { // 실행하고자 하는 제이쿼리 코드 });

2. $("#btn").bind("click", function(event) { // 실행하고자 하는 제이쿼리 코드 });

3. $("#btn").on("click", function(event) { // 실행하고자 하는 제이쿼리 코드 });

4. $("body").on({click: function(event) { // 실행하고자 하는 제이쿼리 코드 }}, "#btn");

5. $("body").on("click", "#btn", function(event) { // 실행하고자 하는 제이쿼리 코드 });
```

제이쿼리 1.7부터는 bind나 click 메소드를 사용해도 내부적으로 on 메소드를 이용하여 
이벤트 핸들러와 연결한다.

```jsx
$(function(){
	$('tbody').on({                      // tbody에
		click: function(){                 // click 이벤트가 발생했을 때
			$('#text').html('버튼을 클릭했습니다!');
		}
	}, '#btn');                         // id가 btn인 요소에 이벤트 핸들러를 등록함
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_handling_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_handling_01)

---

### *이벤트 처리의 발전*

제이쿼리의 발전에 따라 이벤트를 처리하는 방법 역시 변해왔다.
제이쿼리 1.0에서는 bind 메소드를 사용하여 이벤트 핸들러를 등록했다.
그 다음에는 live 메소드와 delegate 메소드를 거쳐 현재는 on 메소드를 이용하여 이벤트를 처리하고 있다.

---

### *.on() 메소드*

제이쿼리는 특정 요소에 이벤트를 연결(event binding)하기 위해 on 메소드를 사용한다.
제이쿼리 1.7부터 소개된 on 메소드는 다음과 같은 특징을 가진다.

1. 선택한 요소에 어떤 타입의 이벤트라도 연결할 수 있다.
2. 하나의 이벤트 핸들러에 여러 개의 이벤트를 동시에 연결할 수 있다.
3. 선택한 요소에 여러 개의 이벤트 핸들러와 여러 개의 이벤트를 같이 연결할 수 있다.
4. 사용자 지정 이벤트(custom event)를 위해 이벤트 핸들러로 데이터를 넘길 수 있다.
5. 차후에 다루게 될 요소를 이벤트에 연결할 수 있다.

on 메소드를 사용하면 하나의 이벤트 핸들러에 여러 개의 이벤트를 동시에 연결할 수 있다.

```jsx
$(function(){
	// 모든 button 요소에 mouseenter, mouseleave 이벤트를 설정함
	$('button').on('mouseenter mouseleave', function(){
		$('#text').append('마우스가 버튼 위로 진입하거나 빠져나갔어요!<br>');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_handling_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_handling_02)

또한 하나의 여소에 여러 개의 이벤트 핸들러를 사용하여 여러 개의 이벤트를 같이 연결할 수도 
있다.

```jsx
$(function(){
	$('button').on({            // 모든 button 요소에
		mouseenter: function(){   // mouseenter 이벤트를 설정함 
			$('#text').append('마우스가 버튼 위로 진입했어요!<br>');
		},
		click: function(){        // click 이벤트를 설정함
      $("#text").append("마우스가 버튼을 클릭했어요!<br>");
		},
		mouseleave: function(){   // mouseleave 이벤트를 설정함
			$("#text").append("마우스가 버튼 위에서 빠져나갔어요!<br>");
		}
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_handling_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_handling_03)

---

### *.one() 메소드*

one 메소드는 연결된 이벤트 핸들러가 한 번 실행되고 나서는 더이상 실행되지 않는다.
또한 같은 이벤트에 대해 연결된 이벤트 핸들러가 한 번 실행된 후에는 다른 이벤트 핸들러를 실행
하고 싶을 때도 사용할 수 없다.

```jsx
$(function(){
	$('button').one('click', function(){
		// 모든 button 요소가 처음 클릭되었을 때만 실행됨
		$('#text').append('첫번째 클릭이에요!<br>');
		// 모든 button 요소가 두 번째 클릭됐을 때부터는 아래 이벤트 핸들러가 실행됨
		$(this).click((){
			$('#text').append('이 버튼을 벌써 클릭했네요!<br>');
		});
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_handling_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_handling_04)

<aside>
💡 one 메소드는 on 메소드와 같은 인수를 전달받는다.
따라서 여러 개의 이벤트 핸들러와 여러 개의 이벤트를 가질 수 있는 등 on 메소드와 같은 특징을 갖는다.

</aside>

---

### *.off() 메소드*

off 메소드는 더는 사용하지 않는 이벤트와의 연결을 제거한다.

```jsx
$(function(){
	$('#clickBtn').on('click',function(){     // id가 clickBtn인 요소를 클릭했을 때 실행 됨
		$('#text').append('버튼을 클릭했어요!<br>');
	});
	$('#removeBtn').on('click',function(){
		$('#clickBtn').off('click');           // id가 clickBtn인 요소의 클릭 이벤트와의 연결을 제거함
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_handling_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_handling_05)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-179fc7e1afcc475ea5210848e8d8dbdb
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_event_handling](http://www.tcpschool.com/jquery/jq_event_handling)
