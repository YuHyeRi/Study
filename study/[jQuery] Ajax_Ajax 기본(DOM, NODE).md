# [jQuery] **Ajax_Ajax 기본(DOM, NODE)**

## *🟣 DOM*

### *문서 객체 모델(DOM)이란?*

문서 객체 모델(DOM, Document Object Model)은 HTML 문서나 XML 문서에 접근하기 위한 일종의 인터페이스이다. 이 모델은 문서 내의 모든 요소의 목적과 특징을 정의하고, 각각의 요소에 접근하는 방법을 제공한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/164e4b98-1dd2-40d6-9d0f-e5639eee96a7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220829%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220829T010331Z&X-Amz-Expires=86400&X-Amz-Signature=7b7a66d6d362fb9734f0afa58c4d4116a7bc1bcd006eb5c924b2f70158a2b0d5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

Ajax에서는 이러한 DOM을 이용하여 웹 페이지의 일부 요소만을 변경할 수 있다. 
따라서 Ajax를 배우기 전에 DOM에 대한 기본적인 사항을 알아야만 한다.

### *DOM 요소의 선택*

자바스크립트로 DOM 요소를 다루기 위해서는 우선 해당 요소를 선택해야만 한다. 
DOM 요소를 선택하는 방법은 다음과 같다.

1. *태그 이름(tag name)*을 이용한 선택
2. *아이디(id)*를 이용한 선택
3. *클래스(class)*를 이용한 선택
4. *CSS 선택자(selector)*를 이용한 선택
5. *HTML 객체 집합(object collection)*을 이용한 선택

### *DOM 요소의 내용 변경*

DOM을 이용하면 DOM 요소의 내용(content)이나 속성값 등을 손쉽게 변경할 수 있다.
DOM 요소의 내용을 바꾸는 가장 쉬운 방법은 innerHTML 프로퍼티를 이용하는 것이다. 
또한 DOM 요소의 속성 이름을 이용하면 속성값을 바로 변경할 수도 있다. 
더 자세한 사항은 자바스크립트 DOM 요소 수업에서 확인할 수 있다.

[자바스크립트 DOM 요소 수업 확인 👉](http://www.tcpschool.com/javascript/js_dom_element)

---

## *🟣 노드*

### *노드(**node)***

DOM은 노드라고 불리는 계층적 단위에 정보를 저장하고 있다. 
DOM은 이러한 노드들을 정의하고 그들 사이의 관계를 설명해주는 역할을 한다. 
노드에 대한 더 자세한 사항은 자바스크립트 노드 수업에서 확인할 수 있다.

[자바스크립트 노드 수업 확인 👉](http://www.tcpschool.com/javascript/js_dom_node)

### ***노드 트리(node tree)***

문서의 정보는 노드 트리라고 불리는 *계층적 구조*에 저장된다. 
이러한 노드 트리는 노드들의 집합으로 *노드 간의 관계를 보여준다.*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2df2d0f0-728c-47b6-aac1-ce72fd97237e/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220829%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220829T010348Z&X-Amz-Expires=86400&X-Amz-Signature=ae291eb1a074b1a06041e5795493046728cc604d4f83877cf09ead33ac4745e0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject>

### *노드 관의 관계*

노트 트리의 모든 노드들은 서로 계층적 관계를 가지고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/59f9593a-802c-46c6-896d-935797b1680d/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220829%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220829T010408Z&X-Amz-Expires=86400&X-Amz-Signature=26e1949bfdbd262c3f56af757380debb7b9889b3c40870bf64aa7d5bd61431a1&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

노드 트리의 가장 상위에는 단 하나의 루트 노드(root node)가 존재한다. 
루트 노드를 제외한 모든 노드는 단 하나의 부모 노드(parent node)만을 가진다. 
모든 요소 노드는 자식 노드(child node)를 가질 수 있다. 
형제 노드는(sibling node)란 같은 부모 노드를 가지는 모든 노드를 가리킨다. 
조상노드(ancestor node)란 부모 노드를 포함해 계층적으로 현재 노드보다 상위에 존재하는 
모든 노드를 가리킨다. 
자손 노드(descendant node)란 자식 노드를 포함해 계층적으로 현재 노드보다 하위에 존재하는 모든 노드를 가리킨다.

### *노드로의 접근*

자바스크립트로 DOM 노드에 접근하는 방법은 다음과 같다.

1. getElementByTagName() 메소드를 이용하는 방법
2. 노드 간의 간계를 이용하여 접근하는 방법

### *노드에 대한 정보*

DOM 노드에 대한 정보는 다음과 같은 속성을 통해 접근할 수 있다.

1. nodeName : 노드 고유의 이름을 명시함
2. nodeValue : 노드의 값을 명시함
3. nodeType : 노드 고유의 타입을 명시함

더 자세한 사항은 자바스크립트 노드로의 접근 수업에서 확인할 수 있다.

[자바스크립트 노드로의 접근 수업 확인 👉](http://www.tcpschool.com/javascript/js_dom_nodeAccess)

### ***노드 리스트(node list)***

노드 리스트는 getElementsByTagName 메소드나 childNodes 속성의 속성값으로 반환되는 
객체이다. 이 객체는 HTML 문서와 같은 순서로 문서 내의 모든 노드를 리스트 형태로 저장하고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d7863525-a016-4bde-955f-85845677d2a1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220829%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220829T010426Z&X-Amz-Expires=86400&X-Amz-Signature=cd2c2f350e57d302443bdd82fcd32e3aee0731bba1611db94d3164c60ac3e503&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

노드에 대한 더 자세한 사항은 자바스크립트 노드 리스트 수업에서 확인할 수 있다.

[자바스크립트 노드 리스트 수업 확인 👉](http://www.tcpschool.com/javascript/js_dom_nodeList)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-Ajax_Ajax-DOM-NODE-c2eec49f1fc04845b76b199025b487f5
<br>
👉 출처1 : [http://www.tcpschool.com/ajax/ajax_basic_dom](http://www.tcpschool.com/ajax/ajax_basic_dom)
<br>
👉 출처2 : [http://www.tcpschool.com/ajax/ajax_basic_node](http://www.tcpschool.com/ajax/ajax_basic_node)
