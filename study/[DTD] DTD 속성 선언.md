# [**DTD] DTD 속성 선언**

**속성의 선언**

DTD에서 속성은 요소에 대한 추가적인 정보를 제공하며, 해당 요소의 특징을 정의한다.
DTD에서 속성은 다음과 같이 ATTLIST 구문으로 선언할 수 있다.

<aside>
💡 <!ATTLIST 요소이름 속성이름 속성타입 속성값>

</aside>

요소의 이름은 해당 속성이 포함될 요소의 이름을 명시한다.

---

**속성의 타입 정의**

DTD에서 속성을 선언할 때 사용할 수 있는 속성 타입은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f07d74ba-8dce-434b-9bdf-e2615085ef7b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221028%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221028T231548Z&X-Amz-Expires=86400&X-Amz-Signature=889ad7841accb12539655c425a201c972345b1b32033fd9ae92c6dd814dca006&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject>

---

**속성값 정의**

DTD에서 속성을 선언할 때 사용할 수 있는 속성값은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/399450a1-c0d9-474c-b3d1-1d419d3d3825/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221028%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221028T231605Z&X-Amz-Expires=86400&X-Amz-Signature=e123e5f288da2effd23406931f148db05fa634a36407226ab5549cadbd57221e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

*DTD 예제*

<aside>
💡 <!ELEMENT math EMPTY>

<!ATTLIST math grade CDATA 'F'>

</aside>

위의 예제에서 만약 grade 속성의 속성값을 명시하지 않으면, 기본값으로 ‘F’가 자동 설정된다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/DTD-DTD-ed7474a75e92499aa4210865a1e7a610
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dtd_attributeDeclaration](http://www.tcpschool.com/xml/xml_dtd_attributeDeclaration)
