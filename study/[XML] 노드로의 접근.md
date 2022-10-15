# [XML] 노드로의 접근

### 노드로의 접근

XML DOM을 이용하면 노드 트리에 포함된 모든 노드에 접근할 수 있다. 
이 때 노드에 접근하는 방법에는 다음과 같은 방법들이 있다.

1. getElementsByTagName 메소드를 이용하는 방법
2. 노드 트리를 연속적으로 탐색하여 접근하는 방법
3. 노드 간의 관계를 이용하여 접근하는 방법

---

### getElementsByTagName 메소드를 이용하는 방법

getElementsByTagName 메소드는 특정 태그 이름을 가지는 모든 요소를 노드 리스트의 형태로 
반환한다. 따라서 이 메소드가 반환하는 노드 리스트를 이용하면 원하는 노드에 접근할 수 있다. 

getElementsByTagName 메소드를 사용하는 문법은 다음과 같다.

```jsx
노드이름.getElementsByTagName("태그이름")
```

---

### 노드 트리를 연속적으로 탐색하여 접근하는 방법

노드 트리 전체를 연속적으로 탐색하여 원하는 노드에 접근할 수도 있다.

```jsx
xmlObj = xmlHttp.responseXML;                 // 요청한 데이터를 XML DOM 객체로 반환함.
nodeList = xmlObj.documentElement.childNodes; // XML 문서 노드의 자식 노드를 반환함.
result = "XML 문서 노드의 자식 요소 노드<br>";

for(idx = 0; idx < nodeList.length; idx++) {
    if(nodeList[idx].nodeType == 1) {         // 요소 노드만을 출력함.
        result += nodeList[idx].nodeName + "<br>";
    }
}

document.getElementById("text").innerHTML = result;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeAccess_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeAccess_01)

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

<aside>
💡 nodeType 프로퍼티는 해당 노드의 타입을 저장하는 프로퍼티로, 수정할 수 없는 읽기 전용 프로퍼티이다.

</aside>

---

### 노드 간의 관계를 이용하여 접근하는 방법

XML DOM에서 노드 간의 관계는 다음과 같은 속성들로 정의된다.

1. parentNode : 부모 노드
2. childNodes : 자식 노드 리스트
3. firstChild : 첫 번째 자식 노드
4. lastChild : 마지막 자식 노드
5. nextSibling : 다음 형제 노드
6. previousSibling : 이전 형제 노드

위와 같은 속성들을 이용하여 원하는 노드에 손쉽게 접근할 수 있다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.
firstLang = xmlObj.getElementsByTagName("language")[0]; // 첫 번째 <language>요소를 반환함.
node = firstLang.firstChild;  // 첫 번째 <language>요소의 첫 번째 자식 노드를 반환함.
result = "language 요소의 모든 자식 요소 노드<br>";

for(idx = 0; idx < firstLang.childNodes.length; idx++) {
    if(node.nodeType == 1) {  // 요소 노드만을 출력함.
        result += node.nodeName + "<br>";
    }

    node = node.nextSibling;  // 현재 노드의 바로 다음 형제 노드를 반환함.
}

document.getElementById("text").innerHTML = result;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeAccess_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeAccess_02)

---

### 빈 텍스트 노드의 처리

현재 대부분의 주요 웹 브라우저는 모두 W3C DOM 모델을 지원하지만 그 처리 방식에 있어 
약간씩의 차이가 있다. 그중에서도 가장 큰 차이점은 띄어쓰기와 줄 바꿈을 처리하는 방식이다. 

파이어폭스나 기타 브라우저들은 띄어쓰기나 줄 바꿈을 텍스트 노드로 취급한다. 
그러나 익스플로러는 띄어쓰기나 줄 바꿈을 텍스트 노드로 취급하지 않는다. 

따라서 자식 노드나 형제 노드를 이용하여 원하는 노드에 접근하려고 하면 브라우저 간에 차이가 
발생하게 된다. 

이 차이를 없애는 가장 손쉬운 방법은 nodeType 프로퍼티를 사용하여 선택된 요소의 타입을 
검사하는 것이다.

다음 예제는 특정 노드의 맨 마지막 자식 요소 노드에 접근하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;            // 요청한 데이터를 XML DOM 객체로 반환함.
documentNode = xmlObj.documentElement;   // XML 문서 노드를 반환함.
lastNode = documentNode.lastChild;       // XML 문서 노드의 마지막 자식 노드를 반환함.

if(lastNode.nodeType != 1) {             // 마지막 자식 노드가 요소 노드가 아니면,
    lastNode = lastNode.previousSibling; // 현재 마지막 노드의 바로 앞 노드를 반환함.
}

document.getElementById("text").innerHTML = "XML 문서 노드의 맨 마지막 자식 요소 노드는 " +
lastNode.childNodes[1].firstChild.nodeValue + "입니다.";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeAccess_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeAccess_03)

위의 예제에서 마지막 자식 노드를 찾은 후에 찾은 노드의 타입이 요소 노드가 아니면 그 앞의 
노드를 다시 검사한다. 
이 방식을 사용하면 모든 브라우저에서 마지막 자식 노드로 같은 요소 노드를 선택할 수 있게 된다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-3a4b911516be4c2698da9c9ad7e5bcce
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeAccess](http://www.tcpschool.com/xml/xml_dom_nodeAccess)
