# [jQuery] 제이쿼리 문법

제이쿼리를 사용하면 아주 간편하게 html 요소를 선택하고, 그렇게 선택된 요소에 손쉽게 특정 동작을 설정할 수 있다.

제이쿼리의 기본 문법은 다음과 같다.

```jsx
$(선택자).동작함수();
```

달러($) 기호는 제이쿼리를 의미하고 제이쿼리에 접근할 수 있게 해주는 식별자이다. 

선택자를 이용하여 원하는 html 요소를 선택하고 동작함수를 정의하여 선택된 요소에 원하는 동작을 설정한다.

---
<br>

### *$() 함수*

선택된 html 요소를 제이쿼리에서 이용할 수 있는 형태로 생성해주는 역할을 한다.
$() 함수의 인자로는 html 태그 이름 뿐만 아니라 css 선택자를 전달하여 특정 html 요소를 선택할 수 있다. 이러한 $() 함수를 통해 생성된 요소를 제이쿼리 객체(jQuery Object) 라고 한다. 
제이쿼리는 이렇게 생성된 제이쿼리 객체의 메소드를 이용하여 여러 동작을 설정할 수 있다.

---
<br>

### *Document 객체의 ready() 메소드*

자바스크립트 코드는 웹 브라우저가 문서의 모든 요소를 로드한 뒤에 실행되어야 한다. 
보통은 별다른 문제가 발생하지 않지만 다음과 같은 경우에는 오류가 발생한다.

- 아직 생성되지 않은 html 요소에 속성을 추가하려고 할 경우
- 아직 로드되지 않은 이미지의 크기를 얻으려고 할 경우

다음 예제는 아직 생성되지 않은 html 요소에 속성을 추가하는 예제이다.

```jsx
function func() {
		addAttribute();  // 아이디가 para인 html 요소에 속성을 추가함
		createElement(); // 아이디가 para인 html 요소를 생성함 
}

function createElement() {
		var criteriaNode = document.getElementById("text");
    var newNode = document.createElement("p") newNode.innerHTML = "새로운 단락입니다.";

    newNode.setAttribute("id", "para");
    document.body.insertBefore(newNode, criteriaNode);
}

function addAttribute() {
    document.getElementById("para").setAttribute("style", "color: red");
}
```

위의 예제에서 addAttribute() 함수는 아이디가 ‘para’인 html 요소에 새로운 속성을 추가하는 함수
이다. 또한  createElement() 함수는 아이디가 ‘para’인 html 요소를 생성하여 추가해주는 함수이다.
아이디가 ‘para’인 html 요소가 생성되기 전에 해당 요소에 속성을 추가해주는 addAttribute() 함수가 호출되므로 Uncaught TypeError가 발생하여 실행중이던 스크립트는 중지될 것이다.
만약 먼저 호출되는 addAttribute() 함수를 createElement() 함수 뒤에 호출하면 정상적으로 동작할 것이다.

그래서 자바스크립트에서는 Window 객체의 onload() 메소드를 이용하여 문서가 모두 로드된 뒤에 코드가 실행되도록 설정한다.

```jsx
window.onload = function() {
	자바스크립트 코드;
};
```

마찬가지로 제이쿼리에서는 Document객체의 ready() 메소드를 이용하여 같은 결과를 보장한다.

```jsx
$(document).ready(function(){
	제이쿼리 코드;
})
```

또한 jQuery Team에서는 같은 결과를 보장하는 더욱 짧은 문법을 다음과 같이 제공하고 있다.

```jsx
$(function(){
	제이쿼리 코드;
})
```

다음 예제는 문서가 모두 로드되는 시점과 창이 모두 로드되는 시점의 차이를 보여주는 예제이다.

```jsx
$(document).ready(function(){
	$('#doc').text('문서가 전부 로드됐어요!');
});

$(window).load(function(){
	$('#win')/text('창이 모두 로드됐어요!');
});
```

*결과*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/59122cfb-696a-4c55-99bf-87a6688a2aa9/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220714%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220714T044715Z&X-Amz-Expires=86400&X-Amz-Signature=80731efc12c054335e167946af64f2a134c9ea9c186ac42c6124184a48e8d171&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br><br>

👉 노션 : https://www.notion.so/tgmary09/jQuery-480dc3f0809d4918bba2379756cbc466
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_basic_syntax](http://www.tcpschool.com/jquery/jq_basic_syntax)
