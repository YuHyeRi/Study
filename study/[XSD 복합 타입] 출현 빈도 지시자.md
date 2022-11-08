# [**XSD 복합 타입**] 출현 빈도 지시자

**출현 빈도 지시자**

출현 빈도 지시자는 해당 요소를 자식 요소로 얼마나 가질 수 있는지를 정의할 때 사용한다.
모든 순서 지시자나 그룹 지시자에서 출현 빈도 지시자의 기본값은 모두 1이다.

1. maxOccurs
2. minOccurs

---

**maxOccurs 지시자**

maxOccurs 지시자는 해당 요소를 자식 요소로 가질 수 있는 최댓값을 명시한다.

다음 예제의 customer요소는 자식 요소로 phoneNumber요소를 최소 1개에서 
최대 2개까지 가질 수 있다.

*xsd04.xsd*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xs:element name="customer">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="age" type="xs:integer"/>
            <xs:element name="phoneNumber" type="xs:integer" maxOccurs="2"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>

</xs:schema>
```

다음 예제는 위에서 작성한 xsd04.xsd에 적합한 XML 문서이다.

*xsd04_good.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<customer>
    <name>홍길동</name>
    <age>15</age>
    <phoneNumber>0212345678</phoneNumber>
    <phoneNumber>01023456789</phoneNumber>
</customer>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence01](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence01)

다음 예제는 위에서 작성한 xsd04.xsd에 적합하지 않은 XML 문서이다.

*xsd04_bad.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<customer>
    <name>홍길동</name>
    <age>15</age>
    <phoneNumber>0212345678</phoneNumber>
    <phoneNumber>03123456789</phoneNumber>
    <phoneNumber>01023456789</phoneNumber>
</customer>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence02](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence02)

위의 예제는 xsd04.xsd에서 정의한 대로 자식 요소로 phoneNumber요소를 최대 2개까지만 
가질 수 있는데, 3개를 가지므로 부적합하다.

---

**minOccurs 지시자**

minOccurs 지시자는 해당 요소를 자식 요소로 가질 수 있는 최솟값을 명시한다.

다음 예제의 customer요소는 자식 요소로 phoneNumber요소를 최소 2개부터 최대 3개까지 가질 수 있다.

*xsd05.xsd*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xs:element name="customer">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="age" type="xs:integer"/>
            <xs:element name="phoneNumber" type="xs:integer" minOccurs="2" maxOccurs="3"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>

</xs:schema>
```

다음 예제는 위에서 작성한 xsd05.xsd에 적합한 XML 문서이다.

*xsd05_good.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<customer>
    <name>홍길동</name>
    <age>15</age>
    <phoneNumber>0212345678</phoneNumber>
    <phoneNumber>01023456789</phoneNumber>
</customer>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence03](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence03)

다음 예제는 위에서 작성한 xsd05.xsd에 적합하지 않은 XML 문서이다.

*xsd05_bad.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<customer>
    <name>홍길동</name>
    <age>15</age>
    <phoneNumber>0212345678</phoneNumber>
</customer>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence04](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence04)

위의 예제는 xsd05.xsd에서 정의한 대로 자식 요소로 phoneNumber요소를 최소 2개 이상 가져야 
하는데, 1개만 가지므로 부적합하다.

---

**출현 빈도 제한 해제**

출현 빈도 지시자인 maxOccurs 지시자와 minOccurs 지시자의 기본값은 1이다.
즉, 출현 빈도 지시자를 따로 명시하지 않고 생략하면 해당 요소를 반드시 1번만 가져야 한다.
이 때 해당 요소를 자식 요소로 가질 수 있는 횟수에 제한을 두고 싶지 않으면 출현 빈도 지시자의 
값을 unbounded로 설정하면 된다.

다음 예제의 customer요소는 자식 요소로 phoneNumber요소를 최소 1개에서 최대 몇 개까지고 
가질 수 있다.

*xsd06.xsd*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xs:element name="customer">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="age" type="xs:integer"/>
            <xs:element name="phoneNumber" type="xs:integer" maxOccurs="unbounded"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>

</xs:schema>
```

다음 예제는 위에서 작성한 xsd06.xsd에 적합한 XML 문서이다.

*xsd06_good.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<customer>
    <name>홍길동</name>
    <age>15</age>
    <phoneNumber>0212345678</phoneNumber>
    <phoneNumber>03123456789</phoneNumber>
    <phoneNumber>01023456789</phoneNumber>
</customer>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence05](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence05)

다음 예제는 위에서 작성한 xsd06.xsd에 적합하지 않은 XML 문서이다.

*xsd06_bad.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<customer>
    <name>홍길동</name>
    <age>15</age>
</customer>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence06](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOccurrence06)

위의 예제는 xsd06.xsd에서 정의한 대로 자식 요소로 <phoneNumber>요소를 최소 1개부터 몇 개
까지고 가질 수 있지만, 1개도 가지지 않으므로 부적합하다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-b999b4c8a15e4d3884ab6969f3fee0b2
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_occurrenceIndicator](http://www.tcpschool.com/xml/xml_xsd_occurrenceIndicator)
