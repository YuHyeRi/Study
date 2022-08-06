# [jQuery] CSS 메소드

### *CSS 스타일 설정*

제이쿼리를 사용하면 선택한 요소의 스타일에 관한 속성값을 손쉽게 받아오거나 설정할 수 있다.

---

### *.css() 메소드*

제이쿼리에서는 css 메소드를 사용하여 선택한 요소의 css 스타일을 간단하게 설정할 수 있다. 
css 메소드는 선택한 요소 집합의 첫 번째 요소의 스타일 속성값을 반환하거나 선택한 요소의 스타일 속성을 인수로 전달받은 값으로 설정한다.

```jsx
$(function(){
	$('button').on('click',function()
		// 모든 p 요소의 폰트크기를 25px로 설정함
		$('p').css('fontSize', '25px');
	
		// 첫번째 p요소의 폰트크기를 반환함.
		$('#text').html($('p').css('fontSize'));
	)};
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_style_property_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_style_property_01)

위의 예제에서 사용된 첫 번째 css 메소드는 선택한 요소의 폰트 크기를 25px로 설정한다. 
그러나 두 번째로 사용된 css 메소드는 선택한 요소의 폰트 크기 값을 반환해주는 역할을 한다.

css 메소드를 사용하면 선택한 요소의 스타일에 관한 여러 속성값을 한번에 설정할 수도 있다.

```jsx
$(function(){
	$('button').on('click',function(){
		$('p').css({
			fontSize: '25px',
			backgroundColor: 'yellow'
		});
	});
});
```

<aside>
💡 자바스크립트에서는 하이픈(-)으로 연결된 css 속성명을 사용할 때,
***하이픈(-)을 제거하고 이름을 카멜케이스 방식으로 바꿔서*** 사용한다.

</aside>

제이쿼리에서 css 메소드에서는 하이픈(-)으로 연결된 css 속성명과 카멜케이스 방식의 속성명을 
둘 다 사용할 수 있다.

```jsx
$(function(){
	$('#fontSize').on('click',function(){
		$('p').css('fontSize', '25px'); // 자바스크립트와 제이쿼리 둘 다 사용 OK
	});		
	$('#backgroundColor').on('click',function(){
			$('p').css('backgroundColor', 'red'); // 제이쿼리에서만 사용OK
	});
});
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-CSS-51832179b4884cb3acd3f36909edbc19
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_style_property](http://www.tcpschool.com/jquery/jq_style_property)
