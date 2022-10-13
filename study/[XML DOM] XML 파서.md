# [XML DOM] **XML 파서**

### **XML 파서(parser)**

현재 대부분의 주요 웹 브라우저는 XML 문서에 접근하고 조작하기 위한 XML 파서를 
별도로 내장하고 있다.

XML DOM은 XML 문서에 접근하고 조작할 수 있는 다양한 메소드를 포함하고 있다. 

하지만 이러한 메소드를 이용하려면 우선 XML 문서를 XML DOM 객체로 변환해야만 한다. 
XML 파서는 XML 문서의 평문 데이터를 읽어들여 그것을 XML DOM 객체로 반환해준다.

---

### **문자열 파싱(parsing)**

다음 예제는 XML 문서의 문자열을 추출하거나 XML DOM 객체로 파싱하고 해당 객체에서 
정보를 추출하는 예제이다.

```jsx
text = "<language><name>HTML</name>" + 
    "<category>web</category>" + 
    "<priority>high</priority>" + 
    "<standard version='5.1'>W3C</standard></language>";
xmlParser = new DOMParser(); // DOMParser 객체를 생성함.
// parseFromString() 메소드를 이용해 문자열을 파싱함.
xmlDoc = xmlParser.parseFromString(text, "text/xml");
document.getElementById("text").innerHTML = "첫 번째 name 요소의 텍스트 값은 " +
xmlDoc.getElementsByTagName("name")[0].childNodes[0].nodeValue + "입니다.";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_xmlParser_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_dom_xmlParser_01)

<br><br>
👉 출처 : https://www.notion.so/tgmary09/XML-DOM-XML-3331d240544e4b3f959dd1a6c565350f
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dom_xmlParser](http://www.tcpschool.com/xml/xml_dom_xmlParser)
