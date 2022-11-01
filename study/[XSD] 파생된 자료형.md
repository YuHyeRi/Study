# [XSD] 파생된 자료형

**파생된 타입(derived datatype)**

파생된 타입이란 기본 타입으로부터 파생되어 생성된 타입을 의미한다. 
파생된 타입을 사용할 때에는 기본 타입과 마찬가지로 반드시 네임스페이스 접두사를 붙어야 한다.

*XSD 예제*

```xml
<xs:element name="player" type="xs:normalizedString"/>
```

---

**정규화된 문자열(normalizedString)**

정규화된 문자열 타입은 기본 타입인 문자열 타입으로부터 파생된 타입이다.
이 타입은 기본 타입인 문자열 타입과 같이 문자를 포함할 수 있다. 
하지만 XML 프로세서가 줄 바꿈 문자, 개행 복귀 문자, 탭 문자를 제거할 것이다.

*XSD 예제*

```xml
<xs:element name="student" type="xs:normalizedString"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<student>홍        길   동    </student>
```

위의 예제에서 XML 프로세서는 탭 문자를 하나의 띄어쓰기로 대체할 것이다.

---

**토큰(token)**

토큰 타입은 기본 타입인 문자열 타입으로부터 파생된 타입이다.
이 타입은 기본 타입인 문자열 타입과 같이 문자를 포함할 수 있다. 
하지만 XML 프로세서가 줄 바꿈 문자, 개행 복귀 문자, 탭 문자, 문자열 앞뒤의 공백, 여러 개의 
띄어쓰기를 모두 제거할 것이다.

*XSD 예제*

```xml
<xs:element name="student" type="xs:token"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<student>홍        길   동    </student>
```

위의 예제에서 XML 프로세서는 탭 문자와 문자열 앞뒤의 공백, 그리고 여러 개의 띄어쓰기를 모두 제거할 것이다.

---

**정수(integer)**

정수 타입은 기본 타입인 소수(decimal) 타입으로부터 파생된 타입이다. 
정수 타입은 소수 부분이 없는 정수를 나타낼 때 사용한다.

*XSD 예제*

```xml
<xs:element name="answer" type="xs:integer"/>
```

위의 XSD 예제에서 정의한 요소는 XML 문서에서 다음과 같이 표현될 수 있다.

*XML 예제*

```xml
<answer>12</answer>
<answer>+12345</answer>
<answer>-123</answer>
```

---

**XSD 파생된 타입**

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a9634465-56d5-4d42-b71c-aaab9a99b978/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221101%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221101T233759Z&X-Amz-Expires=86400&X-Amz-Signature=97313b8849b4fbaedd265d97ffd7667704484481cc2935b40ce3ec25ec8ebae8&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/663cd7d4-ef39-4deb-99ba-037a543fe778/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221101%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221101T233814Z&X-Amz-Expires=86400&X-Amz-Signature=e7d0ef4099a9b0819463407138e5039bd729d2267554f83bc862a60ae9428f78&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XSD-c54c61171c95424d8cac1c7d014daaf5
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xsd_derivedDatatype](http://www.tcpschool.com/xml/xml_xsd_derivedDatatype)
