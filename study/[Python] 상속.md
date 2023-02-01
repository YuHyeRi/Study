# [Python] 상속

**상속(inheritance)**

예를 들어 까치와 참새는 ‘조류’라는 특징을 가지고 있다.
즉 까치와 참새는 모두 서로 다른 ‘종’ 이지만 하늘을 날 수 있는 ‘조류’라는 공통점을 가지고 있는 것이다. 이러한 개념을 클래스에 적용시켜 보면, 까치와 참새 클래스는 모두 ‘조류’ 클래스의 특징을 
‘상속받았다’ 라고 할 수 있다.
이것이 바로 객체 지향 프로그래밍의 대표적인 개념 중 하나인 상속의 개념이며, 이를 이용하면 이미 존재하는 클래스의 모든 특징을 물려받는 새로운 클래스를 손쉽게 생성할 수 있다.

이러한 상속은 기존 클래스를 직접 수정하지 않고, 기능을 추가하거나 변경하고 싶을 때 유용하게 
사용할 수 있다.
이 때 이미 존재하던 클래스를 부모 클래스 또는 기초 클래스라고 부르며, 상속을 통해 새롭게 생성되는 클래스를 자식 클래스 또는 파생 클래스라고 부른다.

---

**클래스 상속하기**

파이썬에서 클래스를 선언할 때 다른 클래스를 상속받고 싶다면, 소괄호 () 를 사용하여 그 안에 상속받고 싶은 클래스명을 넣어 전달함으로써 해당 클래스의 모든 멤버를 상속받을 수 있다.

```python
class 자식클래스명(부모클래스명):
```

```python
class Bird:
    def __init__(self):
        self.flying = True  

    def birdsong(self):
        print("새소리")    

class Sparrow(Bird):
    def birdsong(self):
        print("짹짹")    

my_pet = Sparrow()  
print(my_pet.flying)
my_pet.birdsong()
```

위 예제의 9번 라인에서는 sparrow 클래스가 Bird 클래스를 상속받아 선언되었으며 14번 라인에서는 Sparrow 클래스의 my_pet 인스턴스를 생성하고 있다.
이 때 Sparrow 클래스는 Bird 클래스를 상속받았기 때문에, Sparrow 클래스에서는 선언하지 
않았지만 부모 클래스인 Bird 클래스에는 존재하는 flying 속성을 16번 라인처럼 자유롭게 사용할 수 있는 것이다.

---

**메소드 오버라이딩**

앞선 예제의 10번 라인에서 Sparrow 클래스는 부모 클래스인 Bird 클래스에서 선언한 birdsong 
메소드와 같은 이름의 메소드를 또 다시 선언하고 있다. 이처럼 상속 관계에 잇는 부모 클래스에서 이미 정의된 메소드를 자식 크래스에서 같은 이름으로 재정의하는 것을 메소드 오버라이딩이라고 한다.
자식 클래스에서는 상속받은 부모 클래스의 메소드를 그대로 사용해도 되고, 추가하거나 변경해야 할 사항이 생기면 메소드 오버라이딩을 통해 메소드를 재정의하여 사용할 수도 있는 것이다.

```python
class Bird:
    def __init__(self):
        self.flying = True  

    def birdsong(self):
        print("새소리")    

class Sparrow(Bird):
    def birdsong(self):
        print("짹짹")    

class Chicken(Bird):
    def __init__(self):
        self.flying = False    

my_sparrow = Sparrow()
my_chicken = Chicken()  
my_sparrow.birdsong()
my_chicken.birdsong()
```

위 예제에서 Sparrow 클래스와 Chicken 클래스는 모두 Bird 클래스를 상속받는다.
그러나 Sparrow 클래스는 birdsong 메소드를 재정의하고 Chicken 클래스는 birdsong 메소드를 
재정의하지 않는다.
따라서 23번 라인에서 Chicken 클래스의 인스턴스는 부모 클래스인 Bird 클래스의 birdsong 메소드를 그대로 사용하는 것을 확인할 수 있다.

---

**접근 제어(access control)**

자바나 C++과 같은 대부분의 객체 지향 프로그래밍 언어에서는 사용자가 굳이 알 필요가 없는 
정보는 되도록 사용자로부터 숨겨야한다는 정보은닉의 원칙에 따라 접근 제어자라는 것을 사용한다.
접근 제어자를 사용하면 클래스 외부에서의 직접적인 접근을 허용하지 않는 속성이나 메소드를 
선언할 수 있기 때문에 정보 은닉과 캡슐화를 구체화할 수 있다.

다음은 C++ 언어에서 사용할 수 있는 접근제어자와 그 설명이다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c1526596-fbb6-4a06-b6d7-3eea002952bc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230201T054049Z&X-Amz-Expires=86400&X-Amz-Signature=26dcee516bc824dc03e0fea0fb92ed791a755e8ce174fadb7a1976cb3ac1ce15&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

그러나 파이썬에서는 일한 접근 제어자를 사용하지 않고도, 변수나 메소드의 이름을 작성할 때 
그 작명법에 따라 접근 제어를 구현하고 있다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/20285291-0434-44c4-8587-8f14257bb2c0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230201T054103Z&X-Amz-Expires=86400&X-Amz-Signature=ba6abe8f7a69dc5670f02ee774e324736c95ca50d9d69cd51a6b29036f174925&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/Python-fa32bc8dbe32457ab8076bac8d795414
<br>
👉🏻 출처 : [http://www.tcpschool.com/python2018/python_class_inheritance](http://www.tcpschool.com/python2018/python_class_inheritance)
