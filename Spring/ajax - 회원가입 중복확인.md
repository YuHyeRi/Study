# ajax - 회원가입 중복확인

- javaScript 섹션에 있는 게시판을 수정하면서 진행한다.
- ajax와 jquery를 이용할 것이라서 jquery-3.5.1.min.js를 script 폴더에 추가하고 ajax dependency도 pom.xml에 넣어준다.
- id 중복확인, email 중복확인의 경우 비슷하기때문에 email 중복확인만 설명하기로 한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2ff42bfe-2753-485a-bbf2-4b72ca807cfb/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220303%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220303T085622Z&X-Amz-Expires=86400&X-Amz-Signature=39f5658893ce79e83b71fef959e2bd37d0f52326a2009f2d635a80f24bf6db3a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

## **👧 email 중복확인**

- **email 부분의 jsp 코드이다. id는 ‘email’로 jquery와 연결될 수 있게 한다.**

```html
<tr>
	<th>Email</th>
		<td><input type="email" id="email" name="email" required/>
				<span id="emailcheck"></span>
		</td>
</tr>
```

- **jquery 부분 코드**

→ $(fucntion(){}) 에 넣어 문서가 모두 로드 된 후에 코드를 실행할 수 있게 한다.

→ .on(’keyup’, 함수이름) 을 써 keyup이라는 이벤트가 실행될 때 마다 emailcheck 함수가 실행되게 한다. 이 때 주의할 점은, ***emailcheck() 가 아니라는 점! () 는 뺴고 함수명만 써주어야 한다.***

```jsx
$(function() {
	$("#email").on('keyup', emailcheck);
});
```

- **emailcheck 함수**

→ email 의 입력값을 가져와서 sendData에 저장한다.

→ $.ajax({method, url, data, success}) 로 서버에서 새로고침 없이 데이터를 가져온다.

→ 만약 서버 resp가 fail이면 이메일이 중복이라는 것이고 fail이 아니라면 사용가능한 이메일인 것.

- **$.ajax({url: ‘emailcheck’, method: ‘POST’}) 이 부분에서 알 수 있듯이 controller 객체에서 @ResponseBody와 @RequestMapping(value=”/emailcheck”, method=RequestMethod.POST) 어노테이션이 붙은 함수가 실행된다.**

```jsx
function eamilCheck() {
	var email = $("#email").val();
	var sendData = {"email":email}

	$.ajax({
		url: 'emailcheck',
		method: 'POST',
		data: sendData,
		success: function(resp) {
			if(resp == 'fail') {
				$('#emailcheck').css('color', 'red');
				$('#emailcheck').html("사용할 수 없는 이메일 입니다.");
				flag = false;
			} else {
				$('#emailcheck').css('color', 'blue');
				$('#emailcheck').html('사용할 수 있는 이메일 입니다.');
				flag = true;
			}
		} 
	})
}
```

- **controller 객체에서 emailcheck 함수는 다음과 같다.**

→ repository에서 member 객체를 반환한다면 이미 그 email을 가진 사람이 있다는 것이다.

```java
@ResponseBody
@RequestMapping(value="/emailCheck", method=RequestMethod.POST)
public String emailCheck(Member member) {
	// select * from member where userid = #{}
	// 이 member 객체에는 id 값만 들어가 있고 다른 것은 다 null 값이다.
	Member m = repository.emailCheck(member);
	String message = null;
	
	if(m == null) {          // db에 없으니까 사용할 수 있다.
		message = "success";
	} else {                 // 사용할 수 없다.
		message = "fail";
	}
	return message;
}
```

- **repository 객체에서 emailcheck 함수는 다음과 같다.**

```java
public Member emailCheck(Member member) {
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	Member m = mapper.emailCheck(member);
	
	return m;
}
```

- 원래 interface가 설계도라서 interface에 먼저 함수명을 써두고 mapper, repository, controller 등 그 후에 implement 하는 형식으로 가는데 emailcheck는 나중에 추가된 함수라서 interface에 지금 추가해준다.

- **interface에서 emailCheck는 다음과 같다. (등록부분)**

```java
public Member emailCheck(Member member);
```

- **mapper에서 emailcheck는 다음과 같다.**

```xml
<select id="emailcheck" parameterType="Member" resultTyep="Member">
	SELECT USERID,
					USERPWD,
					GENDER,
					EMAIL,
					PHONE,
					HOBBY,
					TO_CHAR(BIRTH, 'YYYY-MM-DD') AS BIRTH,
					ADDRESS
	FROM MEMBER 
	WHERE EMAIL = #{EAMIL}
</select>
```

#### 👉 노션링크 : https://www.notion.so/ajax-2afd57f798254926a42c93378d27f59f
👉 출처 : [https://yejip.com/web/2020-12-15-게시판ajax1/](https://yejip.com/web/2020-12-15-%EA%B2%8C%EC%8B%9C%ED%8C%90ajax1/)

끝-
