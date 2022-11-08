# [**XSD 복합 타입**] 순서 지시자

**XSD 지시자(indicator)**

XSD 지시자를 사용하면 XML 문서에서 요소들이 구성되는 방식을 설정할 수 있다.
XSD에서 사용할 수 있는 지시자는 다음과 같다.

1. 순서 지시자 : sequence, all, choice
2. 출현 빈도 지시자 : maxOccurs, minOccurs
3. 그룹 지시자 : group, attributeGroup

---

**순서 지시자**

순서 지시자는 요소들이 나타나는 순서를 정의할 때 사용한다.
XSD에서 사용할 수 있는 순서 지시자는 다음과 같다.

1. sequence
2. all
3. choice

---

**sequence 지시자**

sequence 지시자는 자식 요소가 명시된 순서대로만 나타날 수 있다는 것을 명시한다.
다음 XSD 예제의 physical요소는 자식 요소를 height요소와 waist요소 순으로 가져야만 한다.

*xsd01.xsd*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
 
<xs:element name="physical">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="height" type="xs:integer"/>
            <xs:element name="waist" type="xs:integer"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>

</xs:schema>
```

다음 예제는 위에서 작성한 xsd01.xsd에 적합한 XML 문서이다.

*xsd01_good.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<physical>
    <height>180</height>
    <waist>72</waist>
</physical>
```

다음 예제는 위에서 작성한 xsd01.xsd에 적합하지 않은 XML 문서이다.

*xsd01_bad.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<physical>
    <height>180</height>
    <footsize>275</footsize>
</physical>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder02](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder02)

위 예제의 결과 화면을 살펴보면 다음과 같은 메시지를 확인할 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b2ae7ff2-afdd-4235-a194-beec42521f25/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221108%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221108T015738Z&X-Amz-Expires=86400&X-Amz-Signature=601583272eb348042a5be175bcb290150d25b89ee01db705a1cb7c26c9746543&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

즉 xsd01.xsd에서 정의한 대로 두 번째 자식 요소로 waist요소를 가지지 않고, 
대신 footsize요소를 가지므로 부적합하다.

---

**all 지시자**

all 지시자는 자식 요소가 어떤 순서로 나오든지 단 한 번씩만 나올 수 있다는 것을 명시한다. 
따라서 all 지시자를 사용할 때는 출현 빈도 지시자인 minOccurs 지시자는 0 또는 1, 
maxOccurs 지시자는 1로만 명시할 수 있다.

다음 XSD 예제의 physical요소는 height요소와 waist요소를 순서에 상관없이 하나씩만 자식 요소로 가질 수 있다.

*xsd02.xsd*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xs:element name="physical">
    <xs:complexType>
        <xs:all>
            <xs:element name="height" type="xs:integer"/>
            <xs:element name="waist" type="xs:integer"/>
        </xs:all>
    </xs:complexType>
</xs:element>

</xs:schema>
```

다음 예제는 위에서 작성한 xsd02.xsd에 적합한 XML 문서이다.

*xsd02_good.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<physical>
    <waist>72</waist>
    <height>180</height>
</physical>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder03](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder03)

위의 예제처럼 all 지시자는 명시된 자식 요소가 등장하는 순서에 상관없이 단 한 번씩만 가질 수 
있다.

다음 예제는 위에서 작성한 xsd02.xsd에 적합하지 않은 XML 문서이다.

*xsd02_bad.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<physical>
    <height>180</height>
    <height>185</height>
</physical>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder04](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder04)

위의 예제는 xsd02.xsd에서 정의한 대로 자식 요소로 height요소와 waist요소를 하나씩 가지지 않고, height요소만을 두 번 가지므로 부적합하다.

---

**choice 지시자**

choice 지시자는 복합 타입 요소가 포함할 수 있는 자식 요소의 선택 집합을 명시한다. 
복합 타입 요소는 이렇게 선언된 선택 집합 내에서 단 하나의 자식 요소만을 가질 수 있다. 
단, 선택 집합은 다른 선택 집합이나 다른 시퀀스 안에 포함될 수 있다.

다음 예제의 physical요소는 height요소와 waist요소 둘 중 하나만을 자식 요소로 가질 수 있다.

*xsd03.xsd*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xs:element name="physical">
    <xs:complexType>
        <xs:choice>
            <xs:element name="height" type="xs:integer"/>
            <xs:element name="waist" type="xs:integer"/>
        </xs:choice>
    </xs:complexType>
</xs:element>

</xs:schema>
```

다음 예제는 위에서 작성한 xsd03.xsd에 적합한 XML 문서이다.

*xsd03_good.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<physical>
    <height>180</height>
</physical>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder05](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder05)

위의 예제처럼 choice 지시자는 명시된 자식 요소 중에서 단 하나만을 자식 요소로 가져야 한다. 
다음 예제는 위에서 작성한 xsd03.xsd에 적합하지 않은 XML 문서이다.

*xsd03_bad.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<physical>
    <height>180</height>
    <waist>72</waist>
</physical>
```

[http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder06](http://www.tcpschool.com/examples/tryit/tryJava.php?filename=XsdOrder06)

위의 예제는 xsd03.xsd에서 정의한 대로 자식 요소로 height요소와 waist요소 중 단 하나만을 
가지지 않고, height요소와 waist요소를 모두 가지므로 부적합하다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-52fdd6c2b604435cbba2dbe823b99e58
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_orderIndicator](http://www.tcpschool.com/xml/xml_xsd_orderIndicator)
