# [Ajax고급] 문서 타입별 응답 처리

### *서버로부터의 응답 데이터 확인*

Ajax에서는 서버로부터 전달받은 데이터를 다음 프로퍼티를 이용하여 확인할 수 있다.

- responseText 프로퍼티
- responseXML 프로퍼티

---

### ***responseText 프로퍼티***

responseText 프로퍼티는 서버에 요청하여 응답으로 받은 데이터를 문자열로 반환한다.

```jsx
document.getElementById("text").innerHTML = xmlHttp.responseText;
```

---

### *텍스트 파일의 응답 처리*

서버로부터 텍스트 파일을 응답으로 받은 경우에는 responseText 프로퍼티를 사용하여 
받은 데이터를 문자열로 반환한 후 사용할 수 있다.

```jsx
var httpRequest = new XMLHttpRequest();

httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
        // 텍스트 파일의 응답 처리는 responseText 프로퍼티를 사용해야 함.
        
				document.getElementById("text").innerHTML = httpRequest.responseText;
        // 텍스트 파일의 응답 처리에 responseXML 프로퍼티를 사용하면 null을 반환함.
				document.getElementById("xml").innerHTML = httpRequest.responseXML;
    }
};

httpRequest.open("GET", "/examples/media/ajax_doctype_text.php");
httpRequest.send();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_docType_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_docType_01)

**ajax_doctype_text.php**

```php
<?php
    header("Content-Type: text/plain");
?>

Ajax 응답으로 받은 텍스트 문서입니다.
```

---

### ***responseXML 프로퍼티***

responseXML 프로퍼티는 서버에 요청하여 응답으로 받은 데이터를 XML DOM 객체로 반환한다.

```jsx
var httpRequest = new XMLHttpRequest();

httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
        // XML 문서의 응답 처리에 responseText 프로퍼티를 사용하면 XML 코드를 문자열로 반환함.
				document.getElementById("text").innerHTML = httpRequest.responseText;
       
			 // XML 문서의 응답 처리는 responseXML 프로퍼티를 사용해야 함.
        document.getElementById("xml").innerHTML = httpRequest.responseXML;
    }
};

httpRequest.open("GET", "/examples/media/ajax_doctype_xml.php");
httpRequest.send();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_docType_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_docType_02)

**ajax_doctype_xml.php**

```php
<?php
    header("Content-Type: text/xml");
    echo ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
?>

<message>
    Ajax 응답으로 받은 <b>XML 문서</b>입니다.
</message>
```

---

### ***XML 데이터의 응답 처리***

서버로부터 XML 데이터를 응답으로 받은 경우에는 responseXML 프로퍼티를 사용하여 받은 데이터를 처리할 수 있다. 
먼저 responseXML 프로퍼티를 사용하여 XML DOM 객체를 반환한 후에 해당 객체를 가지고 
작업하면 된다.

```jsx
var httpRequest, xmlData, result, i;
httpRequest = new XMLHttpRequest();

httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
        xmlData = httpRequest.responseXML;
        document.getElementById("text").innerHTML =
            xmlData.getElementsByTagName("b")[0].firstChild.nodeValue;
            // XML 데이터의 첫 번째 <b>태그의 텍스트 노드의 값을 반환함.
    }
};

httpRequest.open("GET", "/examples/media/ajax_doctype_xml.php");
httpRequest.send();
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_docType_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_advance_docType_03)

responseText와 responseXML 프로퍼티에 대한 더 자세한 사항은 XMLHttpRequest 객체 수업에서 
확인할 수 있다.

[XML XMLHttpRequest 수업 확인 =>](http://www.tcpschool.com/xml/xml_dom_xmlHttpRequest)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/Ajax-f06446df772d42b9a62118a05721c30d
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_advance_docType](http://www.tcpschool.com/ajax/ajax_advance_docType)
