# Session ์ฌ์ฉ๋ฐฉ๋ฒ

## **๐ง๐ป ์ธ์(Session) ์ด๋?**

โ **ํด๋ผ์ด์ธํธ ๋ณ๋ก ์๋ฒ์ ์ ์ฅ๋๋ ์ ๋ณด**์ด๋ค. ์ฌ์ฉ์ ์ปดํจํฐ์ ์ ์ฅ๋๋ ์ฟ ํค์ ๋ค๋ฅด๊ฒ ์๋ฒ์ ์ ์ฅ๋๋ฏ๋ก, ๋น๊ต์  ***๋ณด์์ด ํ์ํ ๋ฐ์ดํฐ***๋ ์ฟ ํค๋ณด๋ค ์ธ์์ ์ ์ฅํ๋ค. *์๋ฒ๊ฐ ์ข๋ฃ๋๊ฑฐ๋ ์ ํจ์๊ฐ์ด ์ง๋๋ฉด ์ฌ๋ผ์ง๋ค.*

---

## 1. Session ์ด์ฉ ๋ฐฉ๋ฒ

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5646f7ab-4632-4a57-8916-887c80330985/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220226%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220226T011538Z&X-Amz-Expires=86400&X-Amz-Signature=d99814353b494c96e5abe5b2efc3a2690f83fd8107c2a3a426b960ffffd0401c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- **์น ํด๋ผ์ด์ธํธ๊ฐ ์๋ฒ์ ์์ฒญ์ ๋ณด๋ด๋ฉด, ์๋ฒ๋ ํด๋ผ์ด์ธํธ๋ฅผ ์๋ณํ๋ session id๋ฅผ ์์ฑํ๋ค.**
- **์๋ฒ๋ session id๋ก key์ value๋ฅผ ์ ์ฅํ๋ HttpSession์ ์์ฑํ๊ณ  session id๋ฅผ ์ ์ฅํ๊ณ  ์๋ ์ฟ ํค๋ฅผ ์์ฑํ์ฌ ํด๋ผ์ด์ธํธ์๊ฒ ์ ์กํ๋ค.**
- **์๋ฒ๋ ์ฟ ํค์ session id๋ก HttpSession์ ์ฐพ๋๋ค.**

javax.sevlet.http.HttpSession์ผ๋ก ์ธ์ ๋ฐ์ดํฐ๋ฅผ ๋ค๋ฃฐ ์ ์๋ค.

### 1) ์ธ์ ์์ฑ ๋ฐ ์ป๊ธฐ

```jsx
HttpSession session = request.getSession();
HttpSession session = request.getSession(true);
```

request์ getSession() ๋ฉ์๋๋ ์๋ฒ์ ์์ฑ๋ ์ธ์์ด ์๋ค๋ฉด ์ธ์์ ๋ฐํํ๊ณ , ์๋ค๋ฉด ์ ์ธ์์ ์์ฑํ์ฌ ๋ฐํํ๋ค. (์ธ์ default๊ฐ true)

์๋กญ๊ฒ ์์ฑ๋ ์ธ์์ธ์ง๋ HttpSession์ isNew() ๋ฉ์๋๋ก ์ ์ ์๋ค.

```jsx
HttpSession session = request.getSession(false);
```

request์ getSession() ๋ฉ์๋์ ํ๋ผ๋ฏธํฐ๋ก false๋ฅผ ์ ๋ฌํ๋ฉด, ์ด๋ฏธ ์์ฑ๋ ์ธ์์ด ์์ ๋ ๊ทธ ์ธ์์ ๋ฐํํ๊ณ , ์์ผ๋ฉด null์ ๋ฐํํ๋ค.

### 2) ์ธ์์ ๊ฐ ์ ์ฅํ๊ธฐ

```jsx
setAttribute(String name, Object value)
```

setAttribute๋ name, value ์์ผ๋ก ๊ฐ์ฒด Object๋ฅผ ์ ์ฅํ๋ ๋ฉ์๋์ด๋ค.

์ธ์์ด ์ ์ง๋๋ ๋์ ์ ์ฅํ๋ค.

```jsx
session.setAttribute(์ด๋ฆ, ๊ฐ)
```

์ด๋ ๊ฒ ์ฌ์ฉํ  ์ ์๋ค.

### 3) ์ธ์ ๊ฐ ์กฐํํ๊ธฐ

```jsx
getAttribute(String name)
```

getAttribute ๋ฉ์๋๋ก ์ธ์์ ์ ์ฅ๋ ๊ฐ์ ์กฐํํ  ์ ์๋ค.

๋ฆฌํดํ์์ Object์ด๋ฏ๋ก ํ๋ณํ์ด ํ์ํ๋ค.

๋ฉ์๋ setAttribute์ ์ด์ฉํ name์ ์๊ณ  ์๋ค๋ฉด ์๋์ ๊ฐ์ด ์กฐํํ  ์ ์๋ค.

```jsx
String value = (String)session.getAttribute("name");
```

### 4) ์ธ์ ๊ฐ ์ญ์ ํ๊ธฐ

```jsx
removeAttribute(String name)
```

removeAttribute ๋ฉ์๋๋ก name๊ฐ์ ํด๋นํ๋ ์ธ์์ ๋ณด๋ฅผ ์ญ์  ํ  ์ ์๋ค.

```jsx
invalidate()
```

invalidate๋ก ๋ชจ๋  ์ธ์์ ๋ณด๋ฅผ ํ ๋ฒ์ ์ญ์ ํ  ์๋ ์๋ค.

### 5) ์ธ์ ์ ์ง ์๊ฐ ์ค์ ํ๊ธฐ

๊ธฐ๋ณธ์ ์ผ๋ก ์ธ์์ 30๋ถ ์ ์ง๋๋ค. ์ธ์ ์ ์ง ์๊ฐ์ ์๋ฒ์ ์ ์ํ ํ ์๋ฒ์ ์์ฒญ์ ํ์ง ์๋ ์ต๋์๊ฐ์ ๋งํ๋ค. 30๋ถ ์ด์ ์๋ฒ์ ๋ฐ์์ ๋ณด์ด์ง ์์ผ๋ฉด ์ธ์์ด ์๋์ผ๋ก ๋์ด์ง๋ค. ์ด ์ธ์ ์ ์ง ์๊ฐ์ web.xml ํ์ผ์์ ์ค์ ํ  ์ ์๋ค.

```jsx
<session-config>
	<session-timeout>30</session-timeout>
</session-config>
```

---

## 2. Spring MVC์์ Session ์ฌ์ฉ ๋ฐฉ๋ฒ

Spring MVC์์ @SessionAttributes์ @ModelAttribute ์ด๋ธํ์ด์์ผ๋ก ์ธ์์ ๊ฐ์ ์ ์ฅํ๊ณ  ๊ฐ์ ธ์ค๋ ๋ฐฉ๋ฒ์ ์๋ ์์ ๋ค๋ก ์ดํดํด๋ณด์.

@SessionAttributes ํ๋ผ๋ฏธํฐ๋ก ์ง์ ๋ ์ด๋ฆ๊ณผ ๊ฐ์ ์ด๋ฆ์ด @ModelAttribute์ ์ง์ ๋์ด ์๋ค๋ฉด, @ModelAttribute๊ฐ ์ค์ ๋ ๋ฉ์๋๊ฐ ๋ฐํ๋๋ ๊ฐ์ ๊ทธ ์ธ์์ ์ ์ฅํ๋ค.

### 1) Controller ํด๋์ค์ @SessionAttributes๋ฅผ ์ ์ธํ๊ณ  @ModelAttribute๋ ๋ฉ์๋ ์์ ์ ์ธํ๋ค.

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

์ ์์ ๋ฅผ ๋ณด๋ฉด @SessionAttributes์ ํ๋ผ๋ฏธํฐ๋ก ์ง์ ๋ ์ด๋ฆ์ user์ด๋ค. @ModelAttribute์ ํ๋ผ๋ฏธํฐ๋ก ์ง์ ๋ ์ด๋ฆ ๋ํ user์ด๋ค. ๋์ ์ด๋ฆ์ด ๊ฐ์ผ๋ฏ๋ก setUpUserForm ๋ฉ์๋๊ฐ ๋ฐํํ๋ User ๊ฐ์ฒด๋ user๋ผ๋ ์ด๋ฆ์ ์ธ์์ ์ ์ฅ๋๋ค.

(* ์ ์ฝ๋๋ ์ ๊ฐ์ฒด๋ฅผ ๋ฐํํ์ฌ ์ ์ฅ์ํค๋ฏ๋ก ํด๋น ์ธ์๊ฐ์ ์ด๊ธฐํํ๋ ๋ชฉ์ ์ผ๋ก ์ฌ์ฉํ  ์ ์๋ค.)

### 2) @SessionAttributes๋ฅผ Controller ํด๋์ค ์์ ์ ์ธํ๊ณ , ๋ฉ์๋ ํ๋ผ๋ฏธํฐ๋ก @ModelAttribute๋ฅผ ๋ถ๋ฌ์จ๋ค.

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

@SessionAttributes์ ์ด๋ฆ๊ณผ @ModelAttribute์ ์ด๋ฆ์ด ๊ฐ๋ค. ํด๋ผ์ด์ธํธ๋ก๋ถํฐ ์ ์ก๋ฐ์ user๊ฐ์ด ๊ทธ ์ธ์์ ์ ์ฅ๋๋ค.

### 3) ๋ฉ์๋์ @SessionAttribute๊ฐ ์์ ๊ฒฝ์ฐ, ํ๋ผ๋ฏธํฐ๋ก ์ง์ ๋ ์ด๋ฆ์ผ๋ก ๋ฑ๋ก๋ ์ธ์ ์ ๋ณด๋ฅผ ์ฝ์ด์ ๋ณ์์ ํ ๋นํ๋ค.

```jsx
@GetMapping("/info")
public String userInfo(@SessionAttribute("user") User user {
	...
	return "user";
}
```

### 4) SessionStatus๋ก @SessionAttributes์ ์ํด ์ ์ฅ๋ ์ค๋ธ์ ํธ๋ฅผ ์ ๊ฑฐํ  ์ ์๋ค. SessionStatus๋ ์ปจํธ๋กค๋ฌ ๋ฉ์๋์ ํ๋ผ๋ฏธํฐ๋ก ์ฌ์ฉํ  ์ ์๋ ์คํ๋ง ๋ด์ฅ ํ์์ด๋ค.

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

SessionStatus์ setComplete ๋ฉ์๋๋ก user๋ผ๋ ์ด๋ฆ์ ์ธ์ ๊ฐ์ ์ ๊ฑฐํ๋ค.

### 5) Spring MVC์ form tag ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ฌ์ฉํ๊ธฐ

```jsx
<form:form action="login" method="post" modelAttribute="user">
	Email: <form:input path="email" /><br>
	Password: <form:password path="password" /><br>
	<button type="submit">Login</button>
</form:form>
```

modelAttribute ์์ฑ์ผ๋ก ์ง์ ๋ ์ด๋ฆ์ ๊ฐ์ฒด๋ฅผ ์ธ์์์ ์ฝ์ด์ form ํ๊ทธ๋ก ์ค์ ๋ ํ๊ทธ์ ๊ฐ์ ์ค์ ํ๋ค.

์ถ์ฒ : by enai

#### ๐ ๋ธ์๋งํฌ : https://www.notion.so/Session-c20c88d0eb1d41f685439f43708e1864
