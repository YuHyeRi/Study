# [**XML] XML 목적**

**XML 설계 목적**

W3C에 의하면 XML은 다음과 같은 목적으로 설계되었다.

1. 인터넷상에서 명확하게 사용할 수 있어야 한다.
2. 다양한 응용 프로그램을 지원해야 한다.
3. SGML과 호환되어야 한다.
4. XML 문서를 처리하는 프로그램은 손쉽게 작성될 수 있어야 한다.
5. 제공하는 옵션의 수는 최소한으로 유지되어야 한다.
6. 인간이 읽을 수 있어야 하며, 의미가 명확해야 한다.
7. 설계는 빠르게 이루어져야 한다.
8. 설계는 공식적이면서 간결해야 한다.
9. 작성하기 쉬워야 한다.
10. 마크업의 간결성은 그다지 중요하지 않다.

---

**XML 목적**

서로 호환되지 않는 데이터 타입을 사용하는 시스템 간의 데이터 교환에는 많은 시간과 노력이 발생한다. 또한, 이렇게 데이터를 변환하는 과정에서 데이터의 손실이 발생하는 경우도 종종 있다.

그러나 XML은 데이터를 텍스트 형식으로 저장하므로 소프트웨어나 하드웨어에 독립적으로 데이터를 저장하고 전달할 수 있다. 

따라서 XML을 사용하면 새로운 운영체제나 프로그램, 브라우저 등에 상관없이 데이터를 안전하고 손쉽게 전달할 수 있다.

---

**HTML로부터 데이터 분리**

HTML 문서의 데이터를 XML 파일로 따로 저장할 수 있다. 이러한 데이터는 몇 줄의 자바스크립트
코드로도 간단히 읽어들일 수 있으며 HTML 문서 내에서 불러온 데이터를 손쉽게 이용할 수 있다.

다음 예제는 HTML 문서에서 분리된 XML 파일로부터 데이터를 읽어들여, 해당 데이터를 웹 페이지에 표시하는 예제이다.

```jsx
function loadDoc() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if(this.status == 200 && this.readyState == this.DONE) {
            displayData(xmlHttp);
        }
    };

    xmlHttp.open("GET", "/examples/media/korean_major_cities.xml", true);
    xmlHttp.send()
}

function displayData(xmlHttp) {
    var xmlObj, cityList, result, idx;
    xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.
    result = "<table><tr><th>도시 이름</th><th>행정구역</th></tr>";
    cityList = xmlObj.getElementsByTagName("city");
    for(idx = 0; idx < cityList.length; idx++) {
        result += "<tr><td>" +
            cityList[idx].getElementsByTagName("name")[0].childNodes[0].nodeValue + "</td><td>" +
            cityList[idx].getElementsByTagName("class")[0].childNodes[0].nodeValue + "</td></tr>";
    }
    result += "</table>";
    document.getElementById("text").innerHTML = result;
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_intro_purpose_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_intro_purpose_01)

위 예제의 코드가 복잡하고 어렵게 느껴지겠지만 XML 수업들을 차근차근 공부해나가다보면 
모두 이해할 수 있게 될 것이다. 

위의 예제에서 사용되는 korean_major_cities.xml 파일의 코드는 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<korean_cities>
    <city>
        <name>서울</name>
        <class>특별시</class>
    </city>
    <city>
        <name>부산</name>
        <class>광역시</class>
    </city>
    <city>
        <name>인천</name>
        <class>광역시</class
    </city>
    <city>
        <name>대전</name>
        <class>광역시</class>
    </city>
    <city>
        <name>광주</name>
        <class>광역시</class>
    </city>
    <city>
        <name>대구</name>
        <class>광역시</class>
    </city>
    <city>
        <name>울산</name>
        <class>광역시</class>
    </city>
    <city>
        <name>수원</name>
        <class>시</class>
    </city>
    <city>
        <name>청주</name>
        <class>시</class>
    </city>
    <city>
        <name>목포</name>
        <class>시</class>
    </city>
</korean_cities>
```
<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XML-c46345b70a484850b2dfa43b5b1562de
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_intro_purpose](http://www.tcpschool.com/xml/xml_intro_purpose)
