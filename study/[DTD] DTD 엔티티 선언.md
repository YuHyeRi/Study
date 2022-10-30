# [**DTD] DTD 엔티티 선언**

**DTD 엔티티(entity)**

DTD에서 엔티티는 특정 문자열을 손쉽게 사용할 수 있도록 해주는 상용구와 같은 역할을 한다.
엔티티의 이름과 확장할 문자열을 미리 정의해 놓으면, XML 문서나 DTD에서 사용되는 엔티티의
이름은 모두 미리 정의한 문자열로 대체된다.

---

**엔티티의 종류**

DTD에서 엔티티는 일반 엔티티와 파라미터 엔티티로 구분된다.
이 두 엔티티의 차이점은 바로 엔티티가 확장되는 곳이 어디인가 하는 점이다.

일반 엔티티는 XML 문서에서만 확장될 수 있으며, 파싱되거나 파싱되지 않을 수도 있다.
파라미터 엔티티느느 DTD 내부에서만 확장될 수 있으며, 반드시 파싱된다.

---

**XML 엔티티**

XML에서 미리 예약된 엔티티는 다음과 같다.

1. &lt;

2. &gt;

3. &amp;

4. &quot;

5. &apos;

위와 같은 다섯 개의 엔티티를 제외한 모든 엔티티는 반드시 사용하기 전에 DTD에서 선언해야 한다.

---

**내부 엔티티 선언**

DTD에서 엔티티는 XML 문서나 DTD 내부에 선언할 수도 있으며 파일 외부에 선언할 수도 있다.
XML 문서나 DTD 내부에 선언되는 내부 엔티티는 다음과 같은 문법으로 선언할 수 있다.

<aside>
💡 <!ENTITY 엔티티이름 "엔티티값">

</aside>

이렇게 선언된 내부 엔티티는 XML 문서에서 AND기호(&) + 엔티티 이름 + 세미콜론(;)의 형식으로 사용한다.

<aside>
💡 <!ENTITY css "Cascading Style Sheets">

</aside>

<aside>
💡 <lecture>**&css;** </lecture> // <lecture>Cascading Style Sheets<lecture>

</aside>

---

**외부 엔티티 선언**

외부에 파일 형태로 선언되는 외부 엔티티는 다른 DTD 문서에서 재사용할 수 있다.
문서 외부에 존재하는 외부 엔티티는 다음과 같이 SYSTEM 키워드를 사용하여 선언할 수 있다.

<aside>
💡 <!ENTITY 엔티티이름 SYSTEM "URI또는URL">

</aside>

이렇게 선언된 외부 엔티티는 XML 문서에서 AND기호(&) + 엔티티 이름 + 세미콜론(;)의 형식으로
사용한다.

<aside>
💡 <!ENTITY html SYSTEM "[http://codingsam.com/xml/html.dtd](http://codingsam.com/xml/html.dtd)">

</aside>

<aside>
💡 <lecture>**&html;**</lecture> // <lecture>HyperText Markup Language<lecture>

</aside>

---

**파라미터 엔티티의 선언**

DTD 문서에서만 사용하기 위해 선언한 엔티티를 파라미터 엔티티라고 한다.
DTD 내부에 선언되는 파라미터 엔티티는 다음과 같은 문법으로 선언할 수 있다.

<aside>
💡 <!ENTITY %엔티티이름 "엔티티값">

</aside>

파라미터 엔티티는 엔티티 이름 앞에 퍼센트(%) 기호가 들어가는 것을 제외하면,
일반 엔티티와 같은 방법으로 사용된다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/DTD-DTD-f825b03546e645c58b3cc71d8b132e95
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dtd_entityDeclaration](http://www.tcpschool.com/xml/xml_dtd_entityDeclaration)
