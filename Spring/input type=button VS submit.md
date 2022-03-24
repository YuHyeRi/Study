# input type=”submit” VS “button”

### 🟣 button 태그의 type 속성

- type=”**submit**” → 폼을 제출하는 이벤트 발생
- type=”**reset**” → 폼 안에 작성된 내용을 초기화 시킴
- type=”**button**” → 그 자체로는 이벤트가 없고, click 이벤트와 연결시켜 자바스크립트를 활용함

```jsx
<button type="button">클릭</button>

var btn = document.querySelector("button");
btn.addEventListener("click", function() {
	alert("테스트 중입니다.");
})
```

button 태그의 type 값들을 살펴보니 button은 form에서 활용하라고 만든 태그라는 것을 짐작할 수 있다.



### 🟣 button VS input

***(⇒ button 태그가 디자인 면에서 더 자유롭다.)***

button 태그와 input 태그의 가장 큰 차이점은

**button** → 스스로 닫지 않는 태그

**input** → 스스로 닫는 태그

따라서 **button**은 하위 태그들을 추가할 수 있지만 **input**은 그럴 수 없다.

가령, form의 제출 버튼에 이미지를 삽입하고 싶다면

**button** → button 태그의 자식으로 img 태그를 넣어준다

**input** → css의 background-image를 사용해야 한다.

***(* 참고로 이미지는 img 태그를 사용하는 것이 검색엔진 최적화 등에 도움이 된다.)***

****input 태그와 button 태그의 이미지 삽입 방법의 차이***

```html
<button type="button">
	<img src="이미지주소.png">
</button>

<input type="button" />

< !-- css --! >
input {
	width: 200px; height: 200px;
	background-image: url(이미지주소.png);
	background-size: 100% 100%
}
```

👉 노션 : https://www.notion.so/input-type-submit-VS-button-083bfe98be304be5babeac3ed14c2ea7

👉 참고 : [https://cocoder16.tistory.com/18](https://cocoder16.tistory.com/18)
