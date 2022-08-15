# [jQuery] 이펙트효과_슬라이드 효과

### *슬라이드 효과*

제이쿼리에서 슬라이드(slide) 효과는 해당 요소의 css height 속성값을 빠르게 변경하여 표현한다.
이러한 슬라이드 효과를 표현하기 위해 사용되는 메소드는 다음과 같다.

- slideUp()
- slideDown()
- slideToggle()

---

### *슬라이드 업(slideUp), 슬라이드 다운(slideDown)*

***sildeUp*** 메소드는 선택한 요소가 서서히 올라가면서 사라지는 효과를 보여준다. 
또한 ***slideDown*** 메소드는 선택한 요소가 서서히 내려오면서 나타나는 효과를 보여준다.

```jsx
$(function() {
    $("#slideUpBtn").on("click", function() {
        $("#divBox").slideUp();   // id가 "divBox"인 요소를 올라가면서 사라지게 함.
    });

    $("#slideDownBtn").on("click", function() {
        $("#divBox").slideDown(); // id가 "divBox"인 요소를 내려오면서 나타나게 함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_slide_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_slide_01)

인수로 밀리초에 해당하는 숫자나 ‘slow’, ‘fast’ 등의 예약어를 전달하여 슬라이드 효과의 속도를 
조절할 수도 있다.

```jsx
$(function() {
    $("#slideUpBtn").on("click", function() {
        $("#divBox").slideUp(500);   // id가 "divBox"인 요소를 0.5초에 걸쳐 올라가면서 사라지게 함.
    });

    $("#slideDownBtn").on("click", function() {
        $("#divBox").slideDown(300); // id가 "divBox"인 요소를 0.3초에 걸쳐 내려오면서 나타나게 함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_slide_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_slide_02)

---

### *슬라이드 효과의 토글*

제이쿼리에서는 선택한 요소의 현재 표시 상태에 따라 다른 동작을 하는 ***slideToggle*** 메소드를 사용할 수 있다. 선택한 요소가 현재 사라진 상태라면 slideDown 메소드의 동작을 수행하고, 나타나 있는 상태라면 slideUp 메소드의 동작을 수행한다.

```jsx
$(function() {
    $("#slideToggleBtn").on("click", function() {
        // id가 "divBox"인 요소를 빠르게 올라가면서 사라지거나 내려오면서 나타나게 함.
        $("#divBox").slideToggle("fast");
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_slide_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_slide_03)

---

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-_-6b04905c891e4e91a1c05bdd83a659e5
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_effect_slide](http://www.tcpschool.com/jquery/jq_effect_slide)
