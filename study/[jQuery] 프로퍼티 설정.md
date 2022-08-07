# [jQuery] 프로퍼티 설정

다음 메소드를 사용하면 특정 프로퍼티의 값을 읽어오거나 설정할 수 있다.

- .attr()
- .prop()
- .removeAttr()
- .removeProp()

---

### *.attr() 메소드*

선택한 요소 집합의 첫 번째 요소의 지정된 ***속성값***을 반환하거나 
선택한 요소의 지정된 속성을 전달받은 값으로 설정한다.

```jsx
$(function(){
	$('#setBtn').on('click',function(){
		// id가 word인 요소에 title 속성을 추가함
		$('#word').attr('title', '즐거운 제이쿼리 수업').css('color', 'red');
	});
	$('#removeBtn').on('click',function(){
		// 해당 요소에 title 속성을 제거함
		$('#word').removeAttr('title').css('color','black');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_style_property_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_style_property_04)

---

### *.prop() 메소드*

제이쿼리 1.6부터 새롭게 정의된 메소드이다.
이 메소드는 선택한 요소 집합의 첫 번째 요소의 지정된 ***프로퍼티값***을 반환하거나 
선택한 요소의 지정된 프로퍼티를 전달받은 값으로 설정한다.

```jsx
$(function(){
	$('#setBtn').on('click',function(){
		$('input[value="jquery"]').prop({   // input 요소 중에서 value 값이 jquery인 요소를 선택한 후
			checked: true                     // 해당 요소에 checked 프로퍼티를 true 값으로 설정함
		});
	});
	$('#removeBtn').on('click',function(){
		// 해당 요소에서 checked 프로퍼티를 사용함
		$('input[value="jquery"]').removeProp('checked');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_style_property_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_style_property_05)

---

### *속성(attribute)와 프로퍼티(property)의 차이점*

이를 알기 위해서는 우선 속성과 프로퍼티의 차이점을 알아야 한다.

***속성이란*** html 요소의 추가적인 정보를 가지고 있는 **이름과 값의 한 쌍**을 의미한다.

```jsx
// 다음의 input 요소는 checked라는 속성을 가지고 있으며, 
// 그 속성값은 checked이다.
<input id='check' type='checkbox' name='lecture' checked='checked'>
```

***프로퍼티란*** 위와 같은 속성을 객체화하였을 때의 **html dom 트리 내부에서의 값**을 가리킨다.

<aside>
💡 위의 예제에서 만약 해당 체크박스가 체크되면 check 노드의 프로퍼티 값은 true가 된다.

</aside>

***즉, 속성은 html 문서에 존재하고 값이 변하지 않으며, 
프로퍼티는 html dom 트리에 존재하고 그 값이 변할 수 있다.***

예를 들어, 사용자가 html 문서에 있는 input 요소를 체크하거나 자바스크립트를 이용하여 값을 
변경하면 속성값은 변하지 않지만 프로퍼티의 값은 변하게 되는 것이다.

---

### *attr 메소드와 prop 메소드의 차이점*

제이쿼리 1.6 이전에는 attr 메소드를 사용할 때 부정확한 동작을 일으키는 몇몇 속성에 대해 
해당 프로퍼티 값까지 고려해서 코드를 작성해야만 했다.

그러나 제이쿼리 1.6부터 attr 메소드는 속성만을 다루게 하고, 
새롭게 제공되는 prop 메소드를 이용하여 프로퍼티 값을 다루는 방법으로 이런 문제점을 해결했다.

```jsx
$(function(){
	$('#check').change(function(){
		$('#text').html('checked 속성의 속성값 : ' + $(this).attr('checked')
										+ '<br>checked 프로퍼티 값 : ' + $(this).prop('checked'));
	}).change();    // 값이 변할 때마다 갱신함
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_style_property_06](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_style_property_06)

---

### *css 스타일 설정에 관한 메소드*
<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/55d3217c-4c63-4013-a022-a1aff535bdec/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220807%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220807T022848Z&X-Amz-Expires=86400&X-Amz-Signature=f45134e686d85d1790e8aefdb930af5924c08f27d2cedd741f5a395f93e6d573&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-b799d66b3c5d4716a5ee09b67de69982
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_style_property](http://www.tcpschool.com/jquery/jq_style_property)
