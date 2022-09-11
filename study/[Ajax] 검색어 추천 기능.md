# [Ajax] 검색어 추천 기능

### *검색어 추천 기능*

검색어를 입력하면 입력된 단어에 맞춰 적절한 검색어를 추천해주는 기능은 현재 대부분의 사이트에서 사용되고 있다. Ajax를 이용하면 이러한 기능을 어렵지 않게 구현할 수 있다. 

이번에는 제이쿼리와 Ajax를 이용하여 간단한 검색어 추천 기능을 구현해 보도록 하겠다.

---

### *검색어 추천 기능의 동작 순서*

검색어 추천은 검색어를 입력하는 도중에 입력된 검색어와 유사한 검색어를 화면에 표시해주는 
기능이다. 따라서 다음과 같은 순서대로 동작하게 된다.

1. 입력된 검색어를 Ajax 요청으로 서버에 전송함 👉 클라이언트 측
2. 서버에서는 전송된 검색어를 이용하여 추천 검색어 목록을 작성함 👉 서버 측
3. 작성된 추천 검색어 목록을 Ajax 응답으로 클라이언트에 전송함 👉 서버 측
4. Ajax 응답으로 온 추천 검색어 목록을 처리하여 화면에 출력함 👉 클라이언트 측

---

### *클라이언트 측 작업*

클라이언트 측에서 가장 먼저 해야할 일은 사용자로부터 입력을 받는 것이다. 
사용자로부터 입력을 받기 위해서는 다음과 같이 input 요소를 사용한다. 
아래쪽의 div 요소는 응답으로 받은 추천 검색어 목록을 출력할 화면이다.

**ajax_application_suggestion_01.html**

```html
<form action="/examples/media/request.php">
    <input id="search_box" type="text" name="city" size="20">
    <div id="suggestion_box"></div>
</form>
```

그 다음으로는 사용자가 입력한 검색어를 서버로 전송하고 응답으로 받은 추천 검색어 목록을 화면에 출력하는 것이다.

이 부분은 제이쿼리의 $.ajax 메소드를 이용하여 다음과 같이 Ajax 요청과 응답을 구현한다.

**ajax_application_suggestion_01.html**

```jsx
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<script>
    $(function() {   // <input>요소에 문자가 입력될 때마다 호출됨.
        $("#search_box").keyup(function() {
            $.ajax({ // Ajax 요청을 작성하고 GET 방식으로 전송함.
                url: "/examples/media/ajax_suggestion.php",
                data: { keyword : $(this).val() },
                method: "GET"
            })       // Ajax 응답을 정상적으로 받으면 실행됨.

            .done(function(result) {
                $("#suggestion_box").html(result);
            })
        })
    });
</script>
```

제이쿼리에서 ***keyup*** 메소드를 이용하면 input 요소에 문자가 하나씩 입력될 때마다 매번 Ajax 요청을 보낼 수 있다. 
그리고 ***done*** 메소드를 이용하면 Ajax 응답이 성공적으로 수신되면 실행할 콜백함수를 명시할 수 
있다.

---

### *서버 측 작업*

서버 측에서 해야할 일은 Ajax 요청과 함게 전달받은 검색어를 XML 파일에서 찾아 비교하여 
추천 목록을 작성하는 것이다. 이 때 가장 먼저 해야할 일은 비교할 XML 파일을 로드하는 것이다.

**ajax_suggestion.php**

```php
$xmlData = new DOMDocument();
$xmlData->load("korean_city_names.xml"); // XML 파일을 로드함.
```

이 수업에서 사용할 XML 파일은 다음과 같다.

**korean_city_names.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>

<korean_cities>
    <city><name>Andong</name></city>
    <city><name>Ansan</name></city>
    <city><name>Anseong</name></city>
    <city><name>Anyang</name></city>
    <city><name>Asan</name></city>
    ...
</korean_cities>
```

그리고서 사용자가 입력한 검색어와 비교할 요소들을 선택한다.

**ajax_suggestion.php**

```php
// 로드한 XML 문서에서 태그 이름이 "name"인 모든 요소를 선택함.
$names = $xmlData->getElementsByTagName("name");

// Ajax 요청으로 전달받은 keyword 헤더의 값을 반환함.
$keyword = $_GET["keyword"];
```

이렇게 선택된 요소들과 사용자가 입력한 검색어를 순서대로 비교하여 일치하는 값만을 추천 목록에 추가하면 된다.

**ajax_suggestion.php**

```php
$result = "";

for ($i = 0; $i < ($names->length); $i++) {
    if (!empty($keyword)) { // 아무런 입력이 없을 때를 제외함.
        $wordLength = strlen($keyword);

        // <name>요소의 텍스트 노드값을 반환함.
        $name = $names->item($i)->childNodes->item(0)->nodeValue;
        
				// 사용자가 입력한 글자 수만큼만 비교함.
        if (strcasecmp(substr($name, 0, $wordLength), $keyword) == 0) {
            $result .= $name.nl2br("\n");
        }
    }
}
echo $result;
```

strlen, strcasecmp, substr 함수의 사용법에 대한 더 자세한 사항은 PHP 문자열 관련 함수 수업에서 확인할 수 있다.

[PHP 문자열 관련 함수 수업 확인 =>](http://www.tcpschool.com/php/php_builtInFunction_string)

---

### ***검색어 추천 Ajax 예제***

위와 같은 순서대로 작성된 간단한 검색어 추천 예제는 다음과 같다.

```jsx
<head>
    <meta charset="UTF-8">
    <title>Ajax Suggestion</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
        $(function() {   // <input>요소에 문자가 입력될 때마다 호출됨.
            $("#search_box").keyup(function() {
                $.ajax({ // Ajax 요청을 작성하고 GET 방식으로 전송함.
                    url: "/examples/media/ajax_suggestion.php",
                    data: { keyword : $(this).val() },
                    method: "GET"
                })       // Ajax 응답을 정상적으로 받으면 실행됨.

                .done(function(result) {
                    $("#suggestion_box").html(result);
                })
            })
        });
    </script>
</head>
<body>
    <h1>검색어 추천 기능</h1>
    <p>대한민국의 도시를 영문으로 찾아보세요!</p>
    <form action="/examples/media/request.php">
        <input id="search_box" type="text" name="city" size="20">
        <div id="suggestion_box"></div>
    </form>
</body>
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_application_suggestion_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=ajax_application_suggestion_01)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/Ajax-a94dc9df71c94bc7838495779c034e05
<br>
👉 출처 : [http://www.tcpschool.com/ajax/ajax_application_suggestion](http://www.tcpschool.com/ajax/ajax_application_suggestion)
