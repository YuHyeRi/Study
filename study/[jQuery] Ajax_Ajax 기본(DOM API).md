# [jQuery] **Ajax_Ajax 기본(DOM API)**

### *DOM API*

Ajax를 이용하여 웹 페이지의 일부분만을 갱신하려면 더욱 다양한 DOM 속성을 활용해야 한다.
따라서 DOM과 관련된 다양한 API를 이용하여 노드를 동적으로 생성하고 조작할 수 있어야만 한다.
더 자세한 사항은 자바스크립트 노드의 조작 수업과 노드의 관리 수업에서 확인할 수 있다.

[자바스크립트 노드의 관리 수업 확인 👉](http://www.tcpschool.com/javascript/js_dom_nodeManage)

[자바스크립트 노드의 조작 수업 확인 👉](http://www.tcpschool.com/javascript/js_dom_nodeHandle)

---

### ***노드의 추가***

다음 메소드를 사용하면 특정 위치에 새로운 노드를 추가할 수 있다.

1. ***appendChild*** :  새로운 노드를 해당 노드의 자식 노드 리스트에 맨 마지막 노드로 추가함
2. ***insertBefore*** : 새로운 노드를 특정 노드 바로 앞에 추가함
3. ***insertData*** : 텍스트 노드의 텍스트 데이터에 새로운 텍스트를 추가함

다음 예제는 appendChild 메소드를 이용하여 노드를 추가하는 자바스크립트 예제이다.

```jsx
function appendNode(){
	var parent = document.getElementById('list');
	var newItem = document.getElementById('item');

	parent.appendChild(newItem)  // 해당 요소의 맨 마지막 자식 노드로 추가함
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_01)

---

### *노드의 생성*

생성할 노드의 종류에 따라 다음과 같은 메소드를 사용할 수 있다.

1. ***createElement*** : 새로운 요소 노드를 생성함
2. ***createAttribute*** : 새로운 속성 노드를 생성함
3. ***createTextNode*** : 새로운 텍스트 노드를 생성함

다음 예제는 createElement 메소드를 이용하여 노드를 생성하는 자바스크립트 예제이다.

```jsx
function createNode(){
	var criteriaNode = document.getElementById("text"); // 기준이 되는 요소로 아이디가 "text"인 요소를 선택함.
	var newNode = document.createElement("p");          // 새로운 <p> 요소를 생성함.

	newNode.innerHTML = "새로운 단락입니다.";
	document.body.insertBefore(newNode, criteriaNode);  // 새로운 요소를 기준이 되는 요소 바로 앞에 추가함.
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_04)

---

### *노드의 제거*

다음 메소드를 사용하면 특정 노드를 제거할 수 있다.

1. ***removeChild*** : 기존의 노드 리스트에서 특정 노드를 제거함
2. ***removeAttribute*** : 속성의 이름을 이용하여 특정 속성 노드를 제거함

다음 예제는 removeChild 메소드를 이용하여 노드를 제거하는 자바스크립트 예제이다.

```jsx
var parent = document.getElementById("list");      // 아이디가 "list"인 요소를 선택함.
var removedItem = document.getElementById("item"); // 아이디가 "item"인 요소를 선택함.

parent.removeChild(removedItem);                   // 지정된 요소를 삭제함.
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_07](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_07)

---

### *노드의 복제*

***cloneNode*** 메소드를 사용하면 특정 노드를 복제할 수 있다.

다음 예제는 cloneNode 메소드를 이용하여 노드를 복제하는 자바스크립트 예제이다.

```jsx
function cloneElement() {
	var parent = document.getElementById("list");     // 아이디가 "list"인 요소를 선택함.
	var originItem = document.getElementById("item"); // 아이디가 "item"인 요소를 선택함.

	parent.appendChild(originItem.cloneNode(true));   // 해당 노드를 복제하여 리스트의 맨 마지막에 추가함.
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_09](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeManage_09)

---

### *노드의 값 변경*

***nodeValue*** 프로퍼티를 사용하면 특정 노드의 값을 변경할 수 있다. 
또한 ***setAttribute*** 메소드는 속성 노드의 속성값을 변경할 수 있게 해준다.

다음 예제는 nodeValue 프로퍼티를 이용하여 노드를 생성하는 자바스크립트 예제이다.

```jsx
var para = document.getElementById('text');

function changeText(){
	para.firstChild.nodeValue = '텍스트 변경 완료!';
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeHandle_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeHandle_01)

---

### *노드의 교체*

***replaceChild*** 메소드를 사용하면 특정 노드 그 자체를 다른 노드로 바꿀 수 있다.

다음 예제는 replaceChild 메소드를 이용하여 노드를 교체하는 자바스크립트 예제이다.

```jsx
var parent = document.getElementById("parent"); // 부모 노드를 선택함.
var first = document.getElementById("first");
var third = document.getElementById("third");

function changeNode() {
	parent.replaceChild(third, first);          // first 요소를 삭제하고, 그 대신 third 요소를 삽입함.
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeHandle_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=js_dom_nodeHandle_03)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-Ajax_Ajax-DOM-API-eb916e5fc95c41f8ba5c9cb1c2558750
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_basic_domApi](http://www.tcpschool.com/ajax/ajax_basic_domApi)
