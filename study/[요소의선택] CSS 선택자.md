# [요소의선택] CSS 선택자

### *요소의 선택*

제이쿼리를 사용하면 손쉽게 html 요소를 선택하여 선택된 요소에 특정 동작을 설정할 수 있다.
제이쿼리에서는 요소를 선택하기 위해 대부분의 css 선택자뿐만 아니라 몇몇 비표준 선택자까지 
제공하고 있다.
<br><br>

### *CSS 선택자를 이용한 선택*

제이쿼리에서는 CSS 선택자를 사용하여 html 요소를 선택할 수 있다.
태그 이름을 사용하여 같은 태그 이름을 가지는 html 요소를 모두 선택할 수 있다. 
이것은 자바스크립트의 ***getElementsByTagName()*** 메소드와 같은 동작을 한다.

```jsx
$(function(){
	$('p').on('click', function(){          // p 요소를 모두 선택함
		$('span').css('fontSize', '28px');    // span 요소를 모두 선택함
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementSelection_cssSelector_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_cssSelector_01)
<br><br>

***아이디***를 사용하여 특정 html 요소를 선택할 수도 있다.
이것은 자바스크립트의 ***getElementById()*** 메소드와 같은 동작을 한다.

```jsx
$(function(){
	$('p').on('click', function(){
		$('#jq').css('boarder', '2px solid orange');  // 아이디가 jq인 요소를 선택함
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementSelection_cssSelector_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_cssSelector_02)
<br><br>

***클래스***를 사용하여 같은 클래스에 속하는 html 요소를 모두 선택할 수 있다. 
이것은 자바스크립트의 ***getElementByClassName()*** 메소드와 같은 동작을 한다.

```jsx
$(function(){
	$('p').on('click', function(){
		$('.jq').css('backgroundColor', 'lightgary');   // 클래스가 jq인 요소를 모두 선택함
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementSelection_cssSelector_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_cssSelector_03)
<br><br>

***속성***을 사용하여 속성이 조건에 맞는 특정 html 요소를 선택할 수 있다.

```jsx
$(function(){
	$('button').on('click', function(){
		$("img[alt='flower']").attr("src", "/examples/images/img_monalisa.png");
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_elementSelection_cssSelector_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_cssSelector_04)
<br><br>

👉 노션 : https://www.notion.so/tgmary09/CSS-919cbf2a3c8f40e59f7ae16ecc506dc0
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementSelection_cssSelector](http://www.tcpschool.com/jquery/jq_elementSelection_cssSelector)
