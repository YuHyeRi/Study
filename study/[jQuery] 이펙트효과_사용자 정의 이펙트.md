# [jQuery] 이펙트효과_**사용자 정의 이펙트**

### ***animate**메소드*

제이쿼리에서 animate 메소드를 이용하여 사용자가 직접 원하는 이펙트 효과를 정의할 수 있다.
animate 메소드는 여러 css 속성을 이용하여 새로운 이펙트 효과를 만들어준다.

animate 메소드의 원형은 다음과 같다.

```jsx
$(선택자).animate(프로퍼티[,지속시간][,시간당속도함수][,콜백함수]);
```

***프로퍼티 파라미터***는 ***필수***이며 이펙트 효과를 구성할 css 속성을 정의한다.
***지속시간***은 이펙트 효과가 지속될 시간을 전달한다.
***시간당 속도 함수(easing function)***는 이펙트 효과의 시간당 속도를 전달한다.
***콜백 함수***는 이펙트 효과의 동작이 완료된 후에 실행할 함수를 정의한다.

```jsx
$(function() {
    $("#animateBtn").on("click", function() {
        $("#divBox").animate(    // id가 "divBox"인 요소를
            {
                left: "+=100",   // 오른쪽으로 100픽셀 이동하고,
                opacity: 0.2     // 투명도를 0.2로 변경함.
            }, 500, function() { // 0.5초에 걸쳐서 이펙트 효과가 진행됨.
                $("#text").html("사용자 정의 이펙트가 실행됐어요!");
            }
       );
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_customEffect_01](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_customEffect_01)

---

### *.animate() 메소드 - 사용할 수 있는 CSS 속성*

animate 메소드는 색에 관한 속성을 제외한 거의 모든 css 속성을 사용할 수 있다.
css 메소드에서는 하이픈(-)으로 연결된 css 속성명과 camelCase 방식으로 바꾼 속성명을 둘 다 사용할 수 있다. 그러나 *animate 메소드에서는 **camelCasl** 방식의 속성명만 사용할 수 있다.*
animate 메소드에서 사용할 수 있는 css 속성은 다음과 같다.

- backgroundPositionX
- backgroundPositionY
- borderWidth
- borderBottomWidth
- borderLeftWidth
- borderRightWidth
- borderTopWidth
- borderSpacing
- margin
- marginBottom
- marginLeft
- marginRight
- marginTop
- outlineWidth
- padding
- paddingBottom
- paddingLeft
- paddingRight
- paddingTop
- height
- width
- maxHeight
- maxWidth
- minHeight
- minWidth
- fontSize
- bottom
- left
- right
- top
- letterSpacing
- wordSpacing
- lineHeight
- textIndent

---

### ***.animate() 메소드 - 미리 정의된 값***

animate 메소드는 css 속성값으로 미리 정의된 다음 값을 사용할 수 있다.

- show
- hide
- toggle

```jsx
$(function() {
    $("#animateBtn").on("click", function() {
        $("#divBox").animate({
            height: "toggle" // CSS height 속성값을 미리 정의된 "toggle"로 설정함.
        });
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_customEffect_02](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_customEffect_02)

---

### ***.animate() 메소드 - 시간당 속도 함수***

animate 메소드는 시간당 속도 함수를 사용하여 이펙트 효과의 시간당 속도를 설정할 수 있다.

```jsx
$(function() {
    $("#divBox").mouseenter( function() {
        $(this).stop().animate({
            width: "300px"  // CSS width 프로퍼티의 값을 "300px"로 설정함.
        }, 1000, "linear"); // 시간당 속도 함수를 "linear"으로 설정함.
    });

    $("#divBox").mouseleave( function() {
        $(this).stop().animate({
            width: "50px"   // CSS width 프로퍼티의 값을 "50px"로 설정함.
        }, 1000, "swing");  // 시간당 속도 함수를 "swing"으로 설정함.
    });
});
```

[http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_customEffect_03](http://www.tcpschool.com/examples/tryit/tryhtml.php?filename=jq_effect_customEffect_03)
<br><br>
👉 노션 : https://www.notion.so/tgmary09/jQuery-_-a1d44722040a44958725ac61ee036b3b
<br>
👉 출처 : [http://www.tcpschool.com/jquery/jq_effect_customEffect](http://www.tcpschool.com/jquery/jq_effect_customEffect)
