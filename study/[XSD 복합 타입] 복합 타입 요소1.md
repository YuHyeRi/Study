# [**XSD 복합 타입**] **복합 타입 요소1**

**복합 타입(complex type) 요소**

복합 타입 요소란 자식 요소나 속성을 포함하는 요소를 의미한다.
XSD에서 복합 타입 요소는 다음과 같이 구분할 수 있다.

1. 빈 요소
2. 자식 요소만을 포함하는 요소
3. 텍스트만을 포함하는 요소
4. 자식 요소와 텍스트를 모두 포함하는 요소

위에서 언급한 모든 복합 타입 요소는 속성을 포함할 수 있다.

---

**빈 요소의 선언**

XSD에서 빈 요소란 자식 요소는 가지지 않고, 오직 속성만을 가지는 요소를 의미한다. 
빈 요소는 복합 타입 요소이므로 반드시 하나 이상의 속성을 가지고 있어야 한다.

*XML 예제*

```xml
<red redValue="139" />
```

위의 XML 예제는 XSD에서 아래처럼 선언된다.

*XSD 예제*

```xml
<xs:element name="red">
    <xs:complexType>
        <xs:complexContent>
            <xs:restriction base="xs:integer">
                <xs:attribute name="redValue" type="xs:positiveInteger"/>
            </xs:restriction>
        </xs:complexContent>
    </xs:complexType>
</xs:element>
```

하지만 보통은 xs:complexContent요소와 xs:restriction 요소는 생략하고 다음과 같이 정의한다.

*XSD 예제*

```xml
<xs:element name="red">
    <xs:complexType>
        <xs:attribute name="redValue" type="xs:positiveInteger"/>
    </xs:complexType>
</xs:element>
```

<aside>
💡 XSD에서 속성(attribute)은 자식 요소나 또 다른 속성을 포함할 수 없으므로, 언제나 단순 타입(simple type)이다.

</aside>

---

**자식 요소만을 포함하는 요소**

XSD에서 가장 일반적으로 정의되는 요소 중의 하나가 바로 자식 요소만을 포함하는 요소이다.

*XML 예제*

```xml
<physical>
    <height>180</height>
    <waist>32</waist>
</physical>
```

위의 XML예제는 XSD에서 아래처럼 선언된다.

*XSD 예제*

```xml
<xs:element name="physical">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="height" type="xs:integer"/>
            <xs:element name="waist" type="xs:integer"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
```

위의 예제에서 sequence 지시자는 body 타입의 요소는 height 요소와 waist 요소 순으로 자식 요소를 가져야 한다.

<aside>
💡 sequence 지시자는 자식 요소가 명시된 순서대로만 나타날 수 있다는 것을 명시하는 지시자이다.

</aside>

---

**텍스트만을 포함하는 요소**

XSD에서 텍스트만을 포함하는 요소는 simpleContent 요소를 사용하여 선언한다.
이 때 simpleContent 요소 안에는 extension요소나 restriction 요소 중 하나가 반드시 선언되어야 한다. 그래야만 simpleContent 요소를 사용하여 기초가 되는 단순 타입 요소를 확장하거나 제한할 수 있기 때문이다.

*XML 예제*

```xml
<currency country="kor">10000</currency>
```

위의 XML 예제는 XSD에서 아래처럼 선언된다.

*XSD 예제*

```xml
<xs:element name="currency">
    <xs:complexType>
        <xs:simpleContent>
            <xs:extension base="xs:integer">
                <xs:attribute name="country" type="xs:string" />
            </xs:extension>
        </xs:simpleContent>
    </xs:complexType>
</xs:element>
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-1-e87bfe1c8cee45999f3da899d59ffbf7
<br>
 👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_complexType](http://www.tcpschool.com/xml/xml_xsd_complexType)
