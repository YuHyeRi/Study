# [**XSD 단순 타입] XSD 속성**

**XSD 속성(attribute) @**

XSD에서 단순 타입 요소는 속성을 가질 수 없다.
만약 단순 타입의 요소가 속성을 가지게 되면, 그 요소는 복합 타입(complex type)이 된다.
하지만 속성 그 자체는 언제나 단순 타입으로 선언된다.

---

**속성의 선언**

XSD에서 속성을 선언하는 문법은 다음과 같다.

```xml
<xs:attribute name="속성이름" type="속성타입"/>
```

속성의 타입에는 XSD에서 제공하는 다양한 기본 타입과 파생된 타입을 사용할 수 있다.

다음 예제는 속성을 XSD에서 어떻게 선언하는지를 보여주는 예제이다.

*XML 예제*

```xml
<priority rating="3">middle</priority>
```

*XSD 예제*

```xml
<xs:attribute name="rating" type="xs:integer"/>
```

---

**속성의 기본값 선언**

요소와 마찬가지로 속성도 dafault 속성을 이용하여 기본값을 명시할 수 있다.
이렇게 명시된 기본값은 값이 명시되지 않는 경우에 자동으로 설정된다.

다음 예제에서 division 속성값이 직접 명시되지 않으면 기본값인 man으로 자동 설정된다.

*XSD 예제*

```xml
<xs:attribute name="division" type="xs:string" default="man"/>
```

---

**속성의 고정값 선언**

요소와 마찬가지로 속성도 fixed 속성을 사용하여 고정값을 명시할 수 있다.
이렇게 고정값을 명시하면 자동으로 그 값이 부여되며, 사용자가 임의로 값을 변경할 수 없게 된다.

다음 예제에서 division 속성값은 무조건 woman으로 설정된다.

*XSD 예제*

```xml
<xs:attribute name="division" type="xs:string" fixed="woman"/>
```

---

**필수 속성의 선언**

속성은 기본적으로 필수가 아니다. 
그러나 use 속성값을 required로 설정하면 해당 속성을 필수 속성으로 선언할 수 있다.

이렇게 선언된 필수 속성은 요소의 선언 시 반드시 같이 선언되어야 한다.
만약 요소의 선언 시 필수 속성이 함께 선언되지 않으면, 해당 XML 문서는 유효하지 않은 문서로 간주한다.

다음 예제에서 division 속성은 반드시 선언되어야만 한다.

*XSD 예제*

```xml
<xs:attribute name="division" type="xs:string" use="required"/>
```

<aside>
💡 use 속성값을 prohibited으로 설정하면 해당 속성이 존재하지 않아야만 해당 XML 문서가 유효한 문서로 간주한다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-XSD-bd279d02cd8d47fdb5d5fac8e99a9a18
<br>
 👉 노션 : [http://www.tcpschool.com/xml/xml_xsd_attribute](http://www.tcpschool.com/xml/xml_xsd_attribute)
