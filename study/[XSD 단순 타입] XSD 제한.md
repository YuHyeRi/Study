# [**XSD 단순 타입] XSD 제한**

**XSD 제한 (facets)**

XSD에서 XML 요소나 속성을 선언할 때, 해당 요소나 속성이 가질 수 있는 값에 대한 범위를 제한
할 수 있다. 이렇게 기존의 타입인(simple type)을 제한함으로써 새로운 타입을 정의할 수 있다.

XSD에서는 값의 범위를 제한하기 위해 restriction 요소를 사용한다.

```xml
<restriction base="타입">
    타입에 대한 제한 사항
</resctriction>
```

base 속성은 제한 사항을 적용할 타입을 명시한다.

---

**특정 범위의 값을 가지도록 제한**

단순 타입의 요소가 특정 범위 안의 값을 가지도록 제한할 때에는 다음 제한들을 사용한다.

- maxExclusive : 특정 범위의 상한값을 명시합니다.
- maxInclusive : 특정 범위의 상한값을 명시합니다.
- minExclusive : 특정 범위의 하한값을 명시합니다.
- minInclusive : 특정 범위의 하한값을 명시합니다.

여기에서 exclusive와 inclusive의 차이는 명시한 값 까지 포함하는지 안하는지 이다.
exclusive는 명시한 값을 포함되지 않으며, inclusive는 명시한 값까지 포함이다.

다음 예제는 새로운 단순 타입 요소인 allowance 요소를 선언하는 예제이다.

```xml
<xs:element name="allowance">
    <xs:simpleType>
        <xs:restriction base="xs:integer">
            <xs:minInclusive value="0"/>
            <xs:maxInclusive value="100000"/>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```

위의 예제에서 선언된 allowance 요소에는 최소 0부터 최대 100,000까지의 값을 대입할 수 있다.

---

**특정 값 중에서 선택하도록 제한**

단순 타입 요소의 값을 특정 값 중에서 선택하도록 제한하고자 할 때는 다음 제한을 사용한다.

- enumeration :  값으로 설정할 수 있는 허용된 값들의 리스트들을 명시한다.

사용자는 요소를 선언할 때 enumeration 제한으로 나열된 값 중에서 하나만을 선택하여 대입해야 
한다. 

다음 예제는 새로운 단순 타입 요소인 unit 요소를 선언하는 예제이다.

```xml
<xs:element name="unit">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:enumeration value="원"/>
            <xs:enumeration value="달러"/>
            <xs:enumeration value="엔"/>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```

위의 예제에서 선언된 unit 요소는 원, 달러, 엔 중에서 하나의 값만을 대입할 수 있다.

---

**텍스트 데이터의 패턴 지정**

단순 타입 요소의 텍스트 데이터가 특정 패턴을 보이도록 제한할 때에는 다음 제한을 사용한다.

- pattern : 텍스트 데이터의 형식을 정규 표현식을 사용하여 명시한다.

사용자는 pattern 제한에 정규 표현식을 사용하여 허용되는 고정된 패턴을 만들 수 있다.

pattern 제한에 사용되는 대표적인 정규 표현식은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/be00ba9d-acdd-44a1-a5be-30ec127f9199/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221105%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221105T004820Z&X-Amz-Expires=86400&X-Amz-Signature=53a91e7b2acb806cff71ef559b64165c21d0624fbfcb395378d294de2cac1fcf&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

다음 예제는 새로운 단순 타입 요소인 init 요소를 선언하는 예제이다.

```xml
<xs:element name="init">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:pattern value="[a-zA-Z][a-zA-Z]"/>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```

위의 예제에서 선언된 init 요소에는 정확히 두 자리의 영문자로 이루어진 값만을 대입할 수 있다.
init 요소에 대입할 수 있는 유효한 값을 예로 들어오면 ‘ab’, ‘az’, ‘Az’, ‘bF’ 등이 있다.

다음 예제는 새로운 단순 타입 요소인 camel 요소를 선언하는 예제이다.

```xml
<xs:element name="camel">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:pattern value="([A-Z][a-z])+"/>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```

위의 예제에서 선언된 camel 요소에는 영문 대문자와 영문 소문자로 이루어진 한 쌍 이상의 텍스트만을 대입할 수 있다. 즉, camel 요소에 대입할 수 있는 유효한 값에는 ‘ad,’, ‘BcDd’, ‘ZaGdEi’ 등이 
있다.

---

**공백(whitespace)에 대한 제한**

공백 제한을 사용하면 공백을 어떤 식으로 다룰지를 명시할 수 있다.
이 제한의 value 속성값은 다음과 같은 값을 가질 수 있다.

- preserve : 어떠한 공백도 제거하지 않는다.
- replace : 모든 종류의 공백(line feeds, carriage returns, tabs, spaces)을 띄어쓰기로 모두 대체한다.
- collapse : 모든 종류의 공백은 띄어쓰기로 모두 대체되고, 문자열 앞뒤의 여백도 제거되며, 많은 수의 띄어쓰기는 하나의 띄어쓰기로 변환된다.

다음 예제는 새로운 단순 타입 요소인 white 요소를 선언하는 예제이다.

```xml
<xs:element name="white">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:whiteSpace value="replace"/>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```

위의 예제에서 선언된 white 요소에 포함된 모든 종류의 공백은 모두 띄어쓰기로 대체될 것이다.

---

**XSD 제한(facets)**

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/89cc643b-f223-48cb-bcd5-3a080ad3dbe5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221105%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221105T004802Z&X-Amz-Expires=86400&X-Amz-Signature=00f17588b3894afb5fc0322f646b4134384904fdda1a650bbab7985b7e3f6146&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-XSD-520efc7a1fd8457c876fdea66a2d8b94
<br>
 👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_facet](http://www.tcpschool.com/xml/xml_xsd_facet)
