# [Python] 클래스의 활용

**초기화 메소드(initialze method)**

```python
class Dog:
    def setInfo(self, name):
        self.name = name
    def bark(self):
        print(self.name + "가 멍멍하고 짖는다.")

my_dog = Dog()
my_dog.bark()
```

위의 예제를 실행해보면 AttributeError가 발생하며 name 이라는 이름의 변수가 없다는 에러 메시지를 출력하는 것을 확인할 수 있다. 왜냐하면 Dog 인스턴스가 생성되고 나서 bark 메소드를 호출하기 먼저 set_info 메소드가 호출되어 name 이라는 변수를 먼저 선언해야만 제대로 동작하는 구조이기 때문이다.

파이썬에서는 이와 같은 경우를 미리 방지하기 위해 인스턴스가 생성될 때 자동으로 호출되어 변수를 초기화해주는 특별한 메소드를 미리 만들어 제공하고 있으며, 이 메소드가 바로 초기화 메소드
이다. 파이썬에서 초기화 메소드의 이름은 __init__으로 고정되어 있다.

__init__메소드는 인스턴스가 생성되는 시점에서 자동으로 호출됨으로 위의 예제를 다음과 같이 변경하면 메소드 호출의 순서에 상관없이 정상적으로 동작함을 확인할 수 있다.

```python
class Dog: # 클래스 선언
    def __init__(self, name):
        self.name = name  
    def bark(self):
        print(self.name + "가 멍멍하고 짖는다.")    

my_dog = Dog("삼식이") # 인스턴스 생성
my_dog.bark() # 인스턴스의 메소드 호출
```

위 예제의 9번 라인처럼 초기화 메소드를 사용하여 속성을 자동으로 초기화하면 10번 라인에서 
곧바로 bark 메소드를 호출하여도 오류가 발생하지 않는다.

---

**클래스 변수와 인스턴스 변수**

클래스에서도 변수가 선언된 위치에 따라 변수의 유효 범위가 달라지며, 
이에 따라 다음과 같이 구분할 수 있다.

1. 클래스 변수(class variable)
2. 인스턴스 변수(instance variable)

클래스 변수는 해당 클래스에서 생성된 모든 인스턴스가 값을 공유하는 변수이다.

그러나 인스턴스 변수는 init 메소드 내에서 선언된 변수로 인스턴스가 생성될 때마다 새로운 값이 
할당되는 변수이다.

```python
class Dog: # 클래스 선언
    sound = "멍멍" # 클래스 변수 선언  

    def __init__(self, name):
        self.name = name # 인스턴스 변수 선언  

    def bark(self):
        print(self.name + "가 멍멍하고 짖는다.")    

my_dog = Dog("삼식이") # 인스턴스 생성
your_dog = Dog("콩이") # 인스턴스 생성  

print(my_dog.sound) # 클래스 변수에 접근
print(my_dog.name) # 인스턴스 변수에 접근  
print(your_dog.sound) # 클래스 변수에 접근
print(your_dog.name) # 인스턴스 변수에 접근
```

위 예제에서는 Dog 클래스에 sound라는 이름의 클래스 변수를 선언하고, 초기화 메소드를 통해서는 name 이라는 이름의 인스턴스 변수를 선언하고 있다.
14번과 17번 라인의 실행결과처럼 하나의 클래스에서 생성된 서로 다른 인스턴스에서도 클래스 
변수의 값은 공유됨을 확인할 수 있다.
또한 15번과 18번 라인에서는 인스턴스 변수의 값은 인스턴스마다 서로 다름을 확인할 수 있다.
이처럼 인스턴스 간에 값을 서로 공유하지 않아도 되는 변수는 인스턴스 변수로 선언하고, 같은 값을 공유해야만 하는 변수는 클래스 변수로 선언하는 것이 바람직하다.

<aside>
💡 만약 어떤 변수를 클래스 변수로 선언해야 할지 아니면 인스턴스 변수로 선언해야 할지 잘 모르겠다면, 프로그램의 안정성을 위해 무조건 인스턴스 변수로 선언하는 것이 좋다. 이렇게 하면 코드가 중복될 가능성은 생기겠지만 프로그램이 의도치 않게 동작할 가능성은 줄어들기 때문이다.

</aside>
<br><br>
👉 노션 : https://www.notion.so/tgmary09/Python-fb7ffb1292a341c186a77b03b9638882
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_class_use](http://www.tcpschool.com/python2018/python_class_use)
