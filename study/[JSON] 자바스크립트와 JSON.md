# [****JSON] 자바스크립트와 JSON****

JSON은 자바스크립트의 객체 표기법을 제한하여 만든 텍스트 기반의 데이터 교환 표준이다. 
따라서 JSON 데이터는 자바스크립트가 자주 사용되는 웹 환경에서 사용하는 것이 유리하다.

자바스크립트에서 JSON 데이터를 분석하고 사용하는 것은 매우 간단하다. 
자바스크립트는 JSON 데이터를 처리하기 위한 다음과 같은 메소드를 제공하고 있다.

1. JSON.stringify()
2. JSON.parse()
3. toJSON()

### **JSON.stringify() 메소드**

JSON.stringify() 메소드는 인수로 전달받은 자바스크립트 객체를 문자열로 변환하여 반환한다.

```jsx
JSON.stringify(value)
```

value에는 변환할 자바스크립트 객체를 전달한다. 
이 메소드는 UTF-16으로 인코딩된 JSON 형식의 문자열을 반환한다. 
JSON.stringify() 메소드를 지원하는 주요 웹 브라우저의 버전은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6e94d66c-5da1-46ee-a323-bb690837ac66/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220926%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220926T040543Z&X-Amz-Expires=86400&X-Amz-Signature=f537963dcc2004a9198a18fd097fa23d5e92190f4444955567125a640ecf5b36&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

```jsx
var dog = {name: "식빵", family: "웰시코기", age: 1, weight: 2.14}; // 자바스크립트 객체
var data = JSON.stringify(dog);                    // 자바스크립트 객체를 문자열로 변환함.

document.getElementById("json").innerHTML = data;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=json_use_js_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=json_use_js_01)

### **JSON.parse() 메소드**

JSON.parse() 메소드는 JSON.stringify() 메소드와는 반대로 
인수로 전달받은 문자열을 자바스크립트 객체로 변환하여 반환한다.

```jsx
JSON.parse(text)
```

text에는 변환할 문자열을 전달한다. 
이 때 해당 문자열은 반드시 유효한 JSON 형식의 문자열이어야 한다. 
만약 JSON 형식에 맞지 않는 문자열을 전달하면 자바스크립트는 오류를 발생시킬 것이다. 

JSON.parse() 메소드를 지원하는 주요 웹 브라우저의 버전은 다음과 같습니다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9e7ac9d9-8ba3-4f95-b013-e43f631311a0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220926%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220926T040601Z&X-Amz-Expires=86400&X-Amz-Signature=442810357087c145b4066fde75f64c0de06259c63a83a21fd7f5f87036db9823&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

```jsx
var data = '{"name": "식빵", "family": "웰시코기", "age": 1, "weight": 2.14}'; // JSON 형식의 문자열
var dog = JSON.parse(data);                       // JSON 형식의 문자열을 자바스크립트 객체로 변환함.

document.getElementById("json").innerHTML = dog + "<br>";
document.getElementById("json").innerHTML += dog.name + ", " + dog.family;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=json_use_js_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=json_use_js_02)

<aside>
💡 JSON.parse() 메소드는 오직 JSON 형식의 문자열만을 변환할 수 있다.

</aside>

### **toJSON() 메소드**

자바스크립트의 toJSON() 메소드는 자바스크립트의 Date 객체의 데이터를 JSON 형식의 문자열로 변환하여 반환한다. 
따라서 이 메소드는 Date.prototype 객체에서만 사용할 수 있다. 

toJSON() 메소드는 접미사 Z로 식별되는 UTC 표준 시간대의 날짜를 ISO 8601 형식의 문자열로 반환한다. 
따라서 이 문자열은 언제나 24개나 27개의 문자로 이루어지며, 다음과 같은 형식을 따른다.

```jsx
YYYY-MM-DDTHH:mm:ss.sssZ
또는
±YYYYYY-MM-DDTHH:mm:ss.sssZ
```

```jsx
var date = new Date();   // 자바스크립트 Date 객체
var str = date.toJSON(); // Date 객체를 JSON 형식의 문자열로 변환함.

document.getElementById("json").innerHTML = date + "<br>";
document.getElementById("json").innerHTML += str;
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=json_use_js_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=json_use_js_03)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/JSON-JSON-d1e497933f86437787e57f7bc51ecbc7
<br>
👉 출처 : [http://www.tcpschool.com/json/json_use_js](http://www.tcpschool.com/json/json_use_js)
