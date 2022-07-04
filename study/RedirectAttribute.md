# RedirectAttributes

폼 형식의 문서를 작성 후 서버로 보내면 (POST 방식) 곧이어 다른 페이지로 리다이렉트 한다. 문제는 이러한 리다이렉트 방식이 GET방식이라 데이터 전송에는 적절하지 않다.

리다이렉트의 특징은 아래 그림과 같다. spitter 객체를 보내려고 한다. 리다이렉트가 발생하면 원래 요청은 끊어지고, 새로운 HTTP GET 요청이 시작된다. (브라우저에게 이 URL로 리다이렉트해!) 때문에 리다이렉트 실행 이전에 수행된 모델 데이터는 소멸한다. 따라서 리다이렉트로 모델을 전달하는 것은 의미가 없다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/915597cf-69eb-442f-9499-e4da050bd5ec/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220222T072958Z&X-Amz-Expires=86400&X-Amz-Signature=1a5d063c3634cc6f31c5c43caea24c1d16832dfee4112ed2512bad75e23049a4&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

**그러나 리다이렉트 방법으로도 데이터를 전달하는 방법이 있다**. GET의 특징을 이용하는 것이다. 리다이렉트는 **HTTP GET 메소드 방식**이라고 앞서 말했다. GET 방식은 아래 그림처럼 header의 ‘?” 뒤에 파라미터를 붙여 전달한다. 때문에 URL이 노출된다는 특징이 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b3256799-cda4-4573-b38b-60bb621246b1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220222T073010Z&X-Amz-Expires=86400&X-Amz-Signature=7f9691fcb8d1e2c8f9ccf81ff1312b1a0f69c0f8421a0b46f840399fb67a5d83&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

그래서 스프링은 RedirectAttributes 클래스를 제공한다. 이 클래스는 모델의 기능을 그대로 확장(extends) 했으며, 몇 개의 도움 메소드가 추가되었다. 

검색해보니 대부분이 RedirectAttributes가 POST 방식으로 전달한다고 설명한다. 아무래도 URL 뒤에 파라미터가 붙지 않아서 POST 방식이라고 생각하나보다. **그러나 POST 방식이 아니다.** 겉으로만 그렇게 보일 뿐..

RedirectAttributes는 아래 그림처럼 리다이렉트가 발생하기 전에 모든 플래시 속성을 세션에 복사한다. 리다이렉션 이후에는 저장된 플래시 속성을 세션에서 모델로 이동시킨다. 헤더에 파라미터를 붙이지 않기 때문에 URL에 노출되지 않는다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/aa0641e7-e4af-46b5-9502-6ebe23aede9b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220222T073024Z&X-Amz-Expires=86400&X-Amz-Signature=b84cea7eedf78abdb0cb98c52f962d9573706a6be2afd23bd5476743ac1da8a7&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

RedirectAttributes가 제공하는 **addFlashAttribute()** 메소드는 **리다이렉트 직전 플래시에 저장하는** 메소드이다. **리다이렉트 이후에는 소멸한다.**

### 👧🏻 redirect시 데이터 전달 방법

→ RedirectAttributes 클래스를 사용하여전달 (Spring 3.1 버전에 추가)

→ redirect시 RedirectAttributes 클래스를 이용하여 효과적으로 alert 창을 띄울수도 있다.

RedirectAttributes 인터페이스는 기존의 Model 인터페이스를 확장한 것이다.

```jsx
pulbic interface RedirectAttributes extends Model {

}
```

리다이렉트 시 파라미터도 넘겨진다.

```jsx
@RequestMapping(value="/register", method=RequestMethod.POST)
	pubilc String registPOST(BoardVO board, Model model) throws Exception {
		
		service.regist(board);
		model.addAttribute("result", "success");

		return "redirect:/board/listAll";
}
```

URL에 노출된다. 또한 보안에도 취약하다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1bf3d28b-3a5a-4da3-87de-90f8712acad7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220222T073043Z&X-Amz-Expires=86400&X-Amz-Signature=4eb17184d6494e834664af03181765b39a09feaebafae1d266d245787a5e56c0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

### addFlashAttribute() 메소드 사용

```jsx
@RequestMapping(value="/register", method=RequestMethod.POST)
public String registPOST(BoardVo board, RedirectAttributes rttr) throws Exception {
	
	service.regist(board);
	rttr.addFlashAttribute("msg", "success");

	return "redirect:/board/listAll";
}
```

헤더가 아닌 세션을 통해 전달하므로 뒤에 피라미터 X

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/81915ab4-caf5-43d3-920a-818f6bbc82da/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220222%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220222T073056Z&X-Amz-Expires=86400&X-Amz-Signature=03672859b117df1454b1c8aa50950a248c94d33dd0551021c56e5aaa4bccdf03&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

👉참고 : [https://blog.naver.com/allkanet72/220964699929](https://blog.naver.com/allkanet72/220964699929)

[https://web-obj.tistory.com/455](https://web-obj.tistory.com/455)

#### 👉노션링크 : https://www.notion.so/RedirectAttributes-0f850d4c79ec4944b28dccc28c3a4876
