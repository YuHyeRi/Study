# Session 사용방법

## **👧🏻 세션(Session) 이란?**

→ **클라이언트 별로 서버에 저장되는 정보**이다. 사용자 컴퓨터에 저장되던 쿠키와 다르게 서버에 저장되므로, 비교적 ***보안이 필요한 데이터***는 쿠키보다 세션에 저장한다. *서버가 종료되거나 유효시간이 지나면 사라진다.*

---

## 1. Session 이용 방법

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5646f7ab-4632-4a57-8916-887c80330985/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220226%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220226T011538Z&X-Amz-Expires=86400&X-Amz-Signature=d99814353b494c96e5abe5b2efc3a2690f83fd8107c2a3a426b960ffffd0401c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- **웹 클라이언트가 서버에 요청을 보내면, 서버는 클라이언트를 식별하는 session id를 생성한다.**
- **서버는 session id로 key와 value를 저장하는 HttpSession을 생성하고 session id를 저장하고 있는 쿠키를 생성하여 클라이언트에게 전송한다.**
- **서버는 쿠키의 session id로 HttpSession을 찾는다.**

javax.sevlet.http.HttpSession으로 세션 데이터를 다룰 수 있다.

### 1) 세션 생성 및 얻기

```jsx
HttpSession session = request.getSession();
HttpSession session = request.getSession(true);
```

request의 getSession() 메서드는 서버에 생성된 세션이 있다면 세션을 반환하고, 없다면 새 세션을 생성하여 반환한다. (인수 default가 true)

새롭게 생성된 세션인지는 HttpSession의 isNew() 메서드로 알 수 있다.

```jsx
HttpSession session = request.getSession(false);
```

request의 getSession() 메서드의 파라미터로 false를 전달하면, 이미 생성된 세션이 있을 때 그 세션을 반환하고, 없으면 null을 반환한다.

### 2) 세션에 값 저장하기

```jsx
setAttribute(String name, Object value)
```

setAttribute는 name, value 쌍으로 객체 Object를 저장하는 메서드이다.

세션이 유지되는 동안 저장한다.

```jsx
session.setAttribute(이름, 값)
```

이렇게 사용할 수 있다.

### 3) 세션 값 조회하기

```jsx
getAttribute(String name)
```

getAttribute 메서드로 세션에 저장된 값을 조회할 수 있다.

리턴타입은 Object이므로 형변환이 필요하다.

메서드 setAttribute에 이용한 name을 알고 있다면 아래와 같이 조회할 수 있다.

```jsx
String value = (String)session.getAttribute("name");
```

### 4) 세션 값 삭제하기

```jsx
removeAttribute(String name)
```

removeAttribute 메서드로 name값에 해당하는 세션정보를 삭제 할 수 있다.

```jsx
invalidate()
```

invalidate로 모든 세션정보를 한 번에 삭제할 수도 있다.

### 5) 세션 유지 시간 설정하기

기본적으로 세션은 30분 유지된다. 세션 유지 시간은 서버에 접속한 후 서버에 요청을 하지 않는 최대시간을 말한다. 30분 이상 서버에 반응을 보이지 않으면 세션이 자동으로 끊어진다. 이 세션 유지 시간은 web.xml 파일에서 설정할 수 있다.

```jsx
<session-config>
	<session-timeout>30</session-timeout>
</session-config>
```

---

## 2. Spring MVC에서 Session 사용 방법

Spring MVC에서 @SessionAttributes와 @ModelAttribute 어노테이션으로 세션에 값을 저장하고 가져오는 방법을 아래 예제들로 이해해보자.

@SessionAttributes 파라미터로 지정된 이름과 같은 이름이 @ModelAttribute에 지정되어 있다면, @ModelAttribute가 설정된 메서드가 반환되는 값을 그 세션에 저장한다.

### 1) Controller 클래스에 @SessionAttributes를 선언하고 @ModelAttribute는 메서드 위에 선언한다.

```jsx
@Controller
@SessionAttributes("user") 
public class LoginController {
	@ModelAttribute("user")
	public User setUpUserForm() {
		reutrn new User();
	}
}
```

위 예제를 보면 @SessionAttributes의 파라미터로 지정된 이름은 user이다. @ModelAttribute의 파라미터로 지정된 이름 또한 user이다. 둘의 이름이 같으므로 setUpUserForm 메서드가 반환하는 User 객체는 user라는 이름의 세션에 저장된다.

(* 위 코드는 새 객체를 반환하여 저장시키므로 해당 세션값을 초기화하는 목적으로 사용할 수 있다.)

### 2) @SessionAttributes를 Controller 클래스 위에 선언하고, 메서드 파라미터로 @ModelAttribute를 불러온다.

```jsx
@Controller
@SessionAttributes("user")
public class LoginController {
	
	@PostMapping("/dologin")
	public String doLogin(@ModelAttribute("user") User user, Model model) {
		...
	}
}
```

@SessionAttributes의 이름과 @ModelAttribute의 이름이 같다. 클라이언트로부터 전송받은 user값이 그 세션에 저장된다.

### 3) 메서드에 @SessionAttribute가 있을 경우, 파라미터로 지정된 이름으로 등록된 세션 정보를 읽어와 변수에 할당한다.

```jsx
@GetMapping("/info")
public String userInfo(@SessionAttribute("user") User user {
	...
	return "user";
}
```

### 4) SessionStatus로 @SessionAttributes에 의해 저장된 오브젝트를 제거할 수 있다. SessionStatus는 컨트롤러 메서드의 파라미터로 사용할 수 있는 스프링 내장 타입이다.

```jsx
@Controller
@SessionAttributes("user")
public class UserController {
	
	@RequestMapping(value="/user/add", method=ReqeustMethod.POST)
	public String submit(@ModelAttribute("user") User user, SessionStatus sessionStatus) {
	...
	sessionStatus.setComplete();
	...
}
```

SessionStatus의 setComplete 메서드로 user라는 이름의 세션 값을 제거한다.

### 5) Spring MVC의 form tag 라이브러리 사용하기

```jsx
<form:form action="login" method="post" modelAttribute="user">
	Email: <form:input path="email" /><br>
	Password: <form:password path="password" /><br>
	<button type="submit">Login</button>
</form:form>
```

modelAttribute 속성으로 지정된 이름의 객체를 세션에서 읽어와 form 태그로 설정된 태그에 값을 설정한다.

출처 : by enai

#### 👉 노션링크 : https://www.notion.so/Session-c20c88d0eb1d41f685439f43708e1864
