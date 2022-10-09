# [XML] XSLT **템플릿 작성 및 적용**

### 루트 요소

XSLT 문서의 루트 요소는 <xsl:stylesheet>요소나 <xsl:transform>요소로 표현할 수 있다. 
또한 루트 요소의 시작 태그에는 W3C XSLT 네임스페이스를 반드시 같이 명시해줘야 한다.

***예제1***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
...
</xsl:stylesheet>
```

***예제2***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:transform version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
...
</xsl:transform>
```

위의 두 예제는 정확히 같은 동작을 수행하기 때문에 어느 쪽을 사용해도 같은 결과를 얻을 수 있다.

---

### 템플릿 작성

XSLT 프로세서가 XSLT 문서에서 가장 먼저 찾는 요소는 바로 템플릿 요소이다. 
템플릿은 특정 노드가 일치할 때 해당 노드에 적용할 규칙들을 포함하고 있다. 
이러한 템플릿은 루트 노드에 포함된 콘텐츠를 어떻게 처리하고 변환할 것인지를 나타낸다. 

XSLT 문서에서 템플릿은 <xsl:template>요소로 표현할 수 있다. 
match 속성에는 속성값으로 템플릿과 연결할 XML 요소의 범위를 나타내는 XPath 표현식을
명시한다.

다음 예제는 XML 문서 전체를 템플릿과 연결해주는 예제이다.

```xml
<xsl:template match="/">
```

노드(node)에 대한 더 자세한 사항은 XML 노드 수업에서 확인할 수 있다.

[XML 노드 수업 확인 =>](http://www.tcpschool.com/xml/xml_dom_node)

---

### 템플릿 적용

<xsl:apply-template> 요소는 특정 노드나 특정 노드의 자식 노드에 템플릿을 적용할 때 사용한다.
다음 예제는 name 요소와 category 요소에만 각각 별도의 템플릿을 적용하는 예제이다.

***xml_xslt_02.xsl***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2 style="text-align:center">프로그래밍 언어</h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="language">
        <p>
            <xsl:apply-templates select="name"/>
            <xsl:apply-templates select="category"/>
        </p>
    </xsl:template>
    <xsl:template match="name">
        언어 이름 : <strong>
        <xsl:value-of select="."/></strong><br/>
    </xsl:template>
    <xsl:template match="category">
        카테고리 : <span style="color: green">
        <xsl:value-of select="."/></span><br/>
    </xsl:template>
</xsl:stylesheet>
```

이번 수업의 예제에서 사용되는 xml_xslt_02.xml 파일의 코드는 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="xml_xslt_02.xsl"?>
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

다음은 위의 xml_xslt_02.xml 파일을 실행한 결과이다.

[http://www.tcpschool.com/xml/xml_xslt_template](http://www.tcpschool.com/xml/xml_xslt_template)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XSLT-5a62fffa320a41b3bacce8b8cfbb3a8f
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xslt_template](http://www.tcpschool.com/xml/xml_xslt_template)
