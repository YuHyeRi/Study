# [jQuery] 이펙트효과_페이드 효과

### *페이드 효과*

제이쿼리에서 페이드(fade) 효과는 해당 요소의 css *opacity* 속성값을 빠르게 변경하여 표현한다.
이러한 페이드 효과를 표현하기 위해 사용되는 메소드는 다음과 같다.

- fadeIn()
- fadeOut()
- fadeTo()
- fadeToggle()

---

### *페이드 인(fade in), 페이드 아웃(fade out)*

***fadeIn*** 메소드는 선택한 요소를 서서히 사라지게 하고, ***fadeOut*** 메소드는 서서히 나타나게 한다.

```jsx
$(function() {
    $("#fadeInBtn").on("click", function() {
        $("#divBox").fadeIn();  // id가 "divBox"인 요소를 점점 나타나게 함.
    });

    $("#fadeOutBtn").on("click", function() {
        $("#divBox").fadeOut(); // id가 "divBox"인 요소를 점점 사라지게 함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_01)

위의 예제처럼 페이드 아웃 효과가 끝나게 되면 해당 요소는 웹 페이지의 레이아웃에서 완전히 
사라지게 된다.

인수로 밀리초에 해당하는 숫자나 ‘slow’, ‘fast’ 등의 예약어를 전달하여 페이드 효과의 속도를 조절할 수도 있다.

```jsx
$(function() {
    $("#fadeInBtn").on("click", function() {
        $("#divBox").fadeIn("slow"); // id가 "divBox"인 요소를 느리게 점점 나타나게 함.
    });

    $("#fadeOutBtn").on("click", function() {
        $("#divBox").fadeOut(2000);  // id가 "divBox"인 요소를 2초에 걸쳐 점점 사라지게 함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_02)

---

### *페이지 효과의 토글*

제이쿼리에서는 선택한 요소의 현재 표시 상태에 따라 다른 동작을 하는 ***fadeToggle*** 메소드를 
사용할 수 있다. 선택한 요소가 현재 사라진 상태라면 fadeIn 메소드의 동작을 수행하고, 나타나 있는
상태라면 fadeOut 메소드의 동작을 수행한다.

```jsx
$(function() {
    $("#fadeToggleBtn").on("click", function() {
        // id가 "divBox"인 요소를 1초에 걸쳐 점점 나타나게 하거나 사라지게 함.
        $("#divBox").fadeToggle(1000);
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_03)

---

### *페이드 효과의 투명도 설정*

***fadeTo*** 메소드를 사용하면 페이드 효과에서 사용하는 최종 opacity 속성값을 직접 설정할 수 있다.

```jsx
$(function() {
    $("#fadeBtn").on("click", function() {
        // id가 "divBox_01"인 요소를 2초에 걸쳐 opacity 속성값을 0.2까지만 변경시킴.
        $("#divBox_01").fadeTo(2000, 0.2);

        // id가 "divBox_02"인 요소를 2초에 걸쳐 opacity 속성값을 0.5까지만 변경시킴.
        $("#divBox_02").fadeTo(2000, 0.5);

        // id가 "divBox_03"인 요소를 2초에 걸쳐 opacity 속성값을 0.8까지만 변경시킴.
        $("#divBox_03").fadeTo(2000, 0.8);
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_04](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_fade_04)

---

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-_-60cc136091d24672b3a51e44bf958ee2
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_effect_fade](http://www.tcpschool.com/jquery/jq_effect_fade)
