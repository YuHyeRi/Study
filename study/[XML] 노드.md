# [XML] 노드

### 노드(node)

W3C XML DOM 표준에 따르면 XML 문서 내의 모든 것은 노드(node)라고 불리는 계층적 단위에 
정보를 담고 있다. XML DOM은 이러한 노드들을 정의하고 그들 사이의 관계를 설명해주는 역할을 한다.

---

### 노드의 종류

W3C XML DOM 표준에 따르면 XML 문서 내에 존재하는 모든 것은 노드이다. 
XML 문서를 구성하는 대표적인 노드의 종류는 다음과 같다.

- 문서 노드(document node) : XML 문서 전체를 나타내는 노드
- 요소 노드(element node) : 모든 XML 요소는 모두 요소 노드이며, 속성 노드를 가질 수 있는 
유일한 노드
- 속성 노드(attribute node) : XML 요소의 속성은 모두 속성 노드이며, 요소 노드에 관한 정보를 
가지고 있는 노드. 그러나 속성 노드는 해당 요소 노드의 자식 노드(child node)에 포함되지는 
않음
- 텍스트 노드(text node) : XML 문서 내의 텍스트는 모두 텍스트 노드
- 주석 노드(comment node) : XML 문서 내의 주석은 모두 주석 노드

---

### **노드 트리(node tree)**

XML 문서의 정보는 노드 트리라고 불리는 계층적 구조에 저장된다. 
이러한 노드 트리는 노드들의 집합으로 노드 간의 관계를 나타낸다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<programming_languages>
    <language>
        <name>CSS</name>
        <category>web</category>
        <developer>W3C</developer>
        <version status="stable">3.0</version>
        <priority rating="3">high</priority>
    </language>
</programming_languages>
```

다음 그림은 위의 XML 파일을 노드 트리로 표현한 그림이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a6b1c86e-21df-4f1e-ab59-cc33a846df62/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221014%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221014T050307Z&X-Amz-Expires=86400&X-Amz-Signature=4364decd403a31cac7aaa258b5409614c1e24bf4cbbe66ccb28e28bf69307a66&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

노드 트리는 최상위 레벨인 루트 노드(root node)로부터 시작하여 가장 낮은 레벨인 텍스트 노드
까지 뻗어내려간다. XML DOM을 이용하면 노드 트리에 포함된 모든 노드에 접근할 수 있다.

---

### 노드 간의 관계

노드 트리의 모든 노드들은 서로 계층적 관계를 맺고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/667c7d57-ee01-4afd-b280-2d17d92198f0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221014%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221014T050325Z&X-Amz-Expires=86400&X-Amz-Signature=de7dc3ae1637a643782e49107ca09a9e9e00e7a1601e5b3b4d1174b2c89a5b27&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

노드 트리의 최상위에는 단 하나의 루트 노드만이 존재한다.

루트 노드를 제외한 모든 노드는 단 하나의 부모 노드를 가진다. 
모든 요소 노드는 자식 노드를 가질 수 있다.

형제 노드란 같은 부모 노드를 가지는 모든 노드를 가리킨다. 
조상 노드란 부모 노드를 포함해 계층적으로 현재 노드보다 상위에 존재하는 모든 노드를 가리킨다. 자손 노드란 자식 노드를 포함해 계층적으로 현재 노드보다 하위에 존재하는 모든 노드를 가리킨다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-4bb103a084e34173a18014762cc47aeb
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_node](http://www.tcpschool.com/xml/xml_dom_node)
