### 노드의 제거

다음 메소드를 사용하면 특정 노드를 제거할 수 있다.

1. removeChild()
2. removeAttribute()

---

### **removeChild 메소드**

removeChild 메소드는 자식 노드 리스트에서 특정 자식 노드르르 제거한다. 
이 메소드는 성공적으로 노드가 제거되면 제거된 노드를 반환한다. 
노드가 제거될 때는 제거되는 노드의 자식 노드들도 다같이 제거된다.

다음 예제는 첫 번째 language 요소 노드에서 category 요소 노드를 제거하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;                                 // 요청한 데이터를 XML DOM 객체로 반환함.
firstLang = xmlObj.getElementsByTagName("language")[0];       // 첫 번째 <language>요소를 반환함.
removedNode = firstLang.removeChild(firstLang.childNodes[3]); // <category>요소를 제거함.
result += "<br>제거된 요소 노드는 " + removedNode.nodeName + "입니다.";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_07](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_07)

---

### **removeAttribute 메소드**

removeAttribute 메소드는 속성의 이름을 이용하여 특정 속성 노드를 제거한다. 

다음 예제는 첫 번째 priority 요소 노드에서 rating 속성 노드를 제거하는 예제이다.

```jsx
firstStandard = xmlObj.getElementsByTagName("priority")[0]; // 첫 번째 <priority>요소를 반환함.
firstStandard.removeAttribute("rating");   // 첫 번째 <priority>요소의 rating 속성을 제거함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_08](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_08)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-_-f55789d3e51c46afbc9b0737a0fb7eb4
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeManage](http://www.tcpschool.com/xml/xml_dom_nodeManage)
