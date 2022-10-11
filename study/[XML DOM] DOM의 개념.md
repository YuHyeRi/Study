# [XML DOM] DOM의 개념

### 문서 객체 모델(DOM)이란?

DOM(Document Object Model)은 XML이나 HTML 문서에 접근하기 위한 API로 
W3C 표준 권고안이다. DOM은 문서 내의 모든 요소를 정의하고 해당 요소에 접근하는 방법까지 
정의한다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<programming_languages>
    <language>
        <name>HTML</name>
        <category>web</category>
        <developer>W3C</developer>
        <version status="working draft">5.1</version>
        <priority rating="1">high</priority>
    </language>
</programming_languages>
```

DOM은 다음 그림과 같이 계층 구조로 표현된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/dfd598d7-5264-4a4d-be4e-7a613a740ba7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221011%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221011T071733Z&X-Amz-Expires=86400&X-Amz-Signature=0ad6d7cb946c6f8e2a3fbc7573c84dd5f0bf9ed4b81defbf314d0a5cb01cc06d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

W3C DOM 표준은 다음과 같이 세 가지 모델로 구분된다.

1. Core DOM : 모든 문서 타입을 위한 DOM 모델
2. HTML DOM : HTML 문서를 위한 DOM 모델
3. XML DOM : XML 문서를 위한 DOM 모델

---

### HTML DOM

HTML DOM은 HTML 문서에 접근하여 조작할 수 있는 표준화 된 방법을 정의한다. 
모든 HTML 요소는 HTML DOM을 통해 접근할 수 있다.

---

### XML DOM

XML DOM은 XML 문서에 접근하여 해당 문서를 조작할 수 있는 표준화된 방법을 정의한다. 
모든 XML 요소는 XML DOM을 통해 접근할 수 있따.

XML DOM은 XML 문서 내의 모든 요소의 객체, 속성 그리고 메소드를 정의한다. 
이러한 XML DOM은 플랫폼이나 프로그래밍 언어에 상관없이 언제나 사용할 수 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-DOM-DOM-8b93c862609543ccbf2f5f1de8ff2d9b
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_concept](http://www.tcpschool.com/xml/xml_dom_concept)
