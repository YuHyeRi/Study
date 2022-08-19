# [jQuery] Ajax_개요

### *Ajax란?*

Ajax란 Asynchronous JavaScript and XML을 의미한다. 
웹 페이지 전체를 다시 로딩하지 않고도 웹 페이지의 일부분만을 갱신할 수 있게 해준다. 
Ajax는 백그라운드 영역에서 서버와 데이터를 교환하여 웹 페이지에 표시해 준다.

```jsx
$(function(){
	$('#requestBtn').on('click',function(){
		$('#text').load('/examples/media/jquery_ajax_data.txt');
	});
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_intro_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_ajax_intro_01)

Ajax에 대한 더 자세한 사항은 Ajax 수업에서 확인 할 수 있다.

[Ajax 수업 확인하러 가기](http://www.tcpschool.com/ajax/intro)

---

### *Ajax 프레임워크*

Ajax를 사용하여 손쉽게 개발할 수 있도록 미리 여러 가지 기능들을 포함해 놓은 개발 환경을 
Ajax 프레임워크라고 한다. 
이러한 Ajax 프레임워크 중에서도 가장 많이 사용되는 대표적인 프레임워크는 다음과 같다.

- Prototype
- [script.aculo.us](http://script.aculo.us/)
- dojo
- jQuery

이 외에도 수많은 Ajax 프레임워크가 있지만 현재 가장 널리 사용되고 있는 Ajax 프레임워크는 
바로 제이쿼리이다.

---

### *제이쿼리와 Ajax*

제이쿼리에서는 Ajax 기능을 손쉽게 사용할 수 있도록 여러 메소드를 제공하고 있다. 
이러한 메소드를 사용하면 HTTP 요청(request)을 손쉽게 보낼 수 있다. 
또한 데이터의 종류에 따라 그에 알맞는 메소드를 사용하여 서버에 데이터를 요청할 수 있다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-Ajax_-c14b72aaef8b4bcd81d1bc083dc28128
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_ajax_intro](http://www.tcpschool.com/jquery/jq_ajax_intro)
