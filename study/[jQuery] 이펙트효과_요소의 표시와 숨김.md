# [jQuery] 이펙트효과_요소의 표시와 숨김

### *이펙트 효과*

제이쿼리는 웹 페이지에 이펙트 효과를 손쉽게 넣을 수 있는 다양한 메소드를 제공한다.
이러한 이펙트 효과는 기본 설정으로 바로 사용할 수도 있고 animate() 메소드를 통해 설정을 
변경하여 사용할 수도 있다.

---

### *요소의 표시와 숨김*

***hide*** 메소드는 선택한 요소를 순간적으로 사라지게 하고, ***show*** 메소드는 나타나게 한다.

hide 메소드를 통해 숨겨진 요소는 css display 속성값이 none으로 설정된다.
*즉, 이렇게 숨겨진 요소는 더는 웹 페이지의 레이아웃에 영향을 주지 않고 완전히 사라지게 된다.*

```jsx
$(function(){
	$('#showBtn').on('click',function(){
		$('#text').show();        // id가 text인 요소를 나타나게 함
	});
	$('#hideBtn').on('click',function(){
		$('#text').hide();        // id가 text인 요소를 숨김
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_showingHiding_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_showingHiding_01)

<aside>
💡 css의 visibility 속성의 속성값을 hidden 으로 설정해도 html 요소를 숨길 수 있다.
그러나 이때는 보이지만 않을 뿐 숨겨진 요소는 여전히 웹 페이지의 레이아웃에 영향을
주게 된다.

</aside>

*인수로 밀리초에 해당하는 숫자나 ‘slow’, ‘fast’ 등의 예약어를 전달하여 이펙트 효과의 속도를
조절할 수도 있다.*

```jsx
$(function(){
	$('#showBtn').on('click', function(){
		$('#text').show(2000);      // id가 text인 요소를 2초에 걸쳐 나타나게 함
	});
	$('#hideBtn').on('click', function(){
		$('#text').hide('fast');      // id가 text인 요소를 빠르게 숨김
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_showingHiding_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_showingHiding_02)

---

### *요소의 표시 상태 토글*

제이쿼리에서는 선택한 요소의 현재 표시 상태에 따라 다른 동작을 하는 ***toggle*** 메소드를 사용할 수 있다. 선택한 요소가 현재 사라진 상태라면 show 메소드의 동작을 수행하고, 나타나있는 상태라면
hide 메소드의 동작을 수행한다.

```jsx
$(function(){
	$('#toggleBtn').on('click',function(){
		$('#text').toggle('slow');        // id가 text인 요소를 느리게 나타나게 하거나 숨김
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_showingHiding_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_showingHiding_03)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-_-22ecddf609af4df589bb88de3c782f13
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_effect_showingHiding](http://www.tcpschool.com/jquery/jq_effect_showingHiding)
