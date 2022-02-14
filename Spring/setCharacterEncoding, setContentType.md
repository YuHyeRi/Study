# [servlet,JSP] setCharacterEncoding, setContentType

## ❤️ setCharacterEncoding, setContentType

- request.setCharacterEncoding(”UTF-8”);
- response..setCharacterEncoding(”UTF-8”);
- response.setContentType(”text/html; charset=utf-8”);

---

### 1. request.setCharacterEncoding(”UTF-8”);

우리가 어떤 .jsp 파일이나 .html 파일에서 폼 태그에 입력한 값을 전송한다고 가정해보자.

폼 태그에서 입력한 값을 전송할 때는 GET방식과 POST방식으로 나뉘는데, ***POST방식으로 보내는 값이 ‘한글’ 일 경우*** 깨지지 않게 전달하기 위해 사용하는 것이 request.setCharacterEncoding(”UTF-8”); 이다. 

👧 : 그럼 GET방식으로 보내면 어떻게 되나요?

→ **GET방식**으로 보내진 한글은 톰캣이 **기본적으로 UTF-8 문자코드가 적용**되어 있어 **자동**으로 한글 처리를 해주기 때문에 한글이 깨지지 않는다.

GET, POST방식을 모두 사용하니 request.setCharacterEncoding(”UTF-8”);은 꼭 필요하다.

👧 : 그래도 한글 처리가 안된다면 어떡하나요?

→ server.xml 에 port=”8080”과 port=”8009” 두 개의 connector에서 URIEncoding=”URF-8” 을 추가한다.

```jsx
<Connector connection Timeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" 
URIEncoding="UTF-8" />
<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" URIEncoding="UTF-8" />
```

---

### 2. response..setCharacterEncoding(”UTF-8”);

서블릿에서 화면에 데이터를 출력하기 위해서는 out.printIn을 사용하는데, 위의 코드 없이 out.print(”hello”); 를 한다면 ‘hello’ 문구가 출력되지 않고 ??? 와 같은 물음표가 출력이 된다.

이러한 문제점을 해결하기 위한 방법이 response..setCharacterEncoding(”UTF-8”);을 추가하는 것이다.

---

### 3. response.setContentType(”text/html; charset=utf-8”);

그런데 response..setCharacterEncoding(”UTF-8”); 이 문장만 사용하면 ‘hello’ 대신 ‘댊뀘’과 같은 이상한 문자가 출력된다.

이는 **브라우저마다 기본적으로 문자코드를 해석하는 default가 다르기** 때문이다. 따라서 우리는 브라우저에게 utf-8 문자코드로 사용한다는 것을 알려주어야 한다.

이러한 내용을 전달하는 문장이 바로 response.setContentType(”text/html; charset=utf-8”); 인 것이다.

#### 👉 노션링크 : https://www.notion.so/servlet-JSP-setCharacterEncoding-setContentType-08f22b6ad6664614bca3e7c2c34c9d19
