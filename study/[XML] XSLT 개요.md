# [XML] XSLT 개요

### **XSLT란?**

XML 문서는 다양한 장치에서 데이터를 저장하고 전달할 목적으로 만들어졌다. 
그러나 각각의 장치는 내부적으로 자신만의 고유한 데이터 구조를 사용하고 있다.

따라서 각각의 장치가 전달받은 XML문서를 자신이 사용하는 데이터 구조로 변환할 때 
사용할 규칙이 필요하다. 
이러한 변환 규칙에 대한 명세를 작성할 수 있는 언어가 바로 XSL(eXtensible Stylesheet Language) 이다.

CSS가 HTML 문서를 위한 스타일 시트 언어라면 XSL은 XML 문서를 위한 스타일 시트 언어이다.

---

### **XSL의 구성**

XSL은 XML 문서의 변환과 표현을 정의하는 세 개의 언어로 구성된다.

1. XSLT : XSL Transformations를 의미하며 XML 문서를 다른 구조의 문서로 변환시키기 위한 언어
2. XPath : XML 문서의 특정 요소나 속성에 접근하기 위한 경로를 지정하는 언어
3. XSL-FO : XML 데이터를 출력하기 위한 목적으로 설계된 언어

<aside>
💡 XSL-FO는 2012년에 발표된 2.0 버전을 마지막으로 2013년부터는 더 이상의 업데이트를 
진행하고 있지 않다. 따라서 현재는 CSS3로 대체하여 사용하고 있다.

</aside>

---

### XSLT란?

XSLT는 XML 문서를 XHTML 문서나 또 다른 XML 타입의 문서로 변환하기 위해 사용하는 언어이다. XSLT는 W3C 표준 권고안으로 XSL에서 가장 중요한 언어이다.
위와 같은 변환과정에서 XSLT는 XPath를 이용하여 XML 문서에서 필요한 정보를 찾는 역할을 한다.

현재 대부분의 주요 웹 브라우저는 XSLT와 XPath를 모두 지원하고 있다. 가장 최신 버전의 XSLT는 2015년에 발표된 XSLT 3.0 후보 권고안이다. XSLT 3.0에 대한 더 자세한 정보를 원한다면 
W3C 공식 사이트를 방문하여 확인할 수 있다.

[XML Tansformations (XSLT) Version 3.0 =>](https://www.w3.org/TR/xslt-30/)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XSLT-012ede217f4549fb89858387e12ee3de
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xslt_intro](http://www.tcpschool.com/xml/xml_xslt_intro)
