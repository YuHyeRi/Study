# [Python] 클래스와 객체

**클래스(class)**

우리는 앞서 함수란 하나의 특정 작업을 수행하기 위해 독립적으로 설계된 프로그램 코드라고 
배웠다. 이 때 함수의 호출은 특정 작업만을 수행할 뿐 그 결과값을 계속 사용하기 위해서는 반드시 어딘가에 따로 저장해야만 한다. 즉, 함수를 포함한 프로그램 코드의 일부를 재사용하기 위해서는 
해당 함수 뿐만 아니라 데이터가 저장되는 변수까지도 한꺼번에 관리하는 것이 편할 것이다.

이처럼 함수 뿐만 아니라 관련된 변수까지도 한꺼번에 묶어서 관리하고 재사용할 수 있게 해주는 것이 바로 클래스(class)이다.

---

**객체(object)**

클래스와 객체는 우리가 거리에서 흔히 볼 수 있는 붕어빵으로 간단히 비유하여 이해할 수 있다.

붕어빵을 계속해서 찍어낼 수 있는 틀을 클래스라고 한다면, 이러한 붕어빵 틀에서 찍혀 나온 맛있는 붕어빵 하나하나를 객체라고 이해할 수 있다. 즉, 하나의 클래스로부터 무수히 많은 객체를 생성할 수 있다. 이와 같은 객체를 사용하여 데이터를 표현하는 프로그래밍 기법을 객체 지향 프로그래밍(Object-Oriented Programming, OOP)이라고 한다.

<aside>
💡 파이썬에서는 굳이 클래스와 객체를 사용하지 않더라도 충분히 모든 문제를 해결할 수 있다. 그러나 클래스와 객체를 사용하면 많은 문제들을 더욱 손쉽게 해결할 수 있다.

</aside>

---

**속성(attribute)과 메소드(method)**

클래스는 여러 함수와 변수들을 한 번에 묶어서 관리하기 위해 사용한다고 했다. 
이 때 클래스에 포함되는 변수를 속성이라고 부르며, 클래스에 포함되는 함수를 메소드라고 부른다.

예를 들어, 은행 업무를 클래스로 작성한다면 속성으로는 계좌번호, 소유주, 잔액, 이자율 등이 있을 수 있으며, 메소드로는 입금하기, 출금하기 등을 만들 수 있을 것이다.

이처럼 우리가 실생활에서 접할 수 있는 무언가를 속성과 메소드로 분리하여 분석해보는 연습을 
자주한다면 이후에 클래스를 디자인하는데 훨씬 많은 도움이 될 것이다.

<aside>
💡 클래스의 속성과 메소드를 한꺼번에 클래스 멤버(class member)라고도 부른다.

</aside>

---

**클래스 선언하기**

파이썬에서는 class 키워드를 사용하여 클래스를 선언할 수 있으며, 
그 내부에서 def 키워드를 사용하여 메소드를 선언할 수 있다.

속성은 변수를 선언하는 일반적인 방법과 같은 방법으로 선언할 수 있다.

```python
class Dog;
	name = "삼식이"
	age = 3
	breed = "골든리트리버"

def bark(self):
	print(self.name + "가 멍멍하고 짖는다.")
```

위의 예제에서 작성한 Dog 클래스는 name, age, breed라는 3개의 속성과 bark라는 하나의 메소드로 구성된다.
6번 라인의 bark 메소드 선언 시 매개변수로 사용된 self 매개변수는 자바의 this 키워드와 마찬가지로 객체가 자기 자신을 참조하는데 사용하는 매개변수이다.
즉, self 매개변수를 사용하면, 메소드에서 클래스에 정의된 모든 속성 및 다른 메소드에 접근할 수 
있는 것이다.
예를 들어 7번 라인에서 self 매개변수를 사용하여 해당 클래스의 name 속성에 접근하고 있는 것을 확인할 수 있다.
파이썬에서는 메소드를 선언할 때 첫 번째 매개변수로 반드시 self를 명시하도록 하고 있으며,
메소드를 호출할 때는 self 매개변수에 아무런 인수를 전달하지 않아도 된다.

---

**인스턴스 생성하기**

인스턴스(instance)란 클래스를 기반으로 생성된 객체를 가리킨다.

파이썬에서는 클래스명에 소괄호 ()를 사용하여 해당 클래스의 인스턴스를 생성할 수 있다.
생성된 인스턴스에 닷(.) 연산자를 사용하면 해당 클래스의 속성이나 메소드를 호출할 수 있다.

```python
인스턴스명 = 클래스명()
```

다음 예제는 앞서 선언한 Dog 클래스의 인스턴스를 생성하는 예제이다.

```python
class Dog: # 클래스 선언
    name = "삼식이"
    age = 3
    breed = "골든 리트리버"  

    def bark(self):
        print(self.name + "가 멍멍하고 짖는다.")    

my_dog = Dog()      # 인스턴스 생성  
print(my_dog.breed) # 인스턴스의 속성 접근
my_dog.bark()       # 인스턴스의 메소드 호출
```

위 예제의 10번 라인에서는 my_dog라는 이름을 가지는 Dog 클래스의 인스턴스를 생성하고 있다. my_dog는 객체이면서 동시에 Dog 클래스의 인스턴스가 된다.

13번 라인처럼 생성된 인스턴스를 가지고 해당 클래스의 메소드를 호출할 수 있다. 
이 때 메소드 선언에서 사용된 self 매개변수에는 어떠한 인수도 전달하지 않는 것을 확인할 수 있다.

<aside>
💡 객체와 인스턴스는 전혀 별개의 것이 아니며 객체를 바라보면 관점의 차이이다. 위의 예제에서 ‘my_dog는 인스턴스이다.’라고 하기 보다는 ‘my_dog는 객체이다.’라고 말하는 것이 좀 더 정확하며, ‘my_dog는 Dog 클래스의 객체이다.’라고 하기 보다는 ‘my_dog는 Dog 클래스의 인스턴스이다.’라고 말하는 것이 좀 더 정확한 표현이다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/Python-b5fa9c707cba4da8aa3e1a7d1992315a
<br>
 👉🏻출처 : [http://www.tcpschool.com/python2018/python_class_object](http://www.tcpschool.com/python2018/python_class_object)
