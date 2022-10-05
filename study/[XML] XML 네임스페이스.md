# [XML] XML 네임스페이스

**XML 네임스페이스**

XML 네임스페이스는 XML 요소 간의 이름에 대한 충돌을 방지해주는 방법을 제공한다. 
XML 네임스페이스는 요소의 이름과 속성의 이름을 하나의 그룹으로 묶어주어 
이름에 대한 충돌을 해결한다.

이러한 XML 네임스페이스는 URI (Uniform Resource Identifiers)로 식별된다.

---

**XML 요소 간의 이름 충돌**

XML에서는 사용자가 XML 요소의 이름을 직접 정의한다. 
따라서 서로 다른 XML 문서를 통합하려고 할 때 같은 이름을 가진 요소로 인해 충돌이 발생할 수 
있다.

예제1

```xml
<body>
    <h1>html에서의 제목</h1>
    <p>html에서의 단락</p>
</body>
```

예제2

```xml
<body>
    <arm>70</arm>
    <leg>110</leg>
</body>
```

위의 두 예제에서 <body>요소는 서로 완전히 다른 의미로 사용된다. 

예제1에서는 HTML문서의 <body> 태그로 사용되었다.
예제 2에서는 실제 몸을 의미하며, 각 신체 부위의 치수를 기록하기 위해 사용되었다.

그러나 사용자나 XML 응용 프로그램은 두 <body> 요소의 이러한 차이점을 어떻게 다뤄야 하는지 알지 못한다.

---

**XML 네임스페이스의 선언**

XML 에서는 접두사(prefix)를 이용하여 위와 같은 이름의 충돌을 방지하고 있다. 
서로 같은 이름에 요소마다 서로 다른 접두사를 붙이면 이름의 충돌을 방지할 수 있게 된다.

XML에서 이러한 접두사를 사용하려면, 반드시 먼저 접두사에 대한 네임스페이스를 선언해야 한다.

XML에서 네임스페이스를 선언하는 문법은 다음과 같다.

```xml
<요소이름 xmlns:prefix="URI">
```

XML 네임스페이스의 선언은 xmlns나 xmlns:로 시작한다. 
prefix 속성값에는 이름 앞에 붙게 되는 네임스페이스 접두사를 명시한다. 
접두사로 사용되는 URI는 네임스페이스 식별자를 의미한다.

```xml
<root>
    <a:body xmlns:a="https://www.w3.org/TR/html5/">
        <a:h1>html에서의 제목</a:h1>
        <a:p>html에서의 단락</a:p>
    </a:body>
    <b:body xmlns:b="http://codingsam.com/xml/physical/">
        <b:arm>70</b:arm>
        <b:leg>110</b:leg>
    </b:body>
</root>
```

위의 예제에서 첫 번째 <body> 요소의 xmlns 속성은 a:라는 접두사를 선언한다. 
두 번째 <body> 요소의 xmlns 속성은 b:라는 접두사를 선언한다.

이렇게 XML 요소에 네임스페이스가 선언되면, 해당 요소의 모든 자식요소에도 같은 네임스페이스가 선언된다. 이러한 네임스페이스 선언은 XML 루트요소에서도 선언할 수 있다.

```xml
<root
    xmlns:a="https://www.w3.org/TR/html5/"
    xmlns:b="http://codingsam.com/xml/physical/">
    <a:body>
        <a:h1>html에서의 제목</a:h1>
        <a:p>html에서의 단락</a:p>
    </a:body>
    <b:body>
        <b:arm>70</b:arm>
        <b:leg>110</b:leg>
    </b:body>
</root>
```

---

**URI (Uniform Resource Identifier)**

URI란 통합 자원 식별자를 의미하며, 인터넷에 있는 자원을 나타내주는 유일한 주소를 의미한다.
URI의 존재는 인터넷에서 요구되는 기본조건으로서 인터넷 프로토콜에도 항상 명시된다.
가장 잘 알려진 URI로는 인터넷 도메인 주소를 나타내는 URL (Uniform Resource Locator)이다.
또 다른 URI로는 URN(Universal Resource Name)이 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XML-6c1bce595a164268a3872a1b57d3f4fc
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_basic_namespace](http://www.tcpschool.com/xml/xml_basic_namespace)
