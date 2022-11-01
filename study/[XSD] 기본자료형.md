# [XSD] 기본자료형

**XSD 타입**

XSD에서는 사용자를 위해 다양한 타입을 제공한다. 
또한, 사용자가 임의의 타입을 직접 정의하여 사용할 수도 있다.

XSD에서 기본적으로 제공하는 타입은 기본 타입과 파생된 타입으로 구분된다.

---

**기본 타입(primitive datatype)**

XSD에서 제공하는 기본 타입을 사용할 때에는 반드시 네임스페이스 선언시 사용한 접두사를 
붙여야 한다.

*XSD 예제*

```xml
<xs:element name="player" type="xs:string"/>
```

---

**문자열(string)**

문자열 타입은 문자, 줄 바꿈 문자(line feed), 개행 복귀 문자(carriage retrun), 탭 문자(tab)등을 
포함할 수 있다.

*XSD 예제*

```xml
<xs:element name="student" type="xs:string"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<student>홍길동</student>
또는
<student>홍        길   동    </student>
```

---

**날짜와 시간(dataTime)**

날짜와 시간 타입은 날짜와 시간을 동시에 표현할 수 있다.

yyyy-mm-ddThh:mm:ss

- yyyy-mm-dd : yyyy년 mm월 dd일을 나타낸다.
- T : 시간 부분이 시작됨을 알려주며, 반드시 표기해야 하는 문자이다.
- hh:mm:ss : hh시 mm분 ss초를 나타낸다.

*XSD 예제*

```xml
<xs:element name="deadline" type="xs:dateTime"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<deadline>2017-07-01T09:00:00</deadline>
```

---

**시간 간격(duration)**

시간 간격 타입은 시간 사이의 간격을 표현할 수 있다.

PnYnMnDTnHnMnS

- P : 기간을 의미하며 반드시 표기해야 하는 문자이다.
- nYnMnD : 기간을 연월일로 나타낸다.
- T : 시간 부분이 시작됨을 알려주며, 시간 부분을 나타낼 때는 반드시 표기해야 한다.
- nHnMnS : 기간을 시분초로 나타낸다.

*XSD 예제*

```xml
<xs:element name="season" type="xs:duration"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<season>P2YT10M</season> // 2년 10분
<season>PT60S</season>   // 60초
<season>-P2Y</season>    // -2년
```

---

**실수(decimal)**

실수 타입은 실수를 표현할 수 있다.

*XSD 예제*

```xml
<xs:element name="answer" type="xs:decimal"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<answer>12.5</answer>
<answer>+12345.678</answer>
<answer>-0.123</answer>
```

<aside>
💡 실수 타입이 표현할 수 있는 최대 자릿수는 18자리이다.

</aside>

---

**불리언(boolean)**

불리언 타입은 참과 거짓을 표현할 수 있다.

*XSD 예제*

```xml
<xs:attribute name="disabled" type="xs:boolean"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현할 수 있다.

*XML 예제*

```xml
<rank disabled="true">10</rank>
```

---

**anyURI**

anyURI 타입은 통합 자원 식별자(URI)를 표현할 수 있다.

*XSD 예제*

```xml
<xs:attribute name="src" type="xs:anyURI"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<image src="http://codingsam.com/xml/images/uri.png" />
```

---

**XSD 기본 타입**

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e76df173-f02a-4637-bf01-984e9fb16efe/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221101%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221101T012638Z&X-Amz-Expires=86400&X-Amz-Signature=2988fbc32b9be28a02ed71ec60736ddcca859f69f29d16c7846eeff8ee08149a&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-db9b111829354305aa117c8315fc3559
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_primitiveDatatype](http://www.tcpschool.com/xml/xml_xsd_primitiveDatatype)
