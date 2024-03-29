# [Python] 파이썬의 기초

**표준 입출력 함수**

대부분의 프로그램은 사용자의 입력을 받아 동작을 수행한 후 그 결과를 다시 사용자에게 출력하는 형태를 가지고 있다. 따라서 프로그램을 만들 때 입출력 작업은 매우 기본적인 동작이 되며, 
대부분의 프로그래밍 언어에서는 표준 입출력 함수라는 것을 통해 이러한 기능을 제공한다.

파이썬에서도 사용자에게 출력 내용을 보여주기 위한 표준 출력 함수로 print() 함수를 제공하며, 
사용자의 입력을 받기 위한 표준 입력 함수로 input() 함수를 제공하고 있다.

<aside>
💡 함수(function)란 하나의 특별한 목적의 작업을 수행하기 위해 독립적으로 설계된 프로그램 코드의 집합으로 정의할 수 있다. 함수를 사용하면 반복적인 프로그래밍을 피할 수 있으며, 모듈화로 인해 전체적인 코드의 가독성이 좋아진다.
더욱 자세한 사항은 파이썬 함수 단원에서 확인할 수 있다.

[⇒ 파이썬 함수 단원](http://www.tcpschool.com/python2018/python_function_function)

</aside>

---

**print 함수**

파이썬에서는 데이터를 화면에 출력하고 싶을 때 표준 출력 함수인 print 함수를 사용한다.
다음 예제는 다양한 타입의 데이터를 print 함수를 사용하여 출력하는 예제이다.

```python
print(38)
print("문자열")
print([1, 2, 3])
```


이와 같이 print() 함수는 숫자나 문자열뿐만 아니라 배열과 같은 데이터까지도 출력할 수 있다.

다음 예제는 여러 데이터를 print() 함수를 사용하여 한 번에 출력하는 예제이다.

```python
print(1+2)
print("파"+"이"+"썬")
print("파""이""썬")
print("파","이","썬")
```


파이썬에서는 1번과 2번 라인의 print() 함수처럼 더하기(+) 기호를 사용하여 여러 데이터를 한 번에 출력할 수 있다. 그리고 문자열에 한해 더하기 기호를 생략해도 같은 결과를 출력해 주며, 쉼표(,)를 사용하면 띄어쓰기(white space)를 하나씩 삽입하여 출력한다.

---

**input() 함수**

파이썬에서는 프로그램 실행 도중 사용자의 입력을 전달받아 그 값을 프로그램에서 사용하고 
싶을 때 input() 함수를 사용할 수 있다.

다음 예제는 사용자가 입력한 데이터를 곧바로 출력하는 예제이다.

```python
var = input()
print(var)
```

하지만 위의 예제와 같은 경우에는 사용자 입장에서 현재 프로그램이 자신의 입력을 받기 위해 정지해 있는 건지 아니면 다른 이유로 정지된 건지를 명확히 알 수 없다.

따라서 다음 예제와 같이 입력 안내 문자열을 input() 함수에 인수로 전달하여 사용자에게 입력에 
관한 정보나 입력을 해달라는 요청 메시지를 전달하는 것이 좋다.

```python
var = input("출력할 문자열을 입력해 주세요 : ")
print(var)
```

---

**주석(comments)**

주석(comments)이란 해당 프로그램 소스 코드를 이해하는데 도움을 주는 설명을 적거나 개발자가 디버깅을 위해 작성한 코드를 가리킨다. 이러한 주석은 파이썬 인터프리터에 의해 해석되지 않으므로 실행되지 않는다.

파이썬에서는 해시(#) 기호를 사용하여 주석을 작성할 수 있다.

```python
# 작성자 : tcpschool
# 수정날짜 : 2018.05.15

print(38)        # 숫자를 출력하는 코드
print("문자열")  # 문자열을 출력하는 코드
print([1, 2, 3]) # 배열을 출력하는 코드
```


위의 실행결과를 살펴보면 주석으로 처리된 문자열은 프로그램에 어떠한 영향도 미치지 않음을 
확인할 수 있다.

위 예제의 1~2번 라인의 주석처럼 여러 라인에 걸쳐 작성해야 하는 주석은 다음과 같이 세 개의 
큰따옴표(""")나 작은따옴표(''')를 사용하여 더욱 손쉽게 작성할 수 있다.

```python
"""
작성자 : tcpschool
수정날짜 : 2018.05.15
"""

print(38)        # 숫자를 출력하는 코드
print("문자열")  # 문자열을 출력하는 코드
print([1, 2, 3]) # 배열을 출력하는 코드
```


<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/Python-c0127f68b3504b9b8e6f2df0e3b23f0e
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_intro_basic](http://www.tcpschool.com/python2018/python_intro_basic)
