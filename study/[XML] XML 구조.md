
**XML 트리**

XML 문서는 HTML 문서와 마찬가지로 트리(tree) 형태의 계층 구조를 가진다.

이러한 XML 트리는 하나뿐인 루트(root) 요소부터 시작하여 각각의 자식(child) 요소에 차례대로 
연결된다. XML 트리 구조에 포함되는 모든 요소는 자신만의 자식(child) 요소를 가질 수 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/59da0736-0403-490b-b528-9e1e93bf0a67/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220930%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220930T052343Z&X-Amz-Expires=86400&X-Amz-Signature=d35dd1ca9a97ff15ff26b55f7a1f3df537b189d26315da596893728690337220&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

위 그림에서 화살표로 설명하는 용어들은 요소 간의 관계를 나타낸다.

부모(parent) 요소는 여러 개의 자식(child) 요소를 가질 수 있다. 
그러나 자식(child) 요소는 단 하나의 부모(parent) 요소만을 가진다.

형제(sibling) 요소는 같은 트리 레벨(tree level)에 존재하는 요소를 가리킨다. 
즉, 형제 요소란 같은 부모(parent) 요소를 가지는 자식 요소 간의 관계를 나타낸다.

조상(ancestor) 요소란 부모 요소를 포함해 계층적으로 현재 요소보다 상위에 존재하는 모든 요소를 가리킨다. 자손(descendant) 요소란 자식 요소를 포함해 계층적으로 현재 요소보다 하위에 존재하는 모든 요소를 가리킨다.

XML 트리의 모든 요소는 자신만의 텍스트나 속성을 가질 수 있다.

---

**XML 문서 구조**

기본적인 XML 문서는 다음과 같이 구성된다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<shop city="서울" type="마트">
    <food>
        <name>귤</name>
        <sort>과일</sort>
        <cost>3000</cost>
    </food>
    <food>
        <name>상추</name>
        <sort>야채</sort>
        <cost>2000</cost>
    </food>
</shop>
```

XML 문서는 맨 첫줄에 <xml> 태그를 사용하여 XML 문서임을 명시해야 한다.
👉 <?xml version="1.0" encoding="UTF-8"?>

그 다음에는 XML 문서에 단 하나만이 존재하는 루트(root) 요소를 생성한다.
이 루트 요소는 XML 문서에 존재하는 모든 요소의 조상(ancestor) 요소가 된다.

👉 <shop city="서울" type="마트">

위의 예제에서 루트 요소는 자식(child) 요소로 두 개의 <food> 요소를 가진다.

👉 <shop city="서울" type="마트">

  <food>…</food>
  <food>…</food>

</shop>

첫 번째 <food>요소는 <name>요소, <sort>요소, <cost>요소의 총 세 개의 자식 요소를 가진다.

위와 같이 또 하나의 <food>요소를 생성하고 XML 문서가 끝난다.

위에서 살펴본 XML 문서는 상점에서 판매하는 식품에 관한 정보를 담고 있는 문서임을 명확하게 알 수 있다. 
이처럼 XML 문서에서 요소의 이름은 저장하고 있는 데이터의 내용을 명확히 알려준다. 
따라서 요소의 이름만으로도 데이터의 내용을 짐작할 수 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XML-b32905b0a9794ed3a18052ca8fec9842
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_basic_structure](http://www.tcpschool.com/xml/xml_basic_structure)
