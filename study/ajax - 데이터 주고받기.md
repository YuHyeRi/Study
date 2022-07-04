# ajax - 데이터 주고받기

### 👧 ajax 기본 설정

- 서버-클라이언트 간의 비동기 통신을 가능하게 해주는 javaScript library이다.
- 페이지가 전환되지 않고 데이터를 갱신한다.
- ex) 검색창에 검색어를 쳤을 때 페이지가 바뀌지 않고 추천 관련검색어가 하단에 뜨는 것

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1d1f707e-44e5-4425-a4d9-b39aebfa4a5c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220301%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220301T032412Z&X-Amz-Expires=86400&X-Amz-Signature=476f16eecd6f68acf9eefd0b0d7c8f1ae85fa52608472e4df62205f0e1a46ee6&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- ***라이브러리 사용을 위해 pom.xml에 dependency를 추가해준다.***

```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.12.0 --!>
<dependency>
	<groupId>com.faterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.12.0</version>
</dependency>
```

- [https://api.jquery.com/category/ajax/low-level-interface/](https://api.jquery.com/category/ajax/low-level-interface/)

---

## 👧🏻 요청 보내기

- ***@ResponseBody***가 키워드!
- 평소와 같이 controller의 메서드에 @RequestMapping과 함께 @ResponseBody를 써주면
    
    return의 String이 .jsp를 반환하지 않고 문자열 그 자체를 반환하게 된다.
    
    *👉 이렇게 public과 string 사이에 @ResponseBody를 써주거나*
    
    ```java
    @RequestMapping("/reqAjax1")
    	public @ResponseBody String reqAjax1(){
    	...
    }
    ```
    
    *👉 RequestMapping과 함께 서주면 된다.*
    
    ```java
    @ResponseBody
    @RequestMapping("/reqAjax1")
    	public String reqAjax1(){
    	...
    }
    ```
    
    *👉 페이지가 전환되지 않는다.*
    
    <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/bcf1112c-6250-4679-9be1-96ca8cfc5b9a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220301%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220301T032430Z&X-Amz-Expires=86400&X-Amz-Signature=6db50de448693faa64b70ed0f5c0c06b0acc0a55e8adb348824f6e20ba267ec3&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
    
    > **요청보내기1 - ajax 요청보내기**
    > 
    - jsp파일 - 화면에서 버튼을 누르면
    
    ```html
    <li>
    	Ajax1 : <input type="button" id="reqBtn1" value="1.ajax요청" />
    	<span id="req1" style="color:red"></span>
    </li>
    ```
    
    - 다음과 같이 .on(’click’, reqAjax1) 함수가 실행
    
    ```jsx
    $(function(){
    	$('#reqBtn1').on("click", reqAjax1)
    });
    ```
    
    - javaScript func인 reqAjax1과 controller func인 reqAjax1은 순서대로 서술하기 어렵다
    - reqAjax에서는 $.ajax(url: ‘url’, method: ‘method’, success: ‘function’) 구조를 사용하여 데이터를 서버에서 받는다.
    - 대충 보았을 때, url과 method의 정보(클라이언트)로 controller에 있는 함수(서버)와 매칭이 되고 서버에서 클라이언트 쪽으로 정보가 제대로 전달되었으면 success문이 실행된다.
    
    ```jsx
    // 클라이언트 쪽
    function reqAjax1() {
    	$.ajax({
    		url: 'reqAjax1',
    		method: 'GET',
    		success: function(resp){
    			if(resp == 'cool'){
    				$('#req1').text("전송받은 데이터 : " + resp)
    			}
    		}
    	});
    }
    ```
    
    - 그러면 cool이라는 문자를 return하게 되고 success
    - @ResponseBody가 붙어 있기 때문에 cool.jsp를 보여주는 것이 아니라 cool이라는 데이터를 반환해준다.
    
    ```java
    // 서버 쪽
    @Controller
    public class AjaxController{
    	@RequestMapping("/reqAjax1"){
    		public @ResponseBody String reqAjax1(){
    			System.out.printIn("ajax 요청 도착!");
    
    			return "cool";
    		}
    	}
    }
    ```
    
    > **요청보내기2 - 데이터 파라미터로 보내기(String)**
    > 
    - 위와 같은 패턴에 data:”name=”+name+’&phone=’+phone 을 추가하여 서버에 데이터를 전달한다.
    
    ```jsx
    function reqAjax2(){
    	var name = $("#username").val();
    	var phone =$("#phone").val();
    
    	if(name.trim() == '' || phone.trim() == ''){
    		alert('데이터를 입력해주세요');
    		return;
    	}
    
    	// 서버로 보낼 데이터 준비 : 파라미터로 만들기. json으로 만들기
    	var sendData = "name="+name+'&phone='+phone;
    	
    	$.ajax({
    		url: 'reqAjax2',
    		method: 'POST',
    		data: sendData,
    		success: function(resp){}
    	});
    }
    ```
    
    - data로 넘긴 정보에 name, phone이 있었다. 이걸 이렇게 param으로 받아준다.
    
    ```java
    @RequestMapping(value="/reqAjax2", method="RequestMethod.POST")
    public @ResponseBody String reqAjax2(String name, String phone) {
    	System.out.printIn("ajax 요청 도착!" + name + "," + phone);
    
    	return "success";
    }
    ```
    
    > **요청보내기3 - JSON으로 보내기 (String으로 받기)**
    > 
    - data를 String이 아닌 JSON 데이터로 보낸다.
    - 이렇게 보내면 서버쪽에서 param으로 받는다. (map으로 ❌)
    
    ```jsx
    var sendData = {"name":name, "phone":phone}
    // json은 key를 반드시 큰 따옴표로 해주어야 한다. (작따❌)
    
    $.ajax({
    	url: 'reqAjax2',
    	method: 'POST',
    	data: sendData,
    	success: function(resp){
    		var respData = "이름 : " + resp["name"] + ", 전화번호 : " + resp["phone"]
    		$("#req2").html(respData);
    	}
    })
    ```
    
    - 클라이언트에서 받은 정보를 서버에서 map에 넣어서 다시 반환한다. 그럼 그 정보를 처리할 수 있게 위 함수 success: function(resp)에서 정보를 풀어 화면에 넣어준다. 여기서 resp는 당연 map타입이다.
    
    ```java
    @ResponseBody
    @RequestMapping(value="/reqAjax2", method=RequestMethod.POST)
    public Map<String, String> reqAjax2(String name, String phone){
    	System.out.printIn("ajax 요청도착!" + name + "," + phone);
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("name", name);
    	map.put("phone", phone);
    
    	return map;
    }
    ```
    
    > **요청보내기4 - JSON으로 보내기 (map으로 받기)**
    > 
    - map으로 받기 위해서 요청을 보낼 때와 받을 때 추가작업을 해주어야 한다.
    - $.ajax안에 ContentType과 dataType을 추가로 넣어주고 데이터도 JSON.stringify()안에 넣어 보낸다.
    
    <aside>
    💡 JSON.stringify( )는 자바스크립트의 값을 JSON 문자열로 변환한다.
    
    </aside>
    
    - **JSON.stringify(value, replacer, space)**
        
        **value(필수)**: JSON 문자열로 변환할 값이다.(배열, 객체, 또는 숫자, 문자 등이 될 수 있다.)
        
        **replacer(선택)**: 함수 또는 배열이 될 수 있다. 이 값이 null 이거나 제공되지 않으면, 객체의 모든 속성들이 JSON 문자열 결과에 포함된다.
        
    
    ```jsx
    function reqAjax2(){
    	var name = $("#username").val();
    	var phone = $("#phone").val();
    	if(name.trim() == '' || phone.trim() == '') {
    		alert("데이터를 입력해주세요.");
    		return ;
    	}
    
    	// 서버로 보낼 데이터 준비 : 파라미터로 만들기 . json으로 만들기
    	var sendData = {"name":name, "phone":phone}
    	$.ajax({
    		url: 'reqAjax2',
    		method: 'POST',
    		data: JSON.stringify(sendData),
    		dataType: 'json',
    		contentType: 'application/json; charset=UTF-8',
    		success: function(resp){
    			alert(JSON.stringify(sendData))
    		}
    	})
    }
    ```
    
    - 받은 쪽에서도 추가작업이 필요하다. @RequestBody param에 붙여줘야지 jsp에서 넘어온 sjon 데이터를 무사히 받을 수 있다.
    
    ```java
    @ResponseBody
    @RequestMapping(value="/reqAjax2", method=RequestMethod.POST)
    public Map<String, String> reqAjax2(@RequestBody Map<String, String> map) {
    	System.out.printIn(map);
    	return map;
    }
    ```
    
    > **요청보내기5 - VO로 보내기**
    > 
    - 링크를 클릭하면 javaScript의 특정 함수가 실행되게 하기 위해 a href 다음 “javascript:함수명()” 이렇게 쓰면 된다.
    
    ```html
    <li>
    	Ajax3(VO) <br>
    	<a href=javascript:reqAjax3()"> VO데이터 수신 </a><br>
    	<span id="req3" style="color:red"></span>
    </li>
    ```
    
    - 그러면 다음의 js함수가 호출된다. url과 method는 서버의 어떤 함수로 가야하는지 알려주고 그 함수를 갔다 온 후 성공실패를 success를 통해 알 수 있다.
    
    ```jsx
    function reqAjax3(){
    	$.ajax({
    		url: 'reqAjax3',
    		method: 'GET',
    		success: function(resp){
    			var respData = 'replyseq:" + resp["replyseq"] + ", boardseq : " + resp["boardseq"] + ", userid : " + resp["userid"]
    			$("#req3").html(respData);
    		}
    	})
    }
    ```
    
    - 다음과 같이 서버에서 객체의 값을 넣는다. 이걸 위 함수 success의 resp로 받는다. 비록 객체 서버에서 전송을 했지만 JSON 타입으로 전송이 온다.
    
    ```java
    @ResponseBody
    @RequestMapping("/reqAjax3")
    public Reply reqAjax3(String name, String phone){
    	Reply reply = new Reply();
    	reply.setBoardseq(1);
    	reply.setRegdate(new Date().toString());
    	reply.setReplytext("댓글입니다.");
    	reply.setUserid("yu");
    
    	return reply;
    }
    ```
    
    ---
    
    > **응답받기1 - VO 보내고 VO 리스트 받기**
    > 
    
    위 예시들은 클라이언트에서 요청을 보내고 서버에서 요청을 받는데 집중했다면 이번에는 서버에서 온 응답을 받는 것을 볼 것이다.
    
    - 서버에서 리스트를 받아 화면에 출력하는 예제
    
    <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/63d4a2e2-4b4c-4060-9eda-c5fb7496f952/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220301%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220301T032453Z&X-Amz-Expires=86400&X-Amz-Signature=705e17406c787f03c3fef8da20bd0462bbd153fc72ef07f8e0af90f9c5b89119&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
    
    - [요청보내기4]에서 나온 것과 같이 객체를 보낸다.
    - 서버에서 응답을 받으면 success후 코드가 실행된다.
    - $.each문을 사용하여 리스트의 객체들을 하나씩 꺼내주고 그걸 table에 나타나게 해준다.
    
    ```jsx
    function reqList(){
    	// 서버로 보낼 데이터 준비 : 파라미터로 만들기. json으로 만들기
    	var sendReply = {"regdata":"2022/3/1", "replytext":"hello", "userid":"yu", "replyseq":"1"}
    	$.ajax({
    		url: 'reqList',
    		method: 'POST',
    		data: JSON.stringify(sendReply),
    		dataType: 'json',
    		contentType: 'application/json; charset=UTF-8',
    		success: output
    	})
    }
    
    function output(resp){
    	var result = '';
    	result += '<table border="1">'
    	reuslt += '<tr><th>글쓴이</th><th>댓글내용</th><th>글쓴날</th></tr>'
    	$.each(resp, function(index,item){
    		result += '<tr<td>' + titem["userid"] + '</td>'
    		result += '<td>' + item["replytext"] + '</td>'
    		result += '<td>' item["regdate"] + '</td></tr>'
    	})
    	result += '</table>'
    	$(resultList).html(result)
    }
    ```
    
    - 서버에서 list에 add하고 return 하는 코드로 RequestBody를 넣어서 json 데이터를 받을 수 있게 한다.
    
    ```java
    @ResponseBody
    @RequestMapping(value="/reqList", method=RequestMethod.POST)
    public List<Reply> reqList(@RequestBody Reply reply) {
    	List<Reply> list = new ArrayList<Reply>();
    	list.add(reply);
    	list.add(new Reply(2,1,"김","김먹고싶다","2020/12/12"));
    	list.add(new Reply(3,1,"이","이상해","2020/12/12));
    	list.add(new Reply(4,1,"박","박수쳐","2020/12/13));
    	list.add(new Reply(5,1,"최","최근에","2020/12/14));
    	list.add(new Reply(6,1,"조","조조영화","2020/12/15"));
    
    	return list;
    }
    ```
    

끝-
#### 👉 출처 : https://yejip.com/web/2020-12-14-ajax1/
#### 👉 노션링크 : https://www.notion.so/ajax-8ef7ddf915d249008bca89c6ef002f13
