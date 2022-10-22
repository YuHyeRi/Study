# [XML] 노드의 관리_노드복제

### 노드의 복제

cloneNode 메소드를 사용하면 특정 노드를 복제할 수 있다.

---

### **cloneNode 메소드**

cloneNode 메소드는 기존의 존재하는 노드와 똑같은 새로운 노드를 생성하여 반환한다. 

cloneNode 메소드의 원형은 다음과 같다.

```jsx
복제할노드.cloneNode(자식노드복제여부);
```

- 자식 노드 복제 여부 : 전달된 값이 true 이면 복제되는 노드의 모든 속성 노드와 자식 노드도 
같이 복제하며 false이면 속성 노드만 복제하고 자식 노드는 복제하지 않는다.

다음 예제는 첫 번째 language 요소 노드의 name 요소를 복제하여 해당 요소를 첫 번째 language 
요소 노드의 마지막 자식 노드로 추가하는 예제이다.

```jsx
xmlObj = xmlHttp.responseXML;                           // 요청한 데이터를 XML DOM 객체로 반환함.
firstLang = xmlObj.getElementsByTagName("language")[0]; // 첫 번째 <language>요소를 반환함.
copiedNode = firstLang.childNodes[1].cloneNode(true);   // <name>요소를 복제함.
firstLang.appendChild(copiedNode); // 첫 번째 <language>요소에 복제한 <name>요소를 추가함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_09](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_nodeManage_09)

다음 그림은 위 예제의 동작을 순서대로 나타낸 그림이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7b247f77-3d72-4116-9c96-2e5eb221cb7c/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221022%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221022T012520Z&X-Amz-Expires=86400&X-Amz-Signature=16ab0aa62101bcf93b08f80327b1938dd564dc3a71129a536f96369af1964c6b&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-_-c6bf602ece174b4499fa3377013f1e85
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_nodeManage](http://www.tcpschool.com/xml/xml_dom_nodeManage)
