# [**XPath] 필터 표현식**

**필터 표현식(filter expressions)**

XPath에서는 특정 노드나 특정 값을 포함하는 노드를 선택하기 위해 필터 표현식을 사용한다.
필터 표현식은 언제나 대괄호([])안에 표현된다. 

이러한 필터 표현식에 XPath 함수를 사용하면 더욱 자세한 필터링을 할 수 있다.

*예제*

```xml
p_languages/language[1]              : <p_languages>요소의 자식 노드 중 첫 번째 <language>요소를 선택함.
p_languages/language[position() < 3] : <p_languages>요소의 자식 노드 중 처음 두 개의 <language>요소를 선택함.
p_languages/language[last()]         : <p_languages>요소의 자식 노드 중 마지막 <language>요소를 선택함.
//priority[@rating]                  : rating 속성을 가지고 있는 <priority>요소를 모두 선택함.
//priority[@rating = 3]              : rating 속성의 속성값이 3인 <priority>요소를 모두 선택함.
count(//language)                    : 모든 <language>요소의 개수를 반환함.
```

---

**XPath 함수**

XPath 함수는 선택된 노드셋을 평가하여 조건에 맞는 노드를 시퀀스 형태로 반환한다.

가장 많이 사용되는 XPath 함수는 다음과 같다.

| XPath 함수 | 설명 |
| --- | --- |
| position() | 현재 노드셋 안에서의 노드의 위치를 반환함 |
| last() | 현재 노드셋의 마지막 노드를 반환함 |
| count(위치경로) | 지정된 노드셋의 총 노드 개수를 반환함 |
| name() | 현재 노드의 이름을 반환함 |
| name(위치경로) | 지정된 노드셋의 첫 번째 노드를 반환 |

XPath 함수에 대한 더 자세한 정보를 원한다면 W3C 공식 사이트를 방문하여 확인할 수 있다.

[XPath and XQuery Functions and Operators 3.1 =>](https://www.w3.org/TR/xpath-functions-31/)

---

**임의 문자 기호(wild card)**

XPath에서는 임의의 노드를 선택하기 위해 임의 문자 기호를 사용할 수 있다.

| 임의 문자 기호 | 설명 |
| --- | --- |
| * | 어떠한 요소 노드와도 일치함 |
| @* | 어떠한 속성 노드와도 일치함 |
| node() | 어떠한 종류의 어떤 노드와도 일치함 |
| text() | 어떠한 텍스트 노드와도 일치함 |

*예제*

```xml
../*           : 현재 노드의 부모 노드의 자식 요소 노드를 모두 선택함.
//*            : 현재 문서의 모든 요소 노드를 선택함.
//priority[@*] : 어떠한 종류의 속성 노드라도 적어도 하나 이상 가지고 있는 <priority>요소를 모두 선택함.
```

---

**연산자(operator)**

XPath 표현식에서 사용할 수 있는 대표적인 연산자는 다음과 같다.

| 연산자 | 설명 | 반환 타입 |
| --- | --- | --- |
| - | 음의 부호 (단항 연산자) | 숫자(number) |
| *, div, mod | 곱셈, 나눗셈, 나머지 연산 | 숫자(number) |
| +, - | 덧셈, 뺄셈 | 숫자(number) |
| <, <=, >, > = | 비교 연산 | 불리언 |
| =, ! = | 등가 비교 연산 | 불리언 |
| and | 논리 AND 연산 | 불리언 |
| or | 논리 OR 연산 | 불리언 |
| | | 여러 개의 노드셋을 동시에 계산함 | 노드셋 |

*예제*

```xml
//language/name | //language/version  : 모든 <language>요소의 <name>요소와 <version>요소를 모두 선택함.
//name | //version                    : 현재 문서의 <name>요소와 <version>요소를 모두 선택함.
/language/version/@status | //version : <language>요소의 <version>요소의 status 속성을 모두 선택하고,
                                        현재 문서의 <version>요소도 모두 선택함.
```

<aside>
💡 위의 표에서 연산자의 우선순위는 아래에서부터 위쪽으로 증가한다. 
즉, 맨 위의 음의 부호가 가장 우선순위가 높으며, | 연산자가 가장 우선순위가 낮다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/XPath-c204fb0f6bd642648d850e4ba732c918
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_xpath_filterExpression](http://www.tcpschool.com/xml/xml_xpath_filterExpression)
