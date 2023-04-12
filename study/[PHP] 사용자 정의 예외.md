# [PHP] 사용자 정의 예외

**사용자 정의 예외(user defined exception)**

PHP에서 Exception 클래스의 인스턴스 뿐만 아니라 사용자가 직접 정의한 예외 객체를 던질 수도 
있다.
이러한 사용자 정의 예외 클래스는 Exception 클래스를 상속받아 만들 수 있다.

Exception 클래스를 상속받은 자식 클래스는 Exception 클래스의 모든 프로퍼티와 메소드에 
접근할 수 있다.
Exception 클래스의 모든 메소드는 _tostring() 메소드를 제외하고는 오버라이딩 할 수는 없다.
하지만 사용자 정의 예외 클래스에 사용자가 원하는 메소드를 추가할 수는 있다.

```php
class CustomException extends Exception       // Exception 클래스를 상속 받아 예외 정의
{
    public function errorMessage()
    {
        $msg = $this->getMessage()."<br/>".

            "예외가 발생한 파일 경로 : ".$this->getFile()."<br/>".

            "예외가 발생한 라인 번호 : ".$this->getLine();
        return $msg;
    }
}

try
{
    throw new CustomException("예외 메시지"); // 예외 객체 던짐.
}
catch(CustomException $ex)                    // 예외 처리
{
    echo $ex->errorMessage();
}
```

위의 예제는 try 블록에서 사용자가 직접 정의한 CustomException 객체를 던진다.
던져진 예외 객체는 catch 블록에서 CustomException 클래스의 errorMessage() 메소드를 사용하여 처리하고 있다.

---

**중첩 예외**

PHP에서 예외 처리는 중첩될 수 있다.
즉 try 블록 안에 또 다른 try 블록을 정의할 수 있으며 중첩 횟수에도 제한이 없다.
각 try 블록은 최소한 하나 이상의 catch 블록이나 finally 블록을 가져야만 한다.

```php
try
{
    try
    {
        throw new CustomException("예외 메시지"); // 예외 객체 던짐.
    }
    catch(CustomException $ex)                    // 예외 처리
    {
        throw $ex;                                // catch 블록에서 다시 예외 객체 던짐.
    }
}
catch(Exception $ex)                              // 예외 처리
{
    echo $ex->getMessage();
}
```

위의 예제처럼 catch 블록 안에서도 다시 예외를 던질 수 있다.
이렇게 내부 catch 블록에서 다시 던져진 예외는 외부 catch 블록에서 처리된다.
위의 예제에서 다시 던져진 예외는 CustomException 클래스의 errorMessage() 메소드가 아닌 Exception 클래스의 getMessage() 메소드에 의해 처리된다.

---

**다중 catch문**

하나의 try 블록은 여러 개의 catch 블록을 가질 수 있으며, 각각의 catch 블록이 다른 형태의 예외를 처리하도록 할 수 있다.
예외가 발생하면 여러 catch 블록 중에서 던져진 예외 객체를 매개변수로 가지는 가장 처음의 catch 블록이 실행된다.

```php
try
{
    throw new CustomException("예외 메시지"); // 예외 객체 던짐.
}
catch(customException $ex)                    // 던져진 예외는 이 곳에서 처리됨.
{
    echo $ex->errorMessage();
}
catch(Exception $ex)
{
    echo $ex->getMessage();
}
```

위의 예제처럼 Exception 클래스에 대한 catch 블록은 항상 맨 마지막에 위치해야 한다.
그렇지 않으면 해당 catch 블록이 발생하는 예외를 모두 처리할 것이다.
왜냐하면, PHP의 예외 객체는 모두 Exception 클래스에서 파생되기 때문이다.

위의 예제에서 던져진 customException 예외 객체는 첫 번째 catch 블록에서 처리된다.
만약 첫 번째 catch 블록과 두 번째 catch 블록의 순서를 바꾸면, 던져진 예외 객체는 Exception 
클래스의 getMessage() 메소드에 의해 처리될 것이다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-1b6f26a95d9e4e14aa5840ade0de26f7?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_exception_userDefined](http://www.tcpschool.com/php/php_exception_userDefined)
