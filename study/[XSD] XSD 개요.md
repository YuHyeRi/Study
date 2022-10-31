# [XSD] XSD 개요

**XSD란?**

XSD는 XML 스키마 정의(XML Schema Definition)를 의미한다. 
XSD는 XML 문서의 구조 및 해당 문서가 포함할 수 있는 적법한 요소와 속성을 명시한다. 

즉, 해당 XML 문서가 유효한 XML 문서로써 포함할 수 있는 관계를 정의한다.

XML에서 스키마를 정의할 때는 XSD 뿐만 아니라 앞서 배운 DTD를 사용할 수도 있다.

---

**DTD의 단점**

DTD는 오래전부터 엔티티를 정의할 수 있고, 빠른 개발을 위한 내부 DTD를 사용할 수 있어서 
많이 사용되었다. 그러나 시간이 지날수록 다음과 같은 단점들이 발생한다.

1. 네임스페이스를 지원하지 않는다.
2. XML 문법이 아닌 별도의 문법으로 작성해야 한다.
3. 제한된 타입만을 지원한다.
4. 재사용과 확장이 불가능하다.

위와 같은 단점 때문에 2001년 W3C에서는 새로운 스키마 언어인 XSD를 공표한다.

---

**XSD의 특징**

DTD의 단점을 개선한 XSD는 다음과 같은 특징을 가진다.

1. 네임스페이스를 지원한다.
2. XML 문법으로 작성할 수 있어 재사용과 확장이 쉽다.
3. 정수, 문자열 등의 다양한 타입을 지원한다.

---

**XSD 문법**

모든 XSD 문서의 루트 요소는 <schema> 요소이다.

schema 요소를 이요한 XML 스키마의 선언은 다음과 같은 문법을 따른다.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
    targetNamespace="http://codingsam.com"
    xmlns="http://codingsam.com"
    elementFormDefault="qualified">
...
</xs:schema>
```

xmlns:xs 속성은 XSD의 요소와 타입에 사용할 W3C의 XML 스키마 네임스페이스를 명시한다. targetNamespace 속성은 요소를 정의할 XML 스키마 네임스페이스를 명시한다. 
xmlns 속성은 기본 XML 스키마 네임스페이스를 명시한다.
elementFormDefault 속성은 해당 스키마를 이용해 선언한 XML 문서의 모든 요소가 네임스페이스를 만족한다는 것을 명시한다.

---

**XSD 예제**

다음 예제는 간단한 XML 파일 예제이다.

*food.xml*

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<food>
	<name>상추</name>
	<type>야채</type>
	<cost>2000</cost>
</food>
```

다음 예제는 앞선 XML 문서의 요소들을 정의한 DTD 파일 예제이다.

*food.dtd*

```xml
<!ELEMENT food (name,type,cost)>
<!ELEMENT name (#PCDATA)>
<!ELEMENT type (#PCDATA)>
<!ELEMENT cost (#PCDATA)>
```

다음 예제는 앞선 XML 문서의 요소들을 정의한 XSD 파일 예제이다.

*food.xsd*

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
    targetNamespace="http://codingsam.com"
    xmlns="http://codingsam.com"
    elementFormDefault="qualified">

<xs:element name="food">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="type" type="xs:string"/
            <xs:element name="cost" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
</xs:schema>
```

다음 예제는 외부 DTD 파일을 포함하는 XML 파일 예제이다.

*food.xml*

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE food SYSTEM "food.dtd">
<food>
    <name>상추</name>
    <type>야채</type>
    <cost>2000</cost>
</food>
```

다음 예제는 외부 XSD 파일을 포함하는 XML 파일 예제이다.

*food.xml*

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<food
xmlns="http://codingsam.com"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://codingsam.com food.xsd">
    <name>상추</name>
    <type>야채</type>
    <cost>2000</cost>
</food>
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-XSD-64413cdd5bd149c88c5e74ca0b45095f
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_intro](http://www.tcpschool.com/xml/xml_xsd_intro)
