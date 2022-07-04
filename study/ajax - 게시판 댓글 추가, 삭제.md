# ajax - 게시판 댓글 추가, 삭제

- 저번시간에는 댓글작업에 필요한 여러가지 설정을 해주었다.
- 이번시간에는 만들어진 파일에 댓글을 추가, 삭제하는 기능을 추가한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/55bcd466-eedc-41cd-ba73-c8160d4c2c68/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220304%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220304T025901Z&X-Amz-Expires=86400&X-Amz-Signature=edefc9bc2e81f9e89366e84bdca7d190f0fdeca26e73097006370e0cc9afef47&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

## 👧 댓글 추가

> ***boardDetail.jsp - html 부분***
> 

```jsx
<!-- 댓글등록 : 로그인한 사람만 실명으로 댓글을 달 수 있다. --!>
<c:if test="${not empty sessionScope.loginId}">
	<input class="reply" id="replytext" name="relpytext" placeholder="댓글을 입력하세요.">
	<input type="button" id="replyInsert" value="댓글입력">
</c:if>
<div id="replyresult"></div>
```

> ***boardDetail.jsp - javaScript, jquery, ajax 부분***
> 
- 화면 요소가 로딩 된 후 댓글리스트를 화면 뿌려주는 init() 함수를 실행시킨다.
- replyInsert 버튼이 클릭되면 replyInsert() 함수가 실행되어 입력한 정보를 DB에 저장시킨다.

```jsx
$(function() {
	init();
	$("#replyInsert").on("click", replyInsert);
});
```

**👧🏻 replyInsert 함수**

- reply에 필요한 정보를 ajax로 서버로 보낸다.

```jsx
// controller에서 model에 저장한 board 객체에서 정보 받아 변수에 저장
var boardseq = "${board.boardseq}"

// sessionScope로 controller에서 HttpSession 객체에 저장해놓은 정보 받아 변수에 저장
var userid = "${sessionScope.loginId}"

// #replytext의 value 값 읽어와 변수에 저장
var replytext = $("#replytext").val()
```

- 정보를 무사히 가져오면 댓글 입력란이 리셋 되고 화면에 댓글을 뿌려주는 함수가 실행된다.

> ***전체 코드***
> 

```jsx
function replyInsert() {
	var boardseq = "${board.boardseq}"
	var userid = "${sessionScope.loginId}"
	var replytext = $("#replytext").val();

	if(replytext.trim().length == 0) {
		alert("댓글을 입력해주세요.");
		$("#replytext").focus();
		return ;
	}

	var reply = {"boardseq": boardseq, "userid": userid, "replytext": replytext};
	$.ajax({
		url: 'replyInsert',
		method: 'POSt',
		data: JSON.stringify(reply),
		contentType: 'application/json; charset=UTF-8',
		success: function(){
			$('#replytext').val();
			init();
		}
	})
}
```

> ***replyController.java***
> 
- @ResponseBody 뿐 아니라 @RequestBody도 사용한다. (json 형식의 데이터를 보낼 것이라)

```java
@ResponseBody
@RequestMapping(value="/replyInsert", method=RequestMethod.POST)
public String replyInsert(@RequestBody Reply reply) {
	String message = null;
	int result = repository.replyInsert(reply);

	if(result == 1) {         // db에 없으니까 사용할 수 있다.
		message = "success";
	} else {
		message = "fail";
	}

	return message;
}
```

> ***replyRepository.java***
> 
- SqlSession session, session.getMapper(interface명.class)

```java
public int replyInsert(Reply reply) {
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	int result = mapper.replyInsert(reply);

	return result;
}
```

> [***replyMapper.java](http://replyMapper.java) 코드 추가***
> 

```xml
<mapper namespace="sesoc.intern.board.dao.ReplyMapper">
	<insert id="replyInsert" parameterType="Reply">
			INSERT INTO REPLY
			(
			REPLYSEQ,
			BOARDSEQ,
			USERID,
			REPLYTEXT
			)
			VALUES
			(
			REPLY_SEQ.NEXTVAL,
			#{BOARDSEQ},
			#{USERID},
			#{REPLYTEXT}
			)
	</insert>
</mapper>
```

---

## 👧 댓글 삭제

- delete 버튼은 댓글이 동적으로 생성되어 화면에 뿌려질 때 같이 나타난다. (output 함수에서)

```jsx
result +="<td><input type = button  class='replyDelete'"+ diasble+" data-del= '"+item['replyseq']+"' value= '"+item['replyseq']+"'></td>"
```

> ***전체코드***
> 
- 객체리스트들을 each문을 통해 화면에 나타나게 한다. 객체의 replyseq 정보를 data-del속성에 저장한다.
- 화면에 html을 넣고 난 뒤 즉시 이벤트를 추가해준다.

```jsx
function output(resp){
    var result ='<table border="1">	<tr>	<th>아이디</th><th>댓글 내용</th><th>등록일</th><th>비고</th>	</tr>';
  
    $.each(resp,function(index, item){
        result +="<tr><td>"+item["userid"]+"</td>"
        result +="<td><pre style='height : 70px'>"+item['replytext']+"</pre></td>"
        result +="<td>"+item['regdate']+"</td>"		
        var diasble="";
        if(${sessionScope.loginId} != item["userid"])
        {diasble=" disabled"}
        result +="<td><input type = button  class='replyDelete'"+ diasble+" data-del= '"+item['replyseq']+"' value= '"+item['replyseq']+"'></td>"
        result += "</tr>"
    })
    result +=	"</table>"	
    $("#replyresult").html(result)
    $("input:button.replyDelete").on('click',replyDelete)	
}
```

**👧🏻 replyDelete 함수**

- $this.attr(”data-del”) 을 이용하여 replyseq 정보를 받아서 서버에서 보내주면 일련의 과정을 통해 DB에서도 삭제되게 한다.

```jsx
function replyDelete() {
	var replyseq = $(this).attr("data-del");
	var sendData = {"replyseq": replyseq};
	$.ajax({
		method: 'GET',
		url: 'replyDelete',
		data: sendData,
		success: init
	})
}
```

> ***replyController.java***
> 

```java
@ResponseBody
@RequestMapping(value="/replyDelete", method=RequestMethod.GET)
public String replyDelete(int replyseq) {
	int result = repository.replyDelete(replyseq);
	String messgae = null;

	if(result == 1) {
		message = "success";
	} else {
		message = "fail";
	}

	return message;
}
```

> ***replyRepository.java***
> 

```java
public int replyDelete(int replyseq){
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	int result = mapper.replyDelete(replyseq);

	return result;
}
```

> ***replyMapper.xml***
> 

```xml
<mapper namespace="sesoc.intern.board.dao.ReplyMapper">
	<delete id="replyDelete" parameterType="int">
		DELETE REPLY
		WHERE REPLYSEQ = #{REPLYSEQ}
	</delete>
</mapper>
```

👉 출처 : [https://yejip.com/web/2020-12-19-게시판ajax3/](https://yejip.com/web/2020-12-19-%EA%B2%8C%EC%8B%9C%ED%8C%90ajax3/)
👉 노션링크 : https://www.notion.so/ajax-1c136c50985a4744b681e34ef9620026
