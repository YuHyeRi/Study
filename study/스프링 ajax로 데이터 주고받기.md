# 스프링 ajax로 데이터 주고받기

### 👧🏻 스프링에서 JSP로 데이터를 보낼 때

MainController.java

```java
@RequestMapping(value="get.do")
@ResponseBody
public String ajax() {
	Map<String, Object> map = new HashMap<String, Object>();

	map.put("kor", "korea");
	map.put("us", "United States");

	return null;
}
```

test.jsp

```jsx
function test() {
	$.ajax({
					type: "GET",
					url: "get.do",
					data: {
									kor: "${kor}",
									us: "${us}"
								},
					success: function(data) {
										console.log("success");
					},
					error: function(error) {
										console.log("error");
					}
	});
}
```

이처럼 ajax를 통해 프로그래밍을 하게 된 것은 **jsp파일에서 일부 데이터만 변경하기 위해**서였다. kor과 us 부분을 주기적으로 변경해야 하는데, 이를 위해 전체 페이지를 다시 부르는 것은 비효율적이다. 따라서 데이터만 변경하기 위해 ajax(비동기식 자바스크립트와 xml)을 이용하였다. test() 함수를 setInterval함수를 이용하여 주기적으로 call하고 test()를 호출한 이후에 가져온 데이터로 innerHTML 등과 같은 원하는 처리를 하면 된다.

jsp파일에서 url로 등록한 주소를 따라 Controller로 매핑이 된다. 그래서 Controller의 **@RequestMapping(value=”get.do”)**, jsp 파일의 **url: “get.do”** 에서 빨간 글자 부분이 같아야 한다. 또한 Controller의 return value에 따라 url이 달라지므로 return type이  String 일 경우에는 null로 retrun 해주어야 한다. *🟡🟡이 때 **jsp에서 데이터를 받으므로** type은 **“GET”**이라고🟡🟡* 설정해준다. 

---

### 👧🏻 JSP에서 Controller로 데이터를 보낼 때

test.jsp

```jsx
<script src="http://code.jquery.com/jquery-3.2.1.min.js">
	
	$('.id').val(myid);
	$('.pwd').val(mypwd);

	$.ajax({
		type: "POST",
		url: "post.do",
		data: $('form').serialize(),
		success: function(data){
			console.log("success");
		},
		error: function(error){
			console.log("error")
		}
	});

</script>

<form>
	<input type="hidden" class="id" />
	<input type="hidden" class="pwd" />
</form>
```

MainController.java

```java
@RequestMapping(value="post.do")
@ResponseBody
public String record() {
	
	String str1 = request.getParameter("id");
	String str2 = request.getParameter("pwd");

	return null;
}
```

jquery를 이용하여 form값을 Controller로 넘겨주도록 프로그래밍 하였다. form은 실제로는 보이지 않게 하기 위해 type=”hidden”으로 하였고 class명을 정한다. 이 때 꼭 class명이 아니더라도 id나 name으로 이용할 수 있다. jquery는 이 **form에 값을 넣어주는 부분 $(’.class이름’).val(데이터); 형식으로** 정해준다.

***🟡🟡jsp에서 Controller로 데이터 값을 보내므로 type은 “POST”로 정하고🟡🟡,*** 더불어 jquery를 사용하기 위해서는 test.jsp 맨 윗줄의 script 태그처럼 jquery src를 적어주어야 한다.

실행결과 확인 시, str1에는 myid가 str2에는 mypwd가 할당됨을 알 수 있다.

#### 👉 출처 : https://ttuk-ttak.tistory.com/21
#### 👉 노션링크 : https://www.notion.so/ajax-e2ae2c903c354e6e886f3a4f0c384c3e
