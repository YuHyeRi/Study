# [jQuery] 이벤트의 위임

### *이벤트의 위임(event delegation)*

제이쿼리는 이벤트의 위임을 통해 다수의 요소에 공통적으로 적용되는 이벤트 핸들러를 
공통된 조상 요소에 단 한 번만 연결하면 동작할 수 있도록 해준다.

다음 예제는 ul 요소의 자식 요소 중 a 요소에 대해 요소마다 각각 이벤트 핸들러를 직접 연결하는 
예제이다.

```jsx
$(function(){
	$('ul a').on('click', function(event){
		event.preventDefault();   // a 요소 클릭시 기본 동작인 하이퍼링크 작동을 중지시킴
		$('#text').append('이 링크는 동작하지 않습니다!<br>');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_delegation_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_delegation_01)

요소마다 직접 등록된 이벤트 핸들러는 현재 존재하는 a 요소에만 연결되며 새롭게 추가되는 요소
에는 연결되지 않는다.

```jsx
$(function(){
	$('ul a').on('click', function(){
		event.preventDefault();
		$('#text').append('이 링크는 동작하지 않습니다!<br>');
	});
	$('#button').one('click',function(){
		$('ul').append('<li><a href="/jquery/intro">jQuery</a></li>');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_delegation_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_delegation_02)

그러나 위의 예제에 이벤트의 위임을 이용한다면 다음과 같이 작성할 수 있다.

```jsx
$(function() {
    $("ul").on("click", "a", function(event) {
        event.preventDefault(); // <a>요소의 클릭시 기본 동작인 링크의 작동을 중지시킴.
        $("#text").append("이 링크는 동작하지 않습니다!<br>");
    });
    $("button").one("click", function() {
        $("ul").append('<li><a href="/jquery/intro">jQuery</a></li>');
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_delegation_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_delegation_03)

*on 메소드는 해당 요소에 첫 번째 인수로 전달받은 이벤트가 전파되었을 때, 그 이벤트를 발생한 
요소가 두 번째 인수로 전달받은 선택자와 같은지를 검사한다.

만약 이벤트가 발생한 요소와 두 번째 인수로 전달받은 선택자가 같으면 연결된 이벤트 핸들러를 
실행한다.*

---

### *이벤트의 전파(event propagation)*

이벤트의 전파란 이벤트가 발생하였을 때, 브라우저가 이벤트 핸들러를 실행시킬 대상 요소를 
결정하는 과정이다.

이벤트가 document 객체나 html 문서의 요소에서 일어나면 대상 객체를 결정하기 위해 이벤트의 
전파가 일어난다. 이렇게 이벤트가 전파되는 과정을 이벤트 버블링(event bubbling)이라고 한다.

이벤트 버블링은 이벤트가 발생한 요소부터 시작하여 dom 트리를 따라 위쪽으로 올라가며 전파
되는 과정을 의미한다.

즉, 이벤트가 발생한 요소에 연결된 이벤트 핸들러가 실행된 후 그 부모 요소에 연결된 핸들러가 
실행된다. 또다시 그 부모 요소에 등록된 핸들러가 실행되며 마지막에는 document 객체까지 계속 
전파된다.

이러한 전파를 통해 위와 같은 이벤트의 위임(event delegation)이 가능해진다.

이벤트의 전파(progation)에 대한 더 자세한 사항은 자바스크립트 이벤트 리스너 호출 수업에서 확인할 수 있다.

[자바스크립트 이벤트 리스너 호출 수업 확인](http://www.tcpschool.com/javascript/js_event_eventListenerCall)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-363034841fc741968abaaa1f463f025a
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_event_delegation](http://www.tcpschool.com/jquery/jq_event_delegation)
