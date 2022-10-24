# [**XPath] 경로 표현식**

**XPath 표현식(expression)**

XPath에서는 XML 문서의 노드나 노드셋(node-set)을 선택하기 위해 다양한 표현식을 사용한다. 

이번 수업의 예제에서 사용되는 programming_languages.xml 파일의 코드는 다음과 같다.

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

<aside>
💡 *노드셋(node-set)이란 중복을 허용하지 않는 노드들의 순서없는 집합을 의미한다.*

</aside>

---

**위치 경로(location path)**

위치 경로란 XML 문서의 각 노드의 위치를 지정하기 위한 XPath 표현식이다. 

위치 경로는 절대 경로와 상대 경로로 구분할 수 있다.

- 절대 경로 : 슬래시(/)로 시작하며, 루트 노드부터 순서대로 탐색해나감
- 상대 경로 : 슬래시(/)로 시작하지 않으며, 기준으로 지정되는 노드부터 탐색해나감

위치 경로는 모두 시작 위치 이외에도 슬래시(/)로 구분되는 여러 단계(step)를 포함할 수 있다. 

위치 경로 표현에 사용되는 대표적인 경로 연산자는 다음과 같다.

| 경로 연산자 | 설명 |
| --- | --- |
| 노드 이름 | 해당 ‘노드 이름’과 일치하는 모든 노드를 선택함 |
| / | 루트 노드부터 순서대로 탐색해 나감 |
| // | 현재 노드의 위치와 상관없이 지정된 노드에서부터 순서대로 탐색해 나감 |
| . | 현재 노드를 선택함 |
| .. | 현재 노드의 부모 노드를 선택함 |
| @ | 속성 노드를 선택함 |

*예제*

```xml
developer            : <developer>요소를 모두 선택함.
/p_languages         : 루트 노드의 자식 노드인 <p_languages>요소를 선택함. (절대 경로 탐색)
p_languages/language : <p_languages>요소의 자식 노드 중 <language>요소를 모두 선택함. (상대 경로 탐색)
//                   : 루트 노드의 하위 노드를 모두 선택함.
//priority           : 위치에 상관없이 <priority>요소를 모두 선택함.
.//                  : 현재 노드의 하위 노드를 모두 선택함.
version/@status      : 모든 <version>요소의 status 속성 노드를 모두 선택함.
```

<aside>
💡 위치 경로가 슬래시(/)로 시작하면 언제나 단 하나의 요소만을 가리키는 절대 경로를 
나타낸다.

</aside>

다음 예제는 위치에 상관없이 version 요소를 모두 선택하는 예제이다.

```jsx
var xmlObj, path, result, nodeList, node;
xmlObj = xmlHttp.responseXML;
path = "//version";
result = "";

// 익스플로러를 위한 코드
if (window.ActiveXObject !== undefined || xmlHttp.responseType == "msxml-document") {
    xmlObj.setProperty("SelectionLanguage", "XPath");
    nodeList = xmlObj.selectNodes(path);
    for (i=0; i<nodeList.length; i++) {
        result += nodeList[i].text + "<br>";
    }

// 익스플로러를 제외한 브라우저를 위한 코드
} else if (document.implementation && document.implementation.createDocument) {
    nodeList = xmlObj.evaluate(path, xmlObj, null, XPathResult.ANY_TYPE, null);
    node = nodeList.iterateNext();
    while (node) {
        result += node.firstChild.nodeValue + "<br>";
        node = nodeList.iterateNext();
    }
}
document.getElementById("text").innerHTML = result;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_xpath_pathExpression_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_xpath_pathExpression_01)

---

**노드를 찾기 위한 검색 방향 설정**

XPath에서 검색 방향(axis step)은 현재 노드를 기준으로 어느 방향으로 검색해 나갈지를 명시한다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cbc1be09-9ff0-49fb-ae4a-a65395645cca/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221024%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221024T005101Z&X-Amz-Expires=86400&X-Amz-Signature=3da2613c21108fed2cbddc2b7d15e5f3e15cedc63c1a05416d325ad35f8121f4&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

XPath에서 사용할 수 있는 검색 방향(axis step)은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/728d0701-5ee9-4ccc-89fb-e807e84348d4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221024%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221024T005133Z&X-Amz-Expires=86400&X-Amz-Signature=3201e2bed846ec098325846787bb02c909d99a5123a3e97643dd9f6674c1a614&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

---

**경로 표현식(path expression)**

XPath에서는 노드를 선택하기 위해 경로 표현식을 사용한다.

XPath에서 경로 표현식을 작성하는 문법은 다음과 같다.

<aside>
💡 검색방향::노드테스트[필터표현식]

</aside>

1. 검색 방향 : 현재 노드를 기준으로 노드를 검색할 방향을 전달한다.
2. 노드 테스트 : 검색 방향에 존재하는 해당 노드를 검색한다.
3. 필터 표현식 : 검색된 노드셋(node-set)에서 특정 노드나 특정 값을 포함하는 노드를 포함한다.

*예제*

```xml
child::language            : 현재 노드의 자식 노드 중 <language>요소를 모두 선택함.
attribute::version         : 현재 노드의 version 속성 노드를 선택함.
descendant::*              : 현재 노드의 자손 노드를 모두 선택함.
descendant::text()         : 현재 노드의 자손 노드 중 텍스트 노드를 모두 선택함.
ancestor::language         : 현재 노드의 조상 노드 중 <language>요소를 모두 선택함.
ancestor-or-self::language : 현재 노드와 현재 노드의 조상 노드 중 <language>요소를 모두 선택함.
child::*/child::category   : 현재 노드의 자식 노드의 자식 노드 중 <category>요소를 모두 선택함.
```

다음 예제는 현재 노드의 자손 노드를 모두 선택하는 예제이다.

```jsx
path = "descendant::*";
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_xpath_pathExpression_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=xml_xpath_pathExpression_02)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XPath-c42bc463e3da4c2995887a2e2f3cce23
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xpath_pathExpression](http://www.tcpschool.com/xml/xml_xpath_pathExpression)
