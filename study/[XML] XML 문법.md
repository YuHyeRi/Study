# [XML] XML 문법

**XML 선언**

XML 문서는 맨 첫줄에 <xml> 태그를 사용하여 XML 문서임을 명시해야 한다. 
이것을 XML 프롤로그라고 하며, 이 때 사용되는 <xml> 태그의 이름은 소문자 xml로만 사용해야 
한다.

XML 프롤로그의 문법은 다음과 같다.

```xml
<?xml version="XML문서버전" encoding="문자셋" standalone="yes|no"?>
```

version 속성에는 XML 문서에 사용된 XML의 버전을 명시한다.
encoding 속성에는 XML 문서의 문자셋(character set)을 명시하며, 기본값은 UTF-8로 설정된다.
standalone 속성은 XML 문서가 외부 DTD(Document Type Dofinition)와 같은 외부 소스의 데이터에 의존하고 있는 문서인지 아닌지를 XML 파서(parser)에 알려주는 역할을 한다.
이 속성의 기본값은 no이며, yes로 설정하면 이 문서를 파싱(parsing)할 때 참조해야 할 외부 소스가 없다는 것을 의미한다.

---

**XML 문법**

XML 문서는 매우 규칙적이고 예측할 수 있는 구조로 되어 있다. 
따라서 XML 문법은 배우기도 쉽고 사용하기도 쉽다.

1. 모든 XML 요소는 종료 태그를 가져야 한다.

HTML에서는 종료 태그를 생략하거나 빈 태그를 사용해도 대부분의 경우 문제 없이 동작한다. 
그러나 XML 에서는 XHTML과 마찬가지로 종료 태그가 생략되면 오류가 발생한다. 
또한, 빈 태그에도 반드시 슬래시(/)를 추가해야만 오류가 발생하지 않는다.

1. XML 태그는 대소문자를 구분한다.

HTML에서는 태그 이름에 대소문자를 구분하지 않는다. 그러나 XML에서는 태그 이름에 대소문자를 구분하므로 대소문자가 다르면 다른 요소로 인식한다.

```xml
<lecture>이 요소는 lecture 요소입니다.</lecture>
<Lecture>이 구문은 오류를 발생합니다.</lecture>
```

1. XML에서는 시작태그와 종료태그가 모두 대소문자까지 같아야 한다. 
XML에서는 태그 이름에 대소문자를 구분하므로, 시작태그와 종료태그의 대소문자가 모두 
같아야 한다.

1. XML 태그의 여닫는 순서는 반드시 지켜져야 한다. 
여닫는 순서가 지켜진다는 것은 먼저 열린 태그는 그 안의 모든 태그가 닫힌 후에야 닫힐 수 
있다는 뜻이다.

1. XML 에서 속성값은 반드시 따옴표로 감싸야 한다. 
HTML에서는 속성값을 따옴표로 감싸지 않아도 큰 문제 없이 동작한다. 
그러나 XML 에서는 속성값을 따옴표로 감싸지 않으면 오류가 발생한다.

```xml
<student name=홍길동>   // 오류가 발생함.
<student name="이순신"> // 정상적으로 동작함.
```

1. XML 에서는 띄어쓰기를 인식한다. 
HTML에서는 띄어쓰기를 따로 인식하지 않는다. 
그러나 XML에서는 여러 번의 띄어쓰기를 그대로 인식한다.

```xml
코드 : <p>띄   어 쓰    기</p>
HTML : 띄어쓰기
XML  : 띄   어 쓰    기
```

---

**XML 엔티티(Entity)**

XML에서는 예약되어 있는 다섯 개의 특별한 기호가 있다. 이렇게 예약되어 있는 기호를 XML문서에서 사용하면 XML 파서(해석하는 기계)는 그것을 전혀 다른 의미로 해석한다. 
따라서 이렇게 예약된 기호를 기존에 사용하던 의미 그대로 사용하기 위해서 만든 문자셋을 엔티티라고 한다.

HTML에서는 수많은 문자와 기호를 엔티티로 미리 정의해놓고 사용하고 있다. 
그러나 XML에서 제공하는 엔티티는 다섯 개 뿐이다.

다음 표는 XML에서 예약되어 있는 기호와 그에 따른 엔티티를 보여준다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f0343b36-3746-4efc-8527-8fce62ca0f84/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221001%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221001T021114Z&X-Amz-Expires=86400&X-Amz-Signature=8ccd73d130d5f9188cca51de4ac445feab9ceeedcaf0003791a11980f8337b1b&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br><br>
👉 노션 : https://www.notion.so/tgmary09/XML-XML-85ac73fd48eb4ce3bd786a802a10c1d0
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_basic_syntax](http://www.tcpschool.com/xml/xml_basic_syntax)
