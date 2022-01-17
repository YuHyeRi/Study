## 🐑 파라미터를 받는 방법

- **CASE 1 👉http://localhost?id=1&page=2 (⇒@Requestparam)**
- **CASE 2 👉http://localhost/id/1 (⇒@PathVariable)**

1. **@RequestParam 사용하기**
- defaultValue : 값이 없을 때 기본으로 전달할 값
- name : uri에서 바인딩할 파라미터의 이름
- value : uri에서 바인딩하여 별칭으로 정할 값
- required : 필수적으로 값이 전달되어져야 하는 파라미터 (이게 없다면 error 뜸)
- 어노테이션의 괄호 안의 문자열이 전달 인자이름(실제값을 표시) 이다.

```
@RequestMapping("/home")
public String test(@RequestParam("page") int pageNum {
	//..
}
```

1. **@PathVariable 사용하기**
- HTTP 요청에 대해 매칭되는 request parameter 값이 자동으로 들어감
- REST API에서 값을 호출할 때 주로 많이 사용함
- 어떤 요청이던 간에 하나만 쓸 수 있음!!!
- 때문에 여러 파라미터를 보내고 싶다면 @MatrixVariable이라는 메서드를 쓸 수도 있음

```
@PostMapping("/index/{idx}")
@ResponseBody
public String Test(@PathVariable("idx") String idx) {
	//..
	return testService.getTest(idx);
}
```

1. **@RequestParam과 @PathVariable 혼합하여 사용하기**
- 이와 같이 코드를 작성하면 id값에 따라 여러 파라미터를 주고받을 수 있다.

```
@RequestMapping("hello")
public String getList(@PathVariable(value="id") String id,
    @RequestParam(value="param1", required=true) String param1,
    @RequestParam(value="param2", required=true) String param2 {
	//..
}
```

#### 노션 : https://www.notion.so/RequestParam-PathVariable-7cfe693a49b247959d419ff96c30d287
