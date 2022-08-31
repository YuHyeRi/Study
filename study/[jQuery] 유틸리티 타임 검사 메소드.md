# [jQuery] 유틸리티 타입 검사 메소드

### *유틸리티 메소드*

제이쿼리는 프로그래밍을 하는데 도움이 되는 다수의 유틸리티 메소드를 제공한다.

---

### *타입 검사 메소드*

제이쿼리는 인수로 전달받은 값의 타입을 손쉽게 확인해주는 다음과 같은 메소드를 제공한다.

- $.type()
- $.isArray()
- $.isFunction()
- $.isNumeric()
- $.isEmptyObject()
- $.isPlainObject()
- $.isWindow()
- $.isXMLDoc()

---

### ***$.type() 메소드***

자바스크립트의 typeof 연산자는 값에 따라 부정확하거나 모순된 타입 검사 결과를 반환한다.
그러나 제이쿼리는 전달받은 값을 자바스크립트 내부 클래스와 비교하여 더욱 정확한 타입 검사를 제공하는 $.type() 메소드를 제공한다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#text")
            .append($.type(true) + "<br>")                 // boolean
            .append($.type(new Boolean()) + "<br>")        // boolean
            .append($.type(100) + "<br>")                  // number
            .append($.type(new Number(20)) + "<br>")       // number
            .append($.type("문자열") + "<br>")             // string
            .append($.type(new String("홍길동")) + "<br>") // string
            .append($.type(function() {}) + "<br>")        // function
            .append($.type(new Function()) + "<br>")       // function
            .append($.type([]) + "<br>")                   // array
            .append($.type(/정규표현식/) + "<br>")         // regexp
            .append($.type(null) + "<br>");                // null
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_isMethod_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_isMethod_01)

---

### *특정 타입 검사 메소드*

제이쿼리는$.type() 메소드 뿐만 아니라 전달된 값이 특정 타입의 값인지 아닌지를 검사해주는 
다양한 메소드를 제공한다.

```jsx
$(function() {
    $("button").on("click", function() {
        $("#text")
            .html($.isArray([]) + "<br>")                           // true
            .append($.isArray(30) + "<br>")                         // false
            .append($.isFunction(new Function()) + "<br>")          // true
            .append($.isFunction("문자열") + "<br>")                // false
            .append($.isNumeric(100) + "<br>")                      // true
            .append($.isNumeric([7]) + "<br>")                      // false
            .append($.isEmptyObject({}) + "<br>")                   // true
            .append($.isEmptyObject({name: "홍길동"}) + "<br>")     // false
            .append($.isPlainObject(new Object()) + "<br>")         // true
            .append($.isPlainObject(new Object("문자열")) + "<br>") // false
            .append($.isWindow(window) + "<br>");                   // true
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_isMethod_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_utilityMethod_isMethod_02)

---

### *타입 검사 메소드*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/61eedea3-1acc-4659-b80b-427e300bff37/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220831%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220831T031856Z&X-Amz-Expires=86400&X-Amz-Signature=5fad97cc642a3ad144a9506c03945448550c96767e3ef47068aa8c939d043362&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-720d7e8bdaba492cac1dbf65c9fea9ff
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_utilityMethod_isMethod](http://www.tcpschool.com/jquery/jq_utilityMethod_isMethod)
