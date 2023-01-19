# [Python] break, continue

**break 키워드로 반복문 탈출하기**

반복문을 통해 명령문을 반복해서 수행하다보면 프로그램의 흐름상 특정 조건을 만족할 때 더 이상 반복문을 수행하지 않고 그 즉시 해당 반복문을 빠져나가야 할 경우가 생긴다. 이러한 경우에는 break 키워드를 사용하여 반복 조건에 상관없이 가장 가까운 반복문을 즉시 탈출할 수 있다.

다음 예제는 구구단을 5단 까지만 출력하도록 한 예제이다.

```python
for col in range(2,10):
	if col > 5:
		break
	for row in range(1,10):
		print(col, "x", row, "=", col*row)
```

위의 예제에서 구구단을 5단까지 출력한 후 변수 col에는 정수 6이 대입된다. 
따라서 2번 라인의 if 문의 조건식을 만족하게 되어 3번 라인의 break 키워드가 실행된다. 
break 키워드를 만난 프로그램은 그 즉시 가장 가까운 반복문(1번 라인의 for 문)을 탈출하게 되며, 
예제 프로그램은 곧바로 종료된다.

---

**continue 키워드로 처음으로 되돌아가기**

break 키워드가 해당 반복문 전체를 빠져나가게 해준다면, continue 키워드는 해당 루프만을 
즉시 종료하고 다음 루프를 실행시킨다.
즉, continue 키워드는 해당 키워드 바로 다음 명령문부터 해당 반복문의 마지막 명령문까지를 모두 건너뛰고 바로 다음 반복을 실행하는 것이다.

다음은 1부터 10 까지의 정수 중 홀수만을 출력하는 예제이다.

```python
for n in range(1,11):
	if n % 2 == 0:
		continue
	print(n, "은 홀수이다.")
```

위의 예제 2번 라인의 if문에서 변수 n을 2로 나눈 나머지가 0인 경우는 n이 짝수인 경우이다.
즉, n이 짝수이면 그 즉시 해당 반복을 중지하고 n의 크기를 1 증가시킨 후 2번 라인부터 다시 조건식을 검사하게 된다.

<br><br>
👉 https://www.notion.so/tgmary09/Python-break-continue-c91399c1425346c897ed520759be93fd
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_flow_ect](http://www.tcpschool.com/python2018/python_flow_ect)
