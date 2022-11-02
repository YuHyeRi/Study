# [**XSD 단순 타입] 단순 타입 요소**

**단순 타입(simple type) 요소**

XSD에서 요소는 오직 값만을 포함할 수 있는 단순 타입 요소로 선언된다. 
단순 타입의 요소는 자식 요소나 속성을 포함할 수 없다. 
여기서 값만을 포함한다는 의미는 오직 숫자나 불리언, 문자열만을 포함할 수 있는 요소라는 뜻이다.

---

**단순 타입 요소의 선언**

XSD에서 단순 타입 요소를 선언하는 문법은 다음과 같다.

```xml
<xs:element name="요소이름" type="요소타입"/>
```

요소 타입에서는 XSD에서 제공하는 다양한 기본 타입과 파생된 타입을 사용할 수 있다.

다음 예제는 단순 타입 요소를 XSD에서 어떻게 선언하는지를 보여주는 예제이다.

*XML 예제*

```xml
<player>홍길동</player>
<rank>24</rank>
<goal>13:15:00</goal>
```

*XSD 예제*

```xml
<xs:element name="player" type="xs:string"/> // 문자열 타입
<xs:element name="rank" type="xs:integer"/>  // 숫자 타입
<xs:element name="goal" type="xs:time"/>     // 시간 타입
```

---

**단순 타입 요소의 기본값 선언**

단순 타입 요소는 default 속성을 이용하여 기본값을 명시할 수 있다.
이렇게 명시된 기본값은 값이 명시되지 않는 경우에 자동으로 설정된다.

다음 예제에서 grade 요소의 값이 직접 명시되지 않으면, 기본값인 ‘D’로 자동 설정된다.

*XSD 예제*

```xml
<xs:element name="grade" type="xs:string" default="D"/>
```

---

**단순 타입 요소의 고정값 선언**

단순 타입 요소는 fixed 속성을 이용하여 고정값을 명시할 수 있다.
이렇게 고정값을 명시하면 자동으로 그 값이 부여되며, 사용자가 임의로 값을 변경할 수 없게 된다.

다음 예제에서 grade 요소의 값은 무조건 ‘A’로 설정된다.

*XSD 예제*

```xml
<xs:element name="grade" type="xs:string" fixed="A"/>
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-afc188dfdc074f5da23f3825c7c9c1d7
<br>
 👉 노션 : [http://www.tcpschool.com/xml/xml_xsd_simpleType](http://www.tcpschool.com/xml/xml_xsd_simpleType)
