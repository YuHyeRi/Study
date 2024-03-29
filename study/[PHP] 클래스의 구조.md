# [PHP] 클래스의 구조

**클래스의 구조**

PHP에서 클래스는 class 키워드를 사용하여 다음과 같이 선언한다.

```php
class 클래스명
{
	클래스의 프로퍼티와 메소드의 정의;
}
```

PHP에서 클래스명을 생성할 시 반드시 다음 규칙을 지켜야 한다.

1. 클래스의 이름은 숫자와의 구분을 빠르게 하려고 숫자로 시작할 수 없다.
2. 클래스의 이름은 영문자(대소문자), 숫자, 언더스코어(_)로만 구성된다.
3. 클래스의 이름 사이에는 공백이 포함될 수 없다.
4. 클래스의 이름은 대소문자를 구분한다.
5. PHP에서 미리 정의한 예약어는 클래스의 이름으로 사용할 수 없다.

클래스는 클래스만의 상수와 변수를 가질 수 있으며 이것을 프로퍼티라고 한다.
또한 메소드라고 불리는 연산을 정의할 수도 있다.

---

**생성자(constructor)**

클래스는 새로운 객체를 생성할 때마다 생성자라는 메서드를 호출한다.

생성자는 객체가 생성될 때마다 호출되어 해당 객체의 프로퍼티를 초기화하거나, 
필요한 다른 객체를 생성하는 등의 초기화 작업을 수행한다.
생성자는 다른 메서드와 같은 방식으로 선언되며, 매개변수를 가질 수도 있다.

PHP에서 생성자의 이름은 __construct()로 정해져 있다.
이러한 생성자는 객체가 생성될 때마다 자동으로 호출되므로, 사용자가 직접 호출할 필요가 없다.

```php
class 클래스이름
{
    function __construct(매개변수1, 매개변수2, ...)
    {
        생성자가 호출될 때 실행될 코드;
    }
}
```

---

**소멸자(destructor)**

소멸자는 생성자와는 반대로 해당 객체를 더는 사용하지 않아 삭제할 때 호출한다.
PHP에서 소멸자의 이름은__desturct()로 정해져 있으며, 매개변수를 가질 수 없다.

```php
class 클래스이름
{
    function __desturct()
    {
        소멸자가 호출될 때 실행될 코드;
    }
}
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-5448323c6d6546baa457fca8019044f5?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_class_structure](http://www.tcpschool.com/php/php_class_structure)
