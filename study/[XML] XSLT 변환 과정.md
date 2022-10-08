# [XML] XSLT 변환 과정

XSLT의 변환 과정은 다음과 같이 크게 두 가지 과정으로 이루어진다.

1. 변환(Transformation) : XML 문서를 다른 구조의 XML 문서로 변환하는 과정
2. 서식 설정(Formatting) : XML 문서를 특정 데이터 구조의 비 XML 문서로 변환하는 과정

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7c92e4d9-be2b-40d5-941c-517401c22121/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221008%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221008T122358Z&X-Amz-Expires=86400&X-Amz-Signature=e3c8ab5cbef148dad8697795e23f5663b97bc6cceeb98118ec97714e9c1e2dc9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

### XSLT 변환

변환될 데이터를 가지고 있는 XML 문서와 변환에 대한 규칙을 가지고 있는 XSLT 문서만 있으면 
변환을 진행할 수 있다.

XML 문서를 잘 구성된(well-formed) HTML 문서로 바꾸는 과정을 순서대로 살펴보자.

***data.xml***

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
    ...
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

### 1단계 : XSLT 문서작성

***xml_xslt_01.xsl***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2 style="text-align:center">프로그래밍 언어</h2>
                <table border="1" style="width: 50%; margin: auto">
                    <tr>
                        <th>이름</th>
                        <th>종류</th>
                        <th>개발사</th>
                        <th>버전</th>
                        <th>중요도</th>
                    </tr>
                    <xsl:for-each select="programming_languages/language">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="category"/></td>
                            <td><xsl:value-of select="developer"/></td>
                            <td><xsl:value-of select="version"/></td>
                            <td><xsl:value-of select="priority"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
```

---

### **2 단계 : XML 문서에 XSLT 문서를 연결**

***xml_xslt_01.xml***

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="xml_xslt_01.xsl"?>
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

### **3 단계 : 웹 브라우저에서 XML 문서 확인**

[http://www.tcpschool.com/xml/xml_xslt_transform](http://www.tcpschool.com/xml/xml_xslt_transform)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XSLT-31b5e5ee0b3f400abf7e967d48f6387b
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xslt_transform](http://www.tcpschool.com/xml/xml_xslt_transform)
