# [XML] 노드 리스트

### **노드 리스트(node list)**

노드 리스트는 getElementsByTagName 메소드나 childNodes 속성의 속성값으로 반환되는 객체
이다. 이 객체는 XML 문서와 같은 순서대로 문서 내의 모든 노드를 리스트 형태로 저장하고 있다. 
노드 리스트의 각 노드는 배열처럼 0부터 시작하는 인덱스를 이용하여 접근할 수 있다. 

다음 그림은 programming_languages.xml 파일을 노드 리스트로 나타낸 그림이다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<programming_languages>
    <language>
        <name>HTML</name>
        <category>web</category>
        <developer>W3C</developer>
        <version status="working draft">5.1</version>
        <priority rating="1">high</priority>
    </language>

    <language>
        <name>CSS</name>
        <category>web</category>
        <developer>W3C</developer>
        <version status="stable">3.0</version>
        <priority rating="3">middle</priority>
    </language>

    <language>
        <name korean="자바">Java</name>
        <category>application</category>
        <developer>Oracle</developer>
        <version status="stable">8.91</version>
        <priority rating="2">high</priority>
    </language>

    <language>
        <name korean="파이썬">Python</name>
        <category>application</category>
        <developer>Python</developer>
        <version status="stable">3.52</version>
        <priority rating="4">middle</priority>
    </language>
</programming_languages>
```

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b78b409c-3553-4e31-b36c-21755a748705/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221016%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221016T030755Z&X-Amz-Expires=86400&X-Amz-Signature=05b33622b9c191f2f092332218f08a4718ab45d971257ae06df25c6e06ea6e67&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

다음 예제는 XML 문서 노드의 자식 노드를 노드 리스트 객체로 반환하는 예제이다.

```jsx
nodeList = xmlObj.documentElement.childNodes;
```

---

### 노드 리스트의 길이

노드 리스트 객체는 노드 리스트에 노드를 추가하거나 삭제하면 자신의 상태 정보를 스스로 갱신
한다. 따라서 이 객체의 length 속성값은 언제나 노드 리스트가 저장하고 있는 노드들의 총 개수를 
나타낸다.

다음 예제는 XML 문서 노드의 자식 노드의 개수를 반환하는 예제이다.

```jsx
nodeNum = xmlObj.documentElement.childNodes.length;
```

---

### 속성 리스트

요소 노드의 attributes 속성은 해당 요소 노드가 가지고 있는 모든 속성 노드를 리스트 형태로 반환한다. 이것으르 속성 리스트(named node map) 객체라고 한다.

속성 리스트 객체도 노드 리스트 객체와 마찬가지로 자신의 상태 정보를 스스로 갱신한다. 
하지만 속성 리스트 객체는 노드 리스트 객체와는 달리 인덱스로는 접근할 수 없는 순서 없는 리스트(unordered list)의 형태를 가진다. 

따라서 자바스크립트에서는 이름만으로도 아이템을 선택할 수 있는 getNamedItem 메소드를 
별도로 제공한다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.

// 첫 번째 <version>요소의 모든 속성을 리스트 형태로 반환함.
attrList = xmlObj.getElementsByTagName("version")[0].attributes;
document.getElementById("text").innerHTML = // 속성 리스트에서 status 속성의 값을 반환함.
"첫 번째 version 요소의 status 속성값은 " + attrList.getNamedItem("status").nodeValue + "입니다.";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeList_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeList_01)

위의 예제에서 사용된 programming_languages.xml 파일의 코드는 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<programming_languages>
    <language>
        <name>HTML</name>
        <category>web</category>
        <developer>W3C</developer>
        <version status="working draft">5.1</version>
        <priority rating="1">high</priority>
    </language>

    <language>
        <name>CSS</name>
        <category>web</category>
        <developer>W3C</developer>
        <version status="stable">3.0</version>
        <priority rating="3">middle</priority>
    </language>

    <language>
        <name korean="자바">Java</name>
        <category>application</category>
        <developer>Oracle</developer>
        <version status="stable">8.91</version>
        <priority rating="2">high</priority>
    </language>

    <language>
        <name korean="파이썬">Python</name>
        <category>application</category>
        <developer>Python</developer>
        <version status="stable">3.52</version>
        <priority rating="4">middle</priority>
    </language>
</programming_languages>
```

<aside>
💡 nodeType 프로퍼티는 해당 노드의 타입을 저장하는 프로퍼티로 수정할 수 없는 읽기 전용 프로퍼티이다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-52495f71d297451da7a21d1c62bc5874
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeList](http://www.tcpschool.com/xml/xml_dom_nodeList)
