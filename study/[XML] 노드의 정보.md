# [XML] 노드의 정보

### 노드에 대한 정보

노드에 대한 정보에는 다음과 같은 프로퍼티를 사용하여 접근할 수 있다.

1. nodeType
2. nodeName
3. nodeValue

이 프로퍼티들은 특별히 다른 인터페이스를 사용하지 않고도 해당 노드 정보에 직접 접근할 수 있는 방법을 제공해준다.

다음 그림은 우리 수업에서 계속 사용하고 있는 XML 파일에서 각 노드 타입의 프로퍼티 값을 
보여주는 예제 그림이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/957f080d-a00e-47e6-81e7-de7944c9d234/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221017%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221017T032357Z&X-Amz-Expires=86400&X-Amz-Signature=ba745818506d7f2e274fc09823e003db61ffd09fbc44f2782bcf688590f3eed1&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

### nodeType 프로퍼티

nodeType  프로퍼티는 해당 노드의 타입을 저장하는 프로퍼티로 수정할 수 없는 읽기 전용 프로퍼티이다. 대표적인 XML 노드별 nodeType 프로퍼티 값은 다음과 같다.

| 노드 타임 | nodeType 프로터피 값 |
| --- | --- |
| 요소 노드(element node) | 1 |
| 속성 노드(attribute node) | 2 |
| 텍스트 노드(text node) | 3 |
| 주석 노드(comment node) | 8 |
| 문서 노드(document node) | 9 |

다음 예제는 XML 문서 노드의 타입을 출력하는 예제이다.

```jsx
var xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.

document.getElementById("text").innerHTML = // XML 문서 노드의 타입을 반환함.
"XML 문서 노드의 타입은 " + xmlObj.nodeType + "입니다.";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeInfo_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeInfo_01)

이번 수업의 예제에서 사용되는 programming_languages.xml 파일의 코드는 다음과 같다.

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

---

### **nodeName 프로퍼티**

nodeName 프로퍼티는 해당 노드의 이름을 저장하는 프로퍼티로 수정할 수 없는 읽기 전용 
프로퍼티이다.

| 노드 타입 | nodeName 프로퍼티 값 |
| --- | --- |
| 문서 노드(document node) | #document |
| 요소 노드(element node) | 해당 태그 이름 |
| 속성 노드(attribute node) | 해당 속성 이름 |
| 텍스트 노드(text node) | #text |

다음 예제는 XML 문서 노드의 자식 노드 중 첫 번째 요소 노드의 이름을 출력하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.

// XML 문서 노드의 첫 번째 요소 노드를 반환함.
firstElementNode = xmlObj.documentElement.childNodes[1];

// 해당 노드의 첫 번째 요소 노드의 이름을 반환함.
document.getElementById("text").innerHTML =
"첫 번째 요소 노드의 이름은 " + firstElementNode.childNodes[1].nodeName + "입니다.";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeInfo_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeInfo_02)

---

### **nodeValue 프로퍼티**

nodeValue 프로퍼티는 해당 노드의 값을 저장한다.

| 노드 타입 | nodeValue 프로퍼티 값 |
| --- | --- |
| 요소 노드(element node) | undefined |
| 속성 노드(attribute node) | 해당 속성의 속성값 |
| 텍스트 노드(text node) | 해당 텍스트 문자열 |

다음 예제는 XML 문서 노드의 자식 노드 중 첫 번째 요소 노드의 텍스트 노드의 값을 출력하는 
예제이다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.

// XML 문서 노드의 첫 번째 요소 노드를 반환함.
firstElementNode = xmlObj.documentElement.childNodes[1];

// 해당 노드의 첫 번째 요소 노드의 텍스트 노드의 값을 반환함.
document.getElementById("text").innerHTML = "첫 번째 요소 노드의 텍스트 노드값은 " +
firstElementNode.childNodes[1].firstChild.nodeValue + "입니다.";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeInfo_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeInfo_03)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-9a894f72367f4dd9b0063c353dd30a99
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeInfo](http://www.tcpschool.com/xml/xml_dom_nodeInfo)
