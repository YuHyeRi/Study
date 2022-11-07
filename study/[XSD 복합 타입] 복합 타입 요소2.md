# [**XSD 복합 타입**] **복합 타입 요소2**

**자식 요소와 텍스트를 모두 포함하는 요소**

XSD에서는 자식 요소, 속성 그리고 텍스트까지 모두 포함한 복합 타입 요소를 선언할 수 있다.

*XML 예제*

```xml
<student>
    학생의 이름은 <name>홍길동</name>이고,
    성별은 <gender>남자</gender>이며,
    나이는 <age>15</age>살 입니다.
</student>
```

위의 XML 예제는 XSD에서 아래처럼 선언된다.

*XSD 예제*

```xml
<xs:element name="student">
    <xs:complexType mixed="true">
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="gender" type="xs:string"/>
            <xs:element name="age" type="xs:positiveInteger"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
```

<aside>
💡 위의 XML 예제에서 자식 요소들 사이에 나타나는 텍스트를 표현하기 위해서는 반드시 XSD에서 mixed 속성값을 true로 설정해야 한다.

</aside>

---

**임의의 요소 및 속성 사용**

any 요소는 해당 XSD 파일에서 선언되지 않은 요소를 사용하여 XML 문서를 확장할 수 있게 해준다. 또한 anyAttriute 요소는 해당 XSD 파일에서 선언되지 않은 속성을 사용하여 XML 문서를 확장할 수 있도록 도와준다.
이러한 any 요소와 anyAttriute 요소는 XML 문서의 확장성을 더욱 좋게 만들어 준다.
다음 예제에서 student.xsd를 만족하는 student 요소는 세 번 째 요소로 어떤 요소가 나와도 되며, 
또한 세 번째 요소가 나오지 않아도 된다.

*student.xsd*

```xml
<xs:element name="student">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="gender" type="xs:string"/>
            <xs:any minOccurs="0"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
```

*address.xsd*

```xml
<xs:element name="address">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="zipcode" type="xs:integer"/>
            <xs:element name="si" type="xs:string"/>
            <xs:element name="gu" type="xs:string"/>
            <xs:element name="street" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
```

다음 XML 예제들은 모두 위에서 살펴본 student.xsd를 만족하는 XML 예제이다.

*student01.xml*

```xml
<student>
    <name>길동</name>
    <gender>남자</gender>
</student>
```

*student02.xml*

```xml
<student>
    <name>길동</name>
    <gender>남자</gender>
    <address>
        <zipcode>12345</zipcode>
        <si>서울시</si>
        <gu>강남구</gu>
        <street>테헤란로</street>
    </address>
</student>
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-2-944a06b95c0e40599483e3ef8c5a2094
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_complexType](http://www.tcpschool.com/xml/xml_xsd_complexType)
