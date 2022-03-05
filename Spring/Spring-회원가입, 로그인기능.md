# 회원가입, 로그인 기능

로그인을 하기 위해서는 사용자의 아이디와 비밀번호를 조회해야 한다.

### *1. **memberMapper.xml***

resultType을 MemberVo로 설정해준다. 파라미터로 userId와 userPass를 받고 조회한 결과 값을 resultType의 MemberVo로 전달한다. 여기서 parameterType은 생략할 수 있다.

```xml
<select id="login" resultType="kr.co.vo.MemberVo">
	SELECT USERID, USERPASS
	FROM MP_MEMBER
	WHERE USERID = #{userId}
	AND USERPASS = #{userPass}
</select>
```

### ***2. MemberDao.java***

```java
// 회원가입
public void register(MemberVO vo) throws Exception;

// 로그인
public MemberVO login(MemberVO vo) throws Exception;
```

### ***2-1. MemberDaoImpl.java***

login(MemberVo vo)에 파라미터 값이 전달되며 xml에서 조회한 데이터들은 MemberVo에 담긴다.

```java
@Override
public MemberVo login(MemberVo vo) throws Exception {
	return sql.selectOne("memberMapper.login", vo);
}
```

### ***3. MemberService.java***

```java
public void register(MemberVO) vo) throws Exception;

public MemberVO login(MemberVO vo) throws Exception;
```

### ***3-1. MemberServiceImpl.java***

MemberDao에서 MemberVO안에 조회된 값들이 담긴다.

```java
@Override
public MemberVO login(MemberVO vo) throws Exception {
	return dao.login(vo);
}
```

### *4. MemberController.java*

로그인 버튼 클릭시 찾아갈 수 있도록 컨트롤러에 작성해준다. 로그아웃도 마찬가지로 로그아웃 버튼 클릭시 로그인 페이지로 돌아갈 수 있도록 작성해준다.

```java
@RequestMapping(value="/login", method=RequestMethod.POST)
public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
	Logger.info("post login");

	HttpSession session = req.getSession();
	MemberVO login = service.login(vo);

	if(login == null) {
		session.setAttribute("member", null);
		rttr.addFlashAttribute("msg", false);
	} else {
		session.setAttribute("member", login);
	}
	
	return "redirect:/";
}

@RequestMapping(value="/logout", method=RequestMethod.GET)
public String logout(HttpSession session) throws Exception {
	session.invalidate();   // 세션 무효화

	return "redirect:/";
}
```

### *5. home.jsp*

```jsx
<form action="/member/login" method="post" name="homeForm">
	<c:if test="${member == null}">
		<div>
			<label for="userId"></label>
			<input type="text" id="userId" name="userId" />
		</div>
		<div>
			<label for="userPass"></label>
			<input type="password" id="userPass" name="userPass" />
		</div>
		<div>
			<button type="submit">로그인</button>
			<button type="button">회원가입</button>
		</div>
	<c:if>
	<c:if test="${member != null}">
		<div>
			<p>${member.userId}님 환영합니다!</p>
			<button id="logoutBtn">로그아웃</button>
		</div>
	</c:if>
	<c:if test="${msg == false}">
		<p style="color: red;">로그인 실패! 아이디와 비밀번호를 확인해주세요.</p>
	</c:if>
</form>
```

### *6. nav.jsp*

로그인 여부에 따라 로그인, 로그아웃을 보여준다. 또한 로그인을 했을 경우 id님 안녕하세요! 를 보여준다.

```jsx
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
	li {
		list-style: none;
		display: inline;
		padding: 6px;
	}
</style>
<ul>
	<li><a href="/board/list">목록</li>
	<li><a href="/board/writeView">글작성</li>
	<li>
		<c:if test="${member != null}"><a href="/member/logout">로그아웃</a></c:if>
		<c:if test="${member == null}"><a href="/">로그인</a></c:if>
	</li>
	<li>
		<c:if test="${member != null}">
			<p>${member.userId}님 안녕하세요!</p>
		</c:if>
	</li>
</ul>
```

### *7. writeView.jsp*

게시판 작성 시 로그인 여부에 따라 보여주는 설정을 해준다.

```jsx
<c:if test="${member.userId != null}">
	<tr>
		<td>
			<label for="title">제목</label>
			<input type="text" id="title" name="title" class="chk" />
		</td>
	</tr>
	<tr>
		<td>
			<label for="content">내용</label>
			<textarea id="content" name="content" class="chk" />
		</td>
	</tr>
	<tr>
		<td>
			<label for="writer">작성자</label>
			<input type="text" id="writer" name="writer" class="chk" />
		</td>
	</tr>
	<tr>
		<td>
			<button type="submit" class="write_btn">작성</button>
		</td>
	</tr>
</c:if>
<c:if test="${member.userId == null}">
	<p>로그인 후에 작성하실 수 있습니다.</p>
</c:if>
```

### ***8. 실행 화면***

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8970f68b-56a9-4757-b5ff-3b31d341de1c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220305%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220305T021849Z&X-Amz-Expires=86400&X-Amz-Signature=1ae77ab114d40bacaecc646eaf8486710d7a8f3369b371b6f274b8498fcbc44a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

👉 출처 : [https://melonpeach.tistory.com/](https://melonpeach.tistory.com/)
👉 노션링크 : https://www.notion.so/1a331f1a4fee401da06371ce1b526c9e
