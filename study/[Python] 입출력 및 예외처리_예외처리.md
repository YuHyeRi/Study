# [Python] 입출력 및 예외처리_예외처리

**예외 처리(exception handling)**

프로그래밍을 배우다보면 생각지도 못한 여러가지 오류가 발생하는 것을 경험할 수 있다.
이렇게 발생하는 오류는 크게 다음과 같이 두 가지로 구분할 수 있다.

1. 문법 오류 (syntax errors)
2. 예외 (exceptions)

문법 오류는 우리가 프로그래밍을 배우는 과정에서 가장 많이 경험하게 될 오류일 것이다.

*예제*

```python
while True
    print('안녕하세요!')
```

*실행결과*

```python
File "D:/test.py", line 1
    while True
             ^
SyntaxError: invalid syntax
```

위와 같이 문법 오류가 발생하면 파서는 오류가 발생한 라인과 함께 그 대략적인 위치까지도 ‘A’기호를 이용하여 알려준다.
위의 예제에서는 while 문의 가장 마지막에 콜론(:)을 빠뜨렸기 때문에 문법 오류가 발생했다.
이와 같은 문법 오류는 대부분 파서가 그 원인까지도 함께 알려주므로, 쉽게 수정할 수 있다.
그 다음으로 예외란 프로그램을 작성한 후 실행하는 도중에 오류가 발생하여 실행되고 있던 
프로그램이 중지되는 것을 가리킨다.

아무리 문법적인 오류가 나지 않도록 프로그램 코드를 작성했다고 하더라도 프로그램이 실행되는 도중 수많은 원인들에 의해 예외 상황이 발생할 수 있다.
예를 들어 다음 예제와 같이 어떤 숫자를 0으로 나누려고 한다면, 문법적으로는 맞겠지만 0으로 
나눈 것 때문에 ZeroDivisionError가 발생하여 예외가 발생할 것이다.

---

**try, except 문**

이렇게 발생한 예외 처리 상황을 처리할 수 있도록 프로그램의 흐름을 바꾸는 해위를 예외처리라고 부른다.
파이썬에서는 발생한 예외를 유연하게 처리할 수 있도록 try, except 문이라는 예외 처리 구문을 제공한다.

```python
try:
    예외가 발생할 가능성이 있는 코드
except [ 처리할 예외명 [ as 에러 메시지 변수 ]]:
    try 절에서 발생한 예외를 처리할 코드
[ else: ]
    try 절에서 예외가 발생하지 않았을 경우에만 실행될 코드
[ finally: ]
    try 절이 실행되고 나면 언제나 마지막에 실행될 코드
```

우선 try 블록으로 예외가 발생할 가능성이 있는 프로그램 코드를 감싼다.
만약 try 블록에서 예외가 발생하면, 프로그램은 발생한 예외와 일치하는 except 절을 순서대로 찾기 시작한다.

except 절은 여러 개를 동시에 사용할 수 있으며 except 절 뒤에 처리할 예외명을 생략하면 발생한 
예외의 종류에 상관없이 예외가 발생하면 무조건 해당 except 절이 실행된다.
또한 as 키워드를 사용하여 발생한 예외가 출력하는 에러 메시지를 변수에 따로 저장하여 사용할 수도 있다.

<aside>
💡 위와 같은 문법 설명에서 사용되는 대괄호 []는 해당 구문을 반드시 사용할 필요 없이 생략할 수도 있다는 의미이다.

</aside>

---

**try, except 문의 동작 순서**

파이썬에서 try, except 문은 다음과 같은 순서대로 동작하게 된다.

1. try 블록에 포함된 코드가 순서대로 실행된다.
2. 이 때 예외가 발생하지 않으면, except 절은 실행되지 않고 try, except 문은 그대로 종료된다.
3. 만약 try 블록을 실행하는 동안 예외가 발생했다면, 곧바로 발생한 예외명과 except 절에 명시한 예외명이 같은지를 순서대로 확인하게 된다.
    
    3-1. 만약 발생한 예외명과 명시된 예외명이 같다면, 해당 except 절이 실행되고 프로그램의 흐름은 try, except 문 다음으로 넘어간다.
    
    3-2. 만약 발생한 예외명과 명시된 예외명이 같지 않다면, 다음 except 절을 계속해서 확인한다.
    
    3-2-1. 만약 발생한 예외명과 명시된 예외명이 같은 except 절을 찾지 못했다면, 해당 try, except 문보다 더 바깥쪽에 위치한 try, except 문의 except 절들까지 확인하게 된다.
    
    3-2-2. 그래도 발생한 예외명과 명시된 예외명이 같은 except 절을 찾을 수 없었다면, 에러 
    메시지를 출력하고 프로그램은 강제 종료된다.
    

---

**else절과 finally절**

else 절은 try 블록에서 예외가 발생하지 않았을 경우에만 실행되며, 반드시 마지막 except 절 바로 
다음에 위치해야 한다.
파이썬에서 else절은 생략할 수 있다.

```python
try:
    pass
except IndexError:
    print("인덱스가 안맞아요!")
except ZeroDivisionError:
    print("0으로 나누면 안돼요!")
else:
    print("예외가 발생하지 않았어요!") 

print("프로그램이 정상적으로 종료됩니다!")
```

위의 예제에서는 try 블록에서 예외가 발생하지 않았기 때문에 else 절이 실행되며 10번 라인의 print() 함수까지 정상적으로 실행되는 것을 확인할 수 있다.
finally 절은 try 블록이 실행되고 나면 예외 발생 여부와 상관없이 언제나 실행되며, else 절과 
마찬가지로 생략할 수 있다.

```python
try:
    3 / 0
except IndexError:
    print("인덱스가 안맞아요!")
except ZeroDivisionError:
    print("0으로 나누면 안돼요!")
finally:
    print("예외에 상관없이 언제나 실행되요!")  

print("프로그램이 정상적으로 종료됩니다!")
```

위 예제의 try 블록에서는 ZeroDivisionError가 발생하므로 else 절은 실행되지 않겠지만, finally 절은 예외 발생 여부와 상관없이 실행되는 것을 확인할 수 있다.

---

**예외 발생시키기**

파이썬에서는 사용자가 raise 키워드를 사용하여 예외를 강제로 발생시킬 수 있다.
예를 들어, 부모 클래스를 상속받는 자식 클래스에서 부모 클래스의 어떤 메소드는 반드시 
구현하도록 만들고 싶다면, NotImplementedError를 사용하여 이를 강제할 수 있다.

```python
class Bird:
    def birdsong(self):
        raise NotImplementedError

class Chicken(Bird):
    pass

my_chicken = Chicken()
my_chicken.birdsong()
```

위의 예제를 실행하면 NotImplementedError가 발생하고 프로그램이 강제 종료된다.
이는 자식 클래스인 Chicken 클래스에서 부모 클래스의 birdsong() 메소드를 구현하지 않아서 
raise 키워드에 의해 NotImplementedError가 강제로 발생되었기 때문이다.

따라서 다음 예제처럼 부모 클래스의 birdsong() 메소드를 Chicken 클래스에서 오버라이딩해야만 NotImplementedError가 발생하지 않는 것을 확인할 수 있다.

```python
class Bird:
    def birdsong(self):
        raise NotImplementedError    

class Chicken(Bird):
    def birdsong(self):
        print("짹짹")    

my_chicken = Chicken()
my_chicken.birdsong()
```

<br><br>
👉 노션 : https://www.notion.so/tgmary09/Python-_-adcd903820e943efa64dbd9e1852e188
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_io_exception](http://www.tcpschool.com/python2018/python_io_exception)
