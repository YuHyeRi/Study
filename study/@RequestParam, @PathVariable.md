## ๐ ํ๋ผ๋ฏธํฐ๋ฅผ ๋ฐ๋ ๋ฐฉ๋ฒ

- **CASE 1 ๐http://localhost?id=1&page=2 (โ@Requestparam)**
- **CASE 2 ๐http://localhost/id/1 (โ@PathVariable)**

1. **@RequestParam ์ฌ์ฉํ๊ธฐ**
- defaultValue : ๊ฐ์ด ์์ ๋ ๊ธฐ๋ณธ์ผ๋ก ์ ๋ฌํ  ๊ฐ
- name : uri์์ ๋ฐ์ธ๋ฉํ  ํ๋ผ๋ฏธํฐ์ ์ด๋ฆ
- value : uri์์ ๋ฐ์ธ๋ฉํ์ฌ ๋ณ์นญ์ผ๋ก ์ ํ  ๊ฐ
- required : ํ์์ ์ผ๋ก ๊ฐ์ด ์ ๋ฌ๋์ด์ ธ์ผ ํ๋ ํ๋ผ๋ฏธํฐ (์ด๊ฒ ์๋ค๋ฉด error ๋ธ)
- ์ด๋ธํ์ด์์ ๊ดํธ ์์ ๋ฌธ์์ด์ด ์ ๋ฌ ์ธ์์ด๋ฆ(์ค์ ๊ฐ์ ํ์) ์ด๋ค.

```
@RequestMapping("/home")
public String test(@RequestParam("page") int pageNum {
	//..
}
```

1. **@PathVariable ์ฌ์ฉํ๊ธฐ**
- HTTP ์์ฒญ์ ๋ํด ๋งค์นญ๋๋ request parameter ๊ฐ์ด ์๋์ผ๋ก ๋ค์ด๊ฐ
- REST API์์ ๊ฐ์ ํธ์ถํ  ๋ ์ฃผ๋ก ๋ง์ด ์ฌ์ฉํจ
- ์ด๋ค ์์ฒญ์ด๋ ๊ฐ์ ํ๋๋ง ์ธ ์ ์์!!!
- ๋๋ฌธ์ ์ฌ๋ฌ ํ๋ผ๋ฏธํฐ๋ฅผ ๋ณด๋ด๊ณ  ์ถ๋ค๋ฉด @MatrixVariable์ด๋ผ๋ ๋ฉ์๋๋ฅผ ์ธ ์๋ ์์

```
@PostMapping("/index/{idx}")
@ResponseBody
public String Test(@PathVariable("idx") String idx) {
	//..
	return testService.getTest(idx);
}
```

1. **@RequestParam๊ณผ @PathVariable ํผํฉํ์ฌ ์ฌ์ฉํ๊ธฐ**
- ์ด์ ๊ฐ์ด ์ฝ๋๋ฅผ ์์ฑํ๋ฉด id๊ฐ์ ๋ฐ๋ผ ์ฌ๋ฌ ํ๋ผ๋ฏธํฐ๋ฅผ ์ฃผ๊ณ ๋ฐ์ ์ ์๋ค.

```
@RequestMapping("hello")
public String getList(@PathVariable(value="id") String id,
    @RequestParam(value="param1", required=true) String param1,
    @RequestParam(value="param2", required=true) String param2 {
	//..
}
```

#### ๋ธ์ : https://www.notion.so/RequestParam-PathVariable-7cfe693a49b247959d419ff96c30d287
