# [XML] XML 문서의 종류

**XML 문서의 종류**

W3C의 XML 표준 권고안은 문법적인 측면에서 두 가지 종류의 XML 문서를 정의하고 있다.

1. 문법에 맞는(well-formed) XML 문서
2. 유효한(valid) XML 문서

---

**문법에 맞는(well-formed) XML 문서**

문법에 맞는 XML 문서란 XML 문서로서 가져야 하는 최소한의 필수 요건을 충족한 XML 문서를 의미한다. 따라서 이 문서는 XML의 모든 구문을 허용하지만, DTD(document type definition)나 스키마를 사용하지는 않는다.

문법에 맞는 XML 문서가 되기 위한 필수 요건은 다음과 같다.

1. 루트 요소를 하나만 가져야 한다.
2. 모든 XML 요소는 종료 태그를 가져야 한다.
3. 시작태그와 종료태그에 사용된 태그 이름이 대소문자까지 완벽하게 일치해야 한다.
4. 모든 XML 요소의 여닫는 순서가 반드시 정확하게 지켜져야 한다.
5. 모든 속성의 속성값이 따옴표로 둘러싸여 있어야 한다.

위에서 언급한 필수 요건을 만족하지 못하는 XML 문서는 오류를 발생시킨다.
HTML 문서와는 달리 XML 문서에서는 오류가 발생하면 해당 응용 프로그램의 모든 동작을 중지시킨다. 따라서 모든 XML 문서는 반드시 문법에 맞는 XML 문서여야만 한다.

---

**유효한(valid) XML 문서**

유효한 문서는 문법에 맞는 문서를 좀 더 엄격하게 검증한 문서이다. 따라서 유효한 XML 문서는 
모두 문법에 맞는 XML 문서이다. 거기에 추가하여 DTD를 가지고 있으며 그에 따라 제대로 검증된 
문서를 의미한다.

XML에서 사용하는 DTD에는 다음과 같이 두 가지 종류가 있다.

1. DTD : 일반적인 문서 타입 정의
2. XML 스키마(XSD)

이러한 DTD는 XML 문서의 구조 및 해당 문서에서 사용할 수 있는 적법한 요소와 속성을 정의한다.

[XML DTD 수업 확인 =>](http://www.tcpschool.com/xml/xml_dtd_intro)

XML 스키마(XSD)에 대한 더 자세한 사항은 XML XSD 수업에서 확인할 수 있다.

[XML XSD 수업 확인 =>](http://www.tcpschool.com/xml/xml_xsd_intro)

---

**XML 파서**

XML 파서란 응용 프로그램이 XML 문서를 읽을 수 있도록 인터페이스를 제공해주는 라이브러리나 패키지를 의미한다. XML 파서는 XML 문서가 적합한 형식을 갖추고 있는지와 문법상의 오류는 없는지를 검사한다. 현재 대부분의 주요 웹 브라우저는 모두 XML 파서를 내장하고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9171a27c-fe03-45d5-8afb-01d6409c5276/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221006%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221006T014858Z&X-Amz-Expires=86400&X-Amz-Signature=cf04187860f1f5c8b38ebbb926d4fa2cdb04547232e55c5d986b59f67326f920&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

위의 그림은 XML 파서가 어떠한 방식으로 XML 문서와 동작하는지를 보여준다.
XML 파서의 최종목적은 XML 문서를 응용 프로그램이 읽을 수 있는 코드로 변환하는 것이다.

현재 많이 사용되고 있는 XML 파서의 종류는 다음과 같다.

- MSXML(Microsoft Core XML Services)
- System.Xml.XmlDocument
- Java built-in parser
- Saxon
- Xerces

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XML-0dbe2d2704894cf99dd9b65f4d1ebde1
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_basic_document](http://www.tcpschool.com/xml/xml_basic_document)
