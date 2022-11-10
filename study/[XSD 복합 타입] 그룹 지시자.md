# [**XSD 복합 타입**] 그룹 지시자

**그룹 지시자**

그룹 지시자는 요소들 간의 연관성을 명시할 때 사용한다.

1. group
2. attributeGroup

---

**group 지시자**

group 지시자는 연관된 요소들을 하나의 그룹으로 묶어준다.
순서 지시자(sequence, all, choice)는 반드시 group 지시자 내부에 명시되어야 한다. 
이렇게 정의된 그룹은 ref 속성에 해당 그룹의 name 속성값을 사용하면 참조할 수 있다.

다음 예제는 bodyInfo라는 그룹을 선언한 후, physical요소를 선언할 때 해당 그룹을 참조하는 
예제이다.

*XSD 예제*

```xml
<xs:group name="bodyInfo">
    <xs:sequence>
        <xs:element name="height" type="xs:integer"/>
        <xs:element name="waist" type="xs:integer"/>
    </xs:sequence>
</xs:group>

<xs:element name="physical">
    <xs:complexType>
        <xs:sequence>
            <xs:group ref="bodyInfo"/>
            <xs:element name="footsize" type="xs:string"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
```

---

**attributeGroup 지시자**

attributeGroup 지시자는 연관된 속성들을 하나의 속성 그룹으로 묶어준다.
이렇게 정의된 속성 그룹은 ref 속성에 해당 그룹의 name 속성값을 사용하면 참조할 수 있다.

다음 예제는 personInfo 라는 속성 그룹을 선언한 후, person 요소를 선언할 때 해당 속성 그룹을 
참조하는 예제이다.

*XSD 예제*

```xml
<xs:attributeGroup name="personInfo">
    <xs:attribute name="gender" type="xs:string"/>
    <xs:attribute name="age" type="xs:string"/>
</xs:attributeGroup>

<xs:element name="person">
    <xs:complexType>
        <xs:attributeGroup ref="personInfo"/>
    </xs:complexType>
</xs:element>
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-117251fb61fe4aea840a601329c2a668
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_groupIndicator](http://www.tcpschool.com/xml/xml_xsd_groupIndicator)
