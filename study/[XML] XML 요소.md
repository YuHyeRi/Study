# [XML] XML 요소

**XML 문서 구조**

XML 문서는 크게 XML 프롤로그 부분과 XML 요소 부분으로 나눌 수 있다. 
XML 요소 부분은 하나 이상의 XML 요소로 구성된다.

---

**XML 요소**

XML 요소란 XML 문서를 구성하는 하나의 구성 요소로 정의할 수 있다. 
각각의 XML 요소는 하나 이상의 다른 요소를 포함할 수 있다. 
또한 텍스트, 속성, 미디어 객체나 경우에 따라 이들 전부를 포함할 수도 있다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<school>
    <lecture category="application">
        <java>Java</java>
        <cpp>Cpp</cpp>
    </lecture>
    <lecture category="web">
        <php>PHP</php>
        <asp>ASP</asp>
    </lecture>
</school>
```

위의 예제에서 <java>, <cpp>, <php>, <asp> 요소는 각각 자신만의 텍스트를 가진다. 
<school> 요소와 <lecture> 요소는 다른 요소들을 포함한다. 
또한, <lecture> 요소는 category라는 속성을 가진다.

---

**XML 요소 문법**

XML 요소란 시작 태그부터 종료 태그까지의 모든 것을 가리킨다.
XML 요소는 다음과 같은 문법을 사용하여 정의할 수 있다.

```xml
<요소이름 속성1="속성값" 속성2="속성값"... > 내용 </요소이름>
```

또한, 어떠한 내용도 가지지 않는 빈요소는 다음과 같이 정의할 수 있다.

빈 요소는 자신만의 내용을 가지지는 않지만, 요소에 대한 데이터를 저장할 수 있는 속성을 가질 수는 있다.

```xml
<요소이름 속성1="속성값" 속성2="속성값"... />
```

---

**XML 요소 이름의 작성 규칙**

1. XML 요소의 이름은 영문자, 숫자, 하이픈(-), 언더스코어(_, underscore), 점(.)만을 사용한다.
2. XML 요소의 이름은 영문자의 대소문자를 구분한다.
3. 반드시 영문자나 언더스코어(_)로 시작해야 하며, 공백을 포함할 수 없다.
4. 예약어인 xml, XML, Xml 등은 요소의 이름으로 사용할 수 없다.
5. 시작 태그의 이름과 종료 태그의 이름은 반드시 대소문자까지 동일해야 한다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XML-2a54422b7feb4e9299e16c429f93aefa
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_basic_element](http://www.tcpschool.com/xml/xml_basic_element)
