# [Java] ****Generic Programming****

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7ba92770-391d-4862-9ed9-b0b7c9a89fdf/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220629%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220629T013955Z&X-Amz-Expires=86400&X-Amz-Signature=bf96af1cbb3fd9b53dc8f4246c70e3a7e02237fbc7306511c2db205cf0e6e8ef&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

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


💡 ***제네릭 프로그래밍***은 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있는 기술에 중점을 두어 재사용성을 높일 수 있는 프로그래밍 방식이다.

---

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
    
    ---
    
    ### ***Generic class를 사용하지 않는 경우***
    
    *Powder.java*
    
    ```java
    package ch06;
    
    public class Powder {
    	public String toString() {
    		return  "재료는 powder입니다. ";
    	}
    }
    ```
    
    *ThreeDPrinter1.java*
    
    ```java
    package ch06;
    
    public class ThreeDPrinter1 {
    	private Powder material;
    
    	public Powder getMaterial() {
    		return material;
    	}
    
    	public void setMaterial(Powder material) {
    		this.material = material;
    	}
    	
    	public String toString() {
    		return "재료는 Powderrf 입니다.";
    	}
    }
    ```
    
    위의 Powder class와 비슷한 다른 객체를 생성하는 경우 TheeDPrinter 코드도 해당 class가 
    생성됨에 따라 따로 만들어져야 한다. 또는 아래 코드와 같이 Object를 사용할 수도 있다. 
    그러나 Object의 경우 인스턴스를 생성하고 사용할 때 형변환을 해주어야 하는 번거로움이 있다.
    
    *ThreeDPrinter3.java*
    
    ```java
    package ch06;
    
    public class ThreeDPrinter3 {
    	private Object material;
    
    	public Object getMaterial() {
    		return material;
    	}
    
    	public void setMaterial(Object material) {
    		this.material = material;
    	}
    	
    	public String toString() {
    		return "재료는 Powderrf 입니다.";
    	}
    }
    ```
    
    *ThreeDPrinterTest.java*
    
    ```java
    package ch06;
    
    public class ThreeDPrinterTest {
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		
    		Powder powder = new Powder();
    		ThreeDPrinter3 printer = new ThreeDPrinter3();
    		
    		printer.setMaterial(powder);
    		Powder p = (Powder)printer.getMaterial();
    		// ThreeDPrinter3의 경우는 Object type을 이용하여 material을 만들었는데
    		// 이럴 경우 형 변환을 해줘야해서 번거로움이 발생한다.
    		// 그래서 generic programming이 생겨났다.
    		
    	}
    }
    ```
    
    ---
    
    ### ***Generic class를 사용한 코드***
    
    *GenericPrinter.java*
    
    ```java
    package ch06;
    
    public class GenericPrinter<T> {
    	// T는 자료형 매개변수로 이 클래스를 사용하는 시점에 실제 사용할 자료형을 지정하며 static 변수는 사용할 수 없다
    	
    	private T material;
    	// 나중에 사용할 때 사용할 자료형을 입력하면 해당 자료형으로 생성된다.
    
    	public T getMaterial() {
    		return material;
    	}
    
    	public void setMaterial(T material) {
    		this.material = material;
    	}
    	
    	public String toString() {
    		return material.toString();
    	}
    }
    ```
    
    *GenericPrinterTest.java*
    
    ```java
    package ch06;
    
    public class ThreeDPrinterTest {
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		
    		Powder powder = new Powder();
    		ThreeDPrinter3 printer = new ThreeDPrinter3();
    		
    		printer.setMaterial(powder);
    		Powder p = (Powder)printer.getMaterial();
    		// ThreeDPrinter3의 경우는 Object type을 이용하여 material을 만들었는데
    		// 이럴 경우 형 변환을 해줘야해서 번거로움이 발생한다.
    		// 그래서 generic programming이 생겨났다.
    		
    	}
    
    }
    ```
    
    ※ 그 외 코드는 위와 중복되어 생략

---

### ***T 자료형의 범위 제한***

- <T extends 클래스>를 사용하면 T 자료형의 범위를 제한할 수 있다.
- Generic class에 상위 클래스 상속을 할 경우 T에는 상속을 받은 class(자료형)으로만 생성이 가능하다.
- 상속을 받지 않은 경우 T는 object로 변환되어 object 클래스가 기본으로 제공하는 메서드만 사용 가능하다.
- extends를 사용함으로써 사용할 수 있는 class에 대해 제한을 걸어두고 공통으로 사용하는 메서드들을 지정해 줄 수도 있다.

*Material.java*

```java
package ch07;

//Generic class의 제한을 걸기 위한 class로 해당 class는 직접 쓸 일이 없기에 abstract로 생성하였다.
public abstract class Material {
			public abstract void doPrinting();
}
```

*Plastic.java*

```java
package ch07;

public class Plastic extends Material {
	public String toString() {
		return  "재료는 plastic 입니다. ";
	}

	@Override
	public void doPrinting() {
		// TODO Auto-generated method stub
		
	}	
}
```

*GenericPrinter.java*

```java
package ch07;

public class GenericPrinter<T extends Material> {
	// extends Material을 하여 T에 대한 제한을 하였다.
	// Material을 상속받은 Class(자료형)으로만 생성 가능하다!!
	
	private T material;
	// 나중에 사용할 때 사용할 자료형을 입력하면 해당 자료형으로 생성된다.

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	public String toString() {
		return material.toString();
	}
}
```

※ 그 외 코드는 위와 중복되어 생략
    
   <br>
    
👉 notion : https://www.notion.so/Java-Generic-Programming-487bdcfbce2c421d954e387453fdb3e6
    <br>
👉 Reference : [https://velog.io/@seongwon97/Java-Generic-Programming-제너릭-프로그래밍](https://velog.io/@seongwon97/Java-Generic-Programming-%EC%A0%9C%EB%84%88%EB%A6%AD-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)
