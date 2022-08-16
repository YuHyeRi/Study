# [jQuery] 이펙트효과_이펙트 효과의 제어

### *이펙트 효과의 제어*

제이쿼리에서는 다음 메소드를 사용하여 사용자가 직접 이펙트 효과를 제어할 수 있다.

- delay
- stop
- finish

---

### *이펙트 효과의 지연 설정*

***delay*** 메소드는 실행 중인 큐 안에서 연속적으로 실행되는 이펙트 효과 사이의 
지연 시간을 설정한다.

다음 예제는 페이드 아웃 효과와 페이드 인 효과 사이에 1초의 지연시간을 설정하는 예제이다.

```jsx
$(function() {
    $("#startBtn").on("click", function() {
        // id가 "divBox"인 요소를 0.5초에 걸쳐 사라지게 하고
        // 1초의 지연시간 뒤에 다시 2초에 걸쳐 나타나게 함.
        $("#divBox").fadeOut(500).delay(1000).fadeIn(2000);
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_effectHandling_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_effectHandling_01)

---

### *이펙트 효과의 중지*

제이쿼리에서는 stop 메소드와 finish 메소드를 사용하여 실행 중인 이펙트 효과를 중지시킬 수 있다.

***stop*** 메소드는 선택한 요소에서 실행 중인 모든 이펙트 효과를 중지 시킨다.
***finish*** 메소드는 거기에 더해 *선택한 요소가 포함된 큐까지 제거하여 모든 이펙트 효과를 전부 종료*시킨다.

```jsx
$(function() {
    $("#toggleBtn").on("click", function() {
        // id가 "divBox"인 요소를 2초에 걸쳐 올라가면서 사라지거나 내려오면서 나타나게 함.
        $("#divBox").slideToggle(2000);
    });

    $("#stopBtn").on("click", function() {
        // id가 "divBox"인 요소에서 실행 중인 모든 이펙트 효과를 즉시 중지시킴.
        $("#divBox").stop();
    });

    $("#finishBtn").on("click", function() {
        // id가 "divBox"인 요소에서 실행 중인 모든 이펙트 효과를 즉시 중지시키고, 그 큐까지 모두 제거함.
        $("#divBox").finish();
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_effectHandling_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_effectHandling_02)

---

<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-_-cb838472f821415c8f5bac6490889383
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_effect_effectHandling](http://www.tcpschool.com/jquery/jq_effect_effectHandling)
