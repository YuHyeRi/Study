# [서버와의통신] **XMLHttpRequest 객체**

### ***XMLHttpRequest 객체***

Ajax의 가장 핵심적인 구성 요소는 바로 XMLHttpRequest 객체이다. 
Ajax에서 XMLHttpRequest 객체는 *웹 브라우저가 서버와 데이터를 교환할 때 사용된다.* 
웹 브라우저가 백그라운드에서 계속해서 *서버와 통신할 수 있는 것*은 바로 이 객체를 사용하기 
때문이다.

---

### ***XMLHttpRequest 객체의 역사***

비동기식 통신 방식인 XMLHttp는 가장 처음으로 익스플로러5 버전에서 ActiveXObject 라는 객체를 사용하여 구현된다. 
그 후에 모질라와 사파리에서 XMLHttpRequest 라는 이름으로 도입하여 널리 사용되기 시작한다. 

초기의 XMLHttpRequest 객체는 W3C 표준이 아니었기 때문에 웹 브라우저마다 구현상의 차이가 
존재했다. 그러나 익스플러로 7 버전부터 XMLHttpRequest 객체를 기본적으로 지원하게 되며, 
W3C 표준으로도 제정되게 된다. 

따라서 현재 대부분의 웹 브라우저는 모두 비슷한 구현 방식으로 XMLHttpRequest 객체를 사용하고 있다.

---

### *XMLHttpRequest 객체의 생성*

현재 대부분의 웹 브라우저는 XMLHttpRequest 객체를 내장하고 있다. 
이러한 XMLHttpRequest 객체를 생성하는 방법은 브라우저의 종류에 따라 다음과 같이 나눠진다.

1. XMLHttpRequest 객체를 이용한 방법
2. ActiveXObject 객체를 이용한 방법

익스플로러 7과 그 이상의 버전, 크롬, 파이어폭스, 사파리, 오페라에서는 XMLHttpRequest 객체를 
사용한다.

```jsx
var 변수이름 = new XMLHttpRequest();
```

그러나 익스플로러의 구형 버전인 5와 6 버전에서는 ActiveXObject 객체를 사용해야 한다.

```jsx
var 변수이름 = new ActiveXObject("Microsoft.XMLHTTP");
```

따라서 모든 웹 브라우저에서 XMLHttpRequest 인스턴스를 제대로 생성하기 위해서는 다음과 같이 작성해야 한다.

```jsx
var httpRequest;

function createRequest(){
	if(window.XMLHttpRequest){      // 익스플로러 7과 그 이상의 버전, 크롬, 파이어폭스, 사파리, 오페라 등
		return new XMLHttpRequest();
	} else {                        // 익스플로러 6과 그 이하의 버전
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_server_xmlhttprequest_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_server_xmlhttprequest_01)

*하지만 현재 익스플로러 6과 그 이하 버전을 사용하는 사용자는 거의 없으므로 
여기서는 다음과 같이 XMLHttpRequest 객체만을 사용할 것이다.*

```jsx
var httpRequest = new XMLHttpRequest();
```
<br><br>
👉 노션 : https://www.notion.so/tgmary09/XMLHttpRequest-695679a86fe74eae81c46030f062f309
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_server_xmlhttprequest](http://www.tcpschool.com/ajax/ajax_server_xmlhttprequest)
