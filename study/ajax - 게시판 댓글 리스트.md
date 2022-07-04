# ajax - 게시판 댓글 리스트

> **완성 화면**
> 

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/338c84e6-c0cf-4544-97e0-a5e0ed8bda05/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220302%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220302T033937Z&X-Amz-Expires=86400&X-Amz-Signature=68fb2b95c6b0c74aa5749c743a6e4786dcf63dbff7de603cc9e3fa865f1cda72&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

> **설정확인**
> 
- jstl core 추가 되어있는지 → <!DOCTYPE html> 위에

```jsx
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
```

- ajax는 dependency에 추가해서 쓰기 → pom.xml

```xml
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.12.0</version>
</dependency>
```

- jquery 파일도 scrpit 폴더에 추가하여 import 해주기

```jsx
<script scr="script/jquery-3.5.1.min.js"></script>
```

**| Interface로 틀 만들기**

- < 1) 화면에 댓글 목록 보여주기 2) 댓글을 추가하기 3) 댓글을 삭제하기 > 작업을 할 것이다. interface에 함수를 만들어둔다.
- [replyMapper.java](http://replyMapper.java) (interface)

```java
public interface ReplyMapper {
	// 댓글 전체 요청
	public List<Reply> replyList(int boardseq);
	
	// 댓글등록
	public int replyInsert(Reply reply);

	// 댓글삭제
	public int replyDelete(int replyseq);
}
```

> **mapper 생성하고 등록하기**
> 
- replyMapper.xml 파일을 src/main/resources/mappers 에 만든다.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="sesoc.intern.board.dao.ReplyMapper">
    <!--코드 추가할 자리-->
</mapper>
```

- mybatis-config.xml에 mapper 추가해둔다. → src/main/resources/
- typealias 추가

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        <typeAlias type ="sesoc.intern.board.vo.Member" alias = "Member"/>
        <typeAlias type ="sesoc.intern.board.vo.Board" alias = "Board"/>
        <typeAlias type ="sesoc.intern.board.vo.Reply" alias = "Reply"/>
    </typeAliases>
  
    <mappers>
        <mapper resource="mappers/memberMapper.xml" />
        <mapper resource="mappers/boardMapper.xml" />
        <mapper resource="mappers/replyMapper.xml" />
    </mappers>
</configuration>
```

- 뒷단에 필요한 파일들 replyController, replyRepository 파일도 생성해둔다.

> **댓글 화면 만들기**
> 

> ***boardDetail.jsp → html 부분***
> 
- jstl core 문법으로 <c:if>문을 사용하여 sessionScope.loginId가 empty가 아닐 경우에만 댓글창이 보이게 한다.
- sessionScope.loginId는 우리가 login 할 때 controller에서 HttpSession 객체에 저장해 놓은 정보 이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/80c265fe-44d4-42f9-98f4-f09c52fe5a75/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220302%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220302T033953Z&X-Amz-Expires=86400&X-Amz-Signature=dec500a1667c8b920376b2ba669f3a40c510dcbe2a594123771545d14d4bb552&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

```jsx
<!-- 댓글입력 : 로그인한 사람만 실명으로 댓글을 달 수 있다 --!>

<c:if test="${not empty sessionScope.loginId}">
	<input class="reply" id="replytext" name="replytext" placeholder="댓글내용" style="width:450px" />
	<input type="button" id="replyInsert" value="댓글입력" />
</c:if>
<div id="replyresult"></div>
```

> ***boardDetail.jsp → javaScript, jquery, ajax 부분***
> 
- 화면 요소가 로딩된 후, 댓글리스트를 화면에 뿌려주는 함수인 init()을 실행시킨다.
- replyInsert 버튼 클릭시 replyInsert() 함수가 실행되어 입력한 정보를 DB에 저장시킨다.

```jsx
$(function() {
	init();
	$("#replyInsert").on("click", replyInsert);
});
```

**👉 init() 함수**

- controller에서 model에 저장한 board 객체의 boardseq를 받아온다.
- ajax로 페이지 로딩 없이 정보만 갱신한다. replyController의 ***@RequestMapping(value=”/replyList”, method=RequestMethod.POST)*** 가 있는 함수와 매핑되어 정보를 주고 받는다.
- 정보를 가져오는데 success 했다면 output() 함수가 실행된다.

```jsx
function init() {
	var boardseq = ${board.boardseq};
	sendData = {"boardseq" : boardseq};
	
	$.ajax({
		method: "POST",
		data: sendData,
		url: "replyList",
		success: output
	});
}
```

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f66f4274-628c-42e7-89f5-ef149bc93ba5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220302%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220302T034012Z&X-Amz-Expires=86400&X-Amz-Signature=af06e3f93ee2391e4370370cab2740fa9d38b66ce8013dbef05ecda48023a513&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

**👉 output() 함수**

- ***$.each(resp,function(param))을 사용하여*** 리스트 안의 객체를 하나씩 꺼내 문자열에 저장한다. 그 후 result 화면에 표시한다.
- 이벤트를 output 함수에서 추가해주는데 그 이유는 ***이벤트를 추가해줄 버튼이 동적으로 생성되기 때문***이다. (화면을 로드할때만 생성되는 것❌, 데이터를 주고받은 결과로 생성⭕) 그 요소를 화면에 추가하고 그 직후에 이벤트를 걸어주는 코드를 넣어준다.
- delete 하는 코드는 다음 포스팅에 추가할 것

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

**👉 replyController.java**

- ReplyRepository repository;를 전역으로 선언한다. → @Autowired

```java
@Autowired
ReplyRepository repository;

@ResponseBody
@RequestMapping(value="/replyList", method=RequestMethod.POST)
public List<Reply> replyList(int boardseq) {
	List<Reply> replyList = repository.replyList(boardseq);
	
	return replyLiMemberRepositoryst;
}
```

**👉 replyRepository.java**

- SqlSession session; 과 session.getMapper(interface명.class);가 포인트

```java
@Repository
public class ReplyRepository {

	@Autowired
	SqlSession session;

	public List<Reply> replyList(int boardseq) {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		List<Reply> replyList = mapper.replyList(boardseq);

		return replyList;
	}
}
```

**👉 [replyMapper](http://replyMapper.java).xml에 코드를 추가한다.**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="sesoc.intern.board.dao.ReplyMapper">
    <!-- 댓글 목록 요청 -->
    <select id = "replyList" resultType="Reply" parameterType="int">
        SELECT
        replyseq,
        boardseq,
        userid,
        replytext,
        to_char(regdate,'YYYY-MM-DD') as regdate
        FROM
        reply
        WHERE
        boardseq = #{boardseq}
        ORDER BY
        replyseq DESC
    </select>
</mapper>
```

끝-

#### 👉 출처 : https://yejip.com/web/2020-12-17-%EA%B2%8C%EC%8B%9C%ED%8C%90ajax2/
#### 👉 노션링크 : https://www.notion.so/ajax-ae2f8b6a664f4f2e8fc7f98472d11bc2
