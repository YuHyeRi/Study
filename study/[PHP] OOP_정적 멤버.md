# [PHP] OOP_정적 멤버

**static 키워드**

클래스를 정의할 때 static 키워드를 사용한 프로퍼티와 메소드는 해당 클래스의 인스턴스를 
생성하지 않아도 접근할 수 있게 된다.
이러한 프로퍼티와 메소드를 정적 멤버(static member)라고 한다.

이러한 정적 멤버의 특징은 다음과 같다.

1. static 키워드로 선언된 정적 프로퍼티는 인스턴스화된 객체에서는 접근할 수 없다.
2. static 키워드로 선언된 정적 메소드는 인스턴스화된 객체에서도 접근할 수 있다.
3. 정적 메소드 내에서는 $this 의사 변수를 사용할 수 없다.

```php
class StaticMember
{
    public static $staticProperty = "static property";
    public static function showProperty()
    {
        echo self::$staticProperty;."<br>";
    }
}

echo StaticMember::showProperty();  // 호출 가능
echo StaticMember::$staticProperty; // 접근 가능

$var = new StaticMember();          // 인스턴스 생성
echo $var->showProperty();          // 호출 가능
//echo $var->$staticProperty;       // 접근 불가능
```

위의 예제에서 정적 메소드인 showProperty 메소드에서는 자신이 가리키는 $this 의사 변수를 
사용할 수 없다.
따라서 self 키워드와 함께 범위 지정 연산자를 사용하여 프로퍼티에 접근하고 있다.
또한 생성된 인스턴스에서는 정적 프로퍼티에 접근할 수 없음을 보여주고 있다.

---

**범위 지정 연산자(::)**

클래스의 프로퍼티나 메소드에 접근하기 위해서는 인스턴스르르 생성하고, 화살표 연산자(→)를 
사용해야 한다.
하지만 단순히 클래스의 정의 내에서 프로퍼티나 메소드를 사용하고 싶을 때는 범위 지정 연산자(::)를 사용할 수 있다.
범위 지정 연산자(::)는 클래스의 상수, 정적(static) 멤버 또는 재정의된 멤버에 접근할 수 있게 해준다.

클래스의 정의 외부에서 위와 같은 멤버에 접근할 때는 클래스의 이름을 사용해야 한다.

```php
echo OtherClassName::CONSTANT;
```

또한 다음 키워드를 사용하면 클래스의 정의 내에서 특정 프로퍼티나 메소드에 접근할 수 있다.

1. self : 자기 자신에 접근할 때
2. parent : 부모 클래스에 접근할 때

```php
echo self::$property;
echo parent::CONSTANT;
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-OOP_-13af67b8a95d43798cc4b4b924bed923?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_oop_static](http://www.tcpschool.com/php/php_oop_static)
