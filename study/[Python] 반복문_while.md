# [Python] 반복문_while

**반복문(iteration statements)**

파이썬을 비롯한 대부분의 프로그래밍 언어에서는 반복해서 특정 명령이나 연산을 수행해야 할 
경우 사용할 수 있도록 반복문이라는 것을 제공한다. 반복문이란 프로그램 내에서 똑같은 명령을 
일정 횟수만큼 반복하여 수행하도록 제어해주는 명령문을 의미한다.

---

**while 문**

파이썬에서 가장 간단한 반복문은 while 문이다.
while 문은 조건식이 특정 조건을 만족할 때까지 계속해서 주어진 명령문을 반복 실행한다.

파이썬에서 while문은 다음과 같은 방식으로 사용할 수 있다.

*문법*

```python
while 조건식:
	조건식의 결과가 참인 동안 반복적으로 실행되는 명령문
```

다음은 while 문의 동작을 나타낸 흐름도이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d4e34a49-74e3-49be-bf32-2f8b89e4db05/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230117%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230117T032653Z&X-Amz-Expires=86400&X-Amz-Signature=f515e0e91d9ccfc3ba974d98fefd42879539d8091a840c338bb1a3d7c2149427&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

while 문을 만나나 프로그램은 가장 먼저 조건식(1)의 결과가 참인지를 검사한다. 
만약 조건식의 결과가 참이라면 프로그램의 프름은 while 문 내부에로 진입하면, 
만약 결과가 거짓이라면 while 문에 진입하지 않고 건너뛰게 된다.

while 문 내부로 진입한 프로그램은 내부에 포함된 모든 명령문(2)으르 실행하고 나서 또 다시 
조건식을 검사한다. 이렇게 조건을 검사하고 명령문을 모두 수행한 후 또 다시 조건식을 검사하는 
모양이 마치 고리와 같다고 하여 반복문을 루프(loop)라고도 부른다.

다음 예제는 앞서 살펴본 예제를 while 문을 사용하여 다시 구현한 예제이다.

```python
i = 1;

while i < 11:                 # 조건식
	print("파이썬" + str(i))
	i = i + 1                   # 탈출조건
```


---

**무한 루프(infinite loop)**

while 문의 동작에서 가장 중요한 것이 바로 조건식의 결과를 변경하는 명령문(3)이다.

while문에 진입하기 위해서는 조건식(1)의 결과가 참이어야 하는데, 이러한 조건식의 결과를 변경
하는 명령문(3)이 while 문 내부에 존재하지 않는다면, 조건식의 결과는 언제나 참으로 고정되므로 while 문은 영원히 반복될 것이다.
이렇게 영원히 반복되는 반복문을 무한 루프라고 하며, 무한 루프에 빠진 프로그램은 영원히 종료
되지 않는다.

반복문을 작성할 때 가장 많이 하는 실수가 바로 루프를 탈출하기 위한 명령문(3)을 실수로 작성하지 않거나 조건식을 원하는 대로 변경하는데 실패하는 경우이다. 이처럼 의도치 않게 발생한 무한 루프는 프로그램으르 정상적인 방법으로는 끝낼 수 없게 만들며, 결국엔 컴퓨터까지 멈추게 만들 수 있다.

따라서 while 문과 같은 반복문을 작성할 때는 조건식의 결과가 어느 순간에는 거짓으로 변경되도록 반드시 탈출조건(3)을 포함시켜야 한다.

이처럼 무한 루프는 특별히 의도한 경우가 아니라면 반드시 피해야 하는 상황이지만, 
프로그램을 만들다보면 상황에 따라 의도적으로 무한 루프를 사용하는 경우도 생긴다. 
파이썬에서는 무한 루프를 다음과 같이 의도적으로 만들 수 있으며, 이 때는 탈출 조건에 더욱 
신경 써야 한다.

*문법*

```python
while True:
	반복적으로 실행하고자 하는 명령문
									:
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/Python-_while-53683252b2a6426e89f3c25d9eecee59
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_flow_iteration](http://www.tcpschool.com/python2018/python_flow_iteration)
