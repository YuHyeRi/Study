# [**DTD] DTD 개요**

**스키마(schema)**

XML은 다른 마크업 언어를 만드는데 사용되는 다목적 마크업 언어이다. 
이렇게 다른 언어를 정의하기 위해 먼저 해당 언어에 필요한 요소와 속성을 파악해야만 한다. 

이러한 정보들의 집합을 스키마(schema)라고 부른다. 
스키마는 일관성 있는 XML 문서를 유지하는데 아주 중요한 역할을 한다.

XML에서 스키마를 작성할 때에는 다음과 같이 두 가지 방법을 사용할 수 있다.

1. DTD (Document Type Definition)
2. XML 스키마 (XSD)

---

**문서 타입 정의(DTD)란?**

문서 타입 정의(DTD)는 XML 문서의 구조 및 해당 문서에서 사용할 수 있는 적법한 요소와 속성을 
정의한다. DTD는 엔티티를 정의할 수 있으며 빠른 개발을 위한 내부 DTD를 사용할 수 있다. 
DTD는 예전부터 사용해 온 구식 방법이지만 특유의 장점을 바탕으로 아직도 널리 사용되고 있다. 
이러한 DTD는 XML 문서 내부에 명시할 수도 있으며, 별도의 파일로 분리할 수도 있다.

---

**DTD의 사용 목적**

DTD를 사용하여 새로운 XML 문서의 구조를 정의함으로써 새로운 문서 타입을 만들 수 있다. 
이렇게 생성된 DTD는 새로운 문서 타입을 이용한 데이터의 교환에서 표준으로써 활용된다. 
또한 응용 프로그램은 DTD의 정의에 따라 XML 문서의 구문 및 구조에 대한 유효성을 검사할 수 
있다.

---

**DTD 문법**

XML에서 DTD를 작성하는 문법은 다음과 같다.

<aside>
💡 <!DOCTYPE 루트요소 DTD식별자 [ 선언1  선언2 ….]>

</aside>

DTD는 <!DOCTYPE 으로 시작한다. 
루트요소는 XML 파서에 명시된 루트 요소로부터 파싱을 시작하라고 알려주는 역할을 한다. 
DTD 식별자는 프로그램 외부에 존재하는 DTD 파일을 위한 식별자이다. 
만약에 DTD 식별자가 외부 주소를 가리키고 있으면 그것을 외부 서브셋(subset)이라고 한다. 
괄호([]) 안에는 내부 서브셋(subset)이라 불리는 추가로 선언한 엔티티의 리스트가 존재한다.

---

**DTD 내부 서브셋(subset)**

DTD가 XML 파일 내부에서 선언되면 그 선언은 반드시 <!DOCTYPE>안에 위치해야 한다.

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
<!DOCTYPE food [
<!ELEMENT food (name,type,cost)>
<!ELEMENT name (#PCDATA)>
<!ELEMENT type (#PCDATA)>
<!ELEMENT cost (#PCDATA)>
]>
<food>
    <name>상추</name>
    <type>야채</type>
    <cost>2000</cost>
</food>
```

위의 예제에서 !DOCTYPE food는 이 문서의 루트요소가 <food> 요소라는 사실을 명시한다. 
!ELEMENT food는 <food> 요소가 <name>, <type>, <cost>의 세 요소를 반드시 포함해야 한다는 
사실을 명시한다. 
!ELEMENT name은 <name>요소가 #PCDATA 타입의 요소라는 사실을 명시한다. 
!ELEMENT type은 <type>요소가 #PCDATA 타입의 요소라는 사실을 명시한다.
!ELEMENT cost은 <cost>요소가 #PCDATA 타입의 요소라는 사실을 명시한다.

---

**DTD 외부 서브셋(subset)**

DTD가 XML 파일 외부에서 선언되면 <!DOCTYPE>은 반드시 외부 DTD 파일의 주소 정보를 포함해야 한다. 이러한 외부 DTD 파일은 .dtd 확장자를 사용하여 저장한다.

*data.xml*

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE food SYSTEM "food.dtd">
<food>
    <name>상추</name>
    <type>야채</type>
    <cost>2000</cost>
</food>
```

*food.dtd*

```xml
<!ELEMENT food (name,type,cost)>
<!ELEMENT name (#PCDATA)>
<!ELEMENT type (#PCDATA)>
<!ELEMENT cost (#PCDATA)>
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/DTD-DTD-27c12e253649413289c47850bd08c412
<br>
👉 출처 : [http://www.tcpschool.com/xml/xml_dtd_intro](http://www.tcpschool.com/xml/xml_dtd_intro)
