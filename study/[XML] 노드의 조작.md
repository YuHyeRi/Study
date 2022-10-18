# [XML] 노드의 조작

### 노드의 값 확인

nodeValue 프로퍼티를 사용하면 특정 노드의 값을 확인할 수 있다. 
또한 getAttribute 메소드는 속성 노드의 속성값을 반환해준다. 
getAttributeNode 메소드는 특정 노드에 포함된 속성 노드 그 자체를 반환해준다.

다음 예제는 첫 번째 <priority> 요소 노드의 첫 번째 자식 노드의 값을 확인하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.
// 첫 번째 <priority>요소의 첫 번째 자식 노드를 반환함.
targetNode = xmlObj.getElementsByTagName("priority")[0].firstChild;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_01)

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

### 노드의 값 변경

nodeValue 프로퍼티를 사용하면 특정 노드의 값을 변경할 수 있다. 
또한 setAttribute 메소드는 속성 노드의 속성값을 변경할 수 있게 해준다.

---

### 요소 노드의 텍스트

요소 노드는 자신이 직접 텍스트 값을 가지지는 않는다. 
요소 노드의 텍스트는 요소 노드의 자식 노드인 텍스트 노드에 저장된다. 

따라서 요소 노드의 텍스트 값을 확인하거나 변경하고자 할 때는 요소 노드에 포함된 텍스트 노드에 접근해야 한다.

---

### 텍스트 노드의 값 변경

nodeValue 프로퍼티를 사용하여 텍스트 노드의 값을 변경할 수 있다.

다음 예제는 첫 번째 <priority> 요소 노드의 첫 번째 자식 노드의 값을 ‘low’로 변경하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.
// 첫 번째 <priority>요소의 첫 번째 자식 노드를 반환함.
targetNode = xmlObj.getElementsByTagName("priority")[0].firstChild;
targetNode.nodeValue = "low"; // nodeValue 속성을 이용하여 텍스트 노드의 값을 변경함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_02)

---

### 속성 노드의 값 변경

nodeValue 프로퍼티 뿐만 아니라 setAttribute 메소드를 사용하면 속성 노드의 값을 변경할 수 있다. setAttribute 메소드는 속성값을 변경하려는 속성이 존재하지 않으면 먼저 해당 속성을 생성한 후에 속성값을 설정한다.

다음 예제는 세 번째 name 요소 노드의 ‘korean’ 속성값을 ‘자바스크립트’로 변경하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.
targetNode = xmlObj.getElementsByTagName("name")[2]; // 세 번째 <name>요소를 반환함.
// 해당 요소에 "korean" 속성의 속성값을 "자바스크립트"로 변경함.
targetNode.setAttribute("korean", "자바스크립트");
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_03)

---

### 노드의 교체

replaceChild 메소드를 사용하면 특정 노드 그자체를 다른 노드로 바꿀 수 있다.

---

### 요소 노드의 교체

replaceChild 메소드를 사용하면 기존의 요소 노드를 새로운 요소 노드로 교체할 수 있다. 
replaceChild 메소드의 원형은 다음과 같다.

```jsx
부모노드.replaceChild(새로운자식노드, 기존자식노드);
```

1. 새로운 자식 노드 : 자식 노드 리스트에 새롭게 추가할 요소 노드를 전달한다.
2. 기존 자식 노드 : 자식 노드 리스트에서 제거할 요소 노드를 전달한다.

다음 예제는 첫 번째 name 요소 노드를 제거하고, 세 번째 name 요소 노드를 첫 번째 name 요소 
노드의 자리로 옮기는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;
nameList = xmlObj.getElementsByTagName("name"); // 모든 <name>요소를 선택함.
parentNode = nameList[0].parentNode;            // 첫 번째 <name>요소의 부모 요소를 선택함.
// 세 번째 <name>요소를 첫 번째 <name>요소 자리에 교체함.
parentNode.replaceChild(nameList[2], nameList[0]);
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_04)

다음 그림은 위 예제의 동작으르 순서대로 나타낸 그림이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6d4798e1-2dca-4f26-9403-65b1281306d5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221018%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221018T010158Z&X-Amz-Expires=86400&X-Amz-Signature=202d8ac989f509a899fb7ccde716cafbc40ec81aebd200d3f5adcf89c36fb6b6&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

### 텍스트 노드의 데이터 대체

replaceData 메소드를 사용하면 텍스트 노드의 텍스트 데이터를 바꿀 수 있다. 

replaceData 메소드의 원형은 다음과 같다.

```jsx
텍스트노드.replaceData(오프셋, 교체할문자수, 새로운데이터);
```

1. 오프셋(offset) : 오프셋 값은 0부터 시작하며, 기존 텍스트 데이터의 몇 번째 문자부터 교체할지를 전달합니다.
2. 교체할 문자 수 : 기존 텍스트 노드의 데이터로부터 교체할 총 문자 수를 전달합니다.
3. 새로운 데이터 : 새로이 삽입할 텍스트 데이터를 전달합니다.

다음 예제는 세 번째 name 요소 노드의 텍스트 노드의 데이터에서 두 번째 문자부터 세 글자를 ‘Query’로 대체하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.
// 세 번째 <name>요소의 텍스트 노드를 반환함.
javaName = xmlObj.getElementsByTagName("name")[2].firstChild;
// 텍스트 데이터의 두 번째 문자부터 세 글자를 "Query"로 대체함.
javaName.replaceData(1, 3, "Query");
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeHandle_05)

replaceData 메소드 뿐만 아니라 nodeValue 프로퍼티를 이용해도 텍스트 노드의 데이터를 대체할 수 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-9d409b9904e84b70aa76a82dbc31bfc4
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeHandle](http://www.tcpschool.com/xml/xml_dom_nodeHandle)
