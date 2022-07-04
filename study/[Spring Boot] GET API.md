# [Spring Boot] GET API

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/fe167304-2bac-44d5-ab2c-02851a404269/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220701%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220701T031628Z&X-Amz-Expires=86400&X-Amz-Signature=3197cdbaec10149174f72ffa305d12896e8845ab259c14b9a3338a4f52281db0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

REST API 디자인을 하기 위해 자원에 대한 행위들은 HTTP Method로 표현을 해야 한다. 
HTTP Method에는 GET, POST, PUT, DELETE 등이 존재한다.

<br>

### *GET API의 특징*

- 리소스를 취득하는 작업을 하는 API이다.
- CRUD에서 R에 해당한다.
- 값을 읽어오기만 하여 멱등성과 안정성이 있다는 특징이 있다.
- Path Variable을 사용가능하다.
- Query Parameter도 사용가능하다.

<aside>
💡 멱등성 : 수학에서 사용하는 용어로 연산을 여러 번 적용하더라도 결과가 달라지지 않는 
성질을 뜻한다.

</aside>

<br><br>

### *사용되는 Annotation의 종류*

- ***@RestController***
    - 해당 어노테이션을 추가해주면 해당 클래스는 REST API를 처리하는 Controller로 등록된다.
- ***@RequestMapping(path)***
    - 리소스를 설정하는 코드이며 괄호 안에 입력하는 값에 따라 URI가 [localhost:8080/path로](http://localhost:8080/path로)
    설정된다.
- ***@GetMapping(path)***
    - Get API를 해당 URI로 매핑시켜준다.
- ***@PathVariable***
    - 변화하는 구간에 사용하는 어노테이션이며 URL Path를 파싱해준다.
- ***@RequestParam***
    - URL에 쿼리문을 추가할 때 파라미터를 파싱해준다.
    
<br><br>

### *GET API 사용하기*

<br>

***@GetMapping***

```java
@RestController
@RequestMapping("/api/get")
public class GetApiController {
	
	// http://localhost:8081/api/get/hello
	@GetMapping(path="/hello")
	public String Hello(){
		return "get hello";
	}
}
```

- @RestController : 해당 클래스를 REST API를 처리하는 컨트롤러로 등록을 한다.
- @RequestMapping(”/api/get”) : URI를 지정해주는 어노테이션이다.
- 이렇게 @RestController, @RequestMapping()을 통해 GetApiController class는 기본 uri를 [http://localhost:8081/api/get으로](http://localhost:8081/api/get으로) 갖게 되었으며 REST API를 처리하는 컨트롤러로 생성되었다.
- @GetMapping(path=”/hello”) : GET 요청이 path로 들어오면 해당 메소드를 매핑시켜주겠다는 의미를 가진다. 위 코드의 경우는 기본 주소인 [http://localhost:8080/api/get](http://localhost:8080/api/get%EC%97%90) 에 path인 /hello를 추가하여 [http://localhost:8081/api/get/hello](http://localhost:9090/api/get/hello) 로 GET Request가 들어오면 메소드가 실행되고 
결과인 “get hello”를 리턴해주게 된다.
- @GetMapping은 기본적으로 괄호 안에 (”/hello”)라고 입력을 해도 괄호 안의 값을 value 값으로 인식을 하여 path=”/hello” 와 같은 결과를 낸다. 그래서 path는 꼭 써주지 않아도 괜찮다.

```java
@RequestMapping(path="/hi", method=RequestMethod.GET)
public String hi() {
		return "get hi";
}
```

위 코드는 과거에 사용하던 방식으로 RequestMapping을 하면 GET, POST, PUT, DELETE가 모두 동작한다. 위와 같이 GET만 사용하도록 지정하고 싶다면 method parameter를 추가해주면 된다.

<br>

***@PathVariable*** 

```java
@GetMapping("path-variable/{name}")
public String pathVariable(@PathVariable String name) {
		System.out.println("pathVariable : " + name);
		return name;
}
```

사용자의 이름, 아이디 등 변할 수 있는정보를 URI에 넣어야 한다면 개발자는 같은 메소드를 각각의 path마다 생성해주어야 할 것이다. 그러나 이것은 매우 비효율적이다. 바로 이러한 것을 해결해주는 방법이 PathVariable이다. 변화하는 구간에 대해서는 PathVariable을 사용해야 한다.

PathVariable은 @GetMapping의 path를 “path-variable/{name}” 과 같이 변경될 수 있는 부분을 { } 
으로 지정해주면 된다. { } 안에는 변수명을 적으며 메소드의 파라미터에 @PathVariable 변수명을
입력하여 { } 에 들어가는 값을 읽어온다.

위의 코드는 [http://localhost:8080/api/get/path-variable/](http://localhost:8080/api/get/path-variable/seongwon)name 이라는 URIfh request가 왔다면 name은 name이 되며 리턴될 것이다.

```java
@GetMapping("path-variable/{name}")
public String pathVariable(@PathVariable(name="name") String pathName) {
		System.out.printIn("PathVariable : " + pathName);
		return pathName;
}
```

프로그래밍을 하다보면 변수가 꼬여 PathVariable의 변수명을 다르게 설정해야 하는 상황이 생길 수도 있다. 그러한 경우에는 위 코드와 같이 메소드 파라미터에 @PathVariable의 (name=” “) 같이 지정을 하여 다른 변수명을 사용할 수도 있다.

<br>

***Query Parameter*** 


<br>
👉 notion : https://www.notion.so/Spring-Boot-GET-API-f73546e3ed214719a44e7d6ffb3859e4
<br>
👉 Reference : [https://velog.io/@seongwon97/Spring-Boot-GET-API-사용하기](https://velog.io/@seongwon97/Spring-Boot-GET-API-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
