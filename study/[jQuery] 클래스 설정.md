# [jQuery] 클래스 설정

html 요소의 class 속성은 여러 개의 class 값을 가질 수 있다.
제이쿼리는 html 요소의 class 속성값을 손쉽게 다루기 위한 여러 메소드를 제공한다. |이를 통해 class 속성에 적용되는 css 스타일이 동적으로 적용되게 할 수 있다.

1. .addClass()
2. .removeClass()
3. .toggleClass()
4. .hasClass()

---

### *클래스의 추가 및 제거*

**addClass** 메소드로 클래스를 간단히 추가하고 
**removeClass** 메소드로 클래스를 손쉽게 제거할 수 있다.

```jsx
$(function(){
	$('#addBtn').on('click',function(){
		// id가 first, third인 요소에 lined이라는 클래스를 추가함
		$('#first, #third').addClass('lined');
	});
	$('#removeBtn').on('click',function(){
		// id가 first, third인 요소가 lined이라는 클래스에 포함되면 해당 클래스를 삭제함
		$('#first, #third').removeClass('lined');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_style_class_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_style_class_01)

단순히 클래스만을 추가하는 것이 아니라 클래스에 미리 스타일을 설정하여 
해당 클래스에 속한 모든 요소에 한꺼번에 적용하는 것이다.

또한 **toggleClass** 메소드를 이용하여 **클래스의 추가와 제거를 번갈아 시행**할 수도 있다.

다음 예제는 toggleClass 메소드를 이용하여 위의 예제를 조금 더 간단히 만들어본다.

```jsx
$(function(){
	$('button').on('click',function(){
		// id가 first, third인 요소에 lined이라는 클래스를 추가하고 
		// 다시 한 번 클릭하면 제거함
		$('#first, #third').toggleClass('lined');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_style_class_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_style_class_02)

---

### *클래스의 확인*

**hasClass** 메소드를 이용하여 해당 요소가 특정 클래스에 포함되어 있는지를 확인할 수 있다.

```jsx
$(function(){
	$('button').on('click',function(){
		// id가 target인 요소가 lined 이라는 클래스에 포함되면 true,
		// 포함되지 않으면 false를 반환함
		var result = $('#target').hasClass('lined');
		$('#text').html(result);
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_style_class_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_style_class_03)

---

### *클래스 설정에 관한 메소드*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7f67ea3a-5c52-4078-8f67-4893082836fa/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220808%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220808T035447Z&X-Amz-Expires=86400&X-Amz-Signature=c87a28151474bd25f72e6a1030faea7a2377de78b447ada0e30fdf334ce93c0e&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-4e78f991977a423885a516644a25bd64
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_style_class](http://www.tcpschool.com/jquery/jq_style_class)
