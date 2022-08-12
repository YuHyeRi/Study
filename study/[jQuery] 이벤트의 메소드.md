# [jQuery] 이벤트의 메소드

### *이벤트 메소드*

제이쿼리는 on 메소드 이외에도 자바스크립트 이벤트와 관련된 다양한 메소드를 제공한다. 
이러한 이벤트 메소드는 이벤트가 발생하는 요소에 따라 다음과 같이 구분할 수 있다.

- 마우스 이벤트와 관련된 메소드
- 키보드 이벤트와 관련된 메소드
- 입력 양식(form) 이벤트와 관련된 메소드

---

### *❤️ 마우스 이벤트와 관련된 메소드*

- **dbclick**
    - dbclick 메소드는 자바스크립트의 dbclick 이벤트와 이벤트 핸들러를 연결하거나, 
    해당 요소에 dbclick 이벤트를 발생시킨다.
    - 
    
    ```jsx
    $(function() {
        $("button").click(function() {    // 모든 <button>요소에 click 이벤트를 설정함.
            $("#clickText").css("color", "red");
            $("#dblclickText").css("color", "black");
        });
    
        $("button").dblclick(function() { // 모든 <button>요소에 dblclick 이벤트를 설정함.
            $("#dblclickText").css("color", "red");
            $("#clickText").css("color", "black");
        });
    });
    ```
    
    [http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_method_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_method_01)
    
- **hover**
    - hover 메소드는 자바스크립트의 mouserenter와 mouseleave 이벤트를 같이 이벤트 핸들러와 연결한다.
    - 
    
    ```jsx
    $(function() {
        $("button").hover(function() { // 모든 <button>요소에 hover 이벤트를 설정함.
            $("#text").append("마우스가 버튼 위로 진입하거나 빠져나갔어요!<br>");
        });
    });
    ```
    
    [http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_method_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_method_02)
    


---

### *❤️ 키보드 이벤트와 관련된 메소드*

- **keypress**
    - keypress 메소드는 자바스크립트의 keypress 이벤트와 이벤트 핸들러를 연결한다.
    - 다음 예제는 input 요소에 키보드로 문자를 입력할 때마다 입력한 문자에 해당하는 유니코드 숫자를 출력하는 예제이다.
    - 
    
    ```jsx
    $(function() {
        // 아이디가 "key"인 요소에 keypress 이벤트를 설정함.
        $("#key").on("keypress", function(event) {
            $("#str").html(event.type + " : " + event.which);
        });
    });
    ```
    
    [http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_method_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_method_03)
    
    <aside>
    💡 Shift, Esc, Delete와 같은 화면은 화면에 출력되지 않는 키(modifier and non-printing keys)들은 keydown 이벤트를 발생시키지만 keypress 이벤트는 발생시키지 않는다.
    
    </aside>
    
    
    ---
    

### *❤️ 입력 양식(form) 이벤트와 관련된 메소드*

- **focusin, focusout**
    - focusin 메소드는 자바스크립트의 focusin 이벤트와 이벤트 핸들러를 연결한다.
    - focusout 메소드는 자바스크립트의 focusout 이벤트와 이벤트 핸들러를 연결한다.
    - 
    
    ```jsx
    $(function() {
        // 아이디가 "focus"인 요소에 focusin 이벤트를 설정함.
        $("#focus").on("focusin", function(event) {
            $(this).css("backgroundColor", "yellow");
        });
    
        // 아이디가 "focus"인 요소에 focusout 이벤트를 설정함.
        $("#focus").on("focusout", function(event) {
            $(this).css("backgroundColor", "white");
        });
    });
    ```
    
    [http://www.tcpschool.com/examples/tryit/tryhtml.phpfilename=jq_event_method_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_event_method_04)
    
    <aside>
    💡 this 키워드는 현재 선택되어 있는 요소 그 자체를 가리킨다.
    
    </aside>
    
    
    <br><br>
    👉 노션 : https://www.notion.so/tgmary09/jQuery-8a706c669ad7457488d73e5304272aa9
    <br>
    👉 출처 : [http://www.tcpschool.com/jquery/jq_event_method](http://www.tcpschool.com/jquery/jq_event_method)
