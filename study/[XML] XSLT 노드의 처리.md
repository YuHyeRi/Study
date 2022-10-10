# [XML] XSLT 노드의 처리

### 노드의 반복 처리

<xsl:for-each> 요소는 선택된 각 노드에 반복해서 템플릿을 적용해준다. 
이 요소는 select 속성으로 전달받은 XPath 표현식에 따라 선택된 노드의 개수만큼 반복해서 
템플릿을 적용한다. 

다음 예제는 <programming_languages>요소의 자식 요소인 <language>요소의 개수만큼 반복해서 템플릿을 적용하는 예제이다.

```xml
<xsl:for-each select="programming_languages/language">
...
</xsl:for-each>
```

---

### 노드의 값 출력

<xsl:value-of>요소는 선택된 노드에서 데이터를 추출해준다. 
이 요소는 select 속성으로 전달받은 XPath 표현식에 따라 선택된 노드의 값을 텍스트로 추출하여 
해당 위치에 삽입한다.

다음 예제는 name 요소의 값을 추출하여 텍스트로 삽입하는 예제이다.

```xml
<xsl:value-of select="name"/>
```

---

### 노드의 정렬

<xsl:sort>요소는 노드의 정렬 기준을 명시할 때 사용한다. 
<xsl:sort> 요소를 작성하는 문법은 다음과 같다.

```xml
<xsl:sort
    select = string-expression
    lang = { nmtoken }
    data-type = { "text" | "number" | qname-but-not-ncname }
    order = { "ascending" | "descending" }
    case-order = { "upper-first" | "lower-first" } />
```

- select : 노드를 정렬하기 위해 기준이 되는 키(key)를 명시한다.
- lang : 정렬 순서를 결정하는데 사용되는 영문자를 명시한다.
- data-type : 텍스트의 타입을 명시한다.
- order : 정렬순서를 명시하며 기본 설정값은 오름차순이다.
- case-order : 대소문자에 의한 문자열의 정렬 순서를 명시하며 기본 설정값은 대문자가 먼저(upper-first)이다.

다음 예제는 name요소의 텍스트 값을 비교하여 오름차순으로 정렬하는 예제이다.

***xml_xslt_03.xsl***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2 style="text-align:center">이름에 따른 오름차순 정렬</h2>
                <xsl:for-each select="programming_languages/language">
                    <xsl:sort select="name" data-type="text" order="ascending"/>
                    <xsl:value-of select="name"/><br/>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
```

이번 수업의 예제에서 사용되는 xml_xslt_03.xml 파일의 코드는 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="xml_xslt_03.xsl"?>
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

다음은 위의 xml_xslt_03.xml 파일을 실행한 결과이다.

[http://www.tcpschool.com/xml/xml_xslt_nodeHandling](http://www.tcpschool.com/xml/xml_xslt_nodeHandling)

---

### 노드의 조건부 처리

<xsl:if> 요소는 노드의 값이 특정 조건에 해당할 때만 동작한다. 
이 요소는 test 속성으로 전달받은 표현식이 참인 경우에만 실행된다.

다음 예제는 버전이 5 이상인 언어만을 출력하는 예제이다.

***xml_xslt_04.xsl***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2 style="text-align:center">버전이 5.0 이상인 언어</h2>
                <xsl:for-each select="programming_languages/language">
                    <xsl:if test="version &gt; 5">
                        <xsl:value-of select="name"/> : ver.
                        <xsl:value-of select="version"/><br/>
                    </xsl:if>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
```

이번 수업의 예제에서 사용되는 xml_xslt_04.xml 파일의 코드는 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="xml_xslt_04.xsl"?>
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

다음은 위의 xml_xslt_04.xml 파일을 실행한 결과이다.

[http://www.tcpschool.com/xml/xml_xslt_nodeHandling](http://www.tcpschool.com/xml/xml_xslt_nodeHandling)

---

### 노드의 다중 조건부 처리

<xsl:choose> 요소는 <xsl:when>과 <xsl:otherwise>요소와 함께 다중 조건문을 작성할 때 사용한다. <xsl:when>요소는 test 속성으로 전달받은 표현식이 참인 경우에만 실행된다. 
전달받은 표현식이 거짓인 경우에는 <xsl:when>요소는 실행되지 않으며, 
대신에 <xsl:otherwise>요소가 실행된다.

다음 예제는 priority요소의 rating 속성값이 2 이상인 경우와 그렇지 않은 경우에 다른 텍스트를 
출력해주는 예제이다.

***xml_xslt_05.xsl***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2 style="text-align:center">노드의 다중 조건부 처리</h2>
                <xsl:for-each select="programming_languages/language">
                    <xsl:choose>
                        <xsl:when test="priority[@rating &gt; 2]">
                            <xsl:value-of select="name"/> : 나중에 꼭 공부해요!<br/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="name"/> : 우선은 이 과목부터 공부하죠!<br/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
```

이번 수업의 예제에서 사용되는 xml_xslt_05.xml 파일의 코드는 다음과 같다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="xml_xslt_05.xsl"?>
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

다음은 위의 xml_xslt_05.xml 파일을 실행한 결과이다.

[http://www.tcpschool.com/xml/xml_xslt_nodeHandling](http://www.tcpschool.com/xml/xml_xslt_nodeHandling)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XSLT-7931c58484f94fa4ba9b068f5fe3d5bf
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xslt_nodeHandling](http://www.tcpschool.com/xml/xml_xslt_nodeHandling)
