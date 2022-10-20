### 노드의 생성

생성할 노드의 종류에 따라 다음과 같은 메소드를 사용할 수 있다.

1. createElement()
2. createAttribute()
3. createTextNode()

---

### 요소 노드의 생성

createElement 메소드를 사용하여 새로운 요소 노드를 만들 수 있다. 

다음 예제는 새로운 paradigm 요소 노드를 생성하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;                           // 요청한 데이터를 XML DOM 객체로 반환함.
firstLang = xmlObj.getElementsByTagName("language")[0]; // 첫 번째 <language>요소를 반환함.
newNode = xmlObj.createElement("paradigm");             // 새로운 <paradigm>요소 노드를 생성함.
firstLang.appendChild(newNode);                         // 첫 번째 <language>요소에 새로운 요소를 추가함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_04)

---

### 속성 노드의 생성

createAttribute 메소드를 사용하여 새로운 속성 노드를 만들 수 있다. 만약 같은 이름의 속성 노드가 이미 존재하면 기존의 속성 노드는 새로운 속성 노드로 대체된다. 이미 존재하는 요소 노드에 속성 노드를 생성하고자 할 때에는 setAttribute 메소드를 사용할 수 있다.

다음 예제는 새로운 anotherVersion 속성 노드를 생성하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;                               // 요청한 데이터를 XML DOM 객체로 반환함.
versionElement = xmlObj.getElementsByTagName("version")[3]; // 네 번째 <version>요소를 반환함.
newAttrNode = xmlObj.createAttribute("anotherVersion");     // 새로운 anotherVersion 속성 노드를 생성함.
newAttrNode.nodeValue = "2.7.12";             // 새로운 속성 노드에 속성값을 설정함.
versionElement.setAttributeNode(newAttrNode); // 네 번째 <version>요소에 새로운 속성 노드를 추가함.

document.getElementById("text").innerHTML =
"another version : " + versionElement.getAttribute("anotherVersion");
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_05](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_05)

---

### 텍스트 노드의 생성

createTextNode 메소드를 사용하여 새로운 텍스트 노드를 만들 수 있다.

다음 예제는 paradigm 요소 노드에 새롭게 생성한 텍스트 노드를 추가하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;                           // 요청한 데이터를 XML DOM 객체로 반환함.
thirdLang = xmlObj.getElementsByTagName("language")[2]; // 세 번째 <language>요소를 반환함.
newNode = xmlObj.createElement("paradigm");             // 새로운 <paradigm>요소를 생성함.
newTextNode = xmlObj.createTextNode("객체 지향");       // 새로운 텍스트 노드를 생성함.
newNode.appendChild(newTextNode);                       // <paradigm>요소에 텍스트 노드를 추가함.
thirdLang.appendChild(newNode);                         // 세 번째 <language>요소에 새로운 요소를 추가함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_06](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_06)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-_-baf69e611f2241418bbe4102fa51f862
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeManage](http://www.tcpschool.com/xml/xml_dom_nodeManage)
