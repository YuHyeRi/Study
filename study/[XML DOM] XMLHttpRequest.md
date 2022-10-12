# [XML DOM] **XMLHttpRequest**

### **XMLHttpRequest 객체**

현재 대부분의 주요 웹 브라우저는 서버에 데이터를 요청하기 위한 XMLHttpRequest 객체를 
내장하고 있다. XMLHttpRequest 객체는 서버로부터 XML 데이터를 전송받아 처리하는데 사용된다.

이 객체를 사용하면 웹 페이지가 전부 로딩된 후에도 서버에 데이터를 요청하거나 서버로부터 
데이터를 전송받을 수 있다. 

즉, 웹 페이지 전체를 다시 로딩하지 않고 일부분만을 갱신할 수 있게 된다.

---

### XMLHttpRequest 객체의 생성

자바스크립트를 이용하여 XMLHttpRequest 객체를 생성하는 방법은 다음과 같다.

```jsx
var xmlHttp = new XMLHttpRequest();
```

---

### **readyState**

readyState 프로퍼티는 XMLHttpRequest 객체의 현재 상태를 나타낸다.
이 프로퍼티의 값은 객체의 현재 상태에 따라 다음과 같은 주기로 변화한다.

1. UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨.
2. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨.
3. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.
4. LOADING (숫자 3) : 요청한 데이터를 처리 중임.
5. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.

---

### **status**

status 프로퍼티는 서버의 문서 상태를 나타낸다.

- 200 : 서버에 문서가 존재함
- 404 : 서버에 문서가 존재하지 않음

---

### **XMLHttpRequest**

자바스크립트를 이용하여 XMLHttpRequest 객체를 전송하는 방법은 다음과 같다.

```jsx
var xmlHttp = new XMLHttpRequest();       // XMLHttpRequest 객체를 생성함.

xmlHttp.onreadystatechange = function() { // onreadystatechange 이벤트 핸들러를 작성함.
    // 서버상에 문서가 존재하고 요청한 데이터의 처리가 완료되어 응답할 준비가 완료되었을 때
    if(this.status == 200 && this.readyState == this.DONE) {
        // 요청한 데이터를 문자열로 반환함.
        document.getElementById("text").innerHTML = xmlHttp.responseText;            
    }
};

xmlHttp.open("GET", "/examples/media/xml_httpxmlrequest_data.txt", true);
xmlHttp.send();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_xmlHttpRequest_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_xmlHttpRequest_01)

---

### **responseText**

responseText 프로퍼티는 서버에 요청하여 응답으로 받은 데이터를 문자열로 저장하고 있다.

```jsx
document.getElementById("text").innerHTML = xmlHttp.responseText;
```

---

### **responseXML 프로퍼티**

responseXML 프로퍼티는 서버에 요청하여 응답으로 받은 데이터를 XML DOM 객체로 저장하고 
있다.

```jsx
xmlObj = xmlHttp.responseXML;                   // 요청한 데이터를 XML DOM 객체로 반환함.
nameList = xmlObj.getElementsByTagName("name"); // XML DOM 객체에서 요소이름이 "name"인 요소들을 선택함.
result = "";

for (idx = 0; idx < nameList.length; idx++) {
    // id가 "name"인 요소들의 텍스트 노드를 찾아 그 값을 반환함.
    result += nameList[idx].childNodes[0].nodeValue + "<br>";
}
document.getElementById("text").innerHTML = result;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_xmlHttpRequest_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_xmlHttpRequest_02)

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

---

### 비동기식(**asynchronous) 요청**

서버에 비동기식 요청을 보내기 위해서는 open 메소드의 세 번째 인수로 true를 전달하면 된다. 
이렇게 비동기식으로 요청을 보내면 자바스크립트는 서버로부터 응답을 기다리면서 
동시에 다른 일을 할 수 있게 된다.

```xml
xmlHttp.open("GET", "/media/programming_languages.xml", true);
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-DOM-XMLHttpRequest-d6c232f23f4f444b8080fde444f6f1ec
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_xmlHttpRequest](http://www.tcpschool.com/xml/xml_dom_xmlHttpRequest)
