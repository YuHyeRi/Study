# [jQuery] 선택된 요소에 접근

### *Getter, Setter*

선택자에 의해 선택된 요소의 값을 읽거나 설정하기 위해서는 
제이쿼리 메소드를 통해 해당 요소에 접근해야만 한다.

getter 메소드는 선택된 요소에 접근하여 그 값을 읽어오기 위한 메소드이다. 이러한 getter 메소드는 아무런 인수를 전달하지 않고 호출한다.
setter 메소드는 선택된 요소에 접근하여 그 값을 설정하기 위한 메소드이다. 이러한 setter 메소드는 대입하고자 하는 값을 인수로 전달하여 호출한다.

다음 예제는 h1에 접근하여 그 값을 읽어들인 후, 아이디가 ‘text’ 인 요소의 값을 해당 값으로 설정하는 예제이다.

```jsx
$(function(){
	$('button').on('click', function(){
		var newText = $('h1').html(); // 1) h1 요소의 텍스트를 읽어오는 getter 메소드
		$('#text').html(newText);     // 2) id가 'text'인 요소에 새로운 텍스트를 설정하는 setter 메소드
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_access_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_access_01)

1번 라인처럼 .html() 메소드에 인수를 전달하지 않고 호출하면 해당 html 요소에서 값을 읽어오는 getter 메소드로 사용된다.
그러나 2번 라인처럼 인수를 전달하고 호출하면 해당 html 요소에 새로운 값을 설정하는 setter 메소드로 사용된다.

---

## *메소드 체이닝(Method Chaining)*

getter 메소드는 선택된 요소의 값을 읽어서 그 값을 반환한다. 
만약 선택된 요소가 여러 개 존재하면 getter 메소드는 가장 ‘첫 번째 요소’의 값만을 반환할 것이다.

그러나 setter 메소드는 선택된 ‘모든 요소’에 인수로 전달된 값을 설정한다. 그리고 선택된 모든 요소에 접근할 수 있는 또 다른 제이쿼리 객체를 반환한다.
이렇게 반환된 제이쿼리 객체를 이용하면 세미콜론(;)을 사용하지 않고도 곧바로 다른 제이쿼리 메소드를 호출할 수 있다. 
이런 방식으로 여러 개의 메소드가 연속으로 호출되는 것을 메소드 체이닝(Method Chaining) 이라고 한다.

다음 예제는 선택된 요소에 .find(), .eq(), .html() 메소드를 연속으로 호출하는 예제이다.

```jsx
$(function(){
	$('button').on('click',function(){
		// id가 'list'인 요소의 자손 요소 중에서 <li> 요소를 모두 선택한 후에,
		// 그 중에서 두 번째 요소의 값을 설정함
		$('#list').find('li').eq(1).html('두번째 아이템을 선택했어요!');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_access_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_access_02)
<br><br>

💡 eq() 메소드는 선택한 요소 중에서 지정된 index에 해당하는 요소를 선택하는 메소드이다.
<br><br>

메소드 체이닝 도중에 end() 메소드를 사용하면 바로 이전에 선택했던 요소의 집합을 다시 선택할 수 있다.

```jsx
$(function(){
	$('button').on('click',function(){
		$('#list')            // id가 'list'인 요소의 자손 요소 중에서
							.find('li') // 1) <li> 요소를 모두 선택한 후에
							.eq(1).html('text')      // 2) 그 중에서 두번 째 요소의 값을 설정함
							.end()      // 3) 다시 id가 'list'인 요소의 자손 요소 중에서 <li> 요소를 모두 선택한 후에
              .eq(2).html('text2')     // 4) 그 중에서 세번째 요소의 값을 설정함  
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_access_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_elementSelection_access_03)

2번 라인에서 .eq() 메소드를 사용하여 1번 라인에서 .find() 메소드로 선택한 요소의 집합 중 두 번째 요소를 선택한다. 
3번 라인에서 .end() 메소드를 사용하여 .eq() 메소드를 사용하기 이전 집합을 다시 선택하고 있다. 

따라서 4번 라인에서 또다시 .eq() 메소드를 사용하여 요소를 선택할 수 있게 된다.


<br>
<br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-6a7020dde2f94be0b7bab3a1f14ba88a
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_elementSelection_access](http://www.tcpschool.com/jquery/jq_elementSelection_access)
