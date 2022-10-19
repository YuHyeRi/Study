### 노드의 추가

다음 메소드를 사용하면 특정 위치에 새로운 노드를 추가할 수 있다.

1. appendChild()
2. insertBefore()
3. insertData()

---

### **appendChild 메소드**

appendChild 메소드는 새로운 노드를 해당 노드의 자식 노드 리스트의 맨 마지막에 추가한다.

다음 예제는 새로운 paradigm 요소 노드를 생성하고 
생성한 요소 노드를 첫 번째 ‘language’ 요소 노드의 마지막 자식 요소 노드로 추가하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;                           // 요청한 데이터를 XML DOM 객체로 반환함.
firstLang = xmlObj.getElementsByTagName("language")[0]; // 첫 번째 <language>요소를 반환함.
newNode = xmlObj.createElement("paradigm");             // 새로운 <paradigm>요소를 생성함.
firstLang.appendChild(newNode);                         // 첫 번째 <language>요소에 새로운 요소를 추가함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_01)

위의 예제에서 createElement 메소드는 인수로 전달받은 값을 nodeName의 값으로 하는 새로운 
요소 노드를 생성한다. 따라서 createElement 메소드는 nodeType의 값이 1이며 nodeValue의 값은 undefined인 새로운 노드를 반환한다.

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

### **insertBefore 메소드**

insertBefore 메소드는 새로운 노드를 특정 자식 노드 바로 앞에 추가한다.

insertBefore 메소드의 원형은 다음과 같다.

```jsx
부모노드.insertBefore(새로운자식노드, 기준자식노드);
```

1. 새로운 자식 노드 : 자식 노드 리스트(child node list)에 새롭게 추가할 자식 노드를 전달한다.
2. 기준 자식 노드 : 새로운 노드를 삽입할 때 기준이 되는 노드로, 이 노드 바로 앞에 새로운 노드가 추가된다.

다음 예제는 새로운 요소 노드를 생성하고 그 노드를 노드 리스트의 두 번째 요소 노드 앞에 추가
하는 예제이다. 이 예제는 새로운 paradigm 요소 노드를 생성하고 생성한 요소 노드를 첫 번째 language 요소의 두번째 자식 요소 노드로 추가하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;                           // 요청한 데이터를 XML DOM 객체로 반환함.
firstLang = xmlObj.getElementsByTagName("language")[0]; // 첫 번째 <language>요소를 반환함.
newNode = xmlObj.createElement("paradigm");             // 새로운 <paradigm>요소 노드를 생성함.
// 자식 노드 중 두 번째 요소 노드 앞에 새로운 요소 노드를 추가함.
firstLang.insertBefore(newNode, firstLang.childNodes[2]);
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_02)

위의 예제에서 새롭게 생성된 paradigm 요소 노드는 노드 리스트의 두 번째 요소 노드 앞에 추가
된다. 따라서 결과적으로 노드 리스트의 두 번째 요소 노드는 새롭게 추가된 paradigm 요소 노드가 된다.

<aside>
💡 기준 자식 노드에 null 값을 전달하면 새로운 노드는 자식 노드 리스트의 맨 마지막 노드로 추가된다. 즉 appendChild 메소드와 완전히 같은 동작을 하게 된다.

</aside>

---

### **insertData 메소드**

insertData 메소드는 텍스트 노드의 텍스트 데이터에 새로운 텍스트를 추가한다. 

insertData 메소드의 원형은 다음과 같다.

```jsx
텍스트노드.insertData(오프셋, 새로운데이터);
```

1. 오프셋(offset) : 오프셋 값은 0부터 시작하며, 기존 텍스트 데이터의 몇 번째 위치부터 추가할지를 전달한다.
2. 새로운 데이터 : 새로이 삽입할 텍스트 데이터를 전달한다

다음 예제는 세 번째 name 요소 노드의 텍스트 노드의 테이터 끝 부분에 Script를 추가하는 예제
이다.

```jsx
xmlObj = xmlHttp.responseXML;     // 요청한 데이터를 XML DOM 객체로 반환함.
javaName = xmlObj.getElementsByTagName("name")[2].firstChild; // 세 번째 <name>요소의 텍스트 노드를 반환함.

javaName.insertData(1, "Script"); // 텍스트 데이터의 두 번째 문자 위치에 "Script"를 추가함.
javaName.insertData(2, "Script"); // 텍스트 데이터의 세 번째 문자 위치에 "Script"를 추가함.
javaName.insertData(3, "Script"); // 텍스트 데이터의 네 번째 문자 위치에 "Script"를 추가함.
javaName.insertData(4, "Script"); // 텍스트 데이터의 다섯 번째 문자 위치에 "Script"를 추가함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_03)

위의 예제처럼 오프셋을 기존 텍스트 데이터의 길이로 전달하면, 기존 텍스트의 끝에 새로운 텍스트를 추가할 수 있다.

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-_-1eed1f3bbdd342f584bb70dd04595978
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeManage](http://www.tcpschool.com/xml/xml_dom_nodeManage)
