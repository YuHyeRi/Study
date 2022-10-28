# [**DTD] DTD 요소 선언**

**요소의 선언**

DTD에서 요소는 다음과 같이 ELEMENT 구문으로 선언할 수 있다.

<aside>
💡 <!ELEMENT 요소이름 요소카테고리>

또는

<!ELEMENT 요소이름 (요소내용)>

</aside>

---

**빈 요소의 선언**

콘텐츠를 가지지 않는 빈 요소(empty element)는 요소 카테고리를 EMPTY로 설정하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 EMPTY>

</aside>

<aside>
💡 <!ELEMENT line EMPTY>

</aside>

위의 예제에서 line요소는 어떠한 콘텐츠도 가지지 않는 빈 요소가 된다.

---

**하나의 자식 요소만을 가지는 요소의 선언**

DTD에서 요소를 선언할 때에는 자식 요소를 명시할 수 있다. 
하나의 자식 요소만을 가지는 요소는 자식 요소의 이름을 괄호 안에 명시하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 (자식요소이름)>

</aside>

<aside>
💡 <!ELEMENT parent (child)>

</aside>

위의 예제에서 parent 요소는 단 하나의 child 요소만을 자식 요소로 가진다.

---

**여러 자식 요소를 가지는 요소의 선언**

DTD에서 요소를 선언할 때에는 둘 이상의 자식 요소를 명시할 수 있다.
자식 요소를 여러 개 가지는 요소는 자식 요소의 이름을 모두 괄호(())안에 명시하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 (자식요소이름1, 자식요소이름2, ...)>

</aside>

<aside>
💡 <!ELEMENT body (head, body, arm, leg)>

</aside>

위의 예제에서 body 요소는 자식 요소로 head, body, arm, leg 요소를 가진다.

---

**최소한 하나 이상의 자식 요소를 가지는 요소의 선언**

DTD에서 요소를 선언할 때에는 자식 요소가 최소한 하나 이상임을 명시할 수 있다. 
이러한 요소는 자식 요소의 이름 바로 뒤에 플러스(+) 기호를 사용하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 (자식요소이름+)>

</aside>

<aside>
💡 <!ELEMENT parent (children+)>

</aside>

위의 예제에서 parent 요소는 하나 이상의 children 요소를 자식 요소로 가질 수 있다.

---

**자식 요소를 가질 수도 있고, 가지지 않을 수도 있는 요소의 선언**

DTD에서 요소를 선언할 때에는 자식 요소를 가질 수도, 가지지 않을 수도 있게 명시할 수 있다.
이러한 요소는 자식 요소의 이름 바로 뒤에 별(*) 기호를 사용하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 (자식요소이름*)>

</aside>

<aside>
💡 <!ELEMENT parent (children*)>

</aside>

위의 에제에서 parent 요소는 childern 요소를 자식 요소로 가질 수도 있고, 가지지 않을 수도 있다.

---

**자식 요소를 가지지 않거나, 단 하나의 자식 요소만을 가지는 요소의 선언**

DTD에서 요소를 선언할 때에는 자식 요소를 가지지 않거나, 
단 하나의 자식 요소만을 가지도록 명시할 수 있다.
이러한 요소는 자식 요소의 이름 바로 뒤에 물음표(?) 기호를 사용하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 (자식요소이름?)>

</aside>

<aside>
💡 <!ELEMENT parent (children?)>

</aside>

위의 예제에서 parent 요소는 자식 요소로 children 요소를 가지지 않거나, 
만약 가진다면 단 하나만 가질 수 있다.

---

**자식 요소를 선택적으로 가지는 요소의 선언**

DTD에서 요소를 선언할 때에는 자식 요소를 선택적으로 가지도록 명시할 수 있다.
이러한 요소는 선택적으로 가질 자식 요소의 이름을 모두 괄호(())안에 명시하고, 
| 기호를 이용해 구분하여 선언한다.

<aside>
💡 <!ELEMENT 요소이름 (자식요소이름1, ..., (자식요소이름2|자식요소이름3|...))>

</aside>

<aside>
💡 <!ELEMENT parent (brother, (boy|girl))>

</aside>

위의 예제에서 parent 요소는 자식 요소로 brother 요소는 단 하나만 가진다.
그러나 boy 요소와 girl 요소는 둘 중 하나만을 자식 요소로 가질 수 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/DTD-DTD-828bfe2ad89f47beaaf21d0e63e4d7bb
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dtd_elementDeclaration](http://www.tcpschool.com/xml/xml_dtd_elementDeclaration)
