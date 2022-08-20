# [jQuery] Ajax_기초

### *Ajax를 배우기 위한 사전지식*

html, css, 자바스크립트, dom, xml 등 기존에 사용되던 여러 기술을 함께 사용하는 새로운 개발 기법이다. 따라서 ajax를 배우기 전에 다음과 같은 기초 지식을 가지고 있으면 좋다.

- [html](http://www.tcpschool.com/html/intro) 수업 배우기
- [자바스크립트](http://www.tcpschool.com/javascript/intro) 수업 배우기
- [xml](http://www.tcpschool.com/xml/intro) 수업 배우기

---

### *Ajax의 장점*

- 웹 페이지 전체를 다시 로딩하지 않고도 웹 페이지의 일부분만을 갱신할 수 있다.
- 웹 페이지가 로드된 후에 서버로 데이터 요청을 보낼 수 있다.
- 웹 페이지가 로드된 후에 서버로부터 데이터를 받을 수 있다.
- 백그라운드 영역에서 서버로 데이터를 보낼 수 있다.

---

### *Ajax의 한계*

- Ajax는 클라이언트가 서버에 데이터를 요청하는 클라이언트 풀링 방식을 사용하므로 서버 푸시 방식의 실시간 서비스는 만들 수 없다.
- Ajax로는 바이너리 데이터를 보내거나 받을 수 없다.
- Ajax 스크립트가 포함된 서버가 아닌 다른 서버로 Ajax 요청을 보낼수는 없다.
- 클라이언트의 PC로 Ajax 요청을 보낼 수는 없다.

<aside>
💡 ***클라이언트 풀링(Client pooling) 방식***이란 사용자가 직접 원하는 정보를 서버에게 요청하여 얻는 방식을 의미한다.
이에 반해 ***서버 푸시(Server push) 방식***이란 사용자가 요청하지 않아도 서버가 알아서 자동으로 특정 정보를 제공하는 것을 의미한다. 요즘 많이들 사용하는 스마트폰에서 각종 앱이 보내는 푸시 알림이 서버 푸시 방식의 대표적인 예이다.

</aside>

---

### *Ajax 프레임워크*

Ajax를 이용하여 새발을 손쉽게 할 수 있도록 미리 여러가지 기능을 포함해 놓은 개발 환경을 
Ajax 프레임워크라고 한다. 이러한 Ajax 프레임워크 중에서도 가장 많이 사용되는 프레임워크는 
다음과 같다.

- Prototype
- [script.aculo.us](http://script.aculo.us/)
- dojo
- jQuery

이 외에도 수많은 Ajax 프레임워크가 널리 사용되고 있다.
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-Ajax_-aa8c548d497d49c4b8018c0130a55330
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_intro_basic](http://www.tcpschool.com/ajax/ajax_intro_basic)
