# [jQuery] 이벤트의 개념

### *이벤트(event)란?*

오늘날 웹 페이지는 사용자와 수많은 상호작용을 하게 된다.
사용자는 마우스를 움직이거나 요소를 클릭하거나 텍스트 박스에 글을 쓰는 등 
수많은 종류의 동작(action)을 수행한다.

위에서 예를 든 사용자의 동작들이 모두 이벤트(event)를 발생시킨다. 
즉, 이벤트가 발생했다는 것은 웹 페이지에서 특정 동작이 발생하여 웹 브라우저가 그 사실을 
알려주는 것을 의미한다.

---

### *이벤트 핸들러(event handler)*

웹 페이지에서는 수많은 이벤트가 계속해서 발생한다.
특정 요소에서 발생하는 이벤트를 처리하기 위해서는 이벤트 핸들러라는 함수를 작성하여 
연결해야만 한다. 

이벤트 핸들러가 연결된 특정 요소에서 지정된 타입의 이벤트가 발생하면 웹 브라우저는 연결된 
이벤트 핸들러를 실행한다.

다음 예제는 이벤트 핸들러를 작성하여 연결한 예제이다.

```jsx
$(function(){
	$('button').on({
		mouseenter: function(){
				$('#text').append('마우스가 버튼 위로 진입했어요!<br>');
			},
		click: function(){
				$('#text').append('마우스가 버튼을 클릭했어요!<br>');
			},
		mouseleave: function(){
				$('#text').append('마우스가 버튼 위에서 빠져나갔어요!<br>')
		}
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_handling_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_handling_03)

---

### *이벤트 객체(event object)*

이벤트 핸들러 함수는 이벤트 객체(event object)를 인수로 전달받을 수 있다. 
이렇게 전달받은 이벤트 객체를 이용하여 이벤트의 성질을 결정하거나, 
이벤트의 기본 동작을 막을 수도 있다.

제이쿼리의 이벤트 객체는 W3C 표준 권고안을 따르는 이벤트 객체를 정규화 한 것이다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-28406c9435874e8f977a7ae568ae60c1
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_event_concept](http://www.tcpschool.com/jquery/jq_event_concept)
