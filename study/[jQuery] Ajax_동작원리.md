# [jQuery] Ajax_동작원리

### *Ajax 구성요소*

Ajax는 기존에 사용되는 여러 기술을 함께 사용하여 웹 페이지의 일부분만을 갱신할 수 있도록 
해주는 기법이다. 이러한 Ajax에서 사용하는 기존 기술은 다음과 같다.

- 웹 페이지의 표현을 위한 html과 css
- 데이터에 접근하거나 화면 구성을 동적으로 조작하기 위해 사용되는 dom 모델
- 데이터의 교환을 위한 json이나 xml
- 웹 서버와의 비동기식 통신을 위한 XMLHttpRequest 객체
- 위에서 언급한 모든 기술을 결합하여 사용자의 작업 흐름을 제어하는데 사용되는 자바스크립트

---

### *Ajax 동작원리*

Ajax의 동작은 위에서 언급한 Ajax 구성요소들을 사용하여 이루어진다. 
Ajax를 이용한 웹 응용 프로그램은 *자바스크립트 코드를 통해 웹 서버와 통신*을 하게 된다. 
따라서 사용자의 동작에는 영향을 주지 않으면서도 백그라운드에서 지속해서 서버와 통신할 수 있다.

다음 그림은 Ajax를 이용한 웹 응용 프로그램과 기존의 웹 응용 프로그램의 동작 원리를 
간단히 보여주고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6af5ad0e-68b6-41a5-a70b-38af74af6e94/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220820%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220820T151726Z&X-Amz-Expires=86400&X-Amz-Signature=0dd58f071eccd7ea994193b5b6b7fafdfb7f463dc581d5a0e669a4f9c998e102&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

왼쪽 그림의 순서는 다음과 같이 진행된다.

1. 사용자에 의한 요청 이벤트가 발생
2. 요청 이벤트가 발생하면 이벤트 핸들러에 의해 자바스크립트가 호출
3. 자바스크립트는 XMLHttpRequest 객체를 사용하여 서버로 요청을 보냄
    
    이 때, 웹 브라우저는 요청을 보내고 나서 서버의 응답을 기다릴 필요 없이 다른 작업을 처리할 수 있음
    
4. 서버는 전달받은 XMLHttpRequest 객체를 가지고 Ajax 요청을 처리

5,6 서버는 처리한 결과를 html, xml 또는 json 형태의 데이터로 웹 브라우저에 전달, 이 때 전달되어

 응답은 새로운 페이지를 전부 보내는 것이 아니라 필요한 데이터만을 전달

7. 서버로부터 전달받은 데이터를 가지고 웹 페이지의 일부분만을 갱신하는 자바스크립트를 호출
8. 결과적으로 웹 페이지의 일부분만이 다시 로딩되어 표시됨
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-Ajax_-cee53f096d564738980f6c6c9d8f8834
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_intro_works](http://www.tcpschool.com/ajax/ajax_intro_works)
