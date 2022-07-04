# form 태그 -01

*→ form 태그 이용하여 데이터 주고 받기*

## ***속성***

### ***🟣 action***

- form을 전송할 서버 쪽의 script 파일을 지정
- 전송되는 서버 url 또는 html 링크
- form 내부에 입력값들 전송하는(받는사람) 서버측 url
- 수신 작업을 하는 프로그램 주소(url), Servlet, JSP, Spring

### *🟣 method*

- 서버로 데이터를 전송하는 방식 (디폴트 : get)

→ get : 256 ~ 4096 byte 까지만 전송 가능

→ post : 입력 내용의 길이 제한 없음

***🟡 get***

- url의 끝에 데이터를 첨부파여 전송하는 방식
- 키=값&키=값&키=값&키=값&키=값 (get방식 패턴)
- 항상 노출이 된다. (보안상 중요 데이터는 사용금지)
- url 최대 256자까지 (오버플로우 : 데이터 짤림)
- url은 인코딩 방식이 base64 (한글포함X)
- 되도록 영문과 숫자 정도만 전송

***🟡 post***

- 패킷의 본문 안에 데이터를 넣어 전송하는 방식
- 데이터 노출 없음
- 제한 크기 무제한
- 한글 상관없이 전송

```jsx
<form action="boardList.jsp" method="post">
	이름: <input type="text" name="name" />
	나이: <input type="text" name="age" />
</form>

<a href="boardList.jsp">페이지 이동하기</a>
```

### *🟣 name*

- form의 이름, 서버로 보내질 때의 이름의 값으로 데이터 전송

### ***🟣 target***

- action에서 지정한 script파일을 현재 창이 아닌 다른 위치에 열도록 지정

### *🟣 autocomplete*

- 자동완성. on으로 하면 form 전체에 자동 완성 허용

```jsx
<form action="/action_page.php" name="profile" method="get" autocomplete="on">
	<input type="text" name="id" />
	<select>
		<option value="blue">blue</option>
	</select>
	<input type="submit" value="submit"/>
</form>
```


submit button이 클릭되면 input 태그에 입력된 데이터가 form 태그의 method 속성에지정된 방식으로  action 속성에 지정된 서버 측의 처리 로직에 전달된다.

---

## ***<form> 내부의 태그와 속성들***

### *<input>*

→ form의 요소 중 하나, 사용자가 정보를 입력하는 부분을 만들어야 할 때 사용한다.

→ type에 따라 어떤 형식으로 정보를 받을지 결정한다. id값을 통해 서로 구분할 수 있다.

***🟣 속성***

- readonly : 읽기 전용 필드
- placeholder
- autofocus : 페이지를 불러오자마자 특정 부분에 마우스 커서가 표시되도록 함
- autocomplete : 자동완성 설정
- max / min : <input> 필드의 최대값 / 최소값 지정
- maxLegnth : 텍스트 필드에 최대로 입력할 수 있는 문자 갯수 지정
- step : 숫자의 간격 설정, <input>이 date, datatime, datetime-local, month, week, time, number, range일 경우 사용 가능
- required : 필수 입력 필드 지정 (빈칸이면 안넘어감)

***🟣 type 속성에서 사용 가능한 유형***

- hidden : 서버로 보내는 값들을 보내는 필드 (사용자에게 노출❌)
- text : 한줄짜리 텍스트를 입력할 수 있는 텍스트 상자
- search : 검색상자 (크롬, 사파리에서만 사용가능하며 크로스브라우징이 ❌.. 잘 사용하지 않음)
- tel : 전화번호 입력필드
- url : url 주소를 입력필드
- email : 메일 주소 입력 필드 (’@’가 들어간 이메일 형식인지 검사해줌)
- password : 비밀번호 입력필드
- number : 숫자를 조절할 수 있는 화살표
- range : 숫자범위를 조절할 수 있는 슬라이드 막대, min과 max로 범위를 지정하고 step으로 증가값을 셋팅할 수 있다. 기본셋팅은 파란색으로 되어있다. (CSS로 커스터마이징 가능, 다만 각 브라우저마다 가능한 정도가 다르기 확인할 필요 있음)
- color : 색상표
- checkbox : 체크박스 (2개 이상 선택가능)
- radio : 라디오버튼 (1개만 선택가능)
- datetime : 국제표준시(UTC)로 설정된 날짜와 시간 (연, 월, 시, 분, 초, 분할초)
- datetime-local : 사용자가 있는 지역을 기준으로 한 날짜와 시간 (연, 월, 시, 분, 초, 분할초)
- date : 사용자 지역을 기준으로 한 날짜 (연, 월, 일)
- month : 사용자 지역을 기준으로 한 날짜 (연, 월)
- week : 사용자 지역을 기준으로 한 날짜 (연, 주)
- time : 사용자 지역으르 기준으로 한 시간 (시, 분, 초, 분할초)
- button : 버튼을 만들어, 클릭시 이벤트를 발생시킨다. submit과는 차이가 있는데, javaScript를 사용한 효과의 적용 유무이다.
- file : 파일 첨부 버튼 (accept를 사용하여 제출 가능한 파일 양식을 지정 가능)
- submit : 서버 전송 버튼
- image : submit 버튼 대신 사용할 이미지
- reset : 리셋버튼, 사용자가 입력한 모든 정보를 지울 수 있다. 해당 form에 입력했던 내용들을 처음부터 입력하고 싶을 떄 활용

### ***textarea***

→ text 타입과 비슷한 형태이지만, text는 한 줄만 입력 가능하지만, <textarea> 태그는 긴 내용을 입력하는 것이 가능하다.

- 여러 줄의 텍스트를 입력하는 창을 만든다.
- 텍스트 창의 너비와 높이는 html에서는 cols, rows 속성으로, css에서는 width, height 값으로 지정할 수 있다.
- readonly 속성을 입력하면 클릭은 가능하지만 입력은 안되며, disabled 속성은 클릭조차 안된다.
- maxlength와 minlength로 최소, 최대 문자수를 지정할 수 있다.

### ***label***

→ input 태그를 제어하여 상태값을 변경하도록 돕는다.

- 체크박스를 예로 들자면, 클릭 영역이 단순 체크박스 영역에 국한된 것이 아니라 체크박스가 가리키는 툴팁역역에도 클릭시 input 태그가 함께 체크될 수 있다.

```jsx
<label for="test">여기를 클릭</label>
<input id="test" type="checkbox" />
```

위 코드는 label 태그 안의 영역 클릭시, for 속성이 지정된 test 라는 id값을 찾는다. 즉 아래의 input 태그가 원격으로, 자동으로 클릭한 것과 같이 동작하게 된다.

```jsx
<!-- label 태그 안에 input 태그를 위치 --!>
<form name="selectTest">
	<ul>
		<li>
			<label><input type="checkbox" />바나나</label>
		</li>
		<li>
			<label><input type="checkbox" />사과</label>
		</li>
	</ul>
</form>
```


👉 노션 : https://www.notion.so/form-01-8dd64e3b23ba4ef4bd14f18f5cc9e631

👉 출처 : [https://sas-study.tistory.com/131](https://sas-study.tistory.com/131)

👉 출처 : [https://inpa.tistory.com/entry/HTML-📚-폼Form-태그-정리](https://inpa.tistory.com/entry/HTML-%F0%9F%93%9A-%ED%8F%BCForm-%ED%83%9C%EA%B7%B8-%EC%A0%95%EB%A6%AC)

👉 참고 : [https://zorba91.tistory.com/27](https://zorba91.tistory.com/27)
