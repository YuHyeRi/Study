# [jQuery] 이펙트효과_**jQuery.fx 객체**

### ***jQuery.fx 객체***

제이쿼리의 jQuery.fx 객체는 이펙트 효과가 구현되는 방버을 제어하는 다양한 프로퍼티를 
가지고 있다.

- jQeury.fx.speeds
- jQeury.fx.interval
- jQeury.fx.off

---

### ***jQuery.fx.speeds 프로퍼티***

jQuery.fx 객체의 ***speeds*** 프로퍼티는 *"slow", "normal", "fast"* 값을 가지고 효과의 속도를 나타낸다.
제이쿼리에서 제공하는 jQuery.fx.speed 프로퍼티의 기본값은 다음과 같다.

| 프로퍼티 값 | 밀리초 |
| --- | --- |
| fast | 200 |
| normal | 400 |
| slow | 600 |

이러한 속도의 기본값을 speeds 프로퍼티를 이용하여 변경할 수도 있다.

```jsx
$(function() {
    $("#toggleBtn").on("click", function() {
        // id가 "divBox"인 요소를 빠르게(0.2초에 걸쳐) 올라가면서 사라지거나 내려오면서 나타나게 함.
        $("#divBox").slideToggle("fast");
    });

    $("#setBtn").on("click", function() {
        // jQuery.fx 객체의 speeds 프로퍼티의 fast의 기본값을 1초로 변경함.
        jQuery.fx.speeds.fast = 1000;
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_jqueryfx_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_jqueryfx_01)

---

### ***jQuery.fx.interval 프로퍼티***

jQuery.fx 객체의 ***interval*** 프로퍼티는 이펙트 효과가 보여지는 동안의 초당 프레임 수를 나타냅니다.

연속적인 프레임에서의 초당 프레임 수는 13으로 설정되어 있다(기본).
이러한 초당 프레임 수를 interval 프로퍼티를 이용하여 사용 목적에 맞게 변경할 수 있다.

---

### ***jQuery.fx.off 프로퍼티***

jQuery.fx 객체의 ***off 프로퍼티를 true로 설정하면, 모든 이펙트 효과를 사용할 수 없게 됩니다.***

이렇게 이펙트 효과가 비활성화되면 이펙트 효과는 실행되지 않으며 이펙트 효과의 마지막 상태로
즉시 변경된다. off 프로퍼티는 특히 구형 버전의 브라우저를 다룰 때 유용하게 사용될 수 있다.

```jsx
$(function() {
    $("#toggleBtn").on("click", function() {
        // id가 "divBox"인 요소를 1초에 걸쳐 올라가면서 사라지거나 내려오면서 나타나게 함.
        $("#divBox").slideToggle(1000);
    });

    $("#forbidBtn").on("click", function() {
        // jQuery.fx 객체의 off 프로퍼티를 true로 설정함.
        jQuery.fx.off = true;
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_jqueryfx_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_jqueryfx_02)

---
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-_jQuery-fx-c9375c74db0c4021aa18330ab57e1123
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_effect_jqueryfx](http://www.tcpschool.com/jquery/jq_effect_jqueryfx)
