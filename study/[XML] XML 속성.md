# [XML] XML 속성

**XML 속성**

XML 속성은 XML 요소에 대한 추가적인 정보를 제공해주며, 해당 요소의 특징을 정의한다.
XML 속성은 다음과 같은 문법을 사용하여 정의할 수 있다.

```xml
<요소이름 속성1="속성값" 속성2="속성값"... >
```

XML 요소의 속성은 속성명=”속성값”의 형태로 정의된다. 
여기에서 속성값은 반드시 따옴표로 둘러싸여야 한다.

---

**요소와 속성의 차이점**

예제1

```xml
<student>
    <name>홍길동</name>
    <year>3</year>
    <major>컴퓨터공학</major>
</student>
```

예제2

```xml
<student name="홍길동">
    <year>3</year>
    <major>컴퓨터공학</major>
</student>
```

위의 두 예제에서 이름(name)이라는 데이터를 하나는 XML 요소로, 하나는 XML 속성으로 표현하고 있다. 

결과적으로 이 두 예제는 완전히 같은 정보를 제공한다. 
정보의 전달이라는 측면에서 보면 XML 요소로 표현하는 방법과, XML 속성으로 표현하는 방법에 
큰 차이는 없다.

그러나 속성은 여러 개의 값을 가질 수 없으며, 요소처럼 손쉽게 확장할 수 없다는 단점을 가진다. 
또한 속성은 XML 트리에 포함되지 않기 때문에 다양한 용도로 활용할 수가 없다.

---

**XML 속성 이름의 작성 규칙**

1. XML 속성의 이름은 하나의 요소 내에서 중복되어서는 안된다.
2. 속성값은 반드시 따옴표로 둘러싸여야 하며, 작은 따옴표와 큰 따옴표의 차이는 없다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XML-80fecee5c0854c6a90118f02dd7138b2
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_basic_attribute](http://www.tcpschool.com/xml/xml_basic_attribute)
