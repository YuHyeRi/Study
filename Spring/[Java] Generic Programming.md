# [Java] ****Generic Programming****

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7ba92770-391d-4862-9ed9-b0b7c9a89fdf/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220628%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220628T004950Z&X-Amz-Expires=86400&X-Amz-Signature=c82c39cacfce0f234065bd8858e0d9e57f7acc0a18d9dbacf972dbac514be191&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

### ***Generic class / Programming***

- 프로그래밍을 하다보면 여러 자료형이 쓰일 수 있는 변수가 존재할 경우 이 변수를 기반으로 
클래스를 만들어야 할 것이다. 이런 경우 비슷한 코드를 자료형에 따라 여러개의 클래스를 
만들게 된다면 overhead가 발생한다.
- 우리는 이러한 상황이 발생하는 경우 여러 자료형을 담을 수 있는 Generic class를 사용하며 
프로그래밍을 해야 한다.
- Generic class는 자료형을 특정하지 않고 추후 해당 클래스를 사용할 때 지정할 수 있도록 선언
하는 방법이다.
- 이러한 Generic class을 사용하여 다양한 자료형이 적용될 수 있는 class나 method를 만드는 것을 Generic Programming이라고 한다.
- Generic class는 Java 5.0부터 제공 되었다.
- Collection Framework에서 많이 사용되고 있다.

즉, 자료형을 특정하지 않아 사용할 때 원하는 자료형을 선언하여 사용하게 해주는 변수를 Generic class라고 하며 해당 변수를 사용하는 프로그래밍을 Generic Programming이라고 한다.
<br>

<aside>
💡 제네릭 프로그래밍은 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있는 기술에 중점을 두어 재사용성을 높일 수 있는 프로그래밍 방식이다.
</aside>
<br><br>

### ***Generic class 사용법***

- **Generic class 생성**
    - Generic class를 사용할 경우 아래의 코드와 같이 class명 옆에 <T>를 쓴다.
    
    ```java
    public class GenericPrinter<T>
    ```
    
- **Generic variable**
    - T는 자료형 매개변수로 이 클래스를 사용하는 시점에 실제 사용할 자료형으로 지정하여 
    사용한다.
    - static 변수는 사용할 수 없다.
    
    ```java
    private T material;
    ```
    
- **Generic method**
    - 하나 이상의 자료형 매개변수를 입력받고 반환하는 메서드이다.
    - 아래의 코드와 같이 return 값이 있는 메서드이면 자료형 위치에 T를 적어두며, 파라미터를 받아야 하는 경우도 해당 위치에 T를 적어둔다.
    
    ```java
    public T getMaterial() {
    			return material;
    }
    
    public void setMaterial(T material) {
    			this.material = material;
    }
    ```
    <br><br>
    
    👉 notion : https://www.notion.so/Java-Generic-Programming-487bdcfbce2c421d954e387453fdb3e6
    <br>
    👉 Reference : [https://velog.io/@seongwon97/Java-Generic-Programming-제너릭-프로그래밍](https://velog.io/@seongwon97/Java-Generic-Programming-%EC%A0%9C%EB%84%88%EB%A6%AD-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)
