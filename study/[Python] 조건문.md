# [Python] 조건문

**조건문(conditional statements)**

다음 그림은 ‘달면 삼키고 쓰면 뱉는다.’는 속담을 순서도(flow chart)로 작성해본 것이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/39f9dc47-3369-4873-bfb1-18abf7d67080/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230116%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230116T033136Z&X-Amz-Expires=86400&X-Amz-Signature=baca878890302095b5960b58832bb2a221efdf8ab014a5f3c5c8c93516072207&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

순서도에 따르면 조건인 맛(taste)에 따라 달면 삼키고, 달지 않으면 뱉는 서로 다른 행동을 취하게 
된다. 이처럼 조건문이란 주어진 조건식의 결과에 따라 다른 명령을 수행하도록 프로그램의 흐름을 제어하는 명령문을 의미한다.

---

**if-else문**

파이썬에서는 조건 분기를 표현하기 위해 if-else문을 사용한다.

*문법*

```python
if 조건식:
	조건식의 결과가 참일 때만 실행되는 명령문
else:
	조건식의 결과가 거짓일 때만 실행되는 명령문
```

if-else문은 if 키워드 뒤에 위치한 조건식의 결과에 따라 실행되는 명령문이 달라진다.
조건식의 결과가 참인 경우에는 if 문 바로 다음의 명령문들이 실행되며,
else 문 다음의 명령문들은 실행되지 않는다.
반대로 조건식의 결과가 거짓인 경우에는 else 문 바로 다음 명령문들이 실행되며, 
if 문 바로 다음의 명령문들은 실행되지 않는다.

파이썬에서 블록(block)은 콜론(:)으로 시작하여 동일한 들여쓰기 구간을 의미하므로, 
if 키워드와 else 키워드의 맨 끝에도 반드시 콜론(:)을 삽입해야 한다.

<aside>
💡 if 문은 단독으로도 사용할 수 있지만, else 문은 반드시 if 문과 함께 사용해야 한다.

</aside>

다음 예제는 앞서 살펴본 순서도를 그대로 파이썬으로 구현해본 예제이다.

```python
con = "sweet"

if con == "sweet":
	print("삼키다")
else:
	print("뱉는다")
```


---

**if-elif-else문**

if-else 문만으로는 우리가 실제로 구현해야 하는 복잡한 조건들을 제대로 표현하는 것이 매우 힘들고 어렵다.
이러한 불편함을 해소하기 위해 파이썬에서는 if와 else 외에도 elif라는 키워드를 별도로 제공한다.
elif 키워드는 else if의 줄임말로 else문과 또 다른 if 문을 하나로 합쳐놓은 역할을 한다.

*문법*

```python
if 조건식1:
		조건식1의 결과가 참(True)일 때만 실행되는 명령문
elif 조건식2:
		조건식2의 결과가 참(True)일 때만 실행되는 명령문
else:
		조건식1, 2의 결과가 모두 거짓(False)일 때만 실행되는 명령문
```

elif문도 else문과 마찬가지로 반드시 if문과 함께 사용해야 한다.

앞서 살펴본 예제를 elif문을 사용하여 다시 구현하면 다음과 같다.

```python
season = "winter"

if season == "spring":
	print("봄!")
elif season == "summer":
	print("여름!")
elif season == "fall":
	print("가을")
elif season == "winter":
	print("겨울")
```

이처럼 elif문을 사용하면 코드가 훨씬 간결해지며 가독성 또한 높아진다.
이러한 elif문은 하나의 if 문내에서 개수에 상관없이 사용할 수 있다.

<aside>
💡 대부분의 프로그래밍 언어에서 제공하는 또 다른 조건문인 switch-case 문을 파이썬에서는 별도로 제공하지 않는다 파이썬에서는 switch-case 문 대신 elif 문을 사용하도록 권고한다.

</aside>

---

**pass 키워드로 아무일도 하지 않기**

조건문에서는 상황에 따라 어떠한 명령문도 수행하지 않고 그냥 넘어가야할 경우가 생길 수 있다.

다른 프로그래밍 언어에서는 이와 같은 경우 조건문 내부에 아무런 명령문도 명시하지 않으면 되지만, 파이썬에서는 조건문 내부에 명령문이 하나라도 존재하지 않으면 에러가 발생한다.

따라서 파이썬에서는 이런 경우 사용할 수 있도록 pass 라는 키워드를 별도로 제공하고 있다. 
pass 키워드는 다른 어떤 동작도 수행하지 않는다.

다음 예제는 온도가 26도 미만이면 아무런 동작도 수행하지 않지만, 26도 이상이면 특정 문자열을 
출력하는 예제이다.

```python
temp = 18

if temp < 26:
	pass
else:
	print("에어컨을 켠다.")
```

위의 예제에서 4번 라인의 pass 문을 삭제하면 IndentationError 에러가 발생한다.

*물론 위와 같은 예제는 다음과 같이 하나의 if 문을 사용해서 작성하는 것이 더 효과적이다.

```python
temp = 18

if temp > 26:
	print("에어컨을 켠다.")
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/Python-8e21d42170264100b830adca3965a15e
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_flow_if](http://www.tcpschool.com/python2018/python_flow_if)
