# [**DTD] XML 문서의 구성 요소**

**XML 문서의 구성 요소**

DTD에서는 모든 XML 문서가 다음과 같은 구성 요소로 이루어져 있다고 본다.

1. 요소 (elements)
2. 속성 (attributes)
3. 엔티티 (entities)
4. PCDATA
5. CDATA

---

**요소(elements)**

DTD에서 요소란 XML 문서를 구성하는 가장 중요한 구성 요소이다. 
DTD에서 요소는 다음과 같이 ELEMENT 구문으로 선언할 수 있다.

<aside>
💡 <!ELEMENT 요소이름 요소카테고리>

또는

<!ELEMENT 요소이름 (요소내용)>

</aside>

---

**속성(attributes)**

DTD에서 속성은 요소에 대한 추가적인 정보를 제공하며 해당 요소의 특징을 정의한다.
DTD에서 속성은 다음과 같이 ATTLIST 구문으로 선언할 수 있다.

<aside>
💡 <!ATTLIST 요소이름 속성이름 속성타입 속성값>

</aside>

---

**엔티티(entities)**

XML에서는 예약되어 있는 다섯 개의 특별한 기호가 있다. 
이렇게 예약되어 있는 기호를 XML 문서에서 사용하면 XML 파서는 그것을 전혀 다른 의미로 해석
한다. 따라서 이렇게 예약된 기호를 기존에 사용하던 의미 그대로 사용하기 위해서 만든 문자를 
엔티티라고 한다.
DTD에서 내부 엔티티는 다음과 같이 ENTITY 구문으로 선언할 수 있다.

<aside>
💡 <!ENTITY 엔티티이름 "엔티티값">

</aside>

또한 문서 외부에 존재하는 외부 엔티티는 다음과 같이 SYSTEM 키워드를 사용하여 선언할 수 있다.

<aside>
💡 <!ENTITY 엔티티이름 SYSTEM "URI또는URL">

</aside>

---

**PCDATA**

PCDATA(Parsed Character DATA)란 XML 파서에 의해 분석될 문자 데이터를 의미한다.
간단히 말해 XML 요소의 시작 태그와 종료 태그 사이에 위치한 텍스트를 PCDATA라고 생각하면 
된다. PCDATA는 XML 파서가 엔티티와 마크업으로 나누어 분석한다. 
이렇게 XML 파서에 의해 분석될 문자 데이터만을 가지는 요소는 요소의 내용을 #PCDATA로 명시
하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 (#PCDATA)>

</aside>

---

**CDATA**

CDATA(Character DATA)란 XML 파서가 분석하지 않는 문자 데이터를 의미한다.
DTD에서 요소의 콘텐츠에서는 PCDATA만이 올 수 있으며 속성의 속성값으로는 CDATA만이 올 수 
있다.

<aside>
💡 <!ATTLIST 요소이름 속성이름 CDATA 속성값>

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/DTD-XML-7c90fef31f1e48f391f5d5643ab7c358
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dtd_component](http://www.tcpschool.com/xml/xml_dtd_component)
