# form 태그 -01

*→ form 태그 이용하여 데이터 주고 받기*

## ***속성***

### **🟣 action**

- form 내부에 입력값들 전송하는(받는사람) 서버측 url
- 수신 작업을 하는 프로그램 주소(url), Servlet, JSP, Spring

### 🟣 method

→ 서버로 데이터를 전송하는 방식 (디폴트 : get) 

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

👉 노션 : https://www.notion.so/form-01-8dd64e3b23ba4ef4bd14f18f5cc9e631

👉 출처 : [https://sas-study.tistory.com/131](https://sas-study.tistory.com/131) 

👉 참고 : [https://zorba91.tistory.com/27](https://zorba91.tistory.com/27)
